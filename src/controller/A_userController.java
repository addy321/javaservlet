
package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.A_user;
import entity.ResultModel;
import dao.A_userDao;

@WebServlet("/a_user/*")
public class A_userController extends BaseServlet {

    private static final long serialVersionUID = 1L;

    private final A_userDao a_userDao = new A_userDao();

    public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<A_user> a_users = a_userDao.queryAll(null, null);
            writeValue(new ResultUtil().getSuccessResult(a_users), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void queryData(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = (String) request.getAttribute("id");
            A_user a_user = a_userDao.queryData(id);
            writeValue(new ResultUtil().getSuccessResult(a_user), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addData(HttpServletRequest request, HttpServletResponse response) {
        try {
            A_user a_user = new A_user();
            a_user = getKevs(request, response, A_user.class);
            int res = a_userDao.save(a_user);

            ResultUtil rUtil = new ResultUtil();
            ResultModel resultModel = res > 0 ? rUtil.getSuccessResult() : rUtil.getFailResult();
            writeValue(resultModel, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpData(HttpServletRequest request, HttpServletResponse response) {
        try {
            A_user a_user = new A_user();
            a_user = getKevs(request, response, A_user.class);
            int res = a_userDao.update(a_user);
            ResultUtil rUtil = new ResultUtil();
            ResultModel resultModel = res > 0 ? rUtil.getSuccessResult() : rUtil.getFailResult();
            writeValue(resultModel, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DelData(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = (String) request.getAttribute("id");
            int res = a_userDao.delete(id);
            ResultUtil rUtil = new ResultUtil();
            ResultModel resultModel = res > 0 ? rUtil.getSuccessResult() : rUtil.getFailResult();
            writeValue(resultModel, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
            