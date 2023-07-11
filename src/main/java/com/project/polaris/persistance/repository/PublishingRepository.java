package com.project.polaris.persistance.repository;

import com.project.polaris.domain.dto.PublishingDto;
import com.project.polaris.domain.repository.IPublishingRepository;
import com.project.polaris.persistance.crud.IPublishingCrudRespository;
import com.project.polaris.persistance.entity.PublishingEntity;
import com.project.polaris.persistance.mapper.IPublishingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PublishingRepository implements IPublishingRepository {

    private final IPublishingCrudRespository iPublishingCrudRespository;

    private final IPublishingMapper iPublishingMapper;
    @Override
    public List<PublishingDto> getAll() {
        return iPublishingMapper.toPublishingDtoList(iPublishingCrudRespository.findAll());
    }

    @Override
    public Optional<PublishingDto> getPublishing(Long idPublishing) {
        return iPublishingCrudRespository.findById(idPublishing).map(iPublishingMapper::toPublishingDto);
    }

    @Override
    public PublishingDto save(PublishingDto newPublishingDto) {
        PublishingEntity publishingEntity = iPublishingMapper.toPublishingEntity(newPublishingDto);
        return iPublishingMapper.toPublishingDto(iPublishingCrudRespository.save(publishingEntity));
    }

    @Override
    public void delete(Long idPublishing) {
        iPublishingCrudRespository.deleteById(idPublishing);
    }
}
