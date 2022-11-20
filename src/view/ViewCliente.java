package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ViewCliente extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField textCod;
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textCidade;
	private JTextField textCep;
	private JTextField textFone;
	private JTextField textCpfCnpj;
	private JTextField textIE;
	private JTextField textNFazenda;
	private JTable jtCliente;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCliente frame = new ViewCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ViewCliente() {
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1155, 755);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1139, 716);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel codCliente = new JLabel("Código:");
		codCliente.setBounds(17, 11, 79, 24);
		panel.add(codCliente);
		
		textCod = new JTextField();
		textCod.setBounds(17, 37, 79, 20);
		panel.add(textCod);
		textCod.setColumns(10);
		
		JLabel lblNome = new JLabel(" Nome:");
		lblNome.setBounds(17, 99, 46, 14);
		panel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(17, 124, 536, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(17, 155, 86, 24);
		panel.add(lblEndereco);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(14, 190, 372, 20);
		panel.add(textEndereco);
		textEndereco.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(410, 165, 46, 14);
		panel.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(410, 190, 142, 20);
		panel.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("UF:");
		lblNewLabel_4.setBounds(574, 165, 46, 14);
		panel.add(lblNewLabel_4);
		
		JComboBox comboBoxEstados = new JComboBox();
		comboBoxEstados.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL ", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBoxEstados.setToolTipText("");
		comboBoxEstados.setBounds(574, 189, 60, 22);
		panel.add(comboBoxEstados);
		
		textCep = new JTextField();
		textCep.setBounds(705, 190, 141, 20);
		panel.add(textCep);
		textCep.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(705, 165, 46, 14);
		panel.add(lblCep);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(886, 165, 46, 14);
		panel.add(lblTelefone);
		
		textFone = new JTextField();
		textFone.setBounds(888, 190, 201, 20);
		panel.add(textFone);
		textFone.setColumns(10);
		
		JLabel lblCpfCnpj = new JLabel("CPF/CNPJ:");
		lblCpfCnpj.setBounds(17, 225, 72, 36);
		panel.add(lblCpfCnpj);
		
		textCpfCnpj = new JTextField();
		textCpfCnpj.setBounds(17, 259, 369, 20);
		panel.add(textCpfCnpj);
		textCpfCnpj.setColumns(10);
		
		JLabel lblIe = new JLabel("Inscrição Estadual:");
		lblIe.setBounds(410, 236, 107, 14);
		panel.add(lblIe);
		
		textIE = new JTextField();
		textIE.setBounds(410, 259, 224, 20);
		panel.add(textIE);
		textIE.setColumns(10);
		
		JLabel lblNfazenda = new JLabel("Nome da Fazenda:");
		lblNfazenda.setBounds(705, 236, 102, 14);
		panel.add(lblNfazenda);
		
		textNFazenda = new JTextField();
		textNFazenda.setBounds(709, 259, 380, 20);
		panel.add(textNFazenda);
		textNFazenda.setColumns(10);
		
		JButton jbSalvar = new JButton("Salvar");
		jbSalvar.setIcon(new ImageIcon(ViewCliente.class.getResource("/app/imagens/salvar.png")));
		jbSalvar.setBounds(985, 305, 104, 23);
		panel.add(jbSalvar);
		
		JButton jbAlterar = new JButton("Alterar");
		jbAlterar.setIcon(new ImageIcon(ViewCliente.class.getResource("/app/imagens/alterar.png")));
		jbAlterar.setBounds(845, 305, 130, 23);
		panel.add(jbAlterar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 339, 1112, 343);
		panel.add(scrollPane);
		
		jtCliente = new JTable();
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "CPF/CNPJ", "Contato", "Endere\u00E7o", "CEP", "Nome da Fazenda"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		jtCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtCliente.getColumnModel().getColumn(0).setMinWidth(30);
		jtCliente.getColumnModel().getColumn(1).setPreferredWidth(133);
		jtCliente.getColumnModel().getColumn(4).setPreferredWidth(243);
		jtCliente.getColumnModel().getColumn(6).setPreferredWidth(160);
		scrollPane.setViewportView(jtCliente);
		
		JButton btnNovoCli = new JButton("Novo");
		btnNovoCli.setIcon(new ImageIcon(ViewCliente.class.getResource("/app/imagens/novo.png")));
		btnNovoCli.setBounds(17, 305, 89, 23);
		panel.add(btnNovoCli);
		
		JButton jbCancelar = new JButton("Cancelar");
		jbCancelar.setIcon(new ImageIcon(ViewCliente.class.getResource("/app/imagens/cancelar.png")));
		jbCancelar.setBounds(116, 305, 121, 23);
		panel.add(jbCancelar);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(563, 99, 46, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(563, 124, 526, 20);
		panel.add(textField);
		textField.setColumns(10);
	}


}
