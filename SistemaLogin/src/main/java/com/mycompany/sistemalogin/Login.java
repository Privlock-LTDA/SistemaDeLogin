/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemalogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class Login extends JFrame {
    private JTextField txtMatricula;
    private JPasswordField txtSenha;
    private JButton btnLogin;

    private final HashSet<String> matriculasUsadas;
    private final String adminMatricula = "admin";
    private final String adminSenha = "1234";

    public Login() {
        matriculasUsadas = new HashSet<>();

        setTitle("Login - Urna Eletrônica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  // Impede o fechamento padrão
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblMatricula = new JLabel("Matrícula:");
        JLabel lblSenha = new JLabel("Senha (Adm):");

        txtMatricula = new JTextField();
        txtMatricula.setPreferredSize(new Dimension(250, 30));

        txtSenha = new JPasswordField();
        txtSenha.setPreferredSize(new Dimension(250, 30));

        btnLogin = new JButton("Login");

        btnLogin.setBackground(new Color(192, 192, 192));
        btnLogin.setPreferredSize(new Dimension(150, 40));
        btnLogin.setFocusPainted(false);

        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(169, 169, 169));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(new Color(192, 192, 192));
            }
        });

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblMatricula, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtMatricula, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblSenha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JPanel painelVazio = new JPanel();
        painelVazio.setBackground(Color.WHITE);  
        add(painelVazio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(btnLogin, gbc);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = txtMatricula.getText();
                char[] senha = txtSenha.getPassword();

                if (fazerLogin(matricula, senha)) {
                    if (matricula.equals(adminMatricula)) {
                        new TelaAdm().setVisible(true);  
                    } else {
                        JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + matricula + "!");
                    }
                    dispose();  
                } else {
                    JOptionPane.showMessageDialog(null, "Matrícula ou senha inválidos.");
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resposta = JOptionPane.showConfirmDialog(
                        null, 
                        "Você tem certeza que deseja sair?", 
                        "Confirmar", 
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    System.exit(0); // Fecha a aplicação
                }
            }
        });
    }

    private boolean fazerLogin(String matricula, char[] senha) {
        if (!matriculasUsadas.contains(matricula)) {
            matriculasUsadas.add(matricula);  
        }

        if (matricula.equals(adminMatricula) && new String(senha).equals(adminSenha)) {
            return true;  
        }

        return matriculasUsadas.contains(matricula);  
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true); 
        });
    }
}
