//import the exception library for error handeling
import java.lang.IndexOutOfBoundsException;

//first create abstract of the class
//this will contain information regarding the class we are buildng
interface single_linked_list_using_arrayi{
	
	//define a function which will add the element to the list
	//if length is full than size then eed to create new array with n/2 new space
	public void add_element (int pos , Object element);
	
	//delete the element at i th position
	public void delete_element(int pos);
	
	//show the ith element
	public Object show_ith_element(int pos);
}

//create the class having array as building unit of class
//now insertion and deletiation is O(n)
//the <t> denotes the type of object user can use
public class single_linked_list_using_array implements single_linked_list_using_arrayi{

	//create private variable to store the data
	//it should be of type array
	
	private Object list[] = new Object[10];
	
	//define private length variable
	//it should of type int
	public int len = 0;
	
	//make private function which add increase lwngth of array
	private void modify_list() {
		
		//declare new array with length n + n/2
		Object new_list[] = new Object[3*(len)/2 ]; 
		
		//copy all element from existiong list to new one 
		for (int i = 0 ; i <= len - 1 ; i++) {
			
			//now copy ith element to new_list from list
			new_list[i] = list[i]; 
		}
		//at end just change list to new_list and delete new_list
		list = new_list;
	}
	
	//define add element function	
	public void add_element(int pos, Object element) {
		
		//if we need to modify list then we have to do it right now
		if (list.length == len ) {
			
			//then modify the list
			modify_list();
			
			//and element to it
			add_element( pos, element);
		}
		
		//if pos > len - 1 then throw exception
		if (pos > len ) {
			
			//throw the exception
			throw new IndexOutOfBoundsException("the index has reached its maximum length");
		}

		//if len is zero then
		else if (len == 0) {
			
			//just add element at 0
			list[0] = element;
			
			//and increase length l+1
			len++;
		}
		//else move one element left
		else {
			
			//run the for loop for this
			for (int i = len - 1 ; i >= pos ; i--) {
				
				//shift the element to left
				list[i+1] = list[i];
			}
			
			//now just change pos to our desire element
			list[pos] = element;
			
			//and increase length l+1
			len++;
		}
	}
		
		
    //define delete element function	
	public Object show_ith_element(int pos) {
			
			//if pos > len - 1 then throw exception
			if (pos > len - 1) {
				
				//throw the exception
				throw new IndexOutOfBoundsException("the index has reached its maximum length");
			}
			
			//else move one element left 
			else {
				
				//now just return the ith element
				return(list[pos]);
				}
			}
	
	//define delete element function	
	public void delete_element(int pos) {
				
				//if pos > len - 1 then throw exception
				if (pos > len - 1) {
					
					//throw the exception
					throw new IndexOutOfBoundsException("the index has reached its maximum length");
				}
				
				//else move one element left 
				else {
					
					//run the for loop for this
					for (int i = pos ; i <= len - 1 ; i++) {
						
						//shift the element to left
						list[i] = list[i+1];
					}
				}
				
				//just decrese len by one
				len--;
		}	
	
	//must intiate the list
	public single_linked_list_using_array(Object t) {
		
		//now increase length of list by one
		len++;
		
		//just add element to list
		add_element(0,t);
		
		//now reduce the legth by 1
		len--;
	}
	
	//just define contructor to set it to null
	public single_linked_list_using_array(){
	}
			
	public static void main (String args[]) {
		single_linked_list_using_array x = new single_linked_list_using_array();
		x.add_element(0, 0);
		System.out.println(x.show_ith_element(0));
	}
}
