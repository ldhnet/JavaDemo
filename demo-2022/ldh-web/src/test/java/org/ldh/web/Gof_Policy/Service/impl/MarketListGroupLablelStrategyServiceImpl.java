package org.ldh.web.Gof_Policy.Service.impl;

import org.ldh.web.Gof_Policy.Parameter;
import org.ldh.web.Gof_Policy.Service.IGroupLabelStrategyService;

public class MarketListGroupLablelStrategyServiceImpl implements IGroupLabelStrategyService {

    //对应市场营销类型的条件分支里面的实现
    public boolean processBiz(Parameter dto){
        boolean isMarketListSwitchClose=false;
        //开关关闭不请求
        if(isMarketListSwitchClose){
            return false;
        }

        //请求只有一条记录的话
        if(dto.getReqNum()==1){
            //调用营销点查接口
            //return singleRemoteMarketinvoke(dto);

            return false;
        }else if(dto.getReqNum()>1){
            //调用营销批量接口
            //return batchRemoteMarketinvoke(dto);
            return false;
        }
        return false;
    }

   public String getType(){
        return "market_list";
    }
}