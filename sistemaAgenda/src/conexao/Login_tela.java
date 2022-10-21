package conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.SystemColor;



public class Login_tela extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_tela frame = new Login_tela();
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
	public Login_tela() {
		setResizable(false);
		setTitle("Tela de ADM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 677);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 17));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(67, 275, 247, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 17));
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(67, 361, 247, 32);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Vendas");
		btnNewButton.setBackground(new Color(102, 51, 51));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conlogin = conect.createConnectionToMySQL();
					String sql = "select *from administrador where login=? and senha=?";
					PreparedStatement stmt = conlogin.prepareStatement(sql);
					stmt.setString(1, textField.getText());
					stmt.setString(2, new String(passwordField.getPassword()));
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Acesso Liberado!");
						
						new Vendas().setVisible(true);
										
					}else {
						JOptionPane.showMessageDialog(null, "Acesso negado, Você não poossui cadastro em nosso sistema!");

					}
				stmt.close();
				conlogin.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
				
			
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 20));
		btnNewButton.setBounds(43, 425, 292, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 20));
		btnNewButton_1.setBounds(43, 532, 292, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.setBackground(new Color(255, 153, 0));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Calibri", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		btnNewButton_2.setBounds(43, 585, 292, 42);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Atendentes");
		btnNewButton_3.setBackground(new Color(102, 51, 51));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conlogin = conect.createConnectionToMySQL();
					String sql = "select *from administrador where login=? and senha=?";
					PreparedStatement stmt = conlogin.prepareStatement(sql);
					stmt.setString(1, textField.getText());
					stmt.setString(2, new String(passwordField.getPassword()));
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Acesso Liberado!");
						
						new CrudAcesso1().setVisible(true);
										
					}else {
						JOptionPane.showMessageDialog(null, "Acesso negado, Você não poossui cadastro em nosso sistema!");

					}
				stmt.close();
				conlogin.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				
			
				}	
			}
		});
		btnNewButton_3.setFont(new Font("Calibri", Font.BOLD, 20));
		btnNewButton_3.setBounds(43, 478, 292, 43);
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 153));
		panel.setBounds(0, 0, 371, 78);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("ADMIN");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 58));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(134, 331, 84, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(134, 240, 84, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Yussef\\OneDrive\\Imagens\\ADM.png"));
		lblNewLabel_3.setBounds(67, 84, 235, 132);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
