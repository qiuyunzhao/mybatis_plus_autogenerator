package com.haoqian.mybatis_plus.mymodule.service.impl;

import com.haoqian.mybatis_plus.mymodule.entity.Student;
import com.haoqian.mybatis_plus.mymodule.mapper.StudentMapper;
import com.haoqian.mybatis_plus.mymodule.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author haoqian
 * @since 2020-12-20
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
