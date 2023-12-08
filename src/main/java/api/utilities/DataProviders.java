package api.utilities;

import excelutility.Xls_Reader;
import org.testng.annotations.DataProvider;

public class DataProviders {

    public Xls_Reader xls_reader;

    @DataProvider(name="data")
    public Object[] getAllData(){
        xls_reader = new Xls_Reader("F:\\eclipse\\RestAssured\\src\\main\\java\\excelutility\\data.xlsx.xlsx");
        int rowNum =  xls_reader.getRowCount("Sheet1");
        int columnCnt =  xls_reader.getColumnCount("Sheet1");

        String data[][] = new String[rowNum][columnCnt];

        for(int i=1; i<=rowNum; i++){
            for(int j=0; j<columnCnt; j++){
               data[i][j] =  xls_reader.getCellData("Sheet1",i,j);
            }
        }
        return data;
    }

    @DataProvider(name = "username")
    public Object[] getUserName(){
        xls_reader = new Xls_Reader("F:\\eclipse\\RestAssured\\src\\main\\java\\excelutility\\data.xlsx.xlsx");
          int rouCnt =  xls_reader.getRowCount("Sheet1");
          String[] data = new String[rouCnt];
          for(int i=1; i<=rouCnt; i++){
             data[i] =  xls_reader.getCellData("Sheet1",i,1);
          }
          return data;
    }
}
