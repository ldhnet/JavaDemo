package org.ldh.web.controller.ulits;

import lombok.Data;

@Data
public class OperationResult {
    private int code;
    private Object data;
    private String msg;
    public OperationResult(){}
    public OperationResult(int code)
    {
        this.code=code;
    }
    public OperationResult(int code,Object data)
    {
        this.code=code;
        this.data=data;
    }
    public OperationResult(int code,String msg)
    {
        this.code=code;
        this.msg=msg;
    }
}
//
//public  class CodeResult<T> {
//    private Boolean isSuccess;
//    private Integer code;
//    private String msg;
//    private T data;
//    public CodeResult(){
//
//    }
//    public static <T> CodeResult<T> newSuccessResult(T data) {
//        CodeResult<T> codeResult=new CodeResult<>();
//        codeResult.setCode(200);
//        codeResult.setIsSuccess(true);
//        codeResult.setMsg("操作成功");
//        codeResult.setData(data);
//        return codeResult;
//    }
//}