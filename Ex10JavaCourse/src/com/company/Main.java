package com.company;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ReadFile();
        WriteFile();
        ConcatFiles();
        CopyFile();
        FindFile();
        FindInFiles();
    }

    public static void ReadFile()  {
        String fileName = "src/Files/file1.txt";
        File file = new File(fileName);
        try (Scanner in = new Scanner(file)){
            while(in.hasNext()){
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл не найден");
        }
    }
    public static void WriteFile(){
        String fileName = "src/Files/file2.txt";
        String write = " World!";
        try(FileWriter writer = new FileWriter(fileName, false)){
            writer.write(write);
            System.out.println("Файл записан");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Запись не удалась");
        }
    }

    public static void ConcatFiles(){
        File file1 = new File("src/Files/file1.txt");
        File file2 = new File("src/Files/file2.txt");
        File file3 = new File("src/Files/file3.txt");
        StringBuilder rec = new StringBuilder();
        try(Scanner in1 = new Scanner(file1);
            Scanner in2 = new Scanner(file2)){
            while(in1.hasNext()){
                rec.append(in1.nextLine()).append("\n");
            }
            while(in2.hasNext()){
                rec.append(in2.nextLine()).append("\n");
            }
            try(FileWriter writer= new FileWriter(file3, false)){
                writer.write(rec.toString());
                System.out.println("Файлы склеены");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Не удалось склеить файлы");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Не удалось найти файлы");
        }
    }
    public static void CopyFile(){
        File source = new File("src/Files/fileSource.txt");
        File dest = new File("src/Files/fileCopyOfSource.txt");
        try{
            FileChannel from = new FileInputStream(source).getChannel();
            FileChannel to = new FileOutputStream(dest).getChannel();
            to.transferFrom(from,0,from.size());
            System.out.println("Копирование произошло успешно");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл не удалось найти ");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Копирование не удалось");
        }
    }

    public static void FindFile(){
        String dir = "src/Files";
        String nameToFind = "file1.txt";
        File directory = new File(dir);
        String[] listToSearch = directory.list();
        assert listToSearch != null;
        for(String file : listToSearch){
            if(nameToFind.equals(file)){
                System.out.println("Найден файл: " + file+ "путь: "+dir);
            }
        }
    }

    public static void FindInFiles(){
        String dir = "src/Files";
        String textToFind = "Hello";
        File directory = new File(dir);
        File[] listOfFiles = directory.listFiles();
        assert listOfFiles != null;
        for(File file : listOfFiles){
            try(Scanner in = new Scanner(new File(String.valueOf(file)))){
                List<String> lines = new ArrayList<>();
                while(in.hasNextLine()){
                    lines.add(in.nextLine());
                }
                for(String s : lines){
                    if(s.equals(textToFind)){
                        System.out.println("Строка "+ textToFind+" найдена в файле " + file);
                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Не удалось найти файл");
            }
        }
    }
}
