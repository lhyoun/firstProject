package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.ClientUser;

public class ClientUserDao {
	private ClientUserDao() {}
	
	private static ClientUserDao instance=new ClientUserDao();
	
	public static ClientUserDao getInstance() {
		return instance;
	}
	
	public List<ClientUser> selectAll() {
		List<ClientUser> list = new ArrayList<ClientUser>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		//asdasdjaskldj
		
		String sql = "select * from client_user";

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ClientUser client = new ClientUser();
				client.setId(rs.getString("id"));
				client.setPw(rs.getString("pw"));
				list.add(client);
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
	
	public boolean insert(ClientUser client) {
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "insert into client_user(id,pw) " + "values(?,?)";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, client.getId());
			ps.setString(2, client.getPw());
		
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
	
	public boolean login(String id, String pw) {
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select pw from client_user where id=?";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
		
			if (rs.next()) {
				if (pw.equals(rs.getString(1))) {
					flag = true;
					System.out.println("로그인 성공");
				} else {
					System.out.println("패스워드 다름");
				}
			} else {
				System.out.println("아이디 없음");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return flag;
	}
}
