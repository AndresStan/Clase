package Vista;

import Controlador.Controlador;
import Controlador.Verificacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Gestor extends JFrame {

    private boolean esAdmin = false; // Se determinará mediante la consulta

    public Gestor(String dni) {
        Verificacion verificacion = new Verificacion();
        // 1. Consultar en la BD si el DNI es administrador antes de dibujar
        esAdmin = Verificacion.verificarRangoAdmin(dni);

        // 2. Configuración de la ventana
        setTitle("Panel de Control Gimnasio");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0, 0));

        // --- BARRA SUPERIOR (Usuario y Botón Admin condicional) ---
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Definición inicial
        JLabel lblFecha = new JLabel("", SwingConstants.CENTER);
        lblFecha.setFont(new Font("Arial", Font.PLAIN, 14));
        panelSuperior.add(lblFecha, BorderLayout.CENTER);

        // Definir el formateador una sola vez para ahorrar recursos
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy:hh:mm:ss");

        Timer timer = new Timer(1000, e -> {
            LocalDateTime hoy = LocalDateTime.now();
            lblFecha.setText(hoy.format(formateador));
        });

        timer.start(); // ¡No olvides iniciarlo!



        // Texto Usuario: (DNI) a la izquierda
        JLabel lblUsuario = new JLabel("Usuario: " + dni);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        panelSuperior.add(lblUsuario, BorderLayout.WEST);
        JButton btnAddUser = new JButton("Gestionar usuarios");
        // Si la consulta devolvió true, añadimos el botón "Añadir Usuarios" a la derecha
        if (esAdmin) {

            panelSuperior.add(btnAddUser, BorderLayout.EAST);
        }
        add(panelSuperior, BorderLayout.NORTH);

        // --- CUERPO CENTRAL ---
        JPanel panelCentral = new JPanel(new BorderLayout());

        JLabel lblTitulo = new JLabel("PANEL DE CONTROL GIMNASIO", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        panelCentral.add(lblTitulo, BorderLayout.NORTH);

        // --- PANEL DE BOTONES (Tamaño mediano mediante márgenes) ---
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 40, 40));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(50, 150, 150, 150));

        JButton btnMostrar = new JButton("MOSTRAR");
        JButton btnInsertar = new JButton("INSERTAR");
        JButton btnModificar = new JButton("MODIFICAR");
        JButton btnEliminar = new JButton("ELIMINAR");


        panelBotones.add(btnMostrar);
        panelBotones.add(btnInsertar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);

        panelCentral.add(panelBotones, BorderLayout.CENTER);
        add(panelCentral, BorderLayout.CENTER);

        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               GestionUsuarios gu = new GestionUsuarios();
            }
        });


        setVisible(true);
    }


}
