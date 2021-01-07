package com.ljp.test.test;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FoshanOneTest {

	public static final String[] FILENAME_ARRAY = {"1年级-2022届素质能力测试-成绩详情.xls", "1年级-2020届高一第一学期期中-成绩详情.xls", "1年级-2020届高一第一学期期末-成绩详情.xls", "1年级-2020届高一第二学期期中-成绩详情.xls"};
	public static final String[] SHEETNAME_ARRAY = {"2022届素质能力测试", "2020届高一第一学期期中", "2020届高一第一学期期末", "2020届高一第二学期期中"};
	public static final String[] COURSENAME_ARRAY = {"语文", "数学", "英语", "物理", "历史", "语数英物", "语数英史", "政治", "化学", "生物", "地理", "化生名次", "化政名次", "化地名次", "生地名次", "生政名次", "政地名次"};

	public static void main(String[] args) throws Exception {
		Map<String, Map<String, Map<String, Student>>> allMap = new LinkedHashMap<>();
		for (int j = 0; j < 4; j++) {
			HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(new File("C:\\Users\\lezhixing\\Desktop\\one\\" + FILENAME_ARRAY[j]))));
			HSSFSheet sheet = workbook.getSheet(SHEETNAME_ARRAY[j]);
			int totalRowNum = sheet.getLastRowNum();
			List<List<Student>> listList = new ArrayList<>();
			for (int jj = 0; jj < 17; jj++) {
				listList.add(new ArrayList<Student>());
			}
			for (int i = 7; i <= totalRowNum; i++) {
				HSSFRow row = sheet.getRow(i);
				String className = formatCell(row.getCell(0));
				String studentNo = formatCell(row.getCell(1));
				String studentName = formatCell(row.getCell(2));
				Map<String, Map<String, Student>> hahaMap = allMap.get(className + studentName + "（" + studentNo + "）");
				if (hahaMap == null) {
					hahaMap = new LinkedHashMap<>();
				}
				hahaMap.put(SHEETNAME_ARRAY[j], new HashMap<String, Student>());
				allMap.put(className + studentName + "（" + studentNo +"）", hahaMap);

				double yuwen = NumberUtils.toDouble(formatCell(row.getCell(3)), 0D);
				double shuxue = NumberUtils.toDouble(formatCell(row.getCell(4)), 0D);
				double yingyu = NumberUtils.toDouble(formatCell(row.getCell(5)), 0D);
				double wuli = NumberUtils.toDouble(formatCell(row.getCell(6)), 0D);
				double lishi = NumberUtils.toDouble(formatCell(row.getCell(7)), 0D);
				double shengwu = NumberUtils.toDouble(formatCell(row.getCell(10)), 0D);
				double huxue = NumberUtils.toDouble(formatCell(row.getCell(13)), 0D);
				double dili = NumberUtils.toDouble(formatCell(row.getCell(16)), 0D);
				double zhengzhi = NumberUtils.toDouble(formatCell(row.getCell(19)), 0D);

				listList.get(0).add(new Student(className, studentNo, studentName, yuwen, 0));
				listList.get(1).add(new Student(className, studentNo, studentName, shuxue, 0));
				listList.get(2).add(new Student(className, studentNo, studentName, yingyu, 0));
				listList.get(3).add(new Student(className, studentNo, studentName, wuli, 0));
				listList.get(4).add(new Student(className, studentNo, studentName, lishi, 0));
				listList.get(5).add(new Student(className, studentNo, studentName, yuwen + shuxue + yingyu + wuli, 0));
				listList.get(6).add(new Student(className, studentNo, studentName, yuwen + shengwu + yingyu + lishi, 0));

				listList.get(10).add(new Student(className, studentNo, studentName, zhengzhi, 0));
				listList.get(8).add(new Student(className, studentNo, studentName, huxue, 0));
				listList.get(7).add(new Student(className, studentNo, studentName, shengwu, 0));
				listList.get(9).add(new Student(className, studentNo, studentName, dili, 0));
				listList.get(11).add(new Student(className, studentNo, studentName, huxue + shengwu, 0));
				listList.get(12).add(new Student(className, studentNo, studentName,huxue + zhengzhi, 0));
				listList.get(13).add(new Student(className, studentNo, studentName, huxue + dili, 0));
				listList.get(14).add(new Student(className, studentNo, studentName, shengwu + dili, 0));
				listList.get(15).add(new Student(className, studentNo, studentName, shengwu + zhengzhi, 0));
				listList.get(16).add(new Student(className, studentNo, studentName, zhengzhi + dili, 0));
			}
			for (List<Student> list : listList) {
				Collections.sort(list, (o1, o2) -> {
					if (o1.getScore() > o2.getScore()) {
						return -1;
					} else if (o1.getScore() < o2.getScore()) {
						return 1;
					} else {
						return 0;
					}
				});
			}
			for (int i = 0; i < 17; i++) {
				int w = 1;
				int temp = 1;
				double tempScope = -999D;
				List<Student> list = listList.get(i);
				for (Student student : list) {
					double score = student.getScore();
					if (tempScope != score) {
						tempScope = score;
						temp = w;
					}
					student.setRank(temp);
					w++;
					Map<String, Map<String, Student>> tempMap = allMap.get(student.getClassName() + student.getStudentName() + "（" + student.getStudentNo() +"）");
					Map<String, Student> mapp = tempMap.get(SHEETNAME_ARRAY[j]);
					if (mapp == null) {
						mapp = new HashMap<>();
					}
					mapp.put(COURSENAME_ARRAY[i], student);
					tempMap.put(SHEETNAME_ARRAY[j], mapp);
				}
			}
			workbook.close();
		}

		XSSFWorkbook outWb = new XSSFWorkbook();
		XSSFSheet outSheet = outWb.createSheet("佛山一中学生成绩分析表");
		int wd = 0;
		Set<Map.Entry<String, Map<String, Map<String, Student>>>> entrySet = allMap.entrySet();
		for (Map.Entry<String, Map<String, Map<String, Student>>> entry : entrySet) {
			String key = entry.getKey();
			Map<String, Map<String, Student>> hahaMap = entry.getValue();
			Set<Map.Entry<String, Map<String, Student>>> hahaSet = hahaMap.entrySet();
			XSSFRow row = outSheet.createRow(wd);
			row.createCell(0).setCellValue(key);
			XSSFRow a = outSheet.createRow(++wd);
			a.createCell(0).setCellValue("来源");
			a.createCell(1).setCellValue(COURSENAME_ARRAY[0]);
			a.createCell(2).setCellValue("名次");
			a.createCell(3).setCellValue(COURSENAME_ARRAY[1]);
			a.createCell(4).setCellValue("名次");
			a.createCell(5).setCellValue(COURSENAME_ARRAY[2]);
			a.createCell(6).setCellValue("名次");
			a.createCell(7).setCellValue(COURSENAME_ARRAY[3]);
			a.createCell(8).setCellValue("名次");
			a.createCell(9).setCellValue(COURSENAME_ARRAY[4]);
			a.createCell(10).setCellValue("名次");
			a.createCell(11).setCellValue(COURSENAME_ARRAY[5]);
			a.createCell(12).setCellValue("名次");
			a.createCell(13).setCellValue(COURSENAME_ARRAY[6]);
			a.createCell(14).setCellValue("名次");
			for (Map.Entry<String, Map<String, Student>> mm : hahaSet) {
				wd++;
				Map<String, Student> one = mm.getValue();
				XSSFRow b = outSheet.createRow(wd);
				b.createCell(0).setCellValue(mm.getKey());
				b.createCell(1).setCellValue(one.get(COURSENAME_ARRAY[0]).getScore());
				b.createCell(2).setCellValue(one.get(COURSENAME_ARRAY[0]).getRank());
				b.createCell(3).setCellValue(one.get(COURSENAME_ARRAY[1]).getScore());
				b.createCell(4).setCellValue(one.get(COURSENAME_ARRAY[1]).getRank());
				b.createCell(5).setCellValue(one.get(COURSENAME_ARRAY[2]).getScore());
				b.createCell(6).setCellValue(one.get(COURSENAME_ARRAY[2]).getRank());
				b.createCell(7).setCellValue(one.get(COURSENAME_ARRAY[3]).getScore());
				b.createCell(8).setCellValue(one.get(COURSENAME_ARRAY[3]).getRank());
				b.createCell(9).setCellValue(one.get(COURSENAME_ARRAY[4]).getScore());
				b.createCell(10).setCellValue(one.get(COURSENAME_ARRAY[4]).getRank());
				b.createCell(11).setCellValue(one.get(COURSENAME_ARRAY[5]).getScore());
				b.createCell(12).setCellValue(one.get(COURSENAME_ARRAY[5]).getRank());
				b.createCell(13).setCellValue(one.get(COURSENAME_ARRAY[6]).getScore());
				b.createCell(14).setCellValue(one.get(COURSENAME_ARRAY[6]).getRank());
			}
			XSSFRow f = outSheet.createRow(++wd);
			f.createCell(0).setCellValue("来源");
			f.createCell(1).setCellValue(COURSENAME_ARRAY[7]);
			f.createCell(2).setCellValue("名次");
			f.createCell(3).setCellValue(COURSENAME_ARRAY[8]);
			f.createCell(4).setCellValue("名次");
			f.createCell(5).setCellValue(COURSENAME_ARRAY[9]);
			f.createCell(6).setCellValue("名次");
			f.createCell(7).setCellValue(COURSENAME_ARRAY[10]);
			f.createCell(8).setCellValue("名次");
			f.createCell(9).setCellValue(COURSENAME_ARRAY[11]);
			f.createCell(10).setCellValue(COURSENAME_ARRAY[12]);
			f.createCell(11).setCellValue(COURSENAME_ARRAY[13]);
			f.createCell(12).setCellValue(COURSENAME_ARRAY[14]);
			f.createCell(13).setCellValue(COURSENAME_ARRAY[15]);
			f.createCell(14).setCellValue(COURSENAME_ARRAY[16]);
			for (Map.Entry<String, Map<String, Student>> mm : hahaSet) {
				wd++;
				Map<String, Student> one = mm.getValue();
				XSSFRow g = outSheet.createRow(wd);
				g.createCell(0).setCellValue(mm.getKey());
				g.createCell(1).setCellValue(one.get(COURSENAME_ARRAY[7]).getScore());
				g.createCell(2).setCellValue(one.get(COURSENAME_ARRAY[7]).getRank());
				g.createCell(3).setCellValue(one.get(COURSENAME_ARRAY[8]).getScore());
				g.createCell(4).setCellValue(one.get(COURSENAME_ARRAY[8]).getRank());
				g.createCell(5).setCellValue(one.get(COURSENAME_ARRAY[9]).getScore());
				g.createCell(6).setCellValue(one.get(COURSENAME_ARRAY[9]).getRank());
				g.createCell(7).setCellValue(one.get(COURSENAME_ARRAY[10]).getScore());
				g.createCell(8).setCellValue(one.get(COURSENAME_ARRAY[10]).getRank());
				g.createCell(9).setCellValue(one.get(COURSENAME_ARRAY[11]).getRank());
				g.createCell(10).setCellValue(one.get(COURSENAME_ARRAY[12]).getRank());
				g.createCell(11).setCellValue(one.get(COURSENAME_ARRAY[13]).getRank());
				g.createCell(12).setCellValue(one.get(COURSENAME_ARRAY[14]).getRank());
				g.createCell(13).setCellValue(one.get(COURSENAME_ARRAY[15]).getRank());
				g.createCell(14).setCellValue(one.get(COURSENAME_ARRAY[16]).getRank());
			}
			wd += 2;
		}
		outWb.write(new FileOutputStream(new File("C:\\Users\\lezhixing\\Desktop\\one\\outOut.xlsx")));
		outWb.close();
	}

	/**
	 * 格式化列
	 * 
	 * @param cell
	 * @return
	 */
	public static String formatCell(Cell cell) {
		String str = "";
		if (null == cell) {
			return str;
		}
		if (cell.getCellType() == CellType.BLANK) { // 是否为空型
			str = "";
		} else if (cell.getCellType() == CellType.STRING) {// 是否为字符串型
			str = cell.getRichStringCellValue().toString().trim();
		} else if (cell.getCellType() == CellType.NUMERIC) {// 是否为数值型
			if (DateUtil.isCellDateFormatted(cell)) {// 是否为日期型
				try {
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					str = format.format(cell.getDateCellValue()).trim();
				} catch (Exception e) {
					DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
					str = format1.format(cell.getDateCellValue()).trim();
				}
			} else {// 是否为数值型
				if (cell instanceof XSSFCell) {
					str = ((XSSFCell) cell).getRawValue();
				} else {
					double d = cell.getNumericCellValue();
					if (d - (int) d < Double.MIN_VALUE) { // 是否为int型
						str = Integer.toString((int) d).trim();
					} else { // 是否为double型
						str = Double.toString(d);
					}
				}
			}
		}
		return str;
	}

}
