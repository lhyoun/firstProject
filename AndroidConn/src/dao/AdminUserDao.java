package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.AdminUser;

public class AdminUserDao {
	private AdminUserDao() {}
	
	private static AdminUserDao aDao=new AdminUserDao();
	
	public static AdminUserDao getInstance() {
		return aDao;
	}
	
	public int login(String id, String pw) {
		int n= -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select pw from admin_user where id=?";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if(rs.next()) {
				if(pw.equals(rs.getString(1))) {
					n=1;
					System.out.println("로그인 되었어요");
					
				}else {
					n=0;
					System.out.println("비밀번호를 확인하세요");
				}
			}else {
				System.out.println("아이디를 확인하세요");
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConn.close(conn, ps, rs);
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		return n;
	}
}
