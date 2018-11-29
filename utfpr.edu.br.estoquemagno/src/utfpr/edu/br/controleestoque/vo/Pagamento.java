package utfpr.edu.br.controleestoque.vo;
// Generated 22/11/2016 00:32:56 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Pagamento generated by hbm2java
 */
public class Pagamento  implements java.io.Serializable {


     private int idpagamento;
     private Compra compra;
     private Funcionario funcionario;
     private String descricao;
     private BigDecimal valorpagamento;
     private Date datapagamento;
     private Date criacaopagamento;

    public Pagamento() {
    }

	
    public Pagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }
    public Pagamento(int idpagamento, Compra compra, Funcionario funcionario, String descricao, BigDecimal valorpagamento, Date datapagamento, Date criacaopagamento) {
       this.idpagamento = idpagamento;
       this.compra = compra;
       this.funcionario = funcionario;
       this.descricao = descricao;
       this.valorpagamento = valorpagamento;
       this.datapagamento = datapagamento;
       this.criacaopagamento = criacaopagamento;
    }
   
    public int getIdpagamento() {
        return this.idpagamento;
    }
    
    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }
    public Compra getCompra() {
        return this.compra;
    }
    
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getValorpagamento() {
        return this.valorpagamento;
    }
    
    public void setValorpagamento(BigDecimal valorpagamento) {
        this.valorpagamento = valorpagamento;
    }
    public Date getDatapagamento() {
        return this.datapagamento;
    }
    
    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }
    public Date getCriacaopagamento() {
        return this.criacaopagamento;
    }
    
    public void setCriacaopagamento(Date criacaopagamento) {
        this.criacaopagamento = criacaopagamento;
    }




}

