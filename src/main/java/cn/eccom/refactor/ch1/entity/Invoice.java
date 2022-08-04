package cn.eccom.refactor.ch1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuguang
 * @version 1.0.0
 * @ClassName Invoices.java
 * @Description TODO
 * @createTime 2022年08月01日 21:27:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    private String customer;
    private List<Performance> performances;
}
