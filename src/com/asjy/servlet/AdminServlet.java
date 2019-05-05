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
		// TODO 接值
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//1.非空校验,判断用户名和密码是否为空
		if("".equals(name)) {
			//发送错误信息到画面
			String msg = "账户名不能为空";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);	
			return;
		}
		if("".equals(password)) {
			String msg = "密码不能为空";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);	
			return;
		}
		//2.格式校验
		//帐号：前两位英文，总长度4-16位
		//密码：前两位英文，总长度5-10位
		String nameReg="[a-zA-Z]{2}[a-zA-Z0-9]{2,14}";
		String passwordReg="[a-zA-Z]{2}[a-zA-Z0-9]{3,8}";
		if(!name.matches(nameReg)) {
			String msg = "帐号格式错误";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);
			return;
		}
		if(!password.matches(passwordReg)) {
			String msg = "密码格式错误";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);
			return;
		}
		//有效性校验，判断是否存在，调用查询方法
		//第一步，传参
		Admin admin=new Admin();
		admin.setName(name);
		admin.setPassword(password);
		//service层使用
		AdminService a1=new AdminServiceImpl();
		Admin result = a1.login(admin);
		if(result == null) {
			String msg = "账户名或密码错误";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);
			return;
		}
		
		//登录成功后要在每个页面展示用户名
		HttpSession session = request.getSession();
		session.setAttribute("user", result);
		
		//若以上均不满足则判断登录成功
		//登录成功返回到首页，传到用户后台，通过该后台传送到首页，并显示所有用户信息
		request.getRequestDispatcher("CustomerServlet?flag=goIndex").forward(request, response);
		
		
	}

}
