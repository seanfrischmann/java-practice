package queues;

import stack.Stack;

public class Reverser {
	
	public static void main(String[] args) {
//		version1();
		version2();
	}
	
	public static void version1() {
		QueueByCompositionWithLRStruct<Integer> q = new QueueByCompositionWithLRStruct<Integer>();
		q.enqueue(1).enqueue(2).enqueue(3);
		System.out.println("BEFORE: "+q);
		reverse(q);
		System.out.println("AFTER: "+q);
	}
	
	public static void version2() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(3); s.push(2); s.push(1);
		System.out.println("BEFORE: "+s);
		reverse(s);
		System.out.println("AFTER: "+s);
	}
	
	public static <E> void reverse(QueueByCompositionWithLRStruct<E> q) {
		Stack<E> s = new Stack<E>();
		while (! q.isEmpty()) {
			System.out.println("q: "+q+"\ts: "+s);
			s.push(q.dequeue());
		}
		System.out.println("QUEUE: "+q+"\tSTACK: "+s);
		while (! s.isEmpty()) {
			System.out.println("q: "+q+"\ts: "+s);
			q.enqueue(s.pop());
		}
		System.out.println("QUEUE: "+q+"\tSTACK: "+s);
	}

	public static <E> void reverse(Stack<E> s) {
		QueueByCompositionWithLRStruct<E> q = new QueueByCompositionWithLRStruct<E>();
		while (! s.isEmpty()) {
			System.out.println("s: "+s+"\tq: "+q);
			q.enqueue(s.pop());
		}
		System.out.println("STACK: "+s+"\tQUEUE: "+q);
		while (! q.isEmpty()) {
			System.out.println("s: "+s+"\tq: "+q);
			s.push(q.dequeue());
		}
		System.out.println("STACK: "+s+"\tQUEUE: "+q);
	}

}
