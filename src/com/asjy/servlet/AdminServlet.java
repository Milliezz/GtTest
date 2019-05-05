package com.asjy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asjy.model.Admin;
import com.asjy.service.AdminService;
import com.asjy.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if("goRegister".equals(flag)) {
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String flag=request.getParameter("flag");
		if("doLogin".equals(flag)) {
			doLogin(request,response);
		}
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ֵ
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//1.�ǿ�У��,�ж��û����������Ƿ�Ϊ��
		if("".equals(name)) {
			//���ʹ�����Ϣ������
			String msg = "�˻�������Ϊ��";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);	
			return;
		}
		if("".equals(password)) {
			String msg = "���벻��Ϊ��";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);	
			return;
		}
		//2.��ʽУ��
		//�ʺţ�ǰ��λӢ�ģ��ܳ���4-16λ
		//���룺ǰ��λӢ�ģ��ܳ���5-10λ
		String nameReg="[a-zA-Z]{2}[a-zA-Z0-9]{2,14}";
		String passwordReg="[a-zA-Z]{2}[a-zA-Z0-9]{3,8}";
		if(!name.matches(nameReg)) {
			String msg = "�ʺŸ�ʽ����";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);
			return;
		}
		if(!password.matches(passwordReg)) {
			String msg = "�����ʽ����";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);
			return;
		}
		//��Ч��У�飬�ж��Ƿ���ڣ����ò�ѯ����
		//��һ��������
		Admin admin=new Admin();
		admin.setName(name);
		admin.setPassword(password);
		//service��ʹ��
		AdminService a1=new AdminServiceImpl();
		Admin result = a1.login(admin);
		if(result == null) {
			String msg = "�˻������������";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);
			return;
		}
		
		//��¼�ɹ���Ҫ��ÿ��ҳ��չʾ�û���
		HttpSession session = request.getSession();
		session.setAttribute("user", result);
		
		//�����Ͼ����������жϵ�¼�ɹ�
		//��¼�ɹ����ص���ҳ�������û���̨��ͨ���ú�̨���͵���ҳ������ʾ�����û���Ϣ
		request.getRequestDispatcher("CustomerServlet?flag=goIndex").forward(request, response);
		
		
	}

}
