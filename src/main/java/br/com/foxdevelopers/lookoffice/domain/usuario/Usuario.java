package br.com.foxdevelopers.lookoffice.domain.usuario;

import br.com.foxdevelopers.lookoffice.domain.perfil.Perfil;
import br.com.foxdevelopers.lookoffice.domain.permissao.Permissao;
import br.com.foxdevelopers.lookoffice.domain.pessoa.Pessoa;
import br.com.foxdevelopers.lookoffice.domain.usuarioPerfil.UsuarioPerfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id_seq")
    @SequenceGenerator(name = "pessoa_id_seq", sequenceName = "pessoa_id_seq", allocationSize = 1)
    @Column(name = "id")
    @Getter
    @Setter
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Pessoa pessoa;

    @Column(name = "senha")
    @Getter
    @Setter
    private String senha;

    @Column(name = "ultima_senha")
    @Getter
    @Setter
    private String ultimaSenha;

    @Column(name = "dt_alteracao_senha")
    @Getter
    @Setter
    private Date dtAlteracaoSenha;

    @Column(name = "dt_ultimo_login")
    @Getter
    @Setter
    private Date dtUltimoLogin;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "turno")
    @Getter
    @Setter
    private List<UsuarioPerfil> usuarioPerfis;



}

