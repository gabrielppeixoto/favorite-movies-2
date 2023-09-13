package com.gabrielpeixoto.favoritemovies2.controller;

import com.gabrielpeixoto.favoritemovies2.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public @ResponseBody String hello()
    {
        return "Hello World\n";
    }

    /*
        ResponseBody retorna o objeto como resposta à requisição
     */
    @GetMapping("/{nome}")
    public @ResponseBody String helloWithParams(@PathVariable("nome") String nome)
    {
        return "Hello world and " + nome;
    }

    /*
        ResponseEntity retorna um objeto JSON como resposta à requisição
        RequestBody desserializa o objeto JSON na requisição
     */
    @PostMapping("/body")
    public ResponseEntity<Object> helloWithBody(@RequestBody Person nome)
    {
        Map<String, String> data = new HashMap<>();
        data.put("message", nome.getNome());
        data.put("processedAt", new Date().toString());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}

