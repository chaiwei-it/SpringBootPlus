package com.mood.entity.room.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 应用模块
 * @author chaiwei
 * @time 2018-06-04 下午16:00
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
public class RoomDetailsResponse {

    private String id;

    /**
     * 房间编号
     */
    private String roomNum;

    /**
     * 房间类型
     */
    private Integer roomType;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 房间状态
     */
    private Integer status;


}