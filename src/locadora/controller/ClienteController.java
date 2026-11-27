/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.controller;

import java.util.List;
import locadora.exception.ClienteComLocacaoException;
import locadora.model.Cliente;
import locadora.model.Veiculo;
import locadora.model.enums.Estado;
import locadora.repository.ClienteRepository;
import locadora.repository.VeiculoRepository;

/**
 *
 * @author Vitor Savi
 */
public class ClienteController {
    private final ClienteRepository clienteRepository = ClienteRepository.getInstance();
    private final VeiculoRepository veiculoRepository = VeiculoRepository.getInstance();
    
    public void incluir(Cliente cliente) {
        clienteRepository.inserir(cliente);
    }
    
    public void atualizar(Cliente cliente, String nome, String sobrenome, String rg, String cpf, String endereco) {
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setRg(rg);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
    }
    
    public void excluir(Cliente cliente) throws ClienteComLocacaoException {
        if (possuiLocacao(cliente)) {
            throw new ClienteComLocacaoException(
            "Este cliente possui veiculo locado e não pode ser excluído"
            );
        }
        clienteRepository.excluir(cliente);
    }
    
    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }
    
    public List<Cliente> buscar(String termo) {
        if (termo == null || termo.trim().isEmpty()) {
            return clienteRepository.listarTodos();
        }
        return clienteRepository.buscar(termo);
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
