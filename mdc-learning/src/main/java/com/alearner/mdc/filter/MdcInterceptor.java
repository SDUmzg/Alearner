package com.alearner.mdc.filter;

import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mzg on 2018/8/29.
 */
public class MdcInterceptor extends HandlerInterceptorAdapter {

    private static final String REQUEST_ID = "uuid";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取uuid
        String uuid = request.getHeader(REQUEST_ID);
        // 设置MDC
        MDC.put(REQUEST_ID,uuid);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        // 请求结束后，清空MDC
        MDC.clear();
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
