package cn.eccom.refactor.ch1.entity;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static cn.eccom.refactor.ch1.util.PlayTypeConstant.TRAGEDY_PLAY_TYPE;

/**
 * @author yuguang
 * @version 1.0.0
 * @ClassName CalTragedy.java
 * @Description TODO
 * @createTime 2022年08月03日 20:52:00
 */
@Component
@Order(2)
public class CalTragedy extends Calculate {
    @Override
    public String getCalCode() {
        return TRAGEDY_PLAY_TYPE;
    }

    @Override
    public int calAmount(Performance perf) {
        int result = 40000;
        if (perf.getAudience() > 30) {
            result += 1000 * (perf.getAudience() - 30);
        }
        return result;
    }

}
