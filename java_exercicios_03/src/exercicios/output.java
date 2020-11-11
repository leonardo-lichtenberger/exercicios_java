package exercicios;

import java.util.*;

public class Output {

	public static void main(String[] args) {
		
		try {
			int a = 0;
			int b = 5;
			int c = b/a;
			System.out.println("Hello");
		}
		catch (Exception e){
			System.out.println("World");
		}
		finally {
			System.out.println("World");
		}

	}

}
