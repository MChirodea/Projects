package control;

import views.*;

import java.awt.EventQueue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.function.Predicate;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import models.*;

@SuppressWarnings("unused")
public class mainControl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2345053611569100452L;
	private LinkedHashMap<Boolean, LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>>> orarSala; // WIP
	private LinkedHashMap<Boolean, LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>>> orarProf; // o
	private int[][][] vecTemp = new int[10][2][78]; // sa
	// adaug
	// dupa
	// cadrul
	// didactic
	public void mnchelp() {
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary2 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary3 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary4 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary5 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary6 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>> temporary7 = new LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>>();
		temporary.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		
		temporary2.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary2.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		
		temporary3.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary3.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		
		temporary4.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary4.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		
		temporary5.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary5.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		
		temporary6.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary6.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		

		
		temporary7.put("LUNI", temporary);
		temporary7.put("MARȚI", temporary2);
		temporary7.put("MIERCURI", temporary3);
		temporary7.put("JOI", temporary4);
		temporary7.put("VINERI", temporary5);
		temporary7.put("SÂMBĂTĂ", temporary6);
		orarProf.put(false, temporary7);
		
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary21 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary22 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary23 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary24 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary25 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temporary26 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
		LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>> temporary27 = new LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>>();
		temporary21.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary21.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		
		temporary22.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary22.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		
		temporary23.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary23.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		
		temporary24.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary24.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		
		temporary25.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary25.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		
		temporary26.put(new IntervalOrar(8, 9), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(9, 10), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(10, 11), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(11, 12), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(12, 13), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(13, 14), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(14, 15), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(15, 16), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(16, 17), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(17, 18), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(18, 19), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(19, 20), new LinkedHashSet<CadruDidactic>());
		temporary26.put(new IntervalOrar(20, 21), new LinkedHashSet<CadruDidactic>());
		

		
		temporary27.put("LUNI", temporary21);
		temporary27.put("MARȚI", temporary22);
		temporary27.put("MIERCURI", temporary23);
		temporary27.put("JOI", temporary24);
		temporary27.put("VINERI", temporary25);
		temporary27.put("SÂMBĂTĂ", temporary26);
		orarProf.put(true, temporary27);
		
	}
	public mainControl() {
		orarSala = new LinkedHashMap<Boolean, LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>>>();
		orarProf = new LinkedHashMap<Boolean, LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>>>();
		this.mnchelp();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary21 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary3 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary4 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary5 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary6 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>> temporary7 = new LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>>();
		temporary.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		
		temporary21.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary21.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		
		temporary3.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary3.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		
		temporary4.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary4.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		
		temporary5.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary5.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		
		temporary6.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary6.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
				
		temporary7.put("LUNI", temporary);
		temporary7.put("MARȚI", temporary21);
		temporary7.put("MIERCURI", temporary3);
		temporary7.put("JOI", temporary4);
		temporary7.put("VINERI", temporary5);
		temporary7.put("SÂMBĂTĂ", temporary6);
		orarSala.put(false, temporary7);
		
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary2 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary22 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary23 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary24 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary25 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temporary26 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
		LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>> temporary27 = new LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>>();
		temporary2.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary2.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		
		temporary22.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary22.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		
		temporary23.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary23.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		
		temporary24.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary24.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		
		temporary25.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary25.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		
		temporary26.put(new IntervalOrar(8, 9), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(9, 10), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(10, 11), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(11, 12), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(12, 13), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(13, 14), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(14, 15), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(15, 16), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(16, 17), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(17, 18), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(18, 19), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(19, 20), new LinkedHashSet<Sala>());
		temporary26.put(new IntervalOrar(20, 21), new LinkedHashSet<Sala>());
		

		
		temporary27.put("LUNI", temporary2);
		temporary27.put("MARȚI", temporary22);
		temporary27.put("MIERCURI", temporary23);
		temporary27.put("JOI", temporary24);
		temporary27.put("VINERI", temporary25);
		temporary27.put("SÂMBĂTĂ", temporary26);

		orarSala.put(true,temporary27);
		
	}

	public int addSala(Sala sala, Boolean parimp, IntervalOrar inter, String zi) {
		if (orarSala.get(parimp).get(zi).get(inter).contains(sala) == false) {
			orarSala.get(parimp).get(zi).get(inter).add(sala);
			return 0;
		} else {
			return -1;}
		
		
//		if (orarSala.get(parimp) == null) {
//			LinkedHashSet<Sala> temp1 = new LinkedHashSet<Sala>();
//			temp1.add(sala);
//			LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temp2 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
//			temp2.put(inter, temp1);
//			LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>> temp3 = new LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>>();
//			temp3.put(zi, temp2);
//			orarSala.put(parimp, temp3);
//			return 0;
//		} else {
//			if (orarSala.get(parimp).get(zi) == null) {
//				LinkedHashSet<Sala> temp1 = new LinkedHashSet<Sala>();
//				temp1.add(sala);
//				LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>> temp2 = new LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>();
//				temp2.put(inter, temp1);
//				orarSala.get(parimp).put(zi, temp2);
//				return 0;
//			} else {
//				if (orarSala.get(parimp).get(zi).get(inter) == null) {
//					LinkedHashSet<Sala> temp1 = new LinkedHashSet<Sala>();
//					temp1.add(sala);
//					orarSala.get(parimp).get(zi).put(inter, temp1);
//					return 0;
//				} else {
//					if (orarSala.get(parimp).get(zi).get(inter).contains(sala) == false) {
//						orarSala.get(parimp).get(zi).get(inter).add(sala);
//						return 0;
//					} else {
//						return -1;
//					}
//				}
//			}
//		}
	}

	public int addProf(CadruDidactic prof, Boolean parimp, IntervalOrar inter, String zi) {
		
		if (orarProf.get(parimp).get(zi).get(inter).contains(prof) == false) {
			orarProf.get(parimp).get(zi).get(inter).add(prof);
			return 0;
		} else {
			return -1;
		}
		
		
//		if (orarProf.get(parimp) == null) {
//			LinkedHashSet<CadruDidactic> temp1 = new LinkedHashSet<CadruDidactic>();
//			temp1.add(prof);
//			LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temp2 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
//			temp2.put(inter, temp1);
//			LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>> temp3 = new LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>>();
//			temp3.put(zi, temp2);
//			orarProf.put(parimp, temp3);
//			return 0;
//		} else {
//			if (orarProf.get(parimp).get(zi) == null) {
//				LinkedHashSet<CadruDidactic> temp1 = new LinkedHashSet<CadruDidactic>();
//				temp1.add(prof);
//				LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>> temp2 = new LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>();
//				temp2.put(inter, temp1);
//				orarProf.get(parimp).put(zi, temp2);
//				return 0;
//			} else {
//				if (orarProf.get(parimp).get(zi).get(inter) == null) {
//					LinkedHashSet<CadruDidactic> temp1 = new LinkedHashSet<CadruDidactic>();
//					temp1.add(prof);
//					orarProf.get(parimp).get(zi).put(inter, temp1);
//					return 0;
//				} else {
//					if (orarProf.get(parimp).get(zi).get(inter).contains(prof) == false) {
//						orarProf.get(parimp).get(zi).get(inter).add(prof);
//						return 0;
//					} else {
//						return -1;
//					}
//				}
//			}
//		}
	}

	public int editSala(Sala sala, Boolean parimp, IntervalOrar inter, String zi, int index, int link,
			ArrayList<Sala> t) {// Probleme aici ca verifica cu
		LinkedHashSet<Sala> temp = orarSala.get(parimp).get(zi).get(inter);
		if (temp.contains(sala)) {
			Sala sal;
			Iterator<Sala> tempo = temp.iterator();
			while (tempo.hasNext()) {
				sal = tempo.next();
				if (sal.equals(sala)) {
					for (int i = 0; i < 10; i++) {
						if (sal.getAn(i) != null) {
							if (sala.getAn(i) != null) {
								if (!(sal.getAn(i).getAnStudiu().equals(sala.getAn(i).getAnStudiu()))) {
									return -1;
								} else {
									if (link == 1) {
										return 0;
									}
								}
							} else {
								if(link != 1) {
									return -1;
								}
							}

						} else {
							if (sala.getAn(i) != null) {
								return -1;
							}
						}
					}
					return 0;
				}
			}

		}
		Predicate<Sala> pred = m -> {
			if (m.getAn(index) != null) {
				return sala.getAn(index).getAnStudiu().equals(m.getAn(index).getAnStudiu());
			}
			return false;

		};
		temp.stream().filter(pred).forEach(item -> {
			sala.setAn(item.getAn());
			t.add(item);

		});
		temp.removeAll(t);
		temp.add(sala);
		return 0;
	}

	public int editProf(CadruDidactic prof, Boolean parimp, IntervalOrar inter, String zi, int index, int link,
			ArrayList<CadruDidactic> t) {
		LinkedHashSet<CadruDidactic> temp = orarProf.get(parimp).get(zi).get(inter);
		if (temp.contains(prof)) {
			CadruDidactic sal;
			Iterator<CadruDidactic> tempo = temp.iterator();
			while (tempo.hasNext()) {
				sal = tempo.next();
				if (sal.equals(prof)) {
					for (int i = 0; i < 10; i++) {
						if (sal.getAn(i) != null) {
							if (prof.getAn(i) != null) {
								if (!(sal.getAn(i).getAnStudiu().equals(prof.getAn(i).getAnStudiu()))) {
									return -1;
								} else {
									if (link == 1) {
										sal.setDisciplina(prof.getDisciplina());
										return 0;
									}
								}
							} else {
								if(link != 1) {
									return -1;
								}
							}

						} else {
							if (prof.getAn(i) != null) {
								return -1;
							}
						}
					}
					sal.setDisciplina(prof.getDisciplina());
					return 0;
				}
			}

		}

		Predicate<CadruDidactic> pred = m -> {
			if (m.getAn(index) != null) {
				return prof.getAn(index).getAnStudiu().equals(m.getAn(index).getAnStudiu());
			}
			return false;
		};
		temp.stream().filter(pred).forEach(item -> {
			prof.setAn(item.getAn());
			t.add(item);
		});
		temp.removeAll(t);
		temp.add(prof);
		return 0;
	}

	public ArrayList<CadruDidactic> delProf(CadruDidactic prof, Boolean parimp, IntervalOrar inter, String zi,
			int index, ArrayList<CadruDidactic> pr) {
		LinkedHashSet<CadruDidactic> temp = orarProf.get(parimp).get(zi).get(inter);
		int k = 0;
		for (int i = 0; i < 10; i++) {
			if (prof.getAn(i) != null) {
				k++;
			}
		}
		final int g = k;
		Predicate<CadruDidactic> pred = m -> {
			int h = 0;
			for (int i = 0; i < 10; i++) {
				if (m.getAn(i) != null) {
					h++;
				}
			}
			if (m.getAn(index) != null && h == g) {
				return prof.getAn(index).getAnStudiu().equals(m.getAn(index).getAnStudiu());
			}
			return false;

		};
		temp.stream().filter(pred).forEach(item -> {
			pr.add(item);

		});
		return pr;
	}

	public ArrayList<Sala> delSala(Sala sala, Boolean parimp, IntervalOrar inter, String zi, int index,
			ArrayList<Sala> sa) {
		LinkedHashSet<Sala> temp = orarSala.get(parimp).get(zi).get(inter);
		int k = 0;
		for (int i = 0; i < 10; i++) {
			if (sala.getAn(i) != null) {
				k++;
			}
		}
		final int g = k;
		Predicate<Sala> pred = m -> {
			int h = 0;
			for (int i = 0; i < 10; i++) {
				if (m.getAn(i) != null) {
					h++;
				}
			}
			if (m.getAn(index) != null && h == g) {
				return sala.getAn(index).getAnStudiu().equals(m.getAn(index).getAnStudiu());
			}
			return false;

		};
		temp.stream().filter(pred).forEach(item -> {
			sa.add(item);

		});
		return sa;
	}

	public static void main(String[] args) {
		try {// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if (info.getName().equals("Nimbus")) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				GuiInterface gui = new GuiInterface();
			}
		});
	}

	public LinkedHashMap<Boolean, LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>>> getOrarSala() {
		return orarSala;
	}

	public void setOrarSala(
			LinkedHashMap<Boolean, LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<Sala>>>> orarSala) {
		this.orarSala = orarSala;
	}

	public LinkedHashMap<Boolean, LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>>> getOrarProf() {
		return orarProf;
	}

	public void setOrarProf(
			LinkedHashMap<Boolean, LinkedHashMap<String, LinkedHashMap<IntervalOrar, LinkedHashSet<CadruDidactic>>>> orarProf) {
		this.orarProf = orarProf;
	}

	public int[][][] getVecTemp() {
		return vecTemp;
	}

	public void setVecTemp(int[][][] vecTemp) {
		this.vecTemp = vecTemp;
	}

}
