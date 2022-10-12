package bootcamp_java_UD07;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {
	public static Scanner sc = new Scanner(System.in);

	public static void omplirMaterias(ArrayList<String> materias, int numMaterias) {
		String materia;
		for (int i = 0; i < numMaterias; i++) {
			System.out.print("introduce la asignatura: ");
			materia = sc.next();
			materias.add(materia);
		}
	}

	public static double calcularMedia(ArrayList<String> materias) {
		double nota, media = 0;
		for (String i : materias) {
			System.out.println("Nota de " + i + ": ");
			nota = sc.nextDouble();
			media = media + nota;
		}
		media = media / materias.size();
		return media;
	}

	public static void main(String[] args) {
		ArrayList<String> materias = new ArrayList<>();
		Hashtable<String, String> llista = new Hashtable<String, String>();
		String alumno;
		System.out.print("Número de alumnos en clase: ");
		int tamany = sc.nextInt();
		System.out.print("Número de materias: ");
		int numMaterias = sc.nextInt();
		omplirMaterias(materias, numMaterias);
		sc.nextLine();// limpiar el buffer
		for (int i = 0; i < tamany; i++) {
			System.out.println("Nombre del alumno nº " + (i + 1) + ":");
			alumno = sc.next();
			llista.put(alumno, String.format("%.2f", calcularMedia(materias)));
		}
		System.out.println("Mappings of ht1 : " + llista);
		sc.close();
	}

}
