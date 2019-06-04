package com.avtech.mercury.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
//search for poi jars > click on the latest version > click on .bin.zip >
//	select ..mirrors.ocf.berkeley > download > unzip it > copy all executable unzipped files from to resources >
//	select all added files, right click > build pass > add
	
	public ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
	int colnum = 0;

	public ReadExcel(String fileName) throws InvalidFormatException, IOException {

		File exl = new File(fileName);// "G:\\Selenium\\workspace\\aprilmercuryproject\\mercury_inputs\\RegistrationData.xlsx");
		Workbook wb = new XSSFWorkbook(exl);
		Sheet sht = wb.getSheet("Sheet1");
		for (int r = 0; r < sht.getLastRowNum()+1; r++) {
			ArrayList<String> rownn = new ArrayList<String>();
			for (int c = 0; c < sht.getRow(0).getLastCellNum(); c++) {
				rownn.add(sht.getRow(r).getCell(c).toString());
				colnum = sht.getRow(0).getLastCellNum();
			}
			System.out.println(rownn.toString().replace("]", "").replace("[", ""));
//		System.out.println(rownn);
			rows.add(rownn);
		}
	}
	
	public String getExlDataByName(String name, int rownum) {
		ArrayList<String> array0 = rows.get(0);
//		System.out.println(array0);
		int foundIndex = array0.indexOf(name);
		if (!(foundIndex < 0)) {
//			System.out.println("title: " + array0.get(foundIndex) + ", numOfCol= " + rows.size());//rows.lastIndexOf(0));
		} else
			System.out.println("title not found: " + array0.get(foundIndex));
		return rows.get(rownum).get(foundIndex);
	}
//		for (int i = 0; i < colnum; i++) {
//			String foundCell = rows.get(0).get(i);
//			Boolean ifFoundCell = foundCell.equals(name);
//			if (ifFoundCell == true) {
//				System.out.println("title: " + foundCell);
//				} else
//				System.out.println("title not found: " + foundCell);
//		}
//	}
}
