package com.couchbase.learn.model;

import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.Date;


@Data
@Document
@RequiredArgsConstructor
public class User {
    @Id
    private int id;
    @Field
    @QueryIndexed
    private String email;
    @Field
    private String fullName;
    @Field
    private Date birthDate;
    @Field
    private Gender gender;
    @Field
    private Sport sport;
}