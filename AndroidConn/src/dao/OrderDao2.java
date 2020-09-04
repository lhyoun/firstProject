package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ClientUser;
import vo.Order;
import vo.Order2;

public class OrderDao2 {
	/*private int ono;			// 주문 번호(pk, not-null, default:sequnce)
	private int pno;			// 메뉴번호(Product table의 no와 fk)
	private int quantity; 		// 수량
	private int price;			// 주문 금액
	private String state;		// 상태(준비중, 판매 완료 등)
	private String oder_time;	// 주문(들어온) 시간*/
	
	private OrderDao2() {}
	
	private static OrderDao2 oDao=new OrderDao2();
	
	public static OrderDao2 getInstance() {
		return oDao;
	}
	
	public List<Order2> selectAll2(){
		String sql = "select * from order10";

		List<Order2> list = new ArrayList<Order2>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ddd");
				/*Order order = new Order();
				order.setOno(rs.getInt("no"));
				order.setPno(rs.getInt("pno"));
				order.setQuantity(rs.getInt("quantity"));
				order.setPrice(rs.getInt("price"));
				order.setState(rs.getString("state"));
				order.setOder_time(rs.getString("order_time"));
				list.add(order);*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	
	public boolean insert(Order2 order) {
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
