package com.uplooking.crowdfunding.manager.mapper;

import com.uplooking.crowdfunding.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User queryUserLogin(Map<String, Object> paramMap);
    List<User> queryUserByPage(@Param("startIndex") int startIndex, @Param("size") int size);
}