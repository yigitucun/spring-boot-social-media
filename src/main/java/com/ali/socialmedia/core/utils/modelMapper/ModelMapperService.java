package com.ali.socialmedia.core.utils.modelMapper;

import org.modelmapper.ModelMapper;

import java.util.List;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
    <E,D> List<D> toEntity(List<E> entities, Class<D> dto);
    <E,D> E toEntity(Class<E> entity, D dto);

}
