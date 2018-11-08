package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReader {
	
	public static Map<String, Map<String, String>> readTestData() throws IOException {
		
		String path = "Resources/TestData.xlsx";
		
		FileInputStream fis = new FileInputStream(path);
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sh = wb.getSheetAt(0);
		
		int lastRow = sh.getLastRowNum();
		
		Map<String, Map<String, String>> fileMap = new HashMap<String, Map<String, String>>();
		
		Map<String, String> dataMap = new HashMap<String, String>();
		
		for(int i=0; i<=lastRow; i++){
			
			Row row = sh.getRow(i);
			
			Cell keyCol = row.getCell(0);
			String keyData = keyCol.getStringCellValue().trim();
			
			
			Cell valueCol = row.getCell(1);
			String valueData = valueCol.getStringCellValue().trim();
			
			dataMap.put(keyData, valueData);
			
			fileMap.put("TestData", dataMap);

		}
		return fileMap;
		
	}
	
	
	public static String getMapData(String key) throws IOException{
		
		Map<String, String> mapData = readTestData().get("TestData");
		
		String value = mapData.get(key);
		return value;
		
		
	}
	
	

}
