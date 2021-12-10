package br.com.zup.Zupfy.musica;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicaController {
    @Autowired
    private MusicaService musicaService;
    @Autowired
    private ModelMapper modelMapper;

}
