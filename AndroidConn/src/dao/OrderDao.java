package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		String sql = "select * from order9";

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
				order.setOno(rs.getInt("no"));
				order.setPno(rs.getInt("pno"));
				order.setQuantity(rs.getInt("quantity"));
				order.setPrice(rs.getInt("price"));
				order.setState(rs.getString("state"));
				order.setOder_time(rs.getString("order_time"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
}
