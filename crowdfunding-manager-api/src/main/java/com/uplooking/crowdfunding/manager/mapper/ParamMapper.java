package com.uplooking.crowdfunding.manager.mapper;


import com.uplooking.crowdfunding.bean.Param;

import java.util.List;

public interface ParamMapper {
    int deleteByPrimaryKey(Integer id);

	int insert(Param record);

	Param selectByPrimaryKey(Integer id);

	List<Param> selectAll();

	int updateByPrimaryKey(Param record);


}