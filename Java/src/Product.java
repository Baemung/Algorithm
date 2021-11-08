public class Product implements Products{
	int price = 1000;
	
	@Override
	public int getPrice() {
		return this.price;
	}
}
