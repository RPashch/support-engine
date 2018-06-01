package com.support.test.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "id")
@Table(name = "accounts")
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custom_id")
    private Customer customer;

    @NonNull
    @Column(name = "amount_money")
    private Double balance;
}
