package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;

import tool.ObjectTool;

public class BaseServlet extends HttpServlet {

    /**
     * 封装 Servlet
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");

        String url = req.getRequestURI(); // 这个方法只能获得不包含参数的请求url，且只包含相对路径
        url = url.substring(url.lastIndexOf("/") + 1);

        if (url == null || url.isEmpty()) {
            throw new RuntimeException("method parameter does not exist");
        }

        Class<? extends BaseServlet> c = this.getClass();// 获得当前类的Class对象
        Method method = null;
        try {
            method = c.getMethod(url, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            method.invoke(this, req, resp);// 反射调用方法
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 封装跳转
    public void showView(String path, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher(path).forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 封装重定向
    public void redirecturl(String path, HttpServletResponse response) {
        try {
            response.sendRedirect(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 转化请求参数
     *
     * @param object 要转换的对象
     */
    public <T> T getKevs(HttpServletRequest request, HttpServletResponse response, Class<T> obj) {
        try {
            T object = obj.newInstance();
            for (String field : ObjectTool.getKevs(object)) {
                String value = request.getParameter(field);
                if (value != null) {
                    ObjectTool.invokeSet(object, field, value);
                }
            }
            return object;
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 直接将传入的对象序列化为json，并且写回客户端
     *
     * @param obj
     */
    public void writeValue(Object obj, HttpServletResponse response) {
        // 通过流的形式发送json数据
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String res = JSON.toJSONString(obj);
        out.write(res);// 通过流的形式响应
    }

}
