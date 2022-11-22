package br.com.api.ysw.DTO;

import br.com.api.ysw.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String username;
    @Email
    private String email;
    @Size(min = 3 , max= 20, message = "o usuario deve conter de 3 a 20 caracteres")
    private String password;

    public UsuarioDTO(Usuario usuario){
        this.username = usuario.getUsername();
        this.email= usuario.getEmail();
        this.password= usuario.getPassword();
    }

//    public static List<Usuario>
}
