package cn.eccom.refactor.ch1.entity;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static cn.eccom.refactor.ch1.util.PlayTypeConstant.COMEDY_PLAY_TYPE;

/**
 * @author yuguang
 * @version 1.0.0
 * @ClassName CalComedy.java
 * @Description TODO
 * @createTime 2022年08月03日 20:54:00
 */
@Component
@Order(1)
public class CalComedy extends Calculate {
    @Override
    public String getCalCode() {
        return COMEDY_PLAY_TYPE;
    }

    @Override
    public int calAmount(Performance perf) {
        int result = 30000;
        if (perf.getAudience() > 20) {
            result += 10000 + 500 * (perf.getAudience() - 20);
        }
        result += 300 * perf.getAudience();
        return result;
    }

    @Override
    public int calCredits(Performance perf) {
        return super.calCredits(perf) + (int)Math.floor(perf.getAudience() /5);
    }
}
