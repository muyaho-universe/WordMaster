package com.dale;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    ArrayList<WordModel> list;
    Scanner scanner;

    final private String FILENAME = "Dictionary.txt";

    public WordCRUD(Scanner scanner) {
        list = new ArrayList<>();
        this.scanner = scanner;
    }

    @Override
    public Object add() {
        System.out.print("\n=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = scanner.nextInt();
        String word = scanner.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = scanner.nextLine();
        // typed by user
        return new WordModel(0, level, word, meaning);
    }

    public void addWord() {
        WordModel wordModel = (WordModel) add();
        list.add(wordModel);
        System.out.println("\n새 단어가 단어장에 추가되었습니다 !!!");
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

    public void listAll() {
        System.out.println("--------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------");
    }

    public void updateItem() {
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = scanner.next();
        ArrayList<Integer> idList = this.listAll(keyword);

        System.out.print("=> 수정할 번호 선택 : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("=> 뜻 입력 : ");
        String meaning = scanner.nextLine();
        WordModel wordModel = list.get(idList.get(id - 1));
        wordModel.setMeaning((meaning));
        System.out.println("단어가 수정되었습니다.");
    }

    public ArrayList<Integer> listAll(String keyword) {
        ArrayList<Integer> idList = new ArrayList<>();
        int j = 0;

        System.out.println("--------------------------------");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWord().contains(keyword)) {
                j++;
                System.out.print((j) + " ");
                System.out.println(list.get(i).toString());
                idList.add(i);
            }
        }
        System.out.println("--------------------------------");
        return idList;
    }

    public void deleteItem() {
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword = scanner.next();
        ArrayList<Integer> idList = this.listAll(keyword);

        System.out.print("=> 삭제할 번호 선택 : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("=> 정말로 삭제하실래요? (Y/n) ");

        String answer = scanner.next();
        if (answer.equalsIgnoreCase("y")) {
            list.remove((int) idList.get(id - 1));
            System.out.println("단어가 삭제되었습니다.");
        } else {
            System.out.println("취소되었습니다.");
        }


    }

    public void search() {
        System.out.print("=> 검색할 단어 검색 : ");
        String keyword = scanner.next();
        ArrayList<Integer> idList = this.listAll(keyword);
        int j = 0;

        System.out.println("--------------------------------");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWord().contains(keyword)) {
                j++;
                System.out.print((j) + " ");
                System.out.println(list.get(i).toString());
                idList.add(i);
            }
        }
        System.out.println("--------------------------------");
    }

    public void loadFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME));
            String line;
            int count = 0;

            while (true){
                line = bufferedReader.readLine();
                if(line == null) break;
                String[] data = line.split("\\|");

                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                WordModel wordModel = new WordModel(0, level, word, meaning);
                list.add(wordModel);
                count++;
            }
            bufferedReader.close();
            System.out.println("==> " + count + "개 로딩 완료!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile() {
    }
}
