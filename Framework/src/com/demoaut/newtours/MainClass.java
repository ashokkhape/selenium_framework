package com.demoaut.newtours;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("/home/ashokkhape/Desktop/Test Suite.xls");
		FileInputStream istream = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(istream);
		HSSFSheet indexSheet = workbook.getSheet("Index");
		Row indexRow;
		
		HashMap<Integer, ArrayList<String>> stepMap = null;
		List<String> stepList = new ArrayList<String>();
		
		KeywordLibrary.loadProperties();
		
		HashMap<String, String> bufferMap = new HashMap<String, String>();
		
		for(int i = 1; i <= indexSheet.getLastRowNum(); i++)
		{
			indexRow = indexSheet.getRow(i);
			if(indexRow.getCell(1).getStringCellValue().equalsIgnoreCase("Yes"))
			{
				stepMap = ReadExcel.readSteps(workbook, indexRow.getCell(0).getStringCellValue());
				System.out.println(stepMap);

				for(int j = 0; j < stepMap.size(); j++)
				{
					stepList = stepMap.get(j);
					if(stepList.get(0).equals("openBrowser"))
					{
						KeywordLibrary.openBrowser();
						WriteExcel.writeStatus(file, workbook, indexRow.getCell(0).getStringCellValue(), j + 1);
						
					}
					else if(stepList.get(0).equals("bufferText"))
					{
						String value;
						value = KeywordLibrary.bufferText(stepList.get(1), stepList.get(2), stepList.get(3));
						bufferMap.put(stepList.get(3), value);
						WriteExcel.writeStatus(file, workbook, indexRow.getCell(0).getStringCellValue(), j + 1);
					}
					else if(stepList.get(0).equals("verifyBuffer"))
					{
						String value = bufferMap.get(stepList.get(3));
						KeywordLibrary.bufferText(stepList.get(1), stepList.get(2), value);
						WriteExcel.writeStatus(file, workbook, indexRow.getCell(0).getStringCellValue(), j + 1);
					}
					else if(stepList.get(0).equals("readPopup"))
					{
						String value;
						value = KeywordLibrary.bufferText(stepList.get(1), stepList.get(2), stepList.get(3));
						bufferMap.put(stepList.get(3), value);
						WriteExcel.writeStatus(file, workbook, indexRow.getCell(0).getStringCellValue(), j + 1);
					}
					else
					{
						KeywordLibrary.callMethod(stepList.get(0), stepList.get(1), stepList.get(2), stepList.get(3));
						WriteExcel.writeStatus(file, workbook, indexRow.getCell(0).getStringCellValue(), j + 1);
					}
				} 
			}
		}

		System.out.println("Done");	
		workbook.close();
	}	
}
