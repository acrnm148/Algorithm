package _연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 조합
 * 2. 부분집합
 * 3. dfs
 * 4. 비트마스킹 - 조합
 * */
public class 도영이가만든맛있는음식 {

	static int N, min;
	static int[] sin, ssn, tgt;
	static boolean[] isSelected; //부분집합

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sin = new int[N];
		ssn = new int[N];
		isSelected = new boolean[N]; //부분집합
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			ssn[i] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		
		//조합
//		for (int i = 1; i <= N; i++) {
//			tgt = new int[i];
//			comb(0, 0);
//		}
		//부분집합
//		subset(0);
		//dfs
//		dfs(0, 1, 0);
		//비트마스킹 - 조합
		bit();
		
		System.out.println(min);
	}
	
	//조합
	static void comb(int srcIdx, int tgtIdx) {
		//1. 기저조건 - tgt이 다 찼을 때
		if (tgtIdx == tgt.length) {
			//신맛, 쓴맛 차이 최소 찾기
			int total_sin = 1;
			int total_ssn = 0;
			for (int i = 0; i < tgtIdx; i++) {
				total_sin *= sin[tgt[i]];
				total_ssn += ssn[tgt[i]];
			}
			if (total_sin + total_ssn <= 1_000_000_000) {
				int gap = Math.abs(total_sin - total_ssn);
				min = Math.min(min, gap);
			}
			return;
		}
		//2. 기저조건 - src를 다 봤을 때
		if (srcIdx == N) {
			return;
		}
		//3. 조합tgt에 src 넣어줌
		tgt[tgtIdx] = srcIdx;
		//4. 선택이냐 선택안하냐
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
	
	//부분집합
	static void subset(int srcIdx) { //공집합일 때 한번 더 돈다. 그래서 부분집합 일때는 cnt를 세줘라
		//1. 기저조건 - src를 다 봤을 때
		if (srcIdx == N) {
			int cnt = 0;
			int total_sin = 1;
			int total_ssn = 0;
			for (int i = 0; i < srcIdx; i++) {
				if (!isSelected[i]) continue;
				total_sin *= sin[i];
				total_ssn += ssn[i];
				cnt++;
			}
			if (cnt > 0) min = Math.min(min, Math.abs(total_sin - total_ssn));
			return;
		}
		
		isSelected[srcIdx] = true;
		subset(srcIdx + 1);
		isSelected[srcIdx] = false;
		subset(srcIdx + 1);
		
	}
	
	//dfs
	static void dfs(int srcIdx, int now_sin, int now_ssn) {
		//1. 기저조건 - 인덱스끝까지 N번 순회 끝
		if (srcIdx == N) return;
		
		//dfs는 기저조건에 넣어주지 않아도 된다 => 가지치기!!
		int total_sin = now_sin * sin[srcIdx];
		int total_ssn = now_ssn + ssn[srcIdx];
		min = Math.min(min, Math.abs(total_sin - total_ssn));		
		
		//2. 선택이냐 선택아니냐
		dfs(srcIdx + 1, now_sin, now_ssn);
		dfs(srcIdx + 1, now_sin * sin[srcIdx], now_ssn + ssn[srcIdx]);
		
	}
	
	//비트마스킹-부분집합 : 비트마스킹은 부분집합을 tgt[]과 같은 배열이 아닌 int로 표현해서 재귀를 돌지 않고 for문 만으로 부분집합 문제를 푸는 방법
	static void bit() {
		//1. 부분집합 범위 설정
		int count = 1<<N;
		//2. 모든 부분집합에 대하여 확인
		for (int i = 1; i < count; i++) {
			//할일
			int total_sin = 1;
			int total_ssn = 0;
			//3. 자릿수 확인 - flag(1<<j)와 &연산 했을 때 1이면 그 부분집합에 선택된 인덱스 (isSelected[j] == true)
			for (int j = 0; j < N; j++) {
				if (((1<<j) & i) != 0) {
					//할일 - 이제 j를 인덱스로 마음껏 쓰면 되는것임
					total_sin *= sin[j];
					total_ssn += ssn[j];
				}
			}
			//할일 - 부분집합 다 구했다 (기저조건 자리)
			min = Math.min(min, Math.abs(total_ssn - total_sin));
		}
		
	}
	
	
}















