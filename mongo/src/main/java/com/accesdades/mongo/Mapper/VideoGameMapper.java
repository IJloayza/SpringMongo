package com.accesdades.mongo.Mapper;

import org.mapstruct.Mapper;

import com.accesdades.mongo.DTO.VideoGameDTO;
import com.accesdades.mongo.Model.VideoGame;

@Mapper
public class VideoGameMapper {
    private String id;
    private String camp_1;
    private int camp_2;

}