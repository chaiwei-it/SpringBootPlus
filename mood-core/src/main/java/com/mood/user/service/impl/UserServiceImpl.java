package com.mood.user.service.impl;

import com.mood.Shift;
import com.mood.StatusCode;
import com.mood.base.Pager;
import com.mood.entity.user.User;
import com.mood.entity.user.request.*;
import com.mood.entity.user.response.*;
import com.mood.user.dao.UserDao;
import com.mood.user.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserInsertResponse insert(UserInsertRequest request){
        User user = OrikaMapper.map(request, User.class);
        user.setId(IdGen.uuid());
        userDao.insert(user);
        return OrikaMapper.map(user, UserInsertResponse.class);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserUpdateResponse update(UserUpdateRequest request){
        User user = OrikaMapper.map(request, User.class);
        userDao.update(user);
        return OrikaMapper.map(user, UserUpdateResponse.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserDeleteResponse delete(UserDeleteRequest request){
        userDao.deleteById(request.getId());
        return new UserDeleteResponse();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserSelectResponse select(UserSelectRequest request){
        User user = userDao.selectById(request.getId());
        return OrikaMapper.map(user, UserSelectResponse.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserListResponse selectList(UserListRequest request){
        User user = OrikaMapper.map(request, User.class);
        List<User> userList = userDao.selectAll(user, "");
        List<UserDetailsResponse> detailsList = OrikaMapper.mapList(userList, UserDetailsResponse.class);
        UserListResponse response = new UserListResponse();
        response.setList(detailsList);
        return response;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserPagerResponse selectPager(UserPagerRequest request){
        User user = OrikaMapper.map(request, User.class);
        Pager<User> pager = OrikaMapper.map(request, Pager.class);
        pager.setObject(user);
        pager = userDao.selectPager(pager);
        List<UserDetailsResponse> detailsList = OrikaMapper.mapList(pager.getData(), UserDetailsResponse.class);
        UserPagerResponse response = OrikaMapper.map(pager, UserPagerResponse.class);
        response.setList(detailsList);
        return response;
    }
}
