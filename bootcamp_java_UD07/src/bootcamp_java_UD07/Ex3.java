package bootcamp_java_UD07;

import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Ex3 {
	public static void introducirArticulo(Hashtable<String,Double> llistaInventari) {
		String articulo;
		double precio;
		articulo = JOptionPane.showInputDialog("Nombre del artículo;");
		precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
		llistaInventari.put(articulo, precio);
	}
	
	public static void mostrarArticulo(Hashtable<String,Double> llistaInventari) {
		String articulo = JOptionPane.showInputDialog("Nombre del artículo;");
		for(String i : llistaInventari.keySet()) {
			if(i.equalsIgnoreCase(articulo)) {
				System.out.println(i + " cuesta " + llistaInventari.get(i)+"€");
			}
		}
	}

	public static void inventario(Hashtable<String,Double> llistaInventari) {		
		System.out.println("Mostrando stock...");
		for(String i : llistaInventari.keySet()) {
				System.out.println(i + " > " + llistaInventari.get(i)+"€");
		}
	}
	public static void main(String[] args) {
		String opcionMenu="";
		Hashtable<String, Double> llistaInventari = new Hashtable<String, Double>();
		llistaInventari.put("Sudadera", 20.00);
		llistaInventari.put("Chaqueta", 15.00);
		llistaInventari.put("Yeezys", 25.00);
		llistaInventari.put("Arco", 30.00);
		llistaInventari.put("Dark souls", 50.00);
		llistaInventari.put("Disco", 10.00);
		llistaInventari.put("Estufa", 20.00);
		llistaInventari.put("Etanol", 40.00);
		llistaInventari.put("Chocolate", 60.00);
		llistaInventari.put("Crocs", 60.00);
		
		while(!opcionMenu.equalsIgnoreCase("salir") && !opcionMenu.equals("4") ) {
			opcionMenu = JOptionPane.showInputDialog(" 1. Introducir nuevo artículo\n 2. Mostrar artículo \n 3. Mostrar inventario\n 4. Salir");
			if (opcionMenu.equalsIgnoreCase("Introducir nuevo artículo") || opcionMenu.equals("1")) {
				introducirArticulo(llistaInventari);
			}
			else if (opcionMenu.equalsIgnoreCase("Mostrar artículo") || opcionMenu.equals("2")) {
				mostrarArticulo(llistaInventari);
			}
			else if (opcionMenu.equalsIgnoreCase("Mostrar inventario") || opcionMenu.equals("3")) {
				inventario(llistaInventari);
			}
			else if (opcionMenu.equalsIgnoreCase("salir") || opcionMenu.equals("4")) {System.out.println("Saliendo...");}
			else {System.out.println("Debes elegir una de las opciones");};
		}
	}

}
