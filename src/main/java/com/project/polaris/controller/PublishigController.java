package com.project.polaris.controller;

import com.project.polaris.domain.Iservice.IPublishingService;
import com.project.polaris.domain.dto.PublishingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/publishings")
public class PublishigController {

    private final IPublishingService iPublishingService;
    @GetMapping
    public ResponseEntity<List<PublishingDto>> getAll(){
        return ResponseEntity.ok(iPublishingService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PublishingDto> getById(@PathVariable Long idPublishing){
        return ResponseEntity.of(iPublishingService.getPublishing(idPublishing));
    }

    @PostMapping
    public ResponseEntity<PublishingDto> save(@RequestBody PublishingDto publishingDto){
        return ResponseEntity.ok(iPublishingService.save(publishingDto));
    }

    @PatchMapping
    public ResponseEntity<PublishingDto> update(@RequestBody PublishingDto editPublishingDto){
        return ResponseEntity.ok(iPublishingService.save(editPublishingDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idPublishing){
        return new ResponseEntity<>(iPublishingService.delete(idPublishing) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
