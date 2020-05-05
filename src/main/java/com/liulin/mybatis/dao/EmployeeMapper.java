package com.liulin.mybatis.dao;

import com.liulin.mybatis.bean.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * Create by DbL on 2020/5/4 0004
 */
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int updateBatch(List<Employee> list);

    int insertSelective(Employee record);

    int batchInsert(List<Employee> list);

    Employee selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    void deleteByList(List<Integer> ids);

    long countByMap(HashMap<String, String> map);

    List<Employee> selectByMap(HashMap<String, Object> map);
}
