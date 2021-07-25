package com.fanjavaid.algorithms.groking_algorithms;

import java.util.Objects;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public String toString() {
		return "{ data="+ this.data +", next="+ Objects.toString(this.next, "null") +" }";
	}
}

class LinkedList {
	Node head;

	public LinkedList(Node head) {
		this.head = head;
	}

	public Node append(int data) {
		Node node = new Node(data);
		if (this.head == null) {
			this.head = node;
			return node;
		}

		Node current = this.head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = node;
		return node;
	}

	public Node prepend(int data) {
		Node node = new Node(data);
		node.next = this.head;
		this.head = node;
		return node;
	}

	public void appendAfter(int insertAfter, int data) {
		/* My first implementation when you already know the previous node
		 * to insert after
		if (prevNode == null) return;

		Node node = new Node(data);
		node.next = prevNode.next;
		prevNode.next = node;
		*/

		Node current = this.head;
		while (current != null) {
			if (current.data == insertAfter) {
				Node node = new Node(data);
				node.next = current.next;
				current.next = node;
				break;
			}
			current = current.next;
		}
	}

	public void deleteLast() {
		Node current = this.head;

		if (current == null || current.next == null) {
			this.head = null;
			return;
		}

		Node nextNode = current.next;
		while (nextNode != null) {
			if (nextNode.next == null) {
				current.next = null;
			}
			current = current.next;
			nextNode = nextNode.next;
		}
	}

	public void deleteStart() {
		if (this.head != null) {
			Node nextNode = this.head.next;
			this.head.next = null;
			this.head = nextNode;
		}
	}

	public void deleteAfter(int deleteAfter) {
		Node current = this.head;
		while (current != null) {
			if (current.data == deleteAfter && current.next != null) {
				Node nextNode = current.next;
				current.next = nextNode.next;
				nextNode.next = null;
				break;
			}
			current = current.next;
		}
	}
}

public class LinkedListImpl {
	public static void main(String[] args) {
		Node head = new Node(99);
		LinkedList list = new LinkedList(head);

		System.out.println("Init data");
		System.out.println(list.head +"\n");

		System.out.println("Add at the end of list by 5 and 8");
		list.append(5);
		list.append(8);
		list.append(-10);
		System.out.println(list.head +"\n");

		System.out.println("Add at the start of the list by 100");
		list.prepend(100);
		System.out.println(list.head +"\n");

		System.out.println("Delete last node");
		list.deleteLast();
		System.out.println(list.head +"\n");

		System.out.println("Delete start");
		list.deleteStart();
		System.out.println(list.head +"\n");

		System.out.println("Delete after 5");
		list.deleteAfter(5);
		System.out.println(list.head +"\n");	
	}
}
