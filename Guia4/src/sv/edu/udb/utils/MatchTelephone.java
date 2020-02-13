/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.utils;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author usuario
 */
public class MatchTelephone {

    public static void main(String[] args) {
        comparePhone("7123-4444");
    }

    public static boolean comparePhone(String phone) {
        String expresion = "(2|7)\\d{3}-\\d{4}";

        Pattern pat = Pattern.compile(expresion);
        Matcher mat = pat.matcher(phone);
        if (mat.matches()) {
            System.out.println("Si hace match");
            return TRUE;
        }

        return FALSE;
    }
}
