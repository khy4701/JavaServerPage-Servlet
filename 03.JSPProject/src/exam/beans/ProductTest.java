package exam.beans;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product p1 = new Product(1,"1",1);
		Product p2 = new Product(1,"1",1);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2));		
	}
}
