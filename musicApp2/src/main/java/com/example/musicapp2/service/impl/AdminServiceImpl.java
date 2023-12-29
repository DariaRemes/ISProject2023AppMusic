package com.example.musicapp2.service.impl;

import com.example.musicapp2.model.Song;
import com.example.musicapp2.repository.AbstractUserRepository;
import com.example.musicapp2.repository.AdminRepository;
import com.example.musicapp2.repository.SongRepository;
import com.example.musicapp2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends AbstractUserServiceImpl implements AdminService {
}
