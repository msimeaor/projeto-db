package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entily.CD;
import entily.Categoria;

public class CDDAO extends DAO {

	public void createRegistro(CD cd) throws DAOException {

		String sql = "INSERT INTO cd(nome, categoria, conteudo) VALUES (?, ?, ?)";
		PreparedStatement stm = null;

		try {

			stm = getConnection().prepareStatement(sql);

			stm.setString(1, cd.getNome());
			stm.setString(2, cd.getCategoria().toString());
			stm.setString(3, cd.getConteudo());
			stm.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);

		} finally {

			if(stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}	
			}

			closeConnection();

		}
	}


	public void updateRegistro(int id, String nome, String conteudo) throws DAOException {

		String sql = "UPDATE cd SET nome = ?, conteudo = ? WHERE id = " + id;
		PreparedStatement stm = null;

		try {

			stm = getConnection().prepareStatement(sql);

			stm.setString(1, nome);
			stm.setString(2, conteudo);
			stm.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);

		} finally {

			if(stm != null) {
				try {
					stm.close();
					stm = null;
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}

			closeConnection();

		}
	}

	public CD loadRegistro(int id) throws DAOException {

		String sql = "SELECT id, nome, categoria, conteudo FROM cd WHERE id = ? ";
		PreparedStatement stm = null;

		try {

			stm = getConnection().prepareStatement(sql);
			stm.setInt(1, id);

			ResultSet rs = stm.executeQuery();

			if(!rs.next()) {
				return null;
			}
			
			CD cd = new CD();
			cd.setId(rs.getInt("id"));
			cd.setNome(rs.getString("nome"));
			cd.setConteudo(rs.getString("conteudo"));
			cd.setCategoria(Categoria.getCategoria(rs.getString("categoria").charAt(0)));
			return cd;

		} catch (SQLException e) {
			throw new DAOException(e);

		} finally {

			if(stm != null) {
				try {
					stm.close();
					stm = null;
				} catch (SQLException e) {
					throw new DAOException(e);
				}	
			}

			closeConnection();

		}

	}
	
	
	public List<CD> findCDsByCategoria(Categoria categoria) throws DAOException {
		
		String sql = "SELECT id, nome, categoria, conteudo FROM cd WHERE categoria = ?";
		PreparedStatement stm = null;
		
		try {
			
			stm = getConnection().prepareStatement(sql);
			stm.setString(1, categoria.toString());
			ResultSet rs = stm.executeQuery();
			
			List<CD> cds = new ArrayList<>();
			while(rs.next()) {
				
				CD cd = new CD();
				cd.setId(rs.getInt("id"));
				cd.setNome(rs.getString("nome"));
				cd.setConteudo(rs.getString("conteudo"));
				cd.setCategoria(Categoria.getCategoria(rs.getString("categoria").charAt(0)));
				cds.add(cd);
				
			}
			
			return cds;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		
		} finally {
			
			if(stm != null) {
				try {
					stm.close();
					stm = null;
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
			
			closeConnection();
			
		}
		
	}

}
