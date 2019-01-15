package tac.application.util;

import java.util.*;

public class InToPost {
	
	public InToPost(){
		
	}
	
//	   private Stack theStack;
//	   private String input;
//	   private String output = "";
//	   public InToPost (String in) {
//	      input = in;
//	      int stackSize = input.length();
//	      theStack = new Stack(stackSize);
//	   }
//	   public String doTrans() {
//	      for (int j = 0; j < input.length(); j++) {
//	         char ch = input.charAt(j);
//	         System.out.println("Char de la pozitia : "+j+"este : "+ch);
//	         switch (ch) {
//	            case '+': 
//	            case '-':
//	               gotOper(ch, 1); 
//	               break; 
//	            case '*': 
//	            case '/':
//	               gotOper(ch, 2); 
//	               break; 
//	            case '(': 
//	               theStack.push(ch);
//	               break;
//	            case ')': 
//	               gotParen(ch); 
//	               break;
//	            default: 
//	               output = output + ch; 
//	               break;
//	         }
//	      }
//	      while (!theStack.isEmpty()) {
//	         output = output + theStack.pop();
//	      }
//	      System.out.println(output);
//	      return output; 
//	   }
//	   public void gotOper(char opThis, int prec1) {
//	      while (!theStack.isEmpty()) {
//	         char opTop = theStack.pop();
//	         if (opTop == '(') {
//	            theStack.push(opTop);
//	            break;
//	         } else {
//	            int prec2;
//	            if (opTop == '+' || opTop == '-')
//	            prec2 = 1;
//	            else
//	            prec2 = 2;
//	            if (prec2 < prec1) { 
//	               theStack.push(opTop);
//	               break;
//	            } 
//	            else output = output + opTop;
//	         }
//	      }
//	      theStack.push(opThis);
//	   }
//	   public void gotParen(char ch) { 
//	      while (!theStack.isEmpty()) {
//	         char chx = theStack.pop();
//	         if (chx == '(') 
//	         break; 
//	         else output = output + chx; 
//	      }
//	   }
//	   public static void main(String[] args) throws IOException {
//	      String input = "1+2*4/5-7+3/6";
//	      String output;
//	      InToPost theTrans = new InToPost(input);
//	      output = theTrans.doTrans(); 
//	      System.out.println("Postfix is " + output + '\n');
//	   }
	   
	   public Double calculate(String s) {
			// delte white spaces
//			s = s.replaceAll(" ", "");
		 
			Stack<String> stack = new Stack<String>();
			char[] arr = s.toCharArray();
		 
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == ' ')
					continue;
		 
				if (arr[i] >= '0' && arr[i] <= '9') {
					sb.append(arr[i]);
		 
					if (i == arr.length - 1) {
						stack.push(sb.toString());
					}
				} else {
					if (sb.length() > 0) {
						stack.push(sb.toString());
						sb = new StringBuilder();
					}
		 
					if (arr[i] != ')') {
						stack.push(new String(new char[] { arr[i] }));
					} else {
						// when meet ')', pop and calculate
						ArrayList<String> t = new ArrayList<String>();
						while (!stack.isEmpty()) {
							String top = stack.pop();
							if (top.equals("(")) {
								break;
							} else {
								t.add(0, top);
							}
						}
		 
						Double temp = 0.0;
						if (t.size() == 1) {
							temp = Double.valueOf(t.get(0));
						} else {
							for (int j = t.size() - 1; j > 0; j = j - 2) {
								if (t.get(j - 1).equals("-")) {
									temp += 0 - Double.valueOf(t.get(j));
								} else {
									temp += Double.valueOf(t.get(j));
								}
							}
							temp += Double.valueOf(t.get(0));
						}
						stack.push(String.valueOf(temp));
					}
				}
			}
		 
			ArrayList<String> t = new ArrayList<String>();
			while (!stack.isEmpty()) {
				String elem = stack.pop();
				t.add(0, elem);
			}
		 
			Double temp = 0.0;
			for (int i = t.size() - 1; i > 0; i = i - 2) {
				if (t.get(i - 1).equals("-")) {
					temp += 0 - Double.valueOf(t.get(i));
				} else {
					temp += Double.valueOf(t.get(i));
				}
			}
			temp += Double.valueOf(t.get(0));
		 
			return temp;
		}
}
