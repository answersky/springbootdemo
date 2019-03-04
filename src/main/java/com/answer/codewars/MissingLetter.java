package com.answer.codewars;

/**
 * created by liufeng
 * 2019/2/28
 */
public class MissingLetter {

    public static void main(String[] args) {
//        assertEquals('e', findMissingLetter(new char[] { 'a','b','c','d','f' }));
//        assertEquals('P', findMissingLetter(new char[] { 'O','Q','R','S' }));
        findMissingLetter(new char[] {'a','b','e','d','f' });
    }

    public static char findMissingLetter(char[] array) {
        char result=' ';
        for(int i=0;i<array.length;i++){
            char first=array[0];
            char last=array[array.length-1];
            if(i>0){
                int next=first+i;
                if(next!=array[i]){
                    result=(char)next;
                    break;
                }
            }
        }
        System.out.println(String.valueOf(result));
        return result;
    }

}

