package io.nrise.sys.test.entity;

import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Entity(name="session")
@NoArgsConstructor
public class Session implements EntityInterface {
    @Id
    private Long id;

    @Column(name="sessionId", nullable = false)
    private String sessionId;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner")
    private Users users;

}
