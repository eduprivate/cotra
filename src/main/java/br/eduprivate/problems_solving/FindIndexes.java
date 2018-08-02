package br.eduprivate.problems_solving;

public class FindIndexes {
	public int solution(int[] A) {
		int count = 0;
        
		for(int i = 0; i < A.length; i++) {
			int value = A[i];
			int indexCount = getEqualIndexValue(value, i, A);
			count += indexCount;
		}
		return count;
    }
	
	public int getEqualIndexValue(int value, int index, int[] A) {
		int count = 0;
		for(int i = index+1; i < A.length; i++) {
			if (A[i] == value) {
				count++;
			}	
		}
		return count;
	}
	
	public static void main(String[] args) {
		FindIndexes solution = new FindIndexes();
		int[] A = {3, 5, 6, 3, 3, 5};
		System.out.println(solution.solution(A));
	}
	
	
}
