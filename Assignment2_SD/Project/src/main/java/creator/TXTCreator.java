package creator;

import creator.IFileCreator;
import model.Report;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class TXTCreator implements IFileCreator {
    @Override
    public void createFile(String path, List<Report> reps) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(path+"/report.txt", "UTF-8");
        for(Report rep : reps){
            writer.println("User ID: "+rep.getUid().getId() +", Drug bought: " +rep.getDrug() +", Amount: "+rep.getAmount());
        }
        writer.close();
    }
}
