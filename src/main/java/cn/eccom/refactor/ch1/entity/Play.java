package cn.eccom.refactor.ch1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张伟
 * @version 1.0.0
 * @ClassName Play.java
 * @Description TODO
 * @createTime 2022年08月01日 21:25:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Play {
    private String name;
    private String type;
}
