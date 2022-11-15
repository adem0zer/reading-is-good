package com.adem.readingisgood.mapper;

import com.adem.readingisgood.dto.UserDto;
import com.adem.readingisgood.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto entityToDto(User userEntity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @InheritInverseConfiguration
    User dtoToEntity(UserDto userDto, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
