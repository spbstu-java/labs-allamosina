package Lab03;

import java.io.File;

public class Main {
    static final File INIT = new File("./src/Lab03/dictEngRu.txt");
    static final File TASK = new File("./src/Lab03/translate.txt");

    public static void main(String[] args) {
        Translator fromEnToRu = new Translator(INIT);
        StringBuilder translatedText = fromEnToRu.translateFile(TASK);
        System.out.println(translatedText);
    }
}
