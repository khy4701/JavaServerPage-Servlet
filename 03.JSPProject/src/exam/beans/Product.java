package exam.beans;

public class Product {

	private int code;
	private String pro_name;
	private int price;
	public Product(int code, String pro_name, int price) {
		this.code = code;
		this.pro_name = pro_name;
		this.price = price;
	}
	
	public Product(int code, String pro_name)
	{
		this.code = code;
		this.pro_name = pro_name;
		this.price  = 1000;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + price;
		result = prime * result + ((pro_name == null) ? 0 : pro_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (code != other.code)
			return false;
		if (price != other.price)
			return false;
		if (pro_name == null) {
			if (other.pro_name != null)
				return false;
		} else if (!pro_name.equals(other.pro_name))
			return false;
		return true;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
}
