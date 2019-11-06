package com.staryea.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by tangdy on 2019/1/22.
 */
public class MyLocaleResolve implements LocaleResolver {
    /**
     * 通过链接的方式来实现国际化，就是设置指定的localeResolve来实现，然后将此类注册进spring容器
     * springboot会进行判断 当前容器中是否有localeResolve，如果有自定义的就加载自定义的，如果没有就加载默认的
     * @param httpServletRequest
     * @return
     */
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale locale =Locale.getDefault();
        String parameter = httpServletRequest.getParameter("");//参数名称
        if(!StringUtils.isEmpty(parameter)){
            String[] split = parameter.split("");//用指定的分隔符来分隔传出的区域信息（前面是语言信息，后面是国家信息：例如：cn_ZH,en_US）
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}