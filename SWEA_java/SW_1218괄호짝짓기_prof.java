package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SW_1218괄호짝짓기_prof {

	//static Stack<Character> stack = new Stack<>(); 
	static Deque<Character> stack = new ArrayDeque<>(); //덱으로 변경
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int cnt = 0;
			//stack = new Stack<>(); 
			stack.clear(); //=> 일반적인 방법

			int num = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for (int i = 0; i < num; i++) {
				char token = str.charAt(i);
				
				//시작문자
				if (token == '<' || token == '{' || token == '(' || token == '[') {
					stack.push(token);
				} else { //닫는문자
					if (stack.isEmpty()) {
						stack.push(token);
						break;
					}
					char pre = stack.peek();
					if (token == '>' && pre == '<') break;
					else if (token == '}' && pre == '{') break;
					else if (token == ')' && pre == '(') break;
					else if (token == ']' && pre == '[') break;
					else stack.pop();
				}
				
			}
			if (stack.isEmpty()) ans = 1;
			System.out.println("#" + tc + " " + ans);
		}
	}

}
