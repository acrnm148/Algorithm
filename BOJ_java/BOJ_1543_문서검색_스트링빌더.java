package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * StringBuilder
 * String연산을 삭제, 추가할 때는 StringBuilder를 활용하자
 * */
public class BOJ_1543_문서검색_스트링빌더 {

	static String totalStr, str;
	static int ans, size, s;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder totalStr = new StringBuilder();

		totalStr.append(br.readLine());
		str = br.readLine();
		size = str.length();
		
		while (true) {
			s = totalStr.indexOf(str);
			if (s == -1) break; //더 이상 없을 경우 break;
			ans++;
			totalStr.delete(0, s+size);
		}
		System.out.println(ans);
		
	}
}
