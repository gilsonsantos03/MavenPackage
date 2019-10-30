package ufma.ecp.paradigmas.maven_projects;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
	private JLabel lblNome, lblEmail, lblTelefone, lblGrupo, lblAtivo;
	private JTextField txtNome, txtEmail, txtTelefone, txtGrupo, txtAtivo;
	private JButton btnCadastrar, btnLimpar, btnSair, btnVisu;
	private JPanel jpnNome, jpnEmail, jpnTelefone, jpnGrupo, jpnAtivo, jpnBotoes;
	
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
		setSize(1200, 400);
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
		
		lblGrupo = new JLabel("Grupo: ");
		txtGrupo = new JTextField(15);
		
		lblAtivo = new JLabel("Ativo: ");
		txtAtivo = new JTextField(15);
			
		btnCadastrar = new JButton("Cadastro");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		btnVisu = new JButton("Visualizar Registros");
		
		jpnNome = new JPanel();
		jpnNome.setLayout(new FlowLayout());
		jpnEmail = new JPanel();
		jpnEmail.setLayout(new FlowLayout());
		jpnTelefone = new JPanel();
		jpnTelefone.setLayout(new FlowLayout());
		jpnGrupo = new JPanel();
		jpnGrupo.setLayout(new FlowLayout());
		jpnAtivo = new JPanel();
		jpnAtivo.setLayout(new FlowLayout());

		jpnBotoes = new JPanel();
		jpnBotoes.setLayout(new FlowLayout());
		
		//adicionando os componentes
		jpnNome.add(lblNome);
		jpnNome.add(txtNome);
		jpnEmail.add(lblEmail);
		jpnEmail.add(txtEmail);
		jpnTelefone.add(lblTelefone);
		jpnTelefone.add(txtTelefone);
		jpnGrupo.add(lblGrupo);
		jpnGrupo.add(txtGrupo);
		jpnAtivo.add(lblAtivo);
		jpnAtivo.add(txtAtivo);
		jpnBotoes.add(btnCadastrar);
		jpnBotoes.add(btnLimpar);
		jpnBotoes.add(btnSair);
		jpnBotoes.add(btnVisu);
		
		add(jpnNome);
		add(jpnEmail);
		add(jpnTelefone);
		add(jpnGrupo);
		add(jpnAtivo);
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
				txtGrupo.setText("");
				txtAtivo.setText("");
			}
		});
		
		//evento para cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ContatoDAO contatinho = new ContatoDAO();
				contatinho.adicionaContato(new Contato(txtNome.getText(), txtEmail.getText(), txtTelefone.getText()
						, txtGrupo.getText(), Boolean.getBoolean(txtAtivo.getText())));
				btnCadastrarActionPerformed();
			}
		});
		
		//evento para visualizar registros
		btnVisu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					FrameTable f = new FrameTable();
					f.setVisible(true);
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (HeadlessException e) {
					e.printStackTrace();
				}
			}
		});
	}	
}
