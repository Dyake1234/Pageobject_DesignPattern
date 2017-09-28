package com.automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class asd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try 
		{

		FileInputStream fis = new FileInputStream("C:\\Users\\Jake\\Desktop\\TestData.xlsx");
		XSSFWorkbook work = new  XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheetAt(1);
		
		ArrayList<String> list = new ArrayList<String>();
		
		 
		 System.out.println(sheet.getLastRowNum());
		 
				for(int i =1 ; i<sheet.getLastRowNum()+1;i++)
				{
		
					XSSFRow row = sheet.getRow(i);
		
						for (int d = 0; d<row.getLastCellNum();d++)
						{
				
								list.add(row.getCell(d).getStringCellValue());	
			
						}
				}
		
		
				System.out.println(list);
				work.close();
		}
	catch (IOException e){
		e.printStackTrace();
	}
		
	
	}
	
/*	 public ArrayList<String> checkOptions(String excelPath, String sheetname2) throws IOException{
			
			try 
			{

				FileInputStream	fis = new FileInputStream(excelPath);
				XSSFWorkbook workbook = new  XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetname2);
			
			ArrayList<String>	 list = new ArrayList<String>();
			
			 
			 System.out.println(sheet.getLastRowNum());
					for(int i =1 ; i<sheet.getLastRowNum()+1;i++)
					{
						XSSFRow row = sheet.getRow(i);
						
							for (int d = 0; d<row.getLastCellNum();d++)
							{
									list.add(row.getCell(d).getStringCellValue());	
							}
					}
			
			}
		catch (IOException e){
			e.printStackTrace();
		}
			workbook.close();
			return list;
		
		}	 */
}
