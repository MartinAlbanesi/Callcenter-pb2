package ar.edu.unlam.pb2;

public class Contacto {
	//Variables
	private String nombreYApellido;
	private String celular;
	private String email;
	private String direccion;
	private Integer codigoPostal;
	private String localidad;
	private Provincia provincia;
	private Boolean esCliente;
	private Boolean deseaSerLlamado;
	private Llamada llamadasRecibidas[];
	private final Integer CANTIDAD_MAXIMA_DE_LLAMADAS;
	private Integer cantidadDeLlamadasRecibidas;
	
	
	public Contacto(){
		this.CANTIDAD_MAXIMA_DE_LLAMADAS = 100;
		this.cantidadDeLlamadasRecibidas = 0;
		this.esCliente = false;
		this.deseaSerLlamado = true;
	}
	
	//Constructor
	public Contacto(String nombreYApellido, String celular, String email, String direccion, Integer codigoPostal,
			String localidad, Provincia provincia) {
		super();
		this.CANTIDAD_MAXIMA_DE_LLAMADAS = 100;
		this.cantidadDeLlamadasRecibidas = 0;
		this.nombreYApellido = nombreYApellido;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.esCliente = false;
		this.deseaSerLlamado = true;
		llamadasRecibidas = new Llamada[CANTIDAD_MAXIMA_DE_LLAMADAS];
	}
	
	//Métodos

	
	
	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setEsCliente(Boolean esCliente) {
		this.esCliente = esCliente;
	}

	public void setLlamadasRecibidas(Llamada[] llamadasRecibidas) {
		this.llamadasRecibidas = llamadasRecibidas;
	}

	public String getCelular() {
		return celular;
	}

	public String getEmail() {
		return email;
	}

	public String getDireccion() {
		return direccion;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public Provincia getProvincia() {
		return provincia;
	}
	
	public Boolean getEsCliente() {
		return esCliente;
	}
	
	public Boolean getDeseaSerLlamado() {
		return deseaSerLlamado;
	}
	
	public void realizarNuevaLlamada(Llamada nueva) {
		llamadasRecibidas[cantidadDeLlamadasRecibidas++] = nueva;
	}
	
	public Integer getCantidadDeLlamadasRecibidas() {
		return cantidadDeLlamadasRecibidas;
	}
	
	public static Boolean esUnEmailValido(String emailIngresado) {
		if(emailIngresado.contains("@") && emailIngresado.contains(".")) {
			return true;
		}
		else {
			return false;
		}
	}
}
