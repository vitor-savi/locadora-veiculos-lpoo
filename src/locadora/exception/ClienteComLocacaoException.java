/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package locadora.exception;

/**
 *
 * @author Vitor Savi
 */
public class ClienteComLocacaoException extends Exception {

    /**
     * Creates a new instance of <code>ClienteComLocacaoException</code> without
     * detail message.
     */
    public ClienteComLocacaoException() {
    }

    /**
     * Constructs an instance of <code>ClienteComLocacaoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ClienteComLocacaoException(String msg) {
        super(msg);
    }
}
