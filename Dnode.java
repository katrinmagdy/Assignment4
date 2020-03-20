package eg.edu.alexu.csd.datastructure.linkedList.cs18010431Eman_Katrin;
	public class Dnode {
		
		private Object element;
		private Dnode prev;
		private Dnode next;
		
		public Dnode (Object s ,Dnode p,Dnode n) {
			element=s;
			prev=p;
			next=n;
		}
		
		public Object getElement() { return element; }
		
		public Dnode getNext() { return next; }
		
		public Dnode getprev() { return prev; }
		
		public void setElement(Object newElem) {element = newElem;}
		
		public void setNext(Dnode newNext) { next = newNext; }
		
		public void setprev(Dnode newprev) { prev = newprev; }


	}

