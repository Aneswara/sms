package com.sms.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dao.SectionRepository;
import com.sms.model.Section;
import com.sms.service.SectionService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {

	Logger logger=LoggerFactory.getLogger(SectionServiceImpl.class);
	@Autowired
	private SectionRepository sectionRepository;
	
	public Section createSection(Section section) {
		try {
			 section = sectionRepository.save(section);
			 return section;
		} catch (Exception e) {
			logger.error("section is not created");
			return null;
		}
		
	}

	
	public Section updateSection(Section section) {
		try {
			section=sectionRepository.save(section);
			return section;
		} catch (Exception e) {
			logger.error("section is not updated");
			return null;
		}
		
	}

	
	public List<Section> findAllSections() {
		try {
			List<Section> section=sectionRepository.findAll();
			return section;
		} catch (Exception e) {
			logger.error("sections not found");
			return null;
		}
		
	}

	
	public Section deleteSection(Long sectionId) {
		try {
			Section section=sectionRepository.deleteBySectionId(sectionId);
			return section;
		} catch (Exception e) {
			logger.error("section is not deleted");
			return null;
		}
	}

}
