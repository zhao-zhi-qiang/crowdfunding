package com.uplooking.crowdfunding.manager.service;
import com.uplooking.crowdfunding.bean.User;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User queryUserLogin(Map<String,Object> paramMap);
    List<User> queryUserByPage( int startIndex,  int size);
}
