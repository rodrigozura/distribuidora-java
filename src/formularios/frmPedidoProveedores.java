
package formularios;

import datos.DatosLogin;
import datos.ItemsPP;
import datos.Modificaciones;
import datos.PedidosProv;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Conexion;
import logica.fPedidoProv;
import logica.fProductos;
import logica.fProveedores;
import logica.funciones;


public class frmPedidoProveedores extends javax.swing.JInternalFrame {
    
    Conexion con;
    fPedidoProv funcPedidoProv;
    fProveedores funcProv;
    fProductos funcProductos;
    PedidosProv datosPedidoProv = new PedidosProv();
    ItemsPP datosItems = new ItemsPP();
    int bandera = 1;
    funciones f;
    Modificaciones datosF = new Modificaciones();
    
    public frmPedidoProveedores(Conexion con) {
        initComponents();
        this.con=con;
        funcPedidoProv = new fPedidoProv(con);
        funcProv = new fProveedores(con);
        funcProductos = new fProductos(con);
        f = new funciones(con);
        mostrarClientes("");
        mostrarProductos("");
        lblPrecio1.setVisible(false);
        lblPrecio2.setVisible(false);
        lblPrecio3.setVisible(false);
        crearPedidoPrueba();
        
    }
    
    public frmPedidoProveedores(Conexion con, String idPedido) {
        initComponents();
        this.con=con;
        funcPedidoProv = new fPedidoProv(con);
        funcProv = new fProveedores(con);
        funcProductos = new fProductos(con);
        f = new funciones(con);
        mostrarClientes("");
        mostrarProductos("");
        lblPrecio1.setVisible(false);
        lblPrecio2.setVisible(false);
        lblPrecio3.setVisible(false);
        cargarPedido(idPedido);
        
    }
    
    void cargarPedido(String idPedido){
        String [] registros;
        registros = funcPedidoProv.buscarIdPedido(idPedido);
        DefaultTableModel tabla;
        if (registros != null) {
            lblIdPedido.setText(registros[0]);
            TxtIdProv.setText(registros[1]);
            TxtProv.setText(registros[2]);
            TxtDireccionCliente.setText(registros[3]);
            TxtCodPedido.setText(registros[5]);
            TxtTotal.setText(registros[7]);
            cbEstado.setSelectedItem(registros[8]);
            
            tabla = funcPedidoProv.mostrarItems(registros[0]);
            tblItems.setModel(tabla);
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo cargar el Pedido\n Intente mas tarde");
            this.dispose();
        }
    }
    
    void crearPedidoPrueba(){
        
        datosPedidoProv.setIdprov(6);
        datosPedidoProv.setIdusuario(2);
        datosPedidoProv.setCodigo("0000-000000");
        datosPedidoProv.setTotal(Double.parseDouble("0.0"));
        datosPedidoProv.setEstado("Preparado");
        if (!funcPedidoProv.insertar(datosPedidoProv)) {
            JOptionPane.showMessageDialog(null, "No se pudo crear un pedido, intente nuevamente");
            this.dispose();
        }
        String idpedido = funcPedidoProv.buscarId();
        lblIdPedido.setText(idpedido);
    }
    
    void mostrarClientes(String buscar){
        DefaultTableModel tabla;
        String filtro = "nombre";
        if (rbNombre.isSelected()) {
            filtro = "nombre";
        }
        if (rbApellido.isSelected()) {
            filtro = "apellido";
        }
        tabla = funcProv.mostrarProveedores(buscar, filtro);
        tblClientes.setModel(tabla);
        
    }
    
    void mostrarProductos(String buscar){
        DefaultTableModel tabla;
        String filtro = "codBarra";
        if (rbNombre.isSelected()) {
            filtro = "nombre";
        }
        if (rbCat.isSelected()) {
            filtro = "nombre_cat";
        }
        if (rbCodBarra.isSelected()) {
            filtro = "codBarra";
        }
        if (rbId.isSelected()) {
            filtro = "idproducto";
        }
        tabla = funcProductos.mostrarProductosPedido(buscar, filtro);
        tblProductos.setModel(tabla);
    }
    
    void mostrarItems(){
        DefaultTableModel tabla;
        tabla = funcPedidoProv.mostrarItems(lblIdPedido.getText());
        tblItems.setModel(tabla);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        TxtBuscarCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtIdProv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtProv = new javax.swing.JTextField();
        TxtDireccionCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbNombre = new javax.swing.JRadioButton();
        rbApellido = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TxtBuscarProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        TxtIdProd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtProd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtCant = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtPrecio = new javax.swing.JTextField();
        cbPrecio = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        TxtDescProd = new javax.swing.JTextField();
        rbNombreProd = new javax.swing.JRadioButton();
        rbCat = new javax.swing.JRadioButton();
        rbCodBarra = new javax.swing.JRadioButton();
        rbId = new javax.swing.JRadioButton();
        lblPrecio1 = new javax.swing.JLabel();
        lblPrecio2 = new javax.swing.JLabel();
        lblPrecio3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        TxtTotalProd = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        TxtTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        BtnGuardar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        TxtCodPedido = new javax.swing.JTextField();
        BtnCancelar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        BtnNuevo = new javax.swing.JButton();
        lblIdPedido = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Crear Pedidos Proveedor");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Buscar: ");

        TxtBuscarCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarClienteKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Id: ");

        TxtIdProv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TxtIdProv.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Proveedor:");

        TxtProv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TxtProv.setEnabled(false);

        TxtDireccionCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TxtDireccionCliente.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Direccion:");

        buttonGroup1.add(rbNombre);
        rbNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbNombre.setSelected(true);
        rbNombre.setText("Nombre");

        buttonGroup1.add(rbApellido);
        rbApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbApellido.setText("Apellido");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbNombre)
                        .addGap(18, 18, 18)
                        .addComponent(rbApellido)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDireccionCliente))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtProv, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbNombre)
                        .addComponent(rbApellido))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(TxtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TxtProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Proveedor", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Buscar: ");

        TxtBuscarProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarProductoKeyReleased(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Id: ");

        TxtIdProd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TxtIdProd.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Producto: ");

        TxtProd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TxtProd.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Cantidad: ");

        TxtCant.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtCant.setText("1");
        TxtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtCantKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Precio Uni: ");

        TxtPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPrecioKeyReleased(evt);
            }
        });

        cbPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbPrecio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Precio 1", "Precio 2", "Precio 3" }));
        cbPrecio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPrecioItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("$");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Descuento: ");

        TxtDescProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtDescProd.setText("0");
        TxtDescProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtDescProdKeyReleased(evt);
            }
        });

        buttonGroup2.add(rbNombreProd);
        rbNombreProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbNombreProd.setText("Nombre");

        buttonGroup2.add(rbCat);
        rbCat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbCat.setText("Categoria");

        buttonGroup2.add(rbCodBarra);
        rbCodBarra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbCodBarra.setText("Cod Barra");

        buttonGroup2.add(rbId);
        rbId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbId.setSelected(true);
        rbId.setText("Id");

        lblPrecio1.setText("jLabel1");
        lblPrecio1.setEnabled(false);

        lblPrecio2.setText("jLabel1");
        lblPrecio2.setEnabled(false);

        lblPrecio3.setText("jLabel1");
        lblPrecio3.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Total:");

        TxtTotalProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtProd, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbNombreProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbCat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbCodBarra)
                                .addGap(10, 10, 10)
                                .addComponent(rbId))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtTotalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblPrecio3)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblPrecio2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblPrecio1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbNombreProd)
                    .addComponent(rbCat)
                    .addComponent(rbCodBarra)
                    .addComponent(rbId))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(TxtProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TxtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(cbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(TxtDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(TxtTotalProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecio1)
                            .addComponent(lblPrecio2)
                            .addComponent(lblPrecio3))
                        .addGap(3, 3, 3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Items del Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblItemsMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblItems);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );

        TxtTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtTotal.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Total Pedido: ");

        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Guardar_48x48.png"))); // NOI18N
        BtnGuardar.setText("Guardar");
        BtnGuardar.setBorder(null);
        BtnGuardar.setContentAreaFilled(false);
        BtnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnGuardar.setIconTextGap(3);
        BtnGuardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Cod Pedido: ");

        TxtCodPedido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtCodPedido.setText("0-00000000");

        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Cancelar_48x48.png"))); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.setBorder(null);
        BtnCancelar.setBorderPainted(false);
        BtnCancelar.setContentAreaFilled(false);
        BtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnCancelar.setIconTextGap(3);
        BtnCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Estado:");

        cbEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Esperando", "Entregado", "Observando" }));

        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Nuevo_48x48.png"))); // NOI18N
        BtnNuevo.setText("Nuevo");
        BtnNuevo.setBorder(null);
        BtnNuevo.setContentAreaFilled(false);
        BtnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnNuevo.setIconTextGap(3);
        BtnNuevo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtCodPedido)
                                    .addComponent(cbEstado, 0, 174, Short.MAX_VALUE)))
                            .addComponent(lblIdPedido))
                        .addGap(50, 50, 50)
                        .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(TxtCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIdPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(TxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(BtnCancelar)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Proveedor");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarClienteKeyReleased
        mostrarClientes(TxtBuscarCliente.getText());
    }//GEN-LAST:event_TxtBuscarClienteKeyReleased

    private void TxtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarProductoKeyReleased
        mostrarProductos(TxtBuscarProducto.getText());
    }//GEN-LAST:event_TxtBuscarProductoKeyReleased

    private void tblClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMousePressed
        if (evt.getClickCount() == 1) {
            int fila = tblClientes.getSelectedRow();
            
            TxtIdProv.setText(tblClientes.getValueAt(fila, 0).toString());
            TxtProv.setText(tblClientes.getValueAt(fila, 1).toString());
            TxtDireccionCliente.setText(tblClientes.getValueAt(fila, 3).toString());
        }
    }//GEN-LAST:event_tblClientesMousePressed

    private void tblProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMousePressed
        if (evt.getClickCount() == 1) {
            int fila = tblProductos.getSelectedRow();
            TxtCant.setText("1");
            
            TxtIdProd.setText(tblProductos.getValueAt(fila, 0).toString());
            TxtProd.setText(tblProductos.getValueAt(fila, 3).toString());
            TxtPrecio.setText(tblProductos.getValueAt(fila, 6).toString());
            lblPrecio1.setText(tblProductos.getValueAt(fila, 6).toString());
            lblPrecio2.setText(tblProductos.getValueAt(fila, 7).toString());
            lblPrecio3.setText(tblProductos.getValueAt(fila, 8).toString());
            TxtTotalProd.setText(tblProductos.getValueAt(fila, 6).toString());
            
        }
    }//GEN-LAST:event_tblProductosMousePressed

    private void cbPrecioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPrecioItemStateChanged
        if (cbPrecio.getSelectedItem().equals("Precio 1")) {
            TxtPrecio.setText(lblPrecio1.getText());
            try {
                Double precio = Double.parseDouble(TxtPrecio.getText());
                int cant = Integer.parseInt(TxtCant.getText());
                Double desc = Double.parseDouble(TxtDescProd.getText());
                Double total = (precio * cant) * (1 - (desc / 100));
                total = Math.round(total * 100) / 100d;

                TxtTotalProd.setText(total.toString());
            } catch (NumberFormatException e) {
                TxtTotalProd.setText("0");
            }
        }
        if (cbPrecio.getSelectedItem().equals("Precio 2")) {
            TxtPrecio.setText(lblPrecio2.getText());
            try {
                Double precio = Double.parseDouble(TxtPrecio.getText());
                int cant = Integer.parseInt(TxtCant.getText());
                Double desc = Double.parseDouble(TxtDescProd.getText());
                Double total = (precio * cant) * (1 - (desc / 100));
                total = Math.round(total * 100) / 100d;

                TxtTotalProd.setText(total.toString());
            } catch (NumberFormatException e) {
                TxtTotalProd.setText("0");
            }
        }
        if (cbPrecio.getSelectedItem().equals("Precio 3")) {
            TxtPrecio.setText(lblPrecio3.getText());
            try {
                Double precio = Double.parseDouble(TxtPrecio.getText());
                int cant = Integer.parseInt(TxtCant.getText());
                Double desc = Double.parseDouble(TxtDescProd.getText());
                Double total = (precio * cant) * (1 - (desc / 100));
                total = Math.round(total * 100) / 100d;

                TxtTotalProd.setText(total.toString());
            } catch (NumberFormatException e) {
                TxtTotalProd.setText("0");
            }
        }
    }//GEN-LAST:event_cbPrecioItemStateChanged

    private void TxtCantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCantKeyReleased
        try {
            Double precio = Double.parseDouble(TxtPrecio.getText());
            int cant = Integer.parseInt(TxtCant.getText());
            Double total = precio * cant;
            total = Math.round(total * 100) / 100d;
        
            TxtTotalProd.setText(total.toString());
        } catch (NumberFormatException e) {
            TxtTotalProd.setText("0");
        }
        
    }//GEN-LAST:event_TxtCantKeyReleased

    private void TxtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioKeyReleased
        try {
            Double precio = Double.parseDouble(TxtPrecio.getText());
            int cant = Integer.parseInt(TxtCant.getText());
            Double total = precio * cant;
            total = Math.round(total * 100) / 100d;
        
            TxtTotalProd.setText(total.toString());
        } catch (NumberFormatException e) {
            TxtTotalProd.setText("0");
        }
        
    }//GEN-LAST:event_TxtPrecioKeyReleased

    private void TxtDescProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDescProdKeyReleased
        try {
            Double precio = Double.parseDouble(TxtPrecio.getText());
            int cant = Integer.parseInt(TxtCant.getText());
            Double desc = Double.parseDouble(TxtDescProd.getText());
            Double total = (precio*cant)*(1-(desc/100));
            total = Math.round(total * 100) / 100d;
        
            TxtTotalProd.setText(total.toString());
        } catch (NumberFormatException e) {
            TxtTotalProd.setText("0");
        }
    }//GEN-LAST:event_TxtDescProdKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        datosItems.setIdpedidoProv(Integer.parseInt(lblIdPedido.getText()));
        datosItems.setIdproducto(Integer.parseInt(TxtIdProd.getText()));
        datosItems.setCantidad(Integer.parseInt(TxtCant.getText()));
        datosItems.setPrecioUni(Double.parseDouble(TxtPrecio.getText()));
        datosItems.setTotal(Double.parseDouble(TxtTotalProd.getText()));
        Double total = Double.parseDouble(TxtTotal.getText());
        Double totalProd = Double.parseDouble(TxtTotalProd.getText());
        total = totalProd + total;
        total = Math.round(total * 100) / 100d;
        TxtTotal.setText(total.toString());
        
        if (funcPedidoProv.insertarItem(datosItems)) {
            mostrarItems();
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo insertar Item\n Intente nuevamente");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblItemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemsMousePressed
        if (evt.getClickCount() == 1) {
            int fila = tblItems.getSelectedRow();
            int seleccion = JOptionPane.showConfirmDialog(null, "Desea eliminar el items?");
            if (seleccion == 0) {
                datosItems.setIditemPP(Integer.parseInt(tblItems.getValueAt(fila, 0).toString()));
                
                Double total = Double.parseDouble(TxtTotal.getText());
                Double totalProd = Double.parseDouble(tblItems.getValueAt(fila, 5).toString());
                total = total - totalProd;
                total = Math.round(total * 100) / 100d;
                TxtTotal.setText(total.toString());
                
                
                if (funcPedidoProv.eliminarItem(datosItems)) {
                    JOptionPane.showMessageDialog(null, "Se elimino items");
                    
                    mostrarItems();
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar items, intente mas tarde");
                }
            }
        }
    }//GEN-LAST:event_tblItemsMousePressed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        datosPedidoProv.setIdpedidoProv(Integer.parseInt(lblIdPedido.getText()));
        int seleccion = JOptionPane.showConfirmDialog(null, "Desea Salir? Se eliminara el pedido");
        if (seleccion == 0) {
            if (funcPedidoProv.eliminarPedido(datosPedidoProv)) {
                JOptionPane.showMessageDialog(null, "Saliendo...");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar pedido");
                this.dispose();
            }
        }
        
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        datosPedidoProv.setIdpedidoProv(Integer.parseInt(lblIdPedido.getText()));
        datosPedidoProv.setIdprov(Integer.parseInt(TxtIdProv.getText()));
        datosPedidoProv.setIdusuario(DatosLogin.getNusuario());
        datosPedidoProv.setCodigo(TxtCodPedido.getText());
        datosPedidoProv.setTotal(Double.parseDouble(TxtTotal.getText()));
        datosPedidoProv.setEstado(cbEstado.getSelectedItem().toString());

        if (funcPedidoProv.modificar(datosPedidoProv)) {
            datosF.setIdregTabla(Integer.parseInt(lblIdPedido.getText()));
            datosF.setTabla("pedidosprov");
            datosF.setUsuario(DatosLogin.getUsuario());
            if (!f.insertar(datosF)) {
                JOptionPane.showMessageDialog(null, "No se pudo ingresar en la tabla de modificaciones");
            }
            JOptionPane.showMessageDialog(null, "Se Guardo correctamente el pedido");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el Pedido\n Intente nuevamente luego");
        }


    }//GEN-LAST:event_BtnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JTextField TxtBuscarCliente;
    private javax.swing.JTextField TxtBuscarProducto;
    private javax.swing.JTextField TxtCant;
    private javax.swing.JTextField TxtCodPedido;
    private javax.swing.JTextField TxtDescProd;
    private javax.swing.JTextField TxtDireccionCliente;
    private javax.swing.JTextField TxtIdProd;
    private javax.swing.JTextField TxtIdProv;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtProd;
    private javax.swing.JTextField TxtProv;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JTextField TxtTotalProd;
    private javax.swing.JButton btnAgregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbPrecio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblIdPedido;
    private javax.swing.JLabel lblPrecio1;
    private javax.swing.JLabel lblPrecio2;
    private javax.swing.JLabel lblPrecio3;
    private javax.swing.JRadioButton rbApellido;
    private javax.swing.JRadioButton rbCat;
    private javax.swing.JRadioButton rbCodBarra;
    private javax.swing.JRadioButton rbId;
    private javax.swing.JRadioButton rbNombre;
    private javax.swing.JRadioButton rbNombreProd;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblItems;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
