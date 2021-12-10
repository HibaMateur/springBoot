package tn.esprit.spring.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import tn.esprit.spring.entity.Stock;

public interface  ExcelFileService {
	ByteArrayInputStream export(List<Stock> stocks);

}
