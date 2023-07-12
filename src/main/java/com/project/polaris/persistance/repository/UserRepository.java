package com.project.polaris.persistance.repository;

import com.project.polaris.domain.dto.UserDto;
import com.project.polaris.domain.repository.IUserRepository;
import com.project.polaris.persistance.crud.IUserCrudRepository;
import com.project.polaris.persistance.entity.UserEntity;
import com.project.polaris.persistance.mapper.IUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository implements IUserRepository {

    private final IUserCrudRepository iUserCrudRespository;
    private final IUserMapper iUserMapper;

    @Override
    public List<UserDto> getAll() {
        return iUserMapper.toUserDtoList(iUserCrudRespository.findAll());
    }

    @Override
    public Optional<UserDto> getUser(Long idUser) {
        return iUserCrudRespository.findById(idUser).map(iUserMapper::toUserDto);
    }

    @Override
    public UserDto save(UserDto newUserDto) {
        UserEntity userEntity = iUserMapper.toUserEntity(newUserDto);
        return iUserMapper.toUserDto(iUserCrudRespository.save(userEntity));
    }

    @Override
    public void delete(Long idUser) {
        iUserCrudRespository.deleteById(idUser);
    }

}
