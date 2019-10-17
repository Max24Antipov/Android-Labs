package com.example.myapplication2stroki;

public class Phaser {
  public static String PhaserGen () {

     String [] wordListOne = new String[]{"круглосуточный", "взаимный", "умный", "фронтэнд", "динамичный"};
     String [] wordListTwo = new String[]{"уполномоченный", "трудный", "центральный", "фирменный", "сетевой"};
     String [] wordListThree = new String[]{"процесс", "образец", "портал", "пункт следования", "подход"};


     int OneLength = wordListOne.length;
     int Twolength = wordListTwo.length;
     int Threelength= wordListThree.length;

      int r1= (int) (Math.random()*OneLength);
      int r2= (int) (Math.random()*Twolength);
      int r3= (int) (Math.random()*Threelength);

     String phrase = wordListOne[r1]+" "+ wordListTwo[r2]+ " " + wordListThree[r3];



   

      return phrase;
  }

}
