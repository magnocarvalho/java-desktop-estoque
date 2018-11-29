package utfpr.edu.br.controleestoque.tabelas;

import utfpr.edu.br.controleestoque.vo.Itemcompra;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @see Classe modelo. Modela uma tabela para possuir todos os campos de valores
 * do Item.
 * @author Bruna Danieli Ribeiro Gonçalves, Márlon Ândrel Coelho Freitas
 */
public class TableModelItemCompra extends AbstractTableModel {

    //Declaração de variáveis.
    private final List<Itemcompra> linhas;
    private final String[] colunas;

    //Declaração de variáveis que compoem os campos da tabela.
    private static final int produtoItem = 0;
    private static final int valorItem = 1;

    /**
     * @see Construtor padrão. Inicializa as linhas da coluna como nulo e define
     * as colunas com os valores do objeto.
     */
    public TableModelItemCompra() {
        linhas = new ArrayList<>();
        colunas = new String[]{"Produto", "Valor"};
    }

    /**
     * @see Contrutor que inicializa as linhas da coluna com a lista recebida
     * pelo parâmetro e define as colunas com os valores do objeto.
     * @param itens
     */
    public TableModelItemCompra(List<Itemcompra> itens) {
        linhas = new ArrayList<>(itens);
        colunas = new String[]{"Produto", "Valor"};
    }

    //Gets and Sets
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case produtoItem:
                return String.class;
            case valorItem:
                return BigDecimal.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Itemcompra item = linhas.get(rowIndex);
        switch (columnIndex) {
            case produtoItem:
                return item.getProduto().getDescricaoproduto();
            case valorItem:
                return item.getValoritemcompra();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Itemcompra item = linhas.get(rowIndex);
        switch (columnIndex) {
            case produtoItem:
                item.getProduto().setDescricaoproduto((String) aValue);
                break;
            case valorItem:
                item.setValoritemcompra((BigDecimal) (aValue));
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Itemcompra getItem(int rowIndex) {
        return linhas.get(rowIndex);
    }

    /**
     * @see Método que adiciona uma nova linha com os valores do objeto recebido
     * como parâmetro.
     * @param item Usuario que compoe uma linha da tabela.
     */
    public void addItem(Itemcompra item) {
        linhas.add(item);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /**
     * @see Método que adiciona uma lista de linhas com a lista de objetos
     * recebida como parâmetro.
     * @param itens
     */
    public void addListaItens(List<Itemcompra> itens) {
        int indice = getRowCount();
        linhas.addAll(itens);
        fireTableRowsInserted(indice, indice + itens.size());
    }

    /**
     * @see Método que remove linha da tabela atravez do index rebecido como
     * parâmetro.
     * @param rowIndex numero da linha da tabela.
     */
    public void removeItem(int rowIndex) {
        linhas.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /**
     * @see Método que remove todas as linhas da tabela.
     */
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
}
