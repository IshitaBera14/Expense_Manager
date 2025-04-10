package com.expense.manager.entity;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Categories
{
    @Id
    private Integer id;
    private String categoryName;


}
