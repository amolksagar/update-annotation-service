package com.byo.springbootmicroservices.updateannotation.domain.service.webservices.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.byo.springbootmicroservices.updateannotation.UpdateAnnotationProxy;
import com.byo.springbootmicroservices.updateannotation.domain.entity.UpdateAnnotation;
import com.byo.springbootmicroservices.updateannotation.domain.model.Annotation;
import com.byo.springbootmicroservices.updateannotation.domain.model.UpdateAnnotationRequest;
import com.byo.springbootmicroservices.updateannotation.service.UpdateAnnotationService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class UpdateAnnotationController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UpdateAnnotationService updateAnnotationService;
	@Autowired
	private UpdateAnnotationProxy updateAnnotationProxy;

	@PutMapping("annotation")
	public ResponseEntity<UpdateAnnotationRequest> updateAnnotation(
			@RequestBody UpdateAnnotationRequest updateAnnotationRequest)
			throws JsonParseException, JsonMappingException, IOException {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("spcId", updateAnnotationRequest.getSpcId());

		RestTemplate restTemplate = new RestTemplate();
		Optional<ResponseEntity<List<Annotation>>> response = Optional.ofNullable(
				restTemplate.exchange("http://localhost:8000/retrieve-annotations-per-statisticalPrgCycleId/{spcId}",
						HttpMethod.GET, null, new ParameterizedTypeReference<List<Annotation>>() {
						}, uriVariables));

		if (response.isPresent()) {
			Optional<List<Annotation>> annotations = Optional.ofNullable(response.get().getBody());

			if (annotations.isPresent()) {
				UpdateAnnotation updateAnnotation = new UpdateAnnotation();
				BeanUtils.copyProperties(updateAnnotationRequest, updateAnnotation);
				Optional<List<Annotation>> result = Optional.ofNullable(annotations.get().stream()
						.filter(annotation -> (annotation.getId() != null
								&& annotation.getId().equals(updateAnnotationRequest.getId())))
						.collect(Collectors.toList()));
				if (result.isPresent()) {
					updateAnnotationService.updateArticle(updateAnnotation);
					UpdateAnnotationRequest ob = new UpdateAnnotationRequest();
					BeanUtils.copyProperties(updateAnnotation, ob);
					return new ResponseEntity<UpdateAnnotationRequest>(ob, HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<UpdateAnnotationRequest>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("annotation-feign")
	public ResponseEntity<UpdateAnnotationRequest> updateAnnotationUsingFeign(
			@RequestBody UpdateAnnotationRequest updateAnnotationRequest)
			throws JsonParseException, JsonMappingException, IOException {

		Optional<List<Annotation>> response = Optional.ofNullable(
				updateAnnotationProxy.retrieveAnnotationsPerStatisticalPrgCycleId(updateAnnotationRequest.getSpcId()));
		if (response.isPresent()) {
			Optional<List<Annotation>> annotations = Optional.ofNullable(response.get());
			if (logger.isDebugEnabled()) {
				logger.info("{}", response);
			}
			if (annotations.isPresent()) {
				UpdateAnnotation updateAnnotation = new UpdateAnnotation();
				BeanUtils.copyProperties(updateAnnotationRequest, updateAnnotation);
				Optional<List<Annotation>> result = Optional.ofNullable(annotations.get().stream()
						.filter(annotation -> (annotation.getId() != null
								&& annotation.getId().equals(updateAnnotationRequest.getId())))
						.collect(Collectors.toList()));
				if (result.isPresent()) {
					updateAnnotationService.updateArticle(updateAnnotation);
					UpdateAnnotationRequest ob = new UpdateAnnotationRequest();
					BeanUtils.copyProperties(updateAnnotation, ob);
					return new ResponseEntity<UpdateAnnotationRequest>(ob, HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<UpdateAnnotationRequest>(HttpStatus.NOT_FOUND);
	}
}
