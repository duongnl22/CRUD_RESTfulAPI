package com.example.duongnl_poly_test.service.impl;

import com.example.duongnl_poly_test.dto.StatusDTO;
import com.example.duongnl_poly_test.entity.Status;
import com.example.duongnl_poly_test.repository.StatusRepository;
import com.example.duongnl_poly_test.service.StatusService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<StatusDTO> getAllStatus() {
        List<Status> listStatus = statusRepository.findAll();

        TypeToken<List<StatusDTO>> typeToken = new TypeToken<>() {
        };

        List<StatusDTO> listStatusDTO = mapper.map(listStatus, typeToken.getType());

        return listStatusDTO;
    }
}
