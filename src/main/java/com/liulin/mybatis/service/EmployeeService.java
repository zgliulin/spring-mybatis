package com.liulin.mybatis.service;

import com.liulin.mybatis.bean.Employee;
import com.liulin.mybatis.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Create by DbL on 2020/5/4 0004
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAll() {

        return employeeMapper.selectByMap(null);
    }

    public void saveEmpsInfo(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    //检查用户名
    public boolean cheUser(String empName) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("empName",empName);

        long count = employeeMapper.countByMap(map);
        return count == 0;
    }

    //按id查询
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    //员工更新
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        employeeMapper.deleteByList(ids);

    }
}
