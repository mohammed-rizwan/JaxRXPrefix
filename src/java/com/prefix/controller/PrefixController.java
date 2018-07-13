/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prefix.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prefix.service.PersistService;
import com.prefix.service.PersistServiceFactory;
import com.prefix.service.impl.PrefixService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;




/**
 *
 * @author rizwan
 */

@Path("/api")
public class PrefixController {
    
    private static ObjectMapper om = new ObjectMapper();
    
    private static Logger LOGGER = Logger.getLogger(PrefixController.class);
    
    private static PersistService persistService = PersistServiceFactory.getPersistService("json");
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPairs(String values) {
        try {
            PrefixService.populateIndexAndTrie(om.readValue(values, Map.class));
            LOGGER.info("Inverted Index & Trie populated successfully. Persisting the objects now...");
            persistService.write(null, PrefixService.getIvidx());
            persistService.write(null, PrefixService.getTrie());
        } catch (Exception ex) {
            LOGGER.error("Error occured while saving the pairs. ");
            LOGGER.error(ex.getMessage());
        }
    }
    
    @GET
    public String getPairs(@QueryParam(value="prefix") String prefix) {
        try{
            LOGGER.info("Querying the Trie & Index to search for the prefix : "+prefix);
            List<String> str = PrefixService.searchPrefix(prefix);
            return om.writeValueAsString(str);
        } catch(Exception ex){
            LOGGER.error("Error while querying for the prefix : "+prefix);
        }
        return "";
    }
}
