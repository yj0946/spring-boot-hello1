package com.spring.boot.test.service;

import com.spring.boot.test.bean.Demo;
import com.spring.boot.test.dao.IDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO 简单业务逻辑层
 *
 * @author 郑江山
 *
 */
@Service("demoService")   //定义业务逻辑层
public class DemoService {
    @Autowired // 自动装配DAO
    private IDemoRepository demoRepository;

    @Transactional // 自动事务托管
    public void save(Demo demo) {
        demoRepository.save(demo);
    }
}
