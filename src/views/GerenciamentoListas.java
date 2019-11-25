package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import bd.core.MeuResultSet;
import bd.daos.Listas;
import bd.daos.Materias;
import bd.dbos.Aluno;
import bd.dbos.Lista;
import bd.dbos.Materia;
import bd.dbos.Monitor;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTable;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class GerenciamentoListas extends JFrame {

	private JPanel contentPane;
	private JTextField txtDiretorio;
	private JTextField txtNomeLista;
	private JComboBox<String> cbxListas;
	private ButtonGroup bg = new ButtonGroup();
	
	private Aluno aluno;
	private Monitor monitor;
	private Materia materia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoListas frame = new GerenciamentoListas(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GerenciamentoListas(Aluno aluno, Monitor monitor) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 896, 506);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setAluno(aluno);
		setMonitor(monitor);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 153, 204));
		
		JLabel label = new JLabel("Gerenciamento de Listas");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(label);
		
		JPanel pnlContainer = new JPanel();
		pnlContainer.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
				.addComponent(pnlContainer, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlContainer, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
		);
		
		txtDiretorio = new JTextField();
		txtDiretorio.setEnabled(false);
		txtDiretorio.setColumns(10);
		
		JButton btnArquivo = new JButton("Arquivo");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		
		JLabel lblTable = new JLabel("Selecione a mat\u00E9ria");
		lblTable.setForeground(Color.BLACK);
		lblTable.setFont(new Font("Arial", Font.BOLD, 17));
		panel_4.add(lblTable);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		
		cbxListas = new JComboBox<String>();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(307)
					.addComponent(cbxListas, 0, 263, Short.MAX_VALUE)
					.addGap(310))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(20)
					.addComponent(cbxListas)
					.addGap(123))
		);
		panel_5.setLayout(gl_panel_5);
		
		txtNomeLista = new JTextField();
		txtNomeLista.setColumns(10);
		
		JButton btnRealizar = new JButton("Adicionar");
		
		JLabel lblDiretorio = new JLabel("Selecione o arquivo");
		lblDiretorio.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GroupLayout gl_pnlContainer = new GroupLayout(pnlContainer);
		gl_pnlContainer.setHorizontalGroup(
			gl_pnlContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContainer.createSequentialGroup()
					.addGap(326)
					.addComponent(txtNomeLista, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addGap(321))
				.addGroup(gl_pnlContainer.createSequentialGroup()
					.addGap(401)
					.addComponent(btnRealizar, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(398))
				.addGroup(Alignment.TRAILING, gl_pnlContainer.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_pnlContainer.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlContainer.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)))
				.addGroup(Alignment.TRAILING, gl_pnlContainer.createSequentialGroup()
					.addGap(249)
					.addGroup(gl_pnlContainer.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDiretorio, GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
						.addGroup(gl_pnlContainer.createSequentialGroup()
							.addComponent(txtDiretorio, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btnArquivo, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addGap(271)))
					.addContainerGap())
		);
		gl_pnlContainer.setVerticalGroup(
			gl_pnlContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContainer.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDiretorio, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addGroup(gl_pnlContainer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContainer.createSequentialGroup()
							.addGap(1)
							.addComponent(txtDiretorio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnArquivo))
					.addGap(35)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNomeLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
					.addComponent(btnRealizar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNomeLista = new JLabel("Digite o nome da lista:");
		panel_2.add(lblNomeLista);
		pnlContainer.setLayout(gl_pnlContainer);
		panel.setLayout(gl_panel);
		
		carregarCBX();
		btnArquivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//OpenFileDialog dlgAbrir = new OpenFileDialog();
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
				try {
					fileChooser.setDialogTitle("Selecione a Lista");
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileChooser.setFileFilter(filter);
					int retorno = fileChooser.showOpenDialog(null);
					
					if (retorno == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						txtDiretorio.setText(file.getPath());
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btnRealizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!txtDiretorio.getText().equals("")) {
					if(!cbxListas.getSelectedItem().equals("")) {
						if (!txtNomeLista.getText().equals("")) {
							System.out.println("C1");
							incluirLista(txtDiretorio.getText(), txtNomeLista.getText());
						}
						else {
							JOptionPane.showMessageDialog(null, "Nome da lista não informado");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Materia não selecionada!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Arquivo não selecionado");
				}
			}
		});
	}
	
	public void incluirLista(String diretorio, String nome) {
		try {
			System.out.println("C2");			
			Lista lista = new Lista(0, this.materia.getCodigo(), diretorio, nome);
			System.out.println(lista);
			System.out.println("C3");
			Listas.incluir(lista);
		} 
		catch (Exception e) 
		{ } // sei que não vai dar erro
	}
	
	public void carregarCBX() {
		try {
			Materia materia = Materias.getMateria(this.monitor.getCodigo());
			setMateria(materia);
			cbxListas.removeAllItems();
			cbxListas.addItem("");
			cbxListas.addItem(materia.getNome());
		}
		catch (Exception erro) {
			erro.printStackTrace();
		}
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}
