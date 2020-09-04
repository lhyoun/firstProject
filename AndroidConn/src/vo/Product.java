package vo;

public class Product {
	private int no;				// 메뉴 번호(pk, not-null, default:sequnce)
	private String name;		// 상품명
	private int price;			// 가격
	private String info; 		// 정보(설명)
	private String image_name;	// 이미지 이름
	private String category;	// 카테고리
	
	public Product(int no, String name, int price, String info, String image_name, String categroy) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.info = info;
		this.image_name = image_name;
		this.category = categroy;
	}
	
	public Product(String name, int price, String info, String image_name, String categroy) {
		super();
		this.name = name;
		this.price = price;
		this.info = info;
		this.image_name = image_name;
		this.category = categroy;
	}
	
	public Product() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getCategroy() {
		return category;
	}

	public void setCategroy(String categroy) {
		this.category = categroy;
	}

	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + ", info=" + info + ", image_name="
				+ image_name + ", categroy=" + category + "]";
	}
}