package com.ashu.utils.puzz;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mishra.ashish@icloud.com
 */
public class EfficientLockingExample {

    public static void main(String[] args) {

        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread runner1 = new Thread(new Runner(lock1, lock2));
        Thread runner2 = new Thread(new Runner(lock2, lock1));

        System.out.println("started " );
        runner1.start();
        runner2.start();

    }


    static class Runner implements Runnable {

        ReentrantLock lockA = null;
        ReentrantLock lockB = null;

        public Runner (ReentrantLock lock1, ReentrantLock lock2) {
            this.lockA = lock1;
            this.lockB = lock2;
        }

        public void run() {

            System.out.println("acquiring lock on " + lockA.toString());
            try {
              lockA.lockInterruptibly();
              System.out.println("obtained lock on " + lockA.toString());


            } catch(InterruptedException iex) {
                lockA.unlock();

            } finally {
                lockA.unlock();
                System.out.println("released lock on " + lockA.toString());
            }
            try {
                System.out.printf("trying lock on lock " + lockB);
                lockB.lockInterruptibly();
                System.out.println("obtained lock on " + lockB.toString());

            } catch (InterruptedException e) {
                lockB.unlock();

            } finally {
                lockB.unlock();
                System.out.println("released lock on " + lockB.toString());
            }
        }
    }
}
