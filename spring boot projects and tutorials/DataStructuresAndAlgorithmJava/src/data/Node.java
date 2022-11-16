package data;

public class Node {
	private Student student;

	//For linked-list data structure =========
	private Node next; // pointer to next node
	private Node previous; // pointer to previous node

	//For Binary Tree data structure =========
	private Node left; // pointer to next node
	private Node right; // pointer to previous node

	public Node(Student student) {
		this.student = student;
		this.next = null;
		this.previous = null;
	}

	public Node(Student student, Node next, Node previous) {
		this.student = student;
		this.next = next;
		this.previous = previous;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
