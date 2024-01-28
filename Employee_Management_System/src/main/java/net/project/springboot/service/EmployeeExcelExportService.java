package net.project.springboot.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.project.springboot.model.Employee;

public class EmployeeExcelExportService {

	public static ByteArrayInputStream exportToExcel(List<Employee> employees) {
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Sheet sheet = workbook.createSheet("Employees_Details");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Employee ID");
            headerRow.createCell(1).setCellValue("Employee Name");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Contact");
            headerRow.createCell(4).setCellValue("Address");
            headerRow.createCell(5).setCellValue("Salary");
            headerRow.createCell(6).setCellValue("Designation");
            headerRow.createCell(7).setCellValue("Role");
            headerRow.createCell(8).setCellValue("Experience");
            headerRow.createCell(9).setCellValue("currentProjectDetails");
           
            // ... Add other headers for each field

            // Add data rows
            int rowNum = 1;
            for (Employee employee : employees) {
                Row row = sheet.createRow(rowNum++);
                
                row.createCell(0).setCellValue(employee.getId());
                row.createCell(1).setCellValue(employee.getFirstName() +" "+ employee.getLastName());
                row.createCell(2).setCellValue(employee.getEmail());
                row.createCell(3).setCellValue(employee.getContact());
                row.createCell(4).setCellValue(employee.getAddress());
                row.createCell(5).setCellValue(employee.getSalary());
                row.createCell(6).setCellValue(employee.getDesignation());
                row.createCell(7).setCellValue(employee.getRole());
                row.createCell(8).setCellValue(employee.getExperience());
                row.createCell(9).setCellValue(employee.getCurrentProjectDetails());
                // ... Add other fields
            }

            workbook.write(out);
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
