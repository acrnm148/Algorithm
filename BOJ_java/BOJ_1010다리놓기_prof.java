package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010다리놓기_prof {

	/*
	 * 공 7개 중에 4개를 뽑는다. (조합)
	 * => 공 1개를 선택한 경우의 수 + 공 1개를 선택하지 않은 경우의 수
	 * = 공 1개를 선택한 경우의 수 => 6개 중에 3개
	 * = 공 1개를 선택하지 않은 경우의 수 => 6개 중에 4개
	 * 7C4 	= 6C3 + 6C4
	 * 		= 5C2 + 5C3 + 5C3 + 5C4
	 * */
	
	/*
	 * 그냥 조합으로 풀면 그 과정에서 참여를 할 수 있다. (중복이 많이 발생)
	 * 하지만 여기서는 과정에 참여할 필요 없이 단순하게 조합의 경우의 수만 따지므로
	 * => 미리 한번 계산한 값을 저장할 자료구조를 만들고
	 * 	  반복되는 경우에 기록해두고 재사용한다. = memoization
	 * DP : memoization 을 이용해서 작은 수 -> 큰 수로 확대해 나가는 방법
	 * */
	
	static int T, N, M;
	static int[][] memoi; //재귀호출 줄여줌
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			memoi = new int[M+1][N+1];
			
			System.out.println(comb(M, N));
		}
		
	}
	
	static int comb(int src, int tgt) {
		if (memoi[src][tgt] != 0) 
			return memoi[src][tgt]; // 이미 계산된 값이 있다면 그걸 리턴
		
		//현재 src, tgt에 대한 계산된 값이 없다면 (최초 계산)
		//변환 값 전체를 다 선택하던가 하나도 선택하지 않던가
		if (src == tgt || tgt == 0)
			return memoi[src][tgt] = 1;
		
		//7C4 == 6C3 + 6C4
		return memoi[src][tgt] = comb(src-1, tgt-1) + comb(src-1, tgt);
	}
}
