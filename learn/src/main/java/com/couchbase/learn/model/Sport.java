package com.couchbase.learn.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Data
@Document
@RequiredArgsConstructor
public class Sport {
    @Id
    private int id;
    @Field
    @QueryIndexed
    private String sportName;
    @Field
    private SportProficiency sportProficiency;
}
