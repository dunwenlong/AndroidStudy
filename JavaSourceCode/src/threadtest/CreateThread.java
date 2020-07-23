package threadtest;

/**
 * @author Dun Wenlong
 * @time 2020/6/24 15:44
 */
class MyThread extends Thread{
    private String name = null;
    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " : "+ "My Thread extends Thread");
    }
}
public class CreateThread {

    class MyThreadRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("My ThreadRunnable extends Runnable");
        }
    }

    public static void main(String[] args){
//        Thread MyThread = new Thread(new Runnable(){
//
//            @Override
//            public void run() {
//                System.out.println("Inner Class");
//            }
//        });
//        MyThread.start();
        MyThread myThread = new MyThread("A");
        myThread.start();
    }
}
