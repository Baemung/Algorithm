import java.util.ArrayList;
import java.util.List;

public class Box implements Products{
	List<Products> products = new ArrayList<Products>();
	int price;
	
	public void addProduct(Products product) {
		products.add(product);
	}
	
	@Override
	public int getPrice() {
		for(Products product : products) this.price += product.getPrice();
		return this.price;
	}
}
