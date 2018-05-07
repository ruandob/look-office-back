package br.com.foxdevelopers.lookoffice.security.service;

import br.com.foxdevelopers.lookoffice.domain.pessoa.Pessoa;
import br.com.foxdevelopers.lookoffice.domain.pessoa.PessoaService;
import br.com.foxdevelopers.lookoffice.security.jwt.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private PessoaService pessoaService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    		Pessoa pessoa = pessoaService.findByEmail(email);
        if (pessoa == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        } else {
            return JwtUserFactory.create(pessoa);
        }
    }
}