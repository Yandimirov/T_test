package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.model.entity.Contract;
import com.yandimirov.navi.repository.ContractRepository;
import com.yandimirov.navi.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return StreamSupport
                .stream(contractRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Contract findOne(long id) {
        return contractRepository.findOne(id);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void delete(long id) {
        contractRepository.delete(id);
    }
}
