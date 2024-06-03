package com.entity;

public class ItemDtls {
		private int itemId;
		private String itemname;
		private String category;
		private String user_email;
		private String itemphoto;
		private String price;
		public ItemDtls(String itemname, String category, String user_email, String itemphoto, String price) {
			super();
			this.itemname = itemname;
			this.category = category;
			this.user_email = user_email;
			this.itemphoto = itemphoto;
			this.price = price;
		}
		
		public ItemDtls() {
			
		}

		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		public String getItemname() {
			return itemname;
		}
		public void setItemname(String itemname) {
			this.itemname = itemname;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getUser_email() {
			return user_email;
		}
		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}
		public String getItemphoto() {
			return itemphoto;
		}
		public void setItemphoto(String itemphoto) {
			this.itemphoto = itemphoto;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "ItemDtls [itemId=" + itemId + ", itemname=" + itemname + ", category=" + category + ", user_email="
					+ user_email + ", itemphoto=" + itemphoto + ", price=" + price + "]";
		}
		
		
}
