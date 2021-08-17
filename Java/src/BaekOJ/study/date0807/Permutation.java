package BaekOJ.study.date0807;

class PermutationEX {
	StringBuilder sb = new StringBuilder();
	int cnt;
	char[] result;
	boolean[] check;
			
	PermutationEX(int r){
		result = new char[r];
		check = new boolean[r];
	}
	
	public void permutationSWAP(char[] arr, int depth, int n) {
        if (depth == n) {
			for(char num : arr) sb.append(num).append(" ");
            sb.append("\n");
            cnt++;
			return;
        }
        
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            permutationSWAP(arr, depth + 1, n);
            swap(arr, i, depth);
        }
    }
	public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	
	
	
	public void permutation(char[] arr, int depth, int n, int r) {
	    if (depth == r) {
	    	for(char num : result) sb.append(num).append(" ");
            sb.append("\n");
            cnt++;
	        return;
	    }
	 
	    for (int i = 0; i < n; i++) {
	        if (!check[i]) {
	        	check[i] = true;
	            result[depth] = arr[i];
	            
	            permutation(arr, depth + 1, n, r); 
	            
	            result[depth] = 0;
	            check[i] = false;;
	        }
	    }
	}

}

public class Permutation {

	public static void main(String[] args) {
		char[] arr = {'A','B','C','D'};
		PermutationEX perm = new PermutationEX(4);
		
		perm.permutationSWAP(arr, 0, arr.length);
		System.out.println(perm.sb.toString()+perm.cnt);
		perm.sb.setLength(0); perm.cnt = 0;
		
		System.out.println();
		// 크기순 정렬 -> 내부적으로 result,check 객체가 따로 필요함
		// 직관적임
		perm.permutation(arr, 0, arr.length, 4);
		System.out.println(perm.sb.toString()+perm.cnt);
	}
}
