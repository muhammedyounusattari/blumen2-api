package com.kastech.blumen.service.counselor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.kastech.blumen.model.counselor.Counselor;
import com.kastech.blumen.repository.counselor.CounselorRepository;

@Component
public class CounselorServiceV1 {
	
	@Autowired
    CounselorRepository counselorRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CounselorServiceV1.class);

    public Counselor findById(Long id) {
    	return counselorRepository.findById(id).get();
	}

	public List<Counselor> findAll() {
		return counselorRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Counselor save(Counselor counselor) {
		return counselorRepository.save(counselor);
	}
	
	public void deleteById(Long counselorId) {
		counselorRepository.deleteById(counselorId);
	}
    
    
}
