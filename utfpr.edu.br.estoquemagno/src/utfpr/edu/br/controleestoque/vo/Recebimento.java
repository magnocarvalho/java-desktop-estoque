package utfpr.edu.br.controleestoque.vo;
// Generated 22/11/2016 00:32:56 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Recebimento generated by hbm2java
 */
public class Recebimento  implements java.io.Serializable {


     private int idrecebimento;
     private Funcionario funcionario;
     private Venda venda;
     private String descricao;
     private BigDecimal valor;
     private Date criacaorecebimento;

    public Recebimento() {
    }

	
    public Recebimento(int idrecebimento) {
        this.idrecebimento = idrecebimento;
    }
    public Recebimento(int idrecebimento, Funcionario funcionario, Venda venda, String descricao, BigDecimal valor, Date criacaorecebimento) {
       this.idrecebimento = idrecebimento;
       this.funcionario = funcionario;
       this.venda = venda;
       this.descricao = descricao;
       this.valor = valor;
       this.criacaorecebimento = criacaorecebimento;
    }
   
    public int getIdrecebimento() {
        return this.idrecebimento;
    }
    
    public void setIdrecebimento(int idrecebimento) {
        this.idrecebimento = idrecebimento;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Venda getVenda() {
        return this.venda;
    }
    
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public Date getCriacaorecebimento() {
        return this.criacaorecebimento;
    }
    
    public void setCriacaorecebimento(Date criacaorecebimento) {
        this.criacaorecebimento = criacaorecebimento;
    }




}


