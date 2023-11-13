package com.manager_api.car.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResponseTypeDocument {
    private int status;
    private String message;
    private List<typeDocument> typeDocument;
}
