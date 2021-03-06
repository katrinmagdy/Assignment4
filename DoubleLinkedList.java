package eg.edu.alexu.csd.datastructure.linkedList.cs18010431Eman_Katrin;

public class DoubleLinkedList implements ILinkedList{
	Dnode head;
	Dnode trailer;
	int size=0;
	public DoubleLinkedList() {
		size = 0;
		head = new Dnode(null, null, null); // create header
		trailer = new Dnode(null, head, null); // create trailer
		head.setNext(trailer);
		            }

    public void add(int index, Object element) {
    	if((size+1)>index&& index>=0) {
    		Dnode v=head;
    		for(int i=0;i<(index-1)+1;i++) {
    			v=v.getNext();
    		}
    		Dnode z =new Dnode(element,null,null);
    		Dnode w =v.getNext();
    		z.setprev(v);
    		z.setNext(w);
    		w.setprev(z);
    		v.setNext(z);
    		size=size+1;
    	}
    }
	
	public void add(Object element) {
		Dnode z =new Dnode(element,null,null);
		Dnode w=trailer.getprev();
		z.setprev(w);
		z.setNext(trailer);
		w.setNext(z);
		trailer.setprev(z);
		size=size+1;
		
	}
	
	public Object get(int index) {
		if(index<size&&index>=0) {
		Dnode v=head;
		for(int i=0;i<index+1;i++) {
			v=v.getNext();
		}
		return (v.getElement());
		}
		else {
			return null;
		}
	}
	
	public void set(int index, Object element) {
		if(index<size&&index>=0) {
		Dnode v=head;
		for(int i=0;i<index+1;i++) {
			v=v.getNext();
		}
		v.setElement(element);
		}
	}
	
	public void clear() {
		head.setNext(trailer);
		trailer.setprev(head);
		size=0;
		
	}
	
	public boolean isEmpty() {
		 return (size ==0); 
	}
	
	public void remove(int index) {
		if(index<size&&index>=0) {
			Dnode v=head;
		for(int i=0;i<index+1;i++) {
			v=v.getNext();
		}
		Dnode p=v.getprev();
		Dnode n=v.getNext();
		p.setNext(n);
		n.setprev(p);
		v.setNext(null);
		v.setprev(null);
		size--;
	  }
	}
	
	public int size() {
		 return size;
	}
	
	public ILinkedList sublist(int fromIndex, int toIndex) {

		DoubleLinkedList n =new DoubleLinkedList();
	    
	    for(int i=fromIndex;i<=toIndex;i++) {
	    	n.add(get(i));
	    }
	    return n;
		
	}
	
	public boolean contains(Object o) {
		Dnode v=head;
		while(v.getNext()!=null) {
			v=v.getNext();
			if(v.getElement()==o) {
				return true;
			}
		}
		return false;
	}
}
