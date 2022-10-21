package conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class Crud extends JFrame {

	private JPanel contentPane;
	private JTextField txtcpf;
	private JTextField txtCliente;
	private JTextField txtProd;
	private JTextField txtTotal;
	private JTextField txtPreco;
	private JTextField txtAtendente;
	private JTextField txtQtd;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crud frame = new Crud();
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
	public Crud() {
		setResizable(false);
		setTitle("Compras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Yussef\\OneDrive\\Imagens\\multiple-users.png"));
		lblNewLabel.setBounds(10, 11, 178, 200);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Cliente");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1.setBounds(189, 11, 265, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome completo:");
		lblNewLabel_2.setBounds(198, 108, 90, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setBounds(221, 157, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtcpf = new JTextField();
		txtcpf.setFont(new Font("Arial", Font.PLAIN, 12));
		txtcpf.setBounds(288, 154, 114, 20);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCliente.setBounds(288, 110, 235, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(51, 204, 153));
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 222, 647, 24);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Yussef\\OneDrive\\Imagens\\carrinhodeCompras.png"));
		lblNewLabel_4.setBounds(42, 347, 137, 119);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cadastro de  Produtos");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_5.setBounds(164, 274, 305, 26);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nome do Produto:");
		lblNewLabel_6.setBounds(198, 330, 90, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Quantidade:");
		lblNewLabel_7.setBounds(198, 417, 90, 24);
		contentPane.add(lblNewLabel_7);
		
		txtProd = new JTextField();
		txtProd.setFont(new Font("Arial", Font.PLAIN, 12));
		txtProd.setBounds(326, 332, 220, 20);
		contentPane.add(txtProd);
		txtProd.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Valor Total:");
		lblNewLabel_8.setBounds(198, 466, 90, 14);
		contentPane.add(lblNewLabel_8);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTotal.setBounds(326, 463, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Pre\u00E7o Unit\u00E1rio:");
		lblNewLabel_9.setBounds(198, 377, 90, 14);
		contentPane.add(lblNewLabel_9);
		
		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPreco.setBounds(326, 374, 86, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(new Color(51, 204, 153));
		panel_1.setBounds(0, 543, 647, 24);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_10 = new JLabel("Nome do Atendente:");
		lblNewLabel_10.setBounds(198, 502, 114, 14);
		contentPane.add(lblNewLabel_10);
		
		txtAtendente = new JTextField();
		txtAtendente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAtendente.setBounds(326, 494, 220, 20);
		contentPane.add(txtAtendente);
		txtAtendente.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection cadastro = conect.createConnectionToMySQL();
					String sql = "insert into Produtos (nomeAtendente, nomeProduto, precoUnitario, qtdProduto, valorTotal, cliente, cpf) value (?,?,?,?,?,?,?)";
					PreparedStatement stmt = cadastro.prepareStatement(sql);
					stmt.setString(1, txtAtendente.getText());
					stmt.setString(2, txtProd.getText());
					stmt.setString(3, txtPreco.getText());
					stmt.setString(4, txtQtd.getText());
					stmt.setString(5, txtTotal.getText());
					stmt.setString(6, txtCliente.getText());
					stmt.setString(7, txtcpf.getText());
			
					stmt.execute();
					stmt.close();
					cadastro.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Cadastrado   com sucesso!");
				Limpar();
				Limp();		
			}
		});
		btnNewButton_2.setBounds(10, 591, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("Alterar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection alterar = conect.createConnectionToMySQL();
					String sql = "update produtos set nomeAtendente=?,nomeProduto=?,precoUnitario=?,qtdProduto=?,valorTotal=?,cliente=?,cpf=? where id=?";
					PreparedStatement stmt = alterar.prepareStatement(sql);
					stmt.setString(1, txtAtendente.getText());
					stmt.setString(2, txtProd.getText());
					stmt.setString(3, txtPreco.getText());
					stmt.setString(4, txtQtd.getText());
					stmt.setString(5, txtTotal.getText());
					stmt.setString(6, txtCliente.getText());
					stmt.setString(7, txtcpf.getText());
					stmt.setString(8, txtId.getText());
				stmt.execute();	
				stmt.close();
				alterar.close();
				JOptionPane.showMessageDialog(null, "Editado com sucesso!");
				Limpar();
				Limp();
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setBackground(new Color(0, 0, 0));
		btnNewButton_6.setBounds(117, 591, 97, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Deletar");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conlogin = conect.createConnectionToMySQL();
					String sql = "delete from produtos where nomeAtendente=?";
					PreparedStatement stmt = conlogin.prepareStatement(sql);
					stmt.setString(1, txtAtendente.getText());
					stmt.execute();
					stmt.close();
					conlogin.close();
						JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
						Limpar();
						Limp();
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			}

			
		});
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(new Color(0, 0, 0));
		btnNewButton_7.setBounds(331, 591, 97, 23);
		contentPane.add(btnNewButton_7);
		
		txtQtd = new JTextField();
		txtQtd.setFont(new Font("Arial", Font.PLAIN, 12));
		txtQtd.setBounds(326, 419, 86, 20);
		contentPane.add(txtQtd);
		txtQtd.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("ID:");
		lblNewLabel_11.setBounds(221, 65, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Arial", Font.PLAIN, 12));
		txtId.setEnabled(false);
		txtId.setBounds(288, 62, 58, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(438, 591, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_7_1 = new JButton("Pesquisar");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection pesquisar = conect.createConnectionToMySQL();
					String sql = "select *from produtos where nomeAtendente=?";
					PreparedStatement stmt = pesquisar.prepareStatement(sql);
					stmt.setString(1, txtAtendente.getText());
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						txtId.setText(rs.getString("id"));
						txtCliente.setText(rs.getString("cliente"));
						txtcpf.setText(rs.getString("cpf"));
						txtProd.setText(rs.getString("nomeProduto"));
						txtPreco.setText(rs.getString("precoUnitario"));
						txtQtd.setText(rs.getString("qtdProduto"));
						txtTotal.setText(rs.getString("valorTotal"));
						txtAtendente.setText(rs.getString("nomeAtendente"));
					}
					
				rs.close();
				pesquisar.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7_1.setForeground(Color.WHITE);
		btnNewButton_7_1.setBackground(new Color(0, 0, 0));
		btnNewButton_7_1.setBounds(224, 591, 97, 23);
		contentPane.add(btnNewButton_7_1);
		
		JButton btnNewButton_1 = new JButton("Tela de In\u00EDcio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login_tela().setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(545, 591, 92, 23);
		contentPane.add(btnNewButton_1);
		
	}
		private void Limpar() {
			txtCliente.setText("");
			txtcpf.setText("");
			txtCliente.requestFocus();
		}		
			
			private void Limp() {
				txtProd.setText("");
				txtPreco.setText("");
				txtQtd.setText("");
				txtTotal.setText("");
				txtAtendente.setText("");
				txtProd.requestFocus();
		
		
			}
}

