/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
public class Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				int a = stack.pop();
				int b = stack.pop();
				int res = b + a;
				stack.push(res);
			} else if (tokens[i].equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				int res = b - a;
				stack.push(res);
			} else if (tokens[i].equals("*")) {
				int a = stack.pop();
				int b = stack.pop();
				int res = b * a;
				stack.push(res);
			} else if (tokens[i].equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				int res = b / a;
				stack.push(res);
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.peek();
	}
}
