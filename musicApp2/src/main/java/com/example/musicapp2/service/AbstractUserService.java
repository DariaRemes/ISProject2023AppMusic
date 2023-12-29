package com.example.musicapp2.service;

import com.example.musicapp2.model.AbstractUser;

import java.util.List;
import java.util.Optional;

public interface AbstractUserService {
    List<AbstractUser> getAbstractUsers();
    AbstractUser getAbstractUser(Long id);
    AbstractUser saveAbstractUser(AbstractUser abstractUser);

    AbstractUser updateAbstractUser(AbstractUser abstractUser);

    void deleteAbstractUser(Long id);
}
