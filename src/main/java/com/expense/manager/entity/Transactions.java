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


public class Transactions
{
    @Id
    private Integer id;
    private String date;
    private Integer amount;
    private String note;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "userId",
            referencedColumnName = "id"
    )
    private Users user; //table name


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "categoryId",
            referencedColumnName = "id"
    )
    private Categories category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "paymentMethodId",
            referencedColumnName = "id"
    )
    private PaymentMethods paymentMethod;


}

