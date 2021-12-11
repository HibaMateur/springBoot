package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.service.ImportExcelService;
import tp.esprit.spring.excel.helper.ExcelHelper;
import tp.esprit.spring.excel.helper.ResponseMessage;
import tp.esprit.spring.excel.helper.stockExcelImporter;

@RestController
@RequestMapping("/stocks")
@CrossOrigin(origins="http://localhost:4200")
public class ImportExcelController {

	
	List<String> files = new ArrayList<String>();
	   private final Path rootLocation = Paths.get("_Path_To_Save_The_File");
	   @Autowired
	   ImportExcelService excelService;

	   @PostMapping("/upload")
	   public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
	      String message;
	      try {
	         try {
	           excelService.save(file);
	         } catch (Exception e) {
	            throw new RuntimeException("FAIL!");
	         }
	       

	         message = "Successfully uploaded!";
	         return ResponseEntity.status(HttpStatus.OK).body(message);
	      } catch (Exception e) {
	         message = "Failed to upload!";
	         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	      }




}}
