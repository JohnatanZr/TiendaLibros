import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Libro {
	private int ISBN;
	private String nombre;
	private double precioCompra;
	private double precioVenta;
	private int cantidad;
	private ArrayList<Transaccion> transaccion;

	public Libro(int iSBN) {
		ISBN = iSBN;
		this.nombre = JOptionPane.showInputDialog("Ingrese nombre del libro");
		this.precioCompra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio de compra"));
		this.precioVenta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio de venta"));
		this.cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de ejemplares"));
		this.transaccion = new ArrayList<Transaccion>();
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ArrayList<Transaccion> getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(ArrayList<Transaccion> transaccion) {
		this.transaccion = transaccion;
	}

	public void Abastecer(Tienda tienda) {
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantiadad de libros a abastecer"));
		this.cantidad += cantidad;
		transaccion.add(new Transaccion("abastecer", cantidad));
		JOptionPane.showMessageDialog(null, "Abastecido");
	}

	public void Vender(Tienda tienda) {
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantiadad de libros a vender"));
		if (this.cantidad > cantidad) {
			this.cantidad -= cantidad;
			transaccion.add(new Transaccion("venta", cantidad));
		} else {
			JOptionPane.showMessageDialog(null, "No hay cantidad suficiente disponible");
		}

	}

	public int Consulta(Tienda tienda) {
		int contador = 0;
		for (Transaccion e : transaccion) {
			if (e.getTipoTransaccion().equals("abastecer")) {
				contador++;
			}
		}
		return contador;
	}

	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + ", nombre=" + nombre + ", precioCompra=" + precioCompra + ", precioVenta="
				+ precioVenta + ", cantidad=" + cantidad + "]";
	}
	
	

}
