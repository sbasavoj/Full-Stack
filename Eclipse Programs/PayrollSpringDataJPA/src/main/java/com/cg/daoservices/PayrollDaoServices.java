package com.cg.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.beans.Associate;
public interface PayrollDaoServices extends JpaRepository<Associate, Integer>{}
