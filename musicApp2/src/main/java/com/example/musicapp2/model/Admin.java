package com.example.musicapp2.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@DiscriminatorValue("admin")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Admin extends AbstractUser{

}
