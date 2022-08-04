package cn.eccom.refactor.ch1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuguang
 * @version 1.0.0
 * @ClassName Performance.java
 * @Description TODO
 * @createTime 2022年08月01日 21:35:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Performance {
    private String playId;
    private Integer audience;
}
