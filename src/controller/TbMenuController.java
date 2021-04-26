
package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbMenu;
import entity.ResultModel;
import dao.TbMenuDao;

@WebServlet("/tb_menu/*")
public class TbMenuController extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private final TbMenuDao tb_menuDao = new TbMenuDao();

	public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<TbMenu> tb_menus = tb_menuDao.queryAll(null, null);
			writeValue(new ResultUtil().getSuccessResult(tb_menus),response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void queryData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = (String) request.getAttribute("id");
			TbMenu tb_menu = tb_menuDao.queryData(id);
			writeValue(new ResultUtil().getSuccessResult(tb_menu), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbMenu tb_menu = new TbMenu();
			tb_menu = getKevs(request, response, TbMenu.class);
			int res = tb_menuDao.save(tb_menu);
			
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbMenu tb_menu = new TbMenu();
			tb_menu = getKevs(request, response, TbMenu.class);
			int res = tb_menuDao.update(tb_menu);
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DelData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = (String) request.getAttribute("id");
			int res = tb_menuDao.delete(id);
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
            