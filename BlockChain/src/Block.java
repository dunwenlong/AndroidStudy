import java.util.ArrayList;

/**
 * @author Dun Wenlong
 * @time 2020/6/27 10:58
 */
public class Block {
    public String hash = "";
    public String previousHash = "";
    private String data = "";
    /**
     * our data will be a simple message.
     */
    private long timeStamp = 0L;
    /**
     * as number of milliseconds since 1/1/1970.
     */
    private int nonce = 0;
    private static final int DIFFICULTY = 5;
    public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    //our data will be a simple message.

    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        this.hash = mineBlock(DIFFICULTY);
    }

    public String calculateHash() {
        String calculateHash = StringUtil.applySha256(previousHash
                + Long.toString(timeStamp)
                + Integer.toString(nonce)
                + data);
        return calculateHash;
    }

    public String mineBlock(int difficulty) {
        System.out.println("Trying to Mine block... ");
        String target = new String(new char[difficulty]).replace('\0', '0');
        //Create a string with difficulty * "0"
        hash = calculateHash();
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
        return hash;
    }

    /** Add transactions to this block */
    public boolean addTransaction(Transaction transaction) {
        //process transaction and check if valid, unless block is genesis block then ignore.
        if (transaction == null) {
            return false;
        }
        if ((previousHash != "0")) {
            if ((transaction.processTransaction() != true)) {
                System.out.println("Transaction failed to process. Discarded.");
                return false;
            }
        }

        transactions.add(transaction);
        System.out.println("Transaction Successfully added to Block");
        return true;
    }
}
