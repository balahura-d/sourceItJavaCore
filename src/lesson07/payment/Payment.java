package lesson07.payment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lesson9.homework9.DefaultMyList;

/**
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно
 * сформировать покупку из нескольких товаров.
 * 
 * @author Дом
 */
public class Payment {

	List<Purchase> purchase = new ArrayList<>();
	StringBuilder sb;

	public boolean addProduct(int id, String productName, double productPrice) {
		purchase.add(new Purchase(id, productName, productPrice));
		return true;
	}

	public boolean removeProduct(int id) {
		purchase.remove((purchase.stream().filter((p) -> (p.getId() == id)).findFirst()).get());
		return true;
	}

	public String submit() {
		sb = new StringBuilder("<Volshebnaja Shkatulka> Shop" + LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString()
				+ System.lineSeparator());
		DefaultMyList<Purchase> dml = new DefaultMyList<>();
		for (Purchase purchase2 : purchase) {
			dml.add(purchase2);
		}
		for (int i = 0; i < dml.size(); i++) {
			sb.append("[" + dml.get(i).getId() + "]\t[");
			if (dml.get(i).getProductName().length() < 6) {
				sb.append(dml.get(i).getProductName() + "]\t\t\t");// "1234567\t\t\t*"
			} else if (dml.get(i).getProductName().length() < 14) {
				sb.append(dml.get(i).getProductName() + "]\t\t");// "123456789012\t\t*"
			} else if (dml.get(i).getProductName().length() > 23) {
				sb.append(dml.get(i).getProductName().substring(0, 22) + "]");// "123456789012345678901234*"
			} else {
				sb.append(dml.get(i).getProductName() + "]\t");// "123456789012345678\t*"
			}
			sb.append(String.format("[%d]\t", dml.getNum(i)));
			sb.append(String.format("[%8.2f]%n", dml.get(i).getProductPrice() * dml.getNum(i)));
		}
		sb.append(">>>TOTAL:" + purchase.stream().mapToDouble((p)-> p.getProductPrice()).sum());
		System.out.println(sb);
		return sb.toString();
	}

	class Purchase {

		private int id;
		private String productName;
		private double productPrice;

		/**
		 * @param id
		 * @param productName
		 * @param productPrice
		 */
		public Purchase(int id, String productName, double productPrice) {
			super();
			this.id = id;
			this.productName = productName;
			this.productPrice = productPrice;
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @return the productName
		 */
		public String getProductName() {
			return productName;
		}

		/**
		 * @return the productPrice
		 */
		public double getProductPrice() {
			return productPrice;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + id;
			result = prime * result + ((productName == null) ? 0 : productName.hashCode());
			long temp;
			temp = Double.doubleToLongBits(productPrice);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Purchase other = (Purchase) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id != other.id)
				return false;
			if (productName == null) {
				if (other.productName != null)
					return false;
			} else if (!productName.equals(other.productName))
				return false;
			if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
				return false;
			return true;
		}

		private Payment getOuterType() {
			return Payment.this;
		}
	}
}