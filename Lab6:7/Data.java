public class Data {

	private String date;
	private float price;
	
	public Data(String date, float price) {
		this.date = date;
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}