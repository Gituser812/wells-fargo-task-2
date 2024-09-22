package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long securityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double value;

    @ManyToOne
    @JoinColumn(name = "portfolioId", nullable = false)
    private Portfolio portfolio;

    protected Security() {
    }

    public Security(String name, double value, Portfolio portfolio) {
        this.name = name;
        this.value = value;
        this.portfolio = portfolio;
    }

    public long getSecurityId() {
        return securityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
