public class AdditionalArraysTasks{
	public static void main(String[] args){

		//1
		int[][] matrixFor1 = {{1,1,1}, {2,2,2}, {3,3,3}};
		assertEquals("#1", 10, getSumOfDiagonals(matrixFor1));

		//2
		long[][] longArrayFor2 = {{1,2}, {7}, {6,4,2}};
		boolean[][] boolArrayFor2 = {{true, false}, {true}, {true, false, true}};
		long[] expectedArray = {1,7,6,2};
		assertArrayEquals("#2", expectedArray, filter(longArrayFor2, boolArrayFor2));

		//3
		char[][] arrayFor3 = {{'q','w'}, {'e', 'r'}, {'t','y'}};
		printArray(arrayFor3);

	}


	//********************************IMPLEMENTATION*********************************************

		//1
		static int getSumOfDiagonals(int[][] array){

			int sum = 0;

			for(int i = 0; i < array.length; i++){
				sum = sum + array[i][i] + array[i][array.length - 1 - i];				
			}

			int middleElement = array[array.length/2][array.length/2];
			return sum - middleElement;			

		}

		//2
		static long[] filter(long[][] array, boolean[][] flags){

			int numberOfTrueFlags = 0;

			for(int i = 0; i < flags.length; i++){
				for(int j = 0; j < flags[i].length; j++){
					if(flags[i][j]){
						numberOfTrueFlags++;
					}

				}
			}

			long[] resultArray = new long[numberOfTrueFlags];
			int index = 0;

			for(int i = 0; i < array.length; i++){
				for(int j = 0; j < array[i].length; j++){
					if(flags[i][j]){
						resultArray[index++] = array[i][j];

					}
				}
			}
			return resultArray;	
		}

		//3
		static void printArray(char[][] array){
			for(int i = 0; i < array.length; i++){
				for(int j = 0; j < array[i].length; j++){
					System.out.print("" + i + j + ": " + array[i][j] + "| ");
					if(j == array[i].length -1){
						System.out.println();
					}
				}
			}
		}


		//********************************TESTS*******************************************************

		public static void assertEquals(String testId, int expected, int actual){
			if(expected == actual){
				System.out.println("Test #" + testId + " PASSED!");
			}
			else{
			System.out.println("Test #" + testId + " FAILED! Expected: " + expected + " Actual: " + actual);
			}
		}

		public static void assertArrayEquals(String testId, long[] expected, long[] actual){

			boolean isEquals = true;

			if(expected.length != actual.length){
				isEquals = false;
				System.out.println("Test #" + testId + " FAILED! Expected length: " + expected.length 
									+ " Actual length: " + actual.length);
			}
			else{
				for(int i = 0; i < expected.length; i++){
					if(expected[i] != actual[i]){
					isEquals = false;
					System.out.println("Test #" + testId + " FAILED! Expected for index # " + i + ": " + expected[i] + ", Actual: " + actual[i]);
					break;
					}
				}
			}		
			if(isEquals){
				System.out.println("Test #" + testId + " PASSED!");
			}
		}
}