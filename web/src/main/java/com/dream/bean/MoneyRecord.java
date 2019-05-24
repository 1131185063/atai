package com.dream.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MoneyRecord {
    private BigDecimal money;
    private Integer id;
    private String name;
    private String type;
    private String createTime;
    private String updateTime;
}
