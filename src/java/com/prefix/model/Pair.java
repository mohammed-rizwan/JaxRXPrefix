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
public class Pair implements Comparable {

    private String name;
    private int score;

    public Pair() {
    }

    public Pair(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if(obj==null || ! (obj instanceof Pair) || ((Pair)obj).getName()==null)
            return false;

        return ((Pair) obj).getName().equals(this.name);

    }

    @Override
    public int compareTo(Object obj) {
        if(obj==null || ! (obj instanceof Pair) || ((Pair)obj).getName()==null)
            return -1;
        return ((Pair)obj).getScore()-this.score;
    }
}