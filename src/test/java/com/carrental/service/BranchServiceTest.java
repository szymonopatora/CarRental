package com.carrental.service;

import com.carrental.CarRentalApplication;
import com.carrental.common.dto.BranchDto;
import com.carrental.persistence.embeddable.Address;
import com.carrental.persistence.entity.Branch;
import com.carrental.persistence.repository.BranchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CarRentalApplication.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class BranchServiceTest {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BranchService branchService;

    @Test
    public void shouldSaveBranch() {
        //given
        Address address = new Address();
        address.setCountry("Poland");
        BranchDto branchDto = new BranchDto(1L, address);
        int expectedSize = 1;
        //when
        branchService.saveBranch(branchDto);
        int size = branchRepository.findAll().size();
        //then
        assertEquals(expectedSize, size);
    }

    @Test
    public void shouldFindAllBranches(){
        //given
        createThreeBranches();
        int expectedSize = 3;
        //when
        List<Branch> allBranches = branchService.findAllBranches();
        int size = allBranches.size();
        //then
        assertEquals(expectedSize, size);
    }

    @Test
    public void shouldFindBranchById(){
        //given
        createThreeBranches();
        Address address2 = new Address("Wielka", "22/11", "62-433", "Poznań", "Polska");
        Branch expectedBranch = new Branch(3L, address2);
        //when
        Branch branchById = branchService.findBranchById(3L);
        //then
        assertEquals(expectedBranch, branchById);
    }

    private void createThreeBranches(){
        Address address1 = new Address("Mala", "2/1", "60-433", "Poznań", "Polska");
        Address address2 = new Address("Wielka", "22/11", "62-433", "Poznań", "Polska");
        Branch branch1 = new Branch(address1);
        Branch branch2 = new Branch(address1);
        Branch branch3 = new Branch(address2);
        branchRepository.save(branch1);
        branchRepository.save(branch2);
        branchRepository.save(branch3);
    }
}