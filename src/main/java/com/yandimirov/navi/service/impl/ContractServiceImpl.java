package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.model.entity.Contract;
import com.yandimirov.navi.repository.ContractRepository;
import com.yandimirov.navi.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContractServiceImpl implements ContractService {

  @Autowired
  private ContractRepository contractRepository;

  @Override
  public List<Contract> findAll() {
    return contractRepository.findAll();
  }

  @Override
  public Contract findOne(final Long id) {
    return contractRepository.findOne(id);
  }

  @Override
  public Contract save(final Contract contract) {
    return contractRepository.save(contract);
  }

  @Override
  public void delete(final Long id) {
    contractRepository.delete(id);
  }
}
