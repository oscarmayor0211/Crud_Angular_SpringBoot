/**
 * 
 */
package com.project.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.Market;

import com.project.service.MarketService;

import lombok.RequiredArgsConstructor;

/**
 * @author Oscar Mayor
 *
 */

@RestController
@RequestMapping("/projects/markets")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MarketController {
	private final MarketService marketService;

	
	//Rutas Market
		@GetMapping("/market")
		ResponseEntity<List<Market>> getAllmarket(){
			return ResponseEntity.ok().body(marketService.getAllMarket());
		}
		
	
		@PostMapping
		ResponseEntity<Market> createMarket(@RequestBody Market market){
			return ResponseEntity.ok().body(this.marketService.createMarket(market));
		}
		
		@PutMapping("/{id}/edit")
		ResponseEntity<Market> updateMarket(@PathVariable Long id , @RequestBody Market market){
			market.setId_market(id);
			return ResponseEntity.ok().body(this.marketService.updateMarket(market));
		}
		
		@DeleteMapping("/{id}/delete")
		ResponseEntity<?> deleteMarket(@PathVariable Long id){
			this.marketService.deleteMarket(id);
			return ResponseEntity.noContent().build();
		}
}
