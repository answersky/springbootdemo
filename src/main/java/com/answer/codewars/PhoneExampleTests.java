package com.answer.codewars;

import static org.junit.Assert.assertEquals;

/**
 * created by liufeng
 * 2019/4/10
 */
public class PhoneExampleTests {

    public static void main(String[] args) {
        assertEquals(true, validPhoneNumber("(123) 456-7890"));
        assertEquals(false, validPhoneNumber("(1111)555 2345"));
        assertEquals(false, validPhoneNumber("(098) 123 4567"));
    }

    private static boolean validPhoneNumber(String phoneNumber) {
        if(!phoneNumber.contains("-")){
            return false;
        }
        String blank=phoneNumber.substring(phoneNumber.indexOf(")")+1,phoneNumber.indexOf(")")+2);
        if(!" ".equals(blank)){
            return false;
        }
        return true;
    }
}
