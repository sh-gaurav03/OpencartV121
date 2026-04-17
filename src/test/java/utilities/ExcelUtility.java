package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow rw;
	public XSSFCell ce;
	public CellStyle sty;
	String path;
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetName);
		int rwcoun=sh.getLastRowNum();
		wb.close();
		fi.close();
		return rwcoun;
	}
	
	public int getCellCount(String sheetname,int rownum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		rw=sh.getRow(rownum);
		int cellcn=rw.getLastCellNum();
		wb.close();
		fi.close();
		return cellcn;
	}
	
	public String getCellData(String sheetname,int rownum,int column) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		rw=sh.getRow(rownum);
		ce=rw.getCell(column);
		
		DataFormatter df=new DataFormatter();
		String data;
		try {
			data=df.formatCellValue(ce); //Returns the formatted value of a cell as a String regardless
		}catch(Exception e) {
			data="";
		}
		wb.close();
		fi.close();
		return data;
		
	}
	
	public void setCellData(String sheetname,int rownum,int column,String data) throws IOException {
		File xlfile=new File(path);
		if(!xlfile.exists()) {             //If file not exists then create new file
			wb=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			wb.write(fo);
		}
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		
		if(wb.getSheetIndex(sheetname)==-1) {  //If sheet not exists then create new sheet
			wb.createSheet(sheetname);
			
		}
		sh=wb.getSheet(sheetname);
		if(sh.getRow(rownum)==null) {          //If row not exists then create new row
			sh.createRow(rownum);
		}
		
		rw=sh.getRow(rownum);
		ce=rw.createCell(column);
		ce.setCellValue(data);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	public void fillGreenColor(String sheetname,int rownum,int column) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		rw=sh.getRow(rownum);
		ce=rw.getCell(column);
		
		sty=wb.createCellStyle();
		sty.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		sty.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		ce.setCellStyle(sty);
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
	}
	
	public void fillRedColor(String sheetname,int rownum,int column) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		rw=sh.getRow(rownum);
		ce=rw.getCell(column);
		
		sty=wb.createCellStyle();
		sty.setFillForegroundColor(IndexedColors.RED.getIndex());
		sty.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		ce.setCellStyle(sty);
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
	}

}
