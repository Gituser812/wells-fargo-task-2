package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;

@Entity
public class Portfolio<List extends com.wellsfargo.counselor.entity.List<KafkaProperties.Security>> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long portfolioId;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio")
    private com.wellsfargo.counselor.entity.List<Neo4jProperties.Security> securities;

    protected Portfolio() {
    }

    public Portfolio(String name, Client client) {
        this.name = name;
        this.client = client;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSecurities(com.wellsfargo.counselor.entity.List<KafkaProperties.Security> securities) {

    }
}
