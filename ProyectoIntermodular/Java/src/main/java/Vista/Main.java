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

                // 1. Panel con 5 filas y 1 columna
                JPanel panel = new JPanel(new GridLayout(5, 1, 10, 20));

                // 2. EL SECRETO: Grandes márgenes laterales y verticales para centrar todo
                // (Arriba: 200, Izquierda: 200, Abajo: 200, Derecha: 200)
                panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

                // 3. Componentes directos
                JLabel titulo = new JLabel("LOGIN", SwingConstants.CENTER);
                titulo.setFont(new Font("Arial", Font.BOLD, 25));

                JTextField txtDni = new JTextField();
                txtDni.setBorder(BorderFactory.createTitledBorder("DNI"));

                JPasswordField txtPass = new JPasswordField();
                txtPass.setBorder(BorderFactory.createTitledBorder("Contraseña"));

                JButton btnEntrar = new JButton("ENTRAR");
                btnEntrar.setBackground(Color.DARK_GRAY);
                btnEntrar.setForeground(Color.WHITE);
                btnEntrar.setFocusPainted(false); // Quita el recuadro feo al hacer clic

                btnEntrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String dni = txtDni.getText();
                        String pass = new String(txtPass.getPassword());

                        // La vista NO hace el insert, se lo pide al controlador
                        Controlador controlador = new Controlador();
                        if (controlador.verificarUsuario(dni, pass)){
                            frame.dispose();
                            Gestor gestor = new Gestor();
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

    }
}
