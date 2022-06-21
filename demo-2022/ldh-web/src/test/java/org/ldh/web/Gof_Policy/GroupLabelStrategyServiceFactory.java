package org.ldh.web.Gof_Policy;

import org.ldh.web.Gof_Policy.Service.IGroupLabelStrategyService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GroupLabelStrategyServiceFactory implements ApplicationContextAware {

    //存放对应的类型和实现类
    private Map<String, IGroupLabelStrategyService> map = new ConcurrentHashMap<>();

    //策略实现类注入到map
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IGroupLabelStrategyService> tempMap = applicationContext.getBeansOfType(IGroupLabelStrategyService.class);

//        tmepMap.values().forEach(strategyService -> map.put(strategyService.getType(), strategyService));
    }

    //工厂方法
    public boolean processBiz(Parameter dto){

        //根据不同类型，获取不同的实现类
        IGroupLabelStrategyService groupLabelStrategyService= map.get(dto.getType());

        return groupLabelStrategyService.processBiz(dto);
    }
}
