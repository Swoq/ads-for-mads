package com.swoqe.adsformads.model.dto;

import com.swoqe.adsformads.model.BaseSqlEntity;
import com.swoqe.adsformads.model.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "prices")
@Data
public class Price extends BaseSqlEntity {

    private BigDecimal value;

    @OneToOne()
    @JoinColumn(name = "orderId", referencedColumnName = "id", nullable = false)
    private Order orderId;
}
