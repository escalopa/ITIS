package web.app.lab04.dto;

import lombok.*;
import web.app.lab04.models.Role;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;

    private Long role_id;

}
