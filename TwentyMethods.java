import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

class TwentyMethods{
	
	public static void main(String[] args) {

		//1
		char[] charArray = {'A', 'B', 'C'};
		printCharArray(charArray);

		//2
		int [] intArray = {65, 97, 49};
		char[] expectedFor2 = {'A', 'a', '1'};
		assertArrayEquals("2", expectedFor2, intArrayToCharArray(intArray));
		
		//3
		int expectedFor3 = 7000;
		int maxValue = max(5500, expectedFor3);
		assertEquals("3", expectedFor3, maxValue);		

		//4
		int expectedFor4 = 7000;
		int maxValueOutOf3Ints = max (5600, 6000, expectedFor4);
		assertEquals("4", expectedFor4, maxValueOutOf3Ints);		

		//5
		int expectedFor5 = 10000;
		int maxValueOutOf5Ints = max (5600, 6000, 7000, 8000, expectedFor5);
		assertEquals("5", expectedFor5, maxValueOutOf5Ints);		

		//6
		char[] charArrayFor6 = {'M', 'A', 'X'};
		String expectedStringFromChars = "MAX";
		String actualStringFromChars = charArrayToString(charArrayFor6);
		assertEquals("6", expectedStringFromChars, actualStringFromChars);		

		//8
		int expectedFirstIndex = 3;
		int[] intArrayFor8 = {5601, 6001, 7001, 8001, 10001, 8001};
		int actualFirstIndex = firstIndexOf(intArrayFor8, 8001);
		assertEquals("8", expectedFirstIndex, actualFirstIndex);
		

		//9
		int expectedLastIndex = 4;
		int[] intArrayFor9 = {5699, 10099, 7099, 8099, 10099};
		int actualLastIndex = lastIndexOf(intArrayFor9, 10099);
		assertEquals("9", expectedLastIndex, actualLastIndex);		

		//10
		long expectedFactorial = 3628800;
		long actualFactorial1 = factorial(10);
		long actualFactorial2 = factorialWithRecursion(10);
		assertEquals("10_1", expectedFactorial, actualFactorial1);
		assertEquals("10_2", expectedFactorial, actualFactorial2);		

		//11		
		assertTrue("11_1", isYearLeap(2000));
		assertTrue("11_2", isYearLeap(2020));
		assertFalse("11_3", isYearLeap(1900));
		assertFalse("11_4", isYearLeap(2021));
		
		//12
		int[] intArrayFor12 = {12, 1, 333, 777, 100};
		printDivisibleBy(intArrayFor12, 4);

		//13
		int[] arrayFor13 = {100, 22, 10, 123, -3};
		int[] expectedFor13 = {-3, 10, 22, 100, 123};
		sort(arrayFor13);
		assertArrayEquals("13", expectedFor13, arrayFor13);

		//14
		byte[] byteArray = {10, 7, 8, 9, 2, 10, 22, 7};		
		assertTrue("14", containsDuplicates(byteArray));
		assertTrue("14_2", containsDuplicatesWithNoSet(byteArray));

		//15
		int[] arrayFor15 = {1000, 22, 10, 5, -3};
		int[] arrayFor15_2 = {7, 2, 10, 200, -3};
		int[] resultArray15 = multiplyArrayValues(arrayFor15, arrayFor15_2);
		int[] expectedArrayFof15 = {7000, 44, 100, 1000, 9};
		assertArrayEquals("15", expectedArrayFof15, resultArray15);
		
		//16
		int[] arrayFor16 = {1001, 33, 11, 6, -4, 33};
		int[] arrayFor16_2 = {1001, 1, 14, 202, -5};
		int[] expectedArrayFof16 = {-5, -4, 1, 6, 11, 14, 33, 202};	
		int[] resultArray16 = findUniqueValues(arrayFor16, arrayFor16_2);
		sort(resultArray16);				
		assertArrayEquals("16", expectedArrayFof16, resultArray16);
		

		//17
		int[] arrayFor17 = {101, 343, 111, 46, -84, 315};
		int[] expectedArrayFor17 = {315, -84, 46, 111, 343, 101};
		reverceArray(arrayFor17);
		assertArrayEquals("17", expectedArrayFor17, arrayFor17);
		


		//18
		int[] arrayFor18 = generateArray(5, -100, 100);
		assertArrayInRange("18", 5, -100, 100, arrayFor18);			

		//19
		char[] charArrayFor19 = {'f', 'f', 'a', 'A', 'f', 'a', 'r', 'm', 'o'}; 
		char[] charArrayFor19_2 = {'f', 'a', 'r', 'm'};
		assertTrue("19", isCharSequencePresent(charArrayFor19, charArrayFor19_2));

		

	}

	//*******************************************************************IMPLEMENTATION***************************************************************

	//1
	public static void printCharArray(char[] charArray){

		for(char character : charArray){
			System.out.print(character + " ");
		}
		System.out.println();
	}

	//2
	public static char[] intArrayToCharArray(int[] intArray){

		char[] charArray = new char[intArray.length];
		for(int i = 0; i < intArray.length; i++){
			charArray[i] = (char) intArray[i];
		}
		return charArray;
	}

	//3
	public static int max(int firstInt, int secondInt){

		return firstInt > secondInt ? firstInt : secondInt;
	}

	//4
	public static int max(int firstInt, int secondInt, int thirdInt){

		return max(thirdInt, (max(firstInt, secondInt)));

	}

	//5
	public static int max(int firstInt, int secondInt, int thirdInt, int fourthInt, int fifthInt){

		return max(fifthInt, max(fourthInt, max(thirdInt, (max(firstInt, secondInt)))));

	}

	//6
	public static String charArrayToString(char[] charArray){

		String stringFromChars = "";

		for(char character : charArray){
			stringFromChars += character;
		}

		return stringFromChars;
	}

	//8
	public static int firstIndexOf(int[] intArray, int valueToCheck){

		int firstIndex = -1;
		for(int i = 0; i < intArray.length; i++){
			if(intArray[i] == valueToCheck){
				firstIndex = i;
				break;
			}
		}

		return firstIndex;
	}

	//9
	public static int lastIndexOf(int[] intArray, int valueToCheck){

		int lastIndex = -1;
		for(int i = intArray.length -1; i >= 0; i--){
			if(intArray[i] == valueToCheck){
				lastIndex = i;
				break;
			}
		}

		return lastIndex;
	}

	//10
	public static int factorial(int value){

		int factorial = 1; 

		if(value == 0 || value == 1){
			return 1;
		}
		else if(value < 0){
			return -1;
		}
		else{
			for(int i = 1; i <= value; i++){
				factorial *= i;

			}
		}

		return factorial;		
	}

	//10_2
	public static int factorialWithRecursion(int value){

		if(value == 0){
			return 1;
		}
		else if(value < 0){
			return -1;
		}
		else{
			return value * factorialWithRecursion(value - 1);
		}

	}

	//11
	public static boolean isYearLeap(int yearToCheck){
		return (yearToCheck % 4 == 0 && yearToCheck % 100 != 0) 
				|| (yearToCheck % 4 == 0 && yearToCheck % 100 == 0 && yearToCheck % 400 == 0) ? true : false;
	}

	//12
	public static void printDivisibleBy(int[] intArray, int divisor){
		for(int divident : intArray){
			if (divident % divisor == 0){
				System.out.println(divident);
			}
		}

	}

	//13
	public static void sort(int[] intArray){
		if(intArray.length <= 1){
			return;
		}
		
		int[] leftArray = Arrays.copyOfRange(intArray, 0, intArray.length/2);
		int[] rightArray = Arrays.copyOfRange(intArray, intArray.length/2, intArray.length);

		sort(leftArray);
		sort(rightArray);
		merge(intArray, leftArray, rightArray);
	}

	public static void merge(int[] intArray, int[] leftArray, int[] rightArray){
		int i = 0;
		int j = 0;
		int k = 0;

		while(i < leftArray.length && j < rightArray.length){
			if(leftArray[i] < rightArray[j]){
				intArray[k++] = leftArray[i++];
			}
			else{
				intArray[k++] = rightArray[j++];

			}
		}

		while(i < leftArray.length){
			intArray[k++] = leftArray[i++];
		}

		while(j < rightArray.length){
			intArray[k++] = rightArray[j++];
		}
	}

	//14
	public static boolean containsDuplicates(byte[] byteArray){

		Set<Byte> set = new HashSet<>();
		for(byte b : byteArray){
			if(!set.add(b)){
				return true;
			}
		}
		return false;
	}

	public static boolean containsDuplicatesWithNoSet(byte[] byteArray){
		
		boolean[] hasDuplicates = new boolean[256];
		for(int value : byteArray){
			int index = value + 128;
			if(hasDuplicates[index]){
				return true;				
			} else{
				hasDuplicates[index] = true;
			}
		}
		return false;
	}

	//15
	public static int[] multiplyArrayValues(int[] firstArray, int[] secondArray){
		
		int i = 0;
		int j = 0;
		int[] resultArray = new int[firstArray.length];

		while(i < firstArray.length && j < secondArray.length){
			resultArray[i] = firstArray[i] * secondArray[j];
			i++;
			j++;
		}
		return resultArray;

	}

	//16
	public static int[] findUniqueValues(int[] firstArray, int[] secondArray){

		Set<Integer> set = new HashSet<>();		

		for(int value : firstArray){
			set.add(value);
		}

		for(int value : secondArray){
			if(!set.contains(value)){
				set.add(value);
			}
			else{
				set.remove(value);	
			}			
		}

		int[] resultArray = new int[set.size()];

		int k = 0;
		for(int value : set){
			resultArray[k++] = value;
		}

		return resultArray;
	}

	//17
	public static void reverceArray(int[] intArray){

		int tmp = 0;
		for(int i = 0; i < intArray.length/2; i++){
			tmp = intArray[i];
			intArray[i] = intArray[intArray.length - 1 - i];
			intArray[intArray.length - 1 - i] = tmp;			
		}
	}  

	//18
	public static int[] generateArray(int arrLength, int bound1, int bound2){

		int[] intArray = new int[arrLength];

		Random randomGenerator = new Random();
		
		for(int i = 0; i < intArray.length; i++){
			intArray[i] = bound1 + randomGenerator.nextInt(bound2 - bound1 + 1);
		}

		return intArray;

	}

	//19
	public static boolean isCharSequencePresent(char[] charArray1, char[] charArray2){
		
		int sameSequenceLength = 0; 

		for(int i = 0; i < charArray1.length; i++){
			if(charArray1[i] == charArray2[0]){				
				for(int j = 0; j < charArray2.length; j++){

					sameSequenceLength++;					
					if(i + j > charArray1.length - 1 || charArray1[i + j] != charArray2[j]){
						sameSequenceLength = 0;
					}					
				}
				if(sameSequenceLength == charArray2.length){
					System.out.println("sameSequenceLength: " + sameSequenceLength);
					return true;
				}
			}			
		}
		return false;
	}



	//****************************************************************TESTS****************************************************************

	public static void assertEquals(String testId, int expected, int actual){
		if(expected == actual){
			System.out.println("Test #" + testId + " PASSED!");
		}
		else{
			System.out.println("Test #" + testId + " FAILED! Expected: " + expected + " Actual: " + actual);
		}
	}

	public static void assertEquals(String testId, long expected, long actual){
		if(expected == actual){
			System.out.println("Test #" + testId + " PASSED!");
		}
		else{
			System.out.println("Test #" + testId + " FAILED! Expected: " + expected + " Actual: " + actual);
		}
	}

	public static void assertEquals(String testId, String expected, String actual){
		if(expected!= null && expected.equals(actual)){
			System.out.println("Test #" + testId + " PASSED!");
		}
		else{
			System.out.println("Test #" + testId + " FAILED! Expected: " + expected + " Actual: " + actual);
		}
	}

	public static void assertArrayEquals(String testId, char[] expected, char[] actual){

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

	public static void assertArrayEquals(String testId, int[] expected, int[] actual){

		boolean isEquals = true;

		if(expected.length != actual.length){
			isEquals = false;
			System.out.println("Test #" + testId + " FAILED! Expected length: " + expected.length 
								+ ", Actual length: " + actual.length);
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

	public static void assertArrayInRange (String testId, int expectedLength, int bound1, int bound2, int[] actual){

		boolean isEquals = true;

		if(expectedLength != actual.length){
			isEquals = false;
			System.out.println("Test #" + testId + " FAILED! Expected length: " + expectedLength 
								+ ", Actual length: " + actual.length);
		}
		else{
			for(int i = 0; i < expectedLength; i++){
				if(actual[i] < bound1 || actual[i] > bound2){
				isEquals = false;
				System.out.println("Test #" + testId 
									+ " FAILED! Expected value is lover than: " + bound1 + " and higher than: " + bound2 
									+ ", Actual: " + actual[i]);
				break;
				}
			}
		}		
		if(isEquals){
			System.out.println("Test #" + testId + " PASSED!");
		}
	}

	public static void assertTrue(String testId, boolean actual){
		if(true == actual){
			System.out.println("Test #" + testId + " PASSED!");
		}
		else{
			System.out.println("Test #" + testId + " FAILED! Expected: " + "true" + ", Actual: " + actual);
		}
	}

	public static void assertFalse(String testId, boolean actual){
		if(false == actual){
			System.out.println("Test #" + testId + " PASSED!");
		}
		else{
			System.out.println("Test #" + testId + " FAILED! Expected: " + "false" + ", Actual: " + actual);
		}
	}

}