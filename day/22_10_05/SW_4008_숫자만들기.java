package a22_10_05;

import java.util.*;
import java.io.*;

public class SW_4008_숫자만들기 {

	static int[] tgt, num, op;
	static int N, max, min, ans;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			op = new int[4];
			tgt = new int[N-1];
			isSelected = new boolean[N-1];
			
			st = new StringTokenizer(br.readLine());
			int idx = 0;
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}// 입력 끝
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			perm(0);
			ans = max-min;
			System.out.println("#"+tc+" "+ ans );
		}
	}
	
	static void perm(int cnt) {
		if (cnt == N-1) {
			int res = getResult();
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (op[i] == 0) continue;
			
			op[i]--;
			tgt[cnt] = i;
			perm(cnt+1);
			op[i]++;
		}
	}
	
	static int getResult() {
		int res = num[0];
		for (int i = 0; i < N-1; i++) {
			int oper = tgt[i];
			switch (oper) {
			case 0: res += num[i+1]; break; // +
			case 1: res -= num[i+1]; break; // -
			case 2: res *= num[i+1]; break; // *
			case 3: res /= num[i+1]; break; // /
			}
		}
		return res;
	}
}
