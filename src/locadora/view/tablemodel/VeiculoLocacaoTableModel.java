package locadora.view.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import locadora.model.Veiculo;
import locadora.util.Formatador;

public class VeiculoLocacaoTableModel extends AbstractTableModel {
    private final String[] colunas = {"Placa", "Marca", "Modelo", "Ano", "Preço da diária"};
    private List<Veiculo> dados = new ArrayList<>();
    public void setDados(List<Veiculo> dados) { this.dados = dados; fireTableDataChanged(); }
    public Veiculo getItem(int linha) { return dados.get(linha); }
    @Override public int getRowCount() { return dados.size(); }
    @Override public int getColumnCount() { return colunas.length; }
    @Override public String getColumnName(int coluna) { return colunas[coluna]; }
    @Override public Object getValueAt(int linha, int coluna) {
        Veiculo v = dados.get(linha);
        switch (coluna) {
            case 0: return v.getPlaca();
            case 1: return v.getMarca();
            case 2: return v.getModelo();
            case 3: return String.valueOf(v.getAno());
            case 4: return Formatador.moeda(v.getValorDiariaLocacao());
            default: return null;
        }
    }
}
