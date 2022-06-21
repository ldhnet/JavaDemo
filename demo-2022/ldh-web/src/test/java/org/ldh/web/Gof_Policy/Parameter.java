package org.ldh.web.Gof_Policy;

import lombok.Data;

@Data
public class Parameter{
    int pageSize;
    int pageNo;
    int reqNum;
    String Type;
    //其他参数。
}