package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDetails {
	
	public String ReadDetails(String Name) throws IOException
	{

		FileInputStream fis = new FileInputStream(new File("C:\\Casestudy_HotelBooking\\BookingDetails.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet bookingDetails = workbook.getSheetAt(0);
		String Value= "";
		for(int i=1;i<bookingDetails.getLastRowNum();i++)
		{
			XSSFRow row = bookingDetails.getRow(i);
					
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(Name)) {
				Value = row.getCell(1).getStringCellValue();
			}
		}
		workbook.close();
		
		return Value;
		
	}

}
