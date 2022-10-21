package conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class CrudAcesso1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtLogin;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtIdade;
	private JTextField txtSenha;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudAcesso1 frame = new CrudAcesso1();
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
	public CrudAcesso1() {
		setResizable(false);
		setTitle("Cadastro de Atendente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 794);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNome.setBounds(468, 135, 297, 31);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBackground(new Color(102, 51, 51));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conlogin = conect.createConnectionToMySQL();
					String sql = "insert into atendente (atendenteNome, atendenteLogin, atendenteSenha, atendenteIdade, atendenteFone, atendenteEmail) value (?,?,?,?,?,?)";
					PreparedStatement stmt = conlogin.prepareStatement(sql);
					stmt.setString(1, txtNome.getText());
					stmt.setString(2, txtLogin.getText());
					stmt.setString(3, txtSenha.getText());
					stmt.setString(4, txtIdade.getText());
					stmt.setString(5, txtFone.getText());
					stmt.setString(6, txtEmail.getText());
			
					stmt.execute();
					stmt.close();
					conlogin.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Cadastrado   com sucesso!");
				Limpar();
				}
			
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton.setBounds(617, 541, 124, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nome do Atendente:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(302, 148, 165, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(378, 201, 89, 24);
		contentPane.add(lblNewLabel_1);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLogin.setBounds(468, 194, 170, 31);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Idade:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(378, 316, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(367, 373, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		txtFone = new JTextField();
		txtFone.setFont(new Font("Arial", Font.PLAIN, 15));
		txtFone.setBounds(468, 367, 170, 31);
		contentPane.add(txtFone);
		txtFone.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Deletar");
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conlogin = conect.createConnectionToMySQL();
					String sql = "delete from atendente where atendentelogin=?";
					PreparedStatement stmt = conlogin.prepareStatement(sql);
					stmt.setString(1, txtLogin.getText());
					stmt.execute();
					stmt.close();
					conlogin.close();
						JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
						Limpar();
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton_1.setBounds(349, 618, 124, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.setBackground(new Color(255, 153, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton_2.setBounds(617, 618, 124, 39);
		contentPane.add(btnNewButton_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(468, 426, 297, 31);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(367, 431, 64, 14);
		contentPane.add(lblNewLabel_6);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(468, 310, 86, 31);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Senha:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(378, 259, 65, 18);
		contentPane.add(lblNewLabel_5);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(468, 257, 170, 27);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Editar");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(102, 51, 51));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection Editar = conect.createConnectionToMySQL();
					String sql = "update atendente set atendenteNome=?,atendenteLogin=?,atendenteSenha=?,atendenteIdade=?,atendenteFone=?,atendenteEmail=? where idatendente=?";
					PreparedStatement stmt = Editar.prepareStatement(sql);
					stmt.setString(1, txtNome.getText());
					stmt.setString(2, txtLogin.getText());
					stmt.setString(3, txtSenha.getText());
					stmt.setString(4, txtIdade.getText());
					stmt.setString(5, txtFone.getText());
					stmt.setString(6, txtEmail.getText());
					stmt.setString(7, txtId.getText());
				stmt.execute();	
				stmt.close();
				Editar.close();
				JOptionPane.showMessageDialog(null, "Editado com sucesso!");
				Limpar();
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton_4.setBounds(483, 541, 124, 39);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Pesquisar");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(102, 51, 51));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection pesquisar = conect.createConnectionToMySQL();
					String sql = "select *from atendente where atendenteLogin=?";
					PreparedStatement stmt = pesquisar.prepareStatement(sql);
					stmt.setString(1, txtLogin.getText());
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						txtId.setText(rs.getString("idatendente"));
						txtNome.setText(rs.getString("atendenteNome"));
						txtLogin.setText(rs.getString("atendenteLogin"));
						txtSenha.setText(rs.getString("atendenteSenha"));
						txtIdade.setText(rs.getString("atendenteIdade"));
						txtFone.setText(rs.getString("atendenteFone"));
						txtEmail.setText(rs.getString("atendenteEmail"));
					}
					
				rs.close();
				pesquisar.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}


		});
		btnNewButton_5.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton_5.setBounds(349, 541, 124, 39);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_7 = new JLabel("ID:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(378, 103, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		txtId = new JTextField();
		txtId.setForeground(Color.BLACK);
		txtId.setFont(new Font("Arial", Font.BOLD, 20));
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setBackground(Color.WHITE);
		txtId.setBounds(469, 86, 65, 31);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Login");
		btnNewButton_3.setBackground(new Color(165, 42, 42));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginAtendente().setVisible(true);
				
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.setBounds(349, 694, 392, 39);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Limpar");
		btnNewButton_6.setBackground(new Color(255, 153, 0));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton_6.setBounds(483, 618, 124, 39);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Yussef\\OneDrive\\Imagens\\multiple.png"));
		lblNewLabel_8.setBounds(21, 169, 270, 256);
		contentPane.add(lblNewLabel_8);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 153));
		panel.setBounds(0, 0, 835, 75);
		contentPane.add(panel);
		
		JLabel lblNewLabel_9 = new JLabel("Cadastro de Atendente");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 45));
		panel.add(lblNewLabel_9);
	}
	private void sair() {
		System.exit(0);
	}
	
	private void Limpar() {
		txtNome.setText("");
		txtLogin.setText("");
		txtSenha.setText("");
		txtIdade.setText("");
		txtFone.setText("");
		txtEmail.setText("");
		txtNome.requestFocus();

	}
}	