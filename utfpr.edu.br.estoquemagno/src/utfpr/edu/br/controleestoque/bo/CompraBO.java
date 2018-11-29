package utfpr.edu.br.controleestoque.bo;

import utfpr.edu.br.controleestoque.dao.GenericDAO;

import utfpr.edu.br.controleestoque.vo.Produto;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import utfpr.edu.br.controleestoque.conexao.TransactionUtil;
import utfpr.edu.br.controleestoque.dao.DaoCompra;
import utfpr.edu.br.controleestoque.dao.DaoItemCompra;
import utfpr.edu.br.controleestoque.vo.Compra;
import utfpr.edu.br.controleestoque.vo.Fornecedor;
import utfpr.edu.br.controleestoque.vo.Funcionario;
import utfpr.edu.br.controleestoque.vo.Itemcompra;


public class CompraBO {

    /**
     * @see Método que realiza consulta ao banco de dados por todo o Inventario.
     * @return Lista de Produtos
     */
    public List<Produto> buscarInventario() {
        GenericDAO<Produto> produtoDAO = new GenericDAO<>();
        ArrayList<Produto> produtosVO = new ArrayList<>(produtoDAO.consultar(new Produto()));
        return produtosVO;
    }

    /**
     * @see Método que realiza consulta ao banco de dados por todo o Inventario.
     * @return Lista de Compras
     */
    public List<Compra> buscarCompras() {
        GenericDAO<Compra> compraDAO = new GenericDAO<>();
        ArrayList<Compra> comprasVO = new ArrayList<>(compraDAO.consultar(new Compra()));
        return comprasVO;
    }

    public Fornecedor buscarFornecedor(Integer idCliente) {
        GenericDAO<Fornecedor> clienteDAO = new GenericDAO<>();
        ArrayList<Fornecedor> clientesVO = new ArrayList<>(clienteDAO.consultar(new Fornecedor()));
        return clientesVO.get(idCliente);
    }

   

    public Boolean excluirCompra(Long idCompra) {
        try {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta Compra?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    GenericDAO<Compra> compraDAO = new GenericDAO<>();
                    Compra compraVO = compraDAO.consultar("idCompra", idCompra, new Compra());
                    ArrayList<Itemcompra> itens = buscarItens(idCompra);
                    GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
                    itens.stream().forEach((iten) -> {
                        itemDAO.apagar(iten);
                    });
                    compraDAO.apagar(compraVO);
                    JOptionPane.showMessageDialog(null, "Compra excluida com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CompraBO/excluirCompra/" + e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
   public Boolean finalizarCompra(Long idFuncionario, Integer idFornecedor, String valor, ArrayList<Itemcompra> itens) {
        try {
            GenericDAO<Compra> compraDAO = new GenericDAO<>();
            Compra compraVO = new Compra();
            List<Compra> consultar = compraDAO.consultar(compraVO);
            int i = consultar.size();
            compraVO.setIdcompra(i);
            GenericDAO<Funcionario> funcionarioDAO = new GenericDAO<>();
            compraVO.setFuncionario(funcionarioDAO.consultar("idFuncionario", idFuncionario, new Funcionario()));
            if (idFornecedor > 0) {
                compraVO.setFornecedor(buscarFornecedor(idFornecedor - 1));
            }
            compraVO.setValorcompra(new BigDecimal(valor));
           
            compraVO.setCriacaocompra(new Date());
            
            compraDAO.inserir(compraVO);

            GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
            itens.stream().forEach((iten) -> {
                iten.setCompra(compraVO);
                itemDAO.inserir(iten);
            });
            JOptionPane.showMessageDialog(null, "Compra finalizada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CompraBO/finalizarCompra/" + e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

//       Compra c = new Compra();
//       Fornecedor f = new Fornecedor(idFornecedor);
//       Funcionario funcionario = new Funcionario(idFuncionario.intValue());
//       
//       c.setFornecedor(f);
//       c.setFuncionario(funcionario);
//       Long l = Long.valueOf(valor);
//       c.setValorcompra(BigDecimal.valueOf(l));
//       c.setCriacaocompra(new Date());
//       TransactionUtil.beginTransaction();
//            try {
//                new DaoCompra().persistir(c);
//                 
//                    itens.stream().forEach((iten) -> {
//                        iten.setCompra(c);
//                        new DaoItemCompra().persistir(iten);
//                    });
//                TransactionUtil.commit();
//                JOptionPane.showMessageDialog(null, "Cadastrado Com sucesso","Messagem", JOptionPane.INFORMATION_MESSAGE, null);
//                return true;
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Erro ao persistir no banco","Messagem", JOptionPane.ERROR_MESSAGE, null);
//                TransactionUtil.rollback();
//            
//               return false;
//            }
    }

    public void excluirCompra(Long idCompra, ArrayList<Itemcompra> itens) {
        try {
            GenericDAO<Compra> compraDAO = new GenericDAO<>();
            compraDAO.apagar(compraDAO.consultar("idCompra", idCompra, new Compra()));
            GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
            itens.stream().forEach((iten) -> {
                itemDAO.apagar(itemDAO.consultar("idItem", (long)iten.getIditemcompra(), new Itemcompra()));
            });
        } catch (Exception e) {

        }
    }

    public ArrayList<Itemcompra> buscarItens(Long idVenda) {
        GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
        List<Itemcompra> itens = itemDAO.consultar(new Itemcompra());
        ArrayList<Itemcompra> itensVenda = new ArrayList<>();
        itens.stream().filter((iten) -> (Objects.equals(iten.getCompra().getIdcompra(), idVenda))).forEach((iten) -> {
            itensVenda.add(iten);
        });
        return itensVenda;
    }
    
    public Boolean verificarEstoque(ArrayList<Itemcompra> itens){
        Boolean retorno = true;
        for (Itemcompra iten : itens) {
            BigDecimal aux = new BigDecimal(iten.getProduto().getQuantidade()).add(new BigDecimal(iten.getQuantidadeitemcompra()));
            if (aux.compareTo(new BigDecimal(iten.getProduto().getMaximoproduto())) > 0) {
                retorno = false;
            }
        }
        return retorno;
    }

   public String[] buscarNomeFornecedores() {
        GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();
        ArrayList<Fornecedor> fornecedoresVO = new ArrayList<>(fornecedorDAO.consultar(new Fornecedor()));
        ArrayList<String> array = new ArrayList<>();
        array.add("FORNECEDOR");
        fornecedoresVO.stream().forEach((categoriasVO1) -> {
            array.add(categoriasVO1.getNomefornecedor());
        });
        String[] Arr = new String[array.size()];
        Arr = array.toArray(Arr);
        return Arr;
    }

    

   
}
