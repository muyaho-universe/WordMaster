package com.dale;

public class WordModel {
    private int number;
    private int level;

    private String word;
    private String meaning;

    public WordModel(int number, int level, String word, String meaning) {
        this.number = number;
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
