package cn.eccom.refactor.ch1.entity;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static cn.eccom.refactor.ch1.util.PlayTypeConstant.HISTORY_PLAY_TYPE;

/**
 * @author yuguang
 * @version 1.0.0
 * @ClassName CalHistory.java
 * @Description TODO
 * @createTime 2022年08月04日 14:07:00
 */
@Component
@Order(3)
public class CalHistory extends Calculate {
    @Override
    public String getCalCode() {
        return HISTORY_PLAY_TYPE;
    }

    @Override
    public int calAmount(Performance perf) {
        int result = 50000;
        if (perf.getAudience() > 20) {
            result += 10000 + 300 * (perf.getAudience() - 20);
        }
        result += 300 * perf.getAudience();
        return result;
    }
}
