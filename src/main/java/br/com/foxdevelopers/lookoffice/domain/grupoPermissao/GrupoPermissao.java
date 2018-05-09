package br.com.foxdevelopers.lookoffice.domain.grupoPermissao;

import br.com.foxdevelopers.lookoffice.domain.subgrupoPermissao.SubgrupoPermissao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupo_permissao")
@JsonIgnoreProperties({"subgrupoPermissoes"})
public class GrupoPermissao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_permissao_id_seq")
    @SequenceGenerator(name = "grupo_permissao_id_seq", sequenceName = "grupo_permissao_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    @Getter
    @Setter
    private String nome;

    @OneToMany
    @Getter
    @Setter
    private List<SubgrupoPermissao> subgrupoPermissoes;
}
