import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TDFFileReader {

    private final File tdfFinishers;

    public TDFFileReader(String filename) {
        tdfFinishers = new File(filename);
    }

    public List<Rider> readFile(){
        List<Rider> riders = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(this.tdfFinishers);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] values = line.split(";");
                riders.add(new Rider(values[1], values[2]));
            }
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }

       return riders;

    }
}
