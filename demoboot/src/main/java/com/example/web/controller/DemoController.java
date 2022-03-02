package com.example.web.controller;

import com.example.mapper.SysUserMapper;
import com.example.service.IUserInterface;
import com.example.web.models.Questions;
import com.example.web.models.ReportAllList;
import com.example.web.models.SysUser;
import com.example.web.models.TitleList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@RequestMapping("/demo")
@Controller
@Slf4j
public class DemoController {
    @Autowired
    private SysUserMapper SysUserMapper;

    @Autowired
    private IUserInterface UserInterface;

    @RequestMapping("/a")
    public String index(Model model) {

        List<SysUser> userList = UserInterface.selectUserList();

        SysUser _user = SysUserMapper.selectUserById(1);
        log.info(_user.getUsername());
        log.info(_user.getCreatetime().toString());
        log.info(_user.toString());
        model.addAttribute("username", _user.getUsername());
        model.addAttribute("pwd", _user.getPassword());
        return "index";
    }

    /**
     *

    //这是第1层
    public static ReportAllList changeListValue(ReportAllList paramList1, ReportAllList paramList3) {

        paramList1 =paramList3;//这里不正确，意思是把 paramList3  赋值给 paramList1
        paramList1.Questions= changeQuestionsListValue(paramList1.Questions,paramList3.Questions); //这是第2层
        return  paramList1;
    }
    //第2层 数据交换
    public static List<Questions> changeQuestionsListValue(List<Questions> paramList1, List<Questions> paramList3) {

        for (int i=0;i<=paramList3.stream().count();i++)
        {
            paramList1[i]=paramList3[i];//这里不正确，意思是把 paramList3[i] 赋值给 paramList1[i]
            paramList1[i].TitleList= changeQuestionsListValue(paramList1[i].TitleList,paramList3[i].TitleList);//这是第3层
        }

        return  paramList1;
    }
    //第3层 数据交换
    public static List<TitleList> changeQuestionsListValue(List<TitleList> paramList1, List<TitleList> paramList3) {

        for (int i=0;i<=paramList3.stream().count();i++)
        {
            paramList1[i]=paramList3[i];//这里不正确，意思是把 paramList3[i] 赋值给 paramList1[i]
        }

        return  paramList1;
    }
     */
}
