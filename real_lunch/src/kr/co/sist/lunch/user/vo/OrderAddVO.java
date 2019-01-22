package kr.co.sist.lunch.user.vo;

public class OrderAddVO {
	private String orderName,	phone,	ipAddress,	lunchCode,request;	
	private int quan;
	public OrderAddVO(String orderName, String phone, String ipAddress, String lunchCode, String request, int quan) {
		super();
		this.orderName = orderName;
		this.phone = phone;
		this.ipAddress = ipAddress;
		this.lunchCode = lunchCode;
		this.request = request;
		this.quan = quan;
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
	public String getRequest() {
		return request;
	}
	public int getQuan() {
		return quan;
	}
	
}
