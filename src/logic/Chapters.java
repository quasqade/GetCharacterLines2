package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chapters {
    private Map<Chapter, List<Chapter>> map;

    public Chapters()
    {
        map = new HashMap<>();

        List<Chapter> buffer;

        //Chapter 1
        buffer = new ArrayList<>();
        buffer.add(Chapter.CHAPTER1_EL);
        buffer.add(Chapter.CHAPTER1_NL);
        buffer.add(Chapter.CHAPTER1_TRIAL);
        map.put(Chapter.CHAPTER1, buffer);

        //Chapter 2
        buffer = new ArrayList<>();
        buffer.add(Chapter.CHAPTER2_EL);
        buffer.add(Chapter.CHAPTER2_NL);
        buffer.add(Chapter.CHAPTER2_TRIAL);
        map.put(Chapter.CHAPTER2, buffer);

        //Chapter 3
        buffer = new ArrayList<>();
        buffer.add(Chapter.CHAPTER3_EL);
        buffer.add(Chapter.CHAPTER3_NL);
        buffer.add(Chapter.CHAPTER3_TRIAL);
        map.put(Chapter.CHAPTER3, buffer);

        //Chapter 4
        buffer = new ArrayList<>();
        buffer.add(Chapter.CHAPTER4_EL);
        buffer.add(Chapter.CHAPTER4_NL);
        buffer.add(Chapter.CHAPTER4_TRIAL);
        map.put(Chapter.CHAPTER4, buffer);

        //Chapter 5
        buffer = new ArrayList<>();
        buffer.add(Chapter.CHAPTER5_EL);
        buffer.add(Chapter.CHAPTER5_NL);
        buffer.add(Chapter.CHAPTER5_TRIAL);
        map.put(Chapter.CHAPTER5, buffer);

        //Chapter 6
        buffer = new ArrayList<>();
        buffer.add(Chapter.CHAPTER6_EL);
        buffer.add(Chapter.CHAPTER6_NL);
        buffer.add(Chapter.CHAPTER6_TRIAL);
        map.put(Chapter.CHAPTER6, buffer);

        //Main Script
        buffer = new ArrayList<>();
        buffer.add(Chapter.PROLOGUE);
        buffer.add(Chapter.CHAPTER1);
        buffer.add(Chapter.CHAPTER2);
        buffer.add(Chapter.CHAPTER3);
        buffer.add(Chapter.CHAPTER4);
        buffer.add(Chapter.CHAPTER5);
        buffer.add(Chapter.CHAPTER6);
        buffer.add(Chapter.EPILOGUE);
        map.put(Chapter.MAIN_SCRIPT, buffer);

        //All
        buffer = new ArrayList<>();
        buffer.add(Chapter.MAIN_SCRIPT);
        buffer.add(Chapter.FTE);
        buffer.add(Chapter.UNKNOWN);
        map.put(Chapter.ALL, buffer);
    }

    public List<Chapter> get(Chapter chapter)
    {
        if (map.containsKey(chapter))
        return map.get(chapter);
        return null;
    }

    public boolean containsSubchapters(Chapter chapter)
    {
        return map.containsKey(chapter);
    }
}
