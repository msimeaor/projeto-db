package aplicacao;

import java.util.ArrayList;
import java.util.List;

import dao.CDDAO;
import dao.DAOException;
import entily.CD;
import entily.Categoria;

public class Aplicacao {

	public static void main(String[] args) {
		
		//CD cd = new CD();
		//cd.setNome("OFFICE 365");
		//cd.setConteudo("SETUP.EXE OFFICE 365 + LICENSE KEY");
		//cd.setCategoria(Categoria.SOFTWARE);
		
		
		CDDAO cdDao = new CDDAO();
		
		try {
			
			List<CD> cds = new ArrayList<>();
			cds = cdDao.findCDsByCategoria(Categoria.MUSICA);
			
			for(CD cd : cds) {
				
				System.out.println(cd.toString()); 
				System.out.println();
				
			}
		
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
