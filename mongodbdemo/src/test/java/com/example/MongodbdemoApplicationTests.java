package com.example;

import domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class MongodbdemoApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    void saveTest() {
        Book book=new Book();
        book.setId(2);
        book.setName("springbook88");
        book.setType("1");
        book.setDescription("springbook88");
        mongoTemplate.save(book);
    }
    @Test
    void findTest() {

        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }
}
