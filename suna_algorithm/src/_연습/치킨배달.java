package _연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 조합
 * */
public class 치킨배달 {

	static int min, N, M, hi, ci;
	static Pos[] home, chicken;
	static int[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new Pos[2*N+1];
		chicken = new Pos[13];
		tgt = new int[M];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j<=N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) home[hi++] = new Pos(i, j);
				if (tmp == 2) chicken[ci++] = new Pos(i, j);
			}
		}
		min = Integer.MAX_VALUE;
		
		//조합
		comb(0, 0);
		System.out.println(min);
		
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//1. 기저조건 - tgt이 다 찼을 때
		if (tgtIdx == tgt.length) {
			//조합 만들어졌을 때
			int sum = 0;
			//모든 집을 기준으로 집집마다 - 선택한 치킨집과의 거리 최소
			for (int h = 0; h < hi; h++) {
				int dist = Integer.MAX_VALUE;
				for (int c = 0; c < tgtIdx; c++) {
					//치킨집이 2곳이라면, 2곳 중에 최소거리만 더하면 된다
					dist = Math.min(dist, Math.abs(home[h].x - chicken[tgt[c]].x) + Math.abs(home[h].y - chicken[tgt[c]].y));
				}
				sum += dist;
			}
			min = Math.min(min, sum);
			return;
		}
		//2. 기저조건 - src를 다 봤을 때
		if (srcIdx == ci) return;
		
		//3. 조합tgt에 src를 넣어줌
		tgt[tgtIdx] = srcIdx;
		
		//4. 선택이냐 선택아니냐
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
		
	}
	
	static class Pos {
		int x;
		int y; //static 클래스 선언하면 멤버변수도 무조건 static해줘야 갖다 쓸 수 있음
		public Pos(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
}
