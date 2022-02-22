package com.mediaapp.mapp.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

@Data // lombok annotation for generating getters-setters-toString-hashcode-equals methods
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) // for enabling
@Entity // specifies or denotes that this is a JPA entity Object
@Table(name = "song")
public class Song {

    @GeneratedValue(strategy = GenerationType.AUTO) // specifies that this should be
    @Id // primary key of the table
    private BigInteger id;

    private String name;


    @Column(name = "cover_url") // name of the database column this field should be mapped to
    @JsonProperty("cover_url") // name of the JSON key during serialization/deserialization
    private String coverUrl;

    @Column(name = "created_on") // denotes the name of the database column this field should be mapped to
    @JsonProperty("created_on") // name of the database column this field should be mapped to
    private Date createdOn;

    @Column(name = "playlist_id") // the name of the database column this field should be mapped to
    @JsonProperty("playlist_id") // the name of the JSON key during serialization/deserialization
    private BigInteger playlistId;
}
