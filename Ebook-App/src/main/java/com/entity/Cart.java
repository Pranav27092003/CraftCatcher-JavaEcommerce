package com.entity;

public class Cart {
		private int cid;
		private int iid;
		private int uid;
		private String itemName;
		private Double price;
		private Double totalprice;
		public Cart(int cid, int iid, int uid, String itemName, Double price, Double totalprice) {
			super();
			this.cid = cid;
			this.iid = iid;
			this.uid = uid;
			this.itemName = itemName;
			this.price = price;
			this.totalprice = totalprice;
		}
		
		public Cart() {
			// TODO Auto-generated constructor stub
		}
		
		
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public int getIid() {
			return iid;
		}
		public void setIid(int iid) {
			this.iid = iid;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public Double getTotalprice() {
			return totalprice;
		}
		public void setTotalprice(Double totalprice) {
			this.totalprice = totalprice;
		}
		

		
}
