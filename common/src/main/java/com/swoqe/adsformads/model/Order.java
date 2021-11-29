package com.swoqe.adsformads.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "c_order")
@Data
public class Order extends BaseSqlEntity {
    private String template;

    @OneToOne()
    @JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
    private Customer customer;
}
