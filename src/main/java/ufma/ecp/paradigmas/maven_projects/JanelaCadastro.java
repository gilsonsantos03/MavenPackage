package ufma.ecp.paradigmas.maven_projects;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCadastro extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNome, lblEmail, lblTelefone;
	private JTextField txtNome, txtEmail, txtTelefone;
	private JButton btnCadastrar, btnLimpar, btnSair;
	private JPanel jpnNome, jpnEmail, jpnTelefone, jpnBotoes;
	
	private void btnSairActionPerformed() {
		int confirm = JOptionPane.showConfirmDialog(this,
			"Deseja realemente fechar a aplicação?",
			"Sair - Contirmação",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			System.exit(1);
		}	
	}
	
	private void btnCadastrarActionPerformed() {
		JOptionPane.showMessageDialog(null, 
				"Cadastro realizado com sucesso!",
				"Cadastro de contatos",
				JOptionPane.PLAIN_MESSAGE
				);
	}
	
	public JanelaCadastro() {
		//fazendo a configuracao da janela
		setTitle("Cadastro de Contatos");
		setSize(300, 200);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //centraliza o JFrame
		
		//instanciando ...
		lblNome = new JLabel("Nome: ");
		txtNome = new JTextField(15);
		lblEmail = new JLabel("Email: ");
		txtEmail = new JTextField(15);
		lblTelefone = new JLabel("Telefone: ");
		txtTelefone = new JTextField(15);
		btnCadastrar = new JButton("Cadastro");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		jpnNome = new JPanel();
		jpnNome.setLayout(new FlowLayout());
		jpnEmail = new JPanel();
		jpnEmail.setLayout(new FlowLayout());
		jpnTelefone = new JPanel();
		jpnTelefone.setLayout(new FlowLayout());
		jpnBotoes = new JPanel();
		jpnBotoes.setLayout(new FlowLayout());
		
		//adicionando os componentes
		jpnNome.add(lblNome);
		jpnNome.add(txtNome);
		jpnEmail.add(lblEmail);
		jpnEmail.add(txtEmail);
		jpnTelefone.add(lblTelefone);
		jpnTelefone.add(txtTelefone);
		jpnBotoes.add(btnCadastrar);
		jpnBotoes.add(btnLimpar);
		jpnBotoes.add(btnSair);
		
		add(jpnNome);
		add(jpnEmail);
		add(jpnTelefone);
		add(jpnBotoes);
		
		//evento para sair
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				btnSairActionPerformed();
			}
		});
		
		//evento para limpar
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				txtNome.setText("");
				txtEmail.setText("");
				txtTelefone.setText("");
			}
		});
		
		//evento para cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ContatoDAO contatinho = new ContatoDAO();
				contatinho.adicionaContato(new Contato(txtNome.getText(), txtEmail.getText(), txtTelefone.getText()));
				btnCadastrarActionPerformed();
			}
		});
	}	
}
