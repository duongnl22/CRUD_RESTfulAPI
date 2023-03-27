package com.example.duongnl_poly_test.service;

import com.example.duongnl_poly_test.dto.StatusDTO;
import com.example.duongnl_poly_test.entity.Status;
import com.example.duongnl_poly_test.repository.StatusRepository;
import com.example.duongnl_poly_test.service.impl.StatusService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<StatusDTO> getAllStatus() {
        List<Status> listStatus = statusRepository.findAll();

        List<StatusDTO> listStatusDTO = new ArrayList<>();

        mapper.map(listStatus, listStatusDTO.stream().collect(Collectors.toList()));
        return listStatusDTO;
    }
}
