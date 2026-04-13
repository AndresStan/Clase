package Vista;

import Controlador.GestionUsuariosC;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class GestionUsuarios extends JFrame {
    private DefaultListModel<String> modeloLista;
    private JList<String> listaUsuarios;

    public GestionUsuarios() {
        GestionUsuariosC guC = new GestionUsuariosC();
        setTitle("Gestión de Usuarios");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(1, 2, 10, 10));

        // --- PANEL IZQUIERDO: FORMULARIO ALTA ---
        JPanel panelAñadir = new JPanel(new GridLayout(4, 2, 5, 5));
        panelAñadir.setBorder(BorderFactory.createTitledBorder("Nuevo Usuario"));

        JTextField txtDni = new JTextField();
        JPasswordField txtPass = new JPasswordField();
        JCheckBox chkAdmin = new JCheckBox("¿Es Admin?");
        JButton btnAñadir = new JButton("Añadir Usuario");

        panelAñadir.add(new JLabel("DNI:"));
        panelAñadir.add(txtDni);
        panelAñadir.add(new JLabel("Contraseña:"));
        panelAñadir.add(txtPass);
        panelAñadir.add(new JLabel("Rol:"));
        panelAñadir.add(chkAdmin);
        panelAñadir.add(new JLabel(""));
        panelAñadir.add(btnAñadir);

        // --- PANEL DERECHO: ELIMINAR Y LEYENDA ---
        JPanel panelEliminar = new JPanel(new BorderLayout(5, 5));
        panelEliminar.setBorder(BorderFactory.createTitledBorder("Eliminar Usuario"));

        // Cabecera: Botón Refrescar + Espacio + Leyendas
        JPanel panelCabecera = new JPanel(new BorderLayout());

        JButton btnRefrescar = new JButton("Refrescar");

        // Panel para las leyendas con ESPACIO SUPERIOR (EmptyBorder)
        JPanel panelLeyendas = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        // El 10 en el segundo parámetro añade el espacio respecto al botón
        panelLeyendas.setBorder(new EmptyBorder(10, 0, 5, 0));

        JLabel lblDniHeader = new JLabel("DNI");
        JLabel lblAdminHeader = new JLabel("ADMIN");

        // Margen para mover ADMIN a la izquierda
        lblAdminHeader.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        lblDniHeader.setFont(new Font("Arial", Font.BOLD, 12));
        lblAdminHeader.setFont(new Font("Arial", Font.BOLD, 12));

        panelLeyendas.add(lblDniHeader);
        panelLeyendas.add(lblAdminHeader);

        panelCabecera.add(btnRefrescar, BorderLayout.NORTH);
        panelCabecera.add(panelLeyendas, BorderLayout.SOUTH);

        // Lista
        modeloLista = new DefaultListModel<>();
        listaUsuarios = new JList<>(modeloLista);
        listaUsuarios.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollLista = new JScrollPane(listaUsuarios);

        JButton btnEliminar = new JButton("Eliminar Seleccionado");

        panelEliminar.add(panelCabecera, BorderLayout.NORTH);
        panelEliminar.add(scrollLista, BorderLayout.CENTER);
        panelEliminar.add(btnEliminar, BorderLayout.SOUTH);

        // --- LÓGICA DE EVENTOS ---

        btnAñadir.addActionListener(e -> {
            if (!txtDni.getText().isEmpty()) {
                String pass = new String(txtPass.getPassword());
                String dni = txtDni.getText();
                boolean admin = chkAdmin.isSelected();




                txtDni.setText("");
                txtPass.setText("");
                chkAdmin.setSelected(false);

                modeloLista = guC.cargarUsuarios();
                listaUsuarios.setModel(modeloLista);
            }
        });

        btnRefrescar.addActionListener(e -> {
            modeloLista = guC.cargarUsuarios();
            listaUsuarios.setModel(modeloLista);
        });

        btnEliminar.addActionListener(e -> {
            int index = listaUsuarios.getSelectedIndex();
            if (index != -1) {
                String linea = modeloLista.getElementAt(index);
                String dni = linea.trim().split("\\s+")[0];
                guC.eliminarUsuario(dni);
                modeloLista.remove(index);
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un usuario de la lista");
            }
        });

        add(panelAñadir);
        add(panelEliminar);

        modeloLista = guC.cargarUsuarios();
        listaUsuarios.setModel(modeloLista);

        setVisible(true);
    }
}
