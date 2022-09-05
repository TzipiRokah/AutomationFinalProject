package ReadDtat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

    public RegistrationData readRegistration(String name, int row) {
        FileInputStream f = null;
        XSSFWorkbook workbook = null;
        try {
            f = new FileInputStream(name);
            workbook = new XSSFWorkbook(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheetAt(0);
        RegistrationData newRegistrationData = new RegistrationData();
        newRegistrationData.setFirstName(sheet.getRow(row).getCell(0).getStringCellValue());
        newRegistrationData.setLastName(sheet.getRow(row).getCell(1).getStringCellValue());
        newRegistrationData.setEmail(sheet.getRow(row).getCell(2).getStringCellValue());
        newRegistrationData.setPassword(sheet.getRow(row).getCell(3).getStringCellValue());
        newRegistrationData.setError(sheet.getRow(row).getCell(4).getStringCellValue());

        try {
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newRegistrationData;
    }

    public LoginData readLogin(String name, int row) {
        FileInputStream f = null;
        XSSFWorkbook workbook = null;
        try {
            f = new FileInputStream(name);
            workbook = new XSSFWorkbook(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheetAt(1);
        LoginData newLoginData = new LoginData();
        newLoginData.setEmail(sheet.getRow(row).getCell(0).getStringCellValue());
        newLoginData.setPassword(sheet.getRow(row).getCell(1).getStringCellValue());
        newLoginData.setError(sheet.getRow(row).getCell(2).getStringCellValue());

        try {
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newLoginData;
    }

    public String readSearch(String name, int row) {

        String search;
        FileInputStream f = null;
        XSSFWorkbook workbook = null;
        try {
            f = new FileInputStream(name);
            workbook = new XSSFWorkbook(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheetAt(2);
        search=sheet.getRow(row).getCell(0).getStringCellValue();
        try {
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return search;
    }

    public String readShoppingCart(String name, int row) {

        String search;
        FileInputStream f = null;
        XSSFWorkbook workbook = null;
        try {
            f = new FileInputStream(name);
            workbook = new XSSFWorkbook(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheetAt(3);
        search=sheet.getRow(row).getCell(0).getStringCellValue();
        try {
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return search;
    }
}

