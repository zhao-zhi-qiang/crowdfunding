package com.uplooking.crowdfunding.manager.impl;

import com.uplooking.crowdfunding.bean.User;
import com.uplooking.crowdfunding.manager.mapper.UserMapper;
import com.uplooking.crowdfunding.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }
    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
    @Override
    public User queryUserLogin(Map<String, Object> paramMap) {
        return userMapper.queryUserLogin(paramMap);
    }

    @Override
    public List<User> queryUserByPage(int startIndex, int size) {
        return userMapper.queryUserByPage(startIndex,size);
    }

}
