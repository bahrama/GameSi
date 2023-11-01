package ir.gamesi.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    @PrePersist
    protected void onCreateDate(){
        this.createDate = new Date();
    }
    @PreUpdate
    protected void onUpdateDate(){
        this.createDate = new Date();
    }
    @PreRemove
    protected void onRemove(){
    }
}
