package br.com.foxdevelopers.lookoffice.security.model;

import br.com.foxdevelopers.lookoffice.domain.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

public class CurrentUser {

	@Getter
	@Setter
	private String token;

	@Getter
	@Setter
	private Pessoa pessoa;

	public CurrentUser(String token, Pessoa pessoa) {
		this.token = token;
		this.pessoa = pessoa;
	}

}
