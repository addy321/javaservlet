
package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbTest;
import entity.ResultModel;
import dao.TbTestDao;

@WebServlet("/tb_test/*")
public class TbTestController extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private final TbTestDao tb_testDao = new TbTestDao();

	public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<TbTest> tb_tests = tb_testDao.queryAll(null, null);
			writeValue(new ResultUtil().getSuccessResult(tb_tests),response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void queryData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String Id = (String) request.getAttribute("Id");
			TbTest tb_test = tb_testDao.queryData(Id);
			writeValue(new ResultUtil().getSuccessResult(tb_test), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbTest tb_test = new TbTest();
			tb_test = getKevs(request, response, TbTest.class);
			int res = tb_testDao.save(tb_test);
			
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbTest tb_test = new TbTest();
			tb_test = getKevs(request, response, TbTest.class);
			int res = tb_testDao.update(tb_test);
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DelData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String Id = (String) request.getAttribute("Id");
			int res = tb_testDao.delete(Id);
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
            