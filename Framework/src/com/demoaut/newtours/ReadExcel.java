package com.demoaut.newtours;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcel {
	
	public static HashMap<Integer, ArrayList<String>> readSteps(HSSFWorkbook workbook, String sheetName) throws IOException
	{
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		HSSFSheet testcaseSheet = workbook.getSheet(sheetName);
		Row stepRow;
		Cell stepCell;
		for(int i = 1; i <= testcaseSheet.getLastRowNum(); i++)
		{
			ArrayList<String> stepList = new ArrayList<String>();
			stepRow = testcaseSheet.getRow(i);
			for(int j = 0; j < 4; j++)
			{
				stepCell = stepRow.getCell(j); 
				stepList.add(stepCell.getStringCellValue());
			}	
			map.put(i - 1, stepList);
		}				
		return map;
	}

}
