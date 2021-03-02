package io.nrise.sys.test.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name="session")
public class Session implements EntityInterface {
    @Id
    @Column(length = 64, nullable = false)
    private Long owner;

    @Column(name = "ipV4", nullable = false)
    private String ip;

    @Column(name = "lastAccessAt", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastAccessAt;

    @Column(name = "createdAt", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updatedAt;

    @PrePersist
    protected void prePersist() {
        if (this.createdAt == null) createdAt = new Date();
        if (this.updatedAt == null) updatedAt = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "owner")
    private Users users;

}
