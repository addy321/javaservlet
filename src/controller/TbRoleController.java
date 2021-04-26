
package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbRole;
import entity.ResultModel;
import dao.TbRoleDao;

@WebServlet("/tb_role/*")
public class TbRoleController extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private final TbRoleDao tb_roleDao = new TbRoleDao();

	public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<TbRole> tb_roles = tb_roleDao.queryAll(null, null);
			writeValue(new ResultUtil().getSuccessResult(tb_roles),response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void queryData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = (String) request.getAttribute("id");
			TbRole tb_role = tb_roleDao.queryData(id);
			writeValue(new ResultUtil().getSuccessResult(tb_role), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbRole tb_role = new TbRole();
			tb_role = getKevs(request, response, TbRole.class);
			int res = tb_roleDao.save(tb_role);
			
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbRole tb_role = new TbRole();
			tb_role = getKevs(request, response, TbRole.class);
			int res = tb_roleDao.update(tb_role);
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
			int res = tb_roleDao.delete(id);
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
            