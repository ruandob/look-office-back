package br.com.foxdevelopers.lookoffice.domain.usuarioPerfil;

import br.com.foxdevelopers.lookoffice.domain.perfil.Perfil;
import br.com.foxdevelopers.lookoffice.domain.usuario.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario_perfil")
public class UsuarioPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_perfil_id_seq")
    @SequenceGenerator(name = "usuario_perfil_id_seq", sequenceName = "usuario_perfil_id_seq", allocationSize = 1)
    @Column(name = "id")
    @Getter
    @Setter
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Usuario usuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Perfil perfil;

}
