package com.uplooking.crowdfunding.manager.mapper;

import com.uplooking.crowdfunding.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper {
    List<User> findAllUsers();
}
