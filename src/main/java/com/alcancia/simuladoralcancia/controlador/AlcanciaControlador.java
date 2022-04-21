/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcancia.simuladoralcancia.controlador;

import com.alcancia.simuladoralcancia.controlador.servicios.AlcanciaServicio;
import com.alcancia.simuladoralcancia.exeptions.MonedaNoPermitidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Danie
 */
@RestController
@RequestMapping("/alcancia")
public class AlcanciaControlador {

    @Autowired
    private AlcanciaServicio alcanciaServicio;

    @PostMapping
    public ResponseEntity agregarMonedas(@RequestBody int moneda) {

        try {
            alcanciaServicio.agregarMonedas(moneda);
            return new ResponseEntity<>("Moneda agregada correctamente", HttpStatus.OK);
        } catch (MonedaNoPermitidaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error agregando moneda", HttpStatus.OK);
        }

    }

    @GetMapping(path = "/totalDinero")
    public ResponseEntity totalDineroAlcancia() {

        int totalDineroAlcancia = alcanciaServicio.totalDineroAlcancia();

        return new ResponseEntity<>(totalDineroAlcancia, HttpStatus.OK);

    }

    /**
     * recibe una denominacion 50, 100, 200, 500, 100
     *
     * @param denominacion
     * @return
     */
    @GetMapping(path = "/contarMonedasPorDenominacion/{denominacion}")
    public ResponseEntity contarMonedasPorDenominacion(@PathVariable("denominacion") Integer denominacion) {
        
        try {
            long total = alcanciaServicio.contarMonedasPorDenominacion(denominacion);

            return new ResponseEntity<>(total, HttpStatus.OK);
        } catch (MonedaNoPermitidaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error contando monedas", HttpStatus.OK);
        }
    }

}
