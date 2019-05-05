package com.asjy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asjy.model.Customer;

public interface CustomerDaoA {
	//接口中定义规范，告诉Mybatis需要执行什么代理的功能
	//定义添加 --> 需要定义5个参数 --> 压缩成一个参数(实体类对象！)
	//开始进行Mybatis代理，通过xml声明代理的内容
	int insertCustomer(Customer customer);
	
	//定义删除
	int deleteCustomer(int id);
	
	//定义修改
	int updateCustomer(Customer customer);
	
	//定义查询
	List<Customer> findCustomer();

	//查询id
	Customer findCustomerById(int id);
	
	//模糊查询
	List<Customer> findCustomerByIdAndTel(@Param("id") String id,@Param("tel") String tel);
}
