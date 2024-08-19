package controlefuncionario;

//import utils.Conexao;
//import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {
	
	    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	    	Departamento dep1 = new Departamento();
	    	/*
	    	//TESTE COM CONEXAO COM BANCO DE DADOS
	        Connection con = Conexao.conectar();
	        if (con ==  null) {
	            System.out.println("Nao deu certo");
	        } else {
	            System.out.println("Banco conectado com sucesso");
	        }	        
	        */
	    	
	    	/*
//	    	INCLUIR DEPARTAMENTO
	        
	        dep1.setDescDepto(JOptionPane.showInputDialog("Informe o departamento"));
//	        VERIFICANDO SE ESTÁ TUDO CERTO NA INCLUSÃO
	        if (dep1.incluirDepto()) {
	        	System.out.println("Inclusão do departamento feito com sucesso!!");
	        } else {
	        	System.out.println("Erro na inclusão do departamento!!");
	        }     
	        
	        
//	        LISTAR TODOS DEPARTAMENTOS
	        List<Departamento> lista = new ArrayList<>();
	        lista = dep1.listarDeptos();
//	        FOR PARA LISTAR TODOS DEPARTAMENTOS CADASTRADOS
	        for (Departamento d : lista) {
//	        	IF PARA DEIXAR A LISTA MAIS BONITA
	        	if (d.getIdDepto() < 10) {
	        		System.out.println("Departamto: 0" + d.getIdDepto() + " | " + d.getDescDepto());
				} else {
					System.out.println("Departamto: " + d.getIdDepto() + " | " + d.getDescDepto());
				}
	        	
	        	
	        }
	        */
//	        LISTAR UM DEPARTAMENTO
	    	dep1.setIdDepto(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do departamento")));
	    	if (dep1.consultaDepto() == null) {
	    		System.out.println("Não encontrei o departamento");
	    	} else {
	    		System.out.println("Departamento " + dep1.getIdDepto() + " | " + dep1.getDescDepto());
	    	}
	    }

	}
