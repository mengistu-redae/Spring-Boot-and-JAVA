
package com.mum.solution;

/**
 * @author Mengistu Redae
 *
 */

public class MUMsolutionsMainClass {

	public static void main(String[] args) {
		
		//integer array
		int[] intArray1 = {1, 2, 3, 4, 5};
		int[] intArray2 = {3, 2, 1, 4, 5};
		int[] intArray3 = {3, 2, 1, 4, 1};
		int[] intArray4 = {1, 2, 3, 4};
		int[] intArray5 = {};
		int[] intArray6 = {10};
		
		//character array
		char[] charArray1 = {'a', 'b', 'c'};
		
		//centeredArray problem
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("centeredArray problem");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(centeredArray(intArray1));
		System.out.println(centeredArray(intArray2));
		System.out.println(centeredArray(intArray3));
		System.out.println(centeredArray(intArray4));
		System.out.println(centeredArray(intArray5));
		System.out.println(centeredArray(intArray6));
		
		//oddSum - evenSum Array problem
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("oddSum - evenSum Array problem");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(oddEvenSumArray(intArray1));
		System.out.println(oddEvenSumArray(intArray2));
		System.out.println(oddEvenSumArray(intArray3));
		System.out.println(oddEvenSumArray(intArray4));
		System.out.println(oddEvenSumArray(intArray5));
		System.out.println(oddEvenSumArray(intArray6));
		
		//return sub-array problem
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("return sub-array problem");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(returnSubArray(charArray1, 0, 3));	// Result --- {'a', 'b', 'c'}
		System.out.println(returnSubArray(charArray1, 0, 2));	// Result --- {'a', 'b'}
		System.out.println(returnSubArray(charArray1, 0, 1));	// Result --- {'a'}
		System.out.println(returnSubArray(charArray1, 1, 2));	// Result --- {'b', 'c'}
		System.out.println(returnSubArray(charArray1, 1, 1));	// Result --- {'b'}
		System.out.println(returnSubArray(charArray1, 2, 1));	// Result --- {'c'}
		System.out.println(returnSubArray(charArray1, 1, 0));	// Result --- {}
		//System.out.println(returnSubArray(charArray1, 0, 4));	// Result --- null
		//System.out.println(returnSubArray(charArray1, 1, 3));	// Result --- null
		//System.out.println(returnSubArray(charArray1, 2, 2));	// Result --- null
		//System.out.println(returnSubArray(charArray1, 3, 1));	// Result --- null
		//System.out.println(returnSubArray(charArray1, -1, 2));	// Result --- null
		//System.out.println(returnSubArray(charArray1, -1, -2));	// Result --- null
		//System.out.println(returnSubArray(new char[] {}, 0, 1));	// Result --- null
		
		//return reversing digits of an integer
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("reverse digits of an integer");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(reverseDigistsOfInteger(1234));	//Result --- 4321
		System.out.println(reverseDigistsOfInteger(12005));	//Result --- 50021
		System.out.println(reverseDigistsOfInteger(1));		//Result --- 1
		System.out.println(reverseDigistsOfInteger(1000));	//Result --- 1
		System.out.println(reverseDigistsOfInteger(0));		//Result --- 0
		System.out.println(reverseDigistsOfInteger(-12345));	//Result --- -54321
		
		//common elements to two arrays
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("common elements to two arrays");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		
		System.out.println(commonElementsInTwoArrays(new int[]{1, 8, 3, 2}, new int[] {4, 2, 6, 1})); //Result ---	{1, 2}
		System.out.println(commonElementsInTwoArrays(new int[]{1, 8, 3, 2, 6}, new int[] {2, 6, 1})); //Result ---	{2, 6, 1}
		System.out.println(commonElementsInTwoArrays(new int[]{1, 3, 7, 9}, new int[] {7, 1, 9, 3})); //Result ---	{1, 3, 7, 9}
		System.out.println(commonElementsInTwoArrays(new int[]{1, 2}, new int[] {3, 4})); //Result --- {}
		System.out.println(commonElementsInTwoArrays(new int[]{}, new int[] {1, 2, 3})); //Result --- {}
		System.out.println(commonElementsInTwoArrays(new int[]{1, 2}, new int[] {})); //Result ---	{}
		System.out.println(commonElementsInTwoArrays(new int[]{1, 2}, null)); //Result --- null
		System.out.println(commonElementsInTwoArrays(null, new int[] {})); //Result --- null
		System.out.println(commonElementsInTwoArrays(null, null)); //Result ---	null
		
		//POE (point of equilibrium) of an array
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("point of equilibrium of an array");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(pointOfEquilibrium(new int[]{1, 8, 3, 7, 10, 2})); //Result --- 3 Reason: a[0] + a[1] + a[2] is equal to a[4] + a[5]
		System.out.println(pointOfEquilibrium(new int[]{1, 5, 3, 1, 1, 1, 1, 1, 1})); //Result --- 2 Reason: a[0] + a[1] is equal to a[3] + a[4] + a[5] + a[6] + a[7] + a[8]
		System.out.println(pointOfEquilibrium(new int[]{2, 1, 1, 1, 2, 1, 7})); //Result --- 5 Reason: a[0] + a[1] + a[2] + a[3] + a[4] is equal to a[6]
		System.out.println(pointOfEquilibrium(new int[]{1, 2, 3})); //Result --- -1 Reason: No POE.
		System.out.println(pointOfEquilibrium(new int[]{3, 4, 5, 10})); //Result --- -1 Reason: No POE.
		System.out.println(pointOfEquilibrium(new int[]{1, 2, 10, 3, 4})); //Result --- -1 Reason: No POE.
		
		
	}
	
	//Q1-sample test
	private static int centeredArray(int [] array) {
				
		if(array == null || array.length%2 == 0)
			return 0;
		
		int midIndex = array.length/2;
		int midItem = array[midIndex];
		
		for(int i = 0; i < array.length; i++) {
			if(i != midIndex && midItem >= array[i])
				return 0;
		}		
		
		return 1;
	}
	
	//Q2-sample test
	private static int oddEvenSumArray(int [] array) {
		
		int even=0, odd=0;
		for(int i = 0; i< array.length; i++) {
			if(array[i]%2 == 0)
				even += array[i];
			else
				odd += array[i];
		}
		
		return odd - even;
	}

	//Q3-sample test
	private static char[] returnSubArray(char[] a, int start, int len ) {
		if(start < 0 || len < 0 || a.length < (start + len))
			return null;
		//if(len == 0)
		//return new char[] {};
		
		char[] subArray = new char[len];
		for(int i = 0; i< len; i++) {
			subArray[i] = a[i+start];
		}
		
		return subArray;
	}
	
	//Q4-sample test
	private static int reverseDigistsOfInteger(int n) {
		int reversed = 0;
		int reminder = 0;
		
		while(n != 0) {
			reminder = n%10; //reminder is negative if the given number is negative
			reversed = reversed*10 + reminder;
			n = n/10;
		}
		
		return reversed;
	}
	
	//elements common to two arrays
	//Q5-sample test
	private static int[] commonElementsInTwoArrays(int[] first, int[] second) {
		/*
		if(first == null || second == null) return null;
		if(first.length == 0 || second.length ==0 ) return new int[0]; //return new int[] {};
		
		int min = first.length < second.length ? first.length : second.length;		
		int[] a,b;
		if(min == first.length) {
			a = first;
			b = second;
		}
		else {
			a = second;
			b = first;
		}
		
		int numberOfCommonElements = 0;
		int[] commonElements = new int[min];
		for(int i=0; i<min; i++)
			for(int j=0; j<b.length; j++) {
				if(a[i] == b[j]) {
					commonElements[i]=b[j];
					numberOfCommonElements++;
				}
					
			}
		
		int[] finalCommonElements = new int[numberOfCommonElements];
		for(int i = 0; i<numberOfCommonElements; i++)
			finalCommonElements[i]=commonElements[i];
		
		return finalCommonElements;
		
		*/
		
		if (first == null || second == null)
			return null;
		if (first.length == 0 || second.length == 0)
			return new int[0];
		
		int min = (first.length < second.length) ? first.length : second.length;
		int[] a, b;
		if (min == first.length) {
			a = first;
			b = second;
		} else {
			a = second;
			b = first;
		}
		
		int[] c = new int[min];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++)
				if (a[i] == b[j]) {
					c[k] = a[i];
					k++;
				}
		}
			
		int[] retArray = new int[k];
		for (int t = 0; t < retArray.length; t++) {
			retArray[t] = c[t];
			//System.out.print(retArray[t]);
		}
		return retArray;
	}

	//POE (point of equilibrium) of an array
	//Q6-sample test
	private static int pointOfEquilibrium(int[] array) {
		
		///*
		 //NOT WORKING
		int totalSum = 0;
		for(int i=0; i<array.length; i++)
			totalSum += totalSum + array[i];
		
		int leftSum=0, rightSum=0;
		for(int i=0; i<array.length; i++) {		
			
			rightSum=totalSum - leftSum - array[i];
			if(rightSum == leftSum) 
				return i; //return the index
			
			leftSum = leftSum + array[i];
		}
		
		return -1;
		/*/
		
		/*
		if (array.length < 3) 
			return -1;
		
		int i = 0;
		int j = array.length - 1;		
		int idx = 1;		
		int leftSum = array[i];
		int rightSum = array[j];
		
		for (int k = 1; k < array.length - 2; k++)
		{
			if (leftSum < rightSum)
			{
				i++;
				leftSum += array[i];
				idx = i + 1;
			}
			else
			{
				j--;
				rightSum += array[j];
				idx = j - 1;
			}
		}
		
		if (leftSum == rightSum)
			return idx;
		else
			return -1;
		
		*/

		
		/*
		int n = arr.length;
		int mid = n / 2;
	    int leftSum = 0, rightSum = 0;

	    //calculation sum to left of mid
	    for (int i = 0; i < mid; i++){
	        leftSum += arr[i];
	    }
	    //calculating sum to right of mid
	    for (int i = n - 1; i > mid; i--)
	    {
	        rightSum += arr[i];
	    }

	    if (rightSum > leftSum)
	    {
	        while (rightSum > leftSum && mid < n - 1)
	        {
	            rightSum -= arr[mid + 1];
	            leftSum += arr[mid];
	            mid++;
	        }
	    }
	    else
	    {
	        while (leftSum > rightSum && mid > 0)
	        {
	            rightSum += arr[mid];
	            leftSum -= arr[mid - 1];
	            mid--;
	        }
	    }

	    if (rightSum == leftSum)
	    {
	        System.out.print("Equilibrium index : "+ mid);
	        return;
	    }

	    System.out.print("Equilibrium index : " + -1);
	    */
	}
	
}











