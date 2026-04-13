package Vista;
import Controlador.Controlador;
import Modelo.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Main extends Controlador {
    public static void main(String[] args) throws SQLException {


                JFrame frame = new JFrame("Gestor Gimnasio");
                JPanel panel = new JPanel(new GridLayout(5, 1, 10, 20));

                panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));


                JLabel titulo = new JLabel("LOGIN", SwingConstants.CENTER);
                titulo.setFont(new Font("Arial", Font.BOLD, 25));

                JTextField txtDni = new JTextField();
                txtDni.setBorder(BorderFactory.createTitledBorder("DNI"));

                JPasswordField txtPass = new JPasswordField();
                txtPass.setBorder(BorderFactory.createTitledBorder("Contraseña"));

                JButton btnEntrar = new JButton("ENTRAR");
                btnEntrar.setBackground(Color.DARK_GRAY);
                btnEntrar.setForeground(Color.WHITE);
                btnEntrar.setFocusPainted(false);

                btnEntrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String dni = txtDni.getText();
                        String pass = new String(txtPass.getPassword());

                        Controlador controlador = new Controlador();
                        if (controlador.verificarUsuario(dni, pass)){
                            frame.dispose();
                            Gestor gestor = new Gestor(dni);
                        }
                    }
                });

                // 4. Añadir en orden
                panel.add(titulo);
                panel.add(txtDni);
                panel.add(txtPass);
                panel.add(new JLabel("")); // Espacio de separación
                panel.add(btnEntrar);

                frame.add(panel);
                frame.setSize(700, 800);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                /* bypass primera ventana*/

                frame.dispose();
                Gestor gestor = new Gestor("61091513V");

    }
}
