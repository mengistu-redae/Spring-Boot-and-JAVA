package DataStructuresAndAlgorithm;

//static imports
import static simpleSortingAlgorithms.SelectionSort.selectionSortAscending;
import static simpleSortingAlgorithms.SelectionSort.selectionSortDescending;

import java.util.ArrayList;

import binaryTree.BinarySearchTree;
import data.Node;
import data.Student;
import linkedList.SinglyLinkedList;

public class Main {

	public static void main(String[] args) {

		// main menu for data structures and algorithm implementation
		int[] array1 = new int[] { 90, 23, 5, 109, 12, 22, 67, 34 };
		int[] array2 = { 5, -2, 23, 7, 87, -42, 509 };
		int[] array3 = { 45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 6, 8 };
	
		printDecoratedMessage("--- Selection Sort ---");
		printArrayElements(array1);
		printSeparator("Sorted - Asc and Des");
		printArrayElements(selectionSortAscending(array1));
		printArrayElements(selectionSortDescending(array1));

//		printArrayElements(array2);
//		printArrayElements(array3);

		// printDecoratedMessage("Singly Linked List");
		printDecoratedMessage("Traversing Linked List");
		Node head1 = SinglyLinkedList.createSinglyLinkedList1();
		Node head2 = SinglyLinkedList.createSinglyLinkedList2();

		printSeparator("Iterative way");
		SinglyLinkedList.traverseSinglyLinkedListIteratively(head1);

		printSeparator("Recursive way");
		SinglyLinkedList.traverseSinglyLinkedListRecursively(head2);

		printDecoratedMessage("Reversing Linked List");
		Node newHead1 = SinglyLinkedList.reverseLinkedListIteratively(head1);
		Node newHead2 = SinglyLinkedList.reverseLinkedListRecursively(head2, null);
		printSeparator("Iterative way");
		SinglyLinkedList.traverseSinglyLinkedListIteratively(newHead1);
		printSeparator("Recursive way");
		SinglyLinkedList.traverseSinglyLinkedListIteratively(newHead2);

		printDecoratedMessage("Zipping Linked List: --- Iterative way");
		Node zippedList1 = SinglyLinkedList.zipLinkedListIteratively(newHead1, newHead2);
		Node zippedList2 = SinglyLinkedList.zipLinkedListRecursively(SinglyLinkedList.createSinglyLinkedList1(),
				SinglyLinkedList.createSinglyLinkedList2());
		
		printSeparator("Iterative way");
		SinglyLinkedList.traverseSinglyLinkedListIteratively(zippedList1);

		printSeparator("Recursive way");
		SinglyLinkedList.traverseSinglyLinkedListIteratively(zippedList2);
	
		printDecoratedMessage("Linked List to array");
		Student[] studentArray1 = SinglyLinkedList.linkedListValuesToArrayIteratively(newHead1);
		Student[] studentArray2 = SinglyLinkedList.linkedListValuesToArrayRecursively(newHead2);
		
		printSeparator("Iterative way");
		for(Student s: studentArray1)
			System.out.println(s.toString());
		
		printSeparator("Recursive way");
		for(Student s: studentArray2)
			System.out.println(s.toString());
		
		//
		printDecoratedMessage("--- BinarySearch Tree - Depth-First Search(Traversal)  ---");
		Node treeHead1 = BinarySearchTree.createBinarySearchTree1();
		Node treeHead2 = BinarySearchTree.createBinarySearchTree2();
		Node treeHead3 = BinarySearchTree.createBinarySearchTree1();
		
		printSeparator("Iterative way");
		ArrayList<Student> students1 = BinarySearchTree.depthFirstTraversalIteratively(treeHead1);
		for(Student s : students1) 
			System.out.print(s.getStudentId() + ", ");
		
		System.out.println();
		printSeparator("Recursive way");
		ArrayList<Student> students2 = BinarySearchTree.depthFirstTraversalRecursively(treeHead2, new ArrayList<Student>());
		
		for(Student s : students2)
			System.out.print(s.getStudentId() + ", ");
		
		System.out.println();
		printDecoratedMessage("--- BinarySearch Tree - Breadth-First Search(Traversal)  ---");
		printSeparator("Iterative way - is the only way");
		ArrayList<Student> students3 = BinarySearchTree.breadthFirstTraversalIteratively(treeHead3);
		for(Student s : students3)
			System.out.print(s.getStudentId() + ", ");
	}

	// print contents of an array
	private static void printArrayElements(int[] array) {
		for (int a : array)
			System.out.print(a + ", ");

		System.out.println();
	}

	// print separator
	private static void printSeparator(String message) {
		System.out.println("---- " + message + " ----");
	}

	// print separator
	private static void printMessage(String message) {
		System.out.println(message);
	}

	// print separator
	private static void printDecoratedMessage(String message) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		printMessage(message);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
	}

}
