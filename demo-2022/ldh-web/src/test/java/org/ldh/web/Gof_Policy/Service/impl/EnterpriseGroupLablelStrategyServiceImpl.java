package org.ldh.web.Gof_Policy.Service.impl;

import org.ldh.web.Gof_Policy.Parameter;
import org.ldh.web.Gof_Policy.Service.IGroupLabelStrategyService;

public class  EnterpriseGroupLablelStrategyServiceImpl implements IGroupLabelStrategyService {
    //对应企业客群类型的条件分支里面的实现
    public boolean processBiz(Parameter dto){
        boolean isEnterpriseSwitchClose=false;
        //开关关闭不请求
        if(isEnterpriseSwitchClose){
            return false;
        }
        //请求只有一条记录的话
        if(dto.getReqNum()==1){
            //调用大数据的点查接口
            return true;//singleRemoteEOIinvoke(dto);
        }else if(dto.getReqNum()>1){

            //调用远程大数据批量接口
            return true;//batchRemoteEOIinvoke(dto);
        }
        return  true;
    }

    //对应企业类型
    public String getType(){
        return "enterprise";
    }
}