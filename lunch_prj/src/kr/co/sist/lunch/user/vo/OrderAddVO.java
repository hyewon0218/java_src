package kr.co.sist.lunch.user.vo;

public class OrderAddVO {
	private String orderName, phone, ipAddress, lunchCode,ask;
	private int quan;
	public OrderAddVO(String orderNum, String phone, String ipAddress, String lunchCode, String ask, int quan) {
		super();
		this.orderName = orderNum;
		this.phone = phone;
		this.ipAddress = ipAddress;
		this.lunchCode = lunchCode;
		this.quan = quan;
		this.ask=ask;///////Ãß°¡
	}
	public String getOrderName() {
		return orderName;
	}
	public String getPhone() {
		return phone;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public String getLunchCode() {
		return lunchCode;
	}
	
	public String getAsk() {
		return ask;
	}
	public int getQuan() {
		return quan;
	}
	
	
}
