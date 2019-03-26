package com.byo.springbootmicroservices.updateannotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byo.springbootmicroservices.updateannotation.domain.entity.UpdateAnnotation;
import com.byo.springbootmicroservices.updateannotation.repository.UpdateAnnotationRepository;

@Service
public class UpdateAnnotationService implements IUpdateAnnotationService {

	@Autowired
	private UpdateAnnotationRepository updateAnnotationRepository;

	@Override
	public void updateArticle(UpdateAnnotation updateAnnotation) {
		updateAnnotationRepository.save(updateAnnotation);
	}

}
