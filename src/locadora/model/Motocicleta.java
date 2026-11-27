/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.model;

import locadora.model.enums.Categoria;
import locadora.model.enums.Estado;
import locadora.model.enums.Marca;
import locadora.model.enums.ModeloAutomovel;
import locadora.model.enums.ModeloMotocicleta;
import locadora.model.enums.TipoVeiculo;

/**
 *
 * @author Vitor Savi
 */
public class Motocicleta extends Veiculo{
    private ModeloMotocicleta modelo;
    
     
    public Motocicleta(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano, ModeloMotocicleta modelo) {
        super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    @Override
    public double getValorDiariaLocacao() {
         if (this.getCategoria() == Categoria.POPULAR) {
            return 70.0;
        }
        
        if (this.getCategoria() == Categoria.INTERMEDIARIO) {
            return 200.0;
        }
        
        if (this.getCategoria() == Categoria.LUXO) {
            return 350.0;
        }
        
        return 0.0;
    }
    
    @Override
    public Enum<?> getTipo() {
        return TipoVeiculo.MOTOCICLETA;
    }

    @Override
    public Enum<?> getModelo() {
        return this.modelo;
    }
    
}
