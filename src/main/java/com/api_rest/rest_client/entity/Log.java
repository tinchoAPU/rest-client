package com.api_rest.rest_client.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "LOG_SEQ_SQL", name = "log_seq")
    Long id;
    String endpoint;
    Date date;

}
