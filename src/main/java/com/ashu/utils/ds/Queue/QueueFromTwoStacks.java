package com.ashu.utils.ds.Queue;

import com.ashu.utils.ds.Stack.MyStack;

/**
 * Created by mishra.ashish@icloud.com
 */
public class QueueFromTwoStacks<T> {

    public int size;

    public QueueFromTwoStacks() {
        newestOnTop = new MyStack<T>();
        oldestOnTop = new MyStack<T>();
    }


    private MyStack<T> newestOnTop;
    private MyStack<T> oldestOnTop;


    public void enqueue(T elem) throws InterruptedException {
        //insert in newest
        newestOnTop.push(elem);
    }


    public T dequeue() throws InterruptedException {

        if (oldestOnTop.size() == 0)
            while(newestOnTop.size() !=0)
                oldestOnTop.push(newestOnTop.pop());

        return oldestOnTop.pop();
    }


    public int getSize() {
        return newestOnTop.size()>oldestOnTop.size()?   newestOnTop.size():oldestOnTop.size();
    }

}
