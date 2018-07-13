/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prefix.service;

import com.prefix.model.TrieNode;
import java.util.*;

/**
 *
 * @author rizwan
 */
public class TrieNodeService {

    public TrieNode insert(TrieNode root, String word){

        TrieNode node = root;

        for(int i=0;i<word.length();i++){

           TrieNode charNode=node.getCharMap().get(word.charAt(i));

           if(charNode==null){
               charNode=new TrieNode();
               node.getCharMap().put(word.charAt(i), charNode);
           }
           charNode.getTokens().add(word);
           node = charNode;
        }

        return root;
    }

    public Set<String> searchPrefix(TrieNode root, String prefix){

        TrieNode node = root;

        for(int i=0;i<prefix.length();i++){
            TrieNode charNode = node.getCharMap().get(prefix.charAt(i));
            if(charNode==null){
                return new HashSet<>();
            }
            node = charNode;
        }
        return node.getTokens();
    }
}
