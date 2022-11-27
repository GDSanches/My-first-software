package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import model.conexao.Conexao;
import model.entidades.ModelProdutos;
import model.queries.QueryProduto;

public class ControllerProdutos {
	
	 Connection con=Conexao.getConnection();
	/**
	 * 
	 * SALVA UM PRODUTO NO BANCO DE DADOS
	 */
	public void salvarProdutoController(ModelProdutos modelProdutos) {
		QueryProduto.insereProduto(con, modelProdutos);
	/**
	 * BUSCA UM PRODUTO ESPECIFICO	
	 */
	}
	public ModelProdutos retornaProdutoController (int pCod) {
		return QueryProduto.retornaProduto(con, pCod);
	}
	/**
	 * 
	 * RETORNA LISTA DE PRODUTOS 
	 */
	public ArrayList<ModelProdutos> listaProdutos(){
		return QueryProduto.retornarListaProdutos(con);
	}
	public void excluirProdutoController(int pCod) {
		QueryProduto.excluirProduto(con, pCod);
	}
	

}