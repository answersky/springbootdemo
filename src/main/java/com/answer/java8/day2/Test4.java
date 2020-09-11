package com.answer.java8.day2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * created by liufeng
 * 2020/9/1
 */
public class Test4 {

    /**
     * (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
     * (2) 交易员都在哪些不同的城市工作过？
     * (3) 查找所有来自于剑桥的交易员，并按姓名排序。
     * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
     * (5) 有没有交易员是在米兰工作的？
     * (6) 打印生活在剑桥的交易员的所有交易额。
     * (7) 所有交易中，高的交易额是多少？
     * (8) 找到交易额小的交易。
     * @param args
     */
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

        List<Transaction> ts=transactions.stream().filter(transaction -> transaction.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println("1."+ts);

        List<String> citys=transactions.stream().map(transaction->transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println("2."+citys);

        List<Trader> traders=transactions.stream().map(Transaction::getTrader).filter(trader -> "Cambridge".equals(trader.getCity())).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println("3."+traders);

        List<String> names=transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().collect(Collectors.toList());
        System.out.println("4."+names);

        boolean traderList=transactions.stream().map(Transaction::getTrader).anyMatch(trader -> "Milan".equals(trader.getCity()));
        System.out.println("5."+traderList);

        List<Integer> values=transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())).map(Transaction::getValue).collect(Collectors.toList());
        System.out.println("6."+values);

        Integer maxValue=transactions.stream().map(Transaction::getValue).reduce(0,Integer::max);
        System.out.println("7."+maxValue);

        Transaction transaction=transactions.stream().min(Comparator.comparing(Transaction::getValue)).get();
        System.out.println("8."+transaction);

    }
}
