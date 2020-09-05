package vo;

public class Option {
	private int no;
	private String category;
	private String option;
	
	public Option() {}

	public Option(int no, String category, String option) {
		super();
		this.no = no;
		this.category = category;
		this.option = option;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return "Option [no=" + no + ", category=" + category + ", option=" + option + "]";
	}
	
	
}
