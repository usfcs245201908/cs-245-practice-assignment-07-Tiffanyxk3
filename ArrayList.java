import java.util.*;

public class ArrayList<T> implements List<T>
{
	T[] arr, growArr;
	int size, position;

	public ArrayList() {
		arr = (T[]) new Object[10];
		size = 10;
		position = -1;
	}

	public void add(T item) {		
		add(0, item);
	}

	public void add(int pos, T item) {
		if (position == size-1) {// if out of capacity
			grow();
		}
		for (int i=position; i>=pos; i--) {
			arr[i+1] = arr[i];// all element after pos shift to right
		}
		arr[pos] = item;
		position++;
	}

	public T get(int pos) {
		if (size == 0) {
		return null;
		}
		return arr[pos];
	}

	public T remove(int pos) {
		if (size == 0) {
			return null;
		}
		T temp = arr[pos];
		for (int i=pos+1; i<position; i++) {
			arr[i-1] = arr[i];// all element after pos shift to left
		}
		arr[position] = null;
		position--;
		return temp;
	}

	public int size() {
		return position+1;
	}

	public void grow() {
		growArr = (T[]) new Object[arr.length*2];
		for (int i=0; i<size; i++) {
			growArr[i] = arr[i];
		}
		arr = growArr;
		size = size*2;
	}
}