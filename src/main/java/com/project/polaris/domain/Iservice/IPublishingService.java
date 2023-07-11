package com.project.polaris.domain.Iservice;

import com.project.polaris.domain.dto.PublishingDto;

import java.util.List;
import java.util.Optional;

public interface IPublishingService {

    List<PublishingDto> getAll();
    Optional<PublishingDto> getPublishing(Long idPublishing);
    PublishingDto save(PublishingDto newPublishingDto);
    boolean delete(Long idPublishing);
}
