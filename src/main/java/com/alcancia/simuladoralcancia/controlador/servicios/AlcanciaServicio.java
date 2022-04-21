/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcancia.simuladoralcancia.controlador.servicios;

import com.alcancia.simuladoralcancia.exeptions.MonedaNoPermitidaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Danie
 */
@Service
public class AlcanciaServicio {

    private static final List<Integer> monedasPermitidas = Arrays.asList(50, 100, 200, 500, 1000);

    private List<Integer> monedas = new ArrayList<>();

    /**
     * aregamos dinero a la alcancia
     * @param moneda 
     */
    
    public void agregarMonedas(int moneda) {

        //verificar moneda permitida
        verificarMonedaPermitida(moneda);

        monedas.add(moneda);

    }

    /**
     * se calcula el total de dinero en la alcancia
     * @return 
     */
    public int totalDineroAlcancia() {

        Optional<Integer> total = monedas.stream().reduce(Integer::sum);

        return total.isPresent() ? total.get() : 0;
    }

    /**
     * recibe una denominacion 50, 100, 200, 500, 100
     *
     * @param denominacion
     * @return
     */
    public long contarMonedasPorDenominacion(int denominacion) {

        //verificar moneda permitida
        verificarMonedaPermitida(denominacion);

        long count = monedas.stream().filter(moneda -> moneda == denominacion).count();

        return count;
    }

    private void verificarMonedaPermitida(int moneda) {
        if (!monedasPermitidas.contains(moneda)) {
            throw new MonedaNoPermitidaException("La moneda/denominacion no es permitida en la alcancia");
        }
    }

}
