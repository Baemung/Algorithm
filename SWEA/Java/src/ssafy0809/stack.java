package ssafy0809;

class Node {
	public int data;
	public Node link;
	
	public Node(int data){
		this.data = data;
	}
	
	public Node(int data, Node link){
		this.data = data;
		this.link = link;
	}
	
	@Override
	public String toString() {
		if(link != null) return data+"-"+link;
		else return data+"";
	}
}

class StackTest {
	public Node top;
	
	public StackTest(){
		this.top = null;
	}
	
	public StackTest(Node top){
		this.top = top;
	}
	
	public void push(Node data){
		data.link = this.top;
		top = data;
	}
	
	public Node pop() {
		if(!this.isEmpty()) {
			Node pop = this.top;
			top = pop.link;
			pop.link = null;
			return pop;
		}
		else return null;
		
	}
	
	public boolean isEmpty() {
		if(this.top == null) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		if(this.isEmpty()) return "Stack is Empty!";
		else if(top.link != null) return top.data+"-"+top.link;
		else return top.data+"";
	}
}

public class stack {

	public static void main(String[] args) {
		
		StackTest stack = new StackTest();
		stack.push(new Node(10));
		//stack.push(new Node(20));
		//stack.push(new Node(30));
		stack.push(new Node(50));
		stack.push(new Node(60));
		
		Node s1 = stack.pop();
		Node s2 = stack.pop();
		
		System.out.println(stack.isEmpty());
		System.out.println(s1+" "+s2);
		System.out.println(stack);
	}

}
