package com.dale;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    ArrayList<WordModel> list;
    Scanner scanner;

    public WordCRUD(Scanner scanner) {
        list = new ArrayList<>();
        this.scanner = scanner;
    }

    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = scanner.nextInt();
        String word = scanner.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = scanner.nextLine();
        // typed by user
        return new WordModel(0, level, word, meaning);
    }

    public void addWord(){
        WordModel wordModel = (WordModel) add();
        list.add(wordModel);
        System.out.println("새 단어가 단어장에 추가되었습니다 !!!");
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void select(Object obj) {

    }

    public void listAll(){
        System.out.println("--------------------------------");
        for (int i = 0; i < list.size(); i++){
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------");
    }
}
