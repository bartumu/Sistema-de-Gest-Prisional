/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

/**
 *
 * @author Melhor De Mim
 */
import CONTROLLER.*;
import MODEL.*;
import MODEL.Usuario;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.time.format.DateTimeFormatter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    Color defaultColor, ClickedColor, inDefaultColor, inClickedColor;
    CardLayout cardLayout;
    Prisioneiro Pris;
    EJulgado ej;
    EJulgadoPK ejulgadoPK;
    Julgamento julgamento;
    JulgamentoPK julgamentoPK;
    Cela c;
    CelaPK celaPK = new CelaPK();
    CelaController cController = new CelaController();
    Esquadra esq;
    EsquadraController esqCrontroller;
    Crime crime;
    CrimePK crimePK;
    CrimeLocal crimeLocal;
    Funcionario f = new Funcionario();
    FuncionarioController fController = new FuncionarioController();
    DefaultTableModel tbModelF = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;

        }
    };
    DefaultTableModel tbModelF1 = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;

        }
    };
    DefaultTableModel tbModelPris;
    PrisioneiroController prisController;
    BlocoController bController = new BlocoController();
    TurnoController tController;
    Bloco b = new Bloco();
    Turno t = new Turno();

    public Home(Funcionario f) {
        initComponents();

        userNameLabel.setText(f.getNome());

        defaultColor = new Color(60, 179, 113);
        ClickedColor = new Color(204, 255, 204);
        inDefaultColor = new Color(204, 255, 204);
        inClickedColor = new Color(60, 179, 113);
        btnGuardaLiberar.setEnabled(false);
        btnAbsolver.setEnabled(false);

        cardLayout = (CardLayout) (pnlCards.getLayout());
        cardLayout.show(pnlCards, "HomePanel");
//        imgLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Melhor De Mim\\OneDrive - academiabai.co.ao\\Projecto De Pro Implementação\\SistGP\\src\\IMG\\Icons-Bencao-04.png"));

    }

    private void CarregarCombo(CelaController cController) {
        CelaCombo.removeAllItems();
        for (int i = 0; i < cController.AcharCelasNormais(celaPK).size(); i++) {

            CelaCombo.addItem(cController.AcharCelasNormais(celaPK).get(i).getDescricao());
        }
    }

    private void CarregarCombo(BlocoController bController) {
        FuncBlocoCombo.removeAllItems();
        for (int i = 0; i < bController.findAll().size(); i++) {

            FuncBlocoCombo.addItem(bController.findAll().get(i).getDescricao());
        }
    }

    private void CarregarCombo(TurnoController tController) {
        tController = new TurnoController();
        TurnoCombo.removeAllItems();
        for (int i = 0; i < tController.findAll().size(); i++) {

            TurnoCombo.addItem(tController.findAll().get(i).getTurno());
        }
    }

    private void CarregarTabelaPris(JTable a) {
        Object[] columnNames = {"Nº Do BI", "Nome", "Sexo", "Crime", "Cela", "Pena"};
        var criController = new CrimeController();
        var ejController = new EJulgadoController();
        prisController = new PrisioneiroController();
        cController = new CelaController();

        tbModelPris = new DefaultTableModel(columnNames, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };
        for (int i = 0; i < prisController.findAll().size(); i++) {

            Object[] lista = {
                prisController.findAll().get(i).getNumBI(),
                prisController.findAll().get(i).getNome(),
                prisController.findAll().get(i).getSexo(),
                criController.Find(prisController.findAll().get(i).getNumBI()).get(i).getDescricao(),
                cController.Find(prisController.findAll().get(i).getIdBloco().getCelaPK().getIdBloco()).get(i).getCelaPK().getDescricao(),
                ejController.Find(prisController.findAll().get(i).getNumBI()).get(i).getPena()
            };

            tbModelPris.addRow(lista);
        }
        a.setModel(tbModelPris);
    }

    private void ValidarData(String data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        try {
            formato.parse(data);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato data errada, tem que ser Ano-Mes-Dia");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        btnGuardas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPris = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRelatorio = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        imgLabel = new javax.swing.JLabel();
        letterLabel = new javax.swing.JLabel();
        btnSair1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        pnlCards = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRelactorio = new javax.swing.JTable();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lbldataEntrada = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        lblCrime = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        lblEsquadra = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        lblTribunal = new javax.swing.JLabel();
        jSeparator29 = new javax.swing.JSeparator();
        lblPena = new javax.swing.JLabel();
        jSeparator30 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        lblBloco = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator31 = new javax.swing.JSeparator();
        jSeparator32 = new javax.swing.JSeparator();
        lblCela = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        prisPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtDataJulga = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPrisioneiro = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtDataNasc = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtDataEntrada = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        txtEstadoCivil = new javax.swing.JTextField();
        txtNumBI = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        CelaCombo = new javax.swing.JComboBox<>();
        txtCrime = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        txtEsquadra = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        txtEsquadraLocal = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        txtTribunal = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        txtPena = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        txtDataCrime = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        txtLocalCrime = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        btnCad = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAbsolver = new javax.swing.JButton();
        rdbM = new javax.swing.JRadioButton();
        rdbF = new javax.swing.JRadioButton();
        GuardPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGuarda = new javax.swing.JTable();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        btnEdTurno = new javax.swing.JButton();
        btnGuardaLiberar = new javax.swing.JButton();
        FuncBlocoCombo = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGuardaEdit = new javax.swing.JTable();
        jSeparator21 = new javax.swing.JSeparator();
        txtNomeGuarda = new javax.swing.JTextField();
        TurnoCombo = new javax.swing.JComboBox<>();
        HomePanel = new javax.swing.JPanel();
        imgLabel1 = new javax.swing.JLabel();
        letterLabel2 = new javax.swing.JLabel();
        letterLabel3 = new javax.swing.JLabel();
        letterLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(60, 179, 113));

        btnGuardas.setBackground(new java.awt.Color(60, 179, 113));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GUARDAS");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btnGuardasLayout = new javax.swing.GroupLayout(btnGuardas);
        btnGuardas.setLayout(btnGuardasLayout);
        btnGuardasLayout.setHorizontalGroup(
            btnGuardasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnGuardasLayout.setVerticalGroup(
            btnGuardasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        btnPris.setBackground(new java.awt.Color(60, 179, 113));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRISIONEIRO");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btnPrisLayout = new javax.swing.GroupLayout(btnPris);
        btnPris.setLayout(btnPrisLayout);
        btnPrisLayout.setHorizontalGroup(
            btnPrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnPrisLayout.setVerticalGroup(
            btnPrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        btnRelatorio.setBackground(new java.awt.Color(60, 179, 113));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RELATÓRIO");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btnRelatorioLayout = new javax.swing.GroupLayout(btnRelatorio);
        btnRelatorio.setLayout(btnRelatorioLayout);
        btnRelatorioLayout.setHorizontalGroup(
            btnRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnRelatorioLayout.setVerticalGroup(
            btnRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        letterLabel.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        letterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letterLabel.setText("H O M E");

        btnSair1.setBackground(new java.awt.Color(60, 179, 113));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SAIR");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btnSair1Layout = new javax.swing.GroupLayout(btnSair1);
        btnSair1.setLayout(btnSair1Layout);
        btnSair1Layout.setHorizontalGroup(
            btnSair1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnSair1Layout.setVerticalGroup(
            btnSair1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Usuario:");

        userNameLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        userNameLabel.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSair1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(imgLabel)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRelatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(userNameLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(letterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(letterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnPris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameLabel)
                .addGap(32, 32, 32))
        );

        jSplitPane1.setLeftComponent(jPanel2);

        pnlCards.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        tblRelactorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Sexo", "Estado Civil", "Cela", "Crime", "Pena"
            }
        ));
        tblRelactorio.setUpdateSelectionOnSort(false);
        tblRelactorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRelactorioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRelactorio);

        jSeparator20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setText("Nome:");

        lblNome.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblNome.setText("------------------------");

        lbldataEntrada.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbldataEntrada.setText("-------------");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("Data De Entrada: ");

        jSeparator26.setBackground(new java.awt.Color(255, 255, 255));

        lblCrime.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblCrime.setText("-----------------------");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setText("Crime:");

        jSeparator27.setBackground(new java.awt.Color(255, 255, 255));

        lblEsquadra.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblEsquadra.setText("-------------------");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel8.setText("Esquadra:");

        jSeparator28.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setText("Tribunal:");

        lblTribunal.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblTribunal.setText("-------------------");

        jSeparator29.setBackground(new java.awt.Color(255, 255, 255));

        lblPena.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblPena.setText("-------------------");

        jSeparator30.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel11.setText("Pena:");

        lblBloco.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblBloco.setText("-------------------");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel12.setText("Bloco:");

        jSeparator31.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator32.setBackground(new java.awt.Color(255, 255, 255));

        lblCela.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblCela.setText("-------------------");

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setText("Cela:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbldataEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCrime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEsquadra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTribunal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBloco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCela, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblNome))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(lbldataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblCrime))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblEsquadra))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblTribunal))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblPena))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lblBloco))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblCela))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        pnlCards.add(jPanel1, "RelactPanel");

        prisPanel.setBackground(new java.awt.Color(204, 255, 204));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        txtDataJulga.setBackground(new java.awt.Color(204, 255, 204));
        txtDataJulga.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtDataJulga.setText("Data Da Centença");
        txtDataJulga.setBorder(null);
        txtDataJulga.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDataJulgaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataJulgaFocusLost(evt);
            }
        });

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));

        tblPrisioneiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Sexo", "Estado Civil", "Cela", "Crime", "Pena"
            }
        ));
        jScrollPane2.setViewportView(tblPrisioneiro);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        txtNome.setBackground(new java.awt.Color(204, 255, 204));
        txtNome.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtNome.setText("Nome");
        txtNome.setBorder(null);
        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeFocusLost(evt);
            }
        });

        txtEndereco.setBackground(new java.awt.Color(204, 255, 204));
        txtEndereco.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtEndereco.setText("Endereço");
        txtEndereco.setBorder(null);
        txtEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEnderecoFocusGained(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));

        txtDataNasc.setBackground(new java.awt.Color(204, 255, 204));
        txtDataNasc.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtDataNasc.setText("Data de Nascimento");
        txtDataNasc.setBorder(null);
        txtDataNasc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDataNascFocusGained(evt);
            }
        });
        txtDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));

        txtDataEntrada.setBackground(new java.awt.Color(204, 255, 204));
        txtDataEntrada.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtDataEntrada.setText("Data de Entrada");
        txtDataEntrada.setBorder(null);
        txtDataEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDataEntradaFocusGained(evt);
            }
        });
        txtDataEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataEntradaActionPerformed(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));

        txtEstadoCivil.setBackground(new java.awt.Color(204, 255, 204));
        txtEstadoCivil.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtEstadoCivil.setText("Estado Civil");
        txtEstadoCivil.setBorder(null);
        txtEstadoCivil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEstadoCivilFocusGained(evt);
            }
        });

        txtNumBI.setBackground(new java.awt.Color(204, 255, 204));
        txtNumBI.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtNumBI.setText("Número Do BI");
        txtNumBI.setBorder(null);
        txtNumBI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumBIFocusGained(evt);
            }
        });

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));

        CelaCombo.setBackground(new java.awt.Color(204, 255, 204));
        CelaCombo.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        CelaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CELA", "Item 2", "Item 3", "Item 4" }));
        CelaCombo.setBorder(null);

        txtCrime.setBackground(new java.awt.Color(204, 255, 204));
        txtCrime.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtCrime.setText("Crime Cometido");
        txtCrime.setBorder(null);
        txtCrime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCrimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCrimeFocusLost(evt);
            }
        });

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));

        txtEsquadra.setBackground(new java.awt.Color(204, 255, 204));
        txtEsquadra.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtEsquadra.setText("Esquadra Onde Foi Registado");
        txtEsquadra.setBorder(null);
        txtEsquadra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEsquadraFocusGained(evt);
            }
        });
        txtEsquadra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEsquadraActionPerformed(evt);
            }
        });

        jSeparator11.setBackground(new java.awt.Color(255, 255, 255));

        txtEsquadraLocal.setBackground(new java.awt.Color(204, 255, 204));
        txtEsquadraLocal.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtEsquadraLocal.setText("Localização Da Equadra");
        txtEsquadraLocal.setBorder(null);
        txtEsquadraLocal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEsquadraLocalFocusGained(evt);
            }
        });

        jSeparator12.setBackground(new java.awt.Color(255, 255, 255));

        txtTribunal.setBackground(new java.awt.Color(204, 255, 204));
        txtTribunal.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtTribunal.setText("Tribunal Onde Foi julgado");
        txtTribunal.setBorder(null);
        txtTribunal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTribunalFocusGained(evt);
            }
        });

        jSeparator13.setBackground(new java.awt.Color(255, 255, 255));

        txtPena.setBackground(new java.awt.Color(204, 255, 204));
        txtPena.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtPena.setText("Pena");
        txtPena.setBorder(null);
        txtPena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPenaFocusLost(evt);
            }
        });

        jSeparator14.setBackground(new java.awt.Color(255, 255, 255));

        txtDataCrime.setBackground(new java.awt.Color(204, 255, 204));
        txtDataCrime.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtDataCrime.setText("Data Do Crime");
        txtDataCrime.setBorder(null);
        txtDataCrime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDataCrimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataCrimeFocusLost(evt);
            }
        });
        txtDataCrime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataCrimeActionPerformed(evt);
            }
        });

        jSeparator15.setBackground(new java.awt.Color(255, 255, 255));

        txtLocalCrime.setBackground(new java.awt.Color(204, 255, 204));
        txtLocalCrime.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtLocalCrime.setText("Local Do Crime");
        txtLocalCrime.setBorder(null);

        jSeparator16.setBackground(new java.awt.Color(255, 255, 255));

        btnCad.setBackground(new java.awt.Color(204, 255, 204));
        btnCad.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnCad.setText("Cadastrar");
        btnCad.setBorder(new com.formdev.flatlaf.ui.FlatRoundBorder());
        btnCad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadMouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton2.setText("Editar");
        jButton2.setBorder(new com.formdev.flatlaf.ui.FlatRoundBorder());

        btnAbsolver.setBackground(new java.awt.Color(204, 255, 204));
        btnAbsolver.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAbsolver.setText("Absolver");
        btnAbsolver.setBorder(new com.formdev.flatlaf.ui.FlatRoundBorder());
        btnAbsolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbsolverActionPerformed(evt);
            }
        });

        rdbM.setBackground(new java.awt.Color(204, 255, 204));
        rdbM.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        rdbM.setSelected(true);
        rdbM.setText("Masculino");
        rdbM.setBorder(null);
        rdbM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbMMouseClicked(evt);
            }
        });

        rdbF.setBackground(new java.awt.Color(204, 255, 204));
        rdbF.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        rdbF.setText("Feminino");
        rdbF.setBorder(null);
        rdbF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbFMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(txtEstadoCivil)
                                .addComponent(jSeparator2)
                                .addComponent(txtEndereco)
                                .addComponent(txtNome)
                                .addComponent(jSeparator1)
                                .addComponent(jSeparator7)
                                .addComponent(jSeparator4)
                                .addComponent(jSeparator3))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rdbM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbF)))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEsquadra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLocalCrime, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataCrime)
                                    .addComponent(jSeparator15)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNumBI, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCrime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDataEntrada, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator6)
                                        .addComponent(CelaCombo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator13)
                                            .addComponent(txtTribunal)
                                            .addComponent(jSeparator12)
                                            .addComponent(txtEsquadraLocal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtPena)
                                    .addComponent(jSeparator14)
                                    .addComponent(txtDataJulga)
                                    .addComponent(jSeparator9))))
                        .addGap(43, 43, 43))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(btnCad, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbsolver, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CelaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdbM)
                                    .addComponent(rdbF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtNumBI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(txtCrime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEsquadraLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTribunal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataJulga, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPena, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(txtDataCrime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(txtEsquadra, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalCrime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbsolver, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout prisPanelLayout = new javax.swing.GroupLayout(prisPanel);
        prisPanel.setLayout(prisPanelLayout);
        prisPanelLayout.setHorizontalGroup(
            prisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        prisPanelLayout.setVerticalGroup(
            prisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prisPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCards.add(prisPanel, "prisPanel");

        GuardPanel.setBackground(new java.awt.Color(204, 255, 204));

        tblGuarda.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGuarda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGuardaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblGuarda);

        jSeparator17.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator18.setBackground(new java.awt.Color(255, 255, 255));

        btnEdTurno.setBackground(new java.awt.Color(204, 255, 204));
        btnEdTurno.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEdTurno.setText("Escalar");
        btnEdTurno.setBorder(new com.formdev.flatlaf.ui.FlatRoundBorder());
        btnEdTurno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdTurnoMouseClicked(evt);
            }
        });
        btnEdTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdTurnoActionPerformed(evt);
            }
        });

        btnGuardaLiberar.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardaLiberar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGuardaLiberar.setText("Liberar");
        btnGuardaLiberar.setBorder(new com.formdev.flatlaf.ui.FlatRoundBorder());
        btnGuardaLiberar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardaLiberarMouseClicked(evt);
            }
        });

        FuncBlocoCombo.setBackground(new java.awt.Color(204, 255, 204));
        FuncBlocoCombo.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        FuncBlocoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CELA", "Item 2", "Item 3", "Item 4" }));
        FuncBlocoCombo.setBorder(null);

        tblGuardaEdit.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblGuardaEdit);

        jSeparator21.setBackground(new java.awt.Color(255, 255, 255));

        txtNomeGuarda.setBackground(new java.awt.Color(204, 255, 204));
        txtNomeGuarda.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtNomeGuarda.setText("Nome");
        txtNomeGuarda.setBorder(null);
        txtNomeGuarda.setEnabled(false);
        txtNomeGuarda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeGuardaFocusGained(evt);
            }
        });
        txtNomeGuarda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeGuardaActionPerformed(evt);
            }
        });

        TurnoCombo.setBackground(new java.awt.Color(204, 255, 204));
        TurnoCombo.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        TurnoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CELA", "Item 2", "Item 3", "Item 4" }));
        TurnoCombo.setBorder(null);

        javax.swing.GroupLayout GuardPanelLayout = new javax.swing.GroupLayout(GuardPanel);
        GuardPanel.setLayout(GuardPanelLayout);
        GuardPanelLayout.setHorizontalGroup(
            GuardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GuardPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(GuardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GuardPanelLayout.createSequentialGroup()
                        .addGroup(GuardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(GuardPanelLayout.createSequentialGroup()
                                .addGroup(GuardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomeGuarda, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(jSeparator21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TurnoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(GuardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FuncBlocoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(btnEdTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardaLiberar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        GuardPanelLayout.setVerticalGroup(
            GuardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GuardPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(GuardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GuardPanelLayout.createSequentialGroup()
                        .addGroup(GuardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeGuarda, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TurnoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FuncBlocoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GuardPanelLayout.createSequentialGroup()
                        .addGroup(GuardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardaLiberar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pnlCards.add(GuardPanel, "GuardPanel");

        HomePanel.setBackground(new java.awt.Color(204, 255, 204));

        imgLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Melhor De Mim\\OneDrive - academiabai.co.ao\\Projecto De Pro Implementação\\img\\Icons-Bencao-04.png")); // NOI18N

        letterLabel2.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        letterLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letterLabel2.setText("S I S T E M A  D E  G E S T Ã O  ");

        letterLabel3.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        letterLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letterLabel3.setText("Bem Vindo");

        letterLabel4.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        letterLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letterLabel4.setText("P R I S I O N A L");

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomePanelLayout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(imgLabel1))
                    .addGroup(HomePanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(letterLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HomePanelLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(letterLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HomePanelLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(letterLabel4)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(imgLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letterLabel3)
                .addGap(18, 18, 18)
                .addComponent(letterLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letterLabel4)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        pnlCards.add(HomePanel, "HomePanel");

        jSplitPane1.setRightComponent(pnlCards);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseReleased

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        dispose();
        new Login().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        btnRelatorio.setBackground(defaultColor);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseReleased

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        btnRelatorio.setBackground(ClickedColor);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        imgLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Melhor De Mim\\OneDrive - academiabai.co.ao\\Projecto De Pro Implementação\\SistGP\\src\\IMG\\Icons-Bencao-03.png"));
        letterLabel.setText("RELACTÓRIO");
        cardLayout.show(pnlCards, "RelactPanel");
        CarregarTabelaPris(tblRelactorio);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        btnPris.setBackground(defaultColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseReleased

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        btnPris.setBackground(ClickedColor);
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        imgLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Melhor De Mim\\OneDrive - academiabai.co.ao\\Projecto De Pro Implementação\\SistGP\\src\\IMG\\Icons-Bencao-06.png"));
        letterLabel.setText("PRISIONEIROS");
        cardLayout.show(pnlCards, "prisPanel");
        CarregarCombo(cController);
        CarregarTabelaPris(tblPrisioneiro);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
        btnGuardas.setBackground(defaultColor);
    }//GEN-LAST:event_jLabel1MouseReleased

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        btnGuardas.setBackground(ClickedColor);
        //        jLabel1.setForeground(white);
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        imgLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Melhor De Mim\\OneDrive - academiabai.co.ao\\Projecto De Pro Implementação\\SistGP\\src\\IMG\\Icons-Bencao-02.png"));
        letterLabel.setText("GUARDAS");
        cardLayout.show(pnlCards, "GuardPanel");
        CarregarCombo(bController);
        CarregarCombo(tController);
        tbModelF = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };

        tbModelF1 = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };

        fController.CarregarTabelaG(tbModelF, tblGuarda);
        fController.CarregarTabelaG1(tbModelF1, tblGuardaEdit);

    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtPenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPenaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPenaFocusLost

    private void txtPenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPenaFocusGained
        // TODO add your handling code here:
        txtPena.setText("");
    }//GEN-LAST:event_txtPenaFocusGained

    private void txtTribunalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTribunalFocusGained
        // TODO add your handling code here:
        txtTribunal.setText("");
    }//GEN-LAST:event_txtTribunalFocusGained

    private void txtEsquadraLocalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEsquadraLocalFocusGained
        // TODO add your handling code here:
        txtEsquadraLocal.setText("");
    }//GEN-LAST:event_txtEsquadraLocalFocusGained

    private void txtEsquadraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEsquadraFocusGained
        // TODO add your handling code here:
        txtEsquadra.setText("");
    }//GEN-LAST:event_txtEsquadraFocusGained

    private void txtCrimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCrimeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCrimeFocusLost

    private void txtCrimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCrimeFocusGained
        // TODO add your handling code here:
        txtCrime.setText("");
    }//GEN-LAST:event_txtCrimeFocusGained

    private void txtNumBIFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumBIFocusGained
        // TODO add your handling code here:
        txtNumBI.setText("");
    }//GEN-LAST:event_txtNumBIFocusGained

    private void txtEstadoCivilFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstadoCivilFocusGained
        // TODO add your handling code here:
        txtEstadoCivil.setText("");
    }//GEN-LAST:event_txtEstadoCivilFocusGained

    private void txtDataEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataEntradaActionPerformed

    private void txtDataEntradaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataEntradaFocusGained
        // TODO add your handling code here:
        txtDataEntrada.setText("");
    }//GEN-LAST:event_txtDataEntradaFocusGained

    private void txtDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascActionPerformed

    private void txtDataNascFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataNascFocusGained
        // TODO add your handling code here:
        txtDataNasc.setText("");
    }//GEN-LAST:event_txtDataNascFocusGained

    private void txtEnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnderecoFocusGained
        // TODO add your handling code here:
        txtEndereco.setText("");
    }//GEN-LAST:event_txtEnderecoFocusGained

    private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
        if (txtNome.getText().equals("")) {
            txtNome.setText("Nome");
        }
    }//GEN-LAST:event_txtNomeFocusLost

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        txtNome.setText("");
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtDataJulgaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataJulgaFocusLost
        // TODO add your handling code here:
        if (txtDataJulga.getText().equals("")) {
            txtDataJulga.setText("Descrição do Bloco");
        }
    }//GEN-LAST:event_txtDataJulgaFocusLost

    private void txtDataJulgaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataJulgaFocusGained
        // TODO add your handling code here:
        txtDataJulga.setText("");
    }//GEN-LAST:event_txtDataJulgaFocusGained

    private void txtEsquadraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEsquadraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEsquadraActionPerformed

    private void txtDataCrimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataCrimeFocusGained
        // TODO add your handling code here:
        txtDataCrime.setText("");
    }//GEN-LAST:event_txtDataCrimeFocusGained

    private void txtDataCrimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataCrimeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataCrimeFocusLost

    private void txtDataCrimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataCrimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataCrimeActionPerformed

    private void btnCadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadMouseClicked
        // TODO add your handling code here:

        try {
            prisController = new PrisioneiroController();
            Pris = new Prisioneiro();
            celaPK = new CelaPK();
            c = new Cela();
            cController = new CelaController();

            Pris.setNome(txtNome.getText());
            Pris.setEndereco(txtEndereco.getText());
            Pris.setEstadoCivil(txtEstadoCivil.getText());
            ValidarData(txtDataEntrada.getText());
            Pris.setDataEntrada(txtDataEntrada.getText());
            ValidarData(txtDataNasc.getText());
            Pris.setDataNasc(txtDataNasc.getText());
            Pris.setNumBI(txtNumBI.getText());
            if (rdbF.isSelected()) {
                Pris.setSexo("F");
            } else {
                Pris.setSexo("M");
            }
            celaPK.setDescricao((String) CelaCombo.getSelectedItem());
            celaPK.setIdBloco(cController.findIdBloco(celaPK));
            c.setCelaPK(celaPK);
            Pris.setIdBloco(c);
            prisController.Inserir(Pris);

            esq = new Esquadra();
            esqCrontroller = new EsquadraController();
            esq.setDescricao(txtEsquadra.getText());
            esq.setLocal(txtEsquadraLocal.getText());
            esqCrontroller.Inserir(esq);

            julgamentoPK = new JulgamentoPK();
            var jController = new JulgamentoController();
            ValidarData(txtDataJulga.getText());
            julgamentoPK.setData(txtDataJulga.getText());
            julgamentoPK.setTribunal(txtTribunal.getText());
            jController.Inserir(julgamentoPK);

            ejulgadoPK = new EJulgadoPK();
            ej = new EJulgado();
            var ejController = new EJulgadoController();
            ejulgadoPK.setIdJulgamento(jController.findIdJulgamento(julgamentoPK));
            ejulgadoPK.setNumBI(txtNumBI.getText());
            ej.setEJulgadoPK(ejulgadoPK);
            ej.setPena(txtPena.getText());
            ejController.Inserir(ej);

            crime = new Crime();
            crimePK = new CrimePK();
            crimeLocal = new CrimeLocal();
            var criController = new CrimeController();
            var cLocal = new CrimeLocalController();
            crime.setDescricao(txtCrime.getText());
            crimePK.setNumBI(txtNumBI.getText());
            ValidarData(txtDataCrime.getText());
            crimePK.setData(txtDataCrime.getText());
            crimeLocal.setLocal(txtLocalCrime.getText());
            crimeLocal.setNumBI(txtNumBI.getText());
            crime.setCrimeLocal(crimeLocal);
            crime.setCrimePK(crimePK);
            esq.setIdEsquadra(esqCrontroller.findIdEsquadra(esq));
            crime.setIdEsquadra(esq);
            criController.Inserir(crime);
            cLocal.Inserir(crimeLocal);

            JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            txtPena.setText("Pena");
            txtTribunal.setText("Tribunal Em Que foi julgado");
            txtEsquadraLocal.setText("Localização da Esquadra");
            txtEsquadra.setText("Esquadra em Que foi registado Crime");
            txtCrime.setText("Crime Cometido");
            txtLocalCrime.setText("Local do Crime");
            txtNumBI.setText("Nº Do BI");
            txtEstadoCivil.setText("Estado Civil");
            txtDataEntrada.setText("Data de Entrada");
            txtDataNasc.setText("Data de Nascimento");
            txtEndereco.setText("Endereço");
            txtNome.setText("Nome completo");
            txtDataJulga.setText("Data Do Julgamento");
            txtDataCrime.setText("Data Do Crime");
            CelaCombo.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnCadMouseClicked

    private void rdbMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbMMouseClicked
        // TODO add your handling code here:
        rdbF.setSelected(false);
    }//GEN-LAST:event_rdbMMouseClicked

    private void rdbFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbFMouseClicked
        // TODO add your handling code here:

        rdbM.setSelected(false);
    }//GEN-LAST:event_rdbFMouseClicked

    private void tblRelactorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRelactorioMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int j = tblRelactorio.getSelectedRow();
            var pris = new Prisioneiro();
            var jPK = new JulgamentoPK();
            var Cr = new Crime();
            var c = new CelaPK();
            var b = new Bloco();
            var ej = new EJulgado();
            var esq = new Esquadra();
            pris.setNumBI(tbModelPris.getValueAt(j, 0).toString());
            var pController = new PrisioneiroController();
            pController.CarregarRelact(pris, Cr, c, b, ej, jPK, esq);

            lblNome.setText(pris.getNome());
            lblBloco.setText(b.getDescricao());
            lblCela.setText(c.getDescricao());
            lblCrime.setText(Cr.getDescricao());
            lblEsquadra.setText(esq.getDescricao());
            lblPena.setText(ej.getPena());
            lblTribunal.setText(jPK.getTribunal());
            lbldataEntrada.setText(pris.getDataEntrada());

        }
    }//GEN-LAST:event_tblRelactorioMouseClicked

    private void btnAbsolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbsolverActionPerformed
        // TODO add your handling code here:
        int j = tblPrisioneiro.getSelectedRow();
        Pris = new Prisioneiro();
        prisController = new PrisioneiroController();
        Pris.setNumBI(tbModelPris.getValueAt(j, 0).toString());
        Pris.setNome(prisController.Find(Pris.getNumBI()).get(0).getNome());
        Pris.setDataEntrada(prisController.Find(Pris.getNumBI()).get(0).getDataEntrada());
        Pris.setDataNasc(prisController.Find(Pris.getNumBI()).get(0).getDataNasc());
        Pris.setEstadoCivil(prisController.Find(Pris.getNumBI()).get(0).getEstadoCivil());
        Pris.setIdBloco(prisController.Find(Pris.getNumBI()).get(0).getIdBloco());
        Pris.setSexo(prisController.Find(Pris.getNumBI()).get(0).getSexo());
        Pris.setEndereco(prisController.Find(Pris.getNumBI()).get(0).getEndereco());
        Pris.setEstado((short) 0);
        prisController.Actualizar(Pris);
    }//GEN-LAST:event_btnAbsolverActionPerformed

    private void txtNomeGuardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeGuardaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeGuardaActionPerformed

    private void txtNomeGuardaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeGuardaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeGuardaFocusGained

    private void btnGuardaLiberarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardaLiberarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardaLiberarMouseClicked

    private void btnEdTurnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdTurnoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnEdTurnoMouseClicked

    private void tblGuardaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGuardaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int k = tblGuarda.getSelectedRow();
            f.setNumBI(tbModelF.getValueAt(k, 0).toString());
            txtNomeGuarda.setText(tbModelF.getValueAt(k, 1).toString());
        }
    }//GEN-LAST:event_tblGuardaMouseClicked

    private void btnEdTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdTurnoActionPerformed
        // TODO add your handling code here:
        if (btnEdTurno.isEnabled()) {
            b.setDescricao(FuncBlocoCombo.getSelectedItem().toString());
            t.setTurno(TurnoCombo.getSelectedItem().toString());
            fController.Escalar(f, b, t);

            tbModelF = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;

                }
            };

            tbModelF1 = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;

                }
            };

            fController.CarregarTabelaG(tbModelF, tblGuarda);
            fController.CarregarTabelaG1(tbModelF1, tblGuardaEdit);
            txtNomeGuarda.setText("Nome");
        }
    }//GEN-LAST:event_btnEdTurnoActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home(new Funcionario()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CelaCombo;
    private javax.swing.JComboBox<String> FuncBlocoCombo;
    private javax.swing.JPanel GuardPanel;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JComboBox<String> TurnoCombo;
    private javax.swing.JButton btnAbsolver;
    private javax.swing.JButton btnCad;
    private javax.swing.JButton btnEdTurno;
    private javax.swing.JButton btnGuardaLiberar;
    private javax.swing.JPanel btnGuardas;
    private javax.swing.JPanel btnPris;
    private javax.swing.JPanel btnRelatorio;
    private javax.swing.JPanel btnSair1;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel imgLabel1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblBloco;
    private javax.swing.JLabel lblCela;
    private javax.swing.JLabel lblCrime;
    private javax.swing.JLabel lblEsquadra;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPena;
    private javax.swing.JLabel lblTribunal;
    private javax.swing.JLabel lbldataEntrada;
    private javax.swing.JLabel letterLabel;
    private javax.swing.JLabel letterLabel2;
    private javax.swing.JLabel letterLabel3;
    private javax.swing.JLabel letterLabel4;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JPanel prisPanel;
    private javax.swing.JRadioButton rdbF;
    private javax.swing.JRadioButton rdbM;
    private javax.swing.JTable tblGuarda;
    private javax.swing.JTable tblGuardaEdit;
    private javax.swing.JTable tblPrisioneiro;
    private javax.swing.JTable tblRelactorio;
    private javax.swing.JTextField txtCrime;
    private javax.swing.JTextField txtDataCrime;
    private javax.swing.JTextField txtDataEntrada;
    private javax.swing.JTextField txtDataJulga;
    private javax.swing.JTextField txtDataNasc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEsquadra;
    private javax.swing.JTextField txtEsquadraLocal;
    private javax.swing.JTextField txtEstadoCivil;
    private javax.swing.JTextField txtLocalCrime;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeGuarda;
    private javax.swing.JTextField txtNumBI;
    private javax.swing.JTextField txtPena;
    private javax.swing.JTextField txtTribunal;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
