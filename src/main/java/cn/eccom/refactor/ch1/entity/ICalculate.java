package cn.eccom.refactor.ch1.entity;

/**
 * @author yuguang
 * @version 1.0.0
 * @ClassName ICalculate.java
 * @Description TODO
 * @createTime 2022年08月04日 09:30:00
 */
public interface ICalculate {
    int calAmount(Performance perf);
    int calCredits(Performance perf);
    String getCalCode();
}
