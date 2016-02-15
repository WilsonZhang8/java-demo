package com.zghw.base.generic;

/**
 * 链表的栈，实现了先进后出
 * 
 * @author zghw
 *
 */
public class LinkStack<T> {
	// 最顶层元素
	private Node<T> top = new Node<T>();// 初始化为null

	// 入栈 ：入栈后当前最顶元素变为下一个元素，最新的最顶层元素为添加的新元素，
	public void push(T item) {
		top = new Node<T>(item, top);
	}

	// 出栈：最顶层元素出栈，当前最顶元素变为下一个元素，最新的最顶层元素变为下一个元素
	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;// 下一个当成当前最顶元素
		}
		return result;
	}

	class Node<U> {
		U item;
		Node<U> next;// next 链表主要点 当前对象连接下一个当前对象就形成了链表

		public Node() {
			this.item = null;
			this.next = null;
		}

		public Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}

		/**
		 * 是否时最后一个元素
		 * 
		 * @return
		 */
		public boolean end() {
			return ((top == null) && (next == null));
		}
	}

	public static void main(String[] args) {
		LinkStack<String> s = new LinkStack<String>();
		s.push("a");
		s.push("b");
		s.push("c");
		s.push("d");
		s.push("e");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
