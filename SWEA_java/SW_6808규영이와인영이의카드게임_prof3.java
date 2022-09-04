package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* perm이 아니라 NP!!! next perm
 * 순열
 * np배열의 특징은 타겟 배열이 정렬되어있음
 * perm에서 해결 - 파라미터로 넘겨주는 방법
 * 
 * 
 * */
public class SW_6808규영이와인영이의카드게임_prof3{
	
	static int T, win, lose, N = 9;
	static int[] input = new int[19];
	static int[] guCard = new int[9]; //테케에서 고정
	static int[] inCard = new int[9]; //np에 의해 순열이 바뀜
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= N; tc++) { 
			//초기화
			win = 0;
			lose = 0;
			Arrays.fill(input, 0);

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//규영이 카드
			int num = 0;
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());
				guCard[i] = num;
				input[num] = 1;
			}
			//인영이카드
			num = 0;
			for (int i = 1; i <= 18; i++) {
				if (input[i] == 0) inCard[num] = i;
			}
			
			//정렬
			//정렬한 결과도 하나의 경우의 수
			//인영이카드는 이미 정렬되어있어야함. 가장작은수부터 큰수로
			//np 이용 -> 될 때까지
			while (true) {
				// complete code
				check(); //확인
				if (!np()) break; //그다음순열로 //순열이 거짓이면 멈춰라?
			}
			
			
			System.out.println("#"+tc+" " + win + " " + lose);

		}
	}
	
	//암기해야함 : 특징1)리스트 완성다 해놓고, 따져봐야할 때 유용. 가운데 가지치기가 안된다 ========================================================
	static boolean np() {
		int[] src = inCard;
		int i = src.length - 1;
		while (i > 0 && src[i-1] >= src[i]) i--;
		if (i==0) return false; // descending i가 0이되면 더 갈 수 없으니까 끝냄
		
		int j = src.length - 1;
		while (src[i-1] >= src[j]) --j;
		swap(src, i-1, j);
		
		int k = src.length - 1;
		while (i < k) {
			swap(src, i++, k--); //특징2)원본을 swap하여 변형한다. 
		}
		return true;
	}
	// ====================================================================
	
	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	static void check() {
		int guSum = 0;
		int inSum = 0;
		for (int i = 0; i < N; i++) {
			if (guCard[i] > inCard[i]) {
				guSum += guCard[i] + inCard[i]; // 두 점수 다가져감
			}
			else { //서로 다르니까 같을 수가 없다
				inSum += guCard[i] + inCard[i];
			}
		}
		if (guSum > inSum) win++;
		else if (guSum < inSum) lose++; //sum은 같을 수 있으므로 같을 경우는 빼줘야함
		
	}
}
