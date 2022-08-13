package com.samuliak.test.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(NON_EMPTY)
public class UserDTO {
    BigDecimal id;
    String fio;

    @Override
    public String toString() {
        return "{\"id\":" + id +
                ", \"fio\":\"" + fio + "\"}" ;
    }
}