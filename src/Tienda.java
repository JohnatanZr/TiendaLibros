import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tienda {
	private ArrayList<Libro> catalogo;
	private double caja;

	public Tienda() {
		this.catalogo = new ArrayList<Libro>();
		this.caja = 1000000;
	}

	public ArrayList<Libro> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(ArrayList<Libro> catalogo) {
		this.catalogo = catalogo;
	}

	public double getCaja() {
		return caja;
	}

	public void setCaja(double caja) {
		this.caja = caja;
	}

	public Libro BuscarISBN(int ISBN) {
		Libro encontrado = null;
		for (int i = 0; i < catalogo.size(); i++) {
			if (catalogo.get(i) != null && catalogo.get(i).getISBN() == ISBN) {
				encontrado = catalogo.get(i);
			}
		}
		return encontrado;
	}

	public Libro BuscarTitulo(String titulo) {
		Libro encontrado = null;
		for (int i = 0; i < catalogo.size(); i++) {
			if (catalogo.get(i) != null && catalogo.get(i).getNombre().equalsIgnoreCase(titulo)) {
				encontrado = catalogo.get(i);
				JOptionPane.showMessageDialog(null, "Existe el libro");
			} else {
				JOptionPane.showMessageDialog(null, "No existe el libro con ese titulo");
			}
		}
		return encontrado;
	}

	public void RegistrarLibro() {
		int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN del libro a registrar"));
		if (BuscarISBN(ISBN) == null) {
			catalogo.add(new Libro(ISBN));
			JOptionPane.showMessageDialog(null, "Se agregó con exito");
		} else {
			JOptionPane.showMessageDialog(null, "Existe el ISBN en el catalogo");
		}
	}

	public void EliminarLibro() {
		int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN del libro a eliminar"));
		Libro encontrado = BuscarISBN(ISBN);
		if (encontrado == null) {
			JOptionPane.showMessageDialog(null, "No existe el ISBN en el catalogo");
		} else {
			catalogo.remove(encontrado);
			JOptionPane.showMessageDialog(null, "Eliminado con exito");
		}
	}

	public void AbastecerLibro() {
		int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN del libro a abastecer"));
		Libro adicionar = BuscarISBN(ISBN);
		if (adicionar != null) {
			adicionar.Abastecer(this);
			JOptionPane.showMessageDialog(null, "Abastecido con exito");
		} else {
			JOptionPane.showMessageDialog(null, "El ISBN no está en el catalogo");
		}
	}

	public void VenderLibro() {
		int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN del libro a vender"));
		Libro retirar = BuscarISBN(ISBN);
		if (retirar != null) {
			retirar.Vender(this);
			JOptionPane.showMessageDialog(null, "Vendido con exito");
		} else {
			JOptionPane.showMessageDialog(null, "El ISBN no está en el catalogo");
		}
	}

	public void CantidadAbastecer() {
		int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN del libro a consultar"));
		Libro consulta = BuscarISBN(ISBN);
		if (consulta != null) {
			JOptionPane.showMessageDialog(null, "El número de abastecimientos del libro " + consulta.getNombre()
					+ " es " + consulta.Consulta(this));
		} else {
			JOptionPane.showMessageDialog(null, "El ISBN no está en el catalogo");
		}
	}
}
