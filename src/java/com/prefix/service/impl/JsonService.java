/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prefix.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.prefix.controller.PrefixController;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import com.prefix.service.PersistService;
import java.io.OutputStream;
import org.apache.log4j.Logger;
/**
 *
 * @author rizwan
 */
public class JsonService implements PersistService {

    private static ObjectMapper objectMapper = new ObjectMapper();
    
    private static Logger LOGGER = Logger.getLogger(PrefixController.class);

    @Override
    public Map<String,Integer> read(InputStream stream) throws IOException {
        return objectMapper.readValue(new Scanner(stream).useDelimiter("\\A").next().getBytes(),Map.class);
    }

    @Override
    public void write(OutputStream stream, Object persistObject) throws IOException {
        if (stream != null){
            objectMapper.writeValue(stream, persistObject);
        }
        else {
            LOGGER.error("No Outputstream Object defined to persist !!!");
        }
    }
}
