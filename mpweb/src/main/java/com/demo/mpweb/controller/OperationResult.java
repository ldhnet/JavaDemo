package com.demo.mpweb.controller;

import lombok.Data;

@Data
public class OperationResult {
    private Boolean flag;
    private Object data;

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
}
