package com.byo.springbootmicroservices.updateannotation;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.byo.springbootmicroservices.updateannotation.domain.model.Annotation;

/*Implementation before RibbonClient and Eureka server*/
//@FeignClient(name = "get-annotations-for-spc", url = "localhost:8000")
/*Implementation before FeignClient and Zuul API Gateway server*/
//@FeignClient(name = "get-annotations-for-spc")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "get-annotations-for-spc")
/*
 * Imp Note: To call the microservices through the API gateway you have to call
 * http://hostname:portNumberOfZuulServer/spring-app-name/service-name
 */
public interface UpdateAnnotationProxy {
	/* Implementation before FeignClient and Zuul API Gateway server and Feign client using zuul api server */
	/* @GetMapping("/retrieve-annotations-per-statisticalPrgCycleId/{spcId}") */
	@GetMapping("/get-annotations-for-spc/retrieve-annotations-per-statisticalPrgCycleId/{spcId}")
	public List<Annotation> retrieveAnnotationsPerStatisticalPrgCycleId(@PathVariable String spcId);
}
