package org.ldh.web.Gof_Policy.Service;

import org.ldh.web.Gof_Policy.Parameter;

public interface IGroupLabelStrategyService {

    //这个方法对应策略实现类的具体实现
    boolean processBiz(Parameter dto);

    //这个方法就是策略类的类型，也就是对应```if...else```条件判断的类型
    String getType();
}