/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.model;

import java.util.Calendar;
import locadora.model.enums.Categoria;
import locadora.model.enums.Estado;
import locadora.model.enums.Marca;

/**
 *
 * @author Vitor Savi
 */
public abstract class Veiculo implements VeiculoI {
    private Marca marca;
    private Estado estado;
    private Locacao locacao;
    private Categoria categoria;
    private double valorDeCompra;
    private String placa;
    private int ano;

    public Veiculo(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano) {
        this.marca = marca;
        this.estado = estado;
        this.locacao = locacao;
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }
    
    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        this.estado = Estado.LOCADO;
        locacao = new Locacao(dias, dias * getValorDiariaLocacao(), data, cliente);
    }
    
    @Override
    public void vender() {
        this.estado = Estado.VENDIDO;
    }
    
    @Override
    public void devolver() {
        this.estado = Estado.DISPONIVEL;
        this.locacao = null;
    }

    @Override
    public Marca getMarca() {
        return marca;
    }

    @Override
    public Estado getEstado() {
        return estado;
    }

    @Override
    public Locacao getLocacao() {
        return locacao;
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public int getAno() {
        return ano;
    }
    
    @Override
    public double getValorParaVenda() {
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        int idade = anoAtual - this.ano;
        double valorVenda = this.valorDeCompra - (idade * 0.15 * this.valorDeCompra);
        
        if (valorVenda < this.valorDeCompra * 0.1) {
            valorVenda = this.valorDeCompra * 0.1;
        }
        
        return valorVenda;
    }
    
    @Override
    public abstract double getValorDiariaLocacao();
    
    public abstract Enum<?> getModelo();
    
}
