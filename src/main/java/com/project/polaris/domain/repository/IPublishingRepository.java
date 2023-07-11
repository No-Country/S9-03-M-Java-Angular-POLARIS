package com.project.polaris.domain.repository;

import com.project.polaris.domain.dto.PublishingDto;

import java.util.List;
import java.util.Optional;

public interface IPublishingRepository {

    List<PublishingDto> getAll();
    Optional<PublishingDto> getPublishing(Long idPublishing);
    PublishingDto save(PublishingDto newPublishingDto);
    void delete(Long idPublishing);
}
