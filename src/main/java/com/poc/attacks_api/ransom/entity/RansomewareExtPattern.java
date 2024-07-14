package com.poc.attacks_api.ransom.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "ransomware_ext_pattern")
public class RansomewareExtPattern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;

    @Column(name = "ext_pattern")
    private String extPattern;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    @JsonBackReference
    private Ransomware ransomware;

    public RansomewareExtPattern() {
    }

    public RansomewareExtPattern(Long id, String extPattern, Ransomware ransomware) {
        this.id = id;
        this.extPattern = extPattern;
        this.ransomware = ransomware;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtPattern() {
        return extPattern;
    }

    public void setExtPattern(String extPattern) {
        this.extPattern = extPattern;
    }

    public Ransomware getRansomware() {
        return ransomware;
    }

    public void setRansomware(Ransomware ransomware) {
        this.ransomware = ransomware;
    }
}
