package com.answer.mianshi;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by liufeng
 * 2018/11/9
 */
public class Login {
    public static void main(String[] args) throws Exception {
        Login loginDemo = new Login();
        loginDemo.login("answer_sky13@163.com", "123456");// 输入CSDN的用户名，和密码
    }
    public void login(String userName, String pwd) throws Exception {
        // 第一次请求
        Connection con = Jsoup
                .connect("https://oms.qegoo.cn/user/go_login");// 获取连接
        con.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.143 Safari/537.36");// 配置模拟浏览器
        Connection.Response rs = con.execute();// 获取响应
        Document d1 = Jsoup.parse(rs.body());// 转换为Dom树
        List<Element> et = d1.select("#h2tab2 input");// 获取form表单，可以通过查看页面源码代码得知
        // 获取，cooking和表单属性，下面map存放post时的数据
        Map<String, String> datas = new HashMap<>();
        for (Element e : et.get(0).getAllElements()) {
            if (e.attr("name").equals("username")) {
                e.attr("value", userName);// 设置用户名
            }
            if (e.attr("name").equals("password")) {
                e.attr("value", pwd); // 设置用户密码
            }
            if (e.attr("name").length() > 0) {// 排除空值表单属性
                datas.put(e.attr("name"), e.attr("value"));
            }
        }
        /**
         * 第二次请求，post表单数据，以及cookie信息
         *
         * **/
        Connection con2 = Jsoup
                .connect("https://oms.qegoo.cn/user/go_login");
        con2.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.143 Safari/537.36");
        // 设置cookie和post上面的map数据
        Connection.Response login = con2.ignoreContentType(true).method(Connection.Method.POST)
                .data(datas).cookies(rs.cookies()).execute();
        // 打印，登陆成功后的信息
        System.out.println(login.body());
        // 登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
        Map<String, String> map = login.cookies();
        for (String s : map.keySet()) {
            System.out.println(s + "      " + map.get(s));
        }
    }
}

