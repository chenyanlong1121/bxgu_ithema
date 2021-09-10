package com.fhh.bxgu.service;

import com.fhh.bxgu.mapper.ADMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ADService {
    @Autowired
    private ADMapper adMapper;
    public List<String> getADList() {
        return adMapper.getADList();
    }
}
