package com.pyc.crowd.mvc.config;

import com.google.gson.Gson;
import com.pyc.crowd.util.CrowdUtil;
import com.pyc.crowd.util.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 彭远春
 * @create 2022-12-05 10:30
 */
@ControllerAdvice//表示当前类是一个基于注解的异常处理器类
public class CrowdExceptionResolver {

    // @ExceptionHandler(value = ArithmeticException.class)//将一个具体的异常类型和一个方法关联起来
    // public ModelAndView resolveMathException(NullPointerException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
    //     //1.判断您当前请求类型
    //     boolean judgeRequestType = CrowdUtil.judgeRequestType(request);
    //     //2.如果是ajax请求
    //     if (judgeRequestType){
    //         //3.创建ResultEntity对象
    //         ResultEntity<Object> resultEntity = ResultEntity.failed(e.getMessage());
    //         //4.创建Gson对象
    //         Gson gson = new Gson();
    //
    //         String json = gson.toJson(resultEntity);
    //         //将json字符串作为响应体返回给浏览器
    //         response.getWriter().write(json);
    //
    //         return null;
    //     }
    //
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.addObject("exception",e);
    //     modelAndView.setViewName("system-error");
    //     return modelAndView;
    // }

    /**
     *
     * @param e：实际捕获到的异常类型
     * @param request：当前请求对象
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)//将一个具体的异常类型和一个方法关联起来
    public ModelAndView resolveNullPointerException(NullPointerException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.判断您当前请求类型
        boolean judgeRequestType = CrowdUtil.judgeRequestType(request);
        //2.如果是ajax请求
        if (judgeRequestType){
            //3.创建ResultEntity对象
            ResultEntity<Object> resultEntity = ResultEntity.failed(e.getMessage());
            //4.创建Gson对象
            Gson gson = new Gson();

            String json = gson.toJson(resultEntity);
            //将json字符串作为响应体返回给浏览器
            response.getWriter().write(json);

            return null;
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.setViewName("system-error");
        return modelAndView;
    }

    // private ModelAndView commonResolve(String viewName,Exception exception,HttpServletRequest request,HttpServletResponse response){
    //     return null;
    // }
}
