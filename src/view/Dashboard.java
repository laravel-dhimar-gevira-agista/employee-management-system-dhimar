package view;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        setTitle("Employee Management System");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("EMPLOYEE MANAGEMENT SYSTEM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel welcome = new JLabel("Selamat Datang di Dashboard", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton btnPegawai = new JButton("Data Pegawai");
        JButton btnDivisi = new JButton("Data Divisi");
        JButton btnJabatan = new JButton("Data Jabatan");
        JButton btnLogout = new JButton("Logout");

        JPanel panelButton = new JPanel(new GridLayout(2, 2, 20, 20));
        panelButton.add(btnPegawai);
        panelButton.add(btnDivisi);
        panelButton.add(btnJabatan);
        panelButton.add(btnLogout);

        setLayout(new BorderLayout(15,15));
        add(title, BorderLayout.NORTH);
        add(welcome, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);

        btnLogout.addActionListener(e -> {
            dispose();
            new LoginForm().setVisible(true);
        });

    }

}