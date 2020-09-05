package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.OrderTable;

public class OrderTableDao {
	private OrderTableDao() {}
	
	private static OrderTableDao instance=new OrderTableDao();
	
	public static OrderTableDao getInstance() {
		return instance;
	}
	
	public List<OrderTable> selectAll() {
		List<OrderTable> list = new ArrayList<OrderTable>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select count(*) as order_count, order_code, LISTAGG(order_code, ',') WITHIN GROUP(ORDER BY ORDER_CODE) AS ORDER_KEY FROM ORDER10 where order_state='주문완료' GROUP BY ORDER_CODE";

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				OrderTable orderTable = new OrderTable();
				orderTable.setOrder_num(rs.getInt("order_code"));
				orderTable.setOrder_key(rs.getString("order_key"));
				orderTable.setOrder_count(rs.getInt("order_count"));
				list.add(orderTable);
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.getStackTrace();
			} finally {
				DBConn.close(conn, ps, rs);
			}
		}
		return list;
	}
}
