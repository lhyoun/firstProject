package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Option;

public class OptionDao {
	OptionDao(){}
	
	private static OptionDao opDao=new OptionDao();
	
	public static OptionDao getInstance() {
		return opDao;
	}
	
	public List<Option> selectAll(){
		String sql = "select * from order_option9";

		List<Option> list = new ArrayList<Option>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Option option = new Option();
				option.setNo(rs.getInt("no"));
				option.setCategory(rs.getString("category"));
				option.setOption(rs.getString("option_name"));
				list.add(option);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
}
