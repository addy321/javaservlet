
package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbUser;
import entity.ResultModel;
import dao.TbUserDao;

@WebServlet("/tb_user/*")
public class TbUserController extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private final TbUserDao tb_userDao = new TbUserDao();

	public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<TbUser> tb_users = tb_userDao.queryAll(null, null);
			writeValue(new ResultUtil().getSuccessResult(tb_users),response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void queryData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = (String) request.getAttribute("id");
			TbUser tb_user = tb_userDao.queryData(id);
			writeValue(new ResultUtil().getSuccessResult(tb_user), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbUser tb_user = new TbUser();
			tb_user = getKevs(request, response, TbUser.class);
			int res = tb_userDao.save(tb_user);
			
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpData(HttpServletRequest request, HttpServletResponse response) {
		try {
			TbUser tb_user = new TbUser();
			tb_user = getKevs(request, response, TbUser.class);
			int res = tb_userDao.update(tb_user);
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
			int res = tb_userDao.delete(id);
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
            