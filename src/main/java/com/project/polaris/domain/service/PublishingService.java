package com.project.polaris.domain.service;

import com.project.polaris.domain.Iservice.IPublishingService;
import com.project.polaris.domain.dto.PublishingDto;
import com.project.polaris.domain.repository.IPublishingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PublishingService implements IPublishingService {

    private final IPublishingRepository iPublishingRepository;

    @Override
    public List<PublishingDto> getAll() {
        return iPublishingRepository.getAll();
    }

    @Override
    public Optional<PublishingDto> getPublishing(Long idPublishing) {
        return iPublishingRepository.getPublishing(idPublishing);
    }

    @Override
    public PublishingDto save(PublishingDto newPublishingDto) {
        return iPublishingRepository.save(newPublishingDto);
    }

    @Override
    public boolean delete(Long idPublishing) {
        if(iPublishingRepository.getPublishing(idPublishing).isEmpty()){
            return false;
        }
        iPublishingRepository.delete(idPublishing);
        return true;
    }
}
