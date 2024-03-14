package ArmerShop;

import java.util.ArrayList;

public class PurchaseStory {
    ArrayList<ArrayList<Float>> pstory = new ArrayList<>();

    public void Arraysize(int rowN,int columnN) { // 2차원 배열 초기 사이즈 설정하고 0으로 입력해 주는 메소드
        for (float i = 0; i < rowN; i++) {
            ArrayList<Float> row = new ArrayList<>();
            for (int j = 0; j < columnN; j++) {
                if (j == 0) {
                    row.add(i);
                } else {
                    row.add(0.0f);
                }
            }
            pstory.add(row);
        }
    }
    public void ListOut(int startN){
        System.out.println("순번  day   플레이어  무기번호  무기가격");
        for (int i=startN; i<=pstory.size()-1; i++) {
            for (int j=0; j<=pstory.get(i).size()-1; j++) {
                float value=pstory.get(i).get(j);
                System.out.print(value+ "     ");
            }
            System.out.println();
        }
    }
    public void ArrayChange(int rowToChange,int columnToChange,float newValue){
        pstory.get(rowToChange).set(columnToChange, newValue);
    }
    public void MenuAddColumn(){
        for(int i=0; i<pstory.size(); i++){
            pstory.get(i).add(0.0f);
        }
    }
    public void ArrayDelColumn(int delcomnum){
        for(int i=0; i<pstory.size(); i++){
            pstory.get(i).remove(delcomnum);
        }
    }
    public float GetValue(int rown, int coln){
        float value;
        value=pstory.get(rown).get(coln);
        return value;
    }
    public int HowmanyColumn(){
        int value;
        value=pstory.get(0).size();
        return value;
    }
    public int HowmanyRow(){
        int value;
        value=pstory.size();
        return value;
    }
}
