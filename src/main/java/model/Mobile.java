package model;

public class Mobile {

	private String tradeMark;
	private int price;
	public Mobile() {
		super();
	}
	public Mobile(String tradeMark, int price) {
		super();
		this.tradeMark = tradeMark;
		this.price = price;
	}
	public String getTradeMark() {
		return tradeMark;
	}
	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "[tradeMark=" + tradeMark + ", price=" + price + "]";
	}
	
}
