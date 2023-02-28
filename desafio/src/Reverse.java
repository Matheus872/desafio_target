//5) Escreva um programa que inverta os caracteres de um string.
//
//IMPORTANTE:
//a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
//b) Evite usar funções prontas, como, por exemplo, reverse;

import java.util.Scanner;

public class Reverse {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String str = input.nextLine();

        String strInvertida = "";

        // percorre a string inserida de trás para frente
        for (int i = str.length() - 1; i >= 0; i--) {
            strInvertida += str.charAt(i);  // adiciona o caracter na posição i da string inserida à string invertida
        }

        System.out.println("String invertida: " + strInvertida);
    }
}

