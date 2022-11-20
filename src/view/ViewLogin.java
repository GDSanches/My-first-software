 package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;
	
			
	public ViewLogin() {
		setResizable(false);
		
		setTitle("AGRO SANCHES");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelUsuario = new JLabel("Usuário");
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		labelUsuario.setBounds(123, 137, 62, 14);
		contentPane.add(labelUsuario);
		
		textUser = new JTextField();
		textUser.setBounds(123, 162, 242, 34);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 232, 242, 34);
		contentPane.add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 488, 76);
		
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Login de Acesso");
		labelTitulo.setBounds(112, 11, 266, 54);
		panel.add(labelTitulo);
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBackground(new Color(255, 255, 255));
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 73, 488, 328);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelExem = new JLabel("Entre com suas credenciais");
		labelExem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelExem.setHorizontalAlignment(SwingConstants.CENTER);
		labelExem.setBounds(112, 11, 268, 33);
		
		panel_1.add(labelExem);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(125, 135, 67, 14);
		panel_1.add(labelSenha);
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelSenha.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton outButton = new JButton("Sair");
		outButton.setBackground(new Color(217, 81, 51));
		outButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		outButton.setForeground(Color.WHITE);
		outButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		outButton.setFocusPainted(false);
		outButton.setBorderPainted(false);
		outButton.setBounds(125, 270, 242, 34);
		panel_1.add(outButton);
		
		JButton loginButton = new JButton("Entrar");
		loginButton.setBounds(125, 225, 242, 34);
		panel_1.add(loginButton);
		loginButton.setBackground(new Color(58, 65, 84));
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
	}
}
