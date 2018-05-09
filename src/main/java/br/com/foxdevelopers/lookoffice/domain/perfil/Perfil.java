package br.com.foxdevelopers.lookoffice.domain.perfil;

import br.com.foxdevelopers.lookoffice.domain.permissao.Permissao;
import br.com.foxdevelopers.lookoffice.domain.usuarioPerfil.UsuarioPerfil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_id_seq")
    @SequenceGenerator(name = "perfil_id_seq", sequenceName = "perfil_id_seq", allocationSize = 1)
    @Column(name = "id")
    @Getter
    @Setter
    private long id;

    @Column(name = "nome")
    @Getter
    @Setter
    private String nome;

    @Column(name = "descricao")
    @Getter
    @Setter
    private String descricao;

    @JoinTable(name = "perfil_permissao", joinColumns = {
            @JoinColumn(name = "perfil_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "permissao_id", referencedColumnName = "id")})
    @ManyToMany
    @Getter
    @Setter
    private List<Permissao> permissoes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unidade")
    @Getter
    @Setter
    private List<UsuarioPerfil> usuarioPerfis;
}
