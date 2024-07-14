package com.poc.attacks_api.ransom.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "ransomware_alias")
public class RansomwareAlias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;

    @Column(name = "alias")
    private String alias;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    @JsonBackReference
    private Ransomware ransomware;

    public RansomwareAlias() {
    }

    public RansomwareAlias(Long id, String alias, Ransomware ransomware) {
        this.id = id;
        this.alias = alias;
        this.ransomware = ransomware;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Ransomware getRansomware() {
        return ransomware;
    }

    public void setRansomware(Ransomware ransomware) {
        this.ransomware = ransomware;
    }
}
