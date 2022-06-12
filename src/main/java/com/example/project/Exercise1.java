package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
        MyStack<Character> stack = new LinkedListStack<>();
        // Colocar codigo aqui
        llenarPila(s, stack);
        return stack.isEmpty();

    }

    public void llenarPila(String s, MyStack<Character> stack) {
        for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')' || c == ']' || c == '}') {
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        char c1 = stack.top();
                        if (c == ')' && c1 == '(' || c == ']' && c1 == '[' || c == '}' && c1 == '{') {
                            stack.pop();
                        } else {
                            return;
                        }
                    }

            }
        }
    }
}
