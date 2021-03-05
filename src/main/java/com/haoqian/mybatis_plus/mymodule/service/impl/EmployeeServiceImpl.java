package com.haoqian.mybatis_plus.mymodule.service.impl;

import com.haoqian.mybatis_plus.mymodule.entity.Employee;
import com.haoqian.mybatis_plus.mymodule.mapper.EmployeeMapper;
import com.haoqian.mybatis_plus.mymodule.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haoqian
 * @since 2020-12-20
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
