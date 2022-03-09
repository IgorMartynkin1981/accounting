import java.util.ArrayList;
import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class FileManager {

    //считываем кол-во файлов в конечной директории
    public int numberOfFilesInFolder(String path) {
        File file = new File(path);
        File[] s = file.listFiles();
        assert s != null;
        return s.length;
    }

    // Обрабатываем информацию с файлов (месячные отчёты)
    void readAndWriteFileContentMonth(){
        ArrayList<String> stringMonthBase = new ArrayList<>();
        for (int i = 1; i <= numberOfFilesInFolder("/Users/TTa9IJIbHuk/dev/java-sprint1-hw/resources");
             i++) {
            String content = readFileContentsOrNull("m.20210" + i);
            if (content != null) {
                String[] lines = content.split("\\n");
                for (int j = 1; j < lines.length; j++) stringMonthBase.add("0" + i + "," + lines[j]);
            } else {
                break;
            }
        }
        writeMonthBases(stringMonthBase);
    }

    //передаём месячные данные в InformationDatabase
    void writeMonthBases(ArrayList<String> stringMonthBase) {
        for (String s : stringMonthBase) {
            String[] readLine = s.split(",");
            Monthly monthlyReport = new Monthly(
                    Integer.parseInt(readLine[0]),
                    readLine[1],
                    Boolean.parseBoolean(readLine[2]),
                    Integer.parseInt(readLine[3]),
                    Integer.parseInt(readLine[4]));
            InformationDatabase.monthlyBase.add(monthlyReport);
        }
    }

    // Обрабатываем информацию с файлов (годовой отчёт)
    //*прописан частный случай, для массового отчёта необходимо добавить обходчик файлов по заданию
    void readAndWriteFileContentYear(){
        ArrayList<String> stringYearBase = new ArrayList<>();
        String content = readFileContentsOrNull("y.2021");
            if (content != null) {
                String[] lines = content.split("\\n");
                stringYearBase.addAll(Arrays.asList(lines).subList(1, lines.length));
            }
        writeYearBases(stringYearBase);
    }

    //передаём месячные данные в InformationDatabase
    void writeYearBases(ArrayList<String> stringYearBase) {
        for (String s : stringYearBase) {
            String[] readLine = s.split(",");
            Yearly yearlyReport = new Yearly(
                    2021,
                    Integer.parseInt(readLine[0]),
                    Integer.parseInt(readLine[1]),
                    Boolean.parseBoolean(readLine[2]));
            InformationDatabase.yearlyBase.add(yearlyReport);
        }
    }

    //считываем файл CSV и передаем его данные в readAndWriteFileContentMonth или readAndWriteFileContentYear
    String readFileContentsOrNull(String path) {
        Path filePath = Paths.get("resources/", path + ".csv");
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}
