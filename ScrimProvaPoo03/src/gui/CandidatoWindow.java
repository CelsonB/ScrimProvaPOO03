package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Candidato;
import service.CandidatoService;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CandidatoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private CandidatoService candidatoService;
	private JTextField txtFieldNome;
	private JTextField textFieldSenha;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */


	public CandidatoWindow() {
		initComponents();
		this.candidatoService = new CandidatoService ();
		try {
			BuscarCandidatos();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
		
		
	}
	public void BuscarCandidatos() throws SQLException, IOException {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.fireTableDataChanged();
		modelo.setRowCount(0);
		this.candidatoService.buscarCandidatos();
		List<Candidato> candidatos = this.candidatoService.listarCandidatos();
		
		for(Candidato cand : candidatos) {
			System.out.println(cand.getNome());
			modelo.addRow(new Object[] {
				cand.getNome(),
				cand.getEmail(),
				cand.getSenha()
			});
		}
	}
	
	public void cadastrarCandidato() {
		this.candidatoService = new CandidatoService ();
		try {
			candidatoService.cadastrarCandidato(txtFieldNome.getText(), textFieldSenha.getText(),textFieldEmail.getText());
			BuscarCandidatos();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 220, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 414, 239);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome" ,"Email", "Senha", 
			}
		));
		
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(22, 24, 46, 14);
		contentPane.add(labelNome);
		
		JLabel LabelSenha = new JLabel("Senha");
		LabelSenha.setBounds(22, 55, 46, 14);
		contentPane.add(LabelSenha);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(22, 93, 46, 14);
		contentPane.add(labelEmail);
		
		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(95, 21, 86, 20);
		contentPane.add(txtFieldNome);
		txtFieldNome.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(95, 52, 86, 20);
		contentPane.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(95, 90, 86, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton BotaoCadastrar = new JButton("Cadastrar");
		BotaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cadastrarCandidato();
				
			}
		});
		BotaoCadastrar.setBounds(10, 186, 89, 23);
		contentPane.add(BotaoCadastrar);
	}
}
