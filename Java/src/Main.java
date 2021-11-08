public class Main {
	public static void main(String[] args) {
		Box box1 = new Box();
		box1.addProduct(new Product());
		box1.addProduct(new Product());
		box1.addProduct(new Product());
		
		Box box2 = new Box();
		box2.addProduct(new Product());
		box2.addProduct(new Product());
		box2.addProduct(box1);
		
		Box product = new Box();
		product.addProduct(new Product());
		product.addProduct(box2);
		
		System.out.println(product.getPrice());
	}
}
