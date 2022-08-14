package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 18개 중에 9개를 뽑는 경우의 수
 * 조합
 * 
 * all 1~18
 * me -> 1
 * you -> 2
 * used -> 3
 * 
 * 
 * 
 * */
public class SW_6808규영이와인영이의카드게임 {
	
	static int[] me,you,all, check;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= N; tc++) { 
			// 나
			me = new int[9];
			you = new int[9];
			all = new int[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				me[i] = Integer.parseInt(st.nextToken());
				all[me[i]] = 1;
			}
			// 너
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (all[i] == 0) {
					you[idx] = i;
					idx++;
					all[i] = 2;
				}
			}
			check = Arrays.copyOf(you, you.length);
			
			meWin = 0;
			youWin = 0;
			comb(0, 0);
			
			System.out.println("#"+tc+" " + meWin + " " + youWin);
		}
	}
	
	static int meWin, youWin;
	static int i;
	static void comb(int meIdx, int youIdx) { // 조합 함수
		if (meIdx == 9) return;
		for (int t = 0; t < 9; t++) { //나를 기준으로 너를 모두 맞춰봄
			if (me[meIdx] > you[i]) {
				meWin++;
				all[you[i]] = 3; //이건 낸거다
				check[i] = 1;
			}
			else if (me[meIdx] < you[i]){
				youWin++;
				all[you[i]] = 3; //이건 낸거다
				check[i] = 1;
			}
		}
		comb(meIdx++, 0);
	}
	
}
