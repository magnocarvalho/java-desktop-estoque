package utfpr.edu.br.controleestoque.vo;
// Generated 22/11/2016 00:32:56 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Venda generated by hbm2java
 */
public class Venda  implements java.io.Serializable {


     private int idvenda;
     private Funcionario funcionario;
     private BigDecimal valor;
     private Date criacaovenda;
     private Date atualizacaovenda;
     private Set recebimentos = new HashSet(0);
     private Set itemvendas = new HashSet(0);

    public Venda() {
    }

	
    public Venda(int idvenda) {
        this.idvenda = idvenda;
    }
    public Venda(int idvenda, Funcionario funcionario, BigDecimal valor, Date criacaovenda, Date atualizacaovenda, Set recebimentos, Set itemvendas) {
       this.idvenda = idvenda;
       this.funcionario = funcionario;
       this.valor = valor;
       this.criacaovenda = criacaovenda;
       this.atualizacaovenda = atualizacaovenda;
       this.recebimentos = recebimentos;
       this.itemvendas = itemvendas;
    }
   
    public int getIdvenda() {
        return this.idvenda;
    }
    
    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public Date getCriacaovenda() {
        return this.criacaovenda;
    }
    
    public void setCriacaovenda(Date criacaovenda) {
        this.criacaovenda = criacaovenda;
    }
    public Date getAtualizacaovenda() {
        return this.atualizacaovenda;
    }
    
    public void setAtualizacaovenda(Date atualizacaovenda) {
        this.atualizacaovenda = atualizacaovenda;
    }
    public Set getRecebimentos() {
        return this.recebimentos;
    }
    
    public void setRecebimentos(Set recebimentos) {
        this.recebimentos = recebimentos;
    }
    public Set getItemvendas() {
        return this.itemvendas;
    }
    
    public void setItemvendas(Set itemvendas) {
        this.itemvendas = itemvendas;
    }




}

