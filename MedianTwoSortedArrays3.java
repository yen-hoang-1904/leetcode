package leetcode;

public class MedianTwoSortedArrays3 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        double median = MedianTwoSortedArrays3.findMedianSortedArrays(a, b);
        System.out.println(median);
    }

    public static int maximum(int a, int b) {
        return a > b ? a : b;
    }

    public static int minimum(int a, int b) {
        return a < b ? a : b;
    }

    public static double findMedianSortedArrays(int[] a, int[] b) {	
	    // to ensure the l1 < l2
	    if (a.length > b.length) return findMedianSortedArrays(b, a);

	    int l1 = a.length;
	    int l2 = b.length;
	    int l = l1 + l2;

	    if (l1 == 0) {
	    	return l2 % 2 == 0 ? (double) (b[(l2 - 1)/2] + b[(l2 - 1)/2 + 1])/2 : (double) (b[(l2 - 1)/2]);
		}

	    if (l1 == 1) {
			if (l2 == 1) {
				return (double) (a[0] + b[0]) / 2;
			} else {
				int mid = (l2 - 1) / 2;
				if (a[0] < b[mid]) {
					return l2 % 2 == 0 ? (double) b[mid] : (double) (b[mid] + maximum(a[0], b[mid - 1])) / 2;
				} else {
					return l2 % 2 == 0 ? (double) minimum(a[0], b[mid + 1]) : (double) (b[mid] + minimum(a[0], b[mid + 1])) / 2;
				}
			}
			// l2 >= l1 > 1
	    }
	    
	    int i = (l1 - 1)/2;
	    int j = (l1 + l2 - 1)/2 - i - 1;
	    
	    while (i > 0 && i < l1 - 1){
		    if (b[j] > a[i + 1]) {
			    i++;
			    j--;
			    continue;
		    }
		    if (a[i] > b[j + 1]) {
		    	i--;
		    	j++;
			    continue;
		    }
		    return (l1+l2) % 2 == 0? (double) (maximum(a[i], b[j]) + minimum(a[i + 1], b[j + 1]))/2 : (double) maximum(a[i], b[j]);
	    }

	    if (i == 0){ //i = 0
			if (b[j] > a[i + 1]) {
				if (j - 1 > - 1)  return l % 2 == 0? (double) (maximum(a[i + 1], b [j - 1] )+ b[j])/2 : (double) maximum(a[i + 1], b[j - 1]);
				else return l % 2 == 0? (double) (a[i + 1] + b[j])/2 : (double) maximum(a[i + 1], b[j - 1]);
			} else { // b[j] <= a[i + 1]
				if (a[i] <= b[j + 1]) {
					return l % 2 == 0? (double) (maximum(a[i], b[j]) + minimum(a[i + 1], b[j + 1]))/2 : (double) maximum(a[i], b[j]);
				} else { // a[i] > b[j + 1]
					if (j + 2 < l2)  return l % 2 == 0? (double) (b[j + 1] + minimum(b[j + 2], a[i]))/2 : (double) b[j + 1];
					else return l % 2 == 0? (double) (a[i] + b[j + 1]) /2 : (double) b[j + 1];
				}
			}
	    }

	    if (i == l1 - 1) {
			if (j > -1) return l % 2 == 0? (double) (maximum(a[i], b[j]) + b[j + 1])/2 : (double) maximum(a[i], b[j]);
			else return l % 2 == 0? (double) (a[i] + b[j + 1])/2 : (double) maximum(a[i], b[j]);
//			return l % 2 == 0? (double) (a[i] + b[j])/2 : (double) maximum(a[i], b[j]);
	    }
	    return -1;
    }
}
