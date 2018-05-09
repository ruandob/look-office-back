package br.com.foxdevelopers.lookoffice.domain.permissao;

import br.com.foxdevelopers.lookoffice.domain.perfil.Perfil;
import br.com.foxdevelopers.lookoffice.domain.subgrupoPermissao.SubgrupoPermissao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissao_id_seq")
    @SequenceGenerator(name = "permissao_id_seq", sequenceName = "permissao_id_seq", allocationSize = 1)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subgrupo_permissao", referencedColumnName = "id")
    @Getter
    @Setter
    private SubgrupoPermissao subgrupoPermissao;

    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "permissoes")
    @Getter
    @Setter
    private List<Perfil> perfis;
}
