package ArmerShop;

import java.util.ArrayList;

public class ArmersList {
    ArrayList<ArrayList<Integer>> arli = new ArrayList<>();

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
        System.out.println("순번   무기종류  소분류  기본가격  보정판매가  힘    민첩     내구도   재고   구입날짜   --");
        for (int i=startN; i<=arli.size()-1; i++) {
            for (int j=0; j<=arli.get(i).size()-1; j++) {
                int value=arli.get(i).get(j);
                System.out.print(value+ "       ");
            }
            System.out.println();
        }
    }
    public void ArrayChange(int rowToChange,int columnToChange,int newValue){
        arli.get(rowToChange).set(columnToChange, newValue);
    }
    public void MenuAddColumn(){
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
}
