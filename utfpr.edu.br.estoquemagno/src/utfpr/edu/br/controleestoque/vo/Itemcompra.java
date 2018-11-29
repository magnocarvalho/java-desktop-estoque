package utfpr.edu.br.controleestoque.vo;
// Generated 22/11/2016 00:32:56 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Itemcompra generated by hbm2java
 */
public class Itemcompra  implements java.io.Serializable {


     private int iditemcompra;
     private Compra compra;
     private Produto produto;
     private Integer quantidadeitemcompra;
     private BigDecimal valoritemcompra;
     private Date criacaoitemcompra;

    public Itemcompra() {
    }

	
    public Itemcompra(int iditemcompra) {
        this.iditemcompra = iditemcompra;
    }
    public Itemcompra(int iditemcompra, Compra compra, Produto produto, Integer quantidadeitemcompra, BigDecimal valoritemcompra, Date criacaoitemcompra) {
       this.iditemcompra = iditemcompra;
       this.compra = compra;
       this.produto = produto;
       this.quantidadeitemcompra = quantidadeitemcompra;
       this.valoritemcompra = valoritemcompra;
       this.criacaoitemcompra = criacaoitemcompra;
    }
   
    public int getIditemcompra() {
        return this.iditemcompra;
    }
    
    public void setIditemcompra(int iditemcompra) {
        this.iditemcompra = iditemcompra;
    }
    public Compra getCompra() {
        return this.compra;
    }
    
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidadeitemcompra() {
        return this.quantidadeitemcompra;
    }
    
    public void setQuantidadeitemcompra(Integer quantidadeitemcompra) {
        this.quantidadeitemcompra = quantidadeitemcompra;
    }
    public BigDecimal getValoritemcompra() {
        return this.valoritemcompra;
    }
    
    public void setValoritemcompra(BigDecimal valoritemcompra) {
        this.valoritemcompra = valoritemcompra;
    }
    public Date getCriacaoitemcompra() {
        return this.criacaoitemcompra;
    }
    
    public void setCriacaoitemcompra(Date criacaoitemcompra) {
        this.criacaoitemcompra = criacaoitemcompra;
    }




}


