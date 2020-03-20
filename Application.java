package eg.edu.alexu.csd.datastructure.linkedList.cs18010431Eman_Katrin;
	import java.awt.Point;


public class Application implements IPolynomialSolver{
	DoubleLinkedList A=new DoubleLinkedList();
	DoubleLinkedList B=new DoubleLinkedList();
	DoubleLinkedList C=new DoubleLinkedList();
	DoubleLinkedList R=new DoubleLinkedList();
	
	public boolean isEmpty(char poly) {
		 if(poly=='A') { 
			 return A.isEmpty();
		 }
		 else if(poly=='B') {
			 return B.isEmpty();
		 }
		 else if(poly=='C') {
			 return C.isEmpty();
		 }
		 else if(poly=='R') {
			 return R.isEmpty();
		 }
		 return true;
		 
	}
	
	public void set_R(int[][] terms) {
		if(R.size()!=0) {
    		R.clear();
    	}
		for(int i=0;i<terms.length;i++) {
			Point n =new Point(terms[i][0],terms[i][1]);
			R.add(n);
		}
	}
	
	public void add_subtract(char poly) {
		if (poly=='R') {
			for(int i=0;i<R.size();i++) {
				for(int j=R.size()-1;j>=i+1;j--) {
						Point n1=(Point) R.get(i);
						Point n2=(Point) R.get(j);
						if(n1.y==n2.y) {
							n1.x=n1.x+ n2.x;
							R.remove(j);
						}
				}
			}
			for(int i=R.size()-1;i>=0;i--) {
				Point n=(Point) R.get(i);
				if(n.x==0) {
					R.remove(i);
				}
			}
			if(R.size()==0) {
				Point n=new Point(0,0);
				R.add(n);
			}
		}
		else if(poly=='A') {
			for(int i=0;i<A.size();i++) {
				for(int j=A.size()-1;j>=i+1;j--) {
						Point n1=(Point) A.get(i);
						Point n2=(Point) A.get(j);
						if(n1.y==n2.y) {
							n1.x=n1.x+ n2.x;
							A.remove(j);
						}
				}
			}
			for(int i=A.size()-1;i>=0;i--) {
				Point n=(Point) A.get(i);
				if(n.x==0) {
					A.remove(i);
				}
			}
			if(A.size()==0) {
				Point n=new Point(0,0);
				A.add(n);
			}

		}
		else if(poly=='B') {
			for(int i=0;i<B.size();i++) {
				for(int j=B.size()-1;j>=i+1;j--) {
						Point n1=(Point) B.get(i);
						Point n2=(Point) B.get(j);
						if(n1.y==n2.y) {
							n1.x=n1.x+ n2.x;
							B.remove(j);
						}
				}
			}
			for(int i=B.size()-1;i>=0;i--) {
				Point n=(Point) B.get(i);
				if(n.x==0) {
					B.remove(i);
				}
			}
			if(B.size()==0) {
				Point n=new Point(0,0);
				B.add(n);
			}

		}
		else if(poly=='C') {
			for(int i=0;i<C.size();i++) {
				for(int j=C.size()-1;j>=i+1;j--) {
						Point n1=(Point) C.get(i);
						Point n2=(Point) C.get(j);
						if(n1.y==n2.y) {
							n1.x=n1.x+ n2.x;
							C.remove(j);
						}
				}
			}
			for(int i=C.size()-1;i>=0;i--) {
				Point n=(Point) C.get(i);
				if(n.x==0) {
					C.remove(i);
				}
			}
			if(C.size()==0) {
				Point n=new Point(0,0);
				C.add(n);
			}

		}
	}
	
	public int[][] convert_list_to_array(char poly){
		int[][] terms=null;
		 if(poly=='R') {
			terms =new int[R.size][2];
			for(int i=0;i<R.size;i++) {
				Point n=(Point) R.get(i);
				terms[i][0]=n.x;
				terms[i][1]=n.y;
			}
		}
		return terms;
	}
	
	public void swap(int[][] terms,int a,int b) {
		int temp= terms[a][1];
		int temp2= terms[a][0];
		
		terms[a][1] = terms[b][1];
		terms[a][0] = terms[b][0];
		
		terms[b][1] = temp; 
		terms[b][0] = temp2;
	}
	public int[][] sort(int[][] terms){
		for (int i=0;i<terms.length;i++) {
			for(int j=0;j<terms.length-1-i;j++) {
				if(terms[j][1]<terms[j+1][1]) {
					swap(terms,j,j+1);
				}
			}
		}
		return terms;
	}
	
	public void setPolynomial(char poly, int[][] terms) {
    	terms=sort(terms);
    	if(poly=='A'&&A.size()!=0) {
    		A.clear();
    	}
    	else if(poly=='B'&&B.size()!=0) {
    		B.clear();
    	}
    	else if(poly=='C'&&C.size()!=0) {
    		C.clear();
    	}
		if(poly=='A') {
    		for(int i=0;i<terms.length;i++) {
    			Point n =new Point(terms[i][0],terms[i][1]);
    			A.add(n);
    		}
    		add_subtract('A');
    	}
    	else if(poly=='B'){
    		for(int i=0;i<terms.length;i++) {
    			Point n =new Point(terms[i][0],terms[i][1]);
    			B.add(n);
    		}
    		add_subtract('B');
    	}
    	else if(poly=='C') {
    		for(int i=0;i<terms.length;i++) {
    			Point n =new Point(terms[i][0],terms[i][1]);
    			C.add(n);
    		}
    		add_subtract('C');
    	}
    }
    public String print(char poly) {
		String  s="";  String  coeff;  String  exp;   String po="^"; String sign="+";
    	if(poly=='A'&&A.size!=0) {
    		Point n=(Point) A.get(0);
			coeff=String.valueOf(n.x);
			exp=String.valueOf(n.y);  po="^";
			if(n.x==1&&n.y!=0) {
				coeff="";
			}
			if(n.x==-1&&n.y!=0) {
				coeff="-";
			}
			if(n.y==1) {
				exp="";
				po="";
			}
			if(n.y==0&&n.x!=0) {
				s=s+coeff;
			}
			else if(n.x==0) {
				s=s;
			}
			else {
				s=s+coeff+"x"+po+exp;
			}
			for(int i=1;i<A.size;i++) {
				 n=(Point) A.get(i);
				coeff=String.valueOf(n.x);
				exp=String.valueOf(n.y);
				po="^"; sign ="+";
				if(n.x==1&&n.y!=0) {
					coeff="";
				}
				if(n.y==1) {
					exp="";
					po="";
				}
				if(n.x<0) {
					sign="";
				}
				if(n.x==-1&&n.y!=0) {
					coeff="-";
				}
				if(n.y==0&&n.x!=0) {
					s=s+sign+coeff;
				}
				else if(n.x==0) {
					s=s;
				}
				else {
					s=s+sign+coeff+"x"+po+exp;
				}
			}
			return s;		
		}
    	else if(poly=='B'&&B.size!=0) {
    		Point n=(Point) B.get(0);
			coeff=String.valueOf(n.x);
			exp=String.valueOf(n.y);  po="^";
			if(n.x==1&&n.y!=0) {
				coeff="";
			}
			if(n.x==-1&&n.y!=0) {
				coeff="-";
			}
			if(n.y==1) {
				exp="";
				po="";
			}
			if(n.y==0&&n.x!=0) {
				s=s+coeff;
			}
			else if(n.x==0) {
				s=s;
			}
			else {
				s=s+coeff+"x"+po+exp;
			}
			for(int i=1;i<B.size;i++) {
				 n=(Point) B.get(i);
				coeff=String.valueOf(n.x);
				exp=String.valueOf(n.y);
				po="^"; sign ="+";
				if(n.x==1&&n.y!=0) {
					coeff="";
				}
				if(n.x==-1&&n.y!=0) {
					coeff="-";
				}
				if(n.y==1) {
					exp="";
					po="";
				}
				if(n.x<0) {
					sign="";
				}
				if(n.y==0&&n.x!=0) {
					s=s+sign+coeff;
				}
				else if(n.x==0) {
					s=s;
				}
				else {
					s=s+sign+coeff+"x"+po+exp;
				}
			}
			return s;		
    	}
    	else if(poly=='C'&&C.size!=0) {
    		Point n=(Point) C.get(0);
			coeff=String.valueOf(n.x);
			exp=String.valueOf(n.y);  po="^";
			if(n.x==1&&n.y!=0) {
				coeff="";
			}
			if(n.x==-1&&n.y!=0) {
				coeff="-";
			}
			if(n.y==1) {
				exp="";
				po="";
			}
			if(n.y==0&&n.x!=0) {
				s=s+coeff;
			}
			else if(n.x==0) {
				s=s;
			}
			else {
				s=s+coeff+"x"+po+exp;
			}
			for(int i=1;i<C.size;i++) {
				 n=(Point) C.get(i);
				coeff=String.valueOf(n.x);
				exp=String.valueOf(n.y);
				po="^"; sign ="+";
				if(n.x==1&&n.y!=0) {
					coeff="";
				}
				if(n.x==-1&&n.y!=0) {
					coeff="-";
				}
				if(n.y==1) {
					exp="";
					po="";
				}
				if(n.x<0) {
					sign="";
				}
				if(n.y==0&&n.x!=0) {
					s=s+sign+coeff;
				}
				else if(n.x==0) {
					s=s;
				}
				else {
					s=s+sign+coeff+"x"+po+exp;
				}
			}
			return s;			
    	}
    	else if(poly=='R'&&R.size!=0) {
    		Point n=(Point) R.get(0);
			coeff=String.valueOf(n.x);
			exp=String.valueOf(n.y);  po="^";
			if(n.x==1&&n.y!=0) {
				coeff="";
			}
			if(n.x==-1&&n.y!=0) {
				coeff="-";
			}
			if(n.y==1) {
				exp="";
				po="";
			}
			if(n.y==0&&n.x!=0) {
				s=s+coeff;
			}
			else if(n.x==0) {
				s=s;
			}
			else {
				s=s+coeff+"x"+po+exp;
			}
			for(int i=1;i<R.size;i++) {
				 n=(Point) R.get(i);
				coeff=String.valueOf(n.x);
				exp=String.valueOf(n.y);
				po="^"; sign ="+";
				if(n.x==1&&n.y!=0) {
					coeff="";
				}
				if(n.x==-1&&n.y!=0) {
					coeff="-";
				}
				if(n.y==1) {
					exp="";
					po="";
				}
				if(n.x<0) {
					sign="";
				}
				if(n.y==0&&n.x!=0) {
					s=s+sign+coeff;
				}
				else if(n.x==0) {
					s=s;
				}
				else {
					s=s+sign+coeff+"x"+po+exp;
				}
			}
			if(s=="") {
				s="0";
			}
			return s;			
    	}
    	else {
    		return null;
    	}
    	
    }
	
	public void clearPolynomial(char poly) {
		if(poly=='A') {
			A.clear();
		}
		else if(poly=='B') {
			B.clear();
		}
		else if(poly=='C') {
			C.clear();
		}
	}
	
	public float evaluatePolynomial(char poly, float value) {
		float sum=0;
		if(poly=='A'&& A.size!=0) {
			 for(int i=0;i<A.size;i++) {
				 Point n =(Point)A.get(i);
				 sum=(float) (sum +n.x *Math.pow(value, n.y));
			 }
		}
		else if(poly=='B'&& B.size!=0) {
			 for(int i=0;i<B.size;i++) {
				 Point n =(Point)B.get(i);
				 sum=(float) (sum +n.x *Math.pow(value, n.y));
			 }
		}
		else if(poly=='C'&& C.size!=0) {
			 for(int i=0;i<C.size;i++) {
				 Point n =(Point)C.get(i);
				 sum=(float) (sum +n.x *Math.pow(value, n.y));
			 }
		}
		else if(poly=='R'&& R.size!=0) {
			 for(int i=0;i<R.size;i++) {
				 Point n =(Point)R.get(i);
				 sum= (sum +n.x *(float)Math.pow(value, n.y));
			 }
		}	
		return sum;
	}
	
	public int[][] add(char poly1, char poly2){
		R.clear();
		int[][] terms=null;
		if((poly1=='A'&& poly2=='B')||(poly2=='A'&& poly1=='B')) {
			for(int i=0;i<A.size();i++) {
				Point n=(Point) A.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			for(int i=0;i<B.size();i++) {
				Point n=(Point) B.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
			
		}
		else if((poly1=='C'&& poly2=='B')||(poly2=='C'&& poly1=='B')) {
			for(int i=0;i<B.size();i++) {
				Point n=(Point) B.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			for(int i=0;i<C.size();i++) {
				Point n=(Point) C.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
			
		}
		else if((poly1=='A'&& poly2=='C')||(poly2=='A'&& poly1=='C')) {
			for(int i=0;i<A.size();i++) {
				Point n=(Point) A.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			for(int i=0;i<C.size();i++) {
				Point n=(Point) C.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
			
		}
		else if((poly1=='A'&& poly2=='A')) {
			for(int i=0;i<A.size();i++) {
				Point n=(Point) A.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			for(int i=0;i<A.size();i++) {
				Point n=(Point) A.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
			
		}
		else if((poly1=='B'&& poly2=='B')) {
			for(int i=0;i<B.size();i++) {
				Point n=(Point) B.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			for(int i=0;i<B.size();i++) {
				Point n=(Point) B.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
			
		}
		else if((poly1=='C'&& poly2=='C')) {
			for(int i=0;i<C.size();i++) {
				Point n=(Point) C.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			for(int i=0;i<C.size();i++) {
				Point n=(Point) C.get(i);
				Point n2=new Point(n.x,n.y);
				R.add(n2);
			}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);

		}
		
		return terms;
	}
	
	public int[][] subtract(char poly1, char poly2){
		R.clear();
		int[][] terms =null;
		if(poly2=='A') {
			for(int i=0;i<A.size();i++) {
				Point n=(Point) A.get(i);
				n.x=-n.x;
			}
			if(poly1=='B') {
			terms=add('B','A');
			}
			else if(poly1=='C') {
			terms=add('C','A');
			}
			else if(poly1=='A') {
				for(int i=0;i<A.size();i++) {
					Point n=(Point) A.get(i);
					Point n2=new Point(0,n.y);
					R.add(n2);
				}
				add_subtract('R');
				terms = convert_list_to_array('R');
				terms=sort(terms);
				set_R(terms);
			}
			for(int i=0;i<A.size();i++) {
				Point n=(Point) A.get(i);
				n.x=-n.x;
			}
			
		}
		else if(poly2=='B') {
			for(int i=0;i<B.size();i++) {
				Point n=(Point) B.get(i);
				n.x=-n.x;
			}
			if(poly1=='A') {
				terms=add('A','B');
			}
			else if(poly1=='C') {
				terms=add('C','B');
			}
			else if(poly1=='B') {
				for(int i=0;i<B.size();i++) {
					Point n=(Point) B.get(i);
					Point n2=new Point(0,n.y);
					R.add(n2);
				}
				add_subtract('R');
				terms = convert_list_to_array('R');
				terms=sort(terms);
				set_R(terms);
			}
			for(int i=0;i<B.size();i++) {
				Point n=(Point) B.get(i);
				n.x=-n.x;
			}
		}
		else if(poly2=='C') {
			for(int i=0;i<C.size();i++) {
				Point n=(Point) C.get(i);
				n.x=-n.x;
			}
			if(poly1=='A') {
				terms=add('A','C');
			}
			else if(poly1=='B') {
				terms=add('B','C');
			}
			else if(poly1=='C') {
				for(int i=0;i<C.size();i++) {
					Point n=(Point) C.get(i);
					Point n2=new Point(0,n.y);
					R.add(n2);
				}
				add_subtract('R');
				terms = convert_list_to_array('R');
				terms=sort(terms);
				set_R(terms);
			}
			for(int i=0;i<C.size();i++) {
				Point n=(Point) C.get(i);
				n.x=-n.x;
			}
		}
		return terms;
	}
	
	public int[][] multiply(char poly1, char poly2){
		R.clear();
		int[][] terms=null;
		int i,j;
		if((poly1=='A'&& poly2=='B')||(poly2=='A'&& poly1=='B')) {
			for(i=0;i<A.size();i++) {
				for(j=0;j<B.size();j++) {
					Point n1=(Point) A.get(i);
					Point n2=(Point) B.get(j);
					Point temp = new Point((n1.x*n2.x),(n1.y+n2.y));
					R.add(temp);
				}
			}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
		}
		else if((poly1=='C'&& poly2=='B')||(poly2=='C'&& poly1=='B')) {
			for(i=0;i<B.size();i++) {
				for(j=0;j<C.size();j++) {
					Point n1 =(Point) B.get(i);
					Point n2 =(Point) C.get(j);
					Point temp = new Point((n1.x*n2.x),(n1.y+n2.y));
					R.add(temp);
				}
	     	}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
	   }
		else if((poly1=='A'&& poly2=='C')||(poly2=='A'&& poly1=='C')) {
			for(i=0;i<A.size();i++) {
				for(j=0;j<C.size();j++) {
					Point n1 =(Point) A.get(i);
					Point n2 =(Point) C.get(j);
					Point temp = new Point((n1.x*n2.x),(n1.y+n2.y));
					R.add(temp);
				}
	     	}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
		}
		else if((poly1=='A'&& poly2=='A')) {
			for(i=0;i<A.size();i++) {
				for(j=0;j<A.size();j++) {
					Point n1=(Point) A.get(i);
					Point n2=(Point) A.get(j);
					Point temp = new Point((n1.x*n2.x),(n1.y+n2.y));
					R.add(temp);
				}
			}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
		}
		else if((poly1=='B'&& poly2=='B')) {
			for(i=0;i<B.size();i++) {
				for(j=0;j<B.size();j++) {
					Point n1=(Point) B.get(i);
					Point n2=(Point) B.get(j);
					Point temp = new Point((n1.x*n2.x),(n1.y+n2.y));
					R.add(temp);
				}
			}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
		}
		else if((poly1=='C'&& poly2=='C')) {
			for(i=0;i<C.size();i++) {
				for(j=0;j<C.size();j++) {
					Point n1=(Point) C.get(i);
					Point n2=(Point) C.get(j);
					Point temp = new Point((n1.x*n2.x),(n1.y+n2.y));
					R.add(temp);
				}
			}
			add_subtract('R');
			terms = convert_list_to_array('R');
			terms=sort(terms);
			set_R(terms);
		}
		return terms;

	}

}