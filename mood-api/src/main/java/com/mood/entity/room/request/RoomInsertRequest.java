package com.mood.entity.room.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 应用模块
 * @author chaiwei
 * @time 2018-06-04 下午16:00
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
public class RoomInsertRequest implements Serializable {

    /**
     * 房间编号
     */
    @NotNull(message = "请输入房间编号")
    @NotBlank(message = "请输入房间编号")
    private String roomNum;

    /**
     * 房间类型
     */
    @NotNull(message = "请输入房间类型")
    private Integer roomType;

    /**
     * 价格
     */
    @NotNull(message = "请输入房间价格")
    private BigDecimal price;

    /**
     * 房间状态
     */
//    private Integer status;


}