package com.bosonit.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class CustomErrorOutputDto {
    Date datetime;
    int HttpCode;
    String mensaje;
}

