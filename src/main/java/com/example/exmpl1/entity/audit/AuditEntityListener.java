package com.example.exmpl1.entity.audit;

import java.util.Date;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class AuditEntityListener {


    @PrePersist
    public void prePersist(Auditable target) {
        Date now = new Date();
        target.setCreatedDate(now);
        target.setModifiedDate(now);
    }

    @PreUpdate
    public void preUpdate(Auditable target) {
        Date now = new Date();
        target.setModifiedDate(now);
    }

    @PreRemove
    public void preRemove(Auditable target) {
        Date now = new Date();
        target.setModifiedDate(now);

    }

}
