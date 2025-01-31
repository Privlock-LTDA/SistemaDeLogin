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
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblBemVindo = new JLabel("Bem-vindo, Administrador!");
        lblBemVindo.setFont(new Font("Arial", Font.BOLD, 16));

        btnCadastrarCandidato = new JButton("Cadastrar Candidato");
        btnCadastrarCandidato.setPreferredSize(new Dimension(200, 40));
        styleBotao(btnCadastrarCandidato);

        btnVerResultados = new JButton("Ver Resultados");
        btnVerResultados.setPreferredSize(new Dimension(200, 40));
        styleBotao(btnVerResultados);

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

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resposta = JOptionPane.showConfirmDialog(
                        null, 
                        "Você tem certeza que deseja sair?", 
                        "Confirmar", 
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    System.exit(0); // Fecha o aplicativo
                }
            }
        });
    }

    private void styleBotao(JButton botao) {
        botao.setBackground(new Color(192, 192, 192));
        botao.setForeground(Color.BLACK);
        botao.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        botao.setFocusPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 12));

        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(169, 169, 169));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(192, 192, 192));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaAdm().setVisible(true);
        });
    }
}
