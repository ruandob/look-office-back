package br.com.foxdevelopers.lookoffice.security.jwt;

import java.util.ArrayList;
import java.util.List;

import br.com.foxdevelopers.lookoffice.domain.pessoa.Pessoa;
import br.com.foxdevelopers.lookoffice.security.enums.ProfileEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class JwtUserFactory {
	 private JwtUserFactory() {
	    }

	    public static JwtUser create(Pessoa pessoa) {
	        return new JwtUser(
					pessoa.getId(),
					pessoa.getEmail(),
					pessoa.getSenha(),
	                mapToGrantedAuthorities(pessoa.getProfile())
	        );
	    }

	    private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
	    		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
	    		authorities.add(new SimpleGrantedAuthority(profileEnum.toString())); 
	    		return   authorities ;
	    }
}
