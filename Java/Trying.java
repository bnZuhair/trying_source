
public class Trying {
  // Function to check if an expression is well parenthesized or not
  public static boolean isWellParesnthesized(String expression) throws Exception {
    // Create a new stack to store opening brackets
    Stack<Character> stack = new Stack<Character>();
    // Traverse through each character in the expression
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      // If the character is an opening bracket, push it onto the stack
      if (c == '(') {
        stack.puch(c);
      }
      // If the character is a closing bracket, pop the top element from the stack
      // and check if it matches the current closing bracket
      else if (c == ')') {
        if (stack.isEmpty()) {
          return false;
        }
        stack.pop();
      }
    }
    // If the stack is empty, the expression is well parenthesized
    return stack.isEmpty();
  }

  // Function to check if an expression is well parenthesized or not
  public static boolean isWellParenthesized(String expression) throws Exception {
    // Create a new stack to store opening brackets
    Stack<Character> stack = new Stack<Character>();
    // Traverse through each character in the expression
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      // If the character is an opening bracket, push it onto the stack
      if (c == '(' || c == '[' || c == '{') {
        stack.puch(c);
      }
      // If the character is a closing bracket, pop the top element from the stack
      // and check if it matches the current closing bracket
      else if (c == ')' || c == ']' || c == '}') {
        if (stack.isEmpty()) {
          return false;
        }
        char top = stack.pop();
        if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
          return false;
        }
      }
    }
    // If the stack is empty, the expression is well parenthesized
    return stack.isEmpty();
  }

  public static void main(String[] args) throws Exception {
    String expression = "((a+b)*c)/(d+e)";

    if (isWellParenthesized(expression)) 
      System.out.println("The expression is well parenthesized.");
     else 
      System.out.println("The expression is not well parenthesized.");
    
  }
}
