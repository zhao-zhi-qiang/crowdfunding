package com.uplooking.crowdfunding.manager.mapper;
import com.uplooking.crowdfunding.bean.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}