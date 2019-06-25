package com.answer.demo.Collection.zdy;

import java.util.Collection;
import java.util.Iterator;

/**
 * created by liufeng
 * 2019/6/25
 */
public class ZDYLinkedList<E> implements ZDYListInterface<E>{
    /**
     * list 长度
     */
    private int size;
    private Node<E> first;
    private Node<E> last;

    public ZDYLinkedList(){}

    @Override
    public E get(int i) {
        if(i>=size){
            throw new ZDYListException("list out of index,size："+size+",index:"+i);
        }
        int index=0;
        for(Node<E> node=first;node!=null;node=node.next){
            if(i==index){
                return node.item;
            }
            index++;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index=0;
        if(o==null){
            for(Node<E> node=first;node!=null;node=node.next){
                if(node.item==null){
                    return index;
                }
                index++;
            }
        }else {
            for(Node<E> node=first;node!=null;node=node.next){
                if(o.equals(node.item)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorElement<E>();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * 每次添加元素都是往最后一个节点上添加
     * @param o
     * @return
     */
    @Override
    public boolean add(E o) {
        Node<E> oldLastNode=this.last;
        Node<E> node=new Node<>(this.last,o,null);
        this.last=node;
        if(oldLastNode==null){
            //即新增的节点为第一个节点
            first=node;
        }else {
            //将节点链接上
            oldLastNode.next=node;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private class Node<E>{
        E item;
        Node<E> next;
        Node<E> pre;
        public Node(Node<E> pre,E item,Node<E> next){
            this.pre=pre;
            this.item=item;
            this.next=next;
        }
    }

    private class IteratorElement<E> implements Iterator<E>{
        //遍历元素的下标
        int index;

        @Override
        public boolean hasNext() {
            return index<size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            if(index>=size){
                throw new ZDYListException("数组越界 index:"+index+",size:"+size);
            }
            E elment= (E) ZDYLinkedList.this.get(index);
            index++;
            return elment;
        }

        @Override
        public void remove() {

        }
    }
}
