package com.samuliak.test.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObjectNotFoundException extends Exception {

    String message;

}
