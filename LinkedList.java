public class LinkedList<T> implements List<T>
{
	Node<T> head;
	// Node<T> tail;
	int size;

	public class Node<T>
	{
		T data;
		Node<T> previous, next;
		public Node(T d, Node<T> p, Node<T> n) {
			data = d;
			previous = p;
			next = n;
		}
	}

	public LinkedList() {
		head = null;
		// tail = null;
		size = 0;
	}

	public void add(T item) {
		if (size == 0) {
			head  = new Node<T>(item, null, null);
		}
		else {
			head.previous = new Node<T>(item, null, head);
			head = head.previous;
		}
		size++;
	}

	public void add(int pos, T item) {
		size++;
		Node temp = new Node(null,null,null);
		temp.data = item;
		temp.next = null;
		if (head == null) {
			if (pos == 0) {
				head = temp;
			}
			else {
				return;
			}
		}
		if (head != null && pos == 0) {
			temp.next = head;
			head = temp;
			return;
		}
		Node current = head;
		Node prev = null;
		for (int i=0; i<pos; i++) {
			prev = current;
			current = current.next;
			if (current == null) {
				break;
			}
		}
		temp.next = current;
		prev.next = temp;

	}

	public T get(int pos) throws Exception {
		if (size == 0) {
			throw new Exception();
		}
		Node current = head;
		int position = 0;
		while (current != null) {
			if (position == pos) {
				return (T)current.data;
			}
			position++;
			current = current.next;
		}
		return null;
	}

	public T remove(int pos) throws Exception {
		if (size == 0) {
			throw new Exception();
		}
		Node temp = new Node(null,null,null);
		Node current = head;
		int position = 0;
		while (current != null) {
			if (position == pos) {
				temp = current;
				for (int i=0; (current!=null)&&(i<pos-1); i++) {
					current = current.next;
				}
				break;
			}
			position++;
			current = current.next;
		}
		size--;
		return (T)temp.data;
	}

	public int size() {
		return size;
	}
}