package com.itennishy.db.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "t_app")
@Data
@Accessors(chain = true)
public class App implements Persistable<String> {
    @Id
    private String id;
    private String appname;
    private List<Object> activities;
    private boolean persisted;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

    @Override
    public boolean isNew() {
        return !persisted;
    }
}
