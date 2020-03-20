package eg.edu.alexu.csd.datastructure.linkedList.cs18010431Eman_Katrin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoubleLinkedListTest {
	@Test
	void test() {
			DoubleLinkedList s=new DoubleLinkedList();
			ILinkedList p;
			ILinkedList f;
			
			        //Initialize a list and some nodes added
					s.add(0);    s.add(1);	 s.add(2);    s.add(3);   s.add(4);  	s.add(5);	s.add(6); s.add(7);
					s.add(8);    s.add(9);   s.add(10);   s.add(11);
					
					//check on the size
					assertEquals(12,s.size());
					
					//check on all possible indices 
					assertEquals(0,s.get(0));  assertEquals(1,s.get(1)); assertEquals(2,s.get(2)); assertEquals(3,s.get(3)); assertEquals(4,s.get(4));
					assertEquals(5,s.get(5));  assertEquals(6,s.get(6)); assertEquals(7,s.get(7)); assertEquals(8,s.get(8)); assertEquals(9,s.get(9));
					assertEquals(10,s.get(10)); assertEquals(11,s.get(11));
					
					//check the special case of invalid index parameter.
					assertEquals(null,s.get(50));   assertEquals(null, s.get(-1));   assertEquals(null, s.get(12));
					
					//add node at an index in the middle of the list check the size and that the node is added at the correct index
					s.add(6, 20);   assertEquals(13,s.size());   assertEquals(20,s.get(6));
					
					//Change one node to point to another element with a value different than the old one by calling check if the node is updated properly.
					s.set(2, 50);   assertEquals(50,s.get(2));
					
					//Remove one node from the list then check the size of the list has been decreased and that the node has been deleted properly
					s.remove(0);   assertEquals(1,s.get(0));    assertEquals(12,s.size());
					s.remove(1);   assertNotEquals(50, s.get(1));   assertEquals(3,s.get(1));   assertEquals(11,s.size());
					
					
					//check contains() method by calling the method with two integers: one that is in the list and another that is not in the list.
					assertEquals(false,s.contains(50));     assertEquals(true,s.contains(5));
					
					//Use sublist() to choose some elements of the list.check that the size of the sublist is correct and the elements are the desired ones.
					p=s.sublist(0, 2);
					assertEquals(3,p.size());
			        assertEquals(true,p.contains(1));   assertEquals(true,p.contains(3));   assertEquals(true,p.contains(4));
					assertEquals(1,p.get(0));           assertEquals(3,p.get(1));           assertEquals(4,p.get(2));   assertEquals(null,p.get(5));
					
					f=s.sublist(2, 5);
				    assertEquals(4,f.size());
				    assertEquals(4,f.get(0));   assertEquals(5,f.get(1));	assertEquals(20,f.get(2));   assertEquals(6,f.get(3));
					f.add(0, 100);
					assertEquals(100,f.get(0));
					
					
					//Clear the elements of the list. check that the list is Empty.
					s.clear();
					assertEquals(true,s.isEmpty());
					assertEquals(0,s.size());
					assertEquals(false,s.contains(5));
		}

}
