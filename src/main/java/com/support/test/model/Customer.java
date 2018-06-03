package com.support.test.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<CustomerAccount> accounts;

    public Integer getAge(){
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public Double getBalanceFromAllAccounts(){
        if(accounts!=null && accounts.size()>0){
            return accounts
                    .stream()
                    .map(CustomerAccount::getBalance)
                    .reduce((aDouble, aDouble2) -> aDouble+aDouble2)
                    .get();
        }
        return null;
    }
}
