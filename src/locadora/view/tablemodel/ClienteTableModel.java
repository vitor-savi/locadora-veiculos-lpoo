package locadora.view.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import locadora.model.Cliente;

public class ClienteTableModel extends AbstractTableModel {
    private final String[] colunas = {"Nome", "Sobrenome", "RG", "CPF", "Endereço"};
    private List<Cliente> dados = new ArrayList<>();
    public void setDados(List<Cliente> dados) { this.dados = dados; fireTableDataChanged(); }
    public Cliente getItem(int linha) { return dados.get(linha); }
    @Override public int getRowCount() { return dados.size(); }
    @Override public int getColumnCount() { return colunas.length; }
    @Override public String getColumnName(int coluna) { return colunas[coluna]; }
    @Override public Object getValueAt(int linha, int coluna) {
        Cliente c = dados.get(linha);
        switch (coluna) {
            case 0: return c.getNome();
            case 1: return c.getSobrenome();
            case 2: return c.getRg();
            case 3: return c.getCpf();
            case 4: return c.getEndereco();
            default: return null;
        }
    }
}
