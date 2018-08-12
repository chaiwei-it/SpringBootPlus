package com.mood.entity.room;

import com.mood.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 应用模块
 * @author chaiwei
 * @time 2018-06-04 下午16:00
 */
@Data
@Table(name="hotel_room")
public class Room extends BaseEntity {

    @Id
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