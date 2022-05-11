/**
 * @author Nathan Crozier (40048644)
 * @version 4.13.0
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

// 
/**
 * The Class LinearTetra.
 */
public class LinearTetra {
	
	
	  /**
  	 * Startup the tetranacci calculator by creating the base array with the initial 4 tetranacci numbers, and then pass the n value from here to the real method.
  	 *
  	 * @param n the index you want to count up to.
  	 * @return the tetranacci number for the index you passed.
  	 */
  	public static long calculateTetraStartup(int n) { //Create a starting cache consisting of the first 4 numbers in the tetranacci sequence.
		  long[] cache = {0, 0, 0, 1};
		  return calculateTetra(n, cache); //pass our starting cache and our n value into the actual tetranacci method.
		  
		 
	  }
		
	
	/**
	 * Calculate the tetranacci number for the index passed using a passed array of longs.
	 *
	 * @param n the index you want to count to.
	 * @param cache the array of fibonacci numbers that have been counted to already (up to 4). Stored as longs.
	 * @return the fibonacci number corresponding to the index you passed.
	 */
	private static long calculateTetra(int n, long[] cache) {
		 if (n <= 3)
			  return cache[n]; //if we request the first, second, third, or fourth tetranacci number, we're already done. Just grab it from the cache.
		 					  //Otherwise we need to start moving the cache up until we find the number that was requested.
		  long current = cache[0] + cache[1] + cache[2] + cache[3]; //To find the next number in the sequence, we add all of the numbers in the cache together.
		  for (int i = 0; i < 3; i++) //then we increment all of the numbers up by one, effectively dropping the last number in the cache.
			  cache[i] = cache[i + 1];
		  cache[3] = current; //Then we set our most current number in the cache, as the one we calculated earlier.
		  return calculateTetra(n - 1, cache); //Then we pass our new cache back in and decrement n. Once we reach n == 3, we will return the most 'current' value in our cache.
	}


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		

	
		File output = new File("linearOut.txt"); //Creating a file to be printed to

		PrintWriter fileWriter = null;

		try {
			fileWriter = new PrintWriter(new FileOutputStream(output), true);

			for (int n = 5; n <= 100; n+=5) { //Printing up to T(100)
				System.out.println("Attempting calculation of " + n + "th Tetranacci number...");
			long startTime = System.nanoTime();

			fileWriter.println("Running the linear tetra calculator on an input of: " + n
					+ "\nThe result we got was: " + LinearTetra.calculateTetraStartup(n));

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