/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Formatador {

    private static final DecimalFormat MOEDA =
            new DecimalFormat("R$#,##0.00", new DecimalFormatSymbols(Locale.forLanguageTag("pt-BR")));

    private static final SimpleDateFormat DATA = new SimpleDateFormat("dd/MM/yyyy");

    private Formatador() { }

    public static String moeda(double valor) {
        return MOEDA.format(valor);
    }

    public static String data(Calendar data) {
        return DATA.format(data.getTime());
    }

    public static Calendar lerData(String texto) throws ParseException {
        DATA.setLenient(false);
        Calendar c = Calendar.getInstance();
        c.setTime(DATA.parse(texto));
        return c;
    }
}
