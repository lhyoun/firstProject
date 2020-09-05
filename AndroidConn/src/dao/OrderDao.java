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
	/*private int ono;			// 주문 번호(pk, not-null, default:sequnce)
	private int pno;			// 메뉴번호(Product table의 no와 fk)
	private int quantity; 		// 수량
	private int price;			// 주문 금액
	private String state;		// 상태(준비중, 판매 완료 등)
	private String oder_time;	// 주문(들어온) 시간*/
	
	private OrderDao() {}
	
	private static OrderDao oDao=new OrderDao();
	
	public static OrderDao getInstance() {
		return oDao;
	}
	
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
				order.setOrder_code(rs.getInt("order_code")); //주문번호
				order.setOrder_time(rs.getString("order_time")); //주문시간
				order.setPno(rs.getInt("pno")); //제품번호
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
	
	public List<Order> selectAll_name_ver(){
		String sql = "select o.no, o.order_code, o.user_id, p.name, o.user_option, o.order_state, o.order_time from order10 o, product9 p where o.pno=p.no and o.order_state='주문완료'";

		List<Order> list = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("rs없음");
			while (rs.next()) {
				Order order = new Order();
				order.setOrder_code(rs.getInt("order_code")); //주문번호
				order.setOrder_time(rs.getString("order_time")); //주문시간
				order.setName(rs.getNString("name")); //제품이름
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
				System.out.println("sssssssss999999999999999999999999999999999999999999999999999999999999999999999999999999");
				System.out.println(sql);
				System.out.println("update fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return flag;
	}
}
