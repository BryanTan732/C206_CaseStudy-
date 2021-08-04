import java.time.LocalDate;

/**
 * I declare that this code was written by me.

 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20045873, 28 Jul 2021 5:37:14 pm
 */

/**
 * @author bryan
 *
 */
public class Item {
	private String ItemName;
	private String ItemDescription;
	private double MinbidPrice;
	private String AuctionStart;
	private String AuctionEnd;
	private int BidIncR;
	public Item(String itemName, String itemDescription, double minbidPrice, String auctionStart,
			String auctionEnd, int bidIncR) {

		this.ItemName = itemName;
		this.ItemDescription = itemDescription;
		this.MinbidPrice = minbidPrice;
		this.AuctionStart = auctionStart;
		this.AuctionEnd = auctionEnd;
		this.BidIncR = 1;
	}

	public String getItemName() {
		return ItemName;
	}

	public String getItemDescription() {
		return ItemDescription;
	}

	public double getMinbidPrice() {
		return MinbidPrice;
	}

	public String getAuctionStart() {
		return AuctionStart;
	}

	public String getAuctionEnd() {
		return AuctionEnd;
	}

	public int getBidIncR() {
		return BidIncR;
	}

}
