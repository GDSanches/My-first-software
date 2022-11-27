package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControllerProdutos;
import model.entidades.ModelProdutos;

public class ViewProduto extends JFrame  {
	


	private JPanel contentPane;
	private JTextField textCodCliente;
	private JTextField textPnome;
	private JTextField textEstoque;
	private JTextField textPvista;
	private JTextField textPprazo;
	private JTable tableProdutos;
	private JTextField textEspecificacoes;
	private JTextField textPesquisa;
	
	ArrayList<ModelProdutos> listaModelProduto = new ArrayList();
	ControllerProdutos controllerProdutos = new ControllerProdutos();
	ModelProdutos modelProdutos = new ModelProdutos();
	/**
	 * coloca os produtos na tabela de produtos
	 */
	private void carregarProdutosTabela() {
		listaModelProduto = controllerProdutos.listaProdutos();
		DefaultTableModel modelo = (DefaultTableModel) tableProdutos.getModel();
		modelo.setNumRows(0);
		//inserir produtos
		int cont = listaModelProduto.size();
		for(int i = 0;i<cont;i++) {
			modelo.addRow(new Object[] {
					listaModelProduto.get(i).getCodProduto(),
					listaModelProduto.get(i).getProNome(),
					listaModelProduto.get(i).getQtdEstoque(),
					listaModelProduto.get(i).getPrecoVista(),
					listaModelProduto.get(i).getPrecoPrazo(),
					listaModelProduto.get(i).getProEspecificacoes()
											
			});
		}
	}
	
	/**
	 * salva os produtos no banco
	 */
	public void salvarButtonActionPerformed(ActionEvent e) {
		modelProdutos.setProNome(this.textPnome.getText());
		modelProdutos.setQtdEstoque(Integer.parseInt(this.textEstoque.getText()));
		modelProdutos.setPrecoPrazo(Double.parseDouble(this.textPprazo.getText()));
		modelProdutos.setPrecoVista(Double.parseDouble(this.textPvista.getText()));
		modelProdutos.setProEspecificacoes(this.textEspecificacoes.getText());
		controllerProdutos.salvarProdutoController(modelProdutos);
		this.carregarProdutosTabela();
	}
	/**
	 * deleta produto no banco
	 */
	public void deleteButtonActionPerformed(ActionEvent e) {
		int linha = tableProdutos.getSelectedRow();
		int codigoProduto =(int) tableProdutos.getValueAt(linha, 0);
		controllerProdutos.excluirProdutoController(codigoProduto);
		this.carregarProdutosTabela();
	}
	/**
	 * habilita e desabilita a digitação nos campos
	 */
	private void habilitaCampos(boolean c) {
		textEspecificacoes.setEditable(c);
		textEstoque.setEditable(c);
		textPnome.setEditable(c);
		textPprazo.setEditable(c);
		textPvista.setEditable(c);
	}
 
	/**
	 * Launch the application.
	 */
	
	public ViewProduto() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 935, 710);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(36, 26, 46, 14);
		panel.add(lblCodigo);
		
		textCodCliente = new JTextField();
		textCodCliente.setEditable(false);
		textCodCliente.setBounds(34, 51, 80, 20);
		panel.add(textCodCliente);
		textCodCliente.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(162, 26, 46, 14);
		panel.add(lblNome);
		
		textPnome = new JTextField();
		textPnome.setBounds(162, 51, 720, 20);
		panel.add(textPnome);
		textPnome.setColumns(10);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setBounds(36, 120, 78, 14);
		panel.add(lblEstoque);
		
		textEstoque = new JTextField();
		textEstoque.setBounds(36, 145, 78, 20);
		panel.add(textEstoque);
		textEstoque.setColumns(10);
		
		JLabel lblPrecoV = new JLabel("Preço à vista:");
		lblPrecoV.setBounds(162, 120, 80, 14);
		panel.add(lblPrecoV);
		
		textPvista = new JTextField();
		textPvista.setBounds(162, 145, 102, 20);
		panel.add(textPvista);
		textPvista.setColumns(10);
		
		JLabel lblPrecoP = new JLabel("Preço a prazo:");
		lblPrecoP.setBounds(278, 120, 98, 14);
		panel.add(lblPrecoP);
		
		textPprazo = new JTextField();
		textPprazo.setBounds(274, 145, 102, 20);
		panel.add(textPprazo);
		textPprazo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 252, 846, 406);
		panel.add(scrollPane);
		
		tableProdutos = new JTable();
		tableProdutos.setToolTipText("");
		tableProdutos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "Quantidade", "Pre\u00E7o \u00E0 vista", "Pre\u00E7o a prazo", "Especifica\u00E7\u00F5es"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(55);
		tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(68);
		tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(94);
		tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(247);
		scrollPane.setViewportView(tableProdutos);
		
		JLabel lblEspecificacoes = new JLabel("Especificações:");
		lblEspecificacoes.setBounds(398, 120, 158, 14);
		panel.add(lblEspecificacoes);
		
		textEspecificacoes = new JTextField();
		textEspecificacoes.setBounds(398, 145, 484, 20);
		panel.add(textEspecificacoes);
		textEspecificacoes.setColumns(10);
		
		textPesquisa = new JTextField();
		textPesquisa.setBounds(108, 221, 646, 20);
		panel.add(textPesquisa);
		textPesquisa.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPesquisar.setBounds(36, 221, 102, 17);
		panel.add(lblPesquisar);
		
		JButton searchButton = new JButton("Pesquisar");
		searchButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/lupa.png")));
		searchButton.setBounds(764, 220, 118, 23);
		panel.add(searchButton);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/cancelar.png")));
		cancelButton.setBounds(36, 187, 118, 23);
		panel.add(cancelButton);
		
		JButton newButton = new JButton("Novo");
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/novo.png")));
		newButton.setBounds(175, 187, 89, 23);
		panel.add(newButton);
		
		JButton alterButton = new JButton("Alterar");
		alterButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/alterar.png")));
		alterButton.setBounds(280, 187, 96, 23);
		panel.add(alterButton);
		
		JButton deleteButton = new JButton("Excluir");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButtonActionPerformed(e);
			}
		});
		deleteButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/excluir.png")));
		deleteButton.setBounds(398, 187, 124, 23);
		
		panel.add(deleteButton);
		
		JButton salvarButton =  new JButton("Salvar");
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarButtonActionPerformed(e);
			}
		});
		salvarButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/salvar.png")));
		salvarButton.setBounds(780, 669, 102, 23);
		
		panel.add(salvarButton);
		
		carregarProdutosTabela();
	}

	
}
