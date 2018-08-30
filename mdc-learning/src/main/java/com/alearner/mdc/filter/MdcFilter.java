package com.alearner.mdc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by mzg on 2018/8/29.
 */
public class MdcFilter implements Filter{

    private static final Logger LOGGER = LoggerFactory.getLogger(MdcFilter.class);

    private static final String REQUEST_ID = "uuid";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("Set MDC ");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取MDC
        String uuid = httpServletRequest.getHeader(REQUEST_ID);
        // 设置MDC
        MDC.put(REQUEST_ID,uuid);
        try{
            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            // 一次请求之后，清空MDC
            MDC.clear();
        }
    }

    @Override
    public void destroy() {

    }
}
