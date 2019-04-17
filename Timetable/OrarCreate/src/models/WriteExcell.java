package models;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import control.mainControl;

public class WriteExcell {
	private int count = 7;
	HSSFWorkbook workbook = new HSSFWorkbook();
	private HSSFFont font = workbook.createFont();
	private HSSFFont font3 = workbook.createFont();
	private HSSFFont font2 = workbook.createFont();
	private HSSFCellStyle style = workbook.createCellStyle();
	private HSSFCellStyle style2 = workbook.createCellStyle();
	private HSSFCellStyle style3 = workbook.createCellStyle();
	private HSSFCellStyle style4 = workbook.createCellStyle();
	private HSSFCellStyle style5 = workbook.createCellStyle();
	private HSSFCellStyle style6 = workbook.createCellStyle();
	private HSSFCellStyle style7 = workbook.createCellStyle();
	private HSSFCellStyle style8 = workbook.createCellStyle();
	private HSSFCellStyle style9 = workbook.createCellStyle();
	private HSSFCellStyle style10 = workbook.createCellStyle();
	private HSSFCellStyle mergedStyle = workbook.createCellStyle();
	private HSSFCellStyle mergedStyle2 = workbook.createCellStyle();
	private String prevDisciplina = "";
	private IntervalOrar prevInter = new IntervalOrar(0, 0);
	private CadruDidactic tempo;
	private String prevZi = "";
	private LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashMap<Boolean, LinkedHashSet<Sala>>>> test;
	private LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashMap<Boolean, LinkedHashSet<CadruDidactic>>>> test2;
	PrintWriter writer;
	public WriteExcell() {
		test = new LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashMap<Boolean, LinkedHashSet<Sala>>>>();
		test2 = new LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashMap<Boolean, LinkedHashSet<CadruDidactic>>>>();
		try {
			writer = new PrintWriter("iterations.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addTest12(String zi, IntervalOrar inter, Boolean bool, Sala sal, CadruDidactic cad) {
		if (test.get(zi) == null) {
			LinkedHashSet<Sala> temp1 = new LinkedHashSet<Sala>();
			temp1.add(sal);
			LinkedHashMap<Boolean, LinkedHashSet<Sala>> temp2 = new LinkedHashMap<Boolean, LinkedHashSet<Sala>>();
			temp2.put(bool, temp1);
			LinkedHashMap<IntervalOrar, LinkedHashMap<Boolean, LinkedHashSet<Sala>>> temp3 = new LinkedHashMap<IntervalOrar, LinkedHashMap<Boolean, LinkedHashSet<Sala>>>();
			temp3.put(inter, temp2);
			test.put(zi, temp3);

			LinkedHashSet<CadruDidactic> temp5 = new LinkedHashSet<CadruDidactic>();
			temp5.add(cad);
			LinkedHashMap<Boolean, LinkedHashSet<CadruDidactic>> temp6 = new LinkedHashMap<Boolean, LinkedHashSet<CadruDidactic>>();
			temp6.put(bool, temp5);
			LinkedHashMap<IntervalOrar, LinkedHashMap<Boolean, LinkedHashSet<CadruDidactic>>> temp7 = new LinkedHashMap<IntervalOrar, LinkedHashMap<Boolean, LinkedHashSet<CadruDidactic>>>();
			temp7.put(inter, temp6);
			test2.put(zi, temp7);

		} else {
			if (test.get(zi).get(inter) == null) {
				LinkedHashSet<Sala> temp1 = new LinkedHashSet<Sala>();
				temp1.add(sal);
				LinkedHashMap<Boolean, LinkedHashSet<Sala>> temp2 = new LinkedHashMap<Boolean, LinkedHashSet<Sala>>();
				temp2.put(bool, temp1);
				test.get(zi).put(inter, temp2);

				LinkedHashSet<CadruDidactic> temp11 = new LinkedHashSet<CadruDidactic>();
				temp11.add(cad);
				LinkedHashMap<Boolean, LinkedHashSet<CadruDidactic>> temp21 = new LinkedHashMap<Boolean, LinkedHashSet<CadruDidactic>>();
				temp21.put(bool, temp11);
				test2.get(zi).put(inter, temp21);
			} else {
				if (test.get(zi).get(inter).get(bool) == null) {
					LinkedHashSet<Sala> temp1 = new LinkedHashSet<Sala>();
					temp1.add(sal);
					test.get(zi).get(inter).put(bool, temp1);

					LinkedHashSet<CadruDidactic> temp11 = new LinkedHashSet<CadruDidactic>();
					temp11.add(cad);
					test2.get(zi).get(inter).put(bool, temp11);

				} else {
					if (test.get(zi).get(inter).get(bool).contains(sal) == false) {
						test.get(zi).get(inter).get(bool).add(sal);
						test2.get(zi).get(inter).get(bool).add(cad);
					}
				}
			}
		}
	}

	public void writeDataRiseI(HSSFSheet stuff, mainControl mn, int an) {
		count = 7;
		mn.getOrarSala().keySet().stream().forEach(item -> {
			mn.getOrarSala().get(item).keySet().stream().forEach(item2 -> {
				mn.getOrarSala().get(item).get(item2).keySet().stream().forEach(item3 -> {
					mn.getOrarSala().get(item).get(item2).get(item3).stream().forEach(item4 -> {
						if (item4.getAn(an) != null) {
							mn.getOrarProf().get(item).get(item2).get(item3).stream().forEach(item5 -> {
								if (item5.getAn(an) != null) {
									tempo = item5;
								}
							});
							this.addTest12(item2, item3, item, item4, tempo);
						}
					});
				});
			});

		});
		test.keySet().stream().forEach(item -> {
			test.get(item).keySet().stream().forEach(item2 -> {
				test.get(item).get(item2).keySet().stream().forEach(item3 -> {
					test.get(item).get(item2).get(item3).stream().forEach(item4 -> {
						if (item4.getAn(an) != null) {
							test2.get(item).get(item2).get(item3).stream().forEach(item5 -> {
								if (item5.getAn(an) != null) {
									tempo = item5;
								}
							});
							// if(stuff.getRow(count2-2).getCell(2)!=null)
							// System.out.println(stuff.getRow(count2-2).getCell(2).getStringCellValue());
							// if (stuff.getRow(count2-2)!= null &&
							// stuff.getRow(count2-2).getCell(0).getStringCellValue().equals(item)
							// &&
							// stuff.getRow(count2-2).getCell(2).getStringCellValue()
							// .equals(tempo.getDisciplina())
							// &&
							// stuff.getRow(count2-2).getCell(3).getStringCellValue().equals(item4.getNumeSala())
							// &&
							// stuff.getRow(count2-2).getCell(4).getStringCellValue()
							// .equals(tempo.getNume())) {
							// //Schimb intervalul
							// String temporary =
							// stuff.getRow(count2-2).getCell(1)
							// .getStringCellValue();
							// stuff.getRow(count2-2).getCell(1)
							// .setCellValue(temporary.split("(?<=-)")[0] + " "
							// + item2.getOraSfarsit() + ".00");
							// count2++;
							// }else{
							// //adaug normal cu cele doua cazuri
							// stuff.setColumnWidth(count, 1400);
							// HSSFRow temp = stuff.createRow(count);
							// temp.setHeightInPoints(30);
							// count++;
							// count2 = count;
							// HSSFCell cell1 = temp.createCell(0);
							// HSSFCell cell2 = temp.createCell(1);
							// HSSFCell cell3 = temp.createCell(2);
							// HSSFCell cell4 = temp.createCell(3);
							// HSSFCell cell5 = temp.createCell(4);
							// cell1.setCellValue(item);
							// cell1.setCellStyle(style3);
							// cell2.setCellValue(Integer.toString(item2.getOraInceput())
							// + ".00 - "
							// + Integer.toString(item2.getOraSfarsit()) +
							// ".00");
							// cell2.setCellStyle(style5);
							// cell4.setCellValue(item4.getNumeSala());
							// if (item3) {
							// if (tempo.getDisciplina().contains("curs")) {
							// cell4.setCellStyle(style7);
							// cell3.setCellValue(tempo.getDisciplina());
							// cell3.setCellStyle(style7);
							// cell5.setCellValue(tempo.getNume());
							// cell5.setCellStyle(style7);
							// } else {
							// cell4.setCellStyle(style9);
							// cell3.setCellValue(tempo.getDisciplina());
							// cell3.setCellStyle(style9);
							// cell5.setCellValue(tempo.getNume());
							// cell5.setCellStyle(style9);
							// }
							// } else {
							// if (tempo.getDisciplina().contains("curs")) {
							// cell4.setCellStyle(style6);
							// cell3.setCellValue(tempo.getDisciplina());
							// cell3.setCellStyle(style6);
							// cell5.setCellValue(tempo.getNume());
							// cell5.setCellStyle(style6);
							// } else {
							// cell4.setCellStyle(style8);
							// cell3.setCellValue(tempo.getDisciplina());
							// cell3.setCellStyle(style8);
							// cell5.setCellValue(tempo.getNume());
							// cell5.setCellStyle(style8);
							// }
							// }
							//
							// }
							writer.println(item3 +" || " +item +" || " +item2 +" || " +tempo.getDisciplina() +" || " +item4.getNumeSala() +" || " +tempo.getNume());
							
							if (!(prevInter.equals(item2) && prevDisciplina.equals(tempo.getDisciplina())
									&& prevZi.equals(item))) {
								prevInter = item2;
								prevZi = item;
								prevDisciplina = tempo.getDisciplina();
								if (test.get(item).get(item2).get(!(item3)) != null) {
									if (!(stuff.getRow(count - 1).getCell(2).getStringCellValue()
											.contains(tempo.getDisciplina())
											&& stuff.getRow(count - 1).getCell(4).getStringCellValue()
													.equals(tempo.getNume()))) {
										if (stuff.getRow(count - 2).getCell(2) != null) {
											if (stuff.getRow(count - 2).getCell(2).getStringCellValue()
													.contains(tempo.getDisciplina())
													&& stuff.getRow(count - 2).getCell(4).getStringCellValue()
															.equals(tempo.getNume())) {
												String temporary = stuff.getRow(count - 1).getCell(1)
														.getStringCellValue();
												stuff.getRow(count - 2).getCell(1)
														.setCellValue(temporary.split("(?<=-)")[0] + " "
																+ item2.getOraSfarsit() + ".00");
											} else {
												stuff.setColumnWidth(count, 1400);
												HSSFRow temp = stuff.createRow(count);
												temp.setHeightInPoints(30);
												count++;
												HSSFCell cell1 = temp.createCell(0);
												HSSFCell cell2 = temp.createCell(1);
												HSSFCell cell3 = temp.createCell(2);
												HSSFCell cell4 = temp.createCell(3);
												HSSFCell cell5 = temp.createCell(4);
												cell1.setCellValue(item);
												cell1.setCellStyle(style3);
												cell2.setCellValue(Integer.toString(item2.getOraInceput()) + ".00 - "
														+ Integer.toString(item2.getOraSfarsit()) + ".00");
												cell2.setCellStyle(style5);
												cell4.setCellValue(item4.getNumeSala());
												if (item3) {
													if (tempo.getDisciplina().contains("curs")) {
														cell4.setCellStyle(style7);
														cell3.setCellValue(tempo.getDisciplina());
														cell3.setCellStyle(style7);
														cell5.setCellValue(tempo.getNume());
														cell5.setCellStyle(style7);
													} else {
														cell4.setCellStyle(style9);
														cell3.setCellValue(tempo.getDisciplina());
														cell3.setCellStyle(style9);
														cell5.setCellValue(tempo.getNume());
														cell5.setCellStyle(style9);
													}
												} else {
													if (tempo.getDisciplina().contains("curs")) {
														cell4.setCellStyle(style6);
														cell3.setCellValue(tempo.getDisciplina());
														cell3.setCellStyle(style6);
														cell5.setCellValue(tempo.getNume());
														cell5.setCellStyle(style6);
													} else {
														cell4.setCellStyle(style8);
														cell3.setCellValue(tempo.getDisciplina());
														cell3.setCellStyle(style8);
														cell5.setCellValue(tempo.getNume());
														cell5.setCellStyle(style8);
													}
												}
											}

										} else {
											stuff.setColumnWidth(count, 1400);
											HSSFRow temp = stuff.createRow(count);
											temp.setHeightInPoints(30);
											count++;
											HSSFCell cell1 = temp.createCell(0);
											HSSFCell cell2 = temp.createCell(1);
											HSSFCell cell3 = temp.createCell(2);
											HSSFCell cell4 = temp.createCell(3);
											HSSFCell cell5 = temp.createCell(4);
											cell1.setCellValue(item);
											cell1.setCellStyle(style3);
											cell2.setCellValue(Integer.toString(item2.getOraInceput()) + ".00 - "
													+ Integer.toString(item2.getOraSfarsit()) + ".00");
											cell2.setCellStyle(style5);
											cell4.setCellValue(item4.getNumeSala());
											if (item3) {
												if (tempo.getDisciplina().contains("curs")) {
													cell4.setCellStyle(style7);
													cell3.setCellValue(tempo.getDisciplina());
													cell3.setCellStyle(style7);
													cell5.setCellValue(tempo.getNume());
													cell5.setCellStyle(style7);
												} else {
													cell4.setCellStyle(style9);
													cell3.setCellValue(tempo.getDisciplina());
													cell3.setCellStyle(style9);
													cell5.setCellValue(tempo.getNume());
													cell5.setCellStyle(style9);
												}
											} else {
												if (tempo.getDisciplina().contains("curs")) {
													cell4.setCellStyle(style6);
													cell3.setCellValue(tempo.getDisciplina());
													cell3.setCellStyle(style6);
													cell5.setCellValue(tempo.getNume());
													cell5.setCellStyle(style6);
												} else {
													cell4.setCellStyle(style8);
													cell3.setCellValue(tempo.getDisciplina());
													cell3.setCellStyle(style8);
													cell5.setCellValue(tempo.getNume());
													cell5.setCellStyle(style8);
												}
											}
										}

									} else {
										String temporary = stuff.getRow(count - 1).getCell(1).getStringCellValue();
										stuff.getRow(count - 1).getCell(1).setCellValue(
												temporary.split("(?<=-)")[0] + " " + item2.getOraSfarsit() + ".00");

									}
								} else {
									if (!(stuff.getRow(count - 1).getCell(2).getStringCellValue()
											.contains(tempo.getDisciplina())
											&& stuff.getRow(count - 1).getCell(4).getStringCellValue()
													.equals(tempo.getNume())
											&& stuff.getRow(count - 1).getCell(0).getStringCellValue().equals(item))) {
										if (stuff.getRow(count - 2).getCell(2) != null) {
											if (stuff.getRow(count - 2).getCell(2).getStringCellValue()
													.equals(tempo.getDisciplina())
													&& stuff.getRow(count - 2).getCell(4).getStringCellValue()
															.equals(tempo.getNume())
													&& stuff.getRow(count - 2).getCell(0).getStringCellValue()
															.equals(item)) {
												String temporary = stuff.getRow(count - 1).getCell(1)
														.getStringCellValue();
												stuff.getRow(count - 2).getCell(1)
														.setCellValue(temporary.split("(?<=-)")[0] + " "
																+ item2.getOraSfarsit() + ".00");
											} else {
												stuff.setColumnWidth(count, 1400);
												HSSFRow temp = stuff.createRow(count);
												temp.setHeightInPoints(30);
												count++;
												HSSFCell cell1 = temp.createCell(0);
												HSSFCell cell2 = temp.createCell(1);
												HSSFCell cell3 = temp.createCell(2);
												HSSFCell cell4 = temp.createCell(3);
												HSSFCell cell5 = temp.createCell(4);
												cell1.setCellValue(item);
												cell1.setCellStyle(style3);
												cell2.setCellValue(Integer.toString(item2.getOraInceput()) + ".00 - "
														+ Integer.toString(item2.getOraSfarsit()) + ".00");
												cell2.setCellStyle(style5);
												cell4.setCellValue(item4.getNumeSala());
												if (item3) {
													if (tempo.getDisciplina().contains("curs")) {
														cell4.setCellStyle(style7);
														cell3.setCellValue("/ " + tempo.getDisciplina());
														cell3.setCellStyle(style7);
														cell5.setCellValue(tempo.getNume());
														cell5.setCellStyle(style7);
													} else {
														cell4.setCellStyle(style9);
														cell3.setCellValue("/ " + tempo.getDisciplina());
														cell3.setCellStyle(style9);
														cell5.setCellValue(tempo.getNume());
														cell5.setCellStyle(style9);
													}
												} else {
													if (tempo.getDisciplina().contains("curs")) {
														cell4.setCellStyle(style6);
														cell3.setCellValue(tempo.getDisciplina() + " /");
														cell3.setCellStyle(style6);
														cell5.setCellValue(tempo.getNume());
														cell5.setCellStyle(style6);
													} else {
														cell4.setCellStyle(style8);
														cell3.setCellValue(tempo.getDisciplina() + " /");
														cell3.setCellStyle(style8);
														cell5.setCellValue(tempo.getNume());
														cell5.setCellStyle(style8);
													}
												}
											}

										} else {
											stuff.setColumnWidth(count, 1400);
											HSSFRow temp = stuff.createRow(count);
											temp.setHeightInPoints(30);
											count++;
											HSSFCell cell1 = temp.createCell(0);
											HSSFCell cell2 = temp.createCell(1);
											HSSFCell cell3 = temp.createCell(2);
											HSSFCell cell4 = temp.createCell(3);
											HSSFCell cell5 = temp.createCell(4);
											cell1.setCellValue(item);
											cell1.setCellStyle(style3);
											cell2.setCellValue(Integer.toString(item2.getOraInceput()) + ".00 - "
													+ Integer.toString(item2.getOraSfarsit()) + ".00");
											cell2.setCellStyle(style5);
											cell4.setCellValue(item4.getNumeSala());
											if (item3) {
												if (tempo.getDisciplina().contains("curs")) {
													cell4.setCellStyle(style7);
													cell3.setCellValue("/ " + tempo.getDisciplina());
													cell3.setCellStyle(style7);
													cell5.setCellValue(tempo.getNume());
													cell5.setCellStyle(style7);
												} else {
													cell4.setCellStyle(style9);
													cell3.setCellValue("/ " + tempo.getDisciplina());
													cell3.setCellStyle(style9);
													cell5.setCellValue(tempo.getNume());
													cell5.setCellStyle(style9);
												}
											} else {
												if (tempo.getDisciplina().contains("curs")) {
													cell4.setCellStyle(style6);
													cell3.setCellValue(tempo.getDisciplina() + " /");
													cell3.setCellStyle(style6);
													cell5.setCellValue(tempo.getNume());
													cell5.setCellStyle(style6);
												} else {
													cell4.setCellStyle(style8);
													cell3.setCellValue(
															tempo.getDisciplina() + tempo.getDisciplina() + " /");
													cell3.setCellStyle(style8);
													cell5.setCellValue(tempo.getNume());
													cell5.setCellStyle(style8);
												}
											}
										}

									} else {
										String temporary = stuff.getRow(count - 1).getCell(1).getStringCellValue();
										stuff.getRow(count - 1).getCell(1).setCellValue(
												temporary.split("(?<=-)")[0] + " " + item2.getOraSfarsit() + ".00");

									}
								}
							}																																																	
						}
					});
				});
			});
		});
		if (stuff.getRow(7) != null) {
			int flag = 0;
			int start = 8;
			String prevInterval = stuff.getRow(7).getCell(0).getStringCellValue();
			for (int i = 8; i <= count; i++) {
				if (stuff.getRow(i) != null) {
					String tempor = stuff.getRow(i).getCell(0).getStringCellValue();
					if (tempor.equals(prevInterval)) {
						flag++;
					} else {
						prevInterval = tempor;
						if (flag != 0) {
							stuff.addMergedRegion(CellRangeAddress
									.valueOf("A" + Integer.toString(start) + ":A" + Integer.toString(start + flag)));

						}
						flag = 0;
						start = i + 1;
					}
				} else {
					if (flag != 0) {
						stuff.addMergedRegion(CellRangeAddress
								.valueOf("A" + Integer.toString(start) + ":A" + Integer.toString(start + flag)));
					}
				}
			}
			int flag2 = 0;
			int start2 = 8;
			String prevInterval1 = stuff.getRow(7).getCell(1).getStringCellValue();
			for (int i = 8; i <= count; i++) {

				if (stuff.getRow(i) != null) {

					String tempor = stuff.getRow(i).getCell(1).getStringCellValue();
					if (tempor.equals(prevInterval1) && stuff.getRow(i - 1).getCell(0).getStringCellValue()
							.equals(stuff.getRow(i).getCell(0).getStringCellValue())) {
						flag2++;
					} else {
						prevInterval1 = tempor;
						if (flag2 != 0) {
							stuff.addMergedRegion(CellRangeAddress
									.valueOf("B" + Integer.toString(start2) + ":B" + Integer.toString(start2 + flag2)));

						}
						flag2 = 0;
						start2 = i + 1;
					}
				} else {
					if (flag2 != 0) {
						stuff.addMergedRegion(CellRangeAddress
								.valueOf("B" + Integer.toString(start2) + ":B" + Integer.toString(start2 + flag2)));
					}
				}
			}

			for (int i = 7; i < count; i++) {
				HSSFCellStyle style11 = workbook.createCellStyle();
				style11.cloneStyleFrom(stuff.getRow(i).getCell(4).getCellStyle());
				style11.setBorderRight(BorderStyle.MEDIUM);
				stuff.getRow(i).getCell(4).setCellStyle(style11);
			}

			for (int i = 1; i <= 4; i++) {
				if (i != 4) {
					HSSFCellStyle style11 = workbook.createCellStyle();
					style11.cloneStyleFrom(stuff.getRow(count - 1).getCell(i).getCellStyle());
					style11.setBorderBottom(BorderStyle.MEDIUM);
					stuff.getRow(count - 1).getCell(i).setCellStyle(style11);
				} else {
					HSSFCellStyle style11 = workbook.createCellStyle();
					style11.cloneStyleFrom(stuff.getRow(count - 1).getCell(i).getCellStyle());
					style11.setBorderBottom(BorderStyle.MEDIUM);
					style11.setBorderRight(BorderStyle.MEDIUM);
					stuff.getRow(count - 1).getCell(i).setCellStyle(style11);
				}

			}
			for (int i = 7; i < count; i++) {
				if (stuff.getRow(i).getCell(2).getCellStyle().getAlignmentEnum() == HorizontalAlignment.RIGHT
						&& !(stuff.getRow(i - 1).getCell(2).getStringCellValue().contains("/"))) {
					stuff.getRow(i - 1).getCell(2)
							.setCellValue(stuff.getRow(i - 1).getCell(2).getStringCellValue() + " /");
					stuff.getRow(i).getCell(2).setCellValue("/ " + stuff.getRow(i).getCell(2).getStringCellValue());
				}
			}
			for (int i = 7; i < count; i++) {
				if (!(stuff.getRow(i).getCell(2).getStringCellValue().contains("/"))) {
					HSSFCellStyle style11 = workbook.createCellStyle();
					style11.cloneStyleFrom(stuff.getRow(i).getCell(2).getCellStyle());
					style11.setAlignment(HorizontalAlignment.CENTER);
					stuff.getRow(i).getCell(2).setCellStyle(style11);
				} else {
					if (stuff.getRow(i).getCell(2).getStringCellValue().indexOf("/") == 0) {
						HSSFRichTextString val = new HSSFRichTextString(
								stuff.getRow(i).getCell(2).getStringCellValue());
						if (val.toString().contains("sem")) {
							val.applyFont(0, 2, font3);
							val.applyFont(2, val.length(), font2);
							stuff.getRow(i).getCell(2).setCellValue(val);
						} else {
							if (val.toString().contains("curs")) {
								val.applyFont(0, 2, font3);
								val.applyFont(2, val.length(), font);
								stuff.getRow(i).getCell(2).setCellValue(val);
							}
						}

					} else {
						HSSFRichTextString val = new HSSFRichTextString(
								stuff.getRow(i).getCell(2).getStringCellValue());
						if (val.toString().contains("sem")) {
							val.applyFont(0, val.length() - 1, font2);
							val.applyFont(val.length() - 1, val.length(), font3);
							stuff.getRow(i).getCell(2).setCellValue(val);
						} else {
							if (val.toString().contains("curs")) {
								val.applyFont(0, val.length() - 1, font);

								val.applyFont(val.length() - 1, val.length(), font3);
								stuff.getRow(i).getCell(2).setCellValue(val);
							}
						}
					}

				}
			}
		}

	}

	public void ExportHelper(HSSFSheet sheet1, mainControl mn, String sem) {

		sheet1.setColumnWidth(0, 1200);
		sheet1.setColumnWidth(1, 3500);
		sheet1.setColumnWidth(2, 14000);
		sheet1.setColumnWidth(3, 3500);
		sheet1.setColumnWidth(4, 4500);
		sheet1.setColumnWidth(5, 600);
		sheet1.setColumnWidth(6, 1400);

		HSSFRow row1 = sheet1.createRow(0);
		HSSFRow row2 = sheet1.createRow(1);
		HSSFRow row3 = sheet1.createRow(2);
		HSSFRow row4 = sheet1.createRow(3);
		HSSFRow row5 = sheet1.createRow(4);
		HSSFRow row6 = sheet1.createRow(5);
		HSSFRow row7 = sheet1.createRow(6);

		row3.setHeightInPoints(9);
		row4.setHeightInPoints(30);
		row7.setHeightInPoints(30);

		HSSFCell cell1 = row1.createCell(0);
		HSSFCell cell2 = row2.createCell(0);
		HSSFCell cell3 = row4.createCell(1);
		HSSFCell cell4 = row5.createCell(0);
		HSSFCell cell5 = row6.createCell(0);
		HSSFCell cell61 = row7.createCell(0);
		HSSFCell cell62 = row7.createCell(1);
		HSSFCell cell63 = row7.createCell(2);
		HSSFCell cell64 = row7.createCell(3);
		HSSFCell cell65 = row7.createCell(4);

		mergedStyle.setAlignment(HorizontalAlignment.RIGHT);
		mergedStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		mergedStyle2.setAlignment(HorizontalAlignment.CENTER);
		mergedStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setVerticalAlignment(VerticalAlignment.CENTER);
		style2.setBorderBottom(BorderStyle.MEDIUM);
		style2.setBorderTop(BorderStyle.MEDIUM);
		style2.setBorderRight(BorderStyle.MEDIUM);
		style2.setBorderLeft(BorderStyle.MEDIUM);
		style3.setAlignment(HorizontalAlignment.CENTER);
		style3.setVerticalAlignment(VerticalAlignment.CENTER);
		style3.setBorderBottom(BorderStyle.MEDIUM);
		style3.setBorderTop(BorderStyle.MEDIUM);
		style3.setBorderRight(BorderStyle.MEDIUM);
		style3.setBorderLeft(BorderStyle.MEDIUM);
		style3.setRotation((short) 90);
		style4.setAlignment(HorizontalAlignment.CENTER);
		style4.setVerticalAlignment(VerticalAlignment.CENTER);
		style4.setBorderBottom(BorderStyle.THIN);
		style4.setBorderTop(BorderStyle.THIN);
		style4.setBorderRight(BorderStyle.THIN);
		style4.setBorderLeft(BorderStyle.THIN);

		style5.setAlignment(HorizontalAlignment.CENTER);
		style5.setVerticalAlignment(VerticalAlignment.CENTER);
		style5.setBorderBottom(BorderStyle.THIN);
		style5.setBorderTop(BorderStyle.THIN);
		style5.setBorderRight(BorderStyle.THIN);
		style5.setBorderLeft(BorderStyle.THIN);

		style6.setAlignment(HorizontalAlignment.LEFT);
		style6.setVerticalAlignment(VerticalAlignment.CENTER);
		style6.setBorderBottom(BorderStyle.NONE);
		style6.setBorderTop(BorderStyle.THIN);
		style6.setBorderRight(BorderStyle.THIN);
		style6.setBorderLeft(BorderStyle.THIN);

		style7.setAlignment(HorizontalAlignment.RIGHT);
		style7.setVerticalAlignment(VerticalAlignment.CENTER);
		style7.setBorderBottom(BorderStyle.THIN);
		style7.setBorderTop(BorderStyle.NONE);
		style7.setBorderRight(BorderStyle.THIN);
		style7.setBorderLeft(BorderStyle.THIN);

		style8.setAlignment(HorizontalAlignment.LEFT);
		style8.setVerticalAlignment(VerticalAlignment.CENTER);
		style8.setBorderBottom(BorderStyle.NONE);
		style8.setBorderTop(BorderStyle.THIN);
		style8.setBorderRight(BorderStyle.THIN);
		style8.setBorderLeft(BorderStyle.THIN);

		style9.setAlignment(HorizontalAlignment.RIGHT);
		style9.setVerticalAlignment(VerticalAlignment.CENTER);
		style9.setBorderBottom(BorderStyle.THIN);
		style9.setBorderTop(BorderStyle.NONE);
		style9.setBorderRight(BorderStyle.THIN);
		style9.setBorderLeft(BorderStyle.THIN);

		style10.setAlignment(HorizontalAlignment.LEFT);
		font2.setFontHeightInPoints((short) 12);
		font2.setFontName("Arial Narrow");
		font2.setFontHeight((short) 240);
		font2.setColor(IndexedColors.BLACK.getIndex());
		font2.setBold(false);
		font2.setItalic(false);

		font3.setFontName("Arial Narrow");
		font3.setFontHeightInPoints((short) 24);
		font3.setColor(IndexedColors.BLACK.getIndex());
		font3.setBold(false);
		font3.setItalic(true);

		style10.setFont(font);
		style5.setFont(font2);
		style6.setFont(font);
		style7.setFont(font);
		style8.setFont(font2);
		style9.setFont(font2);
		font.setFontHeightInPoints((short) 12);
		font.setFontName("Arial Narrow");
		font.setColor(IndexedColors.BLACK.getIndex());
		font.setBold(true);
		font.setItalic(false);
		style.setFont(font);
		mergedStyle.setFont(font);
		mergedStyle2.setFont(font);
		style2.setFont(font);
		style3.setFont(font);
		style4.setFont(font);
		cell1.setCellStyle(style);
		cell1.setCellValue("UNIVERSITATEA DIN ORADEA");
		cell2.setCellStyle(style);
		cell2.setCellValue("FACULTATEA DE ISTORIE, RELAŢII INTERNAŢIONALE, ȘTIINȚE POLITICE ȘI ȘTIINȚELE COMUNICĂRII");
		switch (sheet1.getSheetName()) {
		case "RISE I":
			cell3.setCellValue("RELAȚII INTERNAȚIONALE ȘI STUDII EUROPENE - ANUL I");
			break;
		case "RISE II":
			cell3.setCellValue("RELAȚII INTERNAȚIONALE ȘI STUDII EUROPENE - ANUL II");
			break;
		case "RISE III":
			cell3.setCellValue("RELAȚII INTERNAȚIONALE ȘI STUDII EUROPENE - ANUL III");
			break;
		case "RISEE I":
			cell3.setCellValue("INTERNATIONAL RELATION AND EUROPEAN STUDIES - 1ST YEAR");
			break;
		case "RISEE II":
			cell3.setCellValue("INTERNATIONAL RELATION AND EUROPEAN STUDIES - 2ND YEAR");
			break;
		case "RISEE III":
			cell3.setCellValue("INTERNATIONAL RELATION AND EUROPEAN STUDIES - 3RD YEAR");
			break;
		case "SS I":
			cell3.setCellValue("STUDII DE SECURITATE - ANUL I");
			break;
		case "SS II":
			cell3.setCellValue("STUDII DE SECURITATE - ANUL II");
			break;
		case "CRP I":
			cell3.setCellValue("COMUNICARE ȘI RELAȚII PUBLICE - ANUL I");
			break;
		case "CRP II":
			cell3.setCellValue("COMUNICARE ȘI RELAȚII PUBLICE - ANUL II");
			break;
		}

		sheet1.addMergedRegion(CellRangeAddress.valueOf("B4:F4"));
		cell3.setCellStyle(mergedStyle);
		cell4.setCellValue("O R A R");
		sheet1.addMergedRegion(CellRangeAddress.valueOf("A5:E5"));
		cell4.setCellStyle(mergedStyle2);
		cell5.setCellValue(sem);
		sheet1.addMergedRegion(CellRangeAddress.valueOf("A6:E6"));
		cell5.setCellStyle(mergedStyle2);
		cell61.setCellStyle(style2);
		cell61.setCellValue("ZI");
		cell62.setCellStyle(style2);
		cell62.setCellValue("ORA");
		cell63.setCellStyle(style2);
		cell63.setCellValue("DISCIPLINA");
		cell64.setCellStyle(style2);
		cell64.setCellValue("SALA");
		cell65.setCellStyle(style2);
		cell65.setCellValue("CADRUL DIDACTIC");

	}

	public void Export(mainControl mn, String sem) {
		// Creeaza un nou fisier excell
		HSSFSheet sheet1 = workbook.createSheet("RISE I");// Creeaza un nou
															// sheet
		HSSFSheet sheet2 = workbook.createSheet("RISE II");
		HSSFSheet sheet3 = workbook.createSheet("RISE III");
		HSSFSheet sheet4 = workbook.createSheet("RISEE I");
		HSSFSheet sheet5 = workbook.createSheet("RISEE II");
		HSSFSheet sheet6 = workbook.createSheet("RISEE III");
		HSSFSheet sheet7 = workbook.createSheet("SS I");
		HSSFSheet sheet8 = workbook.createSheet("SS II");
		HSSFSheet sheet9 = workbook.createSheet("CRP I");
		HSSFSheet sheet10 = workbook.createSheet("CRP II");
		ArrayList<HSSFSheet> hs = new ArrayList<HSSFSheet>();
		hs.add(sheet1);
		hs.add(sheet2);
		hs.add(sheet3);
		hs.add(sheet4);
		hs.add(sheet5);
		hs.add(sheet6);
		hs.add(sheet7);
		hs.add(sheet8);
		hs.add(sheet9);
		hs.add(sheet10);
		for (int i = 0; i < 10; i++) {
			this.ExportHelper(hs.get(i), mn, sem);
			this.writeDataRiseI(hs.get(i), mn, i);
			HSSFRow rowAlpha = hs.get(i).createRow(count + 1);
			HSSFCell cella = rowAlpha.createCell(3);
			HSSFCell cella3 = rowAlpha.createCell(1);
			HSSFRow rowAlpha2 = hs.get(i).createRow(count + 2);
			HSSFCell cella2 = rowAlpha2.createCell(3);
			cella2.setCellValue("/ disciplină -> săptămâna pară");
			cella.setCellValue("disciplină / -> săptămâna impară");
			cella3.setCellValue("Fără / -> săptămânal");
			cella2.setCellStyle(style10);
			cella.setCellStyle(style10);
			cella3.setCellStyle(style10);
		}

		try {
			workbook.write(new FileOutputStream("orar.xls"));
			writer.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch blockd
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
