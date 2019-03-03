
public class Search {
	static int search(int A[], int l, int r, int val) {
		// 查找元素val的下标，不存在返回-1
		int m;
		while (l < r) {
			m = l + (r - l) / 2;

			if (A[m] == val)
				return m;
			else if (A[m] > val)
				r = m;
			else 
				l = m + 1;	
		}
		return -1;
	}

	static int lowerBound(int A[], int l, int r, int val) {
		// 查找第一个大于等于val的下标
		int m;
		while (l < r) {
			m = l + (r - l) / 2;
			if (A[m] >= val)
				r = m;
			else
				l = m + 1;
		}
		return l;
	}

	static int upperBound(int A[], int l, int r, int val) {
		// 查找第一个大于val的下标
		int m;
		while (l < r) {
			m = l + (r - l) / 2;
			if (A[m] > val)
				r = m;
			else
				l = m + 1;
		}
		return l;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 5, 5 };
		System.out.println("等于：" + upperBound(A, 0, 5, 4));
	}
}
