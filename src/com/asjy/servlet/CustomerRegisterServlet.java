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
		// TODO 调用此方法进行添加注册信息，并验证是否符合条件
		//传值，接收数据，并验证
		String no=request.getParameter("no");
		String pw=request.getParameter("pw");
		String conpw=request.getParameter("conpw");
		//1.非空验证
		if("".equals(no)) {
			request.setAttribute("msg", "手机号不能为空");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
			return;
		}
		if("".equals(pw)||"".equals(conpw)) {
			request.setAttribute("msg", "密码或确认密码不能为空");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
			return;
		}
		//格式验证
		String reg="[0-9]{11}";
		String rega="[A-Za-z0-9]{6}";
		if(!no.matches(reg)) {
			//用户名格式错误
			request.setAttribute("msg", "手机号格式错误");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
			return;
		}
		if(!pw.matches(rega)) {
			request.setAttribute("msg", "密码格式错误");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
			return;
		}
        if(!pw.equalsIgnoreCase(conpw)){
        	request.setAttribute("msg", "密码和确认密码不匹配");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
			return;
        }
        //调用添加方法
     // TODO 开始执行添加功能
     		//1.2 将参数打包到对象中
     		Register register=new Register();
     		register.setNo(no);
     		register.setPw(pw);
     		//2. 调用service层中的方法(业务层)
     		RegisterService r1 = new RegisterServiceImpl();
     		boolean result = r1.insertRegister(register);
     		//ctrl + 2 选择第二个：自动接取返回值
     		//3. 判断是否添加成功！
     		if(result == false) {
    			String msg = "手机号或密码错误";
    			request.setAttribute("msg", msg);
    			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
    			return;
    		}
     		//以上均满足
     		request.setAttribute("register", register);
			request.getRequestDispatcher("customer_registerok.jsp").forward(request, response);
	}
}
