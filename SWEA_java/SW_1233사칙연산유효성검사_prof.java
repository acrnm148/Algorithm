package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 밑에서부터 따짐
 * 
 * */
public class SW_1233사칙연산유효성검사_prof {
	
	static int N, ans;
	static char[] node;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N+1];
			
			for (int i = 1; i <= N; i++) {
				node[i] = br.readLine().split(" ")[1].charAt(0);
			}
			int idx = N;
			ans = 1;
			while (idx != 1) {
				//현재 
				if(!Character.isDigit(node[idx]) || !Character.isDigit(node[idx-1]) 
						|| Character.isDigit(node[idx/2])) {//숫자인지 문자인지 알려줌, isDigit 숫자면 true 리턴
					ans = 0;
					break;
				}
				node[idx/2] = '1'; //실제 수식 처리X => 단순하게 유효성 검사
				idx -= 2;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
