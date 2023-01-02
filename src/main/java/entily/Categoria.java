package entily;

public enum Categoria {
	
	SOFTWARE('S'), 
	MUSICA('M'), 
	BACKUP('B');
	
	private char caractere;
	
	Categoria(char c) {
		this.caractere = c;
	}
	
	public char getCaractere() {
		return caractere;
	}
	
	@Override
	public String toString() {
		return String.valueOf(caractere);
	}
	
	public static Categoria getCategoria(char c) {
		
		for(Categoria cat : values()) {
			
			if(cat.toString().charAt(0) == c) {
				return cat;
			}	
		}
		
		return null;
	}
	
}
