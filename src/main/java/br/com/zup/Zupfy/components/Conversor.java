package br.com.zup.Zupfy.components;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Conversor {

    @Bean
    private ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
