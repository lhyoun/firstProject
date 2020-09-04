package vo;

public class Order {
	// 메뉴번호 주문번호 수량 금액 상태 주문시간
	private int ono;			// 주문 번호(pk, not-null, default:sequnce)
	private int pno;			// 메뉴번호(Product table의 no와 fk)
	private int quantity; 		// 수량
	private int price;			// 주문 금액
	private String state;		// 상태(준비중, 판매 완료 등)
	private String oder_time;	// 주문(들어온) 시간
	
	public Order(int ono, int pno, int quantity, int price, String state, String oder_time) {
		super();
		this.ono = ono;
		this.pno = pno;
		this.quantity = quantity;
		this.price = price;
		this.state = state;
		this.oder_time = oder_time;
	}
	
	public Order(int pno, int quantity, int price, String state, String oder_time) {
		super();
		this.pno = pno;
		this.quantity = quantity;
		this.price = price;
		this.state = state;
		this.oder_time = oder_time;
	}
	
	public Order() {}

	public int getOno() {
		return ono;
	}

	public void setOno(int ono) {
		this.ono = ono;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOder_time() {
		return oder_time;
	}

	public void setOder_time(String oder_time) {
		this.oder_time = oder_time;
	}

	@Override
	public String toString() {
		return "Order [ono=" + ono + ", pno=" + pno + ", quantity=" + quantity + ", price=" + price + ", state=" + state
				+ ", oder_time=" + oder_time + "]";
	}
}