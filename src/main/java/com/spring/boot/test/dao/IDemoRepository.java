package com.spring.boot.test.dao;

import com.spring.boot.test.bean.Demo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO Demo表的DAO层接口，并没有具体的实现，继承基础CRUD实现
 * 泛型1：实体类 泛型2：主键映射类型
 * @author 郑江山
 *
 */
public interface IDemoRepository extends CrudRepository<Demo, Integer> {
}
