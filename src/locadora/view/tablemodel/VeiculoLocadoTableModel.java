package locadora.view.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import locadora.model.Cliente;
import locadora.model.Locacao;
import locadora.model.Veiculo;
import locadora.util.Formatador;

public class VeiculoLocadoTableModel extends AbstractTableModel {
    private final String[] colunas = {"Nome do Cliente", "Placa", "Marca", "Modelo", "Ano", "Data Locação", "Preço Diária", "Quantidade de dias locado", "Valor Locação"};
    private List<Veiculo> dados = new ArrayList<>();
    public void setDados(List<Veiculo> dados) { this.dados = dados; fireTableDataChanged(); }
    public Veiculo getItem(int linha) { return dados.get(linha); }
    @Override public int getRowCount() { return dados.size(); }
    @Override public int getColumnCount() { return colunas.length; }
    @Override public String getColumnName(int coluna) { return colunas[coluna]; }
    @Override public Object getValueAt(int linha, int coluna) {
        Veiculo v = dados.get(linha); Locacao l = v.getLocacao(); Cliente c = l.getCliente();
        switch (coluna) {
            case 0: return c.getNome() + " " + c.getSobrenome();
            case 1: return v.getPlaca();
            case 2: return v.getMarca();
            case 3: return v.getModelo();
            case 4: return String.valueOf(v.getAno());
            case 5: return Formatador.data(l.getData());
            case 6: return Formatador.moeda(v.getValorDiariaLocacao());
            case 7: return l.getDias();
            case 8: return Formatador.moeda(l.getValor());
            default: return null;
        }
    }
}
