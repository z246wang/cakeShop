package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.*;

import utils.PriceUtil;

public class Order {
	private int id;
	private float total;
	private int amount;
	private int status;
	private int paytype;
	private String name;
	private String phone;
	private String address;
	private LocalDateTime datetime;
	private User user;
	private Map<Integer,OrderItem> itemMap = new HashMap<Integer,OrderItem>();
	private List<OrderItem> itemList = new ArrayList<OrderItem>();
	
	public void setUsername(String username) {
		user = new User();
		user.setUsername(username);
	}
	
	public void addGoods(Goods g) {
		if(itemMap.containsKey(g.getId())) {
			OrderItem item = itemMap.get(g.getId());
			item.setAmount(item.getAmount()+1);
		}else {
			OrderItem item = new OrderItem(g.getPrice(),1,g,this);
			itemMap.put(g.getId(), item);
		}
		amount++;
		total = PriceUtil.add(total, g.getPrice());
	}
	
	public List<OrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}

	public void lessen(int goodsid) {
		if(itemMap.containsKey(goodsid)) {
			OrderItem item = itemMap.get(goodsid);
			item.setAmount(item.getAmount()-1);
			amount--;
			total = PriceUtil.subtract(total, item.getPrice());
			if(item.getAmount()<=0) {
				itemMap.remove(goodsid);
			}
		}
	}
	
	public Map<Integer, OrderItem> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<Integer, OrderItem> itemMap) {
		this.itemMap = itemMap;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPaytype() {
		return paytype;
	}
	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
