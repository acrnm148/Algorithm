package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1289원재의메모리복구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
			int cnt = 0;
			String str = in.readLine();
			char start = str.charAt(0);
			char pre = start;
			
			if (start == '1')
				cnt++;
			
			for (int i = 1; i < str.length(); i++) {
				if (pre == str.charAt(i)) 
					continue;
				else {
					pre = str.charAt(i);
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
