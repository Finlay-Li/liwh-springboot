package com.dodou.liwh.amqp.boot;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Lwh
 * @ClassName: Hei
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-21 5:02 PM
 */
@Data
public class Hei implements Serializable {
    private static final long serialVersionUID = -2311908432114498397L;
    private BigDecimal num;
}
