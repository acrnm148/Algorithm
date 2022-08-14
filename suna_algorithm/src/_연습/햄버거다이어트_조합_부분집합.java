package _연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조합1
 * 조합2
 * 부분집합
 * dfs
 * */
public class 햄버거다이어트_조합_부분집합 {

	static int N, limit, max;
	static int[] cal, score;
	static boolean[] isSelected; //부분집합
	static int[] tgt, src; //
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			max = 0; //max 초기화를 안해줬음;;;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			cal = new int[N];
			score = new int[N];
			src = new int[N]; //조합
			isSelected = new boolean[N]; //부분집합
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			//조합1 - 직관적 이거쓰자 (조합된 원소를 직접 배열에 담음)
			for (int i = 0; i < N; i++) {
				tgt = new int[i+1];
				comb(0, 0);
			}
			//조합2 - (조합된 원소의 인덱스로만 확인, 원소에 접근해야하면 numbers[] 만들어서 위치 잘보고 넣어줘야함)
			for (int i = 0; i < N; i++) {
				comb2(0, 0, 0, 0, i);
			}
			
			//부분집합
			subset(0);
			
			//dfs
			dfs(0, 0, 0);
			
			System.out.println("#" + t +  " " + max);
		}

	}
	
	//조합1 - 직관적, "조합 원소를 직접 담아줌"
	static void comb(int srcIdx, int tgtIdx) {
		//1. 기저조건1 - tgt 다찼을 때
		if (tgtIdx == tgt.length) {
			int total_cal = 0;
			int total_score = 0;
			for (int i = 0; i < tgt.length; i++) {
				total_cal += cal[tgt[i]];
				total_score += score[tgt[i]];
			}
			if (total_cal > limit) total_score = 0;
			else {
				max = Math.max(max, total_score);
			}
			return;
		}
		//2. 기저조건2 - src 다봤을 때
		if (srcIdx == src.length) return;
		//3. 조합에 src넣어줌
		tgt[tgtIdx] = srcIdx;
		//4. 선택이냐 선택아니냐
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
	
	//조합2 - "조합된 원소를 보려면 numbers[]를 새로 만들어야함, 인덱스 가지고만 풀 때"
	static void comb2(int cnt, int start, int total_score, int total_cal, int r) {
		if (cnt == r) { //이 조합의 기저조건은 for문에서 모든 조합이 다 끝나고 오는 조건이다. 그래서 변화되는 값을 볼 수 없다.
			if (total_cal<= limit ) {
				max = Math.max(total_score, max);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			
			comb2(cnt+1, i+1, total_score + score[i], total_cal + cal[i], r);
		}
	}
	
	//부분집합
	static void subset(int srcIdx) {
		//1. 기저조건 - N개 까지 다 봤을 때
		if (srcIdx == N) {
			int total_cal = 0;
			int total_score = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					total_cal += cal[i];
					total_score += score[i];
					if (total_cal <= limit) 
						max = Math.max(max, total_score);
				}
			}
			
			return;
		}
		
		isSelected[srcIdx] = true; //선택한걸로 돌고
		subset(srcIdx + 1);
		isSelected[srcIdx] = false; //선택안한걸로 돌고 - 모든 부분집합을 보게된다
		subset(srcIdx + 1);
	}
	
	//dfs
	static void dfs(int srcIdx, int total_cal, int total_score) {
		if (total_cal > limit) {
			return;
		}
		
		if (srcIdx == N) { // 조합의 요소 개수가 N개가 안되는데 어떻게 성립? - dfs 넘길 때 항상 srcIdx+1해줬다
			max = Math.max(max, total_score);
			return;
		}
		
		dfs(srcIdx + 1, total_cal + cal[srcIdx], total_score + score[srcIdx]);
		dfs(srcIdx + 1, total_cal, total_score);
	}

}



















