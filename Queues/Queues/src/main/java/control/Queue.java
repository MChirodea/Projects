package control;

import java.util.ArrayList;


import gui.GuiSimulation;

public class Queue extends Thread {
	private ArrayList<Person> clientList;
	private ArrayList<Integer> vals;
	private int qNr = 1;
	private int valo = 0;
	private int delet = 1;
	private int index = 0;
	private int index2 = 0;

	public Queue(int q) {
		this.clientList = new ArrayList<Person>();
		this.vals = new ArrayList<Integer>();
		this.qNr = q;
		this.valo = 0;

	}
	public int getIndexST(){
		return this.index;
	}
	public int getValo(){
		return this.valo;
	}
	public void incIndex(){
		this.index2++;
	}
	
	public int getIndex(){
		return this.index2;
	}
	public int getDelet(){
		return this.delet;
	}
	
	public int getNext(int index){
		return this.vals.get(index);
	}
	
	public void setDelet(int delet){
		this.delet = delet;
	}
	
	public void incDelet(){
		this.delet++;
	}
	public int getTime() {
		return this.valo;
	}

	public synchronized void resetQ() {
		this.valo = 0;
	}

	public synchronized int addPerson(Person p, int time) {
		this.clientList.add(p);
		this.vals.add(p.getServiceTime());
		System.out.println(
				"Queue: " + this.qNr + " ->Client " + p.getID() + " arrived at " + (time + p.getArrivalTime()));
		time += p.getArrivalTime();
		time++;
		this.valo = this.valo + p.getServiceTime();
		String val;
		String val1;
		switch (this.qNr) {
		case 1:
			val = GuiSimulation.labelP1.getText();
			GuiSimulation.labelP1.setText(val + " " + p.getID());
			val1 = "Wait Time Q1: " + this.valo;
			GuiSimulation.labelP8.setText(val1);
			break;
		case 2:
			val = GuiSimulation.labelP2.getText();
			GuiSimulation.labelP2.setText(val + " " + p.getID());
			val1 = "Wait Time Q2: " + this.valo;
			GuiSimulation.labelP9.setText(val1);
			break;
		case 3:
			val = GuiSimulation.labelP3.getText();
			GuiSimulation.labelP3.setText(val + " " + p.getID());
			val1 = "Wait Time Q3: " + this.valo;
			GuiSimulation.labelP10.setText(val1);
			break;
		case 4:
			val = GuiSimulation.labelP4.getText();
			GuiSimulation.labelP4.setText(val + " " + p.getID());
			val1 = "Wait Time Q4: " + this.valo;
			GuiSimulation.labelP11.setText(val1);
			break;
		case 5:
			val = GuiSimulation.labelP5.getText();
			GuiSimulation.labelP5.setText(val + " " + p.getID());
			val1 = "Wait Time Q5: " + this.valo;
			GuiSimulation.labelP12.setText(val1);
			break;
		case 6:
			val = GuiSimulation.labelP6.getText();
			GuiSimulation.labelP6.setText(val + " " + p.getID());
			val1 = "Wait Time Q6: " + this.valo;
			GuiSimulation.labelP13.setText(val1);
			break;
		case 7:
			val = GuiSimulation.labelP7.getText();
			GuiSimulation.labelP7.setText(val + " " + p.getID());
			val1 = "Wait Time Q7: " + this.valo;
			GuiSimulation.labelP14.setText(val1);
			break;
		default:
			val = GuiSimulation.labelP1.getText();
			GuiSimulation.labelP1.setText(val + " " + p.getID());
			val1 = "Wait Time Q1: " + this.valo;
			GuiSimulation.labelP8.setText(val1);
			break;
		}
		return time;
	}

	public synchronized void dP(int time) {
		if (this.clientList.size() > index) {
			Person pTemp = this.clientList.get(this.index);
			this.index++;
			this.valo = this.valo - pTemp.getServiceTime();
			System.out.println("Queue: " + this.qNr + " ->Client " + pTemp.getID() + " left at "
					+ (time + pTemp.getServiceTime()) + ": Service time: " + pTemp.getServiceTime());
			time += pTemp.getServiceTime();

			String qText = "";
			String qWText = "";
			switch (this.qNr) {
			case 1:
				qWText = "Wait Time Q1: " + this.valo;
				GuiSimulation.labelP8.setText(qWText);
				qText = GuiSimulation.labelP1.getText();
				break;
			case 2:
				qWText = "Wait Time Q2: " + this.valo;
				GuiSimulation.labelP9.setText(qWText);
				qText = GuiSimulation.labelP2.getText();
				break;
			case 3:
				qWText = "Wait Time Q3: " + this.valo;
				GuiSimulation.labelP10.setText(qWText);
				qText = GuiSimulation.labelP3.getText();
				break;
			case 4:
				qWText = "Wait Time Q4: " + this.valo;
				GuiSimulation.labelP11.setText(qWText);
				qText = GuiSimulation.labelP4.getText();
				break;
			case 5:
				qWText = "Wait Time Q5: " + this.valo;
				GuiSimulation.labelP12.setText(qWText);
				qText = GuiSimulation.labelP5.getText();
				break;
			case 6:
				qWText = "Wait Time Q6: " + this.valo;
				GuiSimulation.labelP13.setText(qWText);
				qText = GuiSimulation.labelP6.getText();
				break;
			case 7:
				qWText = "Wait Time Q7: " + this.valo;
				GuiSimulation.labelP14.setText(qWText);
				qText = GuiSimulation.labelP7.getText();
				break;
			}
			String qNumber = qText.substring(0, 8);
			String qClients = qText.substring(8, qText.length());
			String k = " ";
			String[] t1 = qClients.split(k);
			String temp = qNumber;
			if (t1.length > 2) {
				for (int i = 2; i < t1.length; i++) {
					temp = temp + " " + t1[i];
					switch (this.qNr) {
					case 1:
						GuiSimulation.labelP1.setText(temp);
						break;
					case 2:
						GuiSimulation.labelP2.setText(temp);
						break;
					case 3:
						GuiSimulation.labelP3.setText(temp);
						break;
					case 4:
						GuiSimulation.labelP4.setText(temp);
						break;
					case 5:
						GuiSimulation.labelP5.setText(temp);
						break;
					case 6:
						GuiSimulation.labelP6.setText(temp);
						break;
					case 7:
						GuiSimulation.labelP7.setText(temp);
						break;
					}
				}
			} else {
				switch (this.qNr) {
				case 1:
					GuiSimulation.labelP1.setText(qNumber);
					break;
				case 2:
					GuiSimulation.labelP2.setText(qNumber);
					break;
				case 3:
					GuiSimulation.labelP3.setText(qNumber);
					break;
				case 4:
					GuiSimulation.labelP4.setText(qNumber);
					break;
				case 5:
					GuiSimulation.labelP5.setText(qNumber);
					break;
				case 6:
					GuiSimulation.labelP6.setText(qNumber);
					break;
				case 7:
					GuiSimulation.labelP7.setText(qNumber);
					break;
				}
			}
		}
	}

	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}