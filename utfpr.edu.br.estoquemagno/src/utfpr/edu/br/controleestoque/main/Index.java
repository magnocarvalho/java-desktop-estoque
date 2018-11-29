/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.controleestoque.main;
import utfpr.edu.br.controleestoque.form.FrmBase;
import utfpr.edu.br.controleestoque.util.Util;


/**
 *
 * @author magno carvalho dos santos
 */
public class Index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //primeiro formulario a ser carregado pelo software.
        FrmBase fr = new FrmBase();
        //função de centralização do formulario
        Util.abrirJFrameCentralizado(fr);
        fr.setVisible(true);
     
    }
    
}
