package ru.tanz.lab7;

import ru.tanz.lab7.scheme.RussianScheme;
import ru.tanz.lab7.scheme.Schematic;
import ru.tanz.lab7.scheme.Scheme;

import java.util.LinkedHashMap;
import java.util.Map;

public class MorseCode implements Codable{
    Map<String, String> scheme;

    public MorseCode(Scheme scheme) {
        this.scheme = new LinkedHashMap<>();
        this.addScheme(scheme.getScheme());

    }

    @Override
    public String encode(String text) {
        boolean endWord = false;

        StringBuilder encodeText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            String sign = String.valueOf(text.charAt(i));
            String signal = this.getSignalBySymbol(sign.toUpperCase());
            if (endWord) {
                encodeText.append(" ");
                endWord = false;
            }   
            if (signal != null) {
                encodeText.append(signal).append(" ");
            }

            if (sign.equals(" ")) {
                endWord = true;
            }
        }

        return encodeText.toString().trim();
    }

    @Override
    public String decode(String text) {

        StringBuilder decodeCode = new StringBuilder();

        for (String signal : text.split(" ")) {
            String sign = this.getSymbolBySignal(signal);

            if (sign != null) {
                decodeCode.append(sign);
            } else if (signal.isEmpty()) {
                decodeCode.append(" ");
            }
        }

        return decodeCode.toString().replaceAll("\s+", " ");
    }
    private String getSymbolBySignal(String signal) {

        if (!scheme.containsValue(signal)) return " ";
        for (Map.Entry<String, String> entry : scheme.entrySet()) {
            if (entry.getValue().equals(signal)){
                return entry.getKey();
            }
        }
        return null;
    }
    private String getSignalBySymbol(String symbol) {

        if (!scheme.containsKey(symbol)) return " ";
        for (Map.Entry<String, String> entry : scheme.entrySet()) {
            if (entry.getKey().equals(symbol.toUpperCase())){
                return entry.getValue();
            }
        }

        return null;
    }
    private void addScheme(Schematic scheme) {
        this.scheme.putAll(scheme.getScheme());
    }
}
