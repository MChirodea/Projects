package model;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 * Class that shows data using reflection.
 * @author mchir
 *
 */
public class TableHelper {
	/**
	 * Method that shows the table data through reflection.
	 * @param object
	 * @param model
	 * @param list
	 * @return
	 */
	 public DefaultTableModel showData(Object object,DefaultTableModel model, ArrayList<Object> list) {
		  	model.setColumnCount(0);
			for (Field field : object.getClass().getDeclaredFields()) {
				model.addColumn(field.getName());	
			}
			Object[] row = new Object[object.getClass().getDeclaredFields().length];
			model.setRowCount(0);
			Field[] field = object.getClass().getDeclaredFields();
			for (int i = 0; i < list.size(); i++) {
				int k = 0;
				 for(int q = 0; q < field.length; q++){
					 try {
						  field[q].setAccessible(true);
						  Object value = field[q].get(list.get(i));
						  row[k++]= value;
						
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					
					model.addRow(row);
				}
				 
			return model;
		}
}
