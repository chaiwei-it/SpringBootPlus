package com.mood.room.service.impl;

import com.mood.Shift;
import com.mood.StatusCode;
import com.mood.base.Pager;
import com.mood.entity.room.Room;
import com.mood.entity.room.request.*;
import com.mood.entity.room.response.*;
import com.mood.room.dao.RoomDao;
import com.mood.room.service.RoomService;
import com.mood.utils.IdGen;
import com.mood.utils.OrikaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户模块
 * @author chaiwei
 * @time 2018-01-07 下午08:00
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public RoomInsertResponse insert(RoomInsertRequest request){
        Room room = OrikaMapper.map(request, Room.class);
        room.setStatus(0);
        room.setId(IdGen.uuid());
        roomDao.insert(room);
        return OrikaMapper.map(room, RoomInsertResponse.class);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RoomUpdateResponse update(RoomUpdateRequest request){
        Room room = OrikaMapper.map(request, Room.class);
        roomDao.update(room);
        return OrikaMapper.map(room, RoomUpdateResponse.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RoomDeleteResponse delete(RoomDeleteRequest request){
        roomDao.deleteById(request.getId());
        return new RoomDeleteResponse();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RoomSelectResponse select(RoomSelectRequest request){
        Room room = roomDao.selectById(request.getId());
        return OrikaMapper.map(room, RoomSelectResponse.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RoomListResponse selectList(RoomListRequest request){
        Room room = OrikaMapper.map(request, Room.class);
        List<Room> roomList = roomDao.selectAll(room, "");
        List<RoomDetailsResponse> detailsList = OrikaMapper.mapList(roomList, RoomDetailsResponse.class);
        RoomListResponse response = new RoomListResponse();
        response.setList(detailsList);
        return response;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RoomPagerResponse selectPager(RoomPagerRequest request){
        Room room = OrikaMapper.map(request, Room.class);
        Pager<Room> pager = OrikaMapper.map(request, Pager.class);
        pager.setObject(room);
        pager = roomDao.selectPager(pager);
        List<RoomDetailsResponse> detailsList = OrikaMapper.mapList(pager.getData(), RoomDetailsResponse.class);
        RoomPagerResponse response = OrikaMapper.map(pager, RoomPagerResponse.class);
        response.setList(detailsList);
        return response;
    }
}
