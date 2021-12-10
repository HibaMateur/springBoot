package tn.esprit.spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.service.DetailProduitServiceImpl;


@RestController
@RequestMapping("/detailproduits")
public class DetailProduitController {
	DetailProduitServiceImpl detailProduit;
	@PostMapping("/add-detail-produit")
	
	public DetailProduit addDetailProduit(@RequestBody DetailProduit dp)
	{
		DetailProduit detailprod = detailProduit.addDetailProduit(dp);
		return detailprod;
	}
}
