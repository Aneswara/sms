package com.sms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Section;
import com.sms.serviceimpl.SectionServiceImpl;

@RestController
@RequestMapping("api/section/v1")
public class SectionController {

	Logger logger = LoggerFactory.getLogger(SectionController.class);
	@Autowired
	private SectionServiceImpl sectionServiceImpl;

	@PostMapping("/createSection")
	public ResponseEntity<Section> createSection(Section section) {
		try {
			section = sectionServiceImpl.createSection(section);
			return new ResponseEntity<Section>(section, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("error created in section creation");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/updateSection")
	public ResponseEntity<Section> updateSection(Section section) {
		try {
			section = sectionServiceImpl.updateSection(section);
			return new ResponseEntity<Section>(section, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in section updation");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findAllSections")
	public ResponseEntity<List<Section>> findAllSections() {
		try {
			List<Section> section = sectionServiceImpl.findAllSections();
			return new ResponseEntity<List<Section>>(section, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in find all sections");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/deleteSection")
	public ResponseEntity<Section> deleteSection(Long sectionId) {
		try {
			Section section = sectionServiceImpl.deleteSection(sectionId);
			return new ResponseEntity<Section>(section, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in section deletion");
			return new ResponseEntity<>(null, HttpStatus.TOO_MANY_REQUESTS);
		}
	}
}
