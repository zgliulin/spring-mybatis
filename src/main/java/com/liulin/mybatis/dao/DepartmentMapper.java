package com.liulin.mybatis.dao;

import com.liulin.mybatis.bean.Department;

import java.util.List;

/**
 * Create by DbL on 2020/5/4 0004
 */
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByMap(Object o);
}
