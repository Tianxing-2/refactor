package cn.eccom.refactor.ch1.service;

import cn.eccom.refactor.ch1.entity.*;
import cn.eccom.refactor.ch1.util.CalculateFactory;
import cn.eccom.refactor.ch1.util.R;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.eccom.refactor.ch1.util.PlayTypeConstant.*;

/**
 * @author yuguang
 * @version 1.0.0
 * @ClassName Prototype.java
 * @Description TODO
 * @createTime 2022年08月01日 21:39:00
 */

public class Prototype {
    //构造数据
    static Map<String, Play> plays = new HashMap<>();
    static List<Invoice> invoices = new ArrayList<>();
    static {
        plays.put("hamlet", new Play("Hamlet", TRAGEDY_PLAY_TYPE));
        plays.put("as-like", new Play("As You Like It", COMEDY_PLAY_TYPE));
        plays.put("othello", new Play("Othello", TRAGEDY_PLAY_TYPE));
        //增加历史剧目三国
        plays.put("threeKingdoms", new Play("threeKingdoms", HISTORY_PLAY_TYPE));


        List<Performance> performances = new ArrayList<>();
        Performance hamlet = new Performance("hamlet", 55);
        Performance asLike = new Performance("as-like", 35);
        Performance othello = new Performance("othello", 40);
        //顾客多订一个表演
        Performance threeKingdoms = new Performance("threeKingdoms", 60);

        performances.add(hamlet); performances.add(othello); performances.add(asLike);
        Invoice invoice = new Invoice();
        invoice.setCustomer("BigCo");
        invoice.setPerformances(performances);
        invoices.add(invoice);
    }


    public static String statement(R data){
        String result = "Statement for" + data.getCustomer() + "\n";
        for(Performance perf : data.getPerformances()){
            result += "" + plays.get(perf.getPlayId()).getName() + calculateFactory.getCalculate(plays.get(perf.getPlayId()).getType()).calAmount(perf) / 100 + "￥(" + perf.getAudience() + " seats)\n";
        }
        result += "Amount owed is " + data.getTotalAmount() / 100 + "￥ \n";
        result += "You earned " + data.getVolumeCredit() + " credits\n";
        return result;
    }


    private static String htmlStatement(R data) {
        String result = "<h1>Statement for " + data.getCustomer() + "</h1>\n";
        result += "<table>\n";
        result += "<tr><th>play</th><th>seats</th><th>cost</th></tr>\n";
        for (Performance perf : data.getPerformances()) {
            result += "<tr><td>" + plays.get(perf.getPlayId()).getName() + "</td><td>" + perf.getAudience() + "</td>";
            result += "<td>" + calculateFactory.getCalculate(plays.get(perf.getPlayId()).getType()).calAmount(perf) / 100 + "￥</td></tr>\n";
        }
        result += "</table>\n";
        result += "<p>Amount owed is <em>" + data.getTotalAmount()/ 100  + "￥</em></p>\n";
        result += "<p>You earned <em>" + data.getVolumeCredit() + "</em> credits</p>\n";
        return result;
    }

    private static R createStatementData() {
        R result = new R();
        result.setTotalAmount(getTotalAmount());
        result.setVolumeCredit(getTotalVolumeCredits());
        result.setCustomer(invoices.get(0).getCustomer());
        result.setPerformances(invoices.get(0).getPerformances());
        return result;
    }

    @Autowired
    private static CalculateFactory calculateFactory;

    private static int getTotalAmount() {
        int result = 0;
        for(Performance perf : invoices.get(0).getPerformances()){
            //plays.get(perf.getPlayId()).getType()可以获取到剧目类型
            //根据传入的类型，通过工厂就可以获取到对应的计算类，调用计算方法
            result += calculateFactory.getCalculate(plays.get(perf.getPlayId()).getType()).calAmount(perf);
        }
        return result;
    }

    private static int getTotalVolumeCredits() {
        int result = 0;
        for(Performance perf : invoices.get(0).getPerformances()){
            result += calculateFactory.getCalculate(plays.get(perf.getPlayId()).getType()).calCredits(perf);
        }
        return result;
    }


    public static void main(String[] args) {
        R data = createStatementData();
        System.out.println(statement(data));
        System.out.println(htmlStatement(data));
    }

}



