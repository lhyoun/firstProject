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

		
		/*----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----*/
		/* Android request 처리용 servlet*/
		
		/* android에 제공하는 product json page */
		if (action.equals("/json.do")) {
			List<Product> list=ProductDao.getInstance().selectAll();
			JSONObject totalObject = new JSONObject();
			JSONArray contentArray = new JSONArray();
			
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
			out.print(jsonInfo);
		}
		
		/* android에 제공하는 option json page */
		else if (action.equals("/optionJson.do")) {
			List<Option> list=OptionDao.getInstance().selectAll();
			JSONObject totalObject = new JSONObject();
			JSONArray contentArray = new JSONArray();
			
			for (int i = 0; i < list.size(); i++) {
				JSONObject contentInfo = new JSONObject();
				contentInfo.put("no", list.get(i).getNo());
				contentInfo.put("category", list.get(i).getCategory());
				contentInfo.put("option", list.get(i).getOption());
				contentArray.add(contentInfo);
			}
			totalObject.put("contents", contentArray);
			String jsonInfo = totalObject.toJSONString();
			out.print(jsonInfo);
		}
		
		/* Android client용 회원가입 */
		else if (action.equals("/signup.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			ClientUser client=new ClientUser(id,pw);
			boolean flag=ClientUserDao.getInstance().insert(client);
			if(flag) {
				System.out.println("회원가입 성공");
				out.print("complete");
				/* 이 값으로 Android에서 성공 또는 실패 처리 */
			}else {
				System.out.println("로그인 실패");
				out.print("fail");
				/* 이 값으로 Android에서 성공 또는 실패 처리 */
			}
		}
		
		/* Android client용 로그인 */
		else if (action.equals("/signin.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			System.out.println(id);
			System.out.println(pw);
			boolean flag=ClientUserDao.getInstance().login(id,pw);
			if(flag) {
				System.out.println("로그인 성공");
				out.print("complete");
			}else {
				System.out.println("로그인 실패");
				out.print("fail");
			}
		}

		/* Android 장바구니 추가하면 order list에 추가 */
		else if (action.equals("/test.do")) {
			int name=Integer.parseInt(request.getParameter("name"));
			String op=request.getParameter("option");
			String user=request.getParameter("user");
			int orderCode=Integer.parseInt(request.getParameter("code"));
			/* 상품 이름(번호,int), 옵션, userID 받아와서 order Table에 추가 */
			
			/*System.out.println(name);
			System.out.println(user);
			System.out.println(op);
			System.out.println(orderCode);*/
			
			Order order=new Order(orderCode,name,op,user); 
			OrderDao.getInstance().insert(order);
		}
		/* 새로운 주문에 order code를 부여하기 위함(한 장바구니에서 들어온 요청들은 동일한 order code를 부여해야 함) */
		else if (action.equals("/maxCode.do")) {
			int maxCode=OrderDao.getInstance().MaxCode()+1;
			out.print("order_code"+maxCode+"order_code");			
		}
		
		
		/*----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----*/
		/* Admin Page request 처리용 servlet*/
		
		/* index의 진입점, login PAGE */
		else if (action.equals("/loginForm.do")) {
			request.getRequestDispatcher("adminPage/loginForm.jsp").forward(request, response);
		}
		
		/* 로그인 request처리용 로직 */
		else if (action.equals("/login.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			int n = AdminUserDao.getInstance().login(id, pw);

			if (n == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("session_id", id);
				out.print("<script> alert('로그인 되었어요'); location.href='orderListForm.do'; </script>");
			} else if (n == 0) {
				out.print("<script> alert('비밀번호를 확인하세요'); location.href='loginForm.do'; </script>");
			} else {
				out.print("<script> alert('아이디를 확인하세요'); location.href='loginForm.do'; </script>");
			}
		}
		
		/* orderListForm(주문들어온 리스트)으로 이동 */
		else if (action.equals("/orderListForm.do")) {
			List<OrderTable> orderTable=OrderTableDao.getInstance().selectAll();
			/* 주문번호들 묶어서 분류하기 위한 로직 */
			request.setAttribute("ttt", orderTable);
			
			List<Order> list = OrderDao.getInstance().selectAll_name_ver();
			request.setAttribute("list", list);			
			
			request.getRequestDispatcher("adminPage/orderListForm.jsp").forward(request, response);
		}
		
		/* orderListForm(주문들어온거 처리 완료 된 리스트)으로 이동 */
		else if (action.equals("/orderListFormComplete.do")) {
			List<OrderTable> orderTable=OrderTableDao.getInstance().selectAll2();
			/* 주문번호들 묶어서 분류하기 위한 로직 */
			request.setAttribute("ttt", orderTable);
			
			List<Order> list = OrderDao.getInstance().selectAll_name_ver2();
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("adminPage/orderListForm.jsp").forward(request, response);
		}

		/* Admin PAGE order list에서 주문 들어온거 다 만들고 DONE 버튼 누르면 시행됨 */ 
		else if (action.equals("/orderComplete.do")) {
			int no=Integer.parseInt(request.getParameter("no"));
			boolean flag=OrderDao.getInstance().updateState(no);
			if(flag){
				out.print("<script> alert('update complete'); location.href='orderListForm.do'; </script>");
			}else {
				out.print("<script> alert('update fail'); location.href='orderListForm.do'; </script>");
			}
		}
		
		
		
		
		/*---------------------------------------------------*/

		
		else if (action.equals("/ProductListForm.do")) {
			List<Product> list = ProductDao.getInstance().selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("adminPage/ProductListForm.jsp").forward(request, response);
		}
		
		else if (action.equals("/orderSate.do")) {
			
			int no=Integer.parseInt(request.getParameter("code"));
			System.out.println(no);
			String state=OrderDao.getInstance().orderState(no);
			out.print(state);
		}
		
		
		
		
		else if (action.equals("/threadTest.do")) {
			System.out.println("ddd");
			int code=Integer.parseInt(request.getParameter("code"));
			System.out.println(code);
			
			String state=OrderDao.getInstance().orderState(code);
			out.print(state);
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