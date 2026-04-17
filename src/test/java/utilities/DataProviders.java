package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"\\testData\\WebShop_LoginData.xlsx"; //taking xl file from testdata
		ExcelUtility eu=new ExcelUtility(path); //creating an object for ExcelUtility
		int totalrow=eu.getRowCount("Sheet1");
		int totalcos=eu.getCellCount("Sheet1", 1);
		String logindata[][]=new String[totalrow][totalcos];//created for two dimension array which can store
		
		for(int i=1;i<=totalrow;i++) {          //1  //read the data from xl storing in two dimensional array
			for(int j=0;j<totalcos;j++) {        //0 // i is rows j is columns
				logindata[i-1][j]=eu.getCellData("Sheet1", i, j);  //1,0
			}
			
		}
		return logindata; //returning two dimensional array
	}

}
