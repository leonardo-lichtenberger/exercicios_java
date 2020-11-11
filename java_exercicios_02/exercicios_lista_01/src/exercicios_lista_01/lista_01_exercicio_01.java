package exercicios_lista_01;

import java.util.Scanner;

public class lista_01_exercicio_01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite seu nome: ");
		String nome = scan.next();
		System.out.print("Digite seu sobrenome: ");
		String sobrenome = scan.next();

		System.out.println("Meu nome é: " + nome + " " + sobrenome);
		scan.close();
	}
}
