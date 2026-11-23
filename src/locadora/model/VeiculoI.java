/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
public interface VeiculoI {
    
    public void locar(int dias, Calendar data, Cliente cliente);
    
    public void vender();
    
    public void devolver();
    
    public Estado getEstado();
    
    public Marca getMarca();
    
    public Categoria getCategoria();
    
    public Locacao getLocacao();
    
    public String getPlaca();
    
    public int getAno();
    
    public double getValorVenda();
    
    public double getValorDiaLocacao();
            
}
