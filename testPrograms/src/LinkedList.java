// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		Test12.java
 * Author:	sjambudi
 */



	import java.io.BufferedWriter;
	import java.io.FileWriter;
	import java.io.IOException;
import java.util.Scanner;

	/***
	 * 
	 * @author Administrator
	 * 
	 */
	public class LinkedList {
		public static class LinkedListNode {
			int val;
			LinkedListNode next;

			LinkedListNode(int node_value) {
				val = node_value;
				next = null;
			}
		};

		public static LinkedListNode _insert_node_into_singlylinkedlist(
				LinkedListNode head, int val) {
			if (head == null) {
				head = new LinkedListNode(val);
			} else {
				LinkedListNode end = head;
				while (end.next != null) {
					end = end.next;
				}
				LinkedListNode node = new LinkedListNode(val);
				end.next = node;
			}
			return head;
		}

		/*
		 * Complete the function below.
		 */
		/*
		 * For your reference: 
		 * LinkedListNode 
		 * { 
		 * 		int val; 
		 * 		LinkedListNode *next; };
		 */
		static LinkedListNode manipulateList(LinkedListNode root) {
			if (root == null || root.next == null)
				return root;
			LinkedListNode mid = root, tail = root.next;
			while (true) {
				mid = mid.next;
				tail = tail.next;
				if (tail == null) {
					break;
				}
				tail = tail.next;
				if (tail == null) {
					break;
				}
			}

			LinkedListNode n1 = root, n2 = mid;
			while (n1.next != mid) {
				LinkedListNode h1Next = n1.next;
				LinkedListNode h2Next = n2.next;
				n1.next = n2;
				n2.next = h1Next;
				n1 = h1Next;
				n2 = h2Next;
			}
			n1.next = n2;
			return root;

		}
		
		static LinkedListNode deleteNode(LinkedListNode head, int value){
			if(head == null){
				return null;
			}
			LinkedListNode end = head;
			
			LinkedListNode nodeBeforeDelNode = null; 
			LinkedListNode delNode = null;
			
			while(end.next != null){
				
				if(end.next.val == value){
					nodeBeforeDelNode = end;
					delNode = end.next;
				}				
				end = end.next;
			}
			
			if(nodeBeforeDelNode == null || delNode == null){
				throw new IllegalStateException("not found");
			}
			nodeBeforeDelNode.next = delNode.next;
			delNode.next = null;
			
			return head;
		}
		
		public static void main(String[] args) throws IOException {
		
			int[] root_array = new int[]{10,20,30,40,50};
			LinkedListNode res;

			int _root_size = root_array.length, _root_i;
			int _root_item;
			LinkedListNode _root = null;
			
			for (_root_i = 0; _root_i < _root_size; _root_i++) {
				_root_item = root_array[_root_i];
				_root = _insert_node_into_singlylinkedlist(_root, _root_item);
			}

			//res = manipulateList(_root);
			res = deleteNode(_root, 40);
			
			while (res != null) {
				System.out.println(res.val);
				res = res.next;
			}
		}
	}


