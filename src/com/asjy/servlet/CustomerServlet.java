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
			 //点击超链接跳回首页都可以执行这个代码，调用goIndex方法点击登录按钮进来的
			 goIndex(request,response);
		}
		else if ("goInsert".equals(flag)) {
			//跳转到添加画面,调用goInsert方法
			goInsert(request,response); 
		}
		else if("goDelete".equals(flag)) {
			//跳转到删除画面,调用goDelete方法
			goDelete(request,response);
		}
		else if("goUpdate".equals(flag)) {
			//跳转到修改页面,调用goUpdate方法
			goUpdate(request,response);
		}
	}

	
	private void goIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 点击超链接跳回首页走这个方法
		//证明是点击登录按钮进来的，直接跳转到首页
		//由于首页中需要展示数据库的信息，所以
		//1. 调用Service层中的全查询
		CustomerService c1 = new CustomerServiceImpl();
		List<Customer> cusList = c1.findCustomer();
		//2. 打包
		request.setAttribute("cusList", cusList);
		//3. 跳转页面（首页）
		request.getRequestDispatcher("customer_index.jsp").forward(request, response);
	}
	
	private void goInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//跳转到添加画面
		request.getRequestDispatcher("customer_insert.jsp").forward(request, response);
	}
	
	private void goDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 跳转到删除画面
		//接取要删除的id的值
		String id=request.getParameter("id");
		//将id打包
		request.setAttribute("id", id);
		//跳转到删除画面
		request.getRequestDispatcher("customer_delete.jsp").forward(request, response);
	}
	
	private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 跳转到修改画面
		//接取要修改的id的值
		String id=request.getParameter("id");
		//调用通过id查找的方法
		CustomerService c2 = new CustomerServiceImpl();
		Customer c02= c2.findCustomerById(Integer.parseInt(id));
		request.setAttribute("id", c02.getId());
		request.setAttribute("name", c02.getName());
		request.setAttribute("points", c02.getPoints());
		request.setAttribute("tel", c02.getTel());
		request.setAttribute("sex", c02.getSex());
		//跳转到修改画面
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
			//实现跳转回首页功能
			goIndex(request,response);
		}
		else if ("doInsert".equals(flag)) {
			//开始执行添加功能,成功的话跳转到添加成功画面，否则跳转回当前页面
			doInsert(request,response);
		}
		else if("doDelete".equals(flag)) {
			//执行删除功能，如果成功跳转到删除成功画面
			DoDelete(request,response);
			
			
		}
		else if("doUpdate".equals(flag)) {
			//开始执行修改的功能
			doUpdate(request,response);
		}
		else if("doSearch".equals(flag)) {
			//模糊查询，调用doSearch方法
			doSearch(request,response);
		}
		
	}

	

	


	private void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 开始执行添加功能
		//1. 接取画面中的参数数据
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String points = request.getParameter("points");
		String tel = request.getParameter("tel");
		String sex = request.getParameter("sex");
		//1.2 将参数打包到对象中
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(id));
		customer.setName(name);
		customer.setPoints(Double.parseDouble(points));
		customer.setTel(tel);
		customer.setSex(sex);
		//2. 调用service层中的方法(业务层)
		CustomerService c1 = new CustomerServiceImpl();
		boolean result = c1.insertCustomer(customer);
		//ctrl + 2 选择第二个：自动接取返回值
		//3. 判断是否添加成功！
		if (result) {
			//跳转到成功画面
			//由于成功画面需要展示添加成功的信息，所以要发送数据到画面中
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("customer_insertok.jsp").forward(request, response);
		}else {
			//跳转回添加画面
			request.getRequestDispatcher("customer_insert.jsp").forward(request, response);
		}
	}
	
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 开始执行修改的功能
		//1. 接取画面中的参数数据
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String points=request.getParameter("points");
		String tel=request.getParameter("tel");
		String sex=request.getParameter("sex");
		//1.2 将参数打包到对象中
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(id));
		customer.setName(name);
		customer.setPoints(Double.parseDouble(points));
		customer.setTel(tel);
		customer.setSex(sex);
		//2. 调用service层中的方法(业务层)
		CustomerService c1 = new CustomerServiceImpl();
		boolean result = c1.updateCustomer(customer);
		if(result) {
			//修改成功，赋值，封装对象
			request.setAttribute("customer", customer);
			//跳转到修改成功画面
			request.getRequestDispatcher("customer_updateok.jsp").forward(request, response);	
		}
		else {
			//跳转回修改画面
			request.getRequestDispatcher("customer_update.jsp").forward(request, response);
		}
	}
	
	private void DoDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//执行删除功能，如果成功跳转到删除成功画面
		String id=request.getParameter("id");
		CustomerService customer=new CustomerServiceImpl();
		Boolean result=customer.deleteCustomer(Integer.parseInt(id));
		if(result) {
			//如果result是true，跳转到删除成功页面
			request.setAttribute("id", id);
			request.getRequestDispatcher("customer_deleteok.jsp").forward(request, response);
		}
		else {
			//跳转回删除画面
			request.getRequestDispatcher("customer_delete.jsp").forward(request, response);
		}
	}
	
	private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 进行模糊查询
		//接取id和电话
		String id = request.getParameter("id");
		String tel = request.getParameter("tel");
		//调用模糊查询的方法
		CustomerService c1=new CustomerServiceImpl();
		List<Customer> cusList=c1.findCustomerByIdAndTel(id, tel);
		//传值
		request.setAttribute("cusList", cusList);
		request.getRequestDispatcher("customer_index.jsp").forward(request, response);
	}
	
	
}
