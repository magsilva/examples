import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TrianguloTest
{
	private Triangulo tri;
	
	@Before
	public void setUp() {
		tri = new Triangulo();
	}
	
	@Test
	public void testIsEscaleno_ConstrutorSimples() {
		tri.setA(3);
		tri.setB(4);
		tri.setC(5);
		assertTrue(tri.isEscaleno());
	}
	
	@Test
	public void testIsEscaleno() {
		Triangulo triangulo = new Triangulo(3, 4, 5);
		assertTrue(triangulo.isEscaleno());
	}
	
	@Test(expected=Exception.class)
	public void testIsEscaleno_TrianguloInvalido() {
		Triangulo triangulo = new Triangulo(1, 2, 7);
	}

	@Test
	public void testIsIsosceles() {
		Triangulo triangulo = new Triangulo(4, 4, 5);
		assertTrue(triangulo.isIsosceles());
	}

	@Test
	public void testIsIsoscelesForEquilatero() {
		Triangulo triangulo = new Triangulo(5, 5, 5);
		assertTrue(triangulo.isIsosceles());
	}

	
	@Test
	public void testIsEquilatero() {
		Triangulo triangulo = new Triangulo(5, 5, 5);
		assertTrue(triangulo.isEquilatero());
	}

	@Test(expected=Exception.class)
	public void test3LadosNegativos() {
//		try {
			Triangulo triangulo = new Triangulo(-5, -5, -5);
			// assertFalse(triangulo.isEquilatero());
//			fail();
//		} catch (Exception e) {
//		}
	}

	@Test(expected=Exception.class)
	public void test1LadoNegativo() {
//		try {
			Triangulo triangulo = new Triangulo(-5, 1, 1);
			// assertFalse(triangulo.isEquilatero());
//			fail();
//		} catch (Exception e) {
//		}
	}

	@Test(expected=Exception.class)
	public void test1LadoZero() {
//		try {
			Triangulo triangulo = new Triangulo(0, 1, 1);
			// assertFalse(triangulo.isEquilatero());
//			fail();
//		} catch (Exception e) {
//		}
	}

}
