package com.thg.accelerator.marcus.weatherApp.Component;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
//
//@Component
//public class IpFilter implements Filter {
//
//    @Value("${allowed.ips}")
//    private String allowedIps;
//
//    private List<String> allowedIpList;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        allowedIpList = Arrays.asList(allowedIps.split(","));
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        String clientIp = request.getRemoteAddr();
//        System.out.println(clientIp);
//        if (allowedIpList.contains(clientIp)) {
//            chain.doFilter(request, response);
//        } else {
//            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        }
//    }
//
//    @Override
//    public void destroy() {
//    }
//}

