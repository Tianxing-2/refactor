package cn.eccom.refactor.ch1.util;

import cn.eccom.refactor.ch1.entity.ICalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * @author yuguang
 * @version 1.0.0
 * @ClassName CalculateFactory.java
 * @Description TODO
 * @createTime 2022年08月04日 09:32:00
 */
@Component
public class CalculateFactory {

    @Autowired
    private List<ICalculate> calculateList;

    private final Map<String, ICalculate> CAL_MAP = new HashMap<>();

    @PostConstruct
    public void putCalculate(){
        calculateList.forEach(calculate -> {
            CAL_MAP.put(calculate.getCalCode(), calculate);
        });
    }

    public ICalculate getCalculate(String code){
        return CAL_MAP.get(code);
    }
}
