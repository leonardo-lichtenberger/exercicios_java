package exercicios_lista_01;

import java.util.Scanner;

public class lista_01_exercicio_03 {

	public static void main(String[] args) {

		int imp = -1;
		int soma = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("N�mero de entrada : ");
		int num = scan.nextInt();
		
		System.out.println("Os n�meros �mpares s�o : ");

		for (int i = 0; i < num; i++) {
			imp = imp + 2;
			System.out.println(imp);
			soma = soma + imp;
		}

		System.out.println("A soma dos n�meros �mpares naturais at� " + num + " � : " + soma);
		scan.close();
	}

}
