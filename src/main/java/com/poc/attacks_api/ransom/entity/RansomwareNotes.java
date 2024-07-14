package com.poc.attacks_api.ransom.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "ransomware_notes")
public class RansomwareNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    @JsonBackReference
    private Ransomware ransomware;

    public RansomwareNotes() {
    }

    public RansomwareNotes(Long id, String notes, Ransomware ransomware) {
        this.id = id;
        this.notes = notes;
        this.ransomware = ransomware;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Ransomware getRansomware() {
        return ransomware;
    }

    public void setRansomware(Ransomware ransomware) {
        this.ransomware = ransomware;
    }
}
