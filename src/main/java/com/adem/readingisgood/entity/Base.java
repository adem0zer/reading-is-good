package com.adem.readingisgood.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Base implements Serializable {
    @CreatedDate
    @Basic
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Basic
    @Column(name = "updated_date")
    private Date updatedDate;

    @PrePersist
    public void setInitialValuesOnPrePersist() {
        this.createdDate = new Date();
    }

    @PreUpdate
    public void setInitialValuesOnPreUpdate() {
        this.updatedDate = new Date();
    }
}
