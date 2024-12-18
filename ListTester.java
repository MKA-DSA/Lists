
public class ListTester {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		// ArrayBasedList<Integer> list = new ArrayBasedList<Integer>();
		// add
		for (int i = 10; i >= 0; i--) {
			list.add(i);
		}
		System.out.println(list);
		System.out.println(list.length());

		// insert
		
		try {
			// adding to end
			System.out.print("Shoud add 1000 to end ");
			list.insert(1000, list.length());
			System.out.println(list);
			System.out.println(list.length());

			// adding to beginning
			list.insert(-1000, 0);
			System.out.print("Shoud add -1000 to beginning ");
			System.out.println(list);
			System.out.println(list.length());

			// adding in the middle
			list.insert(-394, 2);
			System.out.print("Shoud add -394 to pos 2 ");

			System.out.println(list);
			System.out.println(list.length());

			
		} catch(Exception E) { System.out.println(E); }
		try {
			System.out.print("Shoud output exception: ");
			// testing bounds on insert
			list.insert(10000, 10000);
		} catch(Exception E) { System.out.println(E); }
	/*	System.out.println(list);
		
		System.out.println("Finding 9 - should output 1: " + list.find(9));
		System.out.println("Finding 8293 - should output -1: " + list.find(8293));
		
		try {
			System.out.println("Getting 2 - should output 8: " + list.get(2));
			System.out.println("Getting 8293 - should cause Out of Bounds ");
			list.get(8293);
		} catch(Exception E) { System.out.println(E); }
		*/
		/*try {
			System.out.println("Setting pos 0 to -15 " + list.set(-15, 0));
			System.out.println(list);
			System.out.println("Setting pos 5 to -20 " + list.set(-20, 5));
			System.out.println(list);
			System.out.println("Setting pos 10 to -20 " + list.set(-20, 10));
			System.out.println(list);
			System.out.println("Setting pos 12329 to -15: should cause error ");
			list.set(-15, 12329);
		} catch(Exception E) { System.out.println(E); }
		*/
		//testing removes
		try {
			/*System.out.println("Remove position 5: should show -20 " + list.remove(5));
			System.out.println(list);
			
			System.out.println("Remove position 0: should show -15 " + list.remove(0));
			System.out.println(list);*/
			System.out.println(list);
			System.out.println(list.length());
			System.out.println("Remove position size-1: should show 1000 " + list.remove(list.length()-1));
			System.out.println(list);
			
			
			System.out.println("Remove elt 5: should show true " + list.remove((Integer) 5));
			System.out.println(list);
			System.out.println("Remove elt -1000: should show true " + list.remove((Integer) (-1000)));
			System.out.println(list);
			System.out.println("Remove elt 0: should show true " + list.remove((Integer) 0));
			System.out.println(list);
			System.out.println("Remove elt 18492: should show false " + list.remove((Integer) 18492));
			System.out.println(list);
			System.out.println(list.length());



		} catch(Exception E) { System.out.println(E); }
		System.out.println(list);
		list.sort();
		System.out.println("Printing sorted list: "  + list);
		list.clear();
		System.out.println("Printing the cleared list: " + list);
		
	}
}


/* 10 9 8 7 6 5 4 3 2 1 0 
10 10 9 19 8 7 28 6 5 37 4 3 46 2 1 55 0 
Shoud add 1000 to end 10 10 9 19 8 7 28 6 5 37 4 3 46 2 1 55 0 1000 
Shoud add -1000 to beginning -1000 10 10 9 19 8 7 28 6 5 37 4 3 46 2 1 55 0 1000 
Shoud output exception: java.lang.IndexOutOfBoundsException
Finding 19 - should output 4: 4
Finding 8293 - should output -1: -1
Getting 5 - should output 8: 8
Finding 8293 - should cause Out of Bounds 
java.lang.IndexOutOfBoundsException
Setting pos 0 to -15 true
-15 10 10 9 19 8 7 28 6 5 37 4 3 46 2 1 55 0 1000 
Setting pos 12329 to -15: should cause error 
Remove position 5: should show 8 8
-15 10 10 9 19 7 28 6 5 37 4 3 46 2 1 55 0 1000 
Remove elt 5: should show true true
-15 10 10 9 19 7 28 6 37 4 3 46 2 1 55 0 1000 
Remove elt 18492: should show false false
-15 10 10 9 19 7 28 6 37 4 3 46 2 1 55 0 1000 
Remove position 58: should cause error
java.lang.IndexOutOfBoundsException
Printing sorted list: -15 0 1 2 3 4 6 7 9 10 10 19 28 37 46 55 1000 
Printing the cleared list: 
*/
