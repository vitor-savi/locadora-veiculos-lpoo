/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.repository;

import java.util.ArrayList;
import java.util.List;
import locadora.model.Veiculo;

/**
 *
 * @author Vitor Savi
 */
public class VeiculoRepository {
    private static VeiculoRepository instancia;
    private final List<Veiculo> veiculos = new ArrayList<>();
    
    private VeiculoRepository() { }

    public static VeiculoRepository getInstance() {
        if (instancia == null) {
            instancia = new VeiculoRepository();
        }
        
        return instancia;
    }
    
    public void inserir(Veiculo veiculo) {
        veiculos.add(veiculo);
    }
    
    public List<Veiculo> listarTodos() {
        return new ArrayList<>(veiculos);
    }
    
}
