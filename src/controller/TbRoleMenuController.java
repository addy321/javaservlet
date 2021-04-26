
package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbRoleMenu;
import entity.ResultModel;
import dao.TbRoleMenuDao;

@WebServlet("/tb_role_menu/*")
public class TbRoleMenuController extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private final TbRoleMenuDao tb_role_menuDao = new TbRoleMenuDao();

	public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<TbRoleMenu> tb_role_menus = tb_role_menuDao.queryAll(null, null);
			writeValue(new ResultUtil().getSuccessResult(tb_role_menus),response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void queryData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = (String) request.getAttribute("id");
			TbRoleMenu tb_role_menu = tb_role_menuDao.queryData(id);
			writeValue(new ResultUtil().getSuccessResult(tb_role_menu), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbRoleMenu tb_role_menu = new TbRoleMenu();
			tb_role_menu = getKevs(request, response, TbRoleMenu.class);
			int res = tb_role_menuDao.save(tb_role_menu);
			
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbRoleMenu tb_role_menu = new TbRoleMenu();
			tb_role_menu = getKevs(request, response, TbRoleMenu.class);
			int res = tb_role_menuDao.update(tb_role_menu);
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
			int res = tb_role_menuDao.delete(id);
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
            