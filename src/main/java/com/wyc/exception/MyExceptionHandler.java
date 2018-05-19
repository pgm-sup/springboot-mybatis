package com.wyc.exception;

import com.wyc.utils.HaimaJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author haima
 */
@ControllerAdvice
public class MyExceptionHandler {

    public static final String ERROR_VIEW = "error";

    // @ExceptionHandler(value = Exception.class)
    // public Object errorHandler(HttpServletRequest reqest, HttpServletResponse
    // response, Exception e) throws Exception {
    //
    // e.printStackTrace();
    //
    // ModelAndView mav = new ModelAndView();
    // mav.addObject("exception", e);
    // mav.addObject("url", reqest.getRequestURL());
    // mav.setViewName(ERROR_VIEW);
    // return mav;
    // }

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception {

        e.printStackTrace();
        if (isAjax(req)) {
            return HaimaJSONResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", req.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    /**
     *
     * @Title: MyExceptionHandler.java
     * @Package com.wyc.exception
     * @Description: 判断是否是ajax请求 Copyright: Copyright (c) 2018
     *               Company:wyc
     *
     * @author haima
     * @date 2018年04月09日 下午1:40:39
     * @version V1.0
     */
    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
    }
}
