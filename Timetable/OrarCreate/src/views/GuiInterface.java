package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.function.Predicate;

import static javax.swing.JOptionPane.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import control.mainControl;
import models.AnStudiu;
import models.CadruDidactic;
import models.IntervalOrar;
import models.Sala;
import models.WriteExcell;
import models.WriteExcell2;
import models.WriteExcell3;

public class GuiInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2289441448951538942L;
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private JTable table;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	private JTable headerTable;
	private JTable headerTable2;
	private JButton btn;
	private JButton btnPrint;
	private JComboBox<String> combo;
	private Boolean oddeven = false;
	private int prevtable = -1;
	private mainControl mn;
	private int refreshAn = 0;
	private int myInt2 = 0;
	private int count = 0;
	private ArrayList<Sala> items = new ArrayList<Sala>() ;
	private ArrayList<CadruDidactic> items2 =new  ArrayList<CadruDidactic>();

	private void refreshTable() {
		refreshAn = 0;
		switch ((String) combo.getSelectedItem()) {
		case "RISE I":
			refreshAn = 0;
			break;
		case "RISE II":
			refreshAn = 1;
			break;
		case "RISE III":
			refreshAn = 2;
			break;
		case "RISEE I":
			refreshAn = 3;
			break;
		case "RISEE II":
			refreshAn = 4;
			break;
		case "RISEE III":
			refreshAn = 5;
			break;	
		case "SS I":
			refreshAn = 6;
			break;
		case "SS II":
			refreshAn = 7;
			break;
		case "SS III":
			refreshAn = 8;
			break;
		case "CRP II":
			refreshAn = 9;
			break;	
		}
		for (int i = 0; i < 78; i++) {
			for (int j = 0; j < 3; j++) {
				table.getModel().setValueAt("", i, j);
			}
		}
		for (count = 0; count < 78; count++) {
			String interval = (String) headerTable.getModel().getValueAt(count, 0);
			String[] tempo = interval.split(" - ");
			IntervalOrar inter = new IntervalOrar(Integer.parseInt(tempo[0].split("\\.")[0]),
					Integer.parseInt(tempo[1].split("\\.")[0]));
			String zi = "";
			if (count >= 0 && count <= 12) {
				zi = "LUNI";
			} else {
				if (count >= 13 && count <= 25) {
					zi = "MARȚI";
				} else {
					if (count >= 26 && count <= 38) {
						zi = "MIERCURI";
					} else {
						if (count >= 39 && count <= 51) {
							zi = "JOI";
						} else {
							if (count >= 52 && count <= 64) {
								zi = "VINERI";
							} else {
								if (count >= 65 && count <= 77) {
									zi = "SÂMBĂTĂ";
								}
							}
						}
					}
				}
			}
			if (mn.getOrarSala().get(oddeven) != null) {
				if (mn.getOrarSala().get(oddeven).get(zi) != null) {
					LinkedHashSet<Sala> temporary = mn.getOrarSala().get(oddeven).get(zi).get(inter);
					LinkedHashSet<CadruDidactic> temporaryCD = mn.getOrarProf().get(oddeven).get(zi).get(inter);
					if (temporary != null && temporary.size() != 0) {
						Predicate<Sala> pred = item -> {
							if (item.getAn(refreshAn) != null) {
								return item.getAn(refreshAn).getAnStudiu().equals(combo.getSelectedItem());
							}
							return false;

						};
						Predicate<CadruDidactic> pred2 = item -> {
							if (item.getAn(refreshAn) != null) {
								return item.getAn(refreshAn).getAnStudiu().equals(combo.getSelectedItem());
							}
							return false;
						};
						temporary.stream().filter(pred).forEach(item -> {
							table.setValueAt(item.getNumeSala(), count, 1);
						});
						temporaryCD.stream().filter(pred2).forEach(item -> {
							table.setValueAt(item.getNume(), count, 2);
							table.setValueAt(item.getDisciplina(), count, 0);
						});
					}

				}
			}

		}
		count = 0;
	}

	private int editTable(Sala sala, IntervalOrar inter, String zi, CadruDidactic temp, int myInt) {
		int n = mn.addSala(sala, oddeven, inter, zi);
		int m = mn.addProf(temp, oddeven, inter, zi);

		if (n != 0 && m != 0) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(this,
					"Sala si cadrul didactic se suprapun, doriti sa se faca legatura?", "Link Creator", dialogButton);
			if (dialogResult == 0) {
				// System.out.println("Yes option");
				mn.getOrarSala().get(oddeven).get(zi).get(inter).stream().forEach(item -> {
					if (item.equals(sala)) {
						item.addAn(sala.getAn(myInt2), myInt2);
					}
				});
				mn.getOrarProf().get(oddeven).get(zi).get(inter).stream().forEach(item -> {
					if (item.equals(temp)) {
						item.addAn(temp.getAn(myInt2), myInt2);

					}
				});
				return 0;
			} else {
				// System.out.println("No Option");
				return -1;
			}
		} else {
			if (n != 0) {
				items2 = mn.delProf(temp, oddeven, inter, zi, myInt2, new ArrayList<CadruDidactic>());
				mn.getOrarProf().get(oddeven).get(zi).get(inter).removeAll(items2);
				showMessageDialog(null, "Accelasi interval pentru sala!", "WARNING", WARNING_MESSAGE);
				return -2;

			} else {
				if (m != 0) {
					items = mn.delSala(sala, oddeven, inter, zi, myInt2, new ArrayList<Sala>());
					mn.getOrarSala().get(oddeven).get(zi).get(inter).removeAll(items);
					showMessageDialog(null, "Accelasi interval pentru cadrul didactic!", "WARNING", WARNING_MESSAGE);
					return -3;

				}
			}
		}
		return 0;
	}

	private int addTable(Sala sala, IntervalOrar inter, String zi, CadruDidactic temp, int myInt) {
		int n = mn.addSala(sala, oddeven, inter, zi);
		int m = mn.addProf(temp, oddeven, inter, zi);
		if (n != 0 && m != 0) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(this,
					"Sala si cadrul didactic se suprapun, doriti sa se faca legatura?", "Link Creator", dialogButton);
			if (dialogResult == 0) {
				// System.out.println("Yes option");
				mn.getOrarSala().get(oddeven).get(zi).get(inter).stream().forEach(item -> {
					if (item.equals(sala)) {
						item.addAn(sala.getAn(myInt2), myInt2);
					}
				});
				mn.getOrarProf().get(oddeven).get(zi).get(inter).stream().forEach(item -> {
					if (item.equals(temp)) {
						item.addAn(temp.getAn(myInt2), myInt2);
					}
				});
				return 0;
			} else {
				// System.out.println("No Option");
				return -1;
			}
		} else {
			if (n != 0) {
				mn.getVecTemp()[myInt2][myInt][prevtable] = 0;
				items2 = mn.delProf(temp, oddeven, inter, zi, myInt2, new ArrayList<CadruDidactic>());
				mn.getOrarProf().get(oddeven).get(zi).get(inter).removeAll(items2);
				showMessageDialog(null, "Accelasi interval pentru sala!", "WARNING", WARNING_MESSAGE);
				return -2;

			} else {
				if (m != 0) {
					mn.getVecTemp()[myInt2][myInt][prevtable] = 0;
					items = mn.delSala(sala, oddeven, inter, zi, myInt2, new ArrayList<Sala>());
					mn.getOrarSala().get(oddeven).get(zi).get(inter).removeAll(items);
					showMessageDialog(null, "Accelasi interval pentru cadrul didactic!", "WARNING", WARNING_MESSAGE);
					return -3;

				}
			}
		}
		return 0;
	}

	private void tableMouseClicked(java.awt.event.MouseEvent evt) {
		int row = table.rowAtPoint(evt.getPoint());
		if (row != prevtable && prevtable != -1) {
			int myInt = oddeven ? 1 : 0;
			myInt2 = 0;
			switch ((String) combo.getSelectedItem()) {
			case "RISE I":
				myInt2 = 0;
				break;
			case "RISE II":
				myInt2  = 1;
				break;
			case "RISE III":
				myInt2  = 2;
				break;
			case "RISEE I":
				myInt2  = 3;
				break;
			case "RISEE II":
				myInt2  = 4;
				break;
			case "RISEE III":
				myInt2  = 5;
				break;	
			case "SS I":
				myInt2  = 6;
				break;
			case "SS II":
				myInt2  = 7;
				break;
			case "SS III":
				myInt2  = 8;
				break;
			case "CRP II":
				myInt2  = 9;
				break;	
			}
			String disciplina = (String) table.getModel().getValueAt(prevtable, 0);
			Sala sala = new Sala((String) table.getModel().getValueAt(prevtable, 1), myInt2,
					new AnStudiu((String) combo.getSelectedItem()));
			String cadruDidactic = (String) table.getModel().getValueAt(prevtable, 2);
			CadruDidactic temp = new CadruDidactic(cadruDidactic, disciplina, myInt2,
					new AnStudiu((String) combo.getSelectedItem()));
			String interval = (String) headerTable.getModel().getValueAt(prevtable, 0);
			String[] tempo = interval.split(" - ");
			IntervalOrar inter = new IntervalOrar(Integer.parseInt(tempo[0].split("\\.")[0]),
					Integer.parseInt(tempo[1].split("\\.")[0]));
			String zi = "";
			if (prevtable >= 0 && prevtable <= 12) {
				zi = "LUNI";
			} else {
				if (prevtable >= 13 && prevtable <= 25) {
					zi = "MARȚI";
				} else {
					if (prevtable >= 26 && prevtable <= 38) {
						zi = "MIERCURI";
					} else {
						if (prevtable >= 39 && prevtable <= 51) {
							zi = "JOI";
						} else {
							if (prevtable >= 52 && prevtable <= 64) {
								zi = "VINERI";
							} else {
								if (prevtable >= 65 && prevtable <= 77) {
									zi = "SÂMBĂTĂ";
								}
							}
						}
					}
				}
			}
			if (sala.getNumeSala() != null && disciplina != null && cadruDidactic != null
					&& !(sala.getNumeSala().equals("")) && !(disciplina.equals("")) && !(cadruDidactic.equals(""))) {
				if (mn.getVecTemp()[myInt2][myInt][prevtable] == 0) {
					mn.getVecTemp()[myInt2][myInt][prevtable] = 1;
					sala.setNumeSala(sala.getNumeSala().toUpperCase());
					temp.setBoth(temp.getNume().toUpperCase(), temp.getDisciplina());
					this.addTable(sala, inter, zi, temp, myInt);

				} else {
					// EDIT
					// System.out.println("EDIT\n");
					sala.setNumeSala(sala.getNumeSala().toUpperCase());
					temp.setBoth(temp.getNume().toUpperCase(), temp.getDisciplina());
					LinkedHashSet<Sala> tempoo = mn.getOrarSala().get(oddeven).get(zi).get(inter);
					LinkedHashSet<CadruDidactic> tempoo2 = mn.getOrarProf().get(oddeven).get(zi).get(inter);
					//if
						int flag = 0;
						Iterator<Sala> t = tempoo.iterator();
						Iterator<CadruDidactic> t2 = tempoo2.iterator();
						while (t.hasNext() && t2.hasNext()) {
							Sala sal = t.next();
							CadruDidactic sal2 = t2.next();
							int ta = 0;
							for (int i = 0; i < 10; i++) {
								if (sal.getAn(i) != null) {
									ta++;
								}
							}
							final int tb = ta;
							if (ta != 1 && sal.getAn(myInt2) != null) {
								flag = 1;
								if (!(sala.equals(sal) && temp.equals(sal2)
										&& temp.getDisciplina().equals(sal2.getDisciplina()))) {
									int dialogButton = JOptionPane.YES_NO_OPTION;
									int dialogResult = JOptionPane.showConfirmDialog(this,
											"Exista legatura, doriti sa fie distrusa?", "Link Editor", dialogButton);
									if (dialogResult == 0) {
										int g = this.editTable(sala, inter, zi, temp, myInt);
										if (g == 0) {
											sal.addAn(null, myInt2);
											sal2.addAn(null, myInt2);
										}

									} else {
										int n = mn.editSala(sala, oddeven, inter, zi, myInt2, 1, new ArrayList<Sala>());
										int m = mn.editProf(temp, oddeven, inter, zi, myInt2, 1,
												new ArrayList<CadruDidactic>());
										if (n != 0 && m != 0) {
											int dialogButton2 = JOptionPane.YES_NO_OPTION;
											int dialogResult2 = JOptionPane.showConfirmDialog(this,
													"Sala si cadrul didactic se suprapun, doriti sa se faca legatura?",
													"Link Creator", dialogButton2);
											if (dialogResult2 == 0) {
												// System.out.println("Yes option");
												mn.getOrarSala().get(oddeven).get(zi).get(inter).stream()
														.forEach(item -> {
															if (item.equals(sala)) {
																for (int i = 0; i < 10; i++) {
																	if (sal.getAn(i) != null) {
																		item.addAn(sal.getAn(i), i);
																	}
																}

															}
														});
												items = new ArrayList<Sala>();
												mn.getOrarSala().get(oddeven).get(zi).get(inter).stream()
														.forEach(item -> {
															int k = 0;
															for (int i = 0; i < 10; i++) {
																if (item.getAn(i) != null) {
																	k++;
																}
															}
															if (k == tb && item.getAn(myInt2) != null) {
																items.add(item);

															}
														});
												mn.getOrarSala().get(oddeven).get(zi).get(inter).removeAll(items);
												mn.getOrarProf().get(oddeven).get(zi).get(inter).stream()
														.forEach(item -> {
															if (item.equals(temp)) {
																for (int i = 0; i < 10; i++) {
																	if (sal2.getAn(i) != null) {
																		item.addAn(sal2.getAn(i), i);
																	}
																}
															}
														});
												items2 = new ArrayList<CadruDidactic>();
												mn.getOrarProf().get(oddeven).get(zi).get(inter).stream()
														.forEach(item -> {
															int k = 0;
															for (int i = 0; i < 10; i++) {
																if (item.getAn(i) != null) {
																	k++;
																}
															}
															if (k == tb && item.getAn(myInt2) != null) {
																items2.add(item);
															}
														});
												mn.getOrarProf().get(oddeven).get(zi).get(inter).removeAll(items2);
											} else {
												// System.out.println("No Option");
											}
										} else {
											if (n != 0) {
												showMessageDialog(null, "Accelasi interval pentru sala!", "WARNING",
														WARNING_MESSAGE);

											} else {
												if (m != 0) {
													showMessageDialog(null, "Accelasi interval pentru cadrul didactic!",
															"WARNING", WARNING_MESSAGE);

												}
											}
										}
									}
									break;
								} else {
									break;
								}
							}
						}
						if (flag == 0) {
							int n = mn.editSala(sala, oddeven, inter, zi, myInt2, 0, new ArrayList<Sala>());
							int m = mn.editProf(temp, oddeven, inter, zi, myInt2, 0, new ArrayList<CadruDidactic>());
							if (n != 0 && m != 0) {
								int dialogButton2 = JOptionPane.YES_NO_OPTION;
								int dialogResult2 = JOptionPane.showConfirmDialog(this,
										"Sala si cadrul didactic se suprapun, doriti sa se faca legatura?",
										"Link Creator", dialogButton2);
								if (dialogResult2 == 0) {
									// System.out.println("Yes option");
									mn.getOrarSala().get(oddeven).get(zi).get(inter).stream().forEach(item -> {
										if (item.equals(sala)) {
											item.addAn(sala.getAn(myInt2), myInt2);
										}
									});
									items = new ArrayList<Sala>();
									mn.getOrarSala().get(oddeven).get(zi).get(inter).stream().forEach(item -> {
										int k = 0;
										for (int i = 0; i < 10; i++) {
											if (item.getAn(i) != null) {
												k++;
											}
										}
										if (k == 1 && item.getAn(myInt2) != null) {
											items.add(item);

										}
									});
									mn.getOrarSala().get(oddeven).get(zi).get(inter).removeAll(items);
									mn.getOrarProf().get(oddeven).get(zi).get(inter).stream().forEach(item -> {
										if (item.equals(temp)) {
											item.addAn(temp.getAn(myInt2), myInt2);
										}
									});
									items2 = new ArrayList<CadruDidactic>();
									mn.getOrarProf().get(oddeven).get(zi).get(inter).stream().forEach(item -> {
										int k = 0;
										for (int i = 0; i < 10; i++) {
											if (item.getAn(i) != null) {
												k++;
											}
										}
										if (k == 1 && item.getAn(myInt2) != null) {
											items2.add(item);
										}
									});
									mn.getOrarProf().get(oddeven).get(zi).get(inter).removeAll(items2);
								} else {
									// System.out.println("No Option");
								}
							} else {
								if (n != 0) {
									showMessageDialog(null, "Accelasi interval pentru sala!", "WARNING",
											WARNING_MESSAGE);

								} else {
									if (m != 0) {
										showMessageDialog(null, "Accelasi interval pentru cadrul didactic!", "WARNING",
												WARNING_MESSAGE);

									}
								}
							}
						}
					
				}
			} else {
				if (mn.getVecTemp()[myInt2][myInt][prevtable] == 1) {
					// STERGERE
					mn.getVecTemp()[myInt2][myInt][prevtable] = 0;
					System.out.println("DELETE\n");
					// Trebe sa verific daca am legatura, daca am sterg doar legatura, daca nu am,
					// sterg simplu
					sala.setNumeSala(sala.getNumeSala().toUpperCase());
					temp.setBoth(temp.getNume().toUpperCase(), temp.getDisciplina());
					LinkedHashSet<Sala> tempoo = mn.getOrarSala().get(oddeven).get(zi).get(inter);
					Iterator<Sala> t = tempoo.iterator();
					while (t.hasNext()) {
						Sala sal = t.next();
						int k = 0;
						for (int i = 0; i < 10; i++) {
							if (sal.getAn(i) != null) {
								k++;
							}
						}
						if (k != 1 && sal.getAn(myInt2) != null) {
							sal.addAn(null, myInt2);
							final int k2 = k;
							mn.getOrarProf().get(oddeven).get(zi).get(inter).stream().forEach(item -> {
								int kg = 0;
								for (int i = 0; i < 10; i++) {
									if (item.getAn(i) != null) {
										kg++;
									}
								}
								if (kg != 1 && item.getAn(myInt2) != null && kg == k2) {
									item.addAn(null, myInt2);
								}
							});
							break;
						} else {
							if(sal.getAn(myInt2) != null){
								items = mn.delSala(sala, oddeven, inter, zi, myInt2, new ArrayList<Sala>());
								items2 = mn.delProf(temp, oddeven, inter, zi, myInt2, new ArrayList<CadruDidactic>());

							}
							
						}

					}
					mn.getOrarProf().get(oddeven).get(zi).get(inter).removeAll(items2);
					mn.getOrarSala().get(oddeven).get(zi).get(inter).removeAll(items);

				}
			}
			
		} else {
			prevtable = row;
		}
			if (prevtable == -1) {
				prevtable = row;
			}
			prevtable = row;

	}

	public void btnAction(ActionEvent evt) {
		if (oddeven == true) {
			oddeven = false;
			headerTable.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("ORA / IMPAR");
			headerTable.updateUI();
		} else {
			oddeven = true;
			headerTable.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("ORA / PAR");
			headerTable.updateUI();

		}
		this.refreshTable();

	}

	public void printAction(ActionEvent evt) {
		String semAn = (String)JOptionPane.showInputDialog(this,              
                "Introduceți semestrul și anul universitar:\n",
                "Exporter",
                JOptionPane.PLAIN_MESSAGE);

		WriteExcell print = new WriteExcell();
		print.Export(mn,semAn);
		WriteExcell2 print2 = new WriteExcell2();
		print2.Export(mn,semAn);
		WriteExcell3 print3 = new WriteExcell3();
		print3.Export(mn,semAn);
	}

	public void comboActionPerformed(ActionEvent evt) {
		this.refreshTable();
	}

	public static void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 15;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 300)
				width = 300;
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}

	public GuiInterface() {
		FileInputStream fi;
		try {
			fi = new FileInputStream(new File("Orar.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			mn = (mainControl) oi.readObject();
			fi.close();
			oi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			mn = new mainControl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
		p3.setLayout(new BorderLayout());
		table = new JTable(78, 3);
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null } },
				new String[] { "DISCIPLINA", "SALA", "CADRU DIDACTIC" }) {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

		});
		table.getTableHeader().setFont(new Font("Arial", Font.ITALIC, 12));
		model = new javax.swing.table.DefaultTableModel(
				new Object[][] { { null }, { null }, { null }, { null }, { null }, { null }, { null }, { null },
						{ null }, { null }, { null }, { null }, { null }, { null }, { null }, { null }, { null },
						{ null }, { null }, { null }, { null }, { null }, { null }, { null }, { null }, { null },
						{ null }, { null }, { null }, { null }, { null }, { null }, { null }, { null }, { null },
						{ null }, { null }, { null }, { null }, { null }, { null }, { null }, { null }, { null },
						{ null }, { null }, { null }, { null }, { null }, { null }, { null }, { null }, { null },
						{ null }, { null }, { null }, { null }, { null }, { null }, { null }, { null }, { null },
						{ null }, { null }, { null }, { null }, { null }, { null }, { null }, { null }, { null },
						{ null }, { null }, { null }, { null }, { null }, { null }, { null } },
				new String[] { "IMPAR" }) {

			private static final long serialVersionUID = 1L;

			@Override
			public int getColumnCount() {
				return 1;
			}

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;

			}

			@Override
			public String getColumnName(int index) {
				return "ORA / IMPAR";
			}

			@Override
			public int getRowCount() {
				return table.getRowCount();
			}

			@Override
			public Class<?> getColumnClass(int colNum) {
				switch (colNum) {
				case 0:
					return String.class;
				default:
					return super.getColumnClass(colNum);
				}
			}
		};
		model2 = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public int getColumnCount() {
				return 1;
			}

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;

			}

			@Override
			public String getColumnName(int index) {
				return "DAY";
			}

			@Override
			public int getRowCount() {
				return table.getRowCount();
			}

			@Override
			public Class<?> getColumnClass(int colNum) {
				switch (colNum) {
				case 0:
					return String.class;
				default:
					return super.getColumnClass(colNum);
				}

			}

		};
		headerTable2 = new JTable(model2);
		for (int j = 0; j < 6; j++) {
			switch (j) {
			case 0:
				headerTable2.setValueAt("LUNI", j, 0);
				break;
			case 1:
				headerTable2.setValueAt("MARȚI", j, 0);
				break;
			case 2:
				headerTable2.setValueAt("MIERCURI", j, 0);
				break;
			case 3:
				headerTable2.setValueAt("JOI", j, 0);
				break;
			case 4:
				headerTable2.setValueAt("VINERI", j, 0);
				break;
			case 5:
				headerTable2.setValueAt("SÂMBĂTĂ", j, 0);
				break;
			}
		}
		headerTable = new JTable(model);
		for (int i = 0; i < table.getRowCount(); i++) {
			switch (i) {
			case 0:
			case 13:
			case 26:
			case 39:
			case 52:
			case 65:
				headerTable.setValueAt("8.00 - 9.00", i, 0);
				break;
			case 1:
			case 14:
			case 27:
			case 40:
			case 53:
			case 66:
				headerTable.setValueAt("9.00 - 10.00", i, 0);
				break;

			case 2:
			case 15:
			case 28:
			case 41:
			case 54:
			case 67:
				headerTable.setValueAt("10.00 - 11.00", i, 0);
				break;

			case 3:
			case 16:
			case 29:
			case 42:
			case 55:
			case 68:
				headerTable.setValueAt("11.00 - 12.00", i, 0);
				break;

			case 4:
			case 17:
			case 30:
			case 43:
			case 56:
			case 69:
				headerTable.setValueAt("12.00 - 13.00", i, 0);
				break;

			case 5:
			case 18:
			case 31:
			case 44:
			case 57:
			case 70:
				headerTable.setValueAt("13.00 - 14.00", i, 0);
				break;

			case 6:
			case 19:
			case 32:
			case 45:
			case 58:
			case 71:
				headerTable.setValueAt("14.00 - 15.00", i, 0);
				break;

			case 7:
			case 20:
			case 33:
			case 46:
			case 59:
			case 72:
				headerTable.setValueAt("15.00 - 16.00", i, 0);
				break;

			case 8:
			case 21:
			case 34:
			case 47:
			case 60:
			case 73:
				headerTable.setValueAt("16.00 - 17.00", i, 0);
				break;

			case 9:
			case 22:
			case 35:
			case 48:
			case 61:
			case 74:
				headerTable.setValueAt("17.00 - 18.00", i, 0);
				break;

			case 10:
			case 23:
			case 36:
			case 49:
			case 62:
			case 75:
				headerTable.setValueAt("18.00 - 19.00", i, 0);
				break;

			case 11:
			case 24:
			case 37:
			case 50:
			case 63:
			case 76:
				headerTable.setValueAt("19.00 - 20.00", i, 0);
				break;

			case 12:
			case 25:
			case 38:
			case 51:
			case 64:
			case 77:
				headerTable.setValueAt("20.00 - 21.00", i, 0);
				break;
			}

		}
		table.setRowHeight(21);

		table.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				GuiInterface.resizeColumnWidth(table);
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		headerTable2.setRowHeight(273);
		headerTable.setRowHeight(21);
		headerTable.setShowGrid(false);
		headerTable2.setShowGrid(false);
		headerTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		headerTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		headerTable.setPreferredScrollableViewportSize(new Dimension(90, 0));
		headerTable2.setPreferredScrollableViewportSize(new Dimension(90, 0));
		headerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		headerTable2.getColumnModel().getColumn(0).setPreferredWidth(100);
		headerTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {

				boolean selected = table.getSelectionModel().isSelectedIndex(row);
				Component component = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table,
						value, false, false, -1, -2);
				((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
				if (selected) {
					component.setFont(component.getFont().deriveFont(Font.BOLD));
					component.setForeground(Color.red);
				} else {
					component.setFont(component.getFont().deriveFont(Font.PLAIN));
				}
				return component;
			}
		});
		headerTable2.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {

				Component component = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table,
						value, false, false, -1, -2);
				((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
				int[] rows = table.getSelectedRows();
				for (int i = 0; i < rows.length; i++) {
					if (rows[i] >= 0 && rows[i] <= 12 && row == 0) {
						component.setFont(component.getFont().deriveFont(Font.BOLD));
						component.setForeground(Color.red);
					} else {
						component.setFont(component.getFont().deriveFont(Font.ITALIC));
					}

					if (rows[i] >= 13 && rows[i] <= 25 && row == 1) {
						component.setFont(component.getFont().deriveFont(Font.BOLD));
						component.setForeground(Color.red);
					} else {
						component.setFont(component.getFont().deriveFont(Font.ITALIC));
					}

					if (rows[i] >= 26 && rows[i] <= 38 && row == 2) {
						component.setFont(component.getFont().deriveFont(Font.BOLD));
						component.setForeground(Color.red);
					} else {
						component.setFont(component.getFont().deriveFont(Font.ITALIC));
					}
					if (rows[i] >= 39 && rows[i] <= 51 && row == 3) {
						component.setFont(component.getFont().deriveFont(Font.BOLD));
						component.setForeground(Color.red);
					} else {
						component.setFont(component.getFont().deriveFont(Font.ITALIC));
					}

					if (rows[i] >= 52 && rows[i] <= 64 && row == 4) {
						component.setFont(component.getFont().deriveFont(Font.BOLD));
						component.setForeground(Color.red);
					} else {
						component.setFont(component.getFont().deriveFont(Font.ITALIC));
					}

					if (rows[i] >= 65 && rows[i] <= 77 && row == 5) {
						component.setFont(component.getFont().deriveFont(Font.BOLD));
						component.setForeground(Color.red);
					} else {
						component.setFont(component.getFont().deriveFont(Font.ITALIC));
					}
				}

				headerTable2.repaint();
				return component;
			}
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				model.fireTableRowsUpdated(0, model.getRowCount() - 1);
			}
		});
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableMouseClicked(evt);
			}
		});
		scrollPane = new JScrollPane(table);
		scrollPane.setRowHeaderView(headerTable);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		scrollPane2 = new JScrollPane(headerTable);
		scrollPane2.setRowHeaderView(headerTable2);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane2.getVerticalScrollBar().setModel(scrollPane.getVerticalScrollBar().getModel());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				FileOutputStream fo;
				try {
					fo = new FileOutputStream(new File("Orar.txt"));
					ObjectOutputStream oo = new ObjectOutputStream(fo);
					oo.writeObject(mn);
					fo.close();
					oo.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		p2.add(scrollPane2, BorderLayout.WEST);
		p2.add(scrollPane, BorderLayout.CENTER);

		combo = new JComboBox<String>();
		combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RISE I", "RISE II", "RISE III", "RISEE I",
				"RISEE II", "RISEE III", "SS I", "SS II", "SS III", "CRP II" }));
		combo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboActionPerformed(evt);
			}
		});
		p1.add(combo, BorderLayout.NORTH);
		btnPrint = new JButton();
		btnPrint.setText("Export");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				printAction(evt);
			}
		});
		btn = new JButton();
		btn.setText("Schimba Saptamana");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAction(evt);
			}
		});
		p3.add(btnPrint, BorderLayout.SOUTH);
		p3.add(btn, BorderLayout.CENTER);
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		this.add(p3, BorderLayout.SOUTH);
		this.pack();
		this.setLocation(150, 150);
		this.setVisible(true);
		this.refreshTable();
	}

}