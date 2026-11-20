/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package locadora.exception;

/**
 *
 * @author Vitor Savi
 */
public class VeiculoIndisponivelException extends Exception {

    /**
     * Creates a new instance of <code>VeiculoIndisponivelException</code>
     * without detail message.
     */
    public VeiculoIndisponivelException() {
    }

    /**
     * Constructs an instance of <code>VeiculoIndisponivelException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public VeiculoIndisponivelException(String msg) {
        super(msg);
    }
}
