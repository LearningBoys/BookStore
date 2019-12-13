package com.bookstore.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class EncodingFilterServletRequestWrapper extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    //保证转码一次
    private boolean hasEncode;

    public EncodingFilterServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    //重写getParameterMap方法
    @Override
    public Map getParameterMap() {
        //获取数据提交方式
        String method = request.getMethod();
        if (method.equalsIgnoreCase("post")) {
            try {
                request.setCharacterEncoding("UTF-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else if (method.equalsIgnoreCase("get")) {
            //提交数据方式为get
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (!hasEncode) {   //确保get手动编码逻辑只运行一次
                for (String parameterName : parameterMap.keySet()) {
                    String[] values = parameterMap.get(parameterName);
                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            //将"ISO-8859-1"-->"UTF-8"
                            try {
                                values[i] = new String(values[i].getBytes("ISO-8859-1"), "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                hasEncode = true;
            }
            return parameterMap;
        }
        return super.getParameterMap();
    }

    @Override
    public String getParameter(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        if (values == null) {
            return null;
        }
        return values[0];   //返回第一个数据
    }

    @Override
    public String[] getParameterValues(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        return values;
    }
}

