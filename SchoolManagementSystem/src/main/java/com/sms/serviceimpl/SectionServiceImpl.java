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
			 logger.warn(" ser cr   ->" + section.toString());
		} catch (Exception e) {
			logger.error("section is not created");
		}
		return section;
	}

	
	public Section updateSection(Section section) {
		try {
			section=sectionRepository.save(section);
			logger.warn("  ser ud  ->" + section.toString());
		} catch (Exception e) {
			logger.error("section is not updated");
		}
		return section;
	}

	
	public List<Section> findAllSections() {
		List<Section> section=null;
		try {
			 section=sectionRepository.findAll();
		} catch (Exception e) {
			logger.error("sections not found");
		}
		return section;
	}

	
	public Section deleteSection(Long sectionId) {
		Section section=null;
		try {
			 section=sectionRepository.deleteBySectionId(sectionId);
		} catch (Exception e) {
			logger.error("section is not deleted");
		}
		return section;
	}

}
