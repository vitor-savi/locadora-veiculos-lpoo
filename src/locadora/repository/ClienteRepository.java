/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.repository;

import java.util.ArrayList;
import java.util.List;
import locadora.model.Cliente;

/**
 *
 * @author Vitor Savi
 */
public class ClienteRepository {
    private static ClienteRepository instancia;
    private List<Cliente> clientes = new ArrayList<>();
    
    private ClienteRepository() { }

    public static ClienteRepository getInstance() {
        if (instancia == null) {
            instancia = new ClienteRepository();
        }
        
        return instancia;
    }
    
    public void inserir(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void excluir(Cliente cliente) {
        clientes.remove(cliente);
    }
    
    public void atualizar(Cliente original, Cliente atualizado) {
        int posicao = clientes.indexOf(original);
        
        if (posicao >= 0) {
            clientes.set(posicao, atualizado);
        }
    }
    
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }
    
    public List<Cliente> buscar(String termo) {
        String t = termo.trim().toLowerCase();
        List<Cliente> resultado = new ArrayList<>();
        
        for (Cliente c : clientes) {
            if (c.getNome().toLowerCase().contains(t)
                    || c.getSobrenome().toLowerCase().contains(t)
                    || c.getCpf().contains(t)) {
                resultado.add(c);
            }
        }
        
        return resultado;
    }
    
}
