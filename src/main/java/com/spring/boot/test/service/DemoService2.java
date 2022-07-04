package com.spring.boot.test.service;

import com.spring.boot.test.bean.Demo;
import com.spring.boot.test.dao.DemoDaoUseJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("demoService2")
public class DemoService2 {
    @Autowired
    private DemoDaoUseJdbcTemplate daoUseJdbcTemplate;

    public List<Demo> GetByIds(Integer[] ids) {
        return daoUseJdbcTemplate.GetByIds(ids);
    }
}
