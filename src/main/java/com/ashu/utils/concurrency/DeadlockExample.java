package com.ashu.utils.concurrency;

/**
 * Created by mishra.ashish@icloud.com
 */
public class DeadlockExample {


    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread runner1 = new Thread(new Runner(lock1, lock2));
        Thread runner2 = new Thread(new Runner(lock2, lock1));

        runner1.start();
        runner2.start();

    }


    static class Runner implements Runnable {

        Object lockA = null;
        Object lockB = null;

        public Runner (Object lock1, Object lock2) {
            this.lockA = lock1;
            this.lockB = lock2;
        }

        public void run() {

            System.out.println("acquiring lock on " + lockA.toString());

            synchronized (lockA) {
                System.out.println("Obtained lock on " + lockA.toString());
                synchronized (lockB) {
                    System.out.println("Obtained lock on " + lockB.toString());
                }
                System.out.println("released lock on " + lockB.toString());
            }
            System.out.println("released lock on " + lockA.toString());
        }
    }
}
