package com.example.test_prodject.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.beans.Transient;
import java.time.LocalDate;

@Data
@Builder

public class Client {

    private String clientId;
    private String name;
    private String middleName;
    private String surname;
    private Long age;
    private LocalDate birthday;
    private String phone;
}

