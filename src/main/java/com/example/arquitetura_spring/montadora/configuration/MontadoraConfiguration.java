package com.example.arquitetura_spring.montadora.configuration;

import com.example.arquitetura_spring.montadora.Motor;
import com.example.arquitetura_spring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Classe de configuração - registrar um Bean dentro do contexto do Spring Boot
// Bean - componentes configurados uma única vez e que podem ser usados em algum momento da aplicação
@Configuration // Anotação na qual o Spring vai mapear e poderá ser usada em qualquer parte do projeto
public class MontadoraConfiguration {


    @Bean(name = "motorAspirado")
    @Primary // Anotação que mostra que se trata do Bean primário do tipo Motor
    public Motor motorAspirado() {
        var motor = new Motor();
        // Propriedades
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico() {
        var motor = new Motor();
        // Propriedades
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("TH-10");
        motor.setLitragem(1.0);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorTurbo")
    public Motor motorTurbo() {
        var motor = new Motor();
        // Propriedades
        motor.setCavalos(180);
        motor.setCilindros(4);
        motor.setModelo("XPTO-01");
        motor.setLitragem(1.5);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }
}