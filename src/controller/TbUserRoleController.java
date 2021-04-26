
package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbUserRole;
import entity.ResultModel;
import dao.TbUserRoleDao;

@WebServlet("/tb_user_role/*")
public class TbUserRoleController extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private final TbUserRoleDao tb_user_roleDao = new TbUserRoleDao();

	public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<TbUserRole> tb_user_roles = tb_user_roleDao.queryAll(null, null);
			writeValue(new ResultUtil().getSuccessResult(tb_user_roles),response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void queryData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = (String) request.getAttribute("id");
			TbUserRole tb_user_role = tb_user_roleDao.queryData(id);
			writeValue(new ResultUtil().getSuccessResult(tb_user_role), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbUserRole tb_user_role = new TbUserRole();
			tb_user_role = getKevs(request, response, TbUserRole.class);
			int res = tb_user_roleDao.save(tb_user_role);
			
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbUserRole tb_user_role = new TbUserRole();
			tb_user_role = getKevs(request, response, TbUserRole.class);
			int res = tb_user_roleDao.update(tb_user_role);
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
			int res = tb_user_roleDao.delete(id);
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
            