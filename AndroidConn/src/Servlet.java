import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.AdminUserDao;
import dao.ClientUserDao;
import dao.OptionDao;
import dao.OrderDao;
import dao.OrderTableDao;
import dao.ProductDao;
import vo.AdminUser;
import vo.ClientUser;
import vo.Option;
import vo.Order;
import vo.OrderTable;
import vo.Product;

@WebServlet("*.do")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
	}

	@SuppressWarnings("unchecked")
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String action = requestURI.substring(contextPath.length());

		if (action.equals("/json.do")) {
			List<Product> list=ProductDao.getInstance().selectAll();

			JSONObject totalObject = new JSONObject();
			JSONArray contentArray = new JSONArray();
			
			/* json date는 전송 불가능 ? */
			
			for (int i = 0; i < list.size(); i++) {
				JSONObject contentInfo = new JSONObject();
				contentInfo.put("no", list.get(i).getNo());
				contentInfo.put("name", list.get(i).getName());
				contentInfo.put("price", list.get(i).getPrice());
				contentInfo.put("info", list.get(i).getInfo());
				contentInfo.put("image_name", list.get(i).getImage_name());
				contentInfo.put("category", list.get(i).getCategroy());
				contentArray.add(contentInfo);
			}
			totalObject.put("contents", contentArray);
			String jsonInfo = totalObject.toJSONString();
			System.out.println(jsonInfo);
			out.print(jsonInfo);
			
		}
		
		
		else if (action.equals("/adminUser.do")) {
			//List<AdminUser> list=AdminUserDao.getInstance().selectAll();
			//System.out.println(list);
			//request.setAttribute("list", list);
			//request.getRequestDispatcher("json.jsp").forward(request, response);
		}
		
		else if (action.equals("/clientUser.do")) {
			List<ClientUser> list=ClientUserDao.getInstance().selectAll();
			System.out.println(list);
			//request.setAttribute("list", list);
			//request.getRequestDispatcher("json.jsp").forward(request, response);
		}
		
		else if (action.equals("/signup.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			ClientUser client=new ClientUser(id,pw);
			boolean flag=ClientUserDao.getInstance().insert(client);
			if(flag) {
				System.out.println("회원ㅇ가입 성공");
				out.print("a");
			}else {
				System.out.println("실패");
				out.print("b");
			}
		}
		
		else if (action.equals("/signin.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			boolean flag=ClientUserDao.getInstance().login(id,pw);
			if(flag) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("실패");
			}
		}

		
		else if (action.equals("/test.do")) {
			System.out.println("zzzzzz");
			int name=Integer.parseInt(request.getParameter("name"));
			String op=request.getParameter("option");
			String user=request.getParameter("user");
			
			System.out.println(name);
			System.out.println(user);
			System.out.println(op);
			
			Order od=new Order(name,op,user); 
			OrderDao.getInstance().insert(od);
			 
			
		}
		
		else if (action.equals("/loginForm.do")) {
			System.out.println("d");
			request.getRequestDispatcher("adminPage/loginForm.jsp").forward(request, response);
		}
		
		else if (action.equals("/order.do")) {
			List<OrderTable> ttt=OrderTableDao.getInstance().selectAll();
			System.out.println(ttt);
			request.setAttribute("ttt", ttt);
			
			List<Order> list = OrderDao.getInstance().selectAll_name_ver();
			request.setAttribute("list", list);			

			System.out.println(list);
			
			
			request.getRequestDispatcher("adminPage/mainForm.jsp").forward(request, response);
		}
		
		else if (action.equals("/complete.do")) {
			List<OrderTable> ttt=OrderTableDao.getInstance().selectAll2();
			request.setAttribute("ttt", ttt);
			System.out.println(ttt);
			
			List<Order> list = OrderDao.getInstance().selectAll_name_ver2();
			request.setAttribute("list", list);
			System.out.println(list);
			
			request.getRequestDispatcher("adminPage/mainForm.jsp").forward(request, response);
			
		}
		
		else if (action.equals("/Product.do")) {
			request.getRequestDispatcher("adminPage/ProductRegistration.jsp").forward(request, response);
		}
		
		else if (action.equals("/login.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println(id+pw);
			int n = AdminUserDao.getInstance().login(id, pw);

			if (n == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("session_id", id);
				out.print("<script> alert('로그인 되었어요'); location.href='order.do'; </script>");
			} else if (n == 0) {
				out.print("<script> alert('비밀번호를 확인하세요'); location.href='loginForm.do'; </script>");
			} else {
				out.print("<script> alert('아이디를 확인하세요'); location.href='loginForm.do'; </script>");
			}
		}
		
		else if (action.equals("/optionJson.do")) {
			List<Option> list=OptionDao.getInstance().selectAll();
			//request.setAttribute("list", list);
			//request.getRequestDispatcher("json.jsp").forward(request, response);

			JSONObject totalObject = new JSONObject();
			JSONArray contentArray = new JSONArray();
			
			/* json date는 전송 불가능 ? */
			
			for (int i = 0; i < list.size(); i++) {
				JSONObject contentInfo = new JSONObject();
				contentInfo.put("no", list.get(i).getNo());
				contentInfo.put("category", list.get(i).getCategory());
				contentInfo.put("option", list.get(i).getOption());
				contentArray.add(contentInfo);
			}
			totalObject.put("contents", contentArray);
			String jsonInfo = totalObject.toJSONString();
			System.out.println(jsonInfo);
			out.print(jsonInfo);
			
			
		}
		else if (action.equals("/asas.do")) {
			System.out.println("sesssssssssssssssr");
			int no=Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			boolean flag=OrderDao.getInstance().updateState(no);
			if(flag){
				out.print("<script> alert('update complete'); location.href='order.do'; </script>");
			}else {
				out.print("<script> alert('update fail'); location.href='order.do'; </script>");
			}
			//request.getRequestDispatcher("adminPage/ProductRegistration.jsp").forward(request, response);
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
}