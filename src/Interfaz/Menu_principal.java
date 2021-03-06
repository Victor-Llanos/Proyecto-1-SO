/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Main.Main;
import Primitivas.ProduPantallas;
import Primitivas.ProduBotones;
import Primitivas.ProduCamaras;
import Primitivas.ProduPin;
import Primitivas.Assembler;
import Primitivas.Jefazo;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

/**
 *
 * @author Achicopalado
 */
public class Menu_principal extends javax.swing.JFrame {
    
    Semaphore mutexButt;
    Semaphore mutexCams;
    Semaphore mutexScreens;
    Semaphore mutexPins;
    Semaphore mutexDays;
    Semaphore mutexPhones;
    Semaphore mutexWorkJefazo;
    Semaphore mutexWorkManager;
    Semaphore mutexChange;
    float profit;
    
    boolean bossWorking;
    boolean managerWorking;
    Semaphore mutexTotalDelivery;
    
    int countProdScreens;
    int countProdButts;
    int countProdPins;
    int countProdCams;
    int countAssembler;
      
    /**
     * Creates new form Menu_principal
     */
    public Menu_principal() {
        
        this.mutexButt = Main.mutexButt;
        this.mutexCams = Main.mutexCams;
        this.mutexScreens = Main.mutexScreens;
        this.mutexPins = Main.mutexPins;
        this.mutexDays = Main.mutexDays;
        this.mutexPhones = Main.mutexPhones;
        this.bossWorking = Main.bossWorking;
        this.mutexWorkJefazo = Main.mutexWorkJefazo;
        this.managerWorking = Main.managerWorking;
        this.mutexWorkManager = Main.mutexWorkManager;
        this.mutexTotalDelivery = Main.mutexTotalDelivery;
        this.mutexChange = Main.mutexChange;
        this.profit = profit;
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        Runnable r = new Runnable() {
            
            @Override
            public void run() {
                float endTime = (float)Main.dataTXT[0]/70*1000;
        
                while (true) {
                    try {
                        mutexButt.acquire();
                            botones.setText(Integer.toString(Main.buttons));
                        mutexButt.release();
                        
                        mutexCams.acquire();
                            camaras.setText(Integer.toString(Main.cams));
                        mutexCams.release();
                        
                        mutexScreens.acquire();
                            pantallas.setText(Integer.toString(Main.screens));
                        mutexScreens.release();
                        
                        mutexPins.acquire();
                            pines.setText(Integer.toString(Main.pins));
                        mutexPins.release();
                        
                        mutexPhones.acquire();
                            telefonos.setText(Integer.toString(Main.totalPhones));
                            entregados.setText(Integer.toString(Main.phones));
                        mutexPhones.release();
                        
                        mutexChange.acquire();
                            tuggle.setText(Main.telefono);
                        mutexChange.release();
                        
                        profit = (float) (Main.phones * Main.price);
                        Main.semSalCams.acquire();
                        Main.semSalButts.acquire();
                        Main.semSalPins.acquire();
                        Main.semSalScreens.acquire();
                        Main.semSalAss.acquire();
                        Main.semSalBoss.acquire();
                        Main.semSalManager.acquire();
                        profit -=(Main.salButts + Main.salCams + Main.salPins + Main.salScreens + Main.salAss + Main.salBoss + Main.salManager);
                        ganancias.setText(Float.toString(profit));
                        Main.semSalCams.release();
                        Main.semSalButts.release();
                        Main.semSalPins.release();
                        Main.semSalScreens.release();
                        Main.semSalAss.release();
                        Main.semSalBoss.release();
                        Main.semSalManager.release();
                       
                        produPantalla.setText(Integer.toString(Main.dataTXT[6]));
                        produBoton.setText(Integer.toString(Main.dataTXT[7]));
                        produCamara.setText(Integer.toString(Main.dataTXT[8]));
                        produPin.setText(Integer.toString(Main.dataTXT[9]));
                        ensamblador.setText(Integer.toString(Main.dataTXT[10]));
                        
                        mutexDays.acquire();
                            endDay.setText(Integer.toString(Jefazo.endDay));
                        mutexDays.release();
                        
                        mutexWorkJefazo.acquire();
                            if (Main.bossWorking){                          
                                jefe.setText("Trabajando");
                            }else{
                                jefe.setText("Subiendo copas");
                            }
                        mutexWorkJefazo.release();
                        
                        mutexWorkManager.acquire();
                        if (Main.managerWorking){
                            gerente.setText("Trabajando");
                        }else{
                            gerente.setText("Vigilando");
                        }
                        mutexWorkManager.release();
                        
                        Thread.sleep((long)endTime);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error en la app", "ERROR", JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    }
                }
            }
        };
        Thread start = new Thread(r);
        start.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pines = new javax.swing.JTextField();
        camaras = new javax.swing.JTextField();
        botones = new javax.swing.JTextField();
        produPin = new javax.swing.JTextField();
        gerente = new javax.swing.JTextField();
        produPantalla = new javax.swing.JTextField();
        produBoton = new javax.swing.JTextField();
        produCamara = new javax.swing.JTextField();
        quitPantalla = new javax.swing.JButton();
        plusPantalla = new javax.swing.JButton();
        quitBoton = new javax.swing.JButton();
        plusBoton = new javax.swing.JButton();
        quitCamara = new javax.swing.JButton();
        plusCamara = new javax.swing.JButton();
        quitPin = new javax.swing.JButton();
        plusPin = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        quitEnsam = new javax.swing.JButton();
        plusEnsam = new javax.swing.JButton();
        pantallas = new javax.swing.JTextField();
        telefonos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ensamblador = new javax.swing.JTextField();
        ganancias = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jefe = new javax.swing.JTextField();
        gastos = new javax.swing.JButton();
        entregados = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        endDay = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        tuggle = new javax.swing.JTextField();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Pines:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ganancias:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Telefonos:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Botones:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Camaras:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        pines.setEditable(false);
        pines.setBackground(new java.awt.Color(0, 0, 0));
        pines.setForeground(new java.awt.Color(255, 255, 255));
        pines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinesActionPerformed(evt);
            }
        });
        jPanel1.add(pines, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, 80, -1));

        camaras.setEditable(false);
        camaras.setBackground(new java.awt.Color(0, 0, 0));
        camaras.setForeground(new java.awt.Color(255, 255, 255));
        camaras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camarasActionPerformed(evt);
            }
        });
        jPanel1.add(camaras, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 80, -1));

        botones.setEditable(false);
        botones.setBackground(new java.awt.Color(0, 0, 0));
        botones.setForeground(new java.awt.Color(255, 255, 255));
        botones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonesActionPerformed(evt);
            }
        });
        jPanel1.add(botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 80, -1));

        produPin.setEditable(false);
        produPin.setBackground(new java.awt.Color(0, 0, 0));
        produPin.setForeground(new java.awt.Color(255, 255, 255));
        produPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produPinActionPerformed(evt);
            }
        });
        jPanel1.add(produPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 80, -1));

        gerente.setEditable(false);
        gerente.setBackground(new java.awt.Color(0, 0, 0));
        gerente.setForeground(new java.awt.Color(255, 255, 255));
        gerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenteActionPerformed(evt);
            }
        });
        jPanel1.add(gerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 220, -1));

        produPantalla.setEditable(false);
        produPantalla.setBackground(new java.awt.Color(0, 0, 0));
        produPantalla.setForeground(new java.awt.Color(255, 255, 255));
        produPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produPantallaActionPerformed(evt);
            }
        });
        jPanel1.add(produPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 80, -1));

        produBoton.setEditable(false);
        produBoton.setBackground(new java.awt.Color(0, 0, 0));
        produBoton.setForeground(new java.awt.Color(255, 255, 255));
        produBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produBotonActionPerformed(evt);
            }
        });
        jPanel1.add(produBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 80, -1));

        produCamara.setEditable(false);
        produCamara.setBackground(new java.awt.Color(0, 0, 0));
        produCamara.setForeground(new java.awt.Color(255, 255, 255));
        produCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produCamaraActionPerformed(evt);
            }
        });
        jPanel1.add(produCamara, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 80, -1));

        quitPantalla.setText("Desasignar productor");
        quitPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitPantallaActionPerformed(evt);
            }
        });
        jPanel1.add(quitPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 180, -1));

        plusPantalla.setText("Asignar productor");
        plusPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusPantallaActionPerformed(evt);
            }
        });
        jPanel1.add(plusPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 180, -1));

        quitBoton.setText("Desasignar productor");
        quitBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBotonActionPerformed(evt);
            }
        });
        jPanel1.add(quitBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 160, -1));

        plusBoton.setText("Asignar productor");
        plusBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusBotonActionPerformed(evt);
            }
        });
        jPanel1.add(plusBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 160, -1));

        quitCamara.setText("Desasignar productor");
        quitCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitCamaraActionPerformed(evt);
            }
        });
        jPanel1.add(quitCamara, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 170, -1));

        plusCamara.setText("Asignar productor");
        plusCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusCamaraActionPerformed(evt);
            }
        });
        jPanel1.add(plusCamara, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 170, -1));

        quitPin.setText("Desasignar productor");
        quitPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitPinActionPerformed(evt);
            }
        });
        jPanel1.add(quitPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 160, -1));

        plusPin.setText("Asignar productor");
        plusPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusPinActionPerformed(evt);
            }
        });
        jPanel1.add(plusPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, 160, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Productores:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Pantallas:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        quitEnsam.setText("Desasignar ensamblador");
        quitEnsam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitEnsamActionPerformed(evt);
            }
        });
        jPanel1.add(quitEnsam, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 180, -1));

        plusEnsam.setText("Asignar ensamblador");
        plusEnsam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusEnsamActionPerformed(evt);
            }
        });
        jPanel1.add(plusEnsam, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 180, -1));

        pantallas.setEditable(false);
        pantallas.setBackground(new java.awt.Color(0, 0, 0));
        pantallas.setForeground(new java.awt.Color(255, 255, 255));
        pantallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pantallasActionPerformed(evt);
            }
        });
        jPanel1.add(pantallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 80, -1));

        telefonos.setEditable(false);
        telefonos.setBackground(new java.awt.Color(0, 0, 0));
        telefonos.setForeground(new java.awt.Color(255, 255, 255));
        telefonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonosActionPerformed(evt);
            }
        });
        jPanel1.add(telefonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 80, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ensambladores:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Gerente:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, -1, -1));

        ensamblador.setEditable(false);
        ensamblador.setBackground(new java.awt.Color(0, 0, 0));
        ensamblador.setForeground(new java.awt.Color(255, 255, 255));
        ensamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ensambladorActionPerformed(evt);
            }
        });
        jPanel1.add(ensamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 80, -1));

        ganancias.setEditable(false);
        ganancias.setBackground(new java.awt.Color(0, 0, 0));
        ganancias.setForeground(new java.awt.Color(255, 255, 255));
        ganancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gananciasActionPerformed(evt);
            }
        });
        jPanel1.add(ganancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 530, 190, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Jefe:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, -1, -1));

        jefe.setEditable(false);
        jefe.setBackground(new java.awt.Color(0, 0, 0));
        jefe.setForeground(new java.awt.Color(255, 255, 255));
        jefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jefeActionPerformed(evt);
            }
        });
        jPanel1.add(jefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 220, -1));

        gastos.setText("Gastos");
        gastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gastosActionPerformed(evt);
            }
        });
        jPanel1.add(gastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 530, -1, -1));

        entregados.setEditable(false);
        entregados.setBackground(new java.awt.Color(0, 0, 0));
        entregados.setForeground(new java.awt.Color(255, 255, 255));
        entregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entregadosActionPerformed(evt);
            }
        });
        jPanel1.add(entregados, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, 190, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Telefonos totales entregados:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, -1, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Dias para la entrega:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, -1, -1));

        endDay.setEditable(false);
        endDay.setBackground(new java.awt.Color(0, 0, 0));
        endDay.setForeground(new java.awt.Color(255, 255, 255));
        endDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDayActionPerformed(evt);
            }
        });
        jPanel1.add(endDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 190, -1));

        jToggleButton1.setText("Cambiar tel??fono");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, -1, -1));

        tuggle.setEditable(false);
        tuggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuggleActionPerformed(evt);
            }
        });
        jPanel1.add(tuggle, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 90, 30));

        close.setText("x");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pinesActionPerformed

    private void camarasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camarasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camarasActionPerformed

    private void botonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonesActionPerformed

    private void produPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produPinActionPerformed

    private void gerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gerenteActionPerformed

    private void produPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produPantallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produPantallaActionPerformed

    private void produBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produBotonActionPerformed

    private void produCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produCamaraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produCamaraActionPerformed

    private void quitPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitPantallaActionPerformed
        try{
            if(Main.dataTXT[6] > 1){
                Main.dataTXT[6] -=1;
                Main.amtProdscreen[countProdScreens].setHired(false);
                
            }else{
                JOptionPane.showMessageDialog(null, "No puede despedir a todos los productores.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecuci??n del comando", "ERROR", JOptionPane.ERROR_MESSAGE);    
        }
    }//GEN-LAST:event_quitPantallaActionPerformed

    private void plusPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusPantallaActionPerformed
        try{
            if(Main.dataTXT[6] < Main.maxProd){
           
                Main.amtProdscreen[countProdScreens] = new ProduPantallas(Main.pantallas, mutexScreens, Main.semConsScreens, Main.semProdScreens, Main.semSalScreens, Main.salScreens);
                Main.amtProdscreen[countProdScreens].start();
                Main.dataTXT[6] +=1;
        }else{
            JOptionPane.showMessageDialog(null, "No puede exceder el n??mero m??ximo de productores.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecuci??n del comando", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_plusPantallaActionPerformed

    private void quitBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBotonActionPerformed
        try{
            if(Main.dataTXT[7] > 1){
                Main.dataTXT[7] -=1;
                Main.amtProdbutt[countProdButts].setHired(false);
                
            }else{
                JOptionPane.showMessageDialog(null, "No puede despedir a todos los productores.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecuci??n del comando", "ERROR", JOptionPane.ERROR_MESSAGE);    
        }
    }//GEN-LAST:event_quitBotonActionPerformed

    private void plusBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusBotonActionPerformed
        try{
            if(Main.dataTXT[7] < Main.maxProd){
           
                Main.amtProdbutt[countProdButts] = new ProduBotones(Main.botones, mutexButt, Main.semConsButt, Main.semProdButt,Main.semSalButts,Main.salButts);
                Main.amtProdbutt[countProdButts].start();
                Main.dataTXT[7] +=1;

        }else{
            JOptionPane.showMessageDialog(null, "No puede exceder el n??mero m??ximo de productores.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecuci??n del comando", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_plusBotonActionPerformed

    private void quitCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitCamaraActionPerformed
        try{
            if(Main.dataTXT[8] > 1){
                Main.dataTXT[8] -=1;
                Main.amtProdcam[countProdCams].setHired(false);
                
            }else{
                JOptionPane.showMessageDialog(null, "No puede despedir a todos los productores.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecuci??n del comando", "ERROR", JOptionPane.ERROR_MESSAGE);    
        }
    }//GEN-LAST:event_quitCamaraActionPerformed

    private void plusCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusCamaraActionPerformed
        try{
            if(Main.dataTXT[8] < Main.maxProd){
           
                Main.amtProdcam[countProdCams] = new ProduCamaras(Main.camaras, mutexCams, Main.semConsCams, Main.semProdCams, Main.semSalCams, Main.salCams);
                Main.amtProdcam[countProdCams].start();
                Main.dataTXT[8] +=1;
 
        }else{
            JOptionPane.showMessageDialog(null, "No puede exceder el n??mero m??ximo de productores.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecuci??n del comando", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_plusCamaraActionPerformed

    private void quitPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitPinActionPerformed
        try{
            if(Main.dataTXT[9] > 1){
                Main.dataTXT[9] -=1;
                Main.amtProdpin[countProdPins].setHired(false);
                
            }else{
                JOptionPane.showMessageDialog(null, "No puede despedir a todos los productores.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecuci??n del comando", "ERROR", JOptionPane.ERROR_MESSAGE);    
        }
    }//GEN-LAST:event_quitPinActionPerformed

    private void plusPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusPinActionPerformed
        try{
            if(Main.dataTXT[9] < Main.maxProd){
           
                Main.amtProdpin[countProdPins] = new ProduPin(Main.pines, mutexPins, Main.semConsPins, Main.semProdPins, Main.semSalPins, Main.salPins);
                Main.amtProdpin[countProdPins].start();
                Main.dataTXT[9] +=1;

        }else{
            JOptionPane.showMessageDialog(null, "No puede exceder el n??mero m??ximo de productores.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecuci??n del comando", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_plusPinActionPerformed

    private void quitEnsamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitEnsamActionPerformed
        try{
            if(Main.dataTXT[10] > 1){
                Main.dataTXT[10] -=1;
                Main.amtProdscreen[countProdScreens].setHired(false);
                
            }else{
                JOptionPane.showMessageDialog(null, "No puede despedir a todos los ensambladores.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecuci??n del comando", "ERROR", JOptionPane.ERROR_MESSAGE);    
        }
    }//GEN-LAST:event_quitEnsamActionPerformed

    private void plusEnsamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusEnsamActionPerformed
        try{
            if(Main.dataTXT[10] < Main.maxProd){
           
                Main.amtAssembler[countAssembler] = new Assembler(Main.mutexScreens,
                Main.mutexButt,
                Main.mutexPins,
                Main.mutexCams,
                Main.mutexPhones,
                Main.semConsScreens,
                Main.semConsButt,
                Main.semConsPins,
                Main.semConsCams,
                Main.semProdScreens,
                Main.semProdButt,
                Main.semProdPins,
                Main.semProdCams);
                Main.amtAssembler[countAssembler].start();
                Main.dataTXT[10] +=1;

        }else{
            JOptionPane.showMessageDialog(null, "No puede exceder el n??mero m??ximo de productores.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecuci??n del comando", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_plusEnsamActionPerformed

    private void pantallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pantallasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pantallasActionPerformed

    private void telefonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonosActionPerformed

    private void ensambladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ensambladorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ensambladorActionPerformed

    private void gananciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gananciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gananciasActionPerformed

    private void jefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jefeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jefeActionPerformed

    private void gastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gastosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gastosActionPerformed

    private void entregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entregadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entregadosActionPerformed

    private void endDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDayActionPerformed

    private void tuggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuggleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuggleActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        try{
            mutexChange.acquire();
        if(Main.telefono == "Xperia Pro-I"){
            Main.telefono = "Xperia 10 IV";
        } else{
            Main.telefono = "Xperia Pro-I";
        }
        Main.cdi = Main.map.get(Main.telefono)[0];
        Main.pantallas = Main.map.get(Main.telefono)[1];
        Main.botones = Main.map.get(Main.telefono)[2];
        Main.pines = Main.map.get(Main.telefono)[3];
        Main.camaras = Main.map.get(Main.telefono)[4];
        Main.needPantalla = Main.map.get(Main.telefono)[5];
        Main.needPines = Main.map.get(Main.telefono)[6];
        Main.needCamaras = Main.map.get(Main.telefono)[7];
        Main.price = Main.map.get(Main.telefono)[8];
        Main.maxProd = 10 + Main.cdi;
        mutexChange.release();
        
        Main.dataTXT[6] = 1;
        Main.dataTXT[7] = 1;
        Main.dataTXT[8] = 1;
        Main.dataTXT[9] = 1;      
        Main.dataTXT[10] = 1;
        Main.buttons = 0;
        Main.cams = 0;
        Main.screens = 0;
        Main.pins = 0;
        Main.totalPhones = 0;
        Main.phones = 0;
        Main.semProdButt = new Semaphore(45);
        Main.semConsButt = new Semaphore(0);
        Main.mutexButt = new Semaphore(1);
        Main.semProdScreens = new Semaphore(40);
        Main.semConsScreens = new Semaphore(0);
        Main.mutexScreens = new Semaphore(1);
        Main.semProdPins = new Semaphore(15);
        Main.semConsPins = new Semaphore(0);
        Main.mutexPins = new Semaphore(1);
        Main.semProdCams = new Semaphore(20);
        Main.semConsCams = new Semaphore(0);
        Main.mutexCams = new Semaphore(1);
        Main.mutexPhones = new Semaphore(1);
        Main.mutexDays = new Semaphore(1);
        Main.mutexWorkJefazo = new Semaphore(1);
        Main.mutexWorkManager = new Semaphore(1);
        Main.mutexTotalDelivery = new Semaphore(1);
        
        Main.semSalCams.acquire();
        Main.semSalButts.acquire();
        Main.semSalPins.acquire();
        Main.semSalScreens.acquire();
        Main.semSalAss.acquire();
        Main.semSalBoss.acquire();
        Main.semSalManager.acquire();
        profit = 0;
        Main.salButts = 0;
        Main.salCams = 0;
        Main.salPins = 0;
        Main.salScreens = 0;
        Main.salAss = 0;
        Main.salBoss = 0;
        Main.salManager = 0;
        Main.semSalCams.release();
        Main.semSalButts.release();
        Main.semSalPins.release();
        Main.semSalScreens.release();
        Main.semSalAss.release();
        Main.semSalBoss.release();
        Main.semSalManager.release();
        
        } catch (Exception e){
            
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        Menu m = new Menu();
        this.setVisible(false);
    }//GEN-LAST:event_closeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField botones;
    private javax.swing.JTextField camaras;
    private javax.swing.JButton close;
    private javax.swing.JTextField endDay;
    private javax.swing.JTextField ensamblador;
    private javax.swing.JTextField entregados;
    private javax.swing.JTextField ganancias;
    private javax.swing.JButton gastos;
    private javax.swing.JTextField gerente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jefe;
    private javax.swing.JTextField pantallas;
    private javax.swing.JTextField pines;
    private javax.swing.JButton plusBoton;
    private javax.swing.JButton plusCamara;
    private javax.swing.JButton plusEnsam;
    private javax.swing.JButton plusPantalla;
    private javax.swing.JButton plusPin;
    private javax.swing.JTextField produBoton;
    private javax.swing.JTextField produCamara;
    private javax.swing.JTextField produPantalla;
    private javax.swing.JTextField produPin;
    private javax.swing.JButton quitBoton;
    private javax.swing.JButton quitCamara;
    private javax.swing.JButton quitEnsam;
    private javax.swing.JButton quitPantalla;
    private javax.swing.JButton quitPin;
    private javax.swing.JTextField telefonos;
    private javax.swing.JTextField tuggle;
    // End of variables declaration//GEN-END:variables
}
