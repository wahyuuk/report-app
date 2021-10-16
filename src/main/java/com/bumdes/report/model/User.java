package com.bumdes.report.model;

import com.bumdes.report.util.Gender;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class User extends BaseEntity implements Serializable {

    @NotNull(message = "Nama lengkap tidak boleh kosong")
    @NotEmpty(message = "Nama lengkap tidak boleh kosong")
    private String fullName;

    @NotEmpty(message = "Email tidak boleh kosong")
    @NotNull(message = "Email tidak boleh kosong")
    @Email(message = "Format email tidak sesuai")
    private String email;

    @NotEmpty(message = "Gender tidak boleh kosong")
    @NotNull(message = "Gender tidak boleh kosong")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    private LocalDateTime birthDate;

    @NotEmpty(message = "Username tidak boleh kosong")
    @NotNull(message = "Username tidak boleh kosong")
    @Length(max = 50, min = 6, message = "Username min 6 karaketer max 50 karakter ")
    private String username;

    @NotEmpty(message = "Password tidak boleh kosong")
    @NotNull(message = "Password tidak boleh kosong")
    @Length(max = 50, min = 6, message = "Username min 6 karaketer max 50 karakter ")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{6,}$",
            message = "Format password tidak sesuai"
    )
    private String password;

    @NotNull
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
