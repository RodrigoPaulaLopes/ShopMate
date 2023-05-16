package com.rodrigo.ShopMate.entities;

import com.rodrigo.ShopMate.dtos.InsertUserDto;
import com.rodrigo.ShopMate.dtos.UpdateUserDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_User")
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String password;

    @OneToMany(mappedBy = "User")
    private List<Order> orders = new ArrayList<>();

    public User(Long id, String name, String email, String phone, String password) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
        this.setPassword(password);
    }

    public User(InsertUserDto user) {
        this.setName(user.name());
        this.setEmail(user.email());
        this.setPhone(user.phone());
        this.setPassword(user.password());
    }

    public void atualizar(UpdateUserDto oldUser) {
        this.setId(oldUser.id());
        this.setName(oldUser.name());
        this.setEmail(oldUser.email());
        this.setPhone(oldUser.phone());
        this.setPassword(oldUser.password());
    }
}
