package com.ghostben.forcesolve.quickSort;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic
 * @description: 列出文件夹里所有的文件
 * @author: ghostben
 * @create: 2018-11-18 00:22
 **/
public class ListAllFile {
    public static void main(String[] args) {
        listAllFile(new File("D:\\Anaconda\\etc"));
        System.out.println(listAllFile(new File("D:\\Anaconda\\etc"), new ArrayList<>()).size());
    }

    public static void listAllFile(File file){
        File [] files = file.listFiles();  //列出所有文件，包括文件夹
        assert files != null;
        for(File file1 : files){
            if(file1.isFile()){
                System.out.println(file1);
            }else {
                listAllFile(file1);
            }
        }
    }

    public static List listAllFile(File file, List<File> list){
        File [] files = file.listFiles();  //列出所有文件，包括文件夹
        assert files != null;
        for(File file1 : files){
            if(file1.isFile()){
                list.add(file1);
            }else {
                listAllFile(file1);
            }
        }
        return list;
    }
}