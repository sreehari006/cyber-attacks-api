package com.poc.attacks_api.ransom.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "ransomware_ext")
public class RansomwareExt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;

    @Column(name = "ext")
    private String ext;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    @JsonBackReference
    private Ransomware ransomware;

    public RansomwareExt() {
    }

    public RansomwareExt(Long id, String ext, Ransomware ransomware) {
        this.id = id;
        this.ext = ext;
        this.ransomware = ransomware;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Ransomware getRansomware() {
        return ransomware;
    }

    public void setRansomware(Ransomware ransomware) {
        this.ransomware = ransomware;
    }
}
