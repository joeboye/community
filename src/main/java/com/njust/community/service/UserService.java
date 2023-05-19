package com.njust.community.service;

import com.njust.community.dao.UserMapper;
import com.njust.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhangpeng
 * @Date 2023/5/16 15:41
 * @PackageName:com.njust.community.service
 * @ClassName: UserService
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

}
