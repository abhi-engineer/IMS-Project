package ims.project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernamefiled;
    private JPasswordField passwordfield;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
        setLocationRelativeTo(null);
        setTitle("IMS System");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1042, 533);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 153, 204));
        contentPane.setForeground(new Color(105, 105, 105));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel welcomelbl = new JLabel("LOGIN");
        welcomelbl.setBounds(379, 30, 114, 46);
        welcomelbl.setBackground(new Color(248, 248, 255));
        welcomelbl.setForeground(new Color(0, 255, 255));
        welcomelbl.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(welcomelbl);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setBounds(379, 129, 125, 32);
        lblNewLabel.setForeground(new Color(152, 251, 152));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(379, 237, 125, 32);
        lblPassword.setForeground(new Color(152, 251, 152));
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lblPassword);

        usernamefiled = new JTextField();
        usernamefiled.setBounds(379, 168, 280, 32);
        usernamefiled.setBackground(new Color(240, 248, 255));
        usernamefiled.setForeground(new Color(128, 128, 128));
        usernamefiled.setFont(new Font("Tahoma", Font.PLAIN, 16));
        usernamefiled.setText("Enter Username");
        usernamefiled.setColumns(10);
        contentPane.add(usernamefiled);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = usernamefiled.getText();
                char[] ch = passwordfield.getPassword();
                String password = new String(ch);

                try {
                    Connection con = database.Conn.getCon();
                    String query1 = "SELECT * FROM appuser WHERE email=? AND password=? AND status='Active'";
                    PreparedStatement ps = con.prepareStatement(query1);
                    ps.setString(1, email);
                    ps.setString(2, password);

                    ResultSet set = ps.executeQuery();
                    if (set.next()) {
                        if (set.getString("userRole").equals("Admin")) {
                            new Catagory("Admin").setVisible(true);
                            dispose();
                        } else if (set.getString("userRole").equals("superAdmin")) {
                            new UserManager().setVisible(true);
                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                    }

                    // Close resources
                    set.close();
                    ps.close();
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnNewButton.setBounds(533, 379, 125, 32);
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(150, 202, 214));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(btnNewButton);

        JButton loginBtn = new JButton("Close");
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "Do you want to close the IMS", "Select", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    System.exit(0);
                }
            }
        });
        loginBtn.setBounds(379, 379, 125, 29);
        loginBtn.setBackground(new Color(250, 128, 114));
        loginBtn.setForeground(new Color(248, 248, 255));
        loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(loginBtn);

        JLabel lblNewLabel_1 = new JLabel("PAGE");
        lblNewLabel_1.setBounds(492, 31, 106, 45);
        lblNewLabel_1.setForeground(new Color(250, 128, 114));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(lblNewLabel_1);

        passwordfield = new JPasswordField();
        passwordfield.setBackground(new Color(255, 255, 255));
        passwordfield.setBounds(379, 289, 280, 29);
        contentPane.add(passwordfield);
    }
}
