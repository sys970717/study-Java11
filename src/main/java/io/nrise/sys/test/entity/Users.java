package io.nrise.sys.test.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name="users")
@Table(name="users")
public class Users implements EntityInterface {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long owner;
    @Column(length = 32, nullable = false)
    private String id;
    @Column(length = 256, nullable = false)
    private String password;

    @Column(name = "lastAccessAt", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastAccessAt;

    @Column(name = "createdAt", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdAt;

    @Column(name = "updatedAt", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updatedAt;

    @PrePersist
    protected void prePersist() {
        if (this.createdAt == null) createdAt = new Date();
        if (this.updatedAt == null) updatedAt = new Date();
    }

    @OneToMany(mappedBy="users")
    private List session;

    private Users(String id, String password) {
        this.setId(id);
        this.setPassword(password);
    }

    public static Users join (@NonNull String id, @NonNull String password) {
        return new Users(id, password);
    }
}
