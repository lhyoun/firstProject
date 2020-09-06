package vo;

public class Order {
	private String name;
	private int order_code;		// 주문 번호
	private int pno;			// 제품번호
	private String user_option; // 추가 토핑
	private String order_state; // 주문상태 정보(주문전, 주문완료, 수령완료)
	private String order_time;	// 주문(들어온) 시간
	private String user_id;
	private int no;
	private int ea;	
	
	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	public Order() {}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	
	
	public Order(int order_code, int pno, String user_option, String user_id) {
		super();
		this.order_code = order_code;
		this.pno = pno;
		this.user_option = user_option;
		this.user_id = user_id;
	}

	public Order(int pno, String user_option, String user_id) {
		super();
		this.pno = pno;
		this.user_option = user_option;
		this.user_id = user_id;
	}

	public Order(String name, int order_code, int pno, String user_option, String order_state, String order_time,
			String user_id, int no) {
		super();
		this.name = name;
		this.order_code = order_code;
		this.pno = pno;
		this.user_option = user_option;
		this.order_state = order_state;
		this.order_time = order_time;
		this.user_id = user_id;
		this.no = no;
	}

	public Order(int order_code, int pno, String user_option, String order_state, String order_time) {
		super();
		this.order_code = order_code;
		this.pno = pno;
		this.user_option = user_option;
		this.order_state = order_state;
		this.order_time = order_time;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Order(int order_code, String name, String user_option, String order_state, String order_time) {
		super();
		this.order_code = order_code;
		this.name = name;
		this.user_option = user_option;
		this.order_state = order_state;
		this.order_time = order_time;
	}

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
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

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	@Override
	public String toString() {
		return "Order [name=" + name + ", order_code=" + order_code + ", pno=" + pno + ", user_option=" + user_option
				+ ", order_state=" + order_state + ", order_time=" + order_time + ", user_id=" + user_id + ", no=" + no
				+ ", ea=" + ea + "]";
	}
	
//	private int quantity; 		// 수량
//	private int price;			// 주문 금액 ?
//	private String state;		// 상태(준비중, 판매 완료 등)
	
	
//	public Order(int ono, int pno, int quantity, int price, String state, String oder_time) {
//		super();
//		this.ono = ono;
//		this.pno = pno;
//		this.quantity = quantity;
//		this.price = price;
//		this.state = state;
//		this.oder_time = oder_time;
//	}
//	
//	public Order(int pno, int quantity, int price, String state, String oder_time) {
//		super();
//		this.pno = pno;
//		this.quantity = quantity;
//		this.price = price;
//		this.state = state;
//		this.oder_time = oder_time;
//	}
	
}