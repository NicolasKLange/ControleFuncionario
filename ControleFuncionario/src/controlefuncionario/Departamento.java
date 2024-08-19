package controlefuncionario;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.Conexao;

public class Departamento {
	private int    idDepto;
	private String descDepto;
	
	
//	CLASSE PARA INCLUIR DEPARTAMENTO
	public boolean incluirDepto() throws ClassNotFoundException, SQLException{
		String sql = "INSERT INTO departamento (descDepto) ";
			   sql += "VALUES (?)";	  
//		INSTANCIAR CLASSE CONEXAO    
		Connection con = Conexao.conectar();	
		


		
//		TRY/CATCH PARA A INCLUSAO DO DEPARTAMENTO
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
	
//	LISTAR DEPARTAMENTOS CADASTRADOS
	public List<Departamento> listarDeptos() throws ClassNotFoundException{
		
//		CRIANDO LISTA 	
		List<Departamento> listaDepto = new ArrayList<>();
		
//		INSTANCIAR CLASSE CONEXAO 
		Connection con = Conexao.conectar();
		
//		COMANDO PARA LISTAR DEPARTAMENTOS
		String sql = "SELECT idDepto, descDepto FROM departamento ORDER BY idDepto";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
//			WHILE PARA FAZER A LISTAGEM DE TODOS OS DEPARTAMENTOS
			while (rs.next()) {
//				INSTANCIAR CLASSE DEPARTAMENTO 
				Departamento dep = new Departamento();
				dep.setIdDepto(rs.getInt("idDepto"));
				dep.setDescDepto(rs.getString("descDepto"));
				listaDepto.add(dep);
			}
		} catch (SQLException e) {
			System.out.println("Erro em listar departamentos");
			return null;
		}
//		RETORNA A LISTA DOS DEPARTAMENTOS
		return listaDepto;
	
	}
	
/*	
  	LISTAR UM DEPARTAMENTO CADASTRADO 
 */
	public Departamento consultaDepto() throws ClassNotFoundException{
		
//		CRIANDO LISTA 	
		Departamento dep1 = new Departamento();
		dep1 = null;
				
//		INSTANCIAR CLASSE CONEXAO 
		Connection con = Conexao.conectar();
		
//		COMANDO PARA LISTAR DEPARTAMENTOS
		String sql = "SELECT descDepto FROM departamento where idDepto = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, this.getIdDepto());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				dep1.setDescDepto(rs.getString("descDepto"));
			}
		} catch (SQLException e) {
			System.out.println("Erro na consulta do departamento");
			return null;
		}
		return dep1;
	
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
