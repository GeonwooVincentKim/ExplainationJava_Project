package Feature.FileManager;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager {
    private File file;
    private Scanner readFile;
    private FileWriter writeFile;

    public FileManager(File file, Scanner readFile, FileWriter writeFile) {
        this.setFile(file);
        this.setReadFile(readFile);
        this.setWriteFile(writeFile);
    }

    public FileWriter getWriteFile() {
        return writeFile;
    }

    public void setWriteFile(FileWriter writeFile) {
        this.writeFile = writeFile;
    }

    public Scanner getReadFile() {
        return readFile;
    }

    public void setReadFile(Scanner readFile) {
        this.readFile = readFile;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    // 파일 읽어오는 함수
    // 누가, 언제, 어디서, 무엇을, 어떻게, 왜
    // fileReader 가
    // Q1.java 의 q1_main 으로부터
    // fileName 을
    // fileReader의 인자값으로 넘겨 받아서
    // file 을 불러들인다.

    public Scanner fileReader(String fileName) {
        Scanner fileReader = null;
        File file = new File(fileName);

        try {
            fileReader = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileReader;
    }

    // 파일을 쓰는 함수
    // fileWriter 가
    // Q1.java 의
    // q1_main 으로부터
    // fileName 과 결과 값인 result 를
    // 각각 fileWriter 의 인자 값으로 넘겨 받아서
    // file 을 쓴다.

    public void fileWriter(String fileName, String result) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(result);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
