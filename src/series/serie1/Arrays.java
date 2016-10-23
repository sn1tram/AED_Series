package series.serie1;

/**
 * Created by Snitram on 10/10/2016.
 */
public class Arrays {

    //EX1
    public static int greatestAfterRotate(int[] v, int l, int r){
        if(l > r) return -1;
        while (l<r){
            if(v[l]>v[r]) --r;
            if(v[l]<v[r]) ++l;
        }
        return v[r];
    }

    //EX2
    public static boolean isPermutation(int[] a1, int l1, int r1, int[] a2, int l2, int r2){
        if(l1-r1 != l2-r2) return false;
        int count = 0;
        for(int i = l1; i<=r1; i++) {
            int idx = l2;
            while (idx <= r2) {
                if(a1[i] == a2[idx]){
                    ++count;
                    a2[idx] = -1;
                    idx = r2;
                }
                ++idx;
            }
        }
        return (count == (r1-l1)+1) ? true : false;
    }

	//EX3
	public static void changeValueInMaxHeap(int[] v, int count, int ix, int newValue){
		if(ix >= v.length) throw new IllegalArgumentException();
		v[ix] = newValue;
		buildMaxHeap(v, count);
	}

	public static void buildMaxHeap(int[] h, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			maxHeapify(h, i, n);
	}

	public static int left(int i) { return 2 * i + 1; }

	public static int right(int i) { return 2 * i + 2; }

	public static void maxHeapify(int[] h, int i, int n) {
		int l = left(i);
		int r = right(i);
		int largest;
		if (l < n && h[l] > h[i])
			largest = l;
		else largest = i;
		if (r < n && h[r] > h[largest])
			largest = r;
		if (largest != i) {
			exchange(h, i, largest);
			maxHeapify(h, largest, n);
		}
	}

	private static void exchange(int[] h, int i, int j) {
		int aux = h[i];
		h[i] = h[j];
		h[j] = aux;
	}

	//EX4
	public static void sortIPv4Addresses(String[] v, int l, int r){
        int idx = 0;
		while(l < r){
			String aux = v[l];

        }
	}
}
