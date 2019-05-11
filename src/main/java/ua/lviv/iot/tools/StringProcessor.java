package ua.lviv.iot.tools;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private String text;

    private String processedText = "";

    public StringProcessor() { }

    public StringProcessor(final String text) {
        this.text = text;
    }

    public final String getText() {
        return text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    public final void processText() {
        Pattern pattern = Pattern.compile("\\s+");
        String[] words = pattern.split(text);
        for (String word: words) {
            Pattern patternforwords = Pattern.compile("(bus#)\\d{1,3}", Pattern.CASE_INSENSITIVE);
            Matcher matcher = patternforwords.matcher(word);
            if (matcher.find()) {
                processedText = processedText.concat(word.replaceAll("\\b\\d{1,3}\\b", "BUS_UNKNOWN") + " ");
            }
            else {
                processedText = processedText.concat(word) + " ";

            }
        }
        text = processedText;
    }

    public final String showResults() {
            return this.text;
    }

    public static String readInputText() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }

    public static void main(final String[] args) {
        StringProcessor sp = new StringProcessor();
        sp.setText(readInputText());
        sp.processText();
        System.out.println("Processed text:");
        System.out.println(sp.showResults());
    }

}
