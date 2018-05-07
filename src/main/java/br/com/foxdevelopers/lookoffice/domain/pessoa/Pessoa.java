package br.com.foxdevelopers.lookoffice.domain.pessoa;

import br.com.foxdevelopers.lookoffice.security.enums.ProfileEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id_seq")
    @SequenceGenerator(name = "pessoa_id_seq", sequenceName = "pessoa_id_seq", allocationSize = 1)
    @Column(name = "id")
    @Getter
    @Setter
    private long id;

    @Column(name = "nome")
    @Getter
    @Setter
    private String nome;

    @Email
    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @Column(name = "senha")
    @Getter
    @Setter
    private String senha;

    @Column(name = "profile")
    @Getter
    @Setter
    private ProfileEnum profile;


}
