package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 방법2 - 부분집합
 * 몇 개를 뽑으라는 말이 없다
 * 방법1 조합
 * 방법2 부분집합
 * */
public class SW_5215햄버거다이어트_prof2 {

	static int T, N, L, max;
	static Item[] src;
	static boolean[] isSelected;
	
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
			isSelected = new boolean[N];
			for (int i = 0 ;i < N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			subset(0);
			
			System.out.println("#" + t + " " + max);
			
		}

	}
	
	static void subset(int srcIdx) {
		//1. 기저조건
		if (srcIdx == N) {
			int cal = 0;
			int point = 0;
			
			for (int i = 0; i < N; i++) { //같이 계산해줄수도있음
				if (!isSelected[i]) continue; 
				//부분집합은 결국 선택을 한 경우의수 == 선택을하지않는 경우의수 이므로 !isSelected나 isSelected나 값이 동일
				cal += src[i].c;
				point += src[i].p;
			}
			if (cal <= L) max = Math.max(max, point);
			return;
		}
		
		isSelected[srcIdx] = true;
		subset(srcIdx + 1); //true일 때 부분집합 만들기
		isSelected[srcIdx] = false;
		subset(srcIdx + 1); //false로 다시 부분집합 만들기
		
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
