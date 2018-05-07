package br.com.foxdevelopers.lookoffice.domain.pessoa;

import br.com.foxdevelopers.lookoffice.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService extends AbstractService<Pessoa> {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa findByEmail(String email){
        return pessoaRepository.findByEmail(email);
    }
}
