package com.example.musicapp2.service.impl;

import com.example.musicapp2.model.AbstractUser;
import com.example.musicapp2.model.Song;
import com.example.musicapp2.repository.AbstractUserRepository;
import com.example.musicapp2.service.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AbstractUserServiceImpl implements AbstractUserService {
    @Autowired
    private AbstractUserRepository abstractUserRepository;
    @Override
    public List<AbstractUser> getAbstractUsers() {
        return abstractUserRepository.findAll();
    }

    @Override
    public AbstractUser getAbstractUser(Long id) {
        Optional<AbstractUser> abstractUser = abstractUserRepository.findById(id);
        if(abstractUser.isPresent()){
            return abstractUser.get();
        }
        throw new RuntimeException("Song not found with id : " + id);
    }

    @Override
    public AbstractUser saveAbstractUser(AbstractUser abstractUser) {
        return abstractUserRepository.save(abstractUser);
    }

    @Override
    public AbstractUser updateAbstractUser(AbstractUser abstractUser) {
        return abstractUserRepository.save(abstractUser);
    }

    @Override
    public void deleteAbstractUser(Long id) {
           abstractUserRepository.deleteById(id);
    }
}
