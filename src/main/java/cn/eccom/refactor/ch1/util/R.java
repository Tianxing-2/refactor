package cn.eccom.refactor.ch1.util;

import cn.eccom.refactor.ch1.entity.Performance;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuguang
 * @version 1.0.0
 * @ClassName R.java
 * @Description TODO
 * @createTime 2022年08月03日 16:03:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    private String customer;
    private Integer totalAmount;
    private Integer volumeCredit;
    private List<Performance> performances;
}
