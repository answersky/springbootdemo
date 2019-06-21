package com.answer.demo.Collection.zdy;

import java.util.Collection;
import java.util.Iterator;

/**
 * created by liufeng
 * 2019/6/21
 */
public class ZDYList<E> implements ZDYListInterface<E>{
    /**
     * 存储数据的数组
     */
    private Object[] elementArr;
    private int initLength;
    /**
     * list 长度
     */
    private int size;

    public ZDYList(){
        //初始化长度10
        this(10);
    }

    public ZDYList(int initLength){
        if(initLength<0){
            throw new ZDYListException("list的size小于0!");
        }
        this.elementArr=new Object[initLength];
        this.initLength=initLength;
    }


    /**
     * list 中元素的个数
     * @return
     */
    public int size(){
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int indexOf(Object o){
        if(o==null){
            for(int i=0;i<this.elementArr.length;i++){
                if(this.elementArr[i]==null){
                    return i;
                }
            }
        }else {
            for(int i=0;i<this.elementArr.length;i++){
                if(o.equals(this.elementArr[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> iterator() {
        return new IteratorElement();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    /**
     * 添加元素
     * @param element
     */
    public boolean add(E element){
        //判断添加元素时是否数组越界
        if(size==initLength){
            throw new ZDYListException("添加元素已达最大容量");
        }
        this.elementArr[size]=element;
        size++;
        return true;
    }

    private void extendLength(int size){

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
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if(i>=size){
            throw new ZDYListException("数组越界 index:"+i+",size:"+size);
        }
        return (E) this.elementArr[i];
    }

    /**
     * 实现list 使用foreach语句  必须要实现Iterator接口
     */
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
            E elment= (E) ZDYList.this.elementArr[index];
            index++;
            return elment;
        }

        @Override
        public void remove() {

        }
    }
}

