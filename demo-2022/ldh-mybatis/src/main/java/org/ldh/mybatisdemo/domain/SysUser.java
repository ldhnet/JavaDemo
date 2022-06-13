package org.ldh.mybatisdemo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    //@TableField("birth_day")
    private Date createtime;
    private Date updatetime;
}

