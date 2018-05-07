package br.com.foxdevelopers.lookoffice.security.jwt;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
    @Setter
	private String email;

	@Getter
    @Setter
    private String senha;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String email, String senha) {
        this.setEmail(email);
        this.setSenha(senha);
    }
}
