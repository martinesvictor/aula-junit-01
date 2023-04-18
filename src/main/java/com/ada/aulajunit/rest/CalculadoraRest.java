package com.ada.aulajunit.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ada.aulajunit.modelo.Calculadora;

@RestController
@RequestMapping("calculadora")
public class CalculadoraRest {

    @Autowired
    private Calculadora calc;

    @GetMapping("/teste")
    public ResponseEntity<?> teste() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/somar")
    public ResponseEntity<?> somar(@RequestParam(required = true) int n1, @RequestParam(required = true) int n2) {

//        if (n1 < 0 || n2 < 0) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("número inválido");
//        }

        double result = calc.somar(n1, n2);

        Map <String, Object> map = new HashMap<String, Object>();

        List<String> resultados = new ArrayList<String>();
        resultados.add(String.valueOf(result));
        resultados.add("2");

        map.put("resultados", resultados);
        map.put("primeiroNumero", String.valueOf(n1));
        map.put("segundoNumero", String.valueOf(n2));

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

//    @GetMapping("multiplicar")
//    public ResponseEntity<?> multiplicar(@RequestParam(required = true) int n1, @RequestParam(required = true) int n2) {
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    @GetMapping("/multiplicar")
    public ResponseEntity<?> multiplicar(@RequestParam(required = true) int n1, @RequestParam(required = true) int n2) {

        if (n1 < 0 || n2 < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("número inválido");
        }

        double result = calc.multiplicar(n1, n2);

        Map <String, Object> map = new HashMap<String, Object>();

        List<String> resultados = new ArrayList<String>();
        resultados.add(String.valueOf(result));
        resultados.add("2");

        map.put("resultados", resultados);
        map.put("primeiroNumero", String.valueOf(n1));
        map.put("segundoNumero", String.valueOf(n2));

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/subtrair")
    public ResponseEntity<?> subtrair(@RequestParam(required = true) int n1, @RequestParam(required = true) int n2) {

        if (n1 < 0 || n2 < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("número inválido");
        }

        double result = calc.subtrair(n1, n2);

        Map <String, Object> map = new HashMap<String, Object>();

        List<String> resultados = new ArrayList<String>();
        resultados.add(String.valueOf(result));
        resultados.add("2");

        map.put("resultados", resultados);
        map.put("primeiroNumero", String.valueOf(n1));
        map.put("segundoNumero", String.valueOf(n2));

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }


}


