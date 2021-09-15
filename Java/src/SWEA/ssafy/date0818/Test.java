package SWEA.ssafy.date0818;

class Test1{
	int x;
	int idx;
	Test1(int x, int idx){
		this.x = x;
		this.idx = idx;
	}
}

public class Test {
	
	public static void main(String[] args) {

		Test1[] t = new Test1[1];
		t[0] = new Test1(2,1);
		
		Integer[] a = new Integer[5];
		Integer[] b = new Integer[6];
		
		for(Test1 test : t) {
			a[test.idx] = test.x;
			b[test.idx] = test.x;
		}
		
		
		System.out.println(a[1]+" "+b[1]);
		
		if(a[1] == b[1]) System.out.println("same");
		else System.out.println("diff");
		
		if(a[1].equals(b[1])) System.out.println("same");
		else System.out.println("diff");

	}
}
