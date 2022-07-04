package com.spring.boot.test.dao;

import com.spring.boot.test.bean.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * TODO 使用JPA jdbc模板操作数据
 *
 * @author 郑江山
 *
 */
@Repository("demoDao1")
public class DemoDaoUseJdbcTemplate {
    @Autowired //自动装配模板
    private JdbcTemplate jdbcTemplate;

    /**
     * TODO 根据主键获取数据
     * @param id 主键
     * @return 实体对象
     */
    public Demo getById(Integer id) {
        String sql = "select * from Demo where id = ?";

        //获取数据映射
        RowMapper<Demo> mapper = new BeanPropertyRowMapper<>(Demo.class);
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    /**
     * TODO 根据主键获取数据
     * @param ids 主键
     * @return 实体对象
     * 多条数据查询
     */
    public List<Demo> GetByIds(Integer ids[]) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from Demo where id in(");
        for (int i = 0; i < ids.length; i++) {
            sb.append(ids[i] + String.valueOf(","));
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        List<Demo> lstDemo = jdbcTemplate.query(sb.toString(), new RowMapper<Demo>() {
            @Override
            public Demo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Demo demo = new Demo();
                demo.setId(rs.getInt("id"));
                demo.setName(rs.getString("name"));
                demo.setAge(rs.getInt("age"));
                demo.setAddress(rs.getString("address"));
                return demo;
            }
        });
        return lstDemo.size() == 0 ? null : lstDemo;
    }
}
