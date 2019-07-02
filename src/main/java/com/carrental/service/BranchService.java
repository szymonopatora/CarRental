package com.carrental.service;

import com.carrental.common.dto.BranchDto;
import com.carrental.persistence.entity.Branch;
import com.carrental.persistence.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public void saveBranch(BranchDto branchDto){
        Branch branch = new Branch(branchDto.getId(), branchDto.getAddress());
        branchRepository.save(branch);
    }

    public List<Branch> findAllBranches(){
        return branchRepository.findAll();
    }

    public Branch findBranchById(Long branchId){
        return branchRepository.getOne(branchId);
    }
}
