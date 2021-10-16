package com.bumdes.report.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Role extends BaseEntity implements Serializable {

    @NotNull(message = "Nama role tidak boleh kosong")
    @NotEmpty(message = "Nama role tidak boleh kosong")
    private String name;

    @OneToMany
    private Set<User> users;
}
