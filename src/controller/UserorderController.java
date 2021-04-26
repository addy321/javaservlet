
package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Userorder;
import entity.ResultModel;
import dao.UserorderDao;

@WebServlet("/userorder/*")
public class UserorderController extends BaseServlet {

    private static final long serialVersionUID = 1L;

    private final UserorderDao userorderDao = new UserorderDao();

    public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Userorder> userorders = userorderDao.queryAll(null, null);
            writeValue(new ResultUtil().getSuccessResult(userorders), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void queryData(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = (String) request.getAttribute("id");
            Userorder userorder = userorderDao.queryData(id);
            writeValue(new ResultUtil().getSuccessResult(userorder), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addData(HttpServletRequest request, HttpServletResponse response) {
        try {
            Userorder userorder = new Userorder();
            userorder = getKevs(request, response, Userorder.class);
            int res = userorderDao.save(userorder);

            ResultUtil rUtil = new ResultUtil();
            ResultModel resultModel = res > 0 ? rUtil.getSuccessResult() : rUtil.getFailResult();
            writeValue(resultModel, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpData(HttpServletRequest request, HttpServletResponse response) {
        try {
            Userorder userorder = new Userorder();
            userorder = getKevs(request, response, Userorder.class);
            int res = userorderDao.update(userorder);
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
            int res = userorderDao.delete(id);
            ResultUtil rUtil = new ResultUtil();
            ResultModel resultModel = res > 0 ? rUtil.getSuccessResult() : rUtil.getFailResult();
            writeValue(resultModel, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
            