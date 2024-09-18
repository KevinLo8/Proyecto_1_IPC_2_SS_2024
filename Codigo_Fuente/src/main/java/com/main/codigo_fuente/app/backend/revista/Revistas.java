/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.revista;

import java.sql.*;

/**
 *
 * @author kevin
 */
public class Revistas {

    public static Revista[] separarRevistas(ResultSet resultSet) {
        Revista[] revistasOut = new Revista[0];

        try {
            while (resultSet.next()) {
                Revista[] revistas = new Revista[revistasOut.length + 1];
                
                for (int i = 0; i < revistasOut.length; i++) {
                    revistas[i] = revistasOut[i];
                }
                
                Revista revista = new Revista();
                revista.crearResInfo(resultSet);
                
                revistas[revistasOut.length] = revista;
                
                revistasOut = revistas;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return revistasOut;
    }
}
