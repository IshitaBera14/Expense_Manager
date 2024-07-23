package com.expense.manager.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class PaymentMethods
{
    @Id
    private Integer id;
    private String paymentMethod;

}
