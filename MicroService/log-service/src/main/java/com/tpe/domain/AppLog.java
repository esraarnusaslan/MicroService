package com.tpe.domain;

import com.tpe.enums.AppLogLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document// postgre olsaydi entity olurdu ama mongodb
public class AppLog {

    @Id
    private String id;


    private String description;

    private LocalDateTime time;

    private AppLogLevel level;//pom a ekledik


}
