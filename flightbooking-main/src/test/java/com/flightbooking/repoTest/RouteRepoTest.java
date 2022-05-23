package com.flightbooking.repoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import com.flightbooking.model.entity.Route;
import com.flightbooking.repository.RouteRepository;

import com.flightbooking.service.serviceImpl.RouteServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class RouteRepoTest {
	
	@InjectMocks
	RouteServiceImpl service;
	
	@Mock
	RouteRepository repo;
	
	//RoutefindBySourceAndDestination
	@Test
	 void getRoute() {
		String source="bombay";
		String destination="delhi";
		when(repo.findBySourceAndDestination(source, destination)).thenReturn(new Route( 1L,"bombay","delhi"));
		assertEquals(true,repo.findBySourceAndDestination(source, destination).getDestination().contains(destination));
		
	}
	
	//RoutefindBySource
	@Test
	 void getRouteBySource() {
		String source="bombay";
		when(repo.findBySource(source)).thenReturn( Stream.of(new Route( 1L,"bombay","delhi"),new Route((long) 2,"nepal","delhi")).collect(Collectors.toList()));
		assertEquals(true,repo.findBySource(source).toString().contains(source));
		
	}
	
	//RoutefindByDestination
	@Test
	 void getRouteByDestination() {
		String destination="delhi";
		when(repo.findByDestination(destination)).thenReturn( Stream.of(new Route( 1L,"bombay","delhi"),new Route((long) 2,"nepal","delhi")).collect(Collectors.toList()));
		assertEquals(true,repo.findByDestination(destination).toString().contains(destination));
		
	}
	
	
	//RoutefindById
	@Test
	 void getRouteById() {
		long id=1;
		when(repo.findByRouteId(id)).thenReturn( new Route(1L,"bombay","delhi"));
		assertEquals(true,repo.findByRouteId(id).getRouteId()==1);
			}
}
