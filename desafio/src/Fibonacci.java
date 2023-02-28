//2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
//
//IMPORTANTE:
//Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Fibonacci {


    public static void main (String[] args) throws InputMismatchException {
        Scanner input = new Scanner(System.in); // cria um objeto Scanner para ler a entrada do usuário
        System.out.print("Digite um número inteiro: ");

        try {
            int num = input.nextInt();  // lê um número inteiro da entrada
            fibonacci(num); // invoca a função que verifica se o número pertence à sequência de Fibonacci
        }catch (Exception e){   // trata a exceção caso o usuário digite um valor que não seja inteiro
            System.out.println("O programa só aceita números inteiros como entrada.");
        }

    }
    public static void fibonacci( int num){

        int a = 0;
        int b = 1;

        if (num == 0 || num == 1){  // verifica se o número é 0 ou 1, que já estão na sequência e não são cobertos pelo próximo bloco de código
            System.out.println("O número " +  num + " pertence à sequência de Fibonacci.");
            exit(0);    // encerra o programa com status 0 (sucesso)
        }

        while (b < num) {   // encontra o próximo número na sequência de Fibonacci
            int aux = b;
            b = a + b;
            a = aux;
        }

        if (b == num) {
            System.out.println("O número " +  num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " +  num + " não pertence à sequência de Fibonacci.");
        }
    }
}
