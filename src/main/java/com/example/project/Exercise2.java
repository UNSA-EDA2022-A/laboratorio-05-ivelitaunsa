package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
        // Colocar codigo aqui
        return verificarRedundancia(stack, str);
    }

    public boolean verificarRedundancia(MyStack<Character> stack, String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')') {
                char top = stack.top();
                stack.pop();
                //Bandera auxiliar para encontrar la redundancia
                //Si hay operador es que no hay redundancia
                boolean flag = true;
                
                while (top != '(') {
                    //Chequeando operadores de precedencia
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = false;
                    }
                    // Actualizando el top
                    top = stack.top();
                    stack.pop();
                }
                // Si el operador no fue encontrado
                if (flag == true) {
                    return true;
                }
            } else {
                stack.push(c);
            }
        }
        return false;
    }
}
