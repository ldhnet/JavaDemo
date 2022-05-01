package com.demo.mpweb;

import com.demo.mpweb.dao.bookDao;
import com.demo.mpweb.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

//@SpringBootTest
@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc//开启虚拟MVC调用
public class WebTest {

    @Autowired
    private bookDao _bookDao;

    @Autowired
    private IBookService bookService;


    @Test
    void  testWeb(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/1");
        ResultActions action = mvc.perform(builder);

        //预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();

        action.andExpect(ok);//与真实值比较
    }
    @Test
    void  testBody(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/1");
        ResultActions action = mvc.perform(builder);

        //预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher body = content.string("stringboot");

        action.andExpect(body);//与真实值比较
    }
    @Test
    void  testJson(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/1");
        ResultActions action = mvc.perform(builder);

        //预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher body = content.json("");

        action.andExpect(body);//与真实值比较
    }
    @Test
    void  testContentType(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/1");
        ResultActions action = mvc.perform(builder);

        //预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher result = header.string("Content-Type","application/json");

        action.andExpect(result);//与真实值比较
    }
    @Test
    void  testgetById(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/1");
        ResultActions action = mvc.perform(builder);

        //预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        action.andExpect(ok);//与真实值比较

        //预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher result = header.string("Content-Type", "application/json");

        action.andExpect(result);//与真实值比较


    }
}
