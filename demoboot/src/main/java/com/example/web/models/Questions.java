package com.example.web.models;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*
 *   大标题下的表单问题bean
 */
@Data
public class Questions implements Serializable {
    private String id;//问题的id
    private String memo;//描述
    private String name;//问题的名字
    private String isRequired;//是否必填 0非必填 1必填
    private String selectItem;//多选的选项
    private String type;//问题的类型
    private String value;//问题的答案
    private String serialNumber;//序号（用水监管和用水报告）
    private ArrayList<TitleList> nodes;//大标题下的表单数据list数组
    private ArrayList<oaResearchDdList> oaResearchDdLists = new ArrayList<>();//多选，单选答案数据
}
