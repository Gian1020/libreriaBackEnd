package org.example.demo.service;

import org.example.demo.repository.AutoriRepository;
import org.example.demo.repository.LibriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoriService {
    @Autowired
    private LibriRepository libriRepository;
    @Autowired
    private AutoriRepository autoriRepository;

    public List<String> listaNazAutori() {
        List<String> listaNazAutori = libriRepository.listaNazAutori();
        return listaNazAutori;
    }
}
