package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.project.models.Market;
import com.project.repository.MarketRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MarketServiceImpl implements MarketService{
	private final MarketRepository marketRepository;
	
	@Override
	public List<Market> getAllMarket(){
		return marketRepository.findAll();
	}
		
	
	@Override
	public Market createMarket(Market project) {
		return marketRepository.save(project);
	}
	
	@Override
	public Market updateMarket(Market market) {
		Market marketUpdate = marketRepository.findById(market.getId_market()).orElseThrow(()-> new ResourceAccessException("No se encontro el market con el id:" + market.getId_market()));
		
		marketUpdate.setId_market(market.getId_market());
		marketUpdate.setName(market.getName());
		
		marketRepository.save(marketUpdate);
		return marketUpdate;
	}
	
	@Override
	public void deleteMarket(long id) {
		Market market = marketRepository.findById(id).orElseThrow(() -> new ResourceAccessException("No se encontro el market con el id:" + id));
		marketRepository.delete(market);
	}

}
