package com.accesdades.mongo.Model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class VideoGame implements Serializable {
	@Id
    private String id;
    private String game;
    private String gameLink;
    private int year;
    private String genre;
    private String dev;
    private String devLink;
    private String publisher;
    private String publisherLink;
    private String platform;
    private String platformLink;
}
