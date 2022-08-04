package cn.eccom.refactor.ch1.entity;

/**
 * @author yuguang
 * @version 1.0.0
 * @ClassName Calculate.java
 * @Description TODO
 * @createTime 2022年08月03日 20:51:00
 */
public abstract class Calculate implements ICalculate {
    @Override
    public abstract String getCalCode();

    @Override
    public abstract int calAmount(Performance perf);

    @Override
    public int calCredits(Performance perf) {
        return Math.max(perf.getAudience() - 30, 0);
    }
}