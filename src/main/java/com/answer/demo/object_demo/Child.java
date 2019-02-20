package com.answer.demo.object_demo;

/**
 * created by liufeng
 * 2019/2/12
 */
public class Child extends Parent{
    private Integer age;
    public Child(){
        super();
    }
    public Child(Integer age){
        this.age=age;
    }

    @Override
    public String toString() {
        return "Child{" +
                "age=" + age +
                ",id=" + this.id +
                '}';
    }

    public static void main(String[] args) {
        Child child=new Child(12);
        child.id=3;
        System.out.println(child);
    }
}
