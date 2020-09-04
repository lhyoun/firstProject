package vo;

public class ClientUser {
	private String id;
	private String pw;
	
	public ClientUser() {}

	public ClientUser(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "ClientUser [id=" + id + ", pw=" + pw + "]";
	}
}
