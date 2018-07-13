/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prefix.model;

/**
 *
 * @author rizwan
 */
import java.util.*;

public class TrieNode {

    private Set<String> tokens = new HashSet<>();
    Map<Character,TrieNode> charMap = new HashMap<>();

    public Set<String> getTokens() {
        return tokens;
    }

    public void setTokens(Set<String> tokens) {
        this.tokens = tokens;
    }

    public Map<Character, TrieNode> getCharMap() {
        return charMap;
    }

    public void setCharMap(Map<Character, TrieNode> charMap) {
        this.charMap = charMap;
    }

}
