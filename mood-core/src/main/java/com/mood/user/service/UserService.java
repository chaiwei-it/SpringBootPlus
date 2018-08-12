package com.mood.user.service;

import com.mood.entity.user.request.*;
import com.mood.entity.user.response.*;

/**
 * 应用模块
 * @author chaiwei
 * @time 2018-01-07 下午08:00
 */
public interface UserService {

    public UserInsertResponse insert(UserInsertRequest request);

    public UserUpdateResponse update(UserUpdateRequest request);

    public UserDeleteResponse delete(UserDeleteRequest request);

    public UserSelectResponse select(UserSelectRequest request);

    public UserListResponse selectList(UserListRequest request);

    public UserPagerResponse selectPager(UserPagerRequest request);
}
