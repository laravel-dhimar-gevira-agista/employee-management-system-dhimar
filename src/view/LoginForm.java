package view;

import service.LoginService;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public LoginForm() {

        setTitle("Login - Employee Management System");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("LOGIN SYSTEM");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(130, 10, 200, 30);
        add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 60, 100, 25);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(150, 60, 180, 25);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 100, 100, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 100, 180, 25);
        add(txtPassword);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(150, 140, 100, 30);
        add(btnLogin);

        // ================= LOGIN ACTION =================
        btnLogin.addActionListener(e -> {

            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            // VALIDASI INPUT
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Username dan Password tidak boleh kosong!");
                return;
            }

            // PANGGIL SERVICE (TIDAK ADA SQL DI SINI)
            boolean sukses = LoginService.login(username, password);

            if (sukses) {
                JOptionPane.showMessageDialog(this,
                        "Login berhasil!");

                this.dispose(); // tutup login
                new Dashboard().setVisible(true); // buka dashboard

            } else {
                JOptionPane.showMessageDialog(this,
                        "Username atau Password salah!",
                        "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}