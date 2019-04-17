package mainC;

import java.util.LinkedHashMap;
import java.util.function.Predicate;
import data.MonitoredData;
import extractor.Extractor;

public class Handler2 {
	public LinkedHashMap<String, Integer> countAccByDay(int day, Extractor ex) {
		LinkedHashMap<String, Integer> tempo = new LinkedHashMap<String, Integer>();
		tempo.put(ex.leaving, 0);
		tempo.put(ex.toileting, 0);
		tempo.put(ex.showering, 0);
		tempo.put(ex.sleeping, 0);
		tempo.put(ex.breakfast, 0);
		tempo.put(ex.lunch, 0);
		tempo.put(ex.dinner, 0);
		tempo.put(ex.snack, 0);
		tempo.put(ex.spTime, 0);
		tempo.put(ex.grooming, 0);
		Predicate<MonitoredData> predicate = s -> {
			boolean test = s.checkEachDay(day);
			if (test == true) {
				return true;

			} else {
				if (s.getStartTime().getDayOfMonth() == day && ex.getFlag() == 0) {
					ex.setFlag(1);
					return true;
				} else {
					if (ex.getFlag() == 1 && s.getEndTime().getDayOfMonth() == day) {
						ex.setFlag(0);
						return true;
					} else {
						return false;
					}
				}
			}

		};

		ex.getMon().stream().filter(predicate).forEach(item -> {
			switch (item.getActivity()) {
			case "Leaving":
				int countL = tempo.get(ex.leaving);
				countL++;
				tempo.put(ex.leaving, countL);
				break;

			case "Toileting":
				int countT = tempo.get(ex.toileting);
				countT++;
				tempo.put(ex.toileting, countT);
				break;

			case "Showering":
				int countSw = tempo.get(ex.showering);
				countSw++;
				tempo.put(ex.showering, countSw);
				break;

			case "Sleeping":
				int countS = tempo.get(ex.sleeping);
				countS++;
				tempo.put(ex.sleeping, countS);
				break;

			case "Breakfast":
				int countBr = tempo.get(ex.breakfast);
				countBr++;
				tempo.put(ex.breakfast, countBr);
				break;

			case "Lunch":
				int countLc = tempo.get(ex.lunch);
				countLc++;
				tempo.put(ex.lunch, countLc);
				break;

			case "Dinner":
				int countD = tempo.get(ex.dinner);
				countD++;
				tempo.put(ex.dinner, countD);
				break;

			case "Snack":
				int countSk = tempo.get(ex.snack);
				countSk++;
				tempo.put(ex.snack, countSk);
				break;

			case "Spare_Time/TV":
				int countSp = tempo.get(ex.spTime);
				countSp++;
				tempo.put(ex.spTime, countSp);
				break;

			case "Grooming":
				int countG = tempo.get(ex.grooming);
				countG++;
				tempo.put(ex.grooming, countG);
				break;
			}

		});
		return tempo;
	}
}
