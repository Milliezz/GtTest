package com.asjy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asjy.model.Customer;
import com.asjy.model.Register;
import com.asjy.service.CustomerService;
import com.asjy.service.RegisterService;
import com.asjy.service.impl.CustomerServiceImpl;
import com.asjy.service.impl.RegisterServiceImpl;

/**
 * Servlet implementation class CusRegisterServlet
 */
@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if("goLogin".equals(flag)) {
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String flag=request.getParameter("flag");
		if("doRegister".equals(flag)) {
			doRegister(request,response);
		}
		
	}

	private void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ���ô˷����������ע����Ϣ������֤�Ƿ��������
		//��ֵ���������ݣ�����֤
		String no=request.getParameter("no");
		String pw=request.getParameter("pw");
		String conpw=request.getParameter("conpw");
		//1.�ǿ���֤
		if("".equals(no)) {
			request.setAttribute("msg", "�ֻ��Ų���Ϊ��");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
			return;
		}
		if("".equals(pw)||"".equals(conpw)) {
			request.setAttribute("msg", "�����ȷ�����벻��Ϊ��");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
			return;
		}
		//��ʽ��֤
		String reg="[0-9]{11}";
		String rega="[A-Za-z0-9]{6}";
		if(!no.matches(reg)) {
			//�û�����ʽ����
			request.setAttribute("msg", "�ֻ��Ÿ�ʽ����");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
			return;
		}
		if(!pw.matches(rega)) {
			request.setAttribute("msg", "�����ʽ����");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
			return;
		}
        if(!pw.equalsIgnoreCase(conpw)){
        	request.setAttribute("msg", "�����ȷ�����벻ƥ��");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
			return;
        }
        //������ӷ���
     // TODO ��ʼִ����ӹ���
     		//1.2 �����������������
     		Register register=new Register();
     		register.setNo(no);
     		register.setPw(pw);
     		//2. ����service���еķ���(ҵ���)
     		RegisterService r1 = new RegisterServiceImpl();
     		boolean result = r1.insertRegister(register);
     		//ctrl + 2 ѡ��ڶ������Զ���ȡ����ֵ
     		//3. �ж��Ƿ���ӳɹ���
     		if(result == false) {
    			String msg = "�ֻ��Ż��������";
    			request.setAttribute("msg", msg);
    			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
    			return;
    		}
     		//���Ͼ�����
     		request.setAttribute("register", register);
			request.getRequestDispatcher("customer_registerok.jsp").forward(request, response);
	}
}
