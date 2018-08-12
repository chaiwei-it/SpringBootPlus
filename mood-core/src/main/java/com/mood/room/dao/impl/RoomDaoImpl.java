package com.mood.room.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mood.base.Pager;
import com.mood.entity.room.Room;
import com.mood.room.dao.RoomDao;
import com.mood.room.dao.mapper.RoomMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 用户模块
 * @author chaiwei
 * @time 2018-01-07 下午08:00
 */
@Repository
public class RoomDaoImpl implements RoomDao {

   @Autowired
    private RoomMapper roomMapper;

    @Override
    public int insert(Room room) {
        return roomMapper.insert(room);
    }

    @Override
    public int update(Room room) {
        return roomMapper.updateByPrimaryKeySelective(room);
    }

    @Override
    public int deleteById(String id) {
        return roomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Room selectById(String id) {
        return roomMapper.selectByPrimaryKey(id);
    }

//    @Override
//    public List<Room> selectAll(JSONObject param){
//        return null;
//    }

    @Override
    public List<Room> selectAll(Room room, String... data) {
        Example example = new Example(Room.class);
        Example.Criteria criteria = example.createCriteria();
        if (room != null) {
            //拼接条件
//            Object name = room.getName();
//            if (name != null) {
//                criteria.andLike("name", "%" + name.toString() + "%");
//            }
        }
        String orderBy = "";
        if(data.length > 0){
            orderBy = data[0];
        }else{
            orderBy = "id asc";
        }
        if(!"".equals(orderBy)){
            example.setOrderByClause(orderBy);
        }
        return roomMapper.selectByExample(example);
    }

    @Override
    public Pager<Room> selectPager(Pager pager){
        //处理分页
        PageHelper.startPage(pager.getPageIndex(), pager.getPageSize());
        List<Room> result = selectAll((Room)pager.getObject(), pager.getOrderBy());
        //组装返回数据
        PageInfo pageInfo = new PageInfo(result);
        return pager.buildPager(pageInfo.getPages(), pageInfo.getTotal(), pageInfo.getList());
    }

}
