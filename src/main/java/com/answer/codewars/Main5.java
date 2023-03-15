package com.answer.codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created by liufeng
 * 2019/2/22
 */
public class Main5 {

        public static void main(String[] args) {
            String s1="Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha";
            dotest(s1, "Ladder", "1.1", "Program: Ladder Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 1.1");
            String s11="Program title: Hammer\nAuthor: Tolkien\nCorporation: IB\nPhone: +1-503-555-0090\nDate: Tues March 29, 2017\nVersion: 2.0\nLevel: Release";
            dotest(s11, "Balance", "1.5.6", "Program: Balance Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 2.0");
            String s12="Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-009\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha";
            dotest(s12, "Ladder", "1.1", "ERROR: VERSION or PHONE");
        }

    private static void dotest(String s, String prog, String version, String exp) {
        System.out.println("s:\n" + s);
        System.out.println("prog: " + prog);
        System.out.println("version: " + version);
        String ans = change(s, prog, version);
        System.out.println("Actual: " + ans);
        System.out.println("Expect: " + exp);
        assertEquals(exp, ans);
    }

        public static String change(String s, String prog, String version) {
            String result="";
            // remove title
            s=s.replace(" title","");
            String[] infos=s.split("\n");
            for(int i=0;i<infos.length;i++){
                if(infos[i].contains("Program")){
                    String str=infos[i].substring(infos[i].indexOf(":")+1,infos[i].length());
                    result=result+infos[i].replace(str," "+prog)+" ";
                }
                if(infos[i].contains("Author")){
                    String str=infos[i].substring(infos[i].indexOf(":")+1,infos[i].length());
                    result=result+infos[i].replace(str," g964")+" ";
                }
                if(infos[i].contains("Phone")){

                    String str=infos[i].substring(infos[i].indexOf(":")+1,infos[i].length());
                    //校验手机
                    if(!(str.trim()).matches("^\\+1-\\d{3}-\\d{3}-\\d{4}$")){
                        return "ERROR: VERSION or PHONE";
                    }
                    result=result+infos[i].replace(str," +1-503-555-0090")+" ";
                }
                if(infos[i].contains("Date")){
                    String str=infos[i].substring(infos[i].indexOf(":")+1,infos[i].length());
                    result=result+infos[i].replace(str," 2019-01-01")+" ";
                }
                if(infos[i].contains("Version")){
                    //校验版本号是否符合规则
                    String regex="^\\d+\\.\\d+$";
                    String str=infos[i].substring(infos[i].indexOf(":")+1,infos[i].length());
                    if(!(str.trim()).matches(regex)){
                        return "ERROR: VERSION or PHONE";
                    }
                    if("2.0".equals(str.trim())){
                        result=result+infos[i].replace(str," "+2.0);
                    }else {
                        result=result+infos[i].replace(str," "+version);
                    }

                }
            }
            return result;
        }
}
