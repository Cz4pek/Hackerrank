package Java_Stack;

import java.util.*;
class Solution{
	public static boolean ibalanced(String input){
        Stack<Character> sztos = new Stack<Character>();
        for (char nawias : input.toCharArray()) {
            if(nawias == '(' || nawias == '[' || nawias == '{'){
                sztos.push(nawias);
                continue;
            }
            if(nawias == ')' && !sztos.isEmpty() && sztos.peek() == '('){
                sztos.pop();
                continue;
            }
            if(nawias == ']' && !sztos.isEmpty() && sztos.peek() == '['){
                sztos.pop();
                continue;
            }
            if(nawias == '}' && !sztos.isEmpty() && sztos.peek() == '{'){
                sztos.pop();
                continue;
            }
            if (nawias == '}' || nawias == ')' || nawias == ']') {
                sztos.push(nawias);
                break;
            }
        }
        return sztos.isEmpty();
    }
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
        
		while (sc.hasNext()) {
            String input=sc.next();
            System.out.println(ibalanced(input));
		}
		
	}
}

