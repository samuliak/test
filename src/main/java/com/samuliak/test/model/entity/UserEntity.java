package com.samuliak.test.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigDecimal id;

    String fio;

    @Override
    public String toString() {
        return "{\"id\":" + id +
                ", \"fio\":\"" + fio + "\"}" ;
    }
}
