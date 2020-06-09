package com.example.wplusapp;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private final static Singleton instance = new Singleton();
    private Singleton(){
        cardDataList = new ArrayList<>();
        cardDataList.add(new CardData("Android","O.S.", R.drawable.android));
        cardDataList.add(new CardData("iOS","O.S.",R.drawable.ios));
        cardDataList.add(new CardData("Java","Programing Language",R.drawable.java));
        cardDataList.add(new CardData("Android","O.S.",R.drawable.android));
        cardDataList.add(new CardData("iOS","O.S.",R.drawable.ios));
        cardDataList.add(new CardData("Java","Programing Language",R.drawable.java));
        cardDataList.add(new CardData("Android","O.S.",R.drawable.android));
        cardDataList.add(new CardData("iOS","O.S.",R.drawable.ios));
        cardDataList.add(new CardData("Java","Programing Language",R.drawable.java));

    }
    public static Singleton getInstance(){
        return instance;
    }
    public List<CardData> cardDataList;
}