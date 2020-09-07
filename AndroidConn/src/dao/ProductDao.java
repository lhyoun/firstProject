package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Product;

public class ProductDao {
	private ProductDao() {}
	
	private static ProductDao pDao=new ProductDao();
	
	public static ProductDao getInstance() {
		return pDao;
	}
	
	public List<Product> selectCat(){ //카테고리 하나만 출력
		String sql = "select distinct category from product9";

		List<Product> list2 = new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product ProC = new Product();
				ProC.setCategory(rs.getString("category"));
				System.out.println(ProC);
				list2.add(ProC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list2;
	}
	
	public List<Product> selectAll(){
		String sql = "select * from product9 order by no";

		List<Product> list = new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product Pro = new Product();
				Pro.setNo(rs.getInt("no"));
				Pro.setName(rs.getString("name"));
				Pro.setPrice(rs.getInt("price"));
				Pro.setInfo(rs.getString("info"));
				Pro.setImage_name(rs.getString("image_name"));
				Pro.setCategroy(rs.getString("category"));
				list.add(Pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
}
