/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package locadora;

import javax.swing.SwingUtilities;
import locadora.view.TelaPrincipal;

/**
 *
 * @author Vitor Savi e Felipe Fernandes
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}