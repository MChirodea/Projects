package extractor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.function.Predicate;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import data.MonitoredData;
import mainC.Handler2;

public class Extractor {
	private LinkedHashSet<MonitoredData> mon;
	private LinkedHashMap<String, Integer> countMap;
	LinkedHashMap<Integer, LinkedHashMap<String, Integer>> countDayActivity;
	private ArrayList<String> temp;
	public final String leaving = "Leaving";
	public final String toileting = "Toileting";
	public final String showering = "Showering";
	public final String sleeping = "Sleeping";
	public final String breakfast = "Breakfast";
	public final String lunch = "Lunch";
	public final String dinner = "Dinner";
	public final String snack = "Snack";
	public final String spTime = "Spare_Time/TV";
	public final String grooming = "Grooming";
	private int prevDay = 0;
	private int flag = 0;
	private long sum[] = new long[10];
	private int c[] = new int[10];
	private int res[] = new int[10];
	private PrintWriter writer;

	public void initWriter(String s) throws FileNotFoundException, UnsupportedEncodingException {
		setWriter(new PrintWriter(s, "UTF-8"));
	}

	public String getActivity(int i) {
		switch (i) {
		case 0:
			return leaving;
		case 1:
			return toileting;
		case 2:
			return showering;
		case 3:
			return sleeping;
		case 4:
			return breakfast;
		case 5:
			return lunch;
		case 6:
			return dinner;
		case 7:
			return snack;
		case 8:
			return spTime;
		case 9:
			return grooming;
		}
		return null;
	}

	public Extractor() {
		setMon(new LinkedHashSet<MonitoredData>());
		setCountMap(new LinkedHashMap<String, Integer>());
		countDayActivity = new LinkedHashMap<Integer, LinkedHashMap<String, Integer>>();
		getCountMap().put(leaving, 0);
		getCountMap().put(toileting, 0);
		getCountMap().put(showering, 0);
		getCountMap().put(sleeping, 0);
		getCountMap().put(breakfast, 0);
		getCountMap().put(lunch, 0);
		getCountMap().put(dinner, 0);
		getCountMap().put(snack, 0);
		getCountMap().put(spTime, 0);
		getCountMap().put(grooming, 0);
		setTemp(new ArrayList<String>());
		getTemp().add(leaving);
		getTemp().add(toileting);
		getTemp().add(showering);
		getTemp().add(sleeping);
		getTemp().add(breakfast);
		getTemp().add(lunch);
		getTemp().add(dinner);
		getTemp().add(snack);
		getTemp().add(spTime);
		getTemp().add(grooming);
		try {
			this.initWriter("ActivityCount.txt");
			// writer = new PrintWriter("HourTotalBiggerThan10.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void store(String s) {
		String[] parts = s.split("\\t\t");
		parts[2] = parts[2].replace("\t", "");
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		DateTime dt = formatter.parseDateTime(parts[0]);
		DateTime dt2 = formatter.parseDateTime(parts[1]);
		getMon().add(new MonitoredData(dt, dt2, parts[2]));
	}

	public LinkedHashSet<MonitoredData> extractFile() throws IOException {
		Files.lines(Paths.get("Activity.txt")).forEach(line -> store(line));
		return getMon();
	}

	public int countDays() {
		Predicate<MonitoredData> predicate = s -> {
			boolean test = s.checkDay(prevDay);
			prevDay = s.getStartTime().getDayOfMonth();
			return test;
		};
		int countDays = (int) getMon().stream().filter(predicate).count();
		return countDays;

	}

	public ArrayList<Integer> getDays() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Predicate<MonitoredData> predicate = s -> {
			boolean test = s.checkDay(prevDay);
			prevDay = s.getStartTime().getDayOfMonth();
			return test;
		};
		getMon().stream().filter(predicate).forEach(item -> temp.add(item.getStartTime().getDayOfMonth()));
		return temp;
	}

	public LinkedHashMap<String, Integer> countActivities() {
		this.getMon().stream().forEach(item -> {
			switch (item.getActivity()) {
			case "Leaving":
				int countL = getCountMap().get(leaving);
				countL++;
				getCountMap().put(leaving, countL);
				break;

			case "Toileting":
				int countT = getCountMap().get(toileting);
				countT++;
				getCountMap().put(toileting, countT);
				break;

			case "Showering":
				int countSw = getCountMap().get(showering);
				countSw++;
				getCountMap().put(showering, countSw);
				break;

			case "Sleeping":
				int countS = getCountMap().get(sleeping);
				countS++;
				getCountMap().put(sleeping, countS);
				break;

			case "Breakfast":
				int countBr = getCountMap().get(breakfast);
				countBr++;
				getCountMap().put(breakfast, countBr);
				break;

			case "Lunch":
				int countLc = getCountMap().get(lunch);
				countLc++;
				getCountMap().put(lunch, countLc);
				break;

			case "Dinner":
				int countD = getCountMap().get(dinner);
				countD++;
				getCountMap().put(dinner, countD);
				break;

			case "Snack":
				int countSk = getCountMap().get(snack);
				countSk++;
				getCountMap().put(snack, countSk);
				break;

			case "Spare_Time/TV":
				int countSp = getCountMap().get(spTime);
				countSp++;
				getCountMap().put(spTime, countSp);
				break;

			case "Grooming":
				int countG = getCountMap().get(grooming);
				countG++;
				getCountMap().put(grooming, countG);
				break;
			}
		});
		return getCountMap();
	}

	
	public LinkedHashMap<Integer, LinkedHashMap<String, Integer>> getActivitesPerDay(Handler2 h) {
		ArrayList<Integer> day = this.getDays();
		day.stream().forEach(item -> countDayActivity.put(item, h.countAccByDay(item,this)));
		return countDayActivity;
	}

	public LinkedHashMap<String, DateTime> getActivityDate() {
		LinkedHashMap<String, DateTime> temp = new LinkedHashMap<String, DateTime>();
		DateTime aux = new DateTime();
		temp.put(leaving, aux);
		temp.put(toileting, aux);
		temp.put(showering, aux);
		temp.put(sleeping, aux);
		temp.put(breakfast, aux);
		temp.put(lunch, aux);
		temp.put(dinner, aux);
		temp.put(snack, aux);
		temp.put(spTime, aux);
		temp.put(grooming, aux);
		this.getMon().stream().forEach(item -> {
			switch (item.getActivity()) {
			case "Leaving":
				getSum()[0] = getSum()[0] + (item.getEndTime().getMillis() - item.getStartTime().getMillis());
				break;

			case "Toileting":
				getSum()[1] = getSum()[1] + (item.getEndTime().getMillis() - item.getStartTime().getMillis());
				break;

			case "Showering":
				getSum()[2] = getSum()[2] + (item.getEndTime().getMillis() - item.getStartTime().getMillis());
				break;

			case "Sleeping":
				getSum()[3] = getSum()[3] + (item.getEndTime().getMillis() - item.getStartTime().getMillis());
				break;

			case "Breakfast":
				getSum()[4] = getSum()[4] + (item.getEndTime().getMillis() - item.getStartTime().getMillis());
				break;

			case "Lunch":
				getSum()[5] = getSum()[5] + (item.getEndTime().getMillis() - item.getStartTime().getMillis());
				break;

			case "Dinner":
				getSum()[6] = getSum()[6] + (item.getEndTime().getMillis() - item.getStartTime().getMillis());
				break;

			case "Snack":
				getSum()[7] = getSum()[7] + (item.getEndTime().getMillis() - item.getStartTime().getMillis());
				break;

			case "Spare_Time/TV":
				getSum()[8] = getSum()[8] + (item.getEndTime().getMillis() - item.getStartTime().getMillis());
				break;

			case "Grooming":
				getSum()[9] = getSum()[9] + (item.getEndTime().getMillis() - item.getStartTime().getMillis());
				break;
			}
		});
		DateTime countD = new DateTime(getSum()[6]);
		temp.put(dinner, countD);
		DateTime countL = new DateTime(getSum()[0]);
		temp.put(leaving, countL);
		DateTime countT = new DateTime(getSum()[1]);
		temp.put(toileting, countT);
		DateTime countSw = new DateTime(getSum()[2]);
		temp.put(showering, countSw);
		DateTime countS = new DateTime(getSum()[3]);
		temp.put(sleeping, countS);
		DateTime countBr = new DateTime(getSum()[4]);
		temp.put(breakfast, countBr);
		DateTime countLc = new DateTime(getSum()[5]);
		temp.put(lunch, countLc);
		DateTime countSk = new DateTime(getSum()[7]);
		temp.put(snack, countSk);
		DateTime countSp = new DateTime(getSum()[8]);
		temp.put(spTime, countSp);
		DateTime countG = new DateTime(getSum()[9]);
		temp.put(grooming, countG);
		return temp;
	}

	

	public long[] getSum() {
		return sum;
	}

	public void setSum(long sum[]) {
		this.sum = sum;
	}

	public PrintWriter getWriter() {
		return writer;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	public LinkedHashMap<String, Integer> getCountMap() {
		return countMap;
	}

	public void setCountMap(LinkedHashMap<String, Integer> countMap) {
		this.countMap = countMap;
	}

	public LinkedHashSet<MonitoredData> getMon() {
		return mon;
	}

	public void setMon(LinkedHashSet<MonitoredData> mon) {
		this.mon = mon;
	}

	public int getC(int i) {
		return c[i];
	}

	public void setC(int c, int val) {
		this.c[c] = val;
	}

	public ArrayList<String> getTemp() {
		return temp;
	}

	public void setTemp(ArrayList<String> temp) {
		this.temp = temp;
	}

	public int getRes(int i) {
		return res[i];
	}

	public void setRes(int i, int val) {
		this.res[i] = val;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
