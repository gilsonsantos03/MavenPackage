package ufma.ecp.paradigmas.docentesigaa;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameCadastro extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel lblProfessor, lblCadeira, lblId;
	private JTextField txtProfessor, txtCadeira, txtId;
	private JButton btnCadastrar, btnLimpar, btnSair;
	private JPanel jpnProfessor, jpnCadeira, jpnId, jpnBotoes;
	
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
				"Cadastro de Docentes",
				JOptionPane.PLAIN_MESSAGE
				);
	}
	
	public FrameCadastro() {
		//fazendo a configuracao da janela
		setTitle("Cadastro de Docentes");
		setSize(400, 300);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //centraliza o JFrame
		
		//instanciando ...
		lblProfessor = new JLabel("Prof: ");
		txtProfessor = new JTextField(15);
		lblCadeira = new JLabel("Cadeira: ");
		txtCadeira = new JTextField(15);
		lblId = new JLabel("Id: ");
		txtId = new JTextField(15);
		btnCadastrar = new JButton("Cadastro");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		jpnProfessor = new JPanel();
		jpnProfessor.setLayout(new FlowLayout());
		jpnCadeira = new JPanel();
		jpnCadeira.setLayout(new FlowLayout());
		jpnId = new JPanel();
		jpnId.setLayout(new FlowLayout());
		jpnBotoes = new JPanel();
		jpnBotoes.setLayout(new FlowLayout());
		
		//adicionando os componentes
		jpnProfessor.add(lblProfessor);
		jpnProfessor.add(txtProfessor);
		jpnCadeira.add(lblCadeira);
		jpnCadeira.add(lblCadeira);
		jpnId.add(lblId);
		jpnId.add(txtId);
		jpnBotoes.add(btnCadastrar);
		jpnBotoes.add(btnLimpar);
		jpnBotoes.add(btnSair);
		
		add(jpnProfessor);
		add(jpnCadeira);
		add(jpnId);
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
				txtProfessor.setText("");
				txtCadeira.setText("");
				txtId.setText("");
			}
		});
		
		//evento para cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				DocenteDAO docente = new DocenteDAO();
				docente.adicionaDocente(new Docente(txtProfessor.getText(), txtCadeira.getText(), Integer.parseInt(txtId.getText())));
				btnCadastrarActionPerformed();
			}
		});
	}	
}
