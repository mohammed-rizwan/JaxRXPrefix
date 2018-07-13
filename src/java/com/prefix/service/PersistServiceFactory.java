/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prefix.service;

import com.prefix.service.impl.JsonService;

/**
 *
 * @author rizwan
 */
public class PersistServiceFactory {
    
    private static PersistService jsonService = new JsonService();
   
    
    public static PersistService getPersistService(String service){
        
        switch(service){
            
            case "json": 
                return jsonService;
            
            default: 
                return jsonService; 
        }
        
    }
    
    
}
