package com.li.util;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public List readExcel(InputStream is) {
        try {
            // 创建输入流，读取Excel
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        innerList.add(cellinfo);
                    }
                    outerList.add(i, innerList);
                }
                return outerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<List<String>> readExcle2(String fileName) throws Exception {

        //new一个输入流
        FileInputStream inputStream = new FileInputStream(fileName);
        //new一个workbook
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        //创建一个sheet对象，参数为sheet的索引
        HSSFSheet sheet = workbook.getSheetAt(0);
        //new出存放一张表的二维数组
        List<List<String>> allData = new ArrayList<List<String>>();

        for (Row row:sheet) {
            List<String> oneRow = new ArrayList<String>();
            //不读表头
            if(row.getRowNum()==0)
                continue;
            for (Cell cell : row) {
                cell.setCellType(cell.CELL_TYPE_STRING);
                oneRow.add(cell.getStringCellValue().trim());
            }
            allData.add(oneRow);
        }

        for (int i = 0; i < allData.size(); i++) {
//            System.out.println(allData.get(i));
        }
        //关闭workbook
        workbook.close();
        return allData;
    }


    @Test
    public void test(){
        String path = "E:\\IDEA-workspace\\SeleniumLab\\src\\main\\resources\\bing\\lab\\Selenium+Lab2020.xls";
        List<List<String>> res = null;
        try {
            res = readExcle2(path);
            System.out.println(res.size());
            for(List<String> row:res){
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
