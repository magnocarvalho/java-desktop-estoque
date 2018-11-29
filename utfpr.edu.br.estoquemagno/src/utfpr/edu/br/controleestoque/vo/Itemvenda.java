package utfpr.edu.br.controleestoque.vo;
// Generated 22/11/2016 00:32:56 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Itemvenda generated by hbm2java
 */
public class Itemvenda  implements java.io.Serializable {


     private int iditemvenda;
     private Produto produto;
     private Venda venda;
     private Integer quantidade;
     private BigDecimal valor;
     private Date criacaoitemvenda;

    public Itemvenda() {
    }

	
    public Itemvenda(int iditemvenda) {
        this.iditemvenda = iditemvenda;
    }
    public Itemvenda(int iditemvenda, Produto produto, Venda venda, Integer quantidade, BigDecimal valor, Date criacaoitemvenda) {
       this.iditemvenda = iditemvenda;
       this.produto = produto;
       this.venda = venda;
       this.quantidade = quantidade;
       this.valor = valor;
       this.criacaoitemvenda = criacaoitemvenda;
    }
   
    public int getIditemvenda() {
        return this.iditemvenda;
    }
    
    public void setIditemvenda(int iditemvenda) {
        this.iditemvenda = iditemvenda;
    }
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Venda getVenda() {
        return this.venda;
    }
    
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    public Integer getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public Date getCriacaoitemvenda() {
        return this.criacaoitemvenda;
    }
    
    public void setCriacaoitemvenda(Date criacaoitemvenda) {
        this.criacaoitemvenda = criacaoitemvenda;
    }




}


