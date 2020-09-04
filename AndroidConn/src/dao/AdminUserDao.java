package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.AdminUser;

public class AdminUserDao {
	private AdminUserDao() {}
	
	private static AdminUserDao instance=new AdminUserDao();
	
	public static AdminUserDao getInstance() {
		return instance;
	}
	
	public List<AdminUser> selectAll() {
		List<AdminUser> list = new ArrayList<AdminUser>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from admin_user";

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AdminUser admin = new AdminUser();
				admin.setId(rs.getString("id"));
				admin.setPw(rs.getString("pw"));
				list.add(admin);
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
	
	public boolean insert(AdminUser admin) {
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "insert into admin_user(id,pw) " + "values(?,?)";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getId());
			ps.setString(2, admin.getPw());
		
			int n = ps.executeUpdate();
			
			if (n == 1) {
				flag = true;
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회원가입 실패");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	public int login(String id, String pw) {
		int n = -1;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select pw from f_member where id=?";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
		
			if (rs.next()) {
				if (pw.equals(rs.getString(1))) {
					n = 1;
					//System.out.println("로그인 성공");
				} else {
					n = 0;
					//System.out.println("패스워드 다름");
				}
			} else {
				//System.out.println("아이디 없음");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return n;
	}
	
}
