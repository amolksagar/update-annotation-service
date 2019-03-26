package com.byo.springbootmicroservices.updateannotation.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.byo.springbootmicroservices.updateannotation.domain.entity.UpdateAnnotation;

public interface UpdateAnnotationRepository extends JpaRepository<UpdateAnnotation, Long> {
	List<UpdateAnnotation> findBySpcId(String spcId);
}
