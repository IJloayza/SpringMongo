package com.accesdades.mongo.Model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Videogame")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game implements Serializable {
    @Id
    private String id;
    
    @Field("Game")
    private String name;
    
    @Field("GameLink")
    private String gameLink;
    
    @Field("Year")
    private int year;
    
    @Field("Genre")
    private String genre;
    
    @Field("Dev")
    private String dev;
    
    @Field("DevLink")
    private String devLink;
    
    @Field("Publisher")
    private String publisher;
    
    @Field("PublisherLink")
    private String publisherLink;
    
    @Field("Platform")
    private String platform;
    
    @Field("PlatformLink")
    private String platformLink;
}
