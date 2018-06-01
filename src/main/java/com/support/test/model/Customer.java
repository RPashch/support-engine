package com.support.test.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "id")
@Table(name = "customs")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "second_name")
    private String secondName;

    @NonNull
    @Column(name = "date_of_bitrh")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "custom")
    private Set<CustomerAccount> accounts;
}
