package com.mediaapp.mapp;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data // for generating getter-setter-toString-hashcode-equals methods
@Entity // denotes this is a JPA entity Object
@Table(name="playlist")
public class Playlist {

    @GeneratedValue(strategy = GenerationType.AUTO) // denotes that this is an auto generated type field
    @Id // denotes this is a primary key
    private BigInteger id; // this is a Big Integer id


    private String name;

    @Column(name = "created_on") // name of the database column this field should be mapped to
    @JsonProperty("created_on") // name of the database column this field should be mapped to
    private Date createdOn;

    @ElementCollection(targetClass = java.util.HashSet.class) // specified a collection of instances of a basic type or embeddable/nested class
    @OneToMany(cascade = CascadeType.ALL) // specifies a many-valued association with one-to-many multiplicity
    @JoinColumn //specifies a column for joining an entity association or element collection
    private Collection<Song> songs;

}
