package utfpr.edu.br.controleestoque.form;


import java.awt.Cursor;
import utfpr.edu.br.controleestoque.bo.CategoriaBO;
import  utfpr.edu.br.controleestoque.vo.Categoria;

/**
 * @see Classe visual. JDialog que tem como objetivo cadastrar uma nova
 * categoria.
 * @author Magno carvalho
 */
public class FrmCategoria extends javax.swing.JDialog {

    /**
     * @see Construtor padrão.
     * @param viewPainelControle
     * @param parent
     * @param modal
     */
       /**
     * @see Construtor padrão.
     * @param viewPainelControle
     * @param parent
     * @param modal
     */
    public FrmCategoria(java.awt.Frame parent, boolean modal, FrmPainelControle viewPainelControle) {
        //Inicialização dos componentes padrões do JDialog.
        super(parent, modal);
        initComponents();
        this.viewPainelControle = viewPainelControle;
        btnAlterar.setVisible(false);
    }

    /**
     * @see Construtor utilizado quando se quer visualizar ou alterar uma
     * Categoria.
     * @param viewPainelControle
     * @param parent
     * @param modal
     * @param categoria
     * @param alterar
     */
    public FrmCategoria(java.awt.Frame parent, boolean modal, FrmPainelControle viewPainelControle, Categoria categoria, Boolean alterar) {
        //Inicialização dos componentes padrões do JDialog.
        super(parent, modal);
        initComponents();
        this.viewPainelControle = viewPainelControle;
        btnCadastrar.setVisible(false);
        this.categoriaVO = categoria;
        this.categoriaBO = new CategoriaBO();
        btnCadastrar.setVisible(false);
        lbTitulo.setText("Alterar Categoria");

        //Definindo os atributos.
        tfDescricao.setText(categoriaVO.getDescricaocategoria());

        //Definindo como não editável
        if (!alterar) {
            lbTitulo.setText("Categoria");
            btnAlterar.setVisible(false);
            tfDescricao.setEditable(false);
        }
    }

    /**
     * @see Construtor utilizado quando se quer visualizar ou alterar uma
     * Categoria.
     * @param viewPainelControle
     * @param parent
     * @param modal
     * @param categoria
     * @param alterar
     */
   

    //Componentes padrões do JFrame.
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTitulo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnCorpo = new javax.swing.JPanel();
        pnObrigatorio = new javax.swing.JPanel();
        lbDescricao = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JFormattedTextField();
        sprRodape = new javax.swing.JSeparator();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Categoria");
        setResizable(false);

        pnTitulo.setBackground(new java.awt.Color(51, 51, 51));

        lbTitulo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setText("Nova Categoria");

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTituloLayout.setVerticalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCorpo.setBackground(new java.awt.Color(255, 255, 255));

        pnObrigatorio.setBackground(new java.awt.Color(255, 255, 255));

        lbDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbDescricao.setForeground(new java.awt.Color(102, 102, 102));
        lbDescricao.setText("Descrição");

        tfDescricao.setForeground(new java.awt.Color(102, 102, 102));
        try {
            tfDescricao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**************************************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnObrigatorioLayout = new javax.swing.GroupLayout(pnObrigatorio);
        pnObrigatorio.setLayout(pnObrigatorioLayout);
        pnObrigatorioLayout.setHorizontalGroup(
            pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObrigatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnObrigatorioLayout.createSequentialGroup()
                        .addComponent(lbDescricao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfDescricao))
                .addContainerGap())
        );
        pnObrigatorioLayout.setVerticalGroup(
            pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObrigatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sprRodape.setForeground(new java.awt.Color(204, 204, 204));

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utfpr/edu/br/controleestoque/resources/imagens/btnCadastrarUP.png"))); // NOI18N
        btnCadastrar.setBorder(null);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/utfpr/edu/br/controleestoque/resources/imagens/btnCadastrarDOWN.png"))); // NOI18N
        btnCadastrar.setFocusable(false);
        btnCadastrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/utfpr/edu/br/controleestoque/resources/imagens/btnCadastrarDOWN.png"))); // NOI18N
        btnCadastrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/utfpr/edu/br/controleestoque/resources/imagens/btnCadastrarDOWN.png"))); // NOI18N
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utfpr/edu/br/controleestoque/resources/imagens/btnAlterarUP.png"))); // NOI18N
        btnAlterar.setBorder(null);
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/utfpr/edu/br/controleestoque/resources/imagens/btnAlterarDOWN.png"))); // NOI18N
        btnAlterar.setFocusable(false);
        btnAlterar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/utfpr/edu/br/controleestoque/resources/imagens/btnAlterarDOWN.png"))); // NOI18N
        btnAlterar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/utfpr/edu/br/controleestoque/resources/imagens/btnAlterarDOWN.png"))); // NOI18N
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addContainerGap(388, Short.MAX_VALUE))
            .addComponent(pnObrigatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sprRodape)
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCorpoLayout.createSequentialGroup()
                .addComponent(pnObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sprRodape, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAlterar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(pnCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @see Método que responde ao clique do JButton e verifica se os campos
     * estão preenchidos para inserir uma nova Categoria.
     * @param evt
     */
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        btnCadastrar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        categoriaBO = new CategoriaBO();
        if (categoriaBO.validarCampos(pnCorpo)) {
            if (categoriaBO.inserirCategoria(tfDescricao.getText())) {
                viewPainelControle.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    /**
     * @see Método que responde ao clique do JButton e verifica se os campos
     * estão preenchidos para alterar uma Categoria.
     * @param evt
     */
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
         btnCadastrar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        categoriaBO = new CategoriaBO();
        if (categoriaBO.validarCampos(pnCorpo)) {
            Long l = Long.valueOf(categoriaVO.getIdcategoria());
            if (categoriaBO.alterarCategoria(l, tfDescricao.getText())) {
                viewPainelControle.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

   
    //Declaração de variáveis(View).
    private final FrmPainelControle viewPainelControle;

    //Declaração de variáveis(Value Object).
    private Categoria categoriaVO;

    //Declaração de variáveis(Business Object).
    private CategoriaBO categoriaBO;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnObrigatorio;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSeparator sprRodape;
    private javax.swing.JFormattedTextField tfDescricao;
    // End of variables declaration//GEN-END:variables
}
