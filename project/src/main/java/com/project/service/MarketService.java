package com.project.service;

import java.util.List;

import com.project.models.Market;

public interface MarketService {

    Market createMarket(Market market);
	
	Market updateMarket(Market market);
		
	List<Market> getAllMarket();
		
	void deleteMarket(long id);
}
