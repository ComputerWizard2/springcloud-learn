package com.luckye.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    //id
    private Long id;
    //流水号
    private String serial;

}