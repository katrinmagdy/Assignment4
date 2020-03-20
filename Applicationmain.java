package eg.edu.alexu.csd.datastructure.linkedList.UIApplication;
import java.util.InputMismatchException;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedList.cs18010431Eman_Katrin.Application;
public class Applicationmain {

	public static void main(String[] args) throws RuntimeException {
	/*	class StockTrading{
			   public String getDescription(){
			   return "StockTrading";
			  }
			}*/
		Application application=new Application();
		Scanner s=new Scanner(System.in);
		int i,x=0,j;
		int[] extra=new int[100];
		int[][] terms=null;
		char poly=' ',poly1=' ',poly2=' ';
		float valid=1f;
		int v=0;
		while(true) {
			//menu of options
			System.out.println("====================================================================");
			System.out.println("Please choose an action");
			System.out.println("-----------------------");
			System.out.println("1- Set a polynomial variable");
			System.out.println("2- Print the value of a polynomial variable");
			System.out.println("3- Add two polynomials");
			System.out.println("4- Subtract two polynomials");
			System.out.println("5- Multiply two polynomials");
			System.out.println("6- Evaluate a polynomial at some point");
			System.out.println("7- Clear a polynomial variable");
			System.out.println("====================================================================");
			
			if(s.hasNextInt()) {
				x=s.nextInt();
			}
			else if(s.hasNextLine()) {
				s.next();
				try {
				x=s.nextInt();
				}
				catch(InputMismatchException m){
					System.out.println(m.getMessage());
				}
			}
			//take inputs according to choice and check for validation
			if(x==2||x==6||x==7) {
				while(true) {
					System.out.println("Insert the variable name: A, B, C or R");
					try {
					   poly = s.next().charAt(0);
					  if((poly!='A')&&(poly!='B')&&(poly!='C')&&(poly!='R')) {
						throw new RuntimeException("Invalid Polynomial");
					  }
					  else {
							if(application.isEmpty(poly)) {
								throw new RuntimeException("Variable not set");
							}
							else {
								break;
							}
						
					   }
					}
					catch(RuntimeException e) {
						System.out.println(e.getMessage());
					  }
					
					}
				
			}
			else if(x==3||x==4||x==5) {
				while(true) {
					System.out.println("Insert first operand variable name: A, B or C");
					try {
					   poly1 = s.next().charAt(0);
					  if((poly1!='A')&&(poly1!='B')&&(poly1!='C')) {
						throw new RuntimeException("Invalid Polynomial");
					  }
					  else {
							if(application.isEmpty(poly1)) {
								throw new RuntimeException("Variable not set");
							}
							else {
								break;
							}
						
					   }
					}
					catch(RuntimeException e) {
						System.out.println(e.getMessage());
					  }
					
					}
				while(true) {
					System.out.println("Insert the second operand variable name: A, B or C");
					try {
					   poly2 = s.next().charAt(0);
					  if((poly2!='A')&&(poly2!='B')&&(poly2!='C')) {
						throw new RuntimeException("Invalid Polynomial");
					  }
					  else {
							if(application.isEmpty(poly2)) {
								throw new RuntimeException("Variable not set");
							}
							else {
								break;
							}
						
					   }
					}
					catch(RuntimeException e) {
						System.out.println(e.getMessage());
					  }
					
					}
				
			}
			//Do according to input 
			if(x==1) {
				while(true) {
					System.out.println("Insert the variable name: A, B or C");
				try {
				   poly = s.next().charAt(0);
				  if((poly!='A')&&(poly!='B')&&(poly!='C')) {
					throw new RuntimeException("Invalid Polynomial");
				  }
				  else {
					break;
				   }
				}
				catch(RuntimeException e) {
					System.out.println(e.getMessage());
				  }
				}
				String str=new String();
				s.nextLine();
				while(valid%2!=0) {
					int o=1;
				
				
				while(o!=0) {
				System.out.println("Insert the polynomial terms in the form:");
				System.out.println("(coeff1, exponent1), (coeff2, exponent2), ..");
				o=1;
				try {
				str =s.nextLine();
				for(int p=0;p<str.length();p++) {
					if(str.charAt(p)==' '||str.charAt(p)=='('||str.charAt(p)==')'||str.charAt(p)==','||str.charAt(p)=='-') {
						o=0;
						continue;
					}
					else {
						try {
							Integer.parseInt( ""+(str.charAt(p)));
						}
						catch(NumberFormatException k){
							o=-1;
							System.out.println(k.getMessage());
							break;
						}
						if(o!=-1&&o!=0) {
						throw new RuntimeException("InvalidInput");
						}
					}
					o=1;
				}
				}
				catch(RuntimeException c){
					System.out.println(c.getMessage());
				}
				}
				i=0;j=0;
				
				while(i<str.length()) {
				if(str.charAt(i)==' '||str.charAt(i)=='('||str.charAt(i)==')'||str.charAt(i)==',') {
					i++;
				}
				else if(str.charAt(i)=='-') {
					i++;
					extra[j]=-Integer.parseInt(String.valueOf(str.charAt(i)));
					i++;
					j++;
				}
				else {
					extra[j]=Integer.parseInt(String.valueOf(str.charAt(i)));
					i++;
					j++;
				}
				}
				try {
				valid=j;
				if((valid%2)!=0||(valid==0)) {
				if(valid%2!=0) {
					v=1;
					throw new RuntimeException("Invalid as noOfIntegers is odd");
				}
				if(valid==0) {
					v=1;
					throw new RuntimeException("No integers are entered");
				}
				}
				else {
					v=2;
				}
				}
				
				catch(RuntimeException c){
					v=1;
					System.out.println(c.getMessage());
				}
				if(v==2) {
					int no_terms=j/2;
					terms =new int[no_terms][2]; j=0;
				for(i=0;i<no_terms;i++) {
					terms[i][0]=extra[j];
					terms[i][1]=extra[j+1];
					j=j+2;
				}
				
				}
				else {
					valid=1;
					j=0;i=0;
					continue;
				}
			}
				application.setPolynomial(poly, terms);
				System.out.printf("Polynomial %c is set",poly);
				System.out.println();
				valid=3;
			}
			else if(x==2) {

				String str =application.print(poly);
				System.out.printf("Value in %c:",poly);				
				System.out.println(str);
	
			}
			else if(x==3) {
				
				terms = application.add(poly1, poly2);
				System.out.print("Result set in R: ");
				System.out.printf("(%d ,%d)", terms[0][0],terms[0][1]);
				for(i=1;i<terms.length;i++) {
					System.out.printf(", (%d ,%d)", terms[i][0],terms[i][1]);
				}
				System.out.println();
				
			}
			else if(x==4) {
				
				terms = application.subtract(poly1, poly2);
				System.out.print("Result set in R: ");
				System.out.printf("(%d ,%d)", terms[0][0],terms[0][1]);
				for(i=1;i<terms.length;i++) {
					System.out.printf(", (%d ,%d)", terms[i][0],terms[i][1]);
				}
				System.out.println();
				
			}
			else if(x==5) {

				terms = application.multiply(poly1, poly2);
				System.out.print("Result set in R: ");
				System.out.printf("(%d ,%d)", terms[0][0],terms[0][1]);
				for(i=1;i<terms.length;i++) {
					System.out.printf(", (%d ,%d)", terms[i][0],terms[i][1]);
				}
				System.out.println();
				
			}
			else if(x==6) {
				
				System.out.println("Enter a floating point constant :");
				float a =s.nextFloat();
				float result =application.evaluatePolynomial(poly, a);
				System.out.printf("Value of %c at %f is: %f ",poly,a,result);
				System.out.println();
				
				
			}
			else if(x==7) {
				
				application.clearPolynomial(poly);
				System.out.printf("Polynomial %c is cleared ",poly);
				System.out.println();
				
			}
			else {
				System.out.println("Invalid input");
			}
		
		}

	}

}
