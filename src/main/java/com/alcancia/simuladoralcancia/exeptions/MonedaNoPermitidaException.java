/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcancia.simuladoralcancia.exeptions;

/**
 *
 * @author Danie
 */
public class MonedaNoPermitidaException extends RuntimeException{

    public MonedaNoPermitidaException(String string) {
        super(string);
    }

    public MonedaNoPermitidaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
