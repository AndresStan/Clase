package Vista;

import Controlador.Controlador;
import Controlador.Verificacion;
import Controlador.Sentencias;
import Modelo.Pago;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EventListener;

public class Gestor extends JFrame {

    private boolean esAdmin = false;
    Sentencias s = new Sentencias();

    // Modelos para las 4 tablas
    private DefaultTableModel modeloEntrenador;
    private DefaultTableModel modeloSala;
    private DefaultTableModel modeloSocio;
    private DefaultTableModel modeloPago;

    JTabbedPane pestanas;
    public Gestor(String dni) {
        // 1. Consultar en la BD si el DNI es administrador
        esAdmin = Verificacion.verificarRangoAdmin(dni);

        // 2. Configuración de la ventana
        setTitle("Panel de Control Gimnasio");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0, 0));

        // --- BARRA SUPERIOR ---
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel lblFecha = new JLabel("", SwingConstants.CENTER);
        lblFecha.setFont(new Font("Arial", Font.PLAIN, 14));
        panelSuperior.add(lblFecha, BorderLayout.CENTER);

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy:hh:mm:ss");

        Timer timer = new Timer(1000, e -> {
            LocalDateTime hoy = LocalDateTime.now();
            lblFecha.setText(hoy.format(formateador));
        });
        timer.start();

        JLabel lblUsuario = new JLabel("Usuario: " + dni);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        panelSuperior.add(lblUsuario, BorderLayout.WEST);

        // Panel para agrupar los botones de la derecha
        JPanel panelBotonesTop = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));

        JButton btnRefrescar = new JButton("Refrescar");
        panelBotonesTop.add(btnRefrescar);

        JButton btnAddUser = new JButton("Gestionar usuarios");
        if (esAdmin) {
            panelBotonesTop.add(btnAddUser);
        }
        panelSuperior.add(panelBotonesTop, BorderLayout.EAST);
        add(panelSuperior, BorderLayout.NORTH);

        // --- CUERPO CENTRAL (Pestañas) ---
        pestanas = new JTabbedPane();

        modeloEntrenador = new DefaultTableModel(null, new String[]{"ID", "Nombre Completo", "Código Sala"});
        modeloSala = new DefaultTableModel(null, new String[]{"ID", "Nombre", "Capacidad"});
        modeloSocio = new DefaultTableModel(null, new String[]{"DNI", "Nombre Completo", "Correo Electrónico", "Fecha Alta", "Teléfono"});
        modeloPago = new DefaultTableModel(null, new String[]{"ID", "DNI Socio", "Fecha", "Importe"});

        pestanas.addTab("Entrenador", crearPanel("Entrenador", modeloEntrenador));
        pestanas.addTab("Sala", crearPanel("Sala", modeloSala));
        pestanas.addTab("Socio", crearPanel("Socio", modeloSocio));
        pestanas.addTab("Pago", crearPanel("Pago", modeloPago));




        add(pestanas, BorderLayout.CENTER);

        // --- CARGA INICIAL DE DATOS ---
        cargarDatos();

        // --- EVENTOS ---
        btnRefrescar.addActionListener(e -> cargarDatos());
        btnRefrescar.addActionListener(e -> System.out.println(pestanas.getSelectedIndex()));

        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 GestionUsuarios gu = new GestionUsuarios();
            }
        });



        setVisible(true);
    }




    // Método donde meterás las consultas SQL para rellenar las tablas
    public void cargarDatos() {
        // 1. Limpiar los datos actuales de las tablas para no duplicar al refrescar
        modeloEntrenador.setRowCount(0);
        modeloSala.setRowCount(0);
        modeloSocio.setRowCount(0);
        modeloPago.setRowCount(0);

        // Entrenadores
        DefaultListModel<Modelo.Entrenador> listaEntrenadores = s.mostrarEntrenadores();
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            Modelo.Entrenador entrenador = listaEntrenadores.get(i);
            // Suponiendo que tu clase Entrenador tiene estos "getters", ajusta los nombres si son distintos
            modeloEntrenador.addRow(new Object[]{
                    entrenador.getId(),
                    entrenador.getNombreCompleto(),
                    entrenador.getCodigoSala()
            });
        }


        // Socios
        DefaultListModel<Modelo.Socio> listaSocio = s.mostrarSocios();
        for (int i = 0; i < listaSocio.size(); i++) {
            Modelo.Socio socio = listaSocio.get(i);

            modeloSocio.addRow(new Object[]{
                    socio.getDni(),
                    socio.getNombreCompleto(),
                    socio.getCorreoElectronico(),
                    socio.getFechaAlta(),
                    socio.getTelefono()
            });
        }


        // Pago
        DefaultListModel<Modelo.Pago> listaPago = s.mostrarPagos();
        for (int i = 0; i < listaPago.size(); i++) {
            Modelo.Pago pago = listaPago.get(i);

            modeloPago.addRow(new Object[]{
                    pago.getId(),
                    pago.getDniSocio(),
                    pago.getFecha(),
                    pago.getImporte()
            });
        }


        // sala
        DefaultListModel<Modelo.Sala> listaSala = s.mostrarSalas();
        for (int i = 0; i < listaSala.size(); i++) {
            Modelo.Sala sala = listaSala.get(i);

            modeloSala.addRow(new Object[]{
                   sala.getId(),
                   sala.getNombre(),
                   sala.getCapacidad()
            });
        }




    }

    private JPanel crearPanel(String nombreTabla, DefaultTableModel modeloTabla) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTable tabla = new JTable(modeloTabla);
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout(0, 15));

        int numColumnas = modeloTabla.getColumnCount();
        JPanel panelFormulario = new JPanel(new GridLayout(2, numColumnas, 5, 5));
        JTextField[] camposTexto = new JTextField[numColumnas];

        // 1. Añadir las etiquetas (Fila superior del grid)
        for (int i = 0; i < numColumnas; i++) {
            panelFormulario.add(new JLabel(modeloTabla.getColumnName(i)));
        }

        // 2. Añadir los campos (Fila inferior del grid)
        for (int i = 0; i < numColumnas; i++) {
                camposTexto[i] = new JTextField();
                panelFormulario.add(camposTexto[i]);
        }

        pestanas.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                int index = pestanas.getSelectedIndex();

                // Aplicamos tu lógica
                if (index == 0 || index == 1 || index == 3) {
                    camposTexto[0].setEditable(false);
                    // Opcional: cambia el color para que sea visual
                    camposTexto[0].setBackground(new java.awt.Color(240, 240, 240));
                } else {
                    camposTexto[0].setEditable(true);
                    camposTexto[0].setBackground(java.awt.Color.WHITE);
                }
            }
        });




        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnInsertar = new JButton("Insertar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");


        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);

        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                boolean haySeleccion = tabla.getSelectedRow() != -1;
                btnInsertar.setEnabled(!haySeleccion);
                btnEliminar.setEnabled(haySeleccion);
                btnModificar.setEnabled(haySeleccion);

                // Extra: Si hay selección, pasar los datos a las cajas de texto (opcional pero muy útil)
                if(haySeleccion) {
                    for(int i = 0; i < numColumnas; i++) {
                        Object valor = tabla.getValueAt(tabla.getSelectedRow(), i);
                        camposTexto[i].setText(valor != null ? valor.toString() : "");
                    }
                } else {
                    for(int i = 0; i < numColumnas; i++) {
                        camposTexto[i].setText("");
                    }
                }
            }

        });

        panelBotones.add(btnInsertar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);

        panelInferior.add(panelFormulario, BorderLayout.CENTER);
        panelInferior.add(panelBotones, BorderLayout.SOUTH);

        panel.add(panelInferior, BorderLayout.SOUTH);

        // EVENTO ELIMINAR MIEMBRO
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> lista = new ArrayList<>();
                for (JTextField campo : camposTexto){
                    lista.add(campo.getText());

                }
                try {
                    Sentencias.EliminarObjeto(lista, pestanas.getSelectedIndex());
                    JOptionPane.showMessageDialog(panel, "Eliminado correctamente");
                }   catch (Throwable t) {
                    JOptionPane.showMessageDialog(panel, "Error: " + t.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }

                cargarDatos();

            }
        });

        // EVENTO INSERTAR

        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> lista = new ArrayList<>();
                for (JTextField campo : camposTexto){
                    lista.add(campo.getText());
                }
                int num;
                if ((num = Sentencias.InsertarObjeto(lista, pestanas.getSelectedIndex())) > 0) {
                    JOptionPane.showMessageDialog(panel, "Insertado correctamente");
                } else {
                    if (num == -1){
                        JOptionPane.showMessageDialog(panel, "Error clave primaria duplicada (ya existe un registro con esos datos)");
                    }
                    if (num == -2){
                        JOptionPane.showMessageDialog(panel, "Error clave foránea (no existe registro con ese ID)");
                    }
                    if (num == -3) {
                        JOptionPane.showMessageDialog(panel, "El nombre completo debe seguir el formato oficial Ejemplo 'Pedro Garcia Ruiz'");
                    }
                    if (num == -4) {
                        JOptionPane.showMessageDialog(panel, "Asegurate de introducir el DNI con el formato correcto (00000000A)");
                    }
                    if (num == -67) {
                        JOptionPane.showMessageDialog(panel, "Asegurate de introducir los datos correctamente");
                    }
                    if (num == -5) {
                        JOptionPane.showMessageDialog(panel, "Asegurate de introducir los datos de Correo Electronico correctamente");
                    }
                    if (num == -6) {
                        JOptionPane.showMessageDialog(panel, "Asegurate de introducir los datos de Fecha con el siguiente formato (YYYY/MM/DD)");
                    }
                    if (num == -7) {
                        JOptionPane.showMessageDialog(panel, "Asegurate de introducir los datos de un Telefono español valido");
                    }
                    if (num == -88) {
                        JOptionPane.showMessageDialog(panel, "Asegurate de introducir un importe valido");
                    }
                }
                cargarDatos();

            }
        });

        return panel;
    }
}