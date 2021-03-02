package io.nrise.sys.test.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name="users")
public class Users implements EntityInterface {
    @Id
    @Column(length = 64, nullable = false)
    private String owner;
    @Column(length = 32, nullable = false)
    private String id;
    @Column(length = 256, nullable = false)
    private String password;

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

    @OneToMany(mappedBy="session")
    @JoinColumn(name = "owner")
    private List<Session> session;
}
