package com.ashu.utils.ds.heap;


/**
 * Created by mishra.ashish@icloud.com
 */
public class Heap <T extends Comparable<T> > {

    public Node<T> root;

    public void insert(T val) {

        root =  insert(val, root);

    }

    private Node<T> insert(T val, Node<T> heap) {

        if (root == null)
            return new Node<T>(val);

        if ( val.compareTo(heap.data) ==0 )
            return heap;

        if ( val.compareTo(heap.data) > 0 ) {
            heap = insert(val, heap.right);
        } else
            heap = insert(val, heap.left);

        return heap;
    }





    private class Node<T> {

        private T data;
        private Node<T> left, right;

        public Node(T data, Node<T> l, Node<T> r) {
            left = l; right = r;
            this.data = data;
        }

        public Node(T data) {
            this(data, null, null);
        }

        public String toString()
        {
            return data.toString();
        }
    } //end of Node


}
