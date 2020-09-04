package vo;

public class Order2 {
	// 메뉴번호 주문번호 수량 금액 상태 주문시간
	private int no;			// 주문 번호(pk, not-null, default:sequnce)
	private int order_code;
	private String user_id;
	private int pno;			// 메뉴번호(Product table의 no와 fk)
	private String user_option;
	private String order_state;		// 상태(준비중, 판매 완료 등)
	private String oder_time;	// 주문(들어온) 시간
	
	public Order2(int no, int order_code, String user_id, int pno, String user_option, String order_state,
			String oder_time) {
		super();
		this.no = no;
		this.order_code = order_code;
		this.user_id = user_id;
		this.pno = pno;
		this.user_option = user_option;
		this.order_state = order_state;
		this.oder_time = oder_time;
	}
	
	
	
	public Order2(int pno, String user_option, String user_id) {
		super();
		this.pno = pno;
		this.user_option = user_option;
		this.user_id=user_id;
	}



	public Order2() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getUser_option() {
		return user_option;
	}

	public void setUser_option(String user_option) {
		this.user_option = user_option;
	}

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

	public String getOder_time() {
		return oder_time;
	}

	public void setOder_time(String oder_time) {
		this.oder_time = oder_time;
	}

	@Override
	public String toString() {
		return "Order2 [no=" + no + ", order_code=" + order_code + ", user_id=" + user_id + ", pno=" + pno
				+ ", user_option=" + user_option + ", order_state=" + order_state + ", oder_time=" + oder_time + "]";
	}
}