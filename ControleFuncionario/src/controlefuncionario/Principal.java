package controlefuncionario;

//import utils.Conexao;
//import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Principal {
	
	    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	    	
	    	/*
	    	//TESTE COM CONEXAO COM BANCO DE DADOS
	        Connection con = Conexao.conectar();
	        if (con ==  null) {
	            System.out.println("Nao deu certo");
	        } else {
	            System.out.println("Banco conectado com sucesso");
	        }	        
	        */
	    	
//	    	INCLUIR DEPARTAMENTO
	        Departamento dep1 = new Departamento();
	        dep1.setDescDepto(JOptionPane.showInputDialog("Informe o departamento"));
	        
	        if (dep1.incluirDepto()) {
	        	System.out.println("Inclusão do departamento feito com sucesso!!");
	        } else {
	        	System.out.println("Erro na inclusão do departamento!!");
	        }
	        
	    }

	}
