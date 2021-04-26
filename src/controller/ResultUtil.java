package controller;

import entity.ResultModel;

public class ResultUtil {

    // 两个返回的状态
    private static final Boolean SUCCESS = true;
    private static final Boolean Fail = false;
    // 成功与失败时的消息
    private static final String msg1 = "成功";
    private static final String msg2 = "失败";

    private static ResultModel ResultModel;

    // 成功
    public ResultModel getSuccessResult() {
        ResultModel = new ResultModel();
        ResultModel.setMessage(msg1);
        ResultModel.setFlag(SUCCESS);
        return ResultModel;

    }

    // 成功，附带自定义数据
    public ResultModel getSuccessResult(String message) {
        ResultModel = new ResultModel();
        ResultModel.setMessage(message);
        ResultModel.setFlag(SUCCESS);
        return ResultModel;

    }

    // 成功，附带额外数据
    public ResultModel getSuccessResult(Object data) {
        ResultModel = new ResultModel();
        ResultModel.setData(data);
        ResultModel.setMessage(msg1);
        ResultModel.setFlag(SUCCESS);
        return ResultModel;
    }

    // 成功，自定义消息及数据
    public ResultModel getSuccessResult(String message, Object data) {
        ResultModel = new ResultModel();
        ResultModel.setData(data);
        ResultModel.setMessage(message);
        ResultModel.setFlag(SUCCESS);
        return ResultModel;
    }

    // 失败
    public ResultModel getFailResult() {
        ResultModel = new ResultModel();
        ResultModel.setMessage(msg2);
        ResultModel.setFlag(Fail);
        return ResultModel;
    }

    // 失败，附带消息
    public ResultModel getFailResult(String message) {
        ResultModel = new ResultModel();
        ResultModel.setMessage(message);
        ResultModel.setFlag(Fail);
        return ResultModel;
    }

    // 失败，自定义消息及数据
    public ResultModel getFailResult(String message, Object data) {
        ResultModel = new ResultModel();
        ResultModel.setData(data);
        ResultModel.setMessage(message);
        ResultModel.setFlag(Fail);
        return ResultModel;
    }

    // 自定义创建
    public ResultModel getFreeResult(Boolean code, String message, Object data) {
        ResultModel = new ResultModel();
        ResultModel.setData(data);
        ResultModel.setMessage(message);
        ResultModel.setFlag(code);
        return ResultModel;
    }
}
