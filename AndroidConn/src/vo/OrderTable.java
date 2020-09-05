package vo;

public class OrderTable {
	int order_num;
	String order_key;
	int order_count;
	
	public OrderTable(int order_num, String order_key) {
		super();
		this.order_num = order_num;
		this.order_key = order_key;
		
	}
	
	
	
	public OrderTable(int order_num, String order_key, int order_count) {
		super();
		this.order_num = order_num;
		this.order_key = order_key;
		this.order_count = order_count;
	}



	public int getOrder_count() {
		return order_count;
	}



	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}



	public OrderTable() {}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getOrder_key() {
		return order_key;
	}

	public void setOrder_key(String order_key) {
		this.order_key = order_key;
	}

	@Override
	public String toString() {
		return "OrderTable [order_num=" + order_num + ", order_key=" + order_key + ", order_count=" + order_count + "]";
	}
	
	
}
