/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

/**
 *
 * @author Asus
 */
public class QueryUtil {
      public static String updateRapport(int id){
        return "update rapport set tittre = ? where id = "  +id ;
    }
    public static String updateIntervention(int id){
        return "update intervention set date = ? where id = "  +id ;
    }
}
