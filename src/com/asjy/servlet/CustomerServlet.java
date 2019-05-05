package com.asjy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asjy.model.Customer;
import com.asjy.service.CustomerService;
import com.asjy.service.impl.CustomerServiceImpl;
import com.sun.org.apache.xml.internal.security.c14n.implementations.Canonicalizer20010315;

import sun.awt.TracedEventQueue;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		 if("goIndex".equals(flag)) {
			 //���������������ҳ������ִ��������룬����goIndex���������¼��ť������
			 goIndex(request,response);
		}
		else if ("goInsert".equals(flag)) {
			//��ת����ӻ���,����goInsert����
			goInsert(request,response); 
		}
		else if("goDelete".equals(flag)) {
			//��ת��ɾ������,����goDelete����
			goDelete(request,response);
		}
		else if("goUpdate".equals(flag)) {
			//��ת���޸�ҳ��,����goUpdate����
			goUpdate(request,response);
		}
	}

	
	private void goIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ���������������ҳ���������
		//֤���ǵ����¼��ť�����ģ�ֱ����ת����ҳ
		//������ҳ����Ҫչʾ���ݿ����Ϣ������
		//1. ����Service���е�ȫ��ѯ
		CustomerService c1 = new CustomerServiceImpl();
		List<Customer> cusList = c1.findCustomer();
		//2. ���
		request.setAttribute("cusList", cusList);
		//3. ��תҳ�棨��ҳ��
		request.getRequestDispatcher("customer_index.jsp").forward(request, response);
	}
	
	private void goInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ת����ӻ���
		request.getRequestDispatcher("customer_insert.jsp").forward(request, response);
	}
	
	private void goDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ת��ɾ������
		//��ȡҪɾ����id��ֵ
		String id=request.getParameter("id");
		//��id���
		request.setAttribute("id", id);
		//��ת��ɾ������
		request.getRequestDispatcher("customer_delete.jsp").forward(request, response);
	}
	
	private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ת���޸Ļ���
		//��ȡҪ�޸ĵ�id��ֵ
		String id=request.getParameter("id");
		//����ͨ��id���ҵķ���
		CustomerService c2 = new CustomerServiceImpl();
		Customer c02= c2.findCustomerById(Integer.parseInt(id));
		request.setAttribute("id", c02.getId());
		request.setAttribute("name", c02.getName());
		request.setAttribute("points", c02.getPoints());
		request.setAttribute("tel", c02.getTel());
		request.setAttribute("sex", c02.getSex());
		//��ת���޸Ļ���
		request.getRequestDispatcher("customer_update.jsp").forward(request, response);
	}
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("goIndex".equals(flag)) {
			//ʵ����ת����ҳ����
			goIndex(request,response);
		}
		else if ("doInsert".equals(flag)) {
			//��ʼִ����ӹ���,�ɹ��Ļ���ת����ӳɹ����棬������ת�ص�ǰҳ��
			doInsert(request,response);
		}
		else if("doDelete".equals(flag)) {
			//ִ��ɾ�����ܣ�����ɹ���ת��ɾ���ɹ�����
			DoDelete(request,response);
			
			
		}
		else if("doUpdate".equals(flag)) {
			//��ʼִ���޸ĵĹ���
			doUpdate(request,response);
		}
		else if("doSearch".equals(flag)) {
			//ģ����ѯ������doSearch����
			doSearch(request,response);
		}
		
	}

	

	


	private void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ʼִ����ӹ���
		//1. ��ȡ�����еĲ�������
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String points = request.getParameter("points");
		String tel = request.getParameter("tel");
		String sex = request.getParameter("sex");
		//1.2 �����������������
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(id));
		customer.setName(name);
		customer.setPoints(Double.parseDouble(points));
		customer.setTel(tel);
		customer.setSex(sex);
		//2. ����service���еķ���(ҵ���)
		CustomerService c1 = new CustomerServiceImpl();
		boolean result = c1.insertCustomer(customer);
		//ctrl + 2 ѡ��ڶ������Զ���ȡ����ֵ
		//3. �ж��Ƿ���ӳɹ���
		if (result) {
			//��ת���ɹ�����
			//���ڳɹ�������Ҫչʾ��ӳɹ�����Ϣ������Ҫ�������ݵ�������
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("customer_insertok.jsp").forward(request, response);
		}else {
			//��ת����ӻ���
			request.getRequestDispatcher("customer_insert.jsp").forward(request, response);
		}
	}
	
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ʼִ���޸ĵĹ���
		//1. ��ȡ�����еĲ�������
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String points=request.getParameter("points");
		String tel=request.getParameter("tel");
		String sex=request.getParameter("sex");
		//1.2 �����������������
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(id));
		customer.setName(name);
		customer.setPoints(Double.parseDouble(points));
		customer.setTel(tel);
		customer.setSex(sex);
		//2. ����service���еķ���(ҵ���)
		CustomerService c1 = new CustomerServiceImpl();
		boolean result = c1.updateCustomer(customer);
		if(result) {
			//�޸ĳɹ�����ֵ����װ����
			request.setAttribute("customer", customer);
			//��ת���޸ĳɹ�����
			request.getRequestDispatcher("customer_updateok.jsp").forward(request, response);	
		}
		else {
			//��ת���޸Ļ���
			request.getRequestDispatcher("customer_update.jsp").forward(request, response);
		}
	}
	
	private void DoDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ִ��ɾ�����ܣ�����ɹ���ת��ɾ���ɹ�����
		String id=request.getParameter("id");
		CustomerService customer=new CustomerServiceImpl();
		Boolean result=customer.deleteCustomer(Integer.parseInt(id));
		if(result) {
			//���result��true����ת��ɾ���ɹ�ҳ��
			request.setAttribute("id", id);
			request.getRequestDispatcher("customer_deleteok.jsp").forward(request, response);
		}
		else {
			//��ת��ɾ������
			request.getRequestDispatcher("customer_delete.jsp").forward(request, response);
		}
	}
	
	private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ����ģ����ѯ
		//��ȡid�͵绰
		String id = request.getParameter("id");
		String tel = request.getParameter("tel");
		//����ģ����ѯ�ķ���
		CustomerService c1=new CustomerServiceImpl();
		List<Customer> cusList=c1.findCustomerByIdAndTel(id, tel);
		//��ֵ
		request.setAttribute("cusList", cusList);
		request.getRequestDispatcher("customer_index.jsp").forward(request, response);
	}
	
	
}
