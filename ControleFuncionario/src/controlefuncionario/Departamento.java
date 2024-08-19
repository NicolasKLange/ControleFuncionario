package controlefuncionario;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.Conexao;

public class Departamento {
	private int    idDepto;
	private String descDepto;
	
//	CLASSE PARA INCLUIR DEPARTAMENTO
	public boolean incluirDepto() throws ClassNotFoundException, SQLException{
		String sql = "INSERT INTO departamento (descDepto) ";
			   sql += "VALUES (?)";
			   
		Connection con = null;	
		
		con = Conexao.conectar();
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, this.getDescDepto());
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro na inclusão do departamento");
			return false;
		}
			   
		return true;
	}
	
	
//	ÁREA DE GETTERS E SETTERS
	public int getIdDepto() {
		return idDepto;
	}

	public void setIdDepto(int idDepto) {
		this.idDepto = idDepto;
	}

	public String getDescDepto() {
		return descDepto;
	}

	public void setDescDepto(String descDepto) {
		this.descDepto = descDepto;
	}
	
}
