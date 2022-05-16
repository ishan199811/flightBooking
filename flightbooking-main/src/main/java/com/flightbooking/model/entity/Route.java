package com.flightbooking.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Route {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	long routeId;
	
	String source;
	
	String destination;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy="routeId", cascade = CascadeType.ALL)
	Set<Flight> flight;
	
}
