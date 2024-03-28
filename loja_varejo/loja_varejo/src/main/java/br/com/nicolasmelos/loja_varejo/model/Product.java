package br.com.nicolasmelos.loja_varejo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;
    @Column(nullable = false)
    private float cost;
}
