package br.com.literalura.service;

import br.com.literalura.model.Autor;
import br.com.literalura.model.Livro;
import br.com.literalura.repository.AutorRepository;
import br.com.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogoService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public CatalogoService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }


    @Transactional(readOnly = true)
    public List<Livro> listarLivrosRegistrados() {
        return livroRepository.findAllWithAutores();
    }

    @Transactional(readOnly = true)
    public List<Autor> listarAutoresRegistrados() {
        return autorRepository.findAllWithLivros();
    }

    @Transactional(readOnly = true)
    public List<Autor> listarAutoresVivosPorAno(int ano) {
        return autorRepository.buscarAutoresVivosNoAno(ano);
    }

    @Transactional(readOnly = true)
    public List<Livro> listarLivrosPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }
}
