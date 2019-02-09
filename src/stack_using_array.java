//import scanner file
import java.util.Scanner;

//make the appropiate class
public class  stack_using_array implements arrayi {
	
	//define the stack as array list
	private single_linked_list_using_array stack =new single_linked_list_using_array();
	
	//just define functions of stack
	//first one is to check emptiness of stack
	public boolean isEmpty() {
		
		//just check len_ of the list
		return(stack.len == 0);
	}
	
	//make the function for pop
	public Object pop() {
		
		//if len is zero throw error
		if (stack.len == 0) {
			
			//just throw the errror
			throw new IndexOutOfBoundsException("your index has reached bounds");
		}
		//else just pop the element
		else {
		//just define new local variable for showing top element
		Object top = stack.show_ith_element(0);
		
		//just delete the top element
		stack.delete_element(0);
		
		//return the top element
		return(top);
		}
	}
	
	//define the push function
	public void push(Object new_element) {
		
		//just add element to 0 th position
		stack.add_element(0, new_element);
	}
	
	//now last function to top
	public Object top() {
		
		//show error for len = 0
		if (stack.len == 0) {
			
			//throw error
			throw new IndexOutOfBoundsException("your index has reached bounds");
		}
		
		//else do the work
		else {
		
		//just return element at 0th index
		return(stack.show_ith_element(0));
			}
	}
	public static void main(String args[]) {
		stack_using_array s = new stack_using_array();
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		Integer t = 0;
		while (temp.matches("stop") != true) {
			
			switch(temp) {
			case "pop":
				System.out.println(s.pop());
				break;
			case "push":
				t = scan.nextInt();
				s.push(t);
				break;
			case "empty":
				System.out.println(s.isEmpty());
				break;
		
			case "top":
				System.out.println(s.top());
				break;
			}
			temp = scan.nextLine();
		}
		scan.close();
	}
}