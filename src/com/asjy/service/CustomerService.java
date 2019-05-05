package com.asjy.service;

import java.util.List;

import com.asjy.model.Customer;

public interface CustomerService {

	//接口中定义规范
	//定义添加 --> 需要定义5个参数 --> 压缩成一个参数(实体类对象！)
	boolean insertCustomer(Customer customer);
	
	//定义删除
	boolean deleteCustomer(int id);
	
	//定义修改
	boolean updateCustomer(Customer customer);
	
	//定义查询
	List<Customer> findCustomer();

	//查询id
	Customer findCustomerById(int id);
	
	//模糊查询
	List<Customer> findCustomerByIdAndTel(String id,String tel);
	
	
}
