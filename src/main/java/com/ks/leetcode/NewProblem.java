package com.ks.leetcode;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class NewProblem {

    public static void main(String[] args) {
        String s = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b";
        NewProblem n = new NewProblem();
        n.solution(s);
    }

    public String solution(String S) {
        // write your code in Java SE 8

        String[] lines = S.split("\\R+");
        Map<String, Integer> map = new HashMap<>();
        for (String line :
                lines) {
            //System.out.println("-->" + line);

            String[] fields = line.split(" ");

            Map.Entry<String, Integer> entry = splitName(fields[0], fields[1], map);


        }
        return "ChangeMe";
    }

    private Map.Entry<String, Integer> splitName(String name, String size, Map<String, Integer> map) {

        String[] secions = name.split(".");
        String ext = secions[secions.length - 1];

        Integer s = Integer.valueOf(size.split("b")[0]);

        if (ext.equals("mp3") || ext.equals("aac") || ext.equals("flac")) {

            return new AbstractMap.SimpleEntry<>("music", s);
        } else if (ext.equals("jpg") || ext.equals("bmp") || ext.equals("gif")) {
            return new AbstractMap.SimpleEntry<>("image", s);
        } else if (ext.equals("mp4") || ext.equals("avi") || ext.equals("mkv")) {
            return new AbstractMap.SimpleEntry<>("movie", s);
        } else if (ext.equals("7z") || ext.equals("txt") || ext.equals("zip")) {
            return new AbstractMap.SimpleEntry<>("other", s);
        } else return null;
    }
}
