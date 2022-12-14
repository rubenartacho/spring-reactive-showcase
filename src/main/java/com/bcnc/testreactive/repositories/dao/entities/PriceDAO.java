package com.bcnc.testreactive.repositories.dao.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

/**
 * This is the Price Data Access Object. Is used to decouple Data access entities from the core domain entities.
 * It introduces some conversion overhead but in Hexagonal Architecture is necessary to keep domain entities strictly inside the domain so alternate
 * entities are used for data access.
 * Using R2DBC (Reactive DB non blocking, event driven IO) instead of JPA/Hibernate as currently Hibernate uses blocking IO and will degrade
 * reactive performance. So no @Entity .
 */

public class PriceDAO  {
    @Id
    private long priceId;

    @Column("brandID")
    private long brandId;

    @Column("startDate")
    private OffsetDateTime startDate;

    @Column("endDate")
    private OffsetDateTime endDate;

    @Column("priceList")
    private long priceList;

    @Column("productId")
    private long productId;

    @Column("priority")
    private int priority;

    @Column("price")
    private BigDecimal price;

    @Column("currency")
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getPriceId() {
        return priceId;
    }

    public void setPriceId(long priceId) {
        this.priceId = priceId;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public long getPriceList() {
        return priceList;
    }

    public void setPriceList(long priceList) {
        this.priceList = priceList;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PriceDAO{" +
                "priceId=" + priceId +
                ", brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", productId=" + productId +
                ", priority=" + priority +
                ", price=" + price +
                '}';
    }

}
