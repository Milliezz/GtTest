package com.asjy.service;

import java.util.List;

import com.asjy.model.Customer;

public interface CustomerService {

	//�ӿ��ж���淶
	//������� --> ��Ҫ����5������ --> ѹ����һ������(ʵ�������)
	boolean insertCustomer(Customer customer);
	
	//����ɾ��
	boolean deleteCustomer(int id);
	
	//�����޸�
	boolean updateCustomer(Customer customer);
	
	//�����ѯ
	List<Customer> findCustomer();

	//��ѯid
	Customer findCustomerById(int id);
	
	//ģ����ѯ
	List<Customer> findCustomerByIdAndTel(String id,String tel);
	
	
}
