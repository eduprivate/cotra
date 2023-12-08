package br.eduprivate.problems_solving;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<String> openStack = new Stack<>();

        String open = "[{(";

        for (int i = 0; i < s.length(); i++) {
            String atual = String.valueOf(s.charAt(i));

            if (open.contains(atual)){
                openStack.push(atual);
            }  else if (!open.contains(atual) && openStack.isEmpty()){
              return false;
            } else {
                if (!openStack.isEmpty()) {
                    final String peek = openStack.peek();
                    if (peek.equals("{") && atual.equals("}")) {
                        openStack.pop();
                    } else if (peek.equals("[") && atual.equals("]")) {
                        openStack.pop();
                    } else if (peek.equals("(") && atual.equals(")")) {
                        openStack.pop();
                    } else {
                        return false;
                    }
                }
            }

        }

        return openStack.empty();
    }

    public static void main(String[] args)
    {
        String s = "(])";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(s));
    }
}
