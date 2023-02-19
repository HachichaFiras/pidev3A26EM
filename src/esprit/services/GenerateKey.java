/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class GenerateKey {
    
    public int generate()
    {
        String s = String.valueOf(LocalDateTime.now().getYear()).substring(2)+LocalDateTime.now().getDayOfYear()+LocalDateTime.now().getHour()+LocalDateTime.now().getMinute()+LocalDateTime.now().getSecond();
        
        return Integer.parseInt(s);
       
    }
    
}
