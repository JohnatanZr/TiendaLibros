import javax.swing.JOptionPane;

public class Transaccion {
	private String tipoTransaccion;
	private int fecha;
	private int cantidad;
	public Transaccion(String tipoTransaccion, int cantidad) {
		this.tipoTransaccion = tipoTransaccion;
		this.fecha = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fecha de la transcacción"));
		this.cantidad = cantidad;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
