package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "barrow")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Barrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barrowid;

    @NotBlank
    private String memberid;

    @NotBlank
    private String nameofbook;

    @NotBlank
    private String authorofbook;

    @NotBlank
    private String numberofdates;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getBarrowid() {
        return barrowid;
    }

    public void setBarrowid(Long barrowid) {
        this.barrowid = barrowid;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getNameofbook() {
        return nameofbook;
    }

    public void setNameofbook(String nameofbook) {
        this.nameofbook = nameofbook;
    }

    public String getAuthorofbook() {
        return authorofbook;
    }

    public void setAuthorofbook(String authorofbook) {
        this.authorofbook = authorofbook;
    }

    public String getNumberofdates() {
        return numberofdates;
    }

    public void setNumberofdates(String numberofdates) {
        this.numberofdates = numberofdates;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
