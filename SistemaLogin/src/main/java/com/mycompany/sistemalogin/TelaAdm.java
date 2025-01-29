/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemalogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaAdm extends JFrame {
    private final JButton btnCadastrarCandidato;
    private final JButton btnVerResultados;

    public TelaAdm() {
        setTitle("Tela de Administração - Urna Eletrônica");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblBemVindo = new JLabel("Bem-vindo, Admin!");
        lblBemVindo.setFont(new Font("Arial", Font.BOLD, 16));

        btnCadastrarCandidato = new JButton("Cadastrar Candidato");
        btnCadastrarCandidato.setPreferredSize(new Dimension(200, 40));

        btnVerResultados = new JButton("Ver Resultados");
        btnVerResultados.setPreferredSize(new Dimension(200, 40));

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblBemVindo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnCadastrarCandidato, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnVerResultados, gbc);

        btnCadastrarCandidato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastro().setVisible(true);
                dispose();
            }
        });

        btnVerResultados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaResultados().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaAdm().setVisible(true); 
        });
    }
}
