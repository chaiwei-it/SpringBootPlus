package com.mood.controller.room;

import com.mood.base.BaseController;
import com.mood.entity.room.notes.*;
import com.mood.entity.room.request.*;
import com.mood.entity.room.response.*;
import com.mood.room.service.RoomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 模块
 * @author chaiwei
 * @time 2018-05-15 下午10:00
 */
@RestController
@RequestMapping(value = "/api/v1/room", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
public class RoomApi extends BaseController {

    @Autowired
    private RoomService roomService;

    /**
     * 添加
     * @param request
     * @return
     */
    @ApiOperation(value = RoomInsertNote.title, notes = RoomInsertNote.notes)
    @PostMapping("add")
    public RoomInsertResponse create(@Valid @RequestBody RoomInsertRequest request, BindingResult error){
        return roomService.insert(request);
    }

    /**
     * 修改
     * @param request
     * @return
     */
    @ApiOperation(value = RoomUpdateNote.title, notes = RoomUpdateNote.notes)
    @PostMapping("update")
    public RoomUpdateResponse update(@Valid @RequestBody RoomUpdateRequest request, BindingResult error){
        return roomService.update(request);
    }

    /**
     * 删除
     * @param request
     * @return
     */
    @ApiOperation(value = RoomDeleteNote.title, notes = RoomDeleteNote.notes)
    @PostMapping("delete")
    public void delete(@Valid @RequestBody RoomDeleteRequest request, BindingResult error){
        roomService.delete(request);
    }

    /**
     * 详情
     * @param request
     * @return
     */
    @ApiOperation(value = RoomSelectNote.title, notes = RoomSelectNote.notes)
    @PostMapping("select")
    public RoomSelectResponse selete(@Valid @RequestBody RoomSelectRequest request, BindingResult error){
        return roomService.select(request);
    }
//
    /**
     * 列表
     * @param request
     * @return
     */
    @ApiOperation(value = RoomListNote.title, notes = RoomListNote.notes)
    @PostMapping("/list")
    public RoomListResponse list(@Valid @RequestBody RoomListRequest request, BindingResult error){
        return roomService.selectList(request);
    }

    /**
     * 分页
     * @param request
     * @return
     */
    @ApiOperation(value = RoomPagerNote.title, notes = RoomPagerNote.notes)
    @PostMapping("/pager")
    public RoomPagerResponse pager(@Valid @RequestBody RoomPagerRequest request, BindingResult error){
        return roomService.selectPager(request);
    }


}
