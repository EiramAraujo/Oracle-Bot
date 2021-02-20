package com.chiron.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.chiron.bot.models.ArchetypeDTO;
import com.chiron.bot.models.TierDTO;
import com.chiron.bot.models.UnitDTO;
import com.chiron.bot.models.DAOs.ArchetypeDAO;
import com.chiron.bot.models.DAOs.TierDAO;
import com.chiron.bot.models.entities.Archetype;
import com.chiron.bot.models.entities.Tier;
import com.chiron.bot.models.entities.Unit;

public class ExcelReader {
	private static ExcelReader instance;
	@Autowired
	ArchetypeDAO archetypeDAO;
	@Autowired
	TierDAO tierDAO;
	
	private ExcelReader() {}
	
	public static final String FILE = "D:\\Programming\\Chiron\\src\\Units.xlsx";
	
	public void getUnits() {
		System.out.println("In method");
		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE));
			Workbook book = new XSSFWorkbook(excelFile);
			Sheet sheet = book.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			
			if(rowIterator.hasNext()) rowIterator.next();
			
			List<Unit> list = new ArrayList<>();
			
			while(rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				Unit unit = 
				
				int cellIdx = 0;
				while(cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					
					switch(cellIdx) {
						case 0:
							unitDTO.setId((int) currentCell.getNumericCellValue());
							break;
						case 1:
							unitDTO.setName(currentCell.getStringCellValue());
							break;
						case 2:
							Optional<Archetype> archEnt = archetypeDAO.findById((int) currentCell.getNumericCellValue());
							ArchetypeDTO archDTO = new ArchetypeDTO();
							BeanUtils.copyProperties(archEnt.get(),archDTO);
							unitDTO.setArchetype(archDTO);
							break;
						case 3:
							Optional<Tier> tierEnt = tierDAO.findById((int) currentCell.getNumericCellValue());
							TierDTO tierDTO = new TierDTO();
							BeanUtils.copyProperties(tierEnt.get(), tierDTO);
							unitDTO.setTier(tierDTO);
							break;
					}
					cellIdx++;
				}
				list.add(unitDTO);
			}
			book.close();
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static ExcelReader getInstance() {
		if(instance == null) {
			instance = new ExcelReader();
		}
		return instance;
	}
}
