

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
import dao.OrderDao;
import dao.OrderDao2;
import dao.ProductDao;
import vo.AdminUser;
import vo.ClientUser;
import vo.Order;
import vo.Order2;
import vo.Product;

@WebServlet("*.do")
public class ContServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContServlet() {
	}

	@SuppressWarnings("unchecked")
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String action = requestURI.substring(contextPath.length());


		/* index진입점, mainForm contents(사진 9개) 찾아와서 출력, 처음 카테고리 new 라서 최신순으로 출력된다, cno(등록순서)로 내림차순 정렬 */
		if (action.equals("/json.do")) {
			List<Product> list=ProductDao.getInstance().selectAll();
			//request.setAttribute("list", list);
			//request.getRequestDispatcher("json.jsp").forward(request, response);
			
			
			
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
		
		
		else if (action.equals("/order.do")) {
			List<Order2> list=OrderDao2.getInstance().selectAll2();
			//System.out.println(list);
			//request.setAttribute("list", list);
			//request.getRequestDispatcher("json.jsp").forward(request, response);
		}
		
		else if (action.equals("/adminUser.do")) {
			List<AdminUser> list=AdminUserDao.getInstance().selectAll();
			System.out.println(list);
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
			
			Order2 od=new Order2(name,op,user); 
			OrderDao2.getInstance().insert(od);
			 
			
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