/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.controller;

import java.util.ArrayList;
import java.util.List;
import locadora.exception.VeiculoIndisponivelException;
import locadora.model.Automovel;
import locadora.model.Motocicleta;
import locadora.model.Van;
import locadora.model.Veiculo;
import locadora.model.enums.Categoria;
import locadora.model.enums.Estado;
import locadora.model.enums.Marca;
import locadora.model.enums.TipoVeiculo;
import locadora.repository.VeiculoRepository;

/**
 *
 * @author Felipe Fernandes
 */
public class VeiculoController {

    private final VeiculoRepository veiculoRepository = VeiculoRepository.getInstance();

    public void incluir(Veiculo veiculo) {
        veiculoRepository.inserir(veiculo);
    }

    public List<Veiculo> filtrar(TipoVeiculo tipo, Marca marca, Categoria categoria, Estado estado) {
        List<Veiculo> resultado = new ArrayList<>();
        for (Veiculo v : veiculoRepository.listarTodos()) {
            if (tipo != null && v.getTipo() != tipo) continue;
            if (marca != null && v.getMarca() != marca) continue;
            if (categoria != null && v.getCategoria() != categoria) continue;
            if (estado != null && v.getEstado() != estado) continue;
            resultado.add(v);
        }
        return resultado;
    }

    public void vender(Veiculo veiculo) throws VeiculoIndisponivelException {
        if (!estaDisponivel(veiculo)) {
            throw new VeiculoIndisponivelException("Este veículo não está disponível para venda.");
        }
        veiculo.vender();
    }
    
    public List<Veiculo> filtrarDisponiveis(TipoVeiculo tipo, Marca marca, Categoria categoria) {
    List<Veiculo> resultado = new ArrayList<>();
    for (Veiculo v : filtrar(tipo, marca, categoria, null)) {
        if (estaDisponivel(v)) {
            resultado.add(v);
        }
    }
    return resultado;
}

    public static boolean estaDisponivel(Veiculo v) {
        return v.getEstado() == Estado.DISPONIVEL || v.getEstado() == Estado.NOVO;
    }
}