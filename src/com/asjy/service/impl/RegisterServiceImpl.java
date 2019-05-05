package com.asjy.service.impl;

import com.asjy.dao.RegisterDao;
import com.asjy.model.Register;
import com.asjy.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{

	@Override
	public boolean insertRegister(Register register) {
		// TODO 执行添加功能！
		String sql = "insert into tbl_register(register_no,register_password) values(?,?)";
		return RegisterDao.update(sql, register.getNo(),register.getPw());
	}

}
