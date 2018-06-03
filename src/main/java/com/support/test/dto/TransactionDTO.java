package com.support.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private Integer accountFrom;
    private Integer accountTo;
    private Double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
