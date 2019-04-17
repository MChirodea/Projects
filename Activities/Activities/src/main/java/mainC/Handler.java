package mainC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.joda.time.DateTime;
import org.joda.time.base.BaseDateTime;

import extractor.Extractor;

public class Handler {

	public ArrayList<String> activity5(Extractor ex) {
		ex.getCountMap().entrySet().stream().forEach(item -> {
			switch (item.getKey()) {
			case "Leaving":
				ex.setC(0, (int) ((90.0 / 100.0) * (float) item.getValue()));
				break;

			case "Toileting":
				ex.setC(1, (int) ((90.0 / 100.0) * (float) item.getValue()));
				break;

			case "Showering":
				ex.setC(2, (int) ((90.0 / 100.0) * (float) item.getValue()));
				break;

			case "Sleeping":
				ex.setC(3, (int) ((90.0 / 100.0) * (float) item.getValue()));
				break;

			case "Breakfast":
				ex.setC(4, (int) ((90.0 / 100.0) * (float) item.getValue()));
				break;

			case "Lunch":
				ex.setC(5, (int) ((90.0 / 100.0) * (float) item.getValue()));
				break;

			case "Dinner":
				ex.setC(6, (int) ((90.0 / 100.0) * (float) item.getValue()));
				break;

			case "Snack":
				ex.setC(7, (int) ((90.0 / 100.0) * (float) item.getValue()));
				break;

			case "Spare_Time/TV":
				ex.setC(8, (int) ((90.0 / 100.0) * (float) item.getValue()));
				break;

			case "Grooming":
				ex.setC(9, (int) ((90.0 / 100.0) * (float) item.getValue()));
				break;
			}
		});
		ex.getMon().stream().forEach(item -> {
			for (int i = 0; i <= 9; i++) {
				if (ex.getC(i) == 0) {
					ex.getTemp().remove(ex.getActivity(i));
				}
				switch (item.getActivity()) {
				case "Leaving":
					if (TimeUnit.MILLISECONDS
							.toSeconds(item.getEndTime().getMillis() - item.getStartTime().getMillis()) >= 300) {
						ex.setRes(0, ex.getRes(0) + 1);
						if (ex.getRes(0) < ex.getC(0)) {
							ex.getTemp().remove(ex.leaving);
						}
					}
					break;

				case "Toileting":
					if (TimeUnit.MILLISECONDS
							.toSeconds(item.getEndTime().getMillis() - item.getStartTime().getMillis()) >= 300) {
						ex.setRes(1, ex.getRes(1) + 1);
						if (ex.getRes(1) < ex.getC(1)) {
							ex.getTemp().remove(ex.toileting);
						}
					}
					break;

				case "Showering":
					if (TimeUnit.MILLISECONDS
							.toSeconds(item.getEndTime().getMillis() - item.getStartTime().getMillis()) >= 300) {
						ex.setRes(2, ex.getRes(2) + 1);
						if (ex.getRes(2) < ex.getC(2)) {
							ex.getTemp().remove(ex.showering);
						}
					}
					break;

				case "Sleeping":
					if (TimeUnit.MILLISECONDS
							.toSeconds(item.getEndTime().getMillis() - item.getStartTime().getMillis()) >= 300) {
						ex.setRes(3, ex.getRes(3) + 1);
						if (ex.getRes(3) < ex.getC(3)) {
							ex.getTemp().remove(ex.sleeping);
						}
					}
					break;

				case "Breakfast":
					if (TimeUnit.MILLISECONDS
							.toSeconds(item.getEndTime().getMillis() - item.getStartTime().getMillis()) >= 300) {
						ex.setRes(4, ex.getRes(4) + 1);
						if (ex.getRes(4) < ex.getC(4)) {
							ex.getTemp().remove(ex.breakfast);
						}
					}
					break;

				case "Lunch":
					if (TimeUnit.MILLISECONDS
							.toSeconds(item.getEndTime().getMillis() - item.getStartTime().getMillis()) >= 300) {
						ex.setRes(5, ex.getRes(5) + 1);
						if (ex.getRes(5) < ex.getC(5)) {
							ex.getTemp().remove(ex.lunch);
						}
					}
					break;

				case "Dinner":
					if (TimeUnit.MILLISECONDS
							.toSeconds(item.getEndTime().getMillis() - item.getStartTime().getMillis()) >= 300) {
						ex.setRes(6, ex.getRes(6) + 1);
						if (ex.getRes(6) < ex.getC(6)) {
							ex.getTemp().remove(ex.dinner);
						}
					}
					break;

				case "Snack":
					if (TimeUnit.MILLISECONDS
							.toSeconds(item.getEndTime().getMillis() - item.getStartTime().getMillis()) >= 300) {
						ex.setRes(7, ex.getRes(7) + 1);
						if (ex.getRes(7) < ex.getC(7)) {
							ex.getTemp().remove(ex.snack);
						}
					}
					break;

				case "Spare_Time/TV":
					if (TimeUnit.MILLISECONDS
							.toSeconds(item.getEndTime().getMillis() - item.getStartTime().getMillis()) < 300) {
						ex.setRes(8, ex.getRes(8) + 1);
						if (ex.getRes(8) < ex.getC(8)) {
							ex.getTemp().remove(ex.spTime);
						}
					}
					break;

				case "Grooming":
					if (TimeUnit.MILLISECONDS
							.toSeconds(item.getEndTime().getMillis() - item.getStartTime().getMillis()) < 300) {
						ex.setRes(9, ex.getRes(9) + 1);
						if (ex.getRes(9) < ex.getC(9)) {
							ex.getTemp().remove(ex.grooming);
						}
					}
					break;
				}
			}
		});
		return ex.getTemp();
	}

	public static void main(String[] args) {
		Handler help = new Handler();
		Handler2 help2 = new Handler2();
		// TODO Auto-generated method stub
		try {
			Extractor ex = new Extractor();
			ex.extractFile(); // Done
			int days = ex.countDays(); // Done
			LinkedHashMap<String, Integer> map = ex.countActivities(); // Done
			LinkedHashMap<Integer, LinkedHashMap<String, Integer>> mapAcc = ex.getActivitesPerDay(help2);
			LinkedHashMap<String, DateTime> mapDate = ex.getActivityDate();
			ArrayList<String> tst = help.activity5(ex);
			System.out.println("Count of Activities: \n");
			map.entrySet().stream().forEach(item -> {
				System.out.println(item.getKey() + ": " + item.getValue());
				ex.getWriter().println(item.getKey() + ": " + item.getValue());
			});
			ex.getWriter().close();
			System.out.println("\nActivity Count By Day: \n");
			ex.initWriter("ActivityCountByDay.txt");
			mapAcc.entrySet().stream().forEach(item -> {
				System.out.println("Day " + item.getKey() + ": " + item.getValue());
				ex.getWriter().println("Day " + item.getKey() + ": " + item.getValue());
			});
			ex.getWriter().close();
			System.out.println("\nNr. of Days: " + days + "\n");
			System.out.println("Hours for each activity: \n");
			@SuppressWarnings("rawtypes")
			Predicate<Entry> predicate = s -> {
				return ((float) (TimeUnit.MILLISECONDS.toMinutes(((BaseDateTime) s.getValue()).getMillis()))
						/ 60.0 >= 10);
			};
			mapDate.entrySet().stream().forEach(item -> {
				float temp = (float) ((float) (TimeUnit.MILLISECONDS.toMinutes(item.getValue().getMillis())) / 60.0);

				System.out.printf("%s: %.1f\n", item.getKey(), temp);

			});
			ex.initWriter("HourTotalBiggerThan10.txt");
			mapDate.entrySet().stream().filter(predicate).forEach(item -> {
				float temp = (float) ((float) (TimeUnit.MILLISECONDS.toMinutes(item.getValue().getMillis())) / 60.0);
				ex.getWriter().printf("%s: %.1f", item.getKey(), temp);
				ex.getWriter().println();
			});
			ex.getWriter().close();
			System.out.println("\nActivities with smaller than 5 minutes duration 90% of the time \n");
			ex.initWriter("Activity5.txt");
			tst.stream().forEach(item -> {
				ex.getWriter().println(item);
				System.out.println(item);
			});
			ex.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
