/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prefix.service;


import com.prefix.controller.PrefixController;
import com.prefix.model.Pair;
import java.util.*;
import org.apache.log4j.Logger;


/**
 *
 * @author rizwan
 */
public class InvertedIndexService {
    
    private static Logger LOGGER = Logger.getLogger(PrefixController.class);
    
    public Map<String,List<Pair>> populateInvertedIndex(Map<String,Integer> values){

        Map<String,List<Pair>> iv = new HashMap<>();
        
        if(values == null || values.size() ==0){
            LOGGER.info("No pairs to produce inverted index. Empty inverted index created.");
            return iv;
        }
        
        for(Map.Entry<String,Integer> rec:values.entrySet()){

            String[] splits = rec.getKey().split("_");
            for(String token:splits){
              List<Pair> existingRecord=iv.get(token);
              if(existingRecord==null){
                  existingRecord=new ArrayList<>();
                  iv.put(token,existingRecord);
              }
              existingRecord.add(new Pair(rec.getKey(),rec.getValue()));
            }
        }
        LOGGER.info("Inverted index created successfully .");
        return iv;
    }

    public List<String> getSortedNames(Map<String,List<Pair>> ividx, Set<String> tokens){

        Set<Pair> pairs = new TreeSet<>();

        for(String token:tokens){
            if(ividx.get(token)!=null){
                pairs.addAll(ividx.get(token));
            }
        }

        List<String> names = new ArrayList<>();

        for(Pair pair:pairs){
            names.add(pair.getName());
        }
        return names;
    }
    
}
