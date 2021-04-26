
package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Commodity;
import entity.ResultModel;
import dao.CommodityDao;

@WebServlet("/commodity/*")
public class CommodityController extends BaseServlet {

    private static final long serialVersionUID = 1L;

    private final CommodityDao commodityDao = new CommodityDao();

    public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Commodity> commoditys = commodityDao.queryAll(null, null);
            writeValue(new ResultUtil().getSuccessResult(commoditys), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void queryData(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = (String) request.getAttribute("id");
            Commodity commodity = commodityDao.queryData(id);
            writeValue(new ResultUtil().getSuccessResult(commodity), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addData(HttpServletRequest request, HttpServletResponse response) {
        try {
            Commodity commodity = new Commodity();
            commodity = getKevs(request, response, Commodity.class);
            int res = commodityDao.save(commodity);

            ResultUtil rUtil = new ResultUtil();
            ResultModel resultModel = res > 0 ? rUtil.getSuccessResult() : rUtil.getFailResult();
            writeValue(resultModel, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpData(HttpServletRequest request, HttpServletResponse response) {
        try {
            Commodity commodity = new Commodity();
            commodity = getKevs(request, response, Commodity.class);
            int res = commodityDao.update(commodity);
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
            int res = commodityDao.delete(id);
            ResultUtil rUtil = new ResultUtil();
            ResultModel resultModel = res > 0 ? rUtil.getSuccessResult() : rUtil.getFailResult();
            writeValue(resultModel, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
            