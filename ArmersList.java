package ArmerShop;

import java.util.ArrayList;

public class ArmersList {
    ArrayList<ArrayList<Integer>> arli = new ArrayList<>();
    UserArmerNames names1=new UserArmerNames();  // 이름 객체 설정

    public void Arraysize(int rowN,int columnN) { // 2차원 배열 초기 사이즈 설정하고 0으로 입력해 주는 메소드
        for (int i = 0; i < rowN; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < columnN; j++) {
                if (j == 0) {
                    row.add(i);
                } else {
                    row.add(0);
                }
            }
            arli.add(row);
        }
    }
    public void ListOut(int startN){
        System.out.println("순번   무기종류  소분류  기본가격      보정판매가  힘    민첩     내구도   재고   구입날짜   --");
        for (int i=startN; i<=arli.size()-1; i++) {
            if(GetValue(i,3)!=0){
                for (int j=0; j<=arli.get(i).size()-1; j++) {
                    int value=arli.get(i).get(j);
                    System.out.print(value+ "       ");
                }
                System.out.println();
            }
        }
    }
    public void ArrayChange(int rowToChange,int columnToChange,float newValue){
        arli.get(rowToChange).set(columnToChange, (int) newValue);
    }
    public void AddColumn(){
        for(int i=0; i<arli.size(); i++){
            arli.get(i).add(0);
        }
    }
    public void ArrayDelColumn(int delcomnum){
        for(int i=0; i<arli.size(); i++){
            arli.get(i).remove(delcomnum);
        }
    }
    public int GetValue(int rown, int coln){
        int value;
        value=arli.get(rown).get(coln);
        return value;
    }
    public int HowmanyColumn(){
        int value;
        value=arli.get(0).size();
        return value;
    }
    public int HowmanyRow(){
        int value;
        value=arli.size();
        return value;
    }
    public void ArmerListSet(){
        for(int i=0; i<HowmanyRow(); i++){
            ArrayChange(i,0,i); //순번순서 입력
        }
    }
    public void ArmerValueIn(){
        ArrayChange(1,3,5000);	ArrayChange(1,4,0);	ArrayChange(1,5,40);	ArrayChange(1,6,20);	ArrayChange(1,7,100);	ArrayChange(1,8,1);	ArrayChange(1,9,0);
        ArrayChange(2,3,6000);	ArrayChange(2,4,0);	ArrayChange(2,5,45);	ArrayChange(2,6,25);	ArrayChange(2,7,100);	ArrayChange(2,8,1);	ArrayChange(2,9,0);
        ArrayChange(3,3,7000);	ArrayChange(3,4,0);	ArrayChange(3,5,50);	ArrayChange(3,6,30);	ArrayChange(3,7,100);	ArrayChange(3,8,1);	ArrayChange(3,9,0);
        ArrayChange(4,3,8000);	ArrayChange(4,4,0);	ArrayChange(4,5,55);	ArrayChange(4,6,35);	ArrayChange(4,7,100);	ArrayChange(4,8,1);	ArrayChange(4,9,0);
        ArrayChange(5,3,9000);	ArrayChange(5,4,0);	ArrayChange(5,5,60);	ArrayChange(5,6,40);	ArrayChange(5,7,100);	ArrayChange(5,8,1);	ArrayChange(5,9,0);
        ArrayChange(6,3,10000);	ArrayChange(6,4,0);	ArrayChange(6,5,65);	ArrayChange(6,6,45);	ArrayChange(6,7,100);	ArrayChange(6,8,1);	ArrayChange(6,9,0);
        ArrayChange(11,3,8000);	ArrayChange(11,4,0);	ArrayChange(11,5,30);	ArrayChange(11,6,35);	ArrayChange(11,7,100);	ArrayChange(11,8,1);	ArrayChange(11,9,0);
        ArrayChange(12,3,9000);	ArrayChange(12,4,0);	ArrayChange(12,5,35);	ArrayChange(12,6,40);	ArrayChange(12,7,100);	ArrayChange(12,8,1);	ArrayChange(12,9,0);
        ArrayChange(13,3,10000);	ArrayChange(13,4,0);	ArrayChange(13,5,40);	ArrayChange(13,6,45);	ArrayChange(13,7,100);	ArrayChange(13,8,1);	ArrayChange(13,9,0);
        ArrayChange(14,3,11000);	ArrayChange(14,4,0);	ArrayChange(14,5,45);	ArrayChange(14,6,50);	ArrayChange(14,7,100);	ArrayChange(14,8,1);	ArrayChange(14,9,0);
        ArrayChange(15,3,12000);	ArrayChange(15,4,0);	ArrayChange(15,5,50);	ArrayChange(15,6,55);	ArrayChange(15,7,100);	ArrayChange(15,8,1);	ArrayChange(15,9,0);
        ArrayChange(16,3,13000);	ArrayChange(16,4,0);	ArrayChange(16,5,55);	ArrayChange(16,6,60);	ArrayChange(16,7,100);	ArrayChange(16,8,1);	ArrayChange(16,9,0);
        ArrayChange(21,3,6500);	ArrayChange(21,4,0);	ArrayChange(21,5,10);	ArrayChange(21,6,40);	ArrayChange(21,7,100);	ArrayChange(21,8,1);	ArrayChange(21,9,0);
        ArrayChange(22,3,7500);	ArrayChange(22,4,0);	ArrayChange(22,5,15);	ArrayChange(22,6,45);	ArrayChange(22,7,100);	ArrayChange(22,8,1);	ArrayChange(22,9,0);
        ArrayChange(23,3,8500);	ArrayChange(23,4,0);	ArrayChange(23,5,20);	ArrayChange(23,6,50);	ArrayChange(23,7,100);	ArrayChange(23,8,1);	ArrayChange(23,9,0);
        ArrayChange(24,3,9500);	ArrayChange(24,4,0);	ArrayChange(24,5,25);	ArrayChange(24,6,55);	ArrayChange(24,7,100);	ArrayChange(24,8,1);	ArrayChange(24,9,0);
        ArrayChange(25,3,10500);	ArrayChange(25,4,0);	ArrayChange(25,5,30);	ArrayChange(25,6,60);	ArrayChange(25,7,100);	ArrayChange(25,8,1);	ArrayChange(25,9,0);
        ArrayChange(26,3,11500);	ArrayChange(26,4,0);	ArrayChange(26,5,35);	ArrayChange(26,6,65);	ArrayChange(26,7,100);	ArrayChange(26,8,1);	ArrayChange(26,9,0);

    }
    public void AddRow(int story1) { // 2차원 배열 초기 사이즈 설정하고 0으로 입력해 주는 메소드
        ArrayList<Integer> row = new ArrayList<>();
        int i= arli.get(0).size();
        int r=arli.size();
        for (int j = 0; j < i; j++) {
            if (j == 0) {
                row.add(story1);
            } else {
                row.add(0);
            }
        }
        arli.add(row);
    }
}
