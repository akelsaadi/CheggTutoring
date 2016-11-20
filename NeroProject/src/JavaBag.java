import java.util.ArrayList;
import java.util.HashMap;

public class JavaBag<T> implements BagInterface<T> {
	
	private HashMap<T,int[]> map = new HashMap<T,int[]>();
	private int size = 0;
	
	@Override
	public int getCurrentSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean add(T newEntry) {
		int[] count = {0};
		if (map.containsKey(newEntry)) {
			count = map.get(newEntry);	
		}
		count[0]++;
		map.put(newEntry, count);
		size++;
		return true;
	}

	@Override
	public T remove() {
		T item = null;
		if (!map.isEmpty()) {
			item = map.keySet().iterator().next();
			size -= map.get(item)[0];
			map.remove(item);
		}
		return item;
	}

	@Override
	public boolean remove(T anEntry) {
		if (map.containsKey(anEntry)) {
			size -= map.get(anEntry)[0];
			map.remove(anEntry);
		}
		return false;
	}

	@Override
	public void clear() {
		map = new HashMap<T,int[]>();
		size = 0;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		if (map.containsKey(anEntry))
			count = map.get(anEntry)[0];
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		return map.containsKey(anEntry);
	}

	@Override
	public T[] toArray() {
		T[] all = (T[]) new Object[size];
		int index = 0;
		for (T key : map.keySet()) {
			for (int i = 0; i < map.get(key)[0]; i++) {
				all[index] = key;
				index++;
			}
		}
		return all;
	}
	
	public String toString() {
		String s = "";
		for (T item : this.toArray())
			s += item.toString() + " ";
		return s;
	}

	public static void main(String[] args) {
		JavaBag bag = new JavaBag();
		String[] testVals = {"A", "B", "C", "D", "A", "B"};
		for (String s : testVals) {
			bag.add(s);
		}
		System.out.println("Initial bag:  " + bag);
		System.out.println("size:         " + bag.size);
		
		bag.remove("A");
		System.out.println("After rm 'A': " + bag);
		System.out.println("size:         " + bag.size);
		
		bag.remove();
		System.out.println("After remove: " + bag);
		System.out.println("size:         " + bag.size);
	}

}
