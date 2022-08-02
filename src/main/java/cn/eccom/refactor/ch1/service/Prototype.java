package cn.eccom.refactor.ch1.service;

import cn.eccom.refactor.ch1.entity.Invoice;
import cn.eccom.refactor.ch1.entity.Performance;
import cn.eccom.refactor.ch1.entity.Play;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张伟
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
        plays.put("hamlet", new Play("Hamlet", "tragedy"));
        plays.put("as-like", new Play("As You Like It", "comedy"));
        plays.put("othello", new Play("Othello", "tragedy"));


        List<Performance> performances = new ArrayList<>();
        Performance hamlet = new Performance("hamlet", 55);
        Performance asLike = new Performance("as-like", 35);
        Performance othello = new Performance("othello", 40);
        performances.add(hamlet); performances.add(othello); performances.add(asLike);
        Invoice invoice = new Invoice();
        invoice.setCustomer("BigCo");
        invoice.setPerformances(performances);
        invoices.add(invoice);
    }


    public static String statement(){
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "Statement for" + invoices.get(0).getCustomer() + "\n";
        for(Performance perf : invoices.get(0).getPerformances()){
            String playId = perf.getPlayId();
            Play play = plays.get(playId);
            String type = play.getType();
            int thisAmount = 0;
            switch(type){
                case "tragedy":
                    thisAmount = 40000;
                    if(perf.getAudience() > 30){
                        thisAmount += 1000 * (perf.getAudience() - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if(perf.getAudience() > 20){
                        thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                    }
                    thisAmount += 300 * perf.getAudience();
                    break;
                default:
                    throw new Error("unknown type");
            }
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if("comedy".equals(type)) {
                volumeCredits += Math.floor(perf.getAudience() / 5);
            }
            result += "" + play.getName() + thisAmount / 100 + "￥(" + perf.getAudience() + " seats)\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + totalAmount / 100 + "￥ \n";
        result += "You earned " + volumeCredits + " credits\n";
        return result;
    }

    public static void main(String[] args) {
        System.out.println(statement());
    }

}
