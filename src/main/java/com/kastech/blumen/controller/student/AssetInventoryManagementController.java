package com.kastech.blumen.controller.student;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kastech.blumen.model.student.Asset;

@RestController
@RequestMapping("/api/blumen-api/admin")
public class AssetInventoryManagementController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AssetInventoryManagementService assetInventoryManagementService;

	@ResponseBody
	@PostMapping(path = "/saveAsset/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> saveStudentAsset(@RequestParam("assest") Asset asset) {
		LOGGER.info("Inside saveStudentAsset");	
		try {
			assetInventoryManagementService.saveAsset(asset);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("exception occured while serving request for /saveAsset/v1 {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}	
	
	@ResponseBody
	@GetMapping(path = "/getStudentAsset/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<Asset>> getStudentAsset() {
		LOGGER.info("call received for getCounselorContactsByMoreFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(assetInventoryManagementService.getStudentAsset());
	}
	
	@ResponseBody
	@GetMapping(path = "/deleteAsset/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Integer> deleteAsset(@RequestParam("assetId") Integer assetId) {
		LOGGER.info("call received for getCounselorContactsByMoreFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(assetInventoryManagementService.deleteAsset(assetId));
	}
	

	
	@ResponseBody
	@GetMapping(path = "/search/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Asset>> searchAssets(
			@RequestParam("type") String type,
			@RequestParam("usable") String usable,
			@RequestParam("status") String status,
			@RequestParam("dueDateFrom") String dueDateFrom,
			@RequestParam("dueDateTo") String dueDateTo
			) {
		LOGGER.info("call received for getCounselorContactsByMoreFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(assetInventoryManagementService.searchAssets(type,usable,status,dueDateFrom,dueDateTo));
	}
	
}
