package com.asjy.service;

import com.asjy.model.Register;

public interface RegisterService {
	//定义添加 --> 需要定义5个参数 --> 压缩成一个参数(实体类对象！)
		boolean insertRegister(Register register);
}
