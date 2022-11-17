package com.adem.readingisgood.mapper;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface BaseMapper<E, D> {

    D entityToDto(E entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @InheritInverseConfiguration
    E dtoToEntity(D dto, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    default List<D> listEntityToListDto(final List<E> entity, final @Context CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<D> listDto = new ArrayList<>();
        entity.forEach(e -> listDto.add(entityToDto(e, cycleAvoidingMappingContext)));
        return listDto;
    }

    default List<E> listDtoToListEntity(final List<D> dto, final @Context CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<E> listEntity = new ArrayList<>();
        dto.forEach(d -> listEntity.add(dtoToEntity(d, cycleAvoidingMappingContext)));
        return listEntity;
    }

    void update(@MappingTarget E entity, D updatedDto);
}
