package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*중복조합으로 뽑는다
 * 
 * 순서는 상관하지 않고, 숫자 2개를 무조건 뽑는다
 * 1, 4 / 4, 1 합
 * 3, 5 / 5, 3 합
 * 두 음식의 차이가 최소가 될 때?
 * 
 * 두 음식 간 맛의 차이가 최소가 되도록 A, B를 만듦
 * 
 * */
public class SW_4012요리사 {

	static int N, min, a1,a2, b1,b2;
	static int[][] table;
	static int[] a, b, numbers;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			table = new int[N+1][N+1];
			a= new int[2];
			b= new int[2];
			numbers= new int[2];
			isSelected = new boolean[N+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					table[i][j] =Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			//숫자 2개 뽑음
			comb(0, 1);
			System.out.println(a[0] + " "+ a[1] + " " + b[0] + " " + b[1] + " ");
			idx++;
			comb(0, 1);
			
			System.out.println(a[0] + " "+ a[1] + " " + b[0] + " " + b[1] + " ");
			int gap = Math.abs((table[a1][a2] + table[a2][a1]) - (table[b1][b2] + table[b2][b1]));
			min = Math.min(min, gap);
			
			System.out.println(min);
			
		}
	}
	
	// 조합 - 숫자 2개 뽑음
	static int idx;
	static void comb(int cnt, int start) {
		if (cnt == 2) {
			a[idx] = numbers[0];
			b[idx] = numbers[1];
			isSelected[a[idx]] = true;
			isSelected[b[idx]] = true;
//			if (idx == 1) {
//				isSelected[a[0]] = false;
//				isSelected[a[1]] = false;
//				isSelected[b[0]] = false;
//				isSelected[b[1]] = false;
//			}
			
			
			return;
		}
		for (int i = start; i <= N; i++) {
			if (isSelected[i]) continue;
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	
	
}






















