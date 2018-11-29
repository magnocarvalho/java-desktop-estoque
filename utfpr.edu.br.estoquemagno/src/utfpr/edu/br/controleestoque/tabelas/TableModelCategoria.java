package utfpr.edu.br.controleestoque.tabelas;

import utfpr.edu.br.controleestoque.vo.Categoria;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @see Classe modelo. Modela uma tabela para possuir todos os campos de valores
 * da Categoria.
 * 
 */
public class TableModelCategoria extends AbstractTableModel {

    //Declaração de variáveis.
    private final List<Categoria> linhas;
    private final String[] colunas;

    //Declaração de variáveis que compoem os campos da tabela.
    private static final int descricaoCategoria = 0;
    private static final int idCategoria = 1;


    /**
     * @see Construtor padrão. Inicializa as linhas da coluna como nulo e define
     * as colunas com os valores do objeto.
     */
    public TableModelCategoria() {
        linhas = new ArrayList<>();
        colunas = new String[]{"Categoria", "ID"};
    }

    /**
     * @see Contrutor que inicializa as linhas da coluna com a lista recebida
     * pelo parâmetro e define as colunas com os valores do objeto.
     * @param categorias
     */
    public TableModelCategoria(List<Categoria> categorias) {
        linhas = new ArrayList<>(categorias);
        colunas = new String[]{"Categoria", "ID"};
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
            case descricaoCategoria:
                return String.class;
            case idCategoria:
                return Long.class;
            
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria categoria = linhas.get(rowIndex);
        switch (columnIndex) {
            case descricaoCategoria:
                return categoria.getDescricaocategoria();
            case idCategoria:
                return categoria.getIdcategoria();
                   
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Categoria categoria = linhas.get(rowIndex);
        switch (columnIndex) {
            case descricaoCategoria:
                categoria.setDescricaocategoria((String) aValue);
                break;
           
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Categoria getCategoria(int rowIndex) {
        return linhas.get(rowIndex);
    }

    /**
     * @see Método que adiciona uma nova linha com os valores do objeto recebido
     * como parâmetro.
     * @param categoria
     */
    public void addCategoria(Categoria categoria) {
        linhas.add(categoria);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /**
     * @see Método que adiciona uma lista de linhas com a lista de objetos
     * recebida como parâmetro.
     * @param categorias
     */
    public void addListaCategorias(List<Categoria> categorias) {
        int indice = getRowCount();
        linhas.addAll(categorias);
        fireTableRowsInserted(indice, indice + categorias.size());
    }

    /**
     * @see Método que remove linha da tabela atravez do index rebecido como
     * parâmetro.
     * @param rowIndex numero da linha da tabela.
     */
    public void removeCategoria(int rowIndex) {
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
