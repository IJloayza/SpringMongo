package com.accesdades.mongo.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.accesdades.mongo.DTO.GameCreateDTO;
import com.accesdades.mongo.DTO.GameResponseDTO;
import com.accesdades.mongo.Model.Game;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GameMapper {

    GameResponseDTO toDTO(Game videoGame);

    // El mismo nombre pero con diferente signature. Mas facil de usar
    Game toModel(GameResponseDTO videoGameDTO);
    Game toModel(GameCreateDTO videoGameDTO);

    void updateFromDto(GameCreateDTO dto, @MappingTarget Game entity);

}