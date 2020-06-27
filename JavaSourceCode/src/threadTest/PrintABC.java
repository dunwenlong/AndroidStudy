package threadTest;

/**
 * @author Dun Wenlong
 * @time 2020/6/24 16:26
 */
public class PrintABC {
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrint printA = new ThreadPrint("A", c, a);
        ThreadPrint printB = new ThreadPrint("B", a, b);
        ThreadPrint printC = new ThreadPrint("C", b, c);
        new Thread(printA).start();
        Thread.sleep(100);
        new Thread(printB).start();
        Thread.sleep(100);
        new Thread(printC).start();
        Thread.sleep(100);
    }
}
class ThreadPrint implements Runnable{
    private String name = null;
    private Object prev = null;
    private Object self = null;
    public ThreadPrint(String name, Object prev, Object self){
        this.name = name;
        this.prev = prev;
        this.self = self;
    }
    @Override
    public void run() {
        int count = 10;
        while(count>0){
            //先获取pre锁
            synchronized(prev){
                //再获取self锁
                synchronized(self){
                    System.out.println(name);
                    count--;
                    //唤醒其他线程竞争self锁，注意此时self锁并未立即释放
                    self.notify();
                }
                try{
                    if(count==0){
                        prev.notifyAll();
                    } else{
                        //释放prev锁
                        prev.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
