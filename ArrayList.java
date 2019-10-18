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
		// if (position == size-1) {
		// 	grow();
		// }
		// T[] temp = Arrays.copyOf(arr, arr.length+1);
		// temp[0] = item;
		// System.arraycopy(arr, 0, temp, 1, arr.length);
		// position++;


		add(0, item);
	}

	public void add(int pos, T item) {
		if (position == size-1) {
			grow();
		}
		for (int i=position; i>=pos; i--) {
			arr[i+1] = arr[i];
		}
		arr[pos] = item;
		position++;
	}

	public T get(int pos) throws Exception {
		if (size == 0) {
			throw new Exception();
		}
		return arr[pos];
	}

	public T remove(int pos) throws Exception {
		if (size == 0) {
			throw new Exception();
		}
		T temp = arr[pos];
		for (int i=pos+1; i<position; i++) {
			arr[i-1] = arr[i];
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