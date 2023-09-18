package ru.tanz.lab7.scheme;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RussianScheme implements Schematic{
    private static final Map<String, String> SCHEME = new LinkedHashMap<>();
    static {
        SCHEME.put("А", ".-");
        SCHEME.put("Б", "-...");
        SCHEME.put("В", ".--");
        SCHEME.put("Г", "--.");
        SCHEME.put("Д", "-..");
        SCHEME.put("Е", ".");
        SCHEME.put("Ё", ".");
        SCHEME.put("Ж", "...-");
        SCHEME.put("З", "--..");
        SCHEME.put("И", "..");
        SCHEME.put("Й", ".---");
        SCHEME.put("К", "-.-");
        SCHEME.put("Л", ".-..");
        SCHEME.put("М", "--");
        SCHEME.put("Н", "-.");
        SCHEME.put("О", "---");
        SCHEME.put("П", ".--.");
        SCHEME.put("Р", ".-.");
        SCHEME.put("С", "...");
        SCHEME.put("Т", "-");
        SCHEME.put("У", "..-");
        SCHEME.put("Ф", "..-.");
        SCHEME.put("Х", "....");
        SCHEME.put("Ц", "-.-.");
        SCHEME.put("Ч", "---.");
        SCHEME.put("Ш", "----");
        SCHEME.put("Щ", "--.-");
        SCHEME.put("Ъ", ".--.-.");
        SCHEME.put("Ы", "-.--");
        SCHEME.put("Ь", "-..-");
        SCHEME.put("Э", "..-..");
        SCHEME.put("Ю", "..--");
        SCHEME.put("Я", ".-.-");
        SCHEME.put("!", "-.-.--");
        SCHEME.put(",", "--..--");
        SCHEME.put(".", ".-.-.-");
    }
    public RussianScheme() {
        super();
    }

    @Override
    public Map<String, String> getScheme() {
        return SCHEME;
    }
}
