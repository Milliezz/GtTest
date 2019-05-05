package com.asjy.service.impl;

import java.util.List;

import com.asjy.dao.AdminDao;
import com.asjy.model.Admin;
import com.asjy.service.AdminService;

public class AdminServiceImpl implements AdminService{

	@Override
	public Admin login(Admin admin) {
		String sql="select admin_id,admin_name,admin_password from tbl_admin where admin_name=? and admin_password=?";
		List<Admin> adminList = AdminDao.query(sql,admin.getName(),admin.getPassword());
		if(adminList!=null&adminList.size() > 0) {
			return adminList.get(0);
		}
		return null;
	}
	

}
