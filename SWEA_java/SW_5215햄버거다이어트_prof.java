package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 방법1 - 조합
 * 몇 개를 뽑으라는 말이 없다
 * 방법1 조합
 * 방법2 부분집합
 * */
public class SW_5215햄버거다이어트_prof {

	static int T, N, L, max;
	static Item[] src;
	static Item[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			//초기화
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			//src : N개로 고정
			src = new Item[N];
			for (int i = 0 ;i < N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// tgt -> 1개로, 2개로... N개로 재료 사용
			for (int i = 0; i < N; i++) {
				tgt = new Item[i]; //1개짜리 배열, 2개짜리 배열 ... N 개짜리 배열
				comb(0, 0); //srcIdx, tgtIdx //comb가 N번 돈다
			}
			
			System.out.println("#" + t + " " + max);
			
		}

	}
	
	static void comb(int srcIdx, int tgtIdx) {
		// 기저조건
		/*
		 * 타겟이 다 차면 기저조건에서 검사. 
		 * "가지치기" 를 할 수 없다.
		 * => 칼로리가 넘으면 끊어낼 수 없다.
		 * */
		if (tgtIdx == tgt.length) {
			//L을 초과하지 않으면서 최대값을 따져본다
			int cal = 0;
			int point = 0;
			
			//칼로리의 합
			for (int i = 0; i < tgtIdx; i++) {
				cal += tgt[i].c;
			}
			//칼로리 체크
			if (cal <= L) {
				for (int i = 0; i < tgtIdx; i++) {
					point += tgt[i].p;
				}
				max = Math.max(max, point);
			}
			return;
		}
		
		if (srcIdx == N) return;
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx+1, tgtIdx+1); //현재 선택
		comb(srcIdx+1, tgtIdx); // 현재 선택 X
		
	}
	
	static class Item {
		int p; // 맛에 대한 점수
		int c; // 칼로리
		public Item(int p, int c) {
			this.p = p;
			this.c = c;
		}
		
	}
}
