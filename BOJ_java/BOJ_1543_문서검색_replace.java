package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 문자열, 그리디
 * replace, replaceAll 둘 다 사용 가능
 * 전체를 한방에 바꿔주는게 중요, for문써서 매번 바꾸면 원하는 답이 안나온다.
 * */
public class BOJ_1543_문서검색_replace {

	static String totalStr, str;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		totalStr = br.readLine();
		str = br.readLine();

		String totalStr2 = totalStr.replace(str, "1");
		
		for (int i = 0; i < totalStr2.length(); i++) {
			if (totalStr2.charAt(i) == '1')
				ans++;
		}
		System.out.println(ans);
		
	}
}
