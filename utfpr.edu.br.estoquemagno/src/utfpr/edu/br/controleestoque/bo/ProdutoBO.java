package utfpr.edu.br.controleestoque.bo;


import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import utfpr.edu.br.controleestoque.dao.GenericDAO;
import utfpr.edu.br.controleestoque.vo.Categoria;
import utfpr.edu.br.controleestoque.vo.Fornecedor;
import utfpr.edu.br.controleestoque.vo.Produto;

/**
 * @see Classe de objetos de negócios. Métodos:
 * @author 
 */
public class ProdutoBO {

    /**
     * @see Método que persiste um objeto no banco de dados por meio da
     * GenericDAO.
     * @param idCategoria
     * @param idFornecedor
     * @param descricao
     * @param codigo
     * @param custo
     * @param venda
     * @param minimo
     
     * @param maximo
     * @return true/false.
     */
    public Boolean inserirProduto(Integer idCategoria, Integer idFornecedor, String descricao, String codigo, String custo, String venda, String minimo, String maximo, String Quantidade) {
        try {
            GenericDAO<Produto> produtoDAO = new GenericDAO<>();
            Produto produtoV0 = new Produto();
            produtoV0.setIdproduto(1 + (produtoDAO.consultar(produtoV0).size()));
            produtoV0.setDescricaoproduto(descricao);
            produtoV0.setCodigoproduto(codigo);
            produtoV0.setQuantidade(new Long(Quantidade));
            try {
                produtoV0.setCustoproduto(new BigDecimal(custo));
            } catch (Exception e) {
                produtoV0.setCustoproduto(new BigDecimal(0));
            }
            try {
                produtoV0.setVendaproduto(new BigDecimal(venda));
            } catch (Exception e) {
                produtoV0.setVendaproduto(new BigDecimal(0));
            }
            produtoV0.setMinimoproduto(new Long(minimo));
            produtoV0.setMaximoproduto(new Long(maximo));
            
            
            produtoV0.setCriacaoproduto(new Date());
           

            GenericDAO<Categoria> categoriaDAO = new GenericDAO<>();
            try {
                Categoria categoriaVO = buscarCategoria(idCategoria - 1);
                produtoV0.setCategoria(categoriaVO);
            } catch (Exception e) {
                Categoria categoriaVO = null;
                produtoV0.setCategoria(categoriaVO);
            }
            GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();
            try {
                Fornecedor fornecedorVO = buscarFornecedor(idFornecedor - 1);
                produtoV0.setFornecedor(fornecedorVO);
            } catch (Exception e) {
                Fornecedor fornecedorVO = null;
                produtoV0.setFornecedor(fornecedorVO);
            }

            if (produtoDAO.inserir(produtoV0)) {
                JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * @param idProduto
     * @see Método que altera um objeto no banco de dados por meio da
     * GenericDAO.
     * @param idCategoria
     * @param idFornecedor
     * @param descricao
     * @param codigo
     * @param custo
     * @param venda
     * @param minimo
     * @param estoque
     * @param maximo
     * @return true/false.
     */
    public Boolean alterarProduto(Long idProduto, Integer idCategoria, Integer idFornecedor, String descricao, String codigo, String custo, String venda, String minimo, String maximo) {
        try {
            GenericDAO<Produto> produtoDAO = new GenericDAO<>();
            Produto produtoV0 = produtoDAO.consultar("idProduto", idProduto, new Produto());
            produtoV0.setDescricaoproduto(descricao);
            produtoV0.setCodigoproduto(codigo);
            try {
                produtoV0.setCustoproduto(new BigDecimal(custo));
            } catch (Exception e) {
                produtoV0.setCustoproduto(new BigDecimal(0));
            }
            try {
                produtoV0.setVendaproduto(new BigDecimal(venda));
            } catch (Exception e) {
                produtoV0.setVendaproduto(new BigDecimal(0));
            }
            try {
                produtoV0.setMinimoproduto(new Long(minimo));
            } catch (Exception e) {
                
                produtoV0.setMinimoproduto(new Long(0));
            }
            try {
                produtoV0.setMaximoproduto(new Long(maximo));
            } catch (Exception e) {
                
                produtoV0.setMaximoproduto(new Long(0));
            }
            
            

            GenericDAO<Categoria> categoriaDAO = new GenericDAO<>();
            try {
                Categoria categoriaVO = buscarCategoria(idCategoria - 1);
                produtoV0.setCategoria(categoriaVO);
            } catch (Exception e) {
                Categoria categoriaVO = null;
                produtoV0.setCategoria(categoriaVO);
            }
            GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();
            try {
                Fornecedor fornecedorVO = buscarFornecedor(idFornecedor - 1);
                produtoV0.setFornecedor(fornecedorVO);
            } catch (Exception e) {
                Fornecedor fornecedorVO = null;
                produtoV0.setFornecedor(fornecedorVO);
            }

            if (produtoDAO.atualizar(produtoV0)) {
                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * @see Método que realiza consulta ao banco de dados por todos as
     * Categorias.
     * @return Lista de Categorias composta por todas as linhas da tabela
     * categoria do banco de dados.
     */
    public String[] buscarNomeCategorias() {
        GenericDAO<Categoria> categoriaDAO = new GenericDAO<>();
        ArrayList<Categoria> categoriasVO = new ArrayList<>(categoriaDAO.consultar(new Categoria()));
        ArrayList<String> array = new ArrayList<>();
        array.add("CATEGORIA");
        categoriasVO.stream().forEach((categoriasVO1) -> {
            array.add(categoriasVO1.getDescricaocategoria());
        });
        String[] Arr = new String[array.size()];
        Arr = array.toArray(Arr);
        return Arr;
    }

    /**
     * @see Método que realiza consulta ao banco de dados por todos os
     * Fornecedores.
     * @return Lista de Fornecedores composta por todas as linhas da tabela
     * fornecedor do banco de dados.
     */
    public String[] buscarNomeFornecedores() {
        GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();
        ArrayList<Fornecedor> fornecedoresVO = new ArrayList<>(fornecedorDAO.consultar(new Fornecedor()));
        ArrayList<String> array = new ArrayList<>();
        array.add("FORNENEDOR");
        fornecedoresVO.stream().forEach((fornecedoresVO1) -> {
            array.add(fornecedoresVO1.getNomefornecedor());
        });
        String[] Arr = new String[array.size()];
        Arr = array.toArray(Arr);
        return Arr;
    }

    /**
     * @see Método que realiza consulta ao banco de dados por todos os
     * Fornecedores.
     * @param idFornecedor
     * @return Lista de Fornecedores composta por todas as linhas da tabela
     * fornecedor do banco de dados.
     */
    public Fornecedor buscarFornecedor(Integer idFornecedor) {
        GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();
        ArrayList<Fornecedor> fornecedoresVO = new ArrayList<>(fornecedorDAO.consultar(new Fornecedor()));
        return fornecedoresVO.get(idFornecedor);
    }

    /**
     * @see Método que realiza consulta ao banco de dados por todos as
     * Categorias.
     * @param idCategoria
     * @return Lista de Categorias composta por todas as linhas da tabela
     * categoria do banco de dados.
     */
    public Categoria buscarCategoria(Integer idCategoria) {
        GenericDAO<Categoria> categoriaDAO = new GenericDAO<>();
        ArrayList<Categoria> categoriasVO = new ArrayList<>(categoriaDAO.consultar(new Categoria()));
        return categoriasVO.get(idCategoria);
    }

    /**
     * @see Método que verifica se os elementos do JPanel são diferentes de
     * null, usado para verificar se os campos estão preenchidos pelo usuário.
     * @param panel
     * @return false caso pelo menos um componente possuir getText() == null.
     */
    public boolean validarCampos(JPanel panel) {
        Component componentes[] = panel.getComponents();
        boolean erro = true;
        for (Component c : componentes) {
            if (c instanceof JTextField) {
                if (((JTextField) c).isEnabled()) {
                    if (((JTextField) c).getText().trim().equals("")) {
                        ((JTextField) c).setBorder(new LineBorder(Color.RED));
                        erro = false;
                    } else {
                        ((JTextField) c).setBorder(new LineBorder(Color.LIGHT_GRAY));
                    }
                } else {
                    ((JTextField) c).setBorder(new LineBorder(Color.LIGHT_GRAY));
                }
            }
        }
        return erro;
    }
}
