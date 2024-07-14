package com.poc.attacks_api.ransom.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ransomware")
public class Ransomware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(name ="name")
    private String name;

    @Column(name ="decryptor")
    private String decryptor;

    @Column(name ="screenshots")
    private String screenshots;

    @Column(name ="ms_detection")
    private String msDetection;

    @Column(name ="ms_info")
    private String msInfo;

    @Column(name ="sandbox")
    private String sandbox;

    @Column(name ="iocs")
    private String iocs;

    @Column(name ="snort")
    private String snort;

    @OneToMany(mappedBy = "ransomware", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private Set<RansomwareAlgo> ransomwareAlgo;

    @OneToMany(mappedBy = "ransomware", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private Set<RansomwareNotes> ransomwareNotes;

    @OneToMany(mappedBy = "ransomware", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private Set<RansomwareExt> ransomwareExt;

    @OneToMany(mappedBy = "ransomware", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private Set<RansomewareExtPattern> ransomewareExtPattern;

    @OneToMany(mappedBy = "ransomware", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private Set<RansomwareResources> ransomwareResources;

    @OneToMany(mappedBy = "ransomware", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private Set<RansomwareAlias> ransomwareAlias;

    @OneToMany(mappedBy = "ransomware", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private Set<RansomwareComments> ransomwareComments;

    public Ransomware() {
    }

    public Ransomware(Long uid, String name, String decryptor, String screenshots, String msDetection, String msInfo, String sandbox, String iocs, String snort, Set<RansomwareAlgo> ransomwareAlgo, Set<RansomwareNotes> ransomwareNotes, Set<RansomwareExt> ransomwareExt, Set<RansomewareExtPattern> ransomewareExtPattern, Set<RansomwareResources> ransomwareResources, Set<RansomwareAlias> ransomwareAlias, Set<RansomwareComments> ransomwareComments) {
        this.uid = uid;
        this.name = name;
        this.decryptor = decryptor;
        this.screenshots = screenshots;
        this.msDetection = msDetection;
        this.msInfo = msInfo;
        this.sandbox = sandbox;
        this.iocs = iocs;
        this.snort = snort;
        this.ransomwareAlgo = ransomwareAlgo;
        this.ransomwareNotes = ransomwareNotes;
        this.ransomwareExt = ransomwareExt;
        this.ransomewareExtPattern = ransomewareExtPattern;
        this.ransomwareResources = ransomwareResources;
        this.ransomwareAlias = ransomwareAlias;
        this.ransomwareComments = ransomwareComments;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecryptor() {
        return decryptor;
    }

    public void setDecryptor(String decryptor) {
        this.decryptor = decryptor;
    }

    public String getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(String screenshots) {
        this.screenshots = screenshots;
    }

    public String getMsDetection() {
        return msDetection;
    }

    public void setMsDetection(String msDetection) {
        this.msDetection = msDetection;
    }

    public String getMsInfo() {
        return msInfo;
    }

    public void setMsInfo(String msInfo) {
        this.msInfo = msInfo;
    }

    public String getSandbox() {
        return sandbox;
    }

    public void setSandbox(String sandbox) {
        this.sandbox = sandbox;
    }

    public String getIocs() {
        return iocs;
    }

    public void setIocs(String iocs) {
        this.iocs = iocs;
    }

    public String getSnort() {
        return snort;
    }

    public void setSnort(String snort) {
        this.snort = snort;
    }

    public Set<RansomwareAlgo> getRansomwareAlgo() {
        return ransomwareAlgo;
    }

    public void setRansomwareAlgo(Set<RansomwareAlgo> ransomwareAlgo) {
        this.ransomwareAlgo = ransomwareAlgo;
    }

    public Set<RansomwareNotes> getRansomwareNotes() {
        return ransomwareNotes;
    }

    public void setRansomwareNotes(Set<RansomwareNotes> ransomwareNotes) {
        this.ransomwareNotes = ransomwareNotes;
    }

    public Set<RansomwareExt> getRansomwareExt() {
        return ransomwareExt;
    }

    public void setRansomwareExt(Set<RansomwareExt> ransomwareExt) {
        this.ransomwareExt = ransomwareExt;
    }

    public Set<RansomewareExtPattern> getRansomewareExtPattern() {
        return ransomewareExtPattern;
    }

    public void setRansomewareExtPattern(Set<RansomewareExtPattern> ransomewareExtPattern) {
        this.ransomewareExtPattern = ransomewareExtPattern;
    }

    public Set<RansomwareResources> getRansomwareResources() {
        return ransomwareResources;
    }

    public void setRansomwareResources(Set<RansomwareResources> ransomwareResources) {
        this.ransomwareResources = ransomwareResources;
    }

    public Set<RansomwareAlias> getRansomwareAlias() {
        return ransomwareAlias;
    }

    public void setRansomwareAlias(Set<RansomwareAlias> ransomwareAlias) {
        this.ransomwareAlias = ransomwareAlias;
    }

    public Set<RansomwareComments> getRansomwareComments() {
        return ransomwareComments;
    }

    public void setRansomwareComments(Set<RansomwareComments> ransomwareComments) {
        this.ransomwareComments = ransomwareComments;
    }
}
