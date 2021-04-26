
package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Umessage;
import entity.ResultModel;
import dao.UmessageDao;

@WebServlet("/umessage/*")
public class UmessageController extends BaseServlet {

    private static final long serialVersionUID = 1L;

    private final UmessageDao umessageDao = new UmessageDao();

    public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Umessage> umessages = umessageDao.queryAll(null, null);
            writeValue(new ResultUtil().getSuccessResult(umessages), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void queryData(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = (String) request.getAttribute("id");
            Umessage umessage = umessageDao.queryData(id);
            writeValue(new ResultUtil().getSuccessResult(umessage), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addData(HttpServletRequest request, HttpServletResponse response) {
        try {
            Umessage umessage = new Umessage();
            umessage = getKevs(request, response, Umessage.class);
            int res = umessageDao.save(umessage);

            ResultUtil rUtil = new ResultUtil();
            ResultModel resultModel = res > 0 ? rUtil.getSuccessResult() : rUtil.getFailResult();
            writeValue(resultModel, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpData(HttpServletRequest request, HttpServletResponse response) {
        try {
            Umessage umessage = new Umessage();
            umessage = getKevs(request, response, Umessage.class);
            int res = umessageDao.update(umessage);
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
            int res = umessageDao.delete(id);
            ResultUtil rUtil = new ResultUtil();
            ResultModel resultModel = res > 0 ? rUtil.getSuccessResult() : rUtil.getFailResult();
            writeValue(resultModel, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
            