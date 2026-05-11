package Vista;
import Controlador.Verificacion;
import Controlador.Sentencias;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


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
        // Consultar en la BD si el DNI es administrador
        esAdmin = Verificacion.verificarRangoAdmin(dni);

        // Configuración de la ventana
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


        JButton btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.setBackground(new java.awt.Color(255, 204, 204)); // Un tono rojizo suave
        panelBotonesTop.add(btnCerrarSesion);


        JButton btnAddUser = new JButton("Gestionar usuarios");
        if (esAdmin) {
            panelBotonesTop.add(btnAddUser);
        }
        panelSuperior.add(panelBotonesTop, BorderLayout.EAST);
        add(panelSuperior, BorderLayout.NORTH);

        // --- CUERPO CENTRAL (Pestañas) ---
        pestanas = new JTabbedPane();

        // Defino los modelos con los campos de la base de datos
        modeloEntrenador = new DefaultTableModel(null, new String[]{"ID", "Nombre Completo", "Código Sala"});
        modeloSala = new DefaultTableModel(null, new String[]{"ID", "Nombre", "Capacidad"});
        modeloSocio = new DefaultTableModel(null, new String[]{"ID", "DNI", "Nombre Completo", "Correo Electrónico", "Fecha Alta", "Teléfono"});
        modeloPago = new DefaultTableModel(null, new String[]{"ID", "DNI Socio", "Fecha", "Importe"});

        pestanas.addTab("Entrenador", crearPanel( modeloEntrenador));
        pestanas.addTab("Sala", crearPanel( modeloSala));
        pestanas.addTab("Socio", crearPanel( modeloSocio));
        pestanas.addTab("Pago", crearPanel( modeloPago));



        add(pestanas, BorderLayout.CENTER);


        // --- CARGA INICIAL DE DATOS ---
        cargarDatos();




        // Al hacer clic en gestionar usuarios
        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 GestionUsuarios gu = new GestionUsuarios();
            }
        });

        // Al hacer click en cerrar sesion
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(
                        Gestor.this,
                        "¿Estás seguro de que quieres cerrar sesión?",
                        "Cerrar Sesión",
                        JOptionPane.YES_NO_OPTION
                );

                if (respuesta == JOptionPane.YES_OPTION) {

                    dispose();
                    System.exit(0);

                }
            }
        });

        setVisible(true);


    }




    // metodo cargar datos para usarlo siempre que quiera actualizar

    public void cargarDatos() {
        // Limpio los datos actuales de las tablas para no duplicar al refrescar
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
                    socio.getId(),
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


    // Funcion que crea el panel con el modelo que le pasamos al cambiar de pestaña

    private JPanel crearPanel(DefaultTableModel modeloTabla) {


        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloTabla);


        // Esta funcion hace que no pueda editar dando doble click a las celdas
        JTable tabla = new JTable(modeloTabla) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        tabla.setRowSorter(sorter);
        JPanel panelBusqueda = new JPanel(new BorderLayout(5, 0));
        panelBusqueda.add(new JLabel("Buscar: "), BorderLayout.WEST);
        JTextField txtBuscador = new JTextField();
        panelBusqueda.add(txtBuscador, BorderLayout.CENTER);


        // Funcion que al escribir eliminar o cambiar algo en el buscador se actualizer los registros para el filtro
        txtBuscador.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }
            private void filtrar() {
                String texto = txtBuscador.getText();
                if (texto.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    // Para que da igual si lo escribes en minusculas o mayusculas
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
                }

                cargarDatos();
            }
        });


        // Ponemos el filtro
        panel.add(panelBusqueda, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(tabla);
        panel.add(scrollPane, BorderLayout.CENTER);



        JPanel panelInferior = new JPanel(new BorderLayout(0, 15));
        int numColumnas = modeloTabla.getColumnCount();
        JPanel panelFormulario = new JPanel(new GridLayout(2, numColumnas, 5, 5));
        JTextField[] camposTexto = new JTextField[numColumnas];

        // Si clickeas fuera de un registro quito los registros de los textfield
        scrollPane.getViewport().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                tabla.clearSelection();
                for(int i = 0; i < numColumnas; i++) {
                    camposTexto[i].setText("");
                    camposTexto[0].setEditable(false);
                }
            }
        });
        for (int i = 0; i < numColumnas; i++) {
            panelFormulario.add(new JLabel(modeloTabla.getColumnName(i)));
        }


        for (int i = 0; i < numColumnas; i++) {

            // Si el nombre de la columna contiene Fecha pongo que sea un datepicker
            if (modeloTabla.getColumnName(i).contains("Fecha")) {
                // Creo el selector de fecha
                JDateChooser picker = new JDateChooser();
                picker.setDateFormatString("yyyy-MM-dd");

                // Hago que se abra al hacer clic en su campo de texto
                JTextField editor = (JTextField) picker.getDateEditor().getUiComponent();
                editor.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        picker.getCalendarButton().doClick();
                    }
                });

                camposTexto[i] = editor;
                panelFormulario.add(picker);

            } else {
                camposTexto[i] = new JTextField();
                panelFormulario.add(camposTexto[i]);
            }


        }

        pestanas.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                camposTexto[0].setEditable(false);
                camposTexto[0].setBackground(new java.awt.Color(255, 255, 255));


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
                int filaSeleccionada = tabla.getSelectedRow();
                boolean haySeleccion = filaSeleccionada != -1;
                btnInsertar.setEnabled(!haySeleccion);
                btnEliminar.setEnabled(haySeleccion);
                btnModificar.setEnabled(haySeleccion);



                // Si hay seleccion meto todos los datos en los campos de texto

                if(haySeleccion) {
                    int modelRow = tabla.convertRowIndexToModel(filaSeleccionada);
                    for(int i = 0; i < numColumnas; i++) {
                        Object valor = modeloTabla.getValueAt(modelRow, i);
                        camposTexto[i].setText(valor != null ? valor.toString() : "");

                    }
                    if (pestanas.getSelectedIndex()==3){
                        camposTexto[1].setEditable(false);
                        camposTexto[1].setBackground(new java.awt.Color(255, 255, 255));
                    }
                } else {
                    camposTexto[1].setEditable(true);
                    camposTexto[1].setBackground(new java.awt.Color(255, 255, 255));
                }
            }
        });



        panelBotones.add(btnInsertar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);


        panelInferior.add(panelFormulario, BorderLayout.CENTER);
        panelInferior.add(panelBotones, BorderLayout.SOUTH);

        panel.add(panelInferior, BorderLayout.SOUTH);

        // EVENTO ELIMINAR
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> lista = new ArrayList<>();
                for (JTextField campo : camposTexto){
                    lista.add(campo.getText());

                }

                int respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estás seguro de que deseas eliminar este registro?, Esta accion es irreversible",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION
                );

                // si no esta seguro se cancela
                if (respuesta != JOptionPane.YES_OPTION) {
                    return;
                }

                // si tiene clave ajena que es la pestaña 1 entonces doy la confirmacion de que existe un entrenador asignado a esa sala
                // si no tiene prosigo normalmente

                if (pestanas.getSelectedIndex() == 1){
                    if (Sentencias.salaTieneEntrenadores(Integer.parseInt(lista.get(0)))){
                        int respuesta2 = JOptionPane.showConfirmDialog(
                                null,
                                "Hay uno o varios entrenadores asignados a esta sala, ¿Desea proceder con la eliminacion?",
                                "Confirmación",
                                JOptionPane.YES_NO_OPTION
                        );

                        // si no esta seguro se cancela
                        if (respuesta2 != JOptionPane.YES_OPTION) {
                            return;
                        }

                    }
                }

                if (pestanas.getSelectedIndex() == 2){
                    if (Sentencias.socioTienePagos((lista.get(1)))){
                        int respuesta2 = JOptionPane.showConfirmDialog(
                                null,
                                "El socio seleccionado tiene pagos registrados ¿Desea proceder con la eliminacion?",
                                "Confirmación",
                                JOptionPane.YES_NO_OPTION
                        );

                        // si no esta seguro se cancela
                        if (respuesta2 != JOptionPane.YES_OPTION) {
                            return;
                        }

                    }
                }


                // si está seguro procede a la eliminacion
                try {
                    Sentencias.EliminarObjeto(lista, pestanas.getSelectedIndex());
                    JOptionPane.showMessageDialog(panel, "Eliminado correctamente");
                }   catch (Throwable t) {
                    JOptionPane.showMessageDialog(panel, "Error: " + t.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }

                cargarDatos();

            }
        });
        // EVENTO MODIFICAR
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<String> lista = new ArrayList<>();
                for (JTextField campo : camposTexto){
                    lista.add(campo.getText());
                }

                int num;

                try {
                    if ((num = Sentencias.modificarObjeto(lista, pestanas.getSelectedIndex())) == 10) {
                        JOptionPane.showMessageDialog(panel, "Modificado correctamente");
                        cargarDatos();
                    } else {
                        if (num == -1){
                            JOptionPane.showMessageDialog(panel, "Se requiere que el primer carácter de cada palabra del nombre sea una letra mayúscula");
                        }
                        if (num == -2){
                            JOptionPane.showMessageDialog(panel, "Error, no hay ninguna sala con ese codigo");
                        }
                        if (num == -21){
                            JOptionPane.showMessageDialog(panel, "Error la capacidad debe ser un numero entero valido");
                        }
                        if (num == -30){
                            JOptionPane.showMessageDialog(panel, "Asegurate de introducir los datos de Correo Electronico correctamente");
                        }
                        if (num == -31){
                            JOptionPane.showMessageDialog(panel, "Asegurate de introducir el DNI con el formato correcto (00000000A)");
                        }
                        if (num == -32){
                            JOptionPane.showMessageDialog(panel, "Asegurate de introducir los datos de Fecha con el siguiente formato (YYYY/MM/DD) y que no sea posterior a hoy");
                        }
                        if (num == -33){
                            JOptionPane.showMessageDialog(panel, "Asegurate de introducir los datos de un Telefono español valido");
                        }
                        if (num == -34){
                            JOptionPane.showMessageDialog(panel, "El importe no puede ser negativo ni superior a 99999€");
                        }

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }



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
                    if (num == -22){
                        JOptionPane.showMessageDialog(panel, "Error, no hay ninguna sala con ese codigo");
                    }
                    if (num == -2){
                        JOptionPane.showMessageDialog(panel, "Error clave foránea (no existe registro con ese ID)");
                    }
                    if (num == -3) {
                        JOptionPane.showMessageDialog(panel, "Se requiere que el primer carácter de cada palabra del nombre sea una letra mayúscula");
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
                        JOptionPane.showMessageDialog(panel, "Asegurate de introducir los datos de Fecha con el siguiente formato (YYYY/MM/DD) y que no sea posterior a hoy");
                    }
                    if (num == -7) {
                        JOptionPane.showMessageDialog(panel, "Asegurate de introducir los datos de un Telefono español valido");
                    }
                    if (num == -88) {
                        JOptionPane.showMessageDialog(panel, "Asegurate de introducir un importe valido");
                    }
                    if (num == -76) {
                        JOptionPane.showMessageDialog(panel, "Asegurate de introducir una capacidad positiva valida");
                    }
                }
                cargarDatos();

            }
        });

        return panel;
    }





}