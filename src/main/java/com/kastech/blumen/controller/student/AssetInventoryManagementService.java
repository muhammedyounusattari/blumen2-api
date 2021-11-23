package com.kastech.blumen.controller.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.student.Asset;
import com.kastech.blumen.repository.student.AssetInventoryManagementRepository;

@Service
public class AssetInventoryManagementService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired
	private AssetInventoryManagementRepository assetInventoryManagementRepository;
	
	public void saveAsset(Asset asset) {
		LOGGER.info("call made for saveAsset {}", asset);
//		assetInventoryManagementRepository.save(asset);
	}

	public List<Asset> getStudentAsset() {
//		assetInventoryManagementRepository.findAll();
		return getAsset();
	}

	public Integer deleteAsset(Integer assetId) {
	/*	Optional<Asset> asset = assetInventoryManagementRepository.findById(assetId);
		if(asset!=null && asset.isPresent())
			assetInventoryManagementRepository.delete(asset.get()); */
		return 1;
	}

	public List<Asset> searchAssets(String type, String usable, String status, String dueDateFrom, String dueDateTo) {
		//List<Asset> assetList = assetInventoryManagementRepository.findByTypeORUsable(type,usable,status,dueDateFrom,dueDateTo);
		return getAsset();
	}

	/**
	 * TODO
	 * Replace this method with actual db calls
	 * @return
	 */
	private List<Asset> getAsset(){
		Asset asset1 = new Asset(1, "NotEntered", "description", "inStock", "make", "123456", "model", "status", "purDate", "purPrice", 
				"loanDate", "checkOutTo", "dueDate", "notes", "lastInventoriedBy", "lastInventoriedDate", "lastLoanedTo", 
				"lastLoanedDate", "lastReturnedBy", "lastReturnedDate", null, null);
		Asset asset2 = new Asset(2, "NotEntered", "description", "inStock", "make", "123456", "model", "status", "purDate", "purPrice", 
				"loanDate", "checkOutTo", "dueDate", "notes", "lastInventoriedBy", "lastInventoriedDate", "lastLoanedTo", 
				"lastLoanedDate", "lastReturnedBy", "lastReturnedDate", null, null);
		List<Asset> assetList = new ArrayList<>();
		assetList.add(asset1);
		assetList.add(asset2);
		
		return assetList;
	}
}
