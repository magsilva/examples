
public class Triangulo
{
	private int a;
	
	private int b;
	
	private int c;
	
	public Triangulo(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			throw new IllegalArgumentException("Lado negativo");
		}
		
		if (a + b < c || a + c < b || b + c < a) {
			throw new IllegalArgumentException("Nao é triângulo");
		}
		
		this.a = a;
		this.b = b; 
		this.c = c;
	}
	
	public Triangulo() {
		
	}
	
	
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public boolean isEscaleno() {
		if (a != b && a != c && b != c) {
			return true;
		}
		return false;
	}
	
	public boolean isIsosceles() {
		if (a == b || a == c || b == c) {
			return true;
		}
		return false;
	}
	
	public boolean isEquilatero() {
		if (a == b && b == c) {
			return true;
		}
		return false;
	}
}
