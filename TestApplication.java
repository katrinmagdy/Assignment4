package eg.edu.alexu.csd.datastructure.linkedList.cs18010431Eman_Katrin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TestApplication {

	@Test
	public void Apptest() {
		Application n=new Application();
		
		//Initialize an array of terms were column 0 is the coefficient and column 1 is the exponent
		int[][] test =new int[4][2];
		test[0][0]=8;       test[0][1]=-3;
		test[1][0]=2;       test[1][1]=4;
		test[2][0]=-3;      test[2][1]=5;
		test[3][0]=5;       test[3][1]=6;
		
		//set a polynomial and print it to check it is set
		n.setPolynomial('A',test);
		String s= n.print('A');
		assertEquals("5x^6-3x^5+2x^4+8x^-3",s);
		
		//evaluate a polynomial and check the value
		float evaluate =n.evaluatePolynomial('A', 2);
		assertEquals(257.0,evaluate);
		
		//Initialize an array of terms were column 0 is the coefficient and column 1 is the exponent
		 test =new int[4][2];
		test[0][0]=8;       test[0][1]=-3;
		test[1][0]=0;       test[1][1]=4;
		test[2][0]=-3;      test[2][1]=0;
		test[3][0]=1;       test[3][1]=6;
				
		//set a polynomial and print it to check it is set
		n.setPolynomial('A',test);
	    s= n.print('A');
		assertEquals("x^6-3+8x^-3",s);
		
		
		//clear a polynomial and print it to check it is set
		n.clearPolynomial('A');
		s= n.print('A');
		assertEquals(null,s);
		
		//evaluate an empty polynomial and check the value
	    evaluate =n.evaluatePolynomial('A', 2);
		assertEquals(0.0,evaluate);
		
		//Initialize another polynomials
		//polynomial B
		int[][] test1 =new int[4][2];
		test1[0][0]=8;       test1[0][1]=-3;
		test1[1][0]=2;       test1[1][1]=4;
		test1[2][0]=3;       test1[2][1]=5;
		test1[3][0]=5;       test1[3][1]=6;
		
		n.setPolynomial('B',test1);
		s= n.print('B');
		assertEquals("5x^6+3x^5+2x^4+8x^-3",s);
		
		//polynomial C
		int[][] test2 =new int[3][2];
		test2[0][0]=1;       test2[0][1]=5;
		test2[1][0]=3;       test2[1][1]=4;
		test2[2][0]=2;       test2[2][1]=2;
		
		n.setPolynomial('C', test2);
		s= n.print('C');
		assertEquals("x^5+3x^4+2x^2",s);
		
		
		//add B and C
		int[][] terms=n.add('B', 'C');
		s= n.print('R');
		assertEquals("5x^6+4x^5+5x^4+2x^2+8x^-3",s);
		
		int[][] test3 =new int[5][2];
		test3[0][0]=5;       test3[0][1]=6;
		test3[1][0]=4;       test3[1][1]=5;
		test3[2][0]=5;       test3[2][1]=4;
		test3[3][0]=2;       test3[3][1]=2;
		test3[4][0]=8;       test3[4][1]=-3;
		
		for(int i=0;i<terms.length;i++) {
			assertEquals(true,Arrays.equals(terms[i], test3[i]));
		}
		
		n.add('B', 'B');
		s= n.print('R');
		assertEquals("10x^6+6x^5+4x^4+16x^-3",s);
		
		n.add('C', 'C');
		s= n.print('R');
		assertEquals("2x^5+6x^4+4x^2",s);
		
		
		
		//multiply B*C
		terms= n.multiply('B', 'C');
		s= n.print('R');
		assertEquals("5x^11+18x^10+11x^9+16x^8+6x^7+4x^6+8x^2+24x+16x^-1",s);
		
		test3 =new int[9][2];
		test3[0][0]=5;       test3[0][1]=11;
		test3[1][0]=18;       test3[1][1]=10;
		test3[2][0]=11;       test3[2][1]=9;
		test3[3][0]=16;       test3[3][1]=8;
		test3[4][0]=6;       test3[4][1]=7;
		test3[5][0]=4;       test3[5][1]=6;
		test3[6][0]=8;       test3[6][1]=2;
		test3[7][0]=24;       test3[7][1]=1;
		test3[8][0]=16;       test3[8][1]=-1;
		
		
		for(int i=0;i<terms.length;i++) {
			assertEquals(true,Arrays.equals(terms[i], test3[i]));
		}
		
		//subtract B-C
		terms= n.subtract('B', 'C');
		s= n.print('R');
		assertEquals("5x^6+2x^5-x^4-2x^2+8x^-3",s);
		
		test3 =new int[5][2];
		test3[0][0]=5;       test3[0][1]=6;
		test3[1][0]=2;       test3[1][1]=5;
		test3[2][0]=-1;       test3[2][1]=4;
		test3[3][0]=-2;       test3[3][1]=2;
		test3[4][0]=8;       test3[4][1]=-3;
		
		for(int i=0;i<terms.length;i++) {
			assertEquals(true,Arrays.equals(terms[i], test3[i]));
		}
		
		n.subtract('B', 'B');
		s= n.print('R');
		assertEquals("0",s);
		
		//clear a polynomial and print it to check it is set
		n.clearPolynomial('B');
		s= n.print('B');
		assertEquals(null,s);
		
		n.clearPolynomial('C');
		s= n.print('C');
		assertEquals(null,s);
		
	}
}
