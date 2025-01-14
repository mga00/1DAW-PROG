package com.gsd.daw.prog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gsd.daw.prog.api.UnApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AppTest {
	UnApi u=new UnApi();
	@Test
	public void ipPrimerRangoBien1() {
		boolean rango=Funciones.ipRangosBien("1.2.3.4");
		assertTrue(rango);
	}
	@Test
	@DisplayName("El primer campo es mayor que 255")
	public void primerCampoMayorDe255() {
		boolean rango=Funciones.ipRangosBien("256.2.3.4");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El primer campo es menor que 0")
	public void primerCampoMenorDe0() {
		boolean rango=Funciones.ipRangosBien("-1.2.3.4");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El segundo campo es mayor que 255")
	public void segundoCampoMayorDe255() {
		boolean rango=Funciones.ipRangosBien("1.256.3.4");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El segundo campo es menor que 0")
	public void segundoCampoMenorDe0() {
		boolean rango=Funciones.ipRangosBien("1.-2.3.4");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El tercer campo es mayor que 255")
	public void tercerCampoMayorDe255() {
		boolean rango=Funciones.ipRangosBien("1.2.300.4");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El tercer campo es menor que 0")
	public void tercerCampoMenorDe0() {
		boolean rango=Funciones.ipRangosBien("1.2.-3.4");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El cuarto campo es mayor que 255")
	public void cuartoCampoMayorDe255() {
		boolean rango=Funciones.ipRangosBien("1.2.3.400");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El cuarto campo es menor que 0")
	public void cuartoCampoMenorDe0() {
		boolean rango=Funciones.ipRangosBien("0.2.3.-4");
		assertFalse(rango);
	}
	@Test
	@DisplayName("Todos los campos son 0")
	public void todosCampos0() {
		boolean rango=Funciones.ipRangosBien("0.0.0.0");
		assertFalse(rango);
	}
	@Test
	@DisplayName("Todos los campos son 255")
	public void todosCampos255() {
		boolean rango=Funciones.ipRangosBien("255.255.255.255");
		assertFalse(rango);
	}
	@Test
	@DisplayName("Solo el ultimo campo no es 0")
	public void soloUltimoCmpoNo0() {
		boolean rango=Funciones.ipRangosBien("0.0.0.1");
		assertTrue(rango);
	}
	@Test
	@DisplayName("Solo tercer campo no es 0")
	public void soloTercerCmpoNo0() {
		boolean rango=Funciones.ipRangosBien("0.0.1.0");
		assertTrue(rango);
	}
	@Test
	@DisplayName("Solo segundo campo no es 255")
	public void soloSegundoCmpoNo255() {
		boolean rango=Funciones.ipRangosBien("255.1.255.255");
		assertTrue(rango);
	}
	@Test
	@DisplayName("Solo tercer campo no es 255")
	public void solotercerCmpoNo255() {
		boolean rango=Funciones.ipRangosBien("255.255.1.255");
		assertTrue(rango);
	}
	@Test
	@DisplayName("Solo ultimo campo no es 255")
	public void soloUltimoCmpoNo255() {
		boolean rango=Funciones.ipRangosBien("255.255.255.1");
		assertTrue(rango);
	}
	@Test
	@DisplayName("Solo segundo campo no es 0")
	public void soloSegundoCmpoNo0() {
		boolean rango=Funciones.ipRangosBien("0.1.0.0");
		assertTrue(rango);
	}
	@Test
	@DisplayName("El primer campo es -0")
	public void primerCampoEsMenos0() {
		boolean rango=Funciones.ipNoMenosCero("-0.2.3.4");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El segundo campo es -0")
	public void segundoCampoEsMenos0() {
		boolean rango=Funciones.ipNoMenosCero("4.-0.3.4");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El tercer campo es -0")
	public void tercerCampoEsMenos0() {
		boolean rango=Funciones.ipNoMenosCero("4.2.-0.4");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El cuarto campo es -0")
	public void cuartoCampoEsMenos0() {
		boolean rango=Funciones.ipNoMenosCero("4.2.3.-0");
		assertFalse(rango);
	}
	@Test
	@DisplayName("Ningun campo contiene un -0")
	public void ningunCampoEsMenos0() {
		boolean rango=Funciones.ipNoMenosCero("4.2.3.0");
		assertTrue(rango);
	}
	@Test
	@DisplayName("El rango cidr esta bien")
	public void rangoCidrBien() {
		boolean rango=Funciones.rangosCidrBien(31);
		assertTrue(rango);
	}
	@Test
	@DisplayName("El rango cidr es 32")
	public void rangoCidrEs32() {
		boolean rango=Funciones.rangosCidrBien(32);
		assertFalse(rango);
	}
	@Test
	@DisplayName("El rango cidr es 0")
	public void rangoCidrEs0() {
		boolean rango=Funciones.rangosCidrBien(0);
		assertFalse(rango);
	}
	@Test
	@DisplayName("El rango cidr es mayor a 32")
	public void rangoCidrMayor32() {
		boolean rango=Funciones.rangosCidrBien(33);
		assertFalse(rango);
	}
	@Test
	@DisplayName("El rango cidr es menor a 0")
	public void rangoCidrMenor0() {
		boolean rango=Funciones.rangosCidrBien(-1);
		assertFalse(rango);
	}
	@Test
	@DisplayName("El numero de campos de la ip es 4")
	public void numeroCamposIpEs4() {
		boolean rango=Funciones.ipCamposCorrectos("4.2.3.0");
		assertTrue(rango);
	}
	@Test
	@DisplayName("El numero de campos de la ip es menor que 4")
	public void numeroCamposIpEs3() {
		boolean rango=Funciones.ipCamposCorrectos("4.2.3");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El numero de campos de la ip es mayor que 4")
	public void numeroCamposIpEs5() {
		boolean rango=Funciones.ipCamposCorrectos("4.2.3.0.5");
		assertFalse(rango);
	}
	@Test
	@DisplayName("Todos son int validos")
	public void todosIntValidos() {
		boolean rango=Funciones.ipIntValido("4.2.3.0");
		assertTrue(rango);
	}
	@Test
	@DisplayName("El primer campo no es int valido")
	public void primeroNoIntValido() {
		boolean rango=Funciones.ipIntValido("hola.2.3.0");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El segundo campo no es int valido")
	public void segundoNoIntValido() {
		boolean rango=Funciones.ipIntValido("2.hola.3.0");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El tercer campo no es int valido")
	public void tercerNoIntValido() {
		boolean rango=Funciones.ipIntValido("1.2.hola.0");
		assertFalse(rango);
	}
	@Test
	@DisplayName("El cuarto campo no es int valido")
	public void cuartoNoIntValido() {
		boolean rango=Funciones.ipIntValido("1.2.3.hola");
		assertFalse(rango);
	}
	@Test
	@DisplayName("Si el primer campo es menor que 127")
	public void primerCampoMenor127Cidr8() {
		String rango=Funciones.clase("1.2.3.4", 8);
		assertEquals("A Subnetting:false",rango);
	}
	@Test
	@DisplayName("Si el primer campo es igual a 127 y cidr 8")
	public void primerCampoIgual127Cidr8() {
		String rango=Funciones.clase("127.2.3.4", 8);
		assertEquals("A Subnetting:false",rango);
	}
	@Test
	@DisplayName("Si el primer campo es menor que 127 y cidr 8")
	public void primerCampoMenor127CidrDif8() {
		String rango=Funciones.clase("1.2.3.4", 7);
		assertEquals("A Subnetting:true",rango);
	}
	@Test
	@DisplayName("Si el primer campo es igual a 127")
	public void primerCampoIgual127CidrDif8() {
		String rango=Funciones.clase("127.2.3.4", 9);
		assertEquals("A Subnetting:true",rango);
	}
	@Test
	@DisplayName("Si el primer campo es igual a 128 y el cidr es 16")
	public void primerCampoIgual128Cidr16() {
		String rango=Funciones.clase("128.2.3.4", 16);
		assertEquals("B Subnetting:false",rango);
	}
	@Test
	@DisplayName("Si el primer campo es igual a 190 y el cidr es 16")
	public void primerCampoIgual190Cidr16() {
		String rango=Funciones.clase("190.2.3.4", 16);
		assertEquals("B Subnetting:false",rango);
	}
	@Test
	@DisplayName("Si el primer campo es mayor a 128 y menor a 190 y el cidr es 16")
	public void primerCampoMayor128Menor190Cidr16() {
		String rango=Funciones.clase("135.2.3.4", 16);
		assertEquals("B Subnetting:false",rango);
	}
	@Test
	@DisplayName("Si el primer campo es igual a 128 y el cidr no es 16")
	public void primerCampoIgual128CidrDif16() {
		String rango=Funciones.clase("128.2.3.4", 9);
		assertEquals("B Subnetting:true",rango);
	}
	@Test
	@DisplayName("Si el primer campo es igual a 190 y el cidr no es 16")
	public void primerCampoIgual190CidrDif16() {
		String rango=Funciones.clase("190.2.3.4", 9);
		assertEquals("B Subnetting:true",rango);
	}
	@Test
	@DisplayName("Si el primer campo es mayor a 128 y menor a 190 y el cidr no es 16")
	public void primerCampoMayor128Menor190CidrDif16() {
		String rango=Funciones.clase("130.2.3.4", 9);
		assertEquals("B Subnetting:true",rango);
	}
	@Test
	@DisplayName("Si el primer campo es mayor a 190 y menor a 223 y el cidr es 24")
	public void primerCampoMayor190Menor223Cidr24() {
		String rango=Funciones.clase("200.2.3.4", 24);
		assertEquals("C Subnetting:false",rango);
	}
	@Test
	@DisplayName("Si el primer campo es igual a 191 y el cidr es 24")
	public void primerCampoIgual191Cidr24() {
		String rango=Funciones.clase("191.2.3.4", 24);
		assertEquals("C Subnetting:false",rango);
	}
	@Test
	@DisplayName("Si el primer campo es igual a 223 y el cidr es 24")
	public void primerCampoIgual223Cidr24() {
		String rango=Funciones.clase("223.2.3.4", 24);
		assertEquals("C Subnetting:false",rango);
	}
	@Test
	@DisplayName("Si el primer campo es mayor a 190 y menor a 223 y el cidr no es 24")
	public void primerCampoMayor190Menor223CidrDif24() {
		String rango=Funciones.clase("200.2.3.4", 22);
		assertEquals("C Subnetting:true",rango);
	}
	@Test
	@DisplayName("Si el primer campo es mayor igual a 191 y el cidr no es 24")
	public void primerCampoIgual191CidrDif24() {
		String rango=Funciones.clase("191.2.3.4", 22);
		assertEquals("C Subnetting:true",rango);
	}
	@Test
	@DisplayName("Si el primer campo es igual a 223 y el cidr no es 24")
	public void primerCampoIgual223CidrDif24() {
		String rango=Funciones.clase("223.2.3.4", 22);
		assertEquals("C Subnetting:true",rango);
	}
	@Test
	@DisplayName("Si el primer campo es mayor a 223 y el cidr es 36")
	public void primerCampoMayor223Cidr36() {
		String rango=Funciones.clase("224.2.3.4", 36);
		assertEquals("OTRA Subnetting:false",rango);
	}
	@Test
	@DisplayName("Si el primer campo es mayor a 223 y el cidr no es 36")
	public void primerCampoMayor223CidrDif36() {
		String rango=Funciones.clase("224.2.3.4", 35);
		assertEquals("OTRA Subnetting:true",rango);
	}
	@Test
	@DisplayName("Si el cidr no es un entero valido")
	public void cidrNoEsIntValido() {
		boolean rango=Funciones.cidrIntValido("hola");
		assertFalse(rango);
	}
	@Test
	@DisplayName("Si el cidr es un entero valido")
	public void cidrEsIntValido() {
		boolean rango=Funciones.cidrIntValido("33");
		assertTrue(rango);
	}
	
	@Test
	@DisplayName("Prueba main")
	public void pruebaMain() {
		String [] prueba= {"1.2.3.4","23"};
		App.main(prueba);
	}
	@Test
	@DisplayName("Prueba error mal el rango del cidr")
	public void pruebaErrorrangosCidrBien() {
		String [] prueba= {"1.2.3.4","38"};
		App.main(prueba);
	}
	@Test
	@DisplayName("Prueba error ip no es entero valido")
	public void pruebaErroripIntValido() {
		String [] prueba= {"1.2.3.hola", "24"};
		App.main(prueba);
	}
	@Test
	@DisplayName("Prueba error que la ip tenga algun -0")
	public void pruebaErroripNoMenosCero() {
		String [] prueba= {"1.2.3.-0", "24"};
		App.main(prueba);
	}
	@Test
	@DisplayName("Prueba error la ip tiene mas de 4 campos")
	public void pruebaErroripCamposCorrectos() {
		String [] prueba= {"1.2.3.4.5", "24"};
		App.main(prueba);
	}
	@Test
	@DisplayName("Prueba error numero de argumentos")
	public void pruebaErrorNumArgumentos() {
		String [] prueba= {"1.2.3.4"};
		App.main(prueba);
	}
	@Test
	@DisplayName("Prueba error en los rangos de la ip")
	public void pruebaErroripRangosBien() {
		String [] prueba= {"256.2.3.4", "24"};
		App.main(prueba);
	}
	@Test
	@DisplayName("Test para alcanzar la cobertura")
	public void Test100Cobertura() {
		App a=new App();
	}
}
