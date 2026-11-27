/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import locadora.exception.ClienteComLocacaoException;
import locadora.exception.VeiculoIndisponivelException;
import locadora.model.Cliente;
import locadora.model.Veiculo;
import locadora.model.enums.Estado;
import locadora.repository.VeiculoRepository;

/**
 *
 * @author Felipe Fernandes
 */
public class LocacaoController {

    private final VeiculoRepository veiculoRepository = VeiculoRepository.getInstance();

    public void locar(Veiculo veiculo, Cliente cliente, int dias, Calendar data)
            throws VeiculoIndisponivelException, ClienteComLocacaoException {
        if (!VeiculoController.estaDisponivel(veiculo)) {
            throw new VeiculoIndisponivelException("Este veículo não está disponível para locação.");
        }
        if (possuiLocacao(cliente)) {
            throw new ClienteComLocacaoException("Este cliente já possui um veículo locado.");
        }
        if (dias <= 0) {
            throw new IllegalArgumentException("A quantidade de dias deve ser maior que zero.");
        }
        veiculo.locar(dias, data, cliente);
    }

    public void devolver(Veiculo veiculo) {
        if (veiculo.getEstado() == Estado.LOCADO) {
            veiculo.devolver();
        }
    }

    public List<Veiculo> listarLocados() {
        List<Veiculo> locados = new ArrayList<>();
        for (Veiculo v : veiculoRepository.listarTodos()) {
            if (v.getEstado() == Estado.LOCADO) {
                locados.add(v);
            }
        }
        return locados;
    }

    private boolean possuiLocacao(Cliente cliente) {
        for (Veiculo v : veiculoRepository.listarTodos()) {
            if (v.getEstado() == Estado.LOCADO && v.getLocacao().getCliente() == cliente) {
                return true;
            }
        }
        return false;
    }
}