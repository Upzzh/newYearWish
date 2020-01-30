package com.newyear.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName RspResult
 * @Description TODO
 * @Date2020/1/22 14:47
 **/
@Data
@ToString
public class RspResult {
    private Integer status;
    private String  msg;
}
