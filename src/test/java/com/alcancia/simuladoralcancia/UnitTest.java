package com.alcancia.simuladoralcancia;

import com.alcancia.simuladoralcancia.controlador.servicios.AlcanciaServicio;
import com.alcancia.simuladoralcancia.exeptions.MonedaNoPermitidaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danie
 */
public class UnitTest {
    
    AlcanciaServicio alcanciaServicio;
    
    @Before
    public void init(){
        alcanciaServicio = new AlcanciaServicio();
    }
    
    @Test
    public void agregarMonedasValidas() {
        
        alcanciaServicio.agregarMonedas(50);
    }
    
    /**
     * lazara una exception
     */
    @Test (expected = MonedaNoPermitidaException.class)
    public void agregarMonedasNOValidas(){
        
        alcanciaServicio.agregarMonedas(150);
    }

    @Test
    public void totalDineroAlcancia() {
        int expected = 1250;
        alcanciaServicio.agregarMonedas(50);
        alcanciaServicio.agregarMonedas(200);
        alcanciaServicio.agregarMonedas(1000);
        Assert.assertEquals(expected,alcanciaServicio.totalDineroAlcancia());
    }
    
    @Test
    public void contarMonedasPorDenominacion() {
        int expected = 3;
        alcanciaServicio.agregarMonedas(50);
        alcanciaServicio.agregarMonedas(50);
        alcanciaServicio.agregarMonedas(50);
        Assert.assertEquals(expected,alcanciaServicio.contarMonedasPorDenominacion(50));
    }
}
