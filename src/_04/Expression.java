package _04;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.Stack;

public class Expression {

    private static List<String> operator = Arrays.asList("+", "-", "*", "/");

    /**
     * 中缀表达式转后缀表达式
     *
     * @param infix 中缀表达式
     * @return 后缀表达式
     * 如果当前符号的优先级大于栈顶符号优先级，则直接入栈。
     * 否则，栈顶符号出栈直到当前符号优先级大于栈顶元素优先级。
     */
    public static StringBuffer toPostfix(String infix) {
        StringBuffer postfix = new StringBuffer();//运算符的栈
        Stack<String> stack = new Stack<>();//后缀表达式
        int i = 0;
        while (i < infix.length()) {
            char ch = infix.charAt(i);
            switch (ch) {
                case '+', '-' -> {//优先级最低
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix.append(stack.pop());
                    }
                    stack.push(ch + "");
                    i++;
                }
                case '*', '/' -> { //优先级较高
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        postfix.append(stack.pop());
                    }
                    stack.push(ch + "");
                    i++;
                }
                case '(' -> {
                    stack.push(ch + "");
                    i++;
                }
                case ')' -> {
                    String pop = stack.pop();
                    while (pop != null && !"(".equals(pop)) {
                        postfix.append(pop);
                        pop = stack.pop();
                    }
                    i++;
                }
                default -> {
                    while (i < infix.length() && ch >= '0' && ch <= '9') {
                        postfix.append(ch);
                        i++;
                        if (i < infix.length()) {
                            ch = infix.charAt(i);
                        }
                    }
                    postfix.append(" ");
                }
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix;
    }

    public static List<String> toPostfixList(String infix) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < infix.length()) {
            char ch = infix.charAt(i);
            switch (ch) {
                case '+', '-' -> {
                    while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                        list.add(stack.pop());
                    }
                    stack.push(ch + "");
                    i++;
                }
                case '/', '*' -> {
                    while (!stack.isEmpty() && ("/".equals(stack.peek()) || "*".equals(stack.peek()))) {
                        list.add(stack.pop());
                    }
                    stack.push(ch + "");
                    i++;
                }
                case '(' -> {
                    stack.push(ch + "");
                    i++;
                }
                case ')' -> {
                    String pop = stack.pop();
                    while (pop != null && !"(".equals(pop)) {
                        list.add(pop);
                        pop = stack.pop();
                    }
                    i++;
                }
                default -> {
                    StringBuilder str = new StringBuilder();
                    while (i < infix.length() && (ch == '.' || ch >= '0' && ch <= '9')) {
                        str.append(ch);
                        i++;
                        if (i < infix.length()) {
                            ch = infix.charAt(i);
                        }
                    }
                    list.add(str.toString());
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 后缀表达式求值
     *
     * @param postfix 后缀表达式
     * @return result
     */
    public static long toValue(String postfix) {

        return 0;
    }

    public static double toValue(List<String> postfix) {
        Stack<String> numStack = new Stack<>();
        for (String s : postfix) {
            if (operator.contains(s)) {
                //运算符
                String first = numStack.pop();
                String second = numStack.pop();
                numStack.push(String.valueOf(doOperator(first, second, s)));

            } else {
                numStack.push(s);
            }
        }
        return Double.parseDouble(numStack.pop());
    }

    public static double doOperator(String first, String second, String operator) {
        switch (operator) {
            case "+" -> {
                return BigDecimal.valueOf(Double.parseDouble(second)).add(BigDecimal.valueOf(Double.parseDouble(first))).doubleValue();
            }
            case "-" -> {
                return BigDecimal.valueOf(Double.parseDouble(second)).subtract(BigDecimal.valueOf(Double.parseDouble(first))).doubleValue();
            }
            case "*" -> {
                return BigDecimal.valueOf(Double.parseDouble(second)).multiply(BigDecimal.valueOf(Double.parseDouble(first))).doubleValue();
            }
            case "/" -> {
                return BigDecimal.valueOf(Double.parseDouble(second)).divide(BigDecimal.valueOf(Double.parseDouble(first)), 10, RoundingMode.HALF_UP).doubleValue();
            }
        }
        return 0D;
    }

    public static void main(String[] args) {
        System.out.println(toPostfix("9+(3-1)*3+10/2"));
        System.out.println(toPostfixList("9+(3-1.5)*3+10/2"));
        System.out.println(toValue(toPostfixList("9+(3-1.3)/3+10/2")));
    }
}
