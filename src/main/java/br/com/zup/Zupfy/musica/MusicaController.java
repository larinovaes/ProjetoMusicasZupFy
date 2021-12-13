package br.com.zup.Zupfy.musica;

import br.com.zup.Zupfy.musica.dtos.MusicaDetalhesDTO;
import br.com.zup.Zupfy.musica.dtos.MusicaResumoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaService musicaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private MusicaDetalhesDTO cadastrarMusica(@RequestBody @Valid MusicaDetalhesDTO musicaDetalhesDTO) {
     Musica musica = modelMapper.map(musicaDetalhesDTO, Musica.class);
     musicaService.cadastrarMusica(musica);
     musicaDetalhesDTO = modelMapper.map(musica, MusicaDetalhesDTO.class);
     return musicaDetalhesDTO;
    }

    @GetMapping
    private List<MusicaResumoDTO> listarMusicas() {
     List<MusicaResumoDTO> resumoDTO = new ArrayList<>();
        for (Musica musicaRef: musicaService.retornarTodasAsMusicas()) {
            MusicaResumoDTO musicaResumoDTO = modelMapper.map(musicaRef, MusicaResumoDTO.class);
            resumoDTO.add(musicaResumoDTO);
        }
        return resumoDTO;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deletarMusica(@PathVariable int id) {
        musicaService.deletarMusica(id);
    }

}
