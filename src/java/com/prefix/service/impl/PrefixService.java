/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prefix.service.impl;

import com.prefix.model.Pair;
import com.prefix.model.TrieNode;
import com.prefix.service.InvertedIndexService;
import com.prefix.service.TrieNodeService;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 *
 * @author rizwan
 */

public class PrefixService {

    private static Map<String,List<Pair>> ividx = new HashMap<>();

    private static TrieNode trie = new TrieNode();

    private static TrieNodeService trieNodeService = new TrieNodeService();

    private static InvertedIndexService invertedIndexService = new InvertedIndexService();

    public synchronized static void populateIndexAndTrie(InputStream is) throws IOException {
        Map<String,Integer> pairs=new JsonService().read(is);
        populateIndexAndTrie(pairs);
    }
    
    public synchronized static void populateIndexAndTrie(Map<String,Integer> pairs) throws IOException {
        ividx=invertedIndexService.populateInvertedIndex(pairs);

        for(String key:ividx.keySet()){
            trie=trieNodeService.insert(trie,key);
        }
    }

    public static List<String> searchPrefix(String prefix){
        Set<String> tokens = trieNodeService.searchPrefix(trie,prefix);
        Set<Pair> pairs = new TreeSet<>();

        for(String tk:tokens){
            pairs.addAll(ividx.get(tk));
        }

        List<String> names = new ArrayList<>();

        for(Pair pair:pairs){
            names.add(pair.getName());
        }
        
        List<String> returnNames = new ArrayList<>();
        int i=1;
        for(String name:names){
            if(i>10)break;
            returnNames.add(name);
            i++;
        }
        
        return returnNames;
    }

    public static Map<String, List<Pair>> getIvidx() {
        return ividx;
    }

    public static TrieNode getTrie() {
        return trie;
    }
    
}
