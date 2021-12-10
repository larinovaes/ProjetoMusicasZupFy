package br.com.zup.Zupfy.musica;

import br.com.zup.Zupfy.musica.dtos.MusicaDetalhesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaService musicaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private MusicaDetalhesDTO cadastrarMusica(MusicaDetalhesDTO musicaDetalhesDTO) {
     Musica musica = modelMapper.map(musicaDetalhesDTO, Musica.class);
     musicaService.cadastrarMusica(musica);
     musicaDetalhesDTO = modelMapper.map(musica, MusicaDetalhesDTO.class);
     return musicaDetalhesDTO;
    }
}
