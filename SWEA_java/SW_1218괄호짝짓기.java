package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW_1218괄호짝짓기 {

	static Stack<Character> stack;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int cnt = 0;
			stack = new Stack<>();

			int num = Integer.parseInt(br.readLine());
			char[] cmd = br.readLine().toCharArray();
			for (int i = 0; i < num; i++) {
				if (i != 0 && stack.isEmpty()) break;
				
				if (cmd[i] == '(') stack.push(cmd[i]);
				else if (cmd[i] == '{') stack.push(cmd[i]);
				else if (cmd[i] == '[') stack.push(cmd[i]);
				
				if (cmd[i] == ')') {
					if(stack.peek() == '(') stack.pop();
					else stack.push(cmd[i]);
					
				}
				else if (cmd[i] == '}') {
					if(stack.peek() == '{') stack.pop();
					else stack.push(cmd[i]);
					
				}
				else if (cmd[i] == ']') {
					if(stack.peek() == '[') stack.pop();
					else stack.push(cmd[i]);
					
				}
				else if (cmd[i] == '>') {
					if(stack.peek() == '<') stack.pop();
					else stack.push(cmd[i]);
					
				}
				
			}
			int res = 0;
			if (stack.isEmpty() == true) res = 1;
			System.out.println("#" + tc + " " + res);
		}
	}

}
