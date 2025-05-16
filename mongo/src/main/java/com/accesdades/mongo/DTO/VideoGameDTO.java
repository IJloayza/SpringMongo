package com.accesdades.mongo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class VideoGameDTO {
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
