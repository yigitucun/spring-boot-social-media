package com.ali.socialmedia.core.utils.modelMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelMapperManager implements ModelMapperService {
    private final ModelMapper modelMapper;

    public ModelMapperManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }

    @Override
    public <E, D> List<D> toEntity(List<E> entities, Class<D> dto) {
        return entities.stream().map(e -> this.forResponse()
                .map(e,dto))
                .collect(Collectors.toList());
    }

    @Override
    public <E, D> E toEntity(Class<E> entity, D dto) {
        return this.forRequest().map(dto,entity);
    }
}
