package com.example.exmpl1.audit;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class AuditEntityListener {


    @PrePersist
    public void prePersist(Auditable target) {
        target.setCreatedDate(new Date());
    }

    @PreUpdate
    public void preUpdate(Auditable target) {
        target.setModifiedDate(new Date());
    }

    @PreRemove
    public void preRemove(Auditable target) {
        target.setModifiedDate(new Date());

    }

}
