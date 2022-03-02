package com.example.web.models;

import lombok.Data;

import java.util.ArrayList;

/*
 * 数据填报数据（多层数据）
 */
@Data
public class ReportAllList{
    private String id;//id
    private String name;//大标题(一个大标题是一页)
    private ArrayList<Questions> Questions;//大标题下的表单数据list数组
}
