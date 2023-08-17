package com.tpe.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AppLogDTO {

    private String id;

    private String level; // enum type STring olarak girilecek

    private String description;

    private LocalDateTime time;



}
