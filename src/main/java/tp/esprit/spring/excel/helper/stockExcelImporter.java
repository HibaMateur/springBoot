package tp.esprit.spring.excel.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tn.esprit.spring.entity.Stock;

public class stockExcelImporter {
	public List<Stock> excelImport(){
		List<Stock> listStocks=new ArrayList<>();
		String libelleStock="";
		Integer qte=0;
		Integer qteMin=0;
		Long idStock=(long) 0;
		
		String excelFilePathString ="C:\\Users\\mateu\\Downloads\\stocks.xlsx";
		long start = System.currentTimeMillis();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(excelFilePathString);
			Workbook workbook =new XSSFWorkbook(fileInputStream);
			Sheet firstSheet=workbook.getSheetAt(0);
			Iterator<Row> rowIterator=firstSheet.iterator();
			rowIterator.next();
			
			while(rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator= nextRow.cellIterator();
				while(cellIterator.hasNext()) {
					Cell nextCell=cellIterator.next();
					int columnIndex=nextCell.getColumnIndex();
					switch(columnIndex) {
					
					case 0:
						libelleStock=(String)nextCell.getStringCellValue();
						break;
					case 1:
						qte=(int)nextCell.getNumericCellValue();
						break;
					case 2:
						qteMin=(int)nextCell.getNumericCellValue();
						break;
						
					}
					listStocks.add(new Stock(libelleStock,qte,qteMin));
					
				}
			}
			workbook.close();
			long end =System.currentTimeMillis();
			System.out.printf("import done in %d ms \n", (end- start ));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		
		return listStocks;
	}

}
