import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

/**
 * @author Dun Wenlong
 * @time 2020/6/27 15:19
 */
public class Transaction {
    /** this is also the hash of the transaction. */
    public String transactionId;
    /** senders address/public key. */
    public PublicKey sender;
    /** Recipients address/public key. */
    public PublicKey recipient;
    public float value;
    /** this is to prevent anybody else from spending funds in our wallet. */
    public byte[] signature;

    public ArrayList<TransactionInput> inputs;
    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
    /**A rough count of how many transactions have been generated*/
    private static int sequence = 0;
    /** Constructor: */

    public Transaction(PublicKey from, PublicKey to, float value,  ArrayList<TransactionInput> inputs) {
        this.sender = from;
        this.recipient = to;
        this.value = value;
        this.inputs = inputs;
    }

    public boolean processTransaction() {

        if(verifySignature() == false) {
            System.out.println("#Transaction Signature failed to verify");
            return false;
        }

        //Gathers transaction inputs (Making sure they are unspent):
        for(TransactionInput i : inputs) {
            i.UTXO = BlockChain.UTXOs.get(i.transactionOutputId);
        }

        //Checks if transaction is valid:
        if(getInputsValue() < BlockChain.minimumTransaction) {
            System.out.println("Transaction Inputs to small: " + getInputsValue());
            return false;
        }

        //Generate transaction outputs:
        float leftOver = getInputsValue() - value; //get value of inputs then the left over change:
        transactionId = calulateHash();
        outputs.add(new TransactionOutput( this.recipient, value,transactionId)); //send value to recipient
        outputs.add(new TransactionOutput( this.sender, leftOver,transactionId)); //send the left over 'change' back to sender

        //Add outputs to Unspent list
        for(TransactionOutput o : outputs) {
            BlockChain.UTXOs.put(o.id , o);
        }

        //Remove transaction inputs from UTXO lists as spent:
        for(TransactionInput i : inputs) {
            if(i.UTXO == null) {
                continue; //if Transaction can't be found skip it
            }
            BlockChain.UTXOs.remove(i.UTXO.id);
        }

        return true;
    }

    public float getInputsValue() {
        float total = 0;
        for(TransactionInput i : inputs) {
            if(i.UTXO == null) {
                continue; //if Transaction can't be found skip it, This behavior may not be optimal.
            }
            total += i.UTXO.value;
        }
        return total;
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recipient) + Float.toString(value)	;
        signature = StringUtil.applyECDSASig(privateKey,data);
    }

    public boolean verifySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recipient) + Float.toString(value)	;
        return StringUtil.verifyECDSASig(sender, data, signature);
    }

    public float getOutputsValue() {
        float total = 0;
        for(TransactionOutput o : outputs) {
            total += o.value;
        }
        return total;
    }

    private String calulateHash() {
        sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
        return StringUtil.applySha256(
                StringUtil.getStringFromKey(sender) +
                        StringUtil.getStringFromKey(recipient) +
                        Float.toString(value) + sequence
        );
    }
}
