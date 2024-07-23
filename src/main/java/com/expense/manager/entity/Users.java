package com.expense.manager.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Users
{
    @Id
    private Integer id;
    private String name;
    private String moblie;
    private String email;


}
