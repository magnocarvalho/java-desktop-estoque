package utfpr.edu.br.controleestoque.vo;
// Generated 22/11/2016 00:32:56 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Produto generated by hbm2java
 */
public class Produto  implements java.io.Serializable {


     private int idproduto;
     private Categoria categoria;
     private Fornecedor fornecedor;
     private String descricaoproduto;
     private String codigoproduto;
     private BigDecimal custoproduto;
     private BigDecimal vendaproduto;
     private Long minimoproduto;
     private Long maximoproduto;
     private Long quantidade;
     private Date criacaoproduto;
     private Set itemcompras = new HashSet(0);
     private Set itemvendas = new HashSet(0);

    public Produto() {
    }

	
    public Produto(int idproduto) {
        this.idproduto = idproduto;
    }
    public Produto(int idproduto, Categoria categoria, Fornecedor fornecedor, String descricaoproduto, String codigoproduto, BigDecimal custoproduto, BigDecimal vendaproduto, Long minimoproduto, Long maximoproduto, Long quantidade, Date criacaoproduto, Set itemcompras, Set itemvendas) {
       this.idproduto = idproduto;
       this.categoria = categoria;
       this.fornecedor = fornecedor;
       this.descricaoproduto = descricaoproduto;
       this.codigoproduto = codigoproduto;
       this.custoproduto = custoproduto;
       this.vendaproduto = vendaproduto;
       this.minimoproduto = minimoproduto;
       this.maximoproduto = maximoproduto;
       this.quantidade = quantidade;
       this.criacaoproduto = criacaoproduto;
       this.itemcompras = itemcompras;
       this.itemvendas = itemvendas;
    }
   
    public int getIdproduto() {
        return this.idproduto;
    }
    
    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public String getDescricaoproduto() {
        return this.descricaoproduto;
    }
    
    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }
    public String getCodigoproduto() {
        return this.codigoproduto;
    }
    
    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
    }
    public BigDecimal getCustoproduto() {
        return this.custoproduto;
    }
    
    public void setCustoproduto(BigDecimal custoproduto) {
        this.custoproduto = custoproduto;
    }
    public BigDecimal getVendaproduto() {
        return this.vendaproduto;
    }
    
    public void setVendaproduto(BigDecimal vendaproduto) {
        this.vendaproduto = vendaproduto;
    }
    public Long getMinimoproduto() {
        return this.minimoproduto;
    }
    
    public void setMinimoproduto(Long minimoproduto) {
        this.minimoproduto = minimoproduto;
    }
    public Long getMaximoproduto() {
        return this.maximoproduto;
    }
    
    public void setMaximoproduto(Long maximoproduto) {
        this.maximoproduto = maximoproduto;
    }
    public Long getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    public Date getCriacaoproduto() {
        return this.criacaoproduto;
    }
    
    public void setCriacaoproduto(Date criacaoproduto) {
        this.criacaoproduto = criacaoproduto;
    }
    public Set getItemcompras() {
        return this.itemcompras;
    }
    
    public void setItemcompras(Set itemcompras) {
        this.itemcompras = itemcompras;
    }
    public Set getItemvendas() {
        return this.itemvendas;
    }
    
    public void setItemvendas(Set itemvendas) {
        this.itemvendas = itemvendas;
    }




}

