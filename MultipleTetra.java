/**
 * @author Nathan Crozier (40048644)
 * @version 4.13.0
 */


import java.io.*;

//
/**
 * The Class MultipleTetra.
 */
public class MultipleTetra {
	
	/**
	 * Calculate the tetranacci number corresponding to the index you passed..
	 *
	 * @param n the index you wish to calculate to.
	 * @return the tetrancci number corresponding to the index you passed.
	 */
	public static long calculateTetra(int n) {
		if (n <= 2)
			return 0;
		else

		if (n == 3)
			return 1;
						//base cases
		else

			return (calculateTetra(n - 1) + calculateTetra(n - 2) + calculateTetra(n - 3) + calculateTetra(n - 4)); //if we don't meet the base cases, make our recursive calls.

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		

		File output = new File("multipleOut.txt"); //create a file to print to.

		PrintWriter fileWriter = null;

		try {
			fileWriter = new PrintWriter(new FileOutputStream(output), true);

			for (int n = 5; n <= 50; n+=5) { //Printing up to T(50) instead of T(100) as it takes too long to do so.
				System.out.println("Attempting a calculation using " + n + "...");
			long startTime = System.nanoTime();

			fileWriter.println("Running the multiple tetra calculator on an input of: " + n
					+ "\nThe result we got was: " + MultipleTetra.calculateTetra(n));

			long endTime = System.nanoTime();

			long totalTime = (endTime - startTime);

			fileWriter.println("The total time elapsed is: " + totalTime + " nanoseconds.");
			fileWriter.println();
			
			fileWriter.flush();
			System.out.println("Wrote to file for " + n + "...");
			}
			
			fileWriter.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}
		
		
	}
}
