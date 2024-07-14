package com.poc.attacks_api.ransom.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "ransomware_resources")
public class RansomwareResources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;

    @Column(name = "resources")
    private String resources;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    @JsonBackReference
    private Ransomware ransomware;

    public RansomwareResources() {
    }

    public RansomwareResources(Long id, String resources, Ransomware ransomware) {
        this.id = id;
        this.resources = resources;
        this.ransomware = ransomware;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public Ransomware getRansomware() {
        return ransomware;
    }

    public void setRansomware(Ransomware ransomware) {
        this.ransomware = ransomware;
    }
}
