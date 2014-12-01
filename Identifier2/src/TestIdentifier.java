import static org.junit.Assert.*;
import org.junit.Test;

public class TestIdentifier {
	
	
	@Test	
	public void testIndentVazio() {
		Identifier identifier = new Identifier();
		assertEquals(identifier.validateIdentifier(""),false);
	}
	
	@Test	
	public void testIndentNulo() {
		Identifier identifier = new Identifier();
		assertEquals(identifier.validateIdentifier(null),false);
	}	

	@Test	
	public void testIdent2CaracValido() {
		Identifier identifier = new Identifier();
		assertEquals(identifier.validateIdentifier("a1"),true);
	}
		
	@Test	
	public void testIdent3CaracInvalido() {
		Identifier identifier = new Identifier();
		assertEquals(identifier.validateIdentifier("2B3"),false);
	}

	@Test	
	public void testIdent4CaracInvalido() {
		Identifier identifier = new Identifier();
		assertEquals(identifier.validateIdentifier("Z-12"),false);
	}

	@Test	
	public void testIdent7CaracInvalido() {
		Identifier identifier = new Identifier();
		assertEquals(identifier.validateIdentifier("A1b2C3d"),false);
	}	
	
	@Test	
	public void testIdent2CaracInvalido2() {
		Identifier identifier = new Identifier();
		assertEquals(identifier.validateIdentifier("{1"),false);
	}
	
	@Test	
	public void testIdent7CaracInvalido2() {
		Identifier identifier = new Identifier();
		assertEquals(identifier.validateIdentifier("Aza2}3d"),false);
	}	
	
	@Test	
	public void testIdent1CaracValido() {
		Identifier identifier = new Identifier();
		assertEquals(identifier.validateIdentifier("A"),true);
	}	

	@Test	
	public void testIdent1CaracInvalido() {
		Identifier identifier = new Identifier();
		assertEquals(identifier.validateIdentifier("{"),false);
	}	

}
