package com.asjy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.asjy.dao.CustomerDao;
import com.asjy.dao.CustomerDaoA;
import com.asjy.model.Customer;
import com.asjy.service.CustomerService;
import com.asjy.util.MybatisUtil;

public class CustomerServiceImpl implements CustomerService{
	//业务层不需再写sql语句，只需调用dao中的功能
	@Override
	public boolean insertCustomer(Customer customer) {
		// TODO 执行添加功能！
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CustomerDaoA mapper = sqlSession.getMapper(CustomerDaoA.class);
		int result = mapper.insertCustomer(customer);
		if(result > 0) {
			//添加成功，result返回的是受影响行数
			sqlSession.commit();
		}else {
			//添加失败，回滚
			sqlSession.rollback();
		}
		sqlSession.close();
		return result > 0 ? true:false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO 执行删除功能，通过id来进行删除
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CustomerDaoA mapper = sqlSession.getMapper(CustomerDaoA.class);
		int result = mapper.deleteCustomer(id);
		if(result > 0) {
			//添加成功，result返回的是受影响行数
			sqlSession.commit();
		}else {
			//添加失败，回滚
			sqlSession.rollback();
		}
		sqlSession.close();
		return result > 0 ? true:false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO 执行修改功能，通过id来修改用户信息
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CustomerDaoA mapper = sqlSession.getMapper(CustomerDaoA.class);
		int result = mapper.updateCustomer(customer);
		if(result>0) {
			//修改成功，result返回的是受影响行数
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		return result>0 ? true:false;
	}

	@Override
	public List<Customer> findCustomer() {
		// TODO 全查询功能
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CustomerDaoA mapper = sqlSession.getMapper(CustomerDaoA.class);
		List<Customer> customerList = mapper.findCustomer();
		return customerList;
	}

	@Override
	public Customer findCustomerById(int id) {
		// TODO 查询id
		String sql ="select customer_id,customer_name,customer_points,customer_tel,customer_sex from tbl_customer where customer_id=?";
//		return CustomerDao.query(sql, id).get(0);
		List<Customer> cusList = CustomerDao.query(sql, id);
		if (cusList.size() > 0) {
			//验证数据是否存在
			return cusList.get(0);
		}
		return null;
	}

	@Override
	public List<Customer> findCustomerByIdAndTel(String id, String tel) {
		// TODO 重写模糊查询的方法
		//通过id和手机号进行模糊搜索
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CustomerDaoA mapper = sqlSession.getMapper(CustomerDaoA.class);
		List<Customer> customerList = mapper.findCustomerByIdAndTel(id, tel);
		return customerList;
	}
}
