package com.demo.mpweb.controller.ulits;

import lombok.Data;

@Data
public class OperationResult {
    private Boolean flag;
    private Object data;
    private String msg;
    public OperationResult(){}
    public OperationResult(Boolean flag)
    {
        this.flag=flag;
    }
    public OperationResult(Boolean flag,Object data)
    {
        this.flag=flag;
        this.data=data;
    }
    public OperationResult(Boolean flag,String msg)
    {
        this.flag=flag;
        this.msg=msg;
    }
}
