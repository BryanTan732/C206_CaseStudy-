
public class Deal {
	private int id;
	private String itemname;
	private String seller;
	private String buyer;
	private Double price;
	private String closedate;
	public Deal(int id, String itemname, String seller, String buyer, Double price, String closedate) {
		super();
		this.id = id;
		this.itemname = itemname;
		this.seller = seller;
		this.buyer = buyer;
		this.price = price;
		this.closedate = closedate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getClosedate() {
		return closedate;
	}
	public void setClosedate(String closedate) {
		this.closedate = closedate;
	}

}
