package control;

import java.util.Random;

import gui.GuiSimulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class ComparatorMon implements Comparator<Person> {

	public int compare(Person mon1, Person mon2) {
		// TODO Auto-generated method stub
		if (mon1.getArrivalTime() > mon2.getArrivalTime()) {
			return 1;
		} else
			return -1;
	}

}

public class ClientGenerator extends Thread {
	private int number = 0;
	private ArrayList<Queue> qList;
	private ArrayList<Person> cList;

	public ClientGenerator(int number, Queue q, Queue q1, Queue q2, Queue q3, Queue q4, Queue q5, Queue q6) {
		this.qList = new ArrayList<Queue>();
		this.qList.add(q);
		this.qList.add(q1);
		this.qList.add(q2);
		this.qList.add(q3);
		this.qList.add(q4);
		this.qList.add(q5);
		this.qList.add(q6);
		this.number = number;
	}

	public synchronized int getMin(int qN) {
		int min = Math.min(qList.get(0).getTime(), qList.get(1).getTime());
		int min1 = Math.min(min, qList.get(2).getTime());
		int min2 = Math.min(min1, qList.get(3).getTime());
		int min3 = Math.min(min2, qList.get(4).getTime());
		int min4 = Math.min(min3, qList.get(5).getTime());
		int min5 = Math.min(min4, qList.get(6).getTime());
		switch (qN) {
		case 1:
			return qList.get(0).getTime();

		case 2:
			return min;
		case 3:
			return min1;
		case 4:
			return min2;
		case 5:
			return min3;
		case 6:
			return min4;
		case 7:
			return min5;
		}
		return min5;
	}

	public synchronized int chooseNumber(Queue q, Queue q1, Queue q2, Queue q3, Queue q4, Queue q5, Queue q6, int min5,
			Person client, int qN, int time) {
		if (q.getTime() == min5) {
			q.addPerson(client, time);
			return 0;
		} else {
			if (q1.getTime() == min5) {
				q1.addPerson(client, time);
				return 1;
			} else {
				if (q2.getTime() == min5) {
					q2.addPerson(client, time);
					return 2;
				} else {
					if (q3.getTime() == min5) {
						q3.addPerson(client, time);
						return 3;
					} else {
						if (q4.getTime() == min5) {
							q4.addPerson(client, time);
							return 4;
						} else {
							if (q5.getTime() == min5) {
								q5.addPerson(client, time);
								return 5;
							} else {
								q6.addPerson(client, time);
								return 6;
							}
						}
					}
				}
			}
		}
	}

	public void generator(int arrMin, int arrMax, int servMin, int servMax,int qNr) {
		this.cList = new ArrayList<Person>();
		Random random = new Random();
		if(arrMin < 2){
			arrMin = 2;
		}
		if(arrMax < 2){
			arrMax = 3;
		}
		int max = this.number + 50;
		for (int i = 1; i <= max ; i++) {
			Person client = new Person(0, 0, 0);
			client.setID(i);
			client.setArrivalTime(random.nextInt((arrMax - arrMin) + 1) + arrMin);
			client.setServiceTime(random.nextInt((servMax - servMin) + 1) + servMin);
			cList.add(client);
			Collections.sort(cList, new ComparatorMon());

		}

	}

	public void run(int arrMin, int arrMax, int servMin, int servMax, int qNumber) throws InterruptedException {
		this.generator(arrMin, arrMax, servMin, servMax, qNumber);
		Iterator<Person> itp = cList.iterator();
		int c = 0;
		while (c < this.number) {
			if (itp.hasNext()) {
				Person client = itp.next();
				sleep(client.getArrivalTime()*1000);
				int min = this.getMin(qNumber);
				int val = this.chooseNumber(qList.get(0), qList.get(1), qList.get(2), qList.get(3), qList.get(4),
						qList.get(5), qList.get(6), min, client, qNumber, c);
				if (qList.get(val).getDelet() >= qList.get(val).getNext(qList.get(val).getIndex())) {
					int ind = qList.get(val).getIndex();
					int sl = qList.get(val).getNext(ind);
					sleep(sl*500);
					c+= qList.get(val).getDelet();
					qList.get(val).dP(c);
					Random rand = new Random();
					int g = rand.nextInt(qNumber);
					int[] v = new int[qNumber];
					for(int i = 0; i <= g; i++){
						int k = rand.nextInt(qNumber);
						if(k != val && v[k] != 1){
							v[k] = 1;
							switch(k){
							 case 0:
								 if(!(GuiSimulation.labelP8.getText().equals("0"))){
									 sleep(2000);
									 c+= qList.get(k).getNext(qList.get(k).getIndexST());
									 qList.get(k).dP(c);
									 sleep(200);
									 
									
								}
								break;
							 case 1:
								 if(!(GuiSimulation.labelP9.getText().equals("0"))){
									 sleep(2000);
									 c+= qList.get(k).getNext(qList.get(k).getIndexST());
									 qList.get(k).dP(c);
									 sleep(200);
									
								}
								break;
							 case 2:
								 if(!(GuiSimulation.labelP10.getText().equals("0"))){
									 sleep(2000);
									 c+= qList.get(k).getNext(qList.get(k).getIndexST());
									 qList.get(k).dP(c);
									 sleep(200);
								}

								break;
							 case 3:
								 if(!(GuiSimulation.labelP11.getText().equals("0"))){
									 sleep(2000);
									 c+= qList.get(k).getNext(qList.get(k).getIndexST());
									 qList.get(k).dP(c);
									 sleep(200);
							}
	
							break;
							 case 4:
								 if(!(GuiSimulation.labelP12.getText().equals("0"))){
									 sleep(2000);
									 c+= qList.get(k).getNext(qList.get(k).getIndexST());
									 qList.get(k).dP(c);
									 sleep(200);
								}

								break;
							 case 5:
								 if(!(GuiSimulation.labelP13.getText().equals("0"))){
									 sleep(2000);
									 c+= qList.get(k).getNext(qList.get(k).getIndexST());
									 qList.get(k).dP(c);
									 sleep(200);
								}

								break;
							 case 6:
								 if(!(GuiSimulation.labelP14.getText().equals("0"))){
									 sleep(2000);
									 c+= qList.get(k).getNext(qList.get(k).getIndexST());
									 qList.get(k).dP(c);
									 sleep(200);
								}

								break;
							}
							
						}
					}
					
					
					qList.get(val).incIndex();
					qList.get(val).setDelet(1);
				}
				else{
					qList.get(val).incDelet();
				}

				c++;
			}
		}

		System.out.println("--End of Simulation--");

	}

	public void start(int minA, int maxA, int minS, int maxS, int qNrS) throws InterruptedException {
		// TODO Auto-generated method stub
		this.run(minA, maxA, minS, maxS, qNrS);

	}
}
