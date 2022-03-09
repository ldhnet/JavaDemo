package com.example;

import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class JdbcdemoApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
    }
    @Test
    void testJdbcTemplate() {
        String sql = "select * from biz_book where id=1";
        String sql2 = "select * from biz_book";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql2);
        System.out.println(maps);
    }
    @Test
    void testJdbcTemplate_Query() {
        String sql = "select * from biz_book";
        RowMapper<Book> rm=new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book temp=new Book();
                temp.setId(rs.getInt("id"));
                temp.setType(rs.getString("type"));
                temp.setName(rs.getString("name"));
                temp.setDescription(rs.getString("description"));
                return  temp;
            }
        };

        List<Book> list = jdbcTemplate.query(sql, rm);

        System.out.println(list);
    }
    @Test
    void testJdbcTemplate_Save() {
        String sql = "INSERT into biz_book(type,name,description) VALUES(1,'Java教学20','Java教学20')";
        jdbcTemplate.update(sql);
    }
}
