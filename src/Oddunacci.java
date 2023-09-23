import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Oddunacci {

	public static void main(String[] args) {
		PrintWriter pw = null;//create a printwriter object
		try {
			pw = new PrintWriter(new FileOutputStream("OddoOut.txt"));
			System.out.println("File Opened");
			pw.println("This is the linear version");
			long startTime = System.currentTimeMillis();//record time before execution of linear algorithm
			for (int i = 5; i <= 100; i += 5) {
				long[] result = OddunacciLinear(i);
				pw.println(result[0]);
			}
			long endTime = System.currentTimeMillis();//record time before execution of linear algorithm
			long elapsed = endTime - startTime;//calculating time taken by linear algorithm to run
			pw.println("Time elapsed is "+elapsed+" milliseconds.");
			System.out.println("Linear done");
			pw.println("This is the Binary version");
			startTime = System.currentTimeMillis();//record time before execution of binary algorithm
			for (int i = 5; i <= 40; i += 5) {
				pw.println(oddunacciBinary(i));
			}
			endTime = System.currentTimeMillis();//record time after execution of binary algorithm
			elapsed = endTime - startTime;//calculate time taken by binary algorithm to run
			pw.println("Time elapsed is "+elapsed+" milliseconds.");
			System.out.println("Bin done");
			
		}catch(FileNotFoundException e) {
			System.out.println("Could Not open file.");//print error message if file could not be created
		}
		pw.close();//close printwriter object

	}
	public static long oddunacciBinary(int n) {
		if (n <= 3)//base case
			return 1;
		else
			return oddunacciBinary(n-3) + oddunacciBinary(n-2) + oddunacciBinary(n-1);//recursive case
	}
	public static long[ ] OddunacciLinear(int n) {
		if (n <= 4) {//base case
			long[ ] answer = {n - 1, 1, 1};
			return answer;
		} else {
			long[ ] temp = OddunacciLinear(n - 1); //recursive case
			long[ ] answer = {temp[0] + temp[1] + temp[2], temp[0], temp[1]}; //computing current term
			return answer;
		}
	}
	public static int tailRecursiveOddunacci(int n, int a, int b, int c) {
		 if (n == 1)//base cases
	         return a;
	     if (n == 2)
	    	 return b;
	     if (n == 3)
	    	 return c;
	     return tailRecursiveOddunacci(n - 1, b, c, a + b + c);//computation of current term and recursing
		}
}

