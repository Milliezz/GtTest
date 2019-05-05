package com.asjy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asjy.model.Customer;

public interface CustomerDaoA {
	//�ӿ��ж���淶������Mybatis��Ҫִ��ʲô����Ĺ���
	//������� --> ��Ҫ����5������ --> ѹ����һ������(ʵ�������)
	//��ʼ����Mybatis����ͨ��xml�������������
	int insertCustomer(Customer customer);
	
	//����ɾ��
	int deleteCustomer(int id);
	
	//�����޸�
	int updateCustomer(Customer customer);
	
	//�����ѯ
	List<Customer> findCustomer();

	//��ѯid
	Customer findCustomerById(int id);
	
	//ģ����ѯ
	List<Customer> findCustomerByIdAndTel(@Param("id") String id,@Param("tel") String tel);
}
