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
	//ҵ��㲻����дsql��䣬ֻ�����dao�еĹ���
	@Override
	public boolean insertCustomer(Customer customer) {
		// TODO ִ����ӹ��ܣ�
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CustomerDaoA mapper = sqlSession.getMapper(CustomerDaoA.class);
		int result = mapper.insertCustomer(customer);
		if(result > 0) {
			//��ӳɹ���result���ص�����Ӱ������
			sqlSession.commit();
		}else {
			//���ʧ�ܣ��ع�
			sqlSession.rollback();
		}
		sqlSession.close();
		return result > 0 ? true:false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO ִ��ɾ�����ܣ�ͨ��id������ɾ��
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CustomerDaoA mapper = sqlSession.getMapper(CustomerDaoA.class);
		int result = mapper.deleteCustomer(id);
		if(result > 0) {
			//��ӳɹ���result���ص�����Ӱ������
			sqlSession.commit();
		}else {
			//���ʧ�ܣ��ع�
			sqlSession.rollback();
		}
		sqlSession.close();
		return result > 0 ? true:false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO ִ���޸Ĺ��ܣ�ͨ��id���޸��û���Ϣ
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CustomerDaoA mapper = sqlSession.getMapper(CustomerDaoA.class);
		int result = mapper.updateCustomer(customer);
		if(result>0) {
			//�޸ĳɹ���result���ص�����Ӱ������
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		return result>0 ? true:false;
	}

	@Override
	public List<Customer> findCustomer() {
		// TODO ȫ��ѯ����
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CustomerDaoA mapper = sqlSession.getMapper(CustomerDaoA.class);
		List<Customer> customerList = mapper.findCustomer();
		return customerList;
	}

	@Override
	public Customer findCustomerById(int id) {
		// TODO ��ѯid
		String sql ="select customer_id,customer_name,customer_points,customer_tel,customer_sex from tbl_customer where customer_id=?";
//		return CustomerDao.query(sql, id).get(0);
		List<Customer> cusList = CustomerDao.query(sql, id);
		if (cusList.size() > 0) {
			//��֤�����Ƿ����
			return cusList.get(0);
		}
		return null;
	}

	@Override
	public List<Customer> findCustomerByIdAndTel(String id, String tel) {
		// TODO ��дģ����ѯ�ķ���
		//ͨ��id���ֻ��Ž���ģ������
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CustomerDaoA mapper = sqlSession.getMapper(CustomerDaoA.class);
		List<Customer> customerList = mapper.findCustomerByIdAndTel(id, tel);
		return customerList;
	}
}
