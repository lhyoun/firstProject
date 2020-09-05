package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ClientUser;
import vo.Order;

public class OrderDao {
	private OrderDao() {}
	
	private static OrderDao oDao=new OrderDao();
	
	public static OrderDao getInstance() {
		return oDao;
	}

	/*----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----*/
	/* 아래는 Web AdminPage에서 사용할 method */
	
	/* 주문완료(결제 완료 된[주문완료] order list 상품 번호를 상품 이름으로 출력)  */
	public List<Order> selectAll_name_ver(){
		String sql = "select o.no, o.order_code, o.user_id, p.name, o.user_option, o.order_state, o.order_time from order10 o, product9 p where o.pno=p.no and o.order_state='주문완료' order by order_code";

		List<Order> list = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrder_code(rs.getInt("order_code")); 
				order.setOrder_time(rs.getString("order_time"));
				order.setName(rs.getNString("name"));
				order.setUser_option(rs.getString("user_option"));
				order.setOrder_state(rs.getString("order_state"));	
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	
	/* 주문완료(제작 완료 된[수령완료] order list 상품 번호를 상품 이름으로 출력)  */
	public List<Order> selectAll_name_ver2(){
		String sql = "select o.no, o.order_code, o.user_id, p.name, o.user_option, o.order_state, o.order_time from order10 o, product9 p where o.pno=p.no and o.order_state='수령완료'";

		List<Order> list = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrder_code(rs.getInt("order_code")); 
				order.setOrder_time(rs.getString("order_time"));
				order.setName(rs.getNString("name"));
				order.setUser_option(rs.getString("user_option"));
				order.setOrder_state(rs.getString("order_state"));	
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}

	/* order list[주문 완료]에서 상품 제작 완료 버튼 누르면 [수령완료]로 update */
	public boolean updateState(int no) {
		boolean flag=false;
		String sql = "update order10 set order_state='수령완료' where order_code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			int n=pstmt.executeUpdate();
			if(n>=1) {
				flag=true;
				System.out.println("update complete");
			}else {
				System.out.println("update fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return flag;
	}
	
	/* [주문완료] 상태의 모든 order list의 row를 출력 (현재 쓰이고 있는 곳 없음)*/
	public List<Order> selectAll(){
		String sql = "select * from order10 where order_state='주문완료'";

		List<Order> list = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrder_code(rs.getInt("order_code"));
				order.setOrder_time(rs.getString("order_time")); 
				order.setPno(rs.getInt("pno"));
				order.setUser_option(rs.getString("user_option"));
				order.setOrder_state(rs.getString("order_state"));		
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	
	/*----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----*/
	/* 아래는 Android에서 사용할 method */
	
	/*장바구니 추가하면 [주문전] 상태로 order list에 insert (지금은 [주문완료]이지만 추후에 [주문전]으로 수저아고 결제 시 [주문완료]로 업데이트 하는 로직 필요)*/ 
	public boolean insert(Order order) {
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "insert into order10 values(ordernum9.nextval,0011,?,?,?,'주문완료',to_char(sysdate,'yyyy.mm.dd hh24:mi'))";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, order.getUser_id());
			ps.setInt(2, order.getPno());
			ps.setString(3, order.getUser_option());
		
			int n = ps.executeUpdate();
			
			if (n == 1) {
				flag = true;
				System.out.println("주문 추가 완료");
			} else {
				System.out.println("실패");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
}
