import javax.swing.JOptionPane;

public class Operacionppal {

	public static void main(String[] args) {
		Tienda nuevo = new Tienda();
		int opc = 0;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(		
							  "Menú\n"
							+ "1. Registrar un libro en el catálogo.\n" 
							+ "2. Eliminar un libro del catálogo.\n"
							+ "3. Buscar un libro por título.\n"
							+ "4. Buscar un libro por ISBN.\n"
							+ "5. Abastecer ejemplares de un libro.\n" 
							+ "6. Vender ejemplares de un libro.\n"
							+ "7. Calcular la cantidad de transacciones de abastecimiento de un libro particular.\n"
							+ "0. Salir"));
			switch (opc) {
			case 1:
				nuevo.RegistrarLibro();
				break;
			case 2:
				nuevo.EliminarLibro();
				break;
			case 3:
				String titulo = JOptionPane.showInputDialog("Ingrese titulo del libro a consultar");
				nuevo.BuscarTitulo(titulo);
				break;
			case 4:
				int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN del libro a consultar"));
				if (nuevo.BuscarISBN(ISBN) != null) {
					JOptionPane.showMessageDialog(null, "Existe el libro en catalogo");
				} else {
					JOptionPane.showMessageDialog(null, "No existe el libro en catalogo");
				}
				break;
			case 5:
				nuevo.AbastecerLibro();
				break;
			case 6:
				nuevo.VenderLibro();
				break;
			case 7:
				nuevo.CantidadAbastecer();
				break;
			}
		} while (opc != 0);

	}

}
