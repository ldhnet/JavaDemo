package org.ldh.web.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.ldh.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    private ObjectMapper mapper=new ObjectMapper();

    @RequestMapping("/queryUserByNameFuzzy")
    public CodeResult queryUserByNameFuzzy(String userName)throws Exception{
        List<User> users = mapper.readValue(str, new TypeReference<List<User>>() {
        });
        return CodeResult.newSuccessResult(users);
    }

    @Data
    static
    class CodeResult<T> {
        private Boolean isSuccess;
        private Integer code;
        private String msg;
        private T data;
        public CodeResult(){

        }
        public static <T> CodeResult<T> newSuccessResult(T data) {
            CodeResult<T> codeResult=new CodeResult<>();
            codeResult.setCode(200);
            codeResult.setIsSuccess(true);
            codeResult.setMsg("操作成功");
            codeResult.setData(data);
            return codeResult;
        }
    }

    String str="[\n" +
            "\t{\n" +
            "\t\t\"id\": 1308,\n" +
            "\t\t\"userName\": \"胡斐\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": 1463,\n" +
            "\t\t\"userName\": \"胡俊华\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": 1478,\n" +
            "\t\t\"userName\": \"胡苡鑫\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": 1501,\n" +
            "\t\t\"userName\": \"胡新华\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": 1680,\n" +
            "\t\t\"userName\": \"胡振兴\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": 1711,\n" +
            "\t\t\"userName\": \"胡艳\"\n" +
            "\t},\t{\n" +
            "\t\t\"id\": 1519,\n" +
            "\t\t\"userName\": \"张浩良\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": 1530,\n" +
            "\t\t\"userName\": \"张煜晗\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": 1536,\n" +
            "\t\t\"userName\": \"张燕青\"\n" +
            "\t}]";
}
