/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.model;

import locadora.model.enums.Categoria;
import locadora.model.enums.Estado;
import locadora.model.enums.Marca;
import locadora.model.enums.ModeloMotocicleta;
import locadora.model.enums.ModeloVan;

/**
 *
 * @author Vitor Savi
 */
public class Van extends Veiculo{
    private ModeloVan modelo;
    
    public Van(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano, ModeloVan modelo) {
        super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    @Override
    public double getValorDiariaLocacao() {
         if (this.getCategoria() == Categoria.POPULAR) {
            return 200.0;
        }
        
        if (this.getCategoria() == Categoria.INTERMEDIARIO) {
            return 400.0;
        }
        
        if (this.getCategoria() == Categoria.LUXO) {
            return 660.0;
        }
        
        return 0.0;
    }

    @Override
    public Enum<?> getModelo() {
        return this.modelo;
    }
    
}
