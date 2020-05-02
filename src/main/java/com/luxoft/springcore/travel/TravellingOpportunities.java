package com.luxoft.springcore.travel;

import com.luxoft.springcore.objects.City;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TravellingOpportunities {
	
	private List<Connection> connections;

	public List<Connection> getConnections() {
		return Collections.unmodifiableList(connections);
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

	public Optional<Connection> getConnection(City source, City destination) {
		return getConnections().stream()
				.filter(connection ->
					connection.getSource().equals(source) && connection.getDestination().equals(destination))
				.findFirst();
	}
}
