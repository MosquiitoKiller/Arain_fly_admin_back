package ru.mosquiito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long id;

    private String email;

    private Integer accountStatus;

    private Date createDate;

}
