package test;

import static org.junit.Assert.*;	

import org.junit.Test;

import ar.edu.unlam.pb2.Contacto;
import ar.edu.unlam.pb2.Llamada;
import ar.edu.unlam.pb2.Provincia;


public class TestContactos {
	
	@Test
	public void queSePuedaConvertirUnStringAUnInteger() {
		int valorEsperado = 52;
		/*double realPrimitivo = 100.5;
		boolean booleanoPrimitivo = false;*/
		
		Integer enteroWrapper = Integer.parseInt("52");
		
		assertEquals(valorEsperado,(int)enteroWrapper);
	}

	@Test
	public void queSePuedaCrearUnContacto() {
		//Preparación
		Contacto nuevo;
		final String NOMBRE_Y_APELLIDO_ESPERADO = "Enzo Fernandez";
		final String CELULAR_ESPERADO = "+5491256723";
		final String E_MAIL_ESPERADO = "enzofernandez@carp.com.ar";
		final String DIRECCION_ESPERADA = "Udaondo y Lugones";
		final Integer CODIGO_POSTAL_ESPERADO = 1708;
		final String LOCALIDAD_ESPERADA = "CABA";
		final Provincia PROVINCIA_ESPERADA = Provincia.CABA;
		final Boolean ES_CLIENTE = false;
		final Boolean DESEA_SER_LLAMADO = true;
		//Ejecución
		nuevo = new Contacto(NOMBRE_Y_APELLIDO_ESPERADO,CELULAR_ESPERADO,E_MAIL_ESPERADO,DIRECCION_ESPERADA,CODIGO_POSTAL_ESPERADO,LOCALIDAD_ESPERADA,PROVINCIA_ESPERADA);
		//Validación
		assertNotNull(nuevo);
		assertEquals(DESEA_SER_LLAMADO,nuevo.getDeseaSerLlamado());
		assertFalse(nuevo.getEsCliente());	
	}
	
	@Test
	public void queLosDatosDelContactoSeGuardenCorrectamente() {
		//Preparación
		Contacto nuevo;
		final String NOMBRE_Y_APELLIDO_ESPERADO = "Enzo Fernandez";
		final String CELULAR_ESPERADO = "+5491256723";
		final String E_MAIL_ESPERADO = "enzofernandez@carp.com.ar";
		final String DIRECCION_ESPERADA = "Udaondo y Lugones";
		final Integer CODIGO_POSTAL_ESPERADO = 1708;
		final String LOCALIDAD_ESPERADA = "CABA";
		final Provincia PROVINCIA_ESPERADA = Provincia.CABA;
		final Boolean ES_CLIENTE = false;
		final Boolean DESEA_SER_LLAMADO = true;
		//Ejecución
		nuevo = new Contacto(NOMBRE_Y_APELLIDO_ESPERADO,CELULAR_ESPERADO,E_MAIL_ESPERADO,DIRECCION_ESPERADA,CODIGO_POSTAL_ESPERADO,LOCALIDAD_ESPERADA,PROVINCIA_ESPERADA);
		//Validación
		assertNotNull(nuevo);
		assertEquals(NOMBRE_Y_APELLIDO_ESPERADO,nuevo.getNombreYApellido());
		assertEquals(CELULAR_ESPERADO,nuevo.getCelular());
		assertEquals(E_MAIL_ESPERADO,nuevo.getEmail());
		assertEquals(DIRECCION_ESPERADA,nuevo.getDireccion());
		assertEquals(CODIGO_POSTAL_ESPERADO,nuevo.getCodigoPostal());
		assertEquals(LOCALIDAD_ESPERADA,nuevo.getLocalidad());
		assertEquals(PROVINCIA_ESPERADA,nuevo.getProvincia());
		
		assertFalse(nuevo.getEsCliente());	
		assertTrue(nuevo.getDeseaSerLlamado());
	}
	
	@Test
	public void queSePuedaRegistrarUnaLlamadaExitosa() {
		//Preparación
		Contacto nuevo;
		Llamada nueva;
		final String NOMBRE_Y_APELLIDO_ESPERADO = "Enzo Fernandez";
		final String CELULAR_ESPERADO = "+5491256723";
		final String E_MAIL_ESPERADO = "enzofernandez@carp.com.ar";
		final String DIRECCION_ESPERADA = "Udaondo y Lugones";
		final Integer CODIGO_POSTAL_ESPERADO = 1708;
		final String LOCALIDAD_ESPERADA = "CABA";
		final Provincia PROVINCIA_ESPERADA = Provincia.CABA;
		final Boolean RESULTADO_DE_LA_LLAMADA_ESPERADA = true;
		final String OBSERVACIONES_ESPERADAS = "Se realizo la venta";
		final Integer CANTIDAD_DE_LLAMADAS_RECIBIDAS_ESPERADAS = 1;
		//Ejecución
		nuevo = new Contacto(NOMBRE_Y_APELLIDO_ESPERADO,CELULAR_ESPERADO,E_MAIL_ESPERADO,DIRECCION_ESPERADA,CODIGO_POSTAL_ESPERADO,LOCALIDAD_ESPERADA,PROVINCIA_ESPERADA);
		nueva = new Llamada(RESULTADO_DE_LA_LLAMADA_ESPERADA,OBSERVACIONES_ESPERADAS);
		nuevo.realizarNuevaLlamada(nueva);
		//Validacion
		assertEquals(CANTIDAD_DE_LLAMADAS_RECIBIDAS_ESPERADAS,nuevo.getCantidadDeLlamadasRecibidas());
		
	}
	
	@Test
	public void queSeValideCorrectamenteElFormatoDelEmail() {
		//Preparación
		Contacto nuevo;
		final String EMAIL_CORRECTO = "enzofernandez@carp.com.ar";
		//Ejecución
		nuevo = new Contacto();
		//Validación
		assertTrue(nuevo.esUnEmailValido(EMAIL_CORRECTO));
	}
	
	@Test
	public void queSeValideCorrectamenteUnEmailSinArroba() {
		//Preparación
		Contacto nuevo;
		final String EMAIL_INCORRECTO = "enzofernandezcarp.com.ar";
		//Ejecución
		nuevo = new Contacto();
		//Validación
		assertFalse(nuevo.esUnEmailValido(EMAIL_INCORRECTO));
	}
	
	@Test
	public void queSeValideCorrectamenteUnEmailSinPunto() {
		//Preparación
		Contacto nuevo;
		final String EMAIL_INCORRECTO = "enzofernandez@carpcomar";
		final Boolean RESULTADO_ESPERADO;
		//Ejecución
		RESULTADO_ESPERADO = Contacto.esUnEmailValido(EMAIL_INCORRECTO);
		//Validación
		assertFalse(RESULTADO_ESPERADO);
	}

}
