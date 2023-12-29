package com.example.musicapp2.service.impl;

import com.example.musicapp2.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl extends AbstractUserServiceImpl implements UserService {
}
