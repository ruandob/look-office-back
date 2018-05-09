package br.com.foxdevelopers.lookoffice.domain.subgrupoPermissao;

import br.com.foxdevelopers.lookoffice.domain.grupoPermissao.GrupoPermissao;
import br.com.foxdevelopers.lookoffice.domain.permissao.Permissao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subgrupo_permissao")
@JsonIgnoreProperties({"permissoes"})
public class SubgrupoPermissao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subgrupo_permissao_id_seq")
    @SequenceGenerator(name = "subgrupo_permissao_id_seq", sequenceName = "subgrupo_permissao_id_seq", allocationSize = 1)
    @Column(name = "id")
    @Getter
    @Setter
    private long id;

    @Column(name = "nome")
    @Getter
    @Setter
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grupo_permissao_id", referencedColumnName = "id")
    @Getter
    @Setter
    private GrupoPermissao grupoPermissao;

    @OneToMany(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<Permissao> permissoes;

}
