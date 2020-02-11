package com.qardio.auto.mobile.models;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

import static java.util.Objects.requireNonNull;

/**
 * @author Tomash Gombosh
 */
@Data
@AllArgsConstructor
public class User extends Model {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public User(final Consumer<User> builder) {
        requireNonNull(builder).accept(this);
    }
}
