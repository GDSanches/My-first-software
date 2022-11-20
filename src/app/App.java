package app;


import java.sql.Connection;

import model.conexao.Conexao;
import model.consultas.FuncoesBanco;
import view.ViewCliente;
import view.ViewLogin;

public class App {

	//private static Conexao conectar = null;
	
	public static void main(String[] args) {
		
		Connection con=Conexao.getConnection();
		
		//FuncoesBanco.insereCliente(con);
		//FuncoesBanco.insereVendedor(con);
		//FuncoesBanco.insereProduto(con);
		//FuncoesBanco.insereVenda(con);
		
		FuncoesBanco.consultaCliente(con);
		FuncoesBanco.consultaVendedor(con);
		FuncoesBanco.consultaProduto(con);
		FuncoesBanco.consultaVenda(con);
		FuncoesBanco.consultaItensvendidos(con);
		
		Conexao.closeConnection();
		 
		try {
			
			ViewLogin frame = new ViewLogin();
			frame.setVisible(true);
		} 
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		try {
			ViewCliente frame = new ViewCliente();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}


	
	
