package com.mood.room.service;

import com.mood.entity.room.request.*;
import com.mood.entity.room.response.*;

/**
 * 应用模块
 * @author chaiwei
 * @time 2018-01-07 下午08:00
 */
public interface RoomService {

    public RoomInsertResponse insert(RoomInsertRequest request);

    public RoomUpdateResponse update(RoomUpdateRequest request);

    public RoomDeleteResponse delete(RoomDeleteRequest request);

    public RoomSelectResponse select(RoomSelectRequest request);

    public RoomListResponse selectList(RoomListRequest request);

    public RoomPagerResponse selectPager(RoomPagerRequest request);
}
