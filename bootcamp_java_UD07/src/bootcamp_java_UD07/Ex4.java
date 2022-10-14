package bootcamp_java_UD07;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex4 {
	public static Scanner sc = new Scanner(System.in);

	public static void copiaLista(Hashtable<String, Double> listaCompra, Hashtable<String, Double> productos4iva,
			Hashtable<String, Double> productos21iva) {
		String producto = "";
		System.out.println("Introduce '-' para salir de la caja ");
		while (!producto.equals("-")) {
			System.out.println("Producto:");
			producto = sc.nextLine();
			if (productos4iva.containsKey(producto)) { // Si se encuentra en una de las dos listas lo añade
				listaCompra.put(producto, productos4iva.get(producto));
			} else if (productos21iva.containsKey(producto)) {
				listaCompra.put(producto, productos21iva.get(producto));
			} else if (producto.equals("-")) {
				System.out.println("saliendo...");
			} else {
				System.out.println("El producto " + producto + " no esta disponible en la tienda");
			}
		}
	}

	public static double compruebaPago(Hashtable<String, Double> listaCompra, Hashtable<String, Double> productos4iva,
			Hashtable<String, Double> productos21iva, double precioTotalIVA) {
		Enumeration<String> e = listaCompra.keys();
		while (e.hasMoreElements()) {
			String clau = e.nextElement();// Dependiendo de en que lista se encuentre calculará un IVA u otro
			if (productos4iva.containsKey(clau)) {
				precioTotalIVA = precioTotalIVA + (listaCompra.get(clau) + (listaCompra.get(clau) * 0.04));
			} else if (productos21iva.containsKey(clau)) {
				precioTotalIVA = precioTotalIVA + (listaCompra.get(clau) + (listaCompra.get(clau) * 0.21));
			}
		}
		return precioTotalIVA;
	}

	public static void introducirArticulo(Hashtable<String, Double> llistaInventari) {
		String articulo;
		double precio;
		articulo = JOptionPane.showInputDialog("Nombre del artículo;");
		precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
		llistaInventari.put(articulo, precio);
	}

	public static void mostrarArticulo(Hashtable<String, Double> llistaInventari) {
		String articulo = JOptionPane.showInputDialog("Nombre del artículo;");
		for (String i : llistaInventari.keySet()) {
			if (i.equalsIgnoreCase(articulo)) {
				System.out.println(i + " cuesta " + llistaInventari.get(i) + "€");
			}
		}
	}

	public static void inventario(Hashtable<String, Double> llistaInventari) {
		System.out.println("Mostrando stock...");
		System.out.println("-------------------------------");
		for (String i : llistaInventari.keySet()) {
			System.out.println(i + " > " + llistaInventari.get(i) + "€");
		}
		System.out.println("-------------------------------");
	}

	public static void main(String[] args) {

		double precioTotal = 0, precioTotalIVA = 0, pago;
		String opcionMenu = "", opcion = "", opcionLista = "";
		Hashtable<String, Double> listaCompra = new Hashtable<String, Double>();
		Hashtable<String, Double> productos4iva = new Hashtable<String, Double>();
		Hashtable<String, Double> productos21iva = new Hashtable<String, Double>();

		// productos21iva con 21% iva
		productos21iva.put("Champú pantene", 3.85);
		productos21iva.put("Jack Daniels", 11.45);
		productos21iva.put("Negrita", 10.99);
		productos21iva.put("Yeezy 350", 310.0);
		productos21iva.put("Pintalabios", 7.0);
		// productos21iva con 4% iva
		productos4iva.put("Pan", 0.50);
		productos4iva.put("Leche", 0.64);
		productos4iva.put("Queso", 1.20);
		productos4iva.put("Huevos", 1.35);
		productos4iva.put("Lubina", 3.50);
		productos4iva.put("Pollo", 5.0);
		productos4iva.put("Atún", 3.25);
		productos4iva.put("Garbanzos", 0.85);
		productos4iva.put("Alubias", 0.45);
		productos4iva.put("Pasta", 1.20);
		while (!opcion.equalsIgnoreCase("salir") && !opcion.equals("3")) {
			opcion = JOptionPane.showInputDialog(" 1. Gestionar stock\n 2. Cobrar\n 3. Salir");
			if (opcion.equalsIgnoreCase("Gestionar stock") || opcion.equals("1")) {
				while (!opcionMenu.equalsIgnoreCase("salir") && !opcionMenu.equals("4")) {
					opcionMenu = JOptionPane.showInputDialog(
							" 1. Introducir nuevo artículo\n 2. Mostrar artículo \n 3. Mostrar inventario\n 4. Salir");
					if (opcionMenu.equalsIgnoreCase("Introducir nuevo artículo") || opcionMenu.equals("1")) {
						opcionLista = JOptionPane
								.showInputDialog(" Elige que productos quieres gestionar\n 1. 21% IVA\n 2. 4% IVA");
						if (opcionLista.equals("1")) {
							introducirArticulo(productos21iva);
						} else if (opcionLista.equals("2")) {
							introducirArticulo(productos4iva);
						}
					} else if (opcionMenu.equalsIgnoreCase("Mostrar artículo") || opcionMenu.equals("2")) {
						opcionLista = JOptionPane
								.showInputDialog(" Elige que productos quieres gestionar\n 1. 21% IVA\n 2. 4% IVA");
						if (opcionLista.equals("1")) {
							mostrarArticulo(productos21iva);
						} else if (opcionLista.equals("2")) {
							mostrarArticulo(productos4iva);
						}
					} else if (opcionMenu.equalsIgnoreCase("Mostrar inventario") || opcionMenu.equals("3")) {
						opcionLista = JOptionPane
								.showInputDialog(" Elige que productos quieres gestionar\n 1. 21% IVA\n 2. 4% IVA");
						if (opcionLista.equals("1")) {
							inventario(productos21iva);
						} else if (opcionLista.equals("2")) {
							inventario(productos4iva);
						}
					} else if (opcionMenu.equalsIgnoreCase("salir") || opcionMenu.equals("4")) {
						System.out.println("Saliendo...");
					} else {
						System.out.println("Debes elegir una de las opciones");
					}
					;
				}
			} else if (opcion.equalsIgnoreCase("Cobrar") || opcion.equals("2")) {
				copiaLista(listaCompra, productos4iva, productos21iva);
				precioTotalIVA = compruebaPago(listaCompra, productos4iva, productos21iva, precioTotalIVA);
				if (listaCompra.size() > 0) {// si la lista de compra tiene elementos
					System.out.print("Pago:");
					pago = sc.nextDouble();
					if (pago < precioTotalIVA) { // Si no ha pagado lo suficiente se vuelve a pedir el pago
						System.out.println("Pago insuficiente!!");
						System.out.println("Debe pagar con una cantidad superior o igual a:"
								+ String.format("%.2f", precioTotalIVA) + " introduce de nuevo el pago");
						pago = sc.nextDouble();
					}

					System.out.println("----------------------------------------------");
					System.out.println("		RECIBO DONMERCA S.L.");
					System.out.println("----------------------------------------------");
					Enumeration<String> e = listaCompra.keys();
					while (e.hasMoreElements()) {
						String clau = e.nextElement();
						if (productos4iva.containsKey(clau)) { // Dependiendo de en que lista se encuentre mostrará un
																// IVA
																// añadido u otro
							System.out.println(clau + " 4% de IVA aplicado: "
									+ String.format("%.2f", (listaCompra.get(clau) + (listaCompra.get(clau) * 0.04)))
									+ "€");
							precioTotal = precioTotal + listaCompra.get(clau);
						} else if (productos21iva.containsKey(clau)) {
							System.out.println(clau + " 21% de IVA aplicado: "
									+ String.format("%.2f", (listaCompra.get(clau) + (listaCompra.get(clau) * 0.21)))
									+ "€");
							precioTotal = precioTotal + listaCompra.get(clau);
						}
					}
					System.out.println("----------------------------------------------");
					System.out.println("Precio total bruto: " + String.format("%.2f", precioTotal) + "€");
					System.out.println("Precio total con IVA: " + String.format("%.2f", precioTotalIVA) + "€");
					System.out.println("----------------------------------------------");
					System.out.println("Número de productos comprados " + listaCompra.size());
					System.out.println("Pago: " + pago + "€");
					System.out.println("A devolver: " + String.format("%.2f", (pago - precioTotalIVA)) + "€");
					System.out.println("----------------------------------------------");
				}
			}
		}
		System.out.println("Saliendo...");
		sc.close();
	}

}
