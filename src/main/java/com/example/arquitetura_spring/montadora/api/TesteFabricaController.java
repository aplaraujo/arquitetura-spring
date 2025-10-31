package com.example.arquitetura_spring.montadora.api;

import com.example.arquitetura_spring.montadora.CarroStatus;
import com.example.arquitetura_spring.montadora.Chave;
import com.example.arquitetura_spring.montadora.HondaHRV;
import com.example.arquitetura_spring.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {
    @Autowired // Anotação que injeta uma instância
//    @Qualifier("motorEletrico") // Anotação que expõe o nome do Bean (permite escolher um Bean de cada tipo)
    @MotorAspirado
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}
