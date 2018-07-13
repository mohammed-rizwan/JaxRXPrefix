/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prefix.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 *
 * @author rizwan
 */
public interface PersistService {

    Map<String,Integer> read(InputStream stream) throws IOException;
    void write(OutputStream stream, Object persistObject) throws IOException;

}
