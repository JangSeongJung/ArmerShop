package ArmerShop;

import java.util.ArrayList;

public class PlayersList{
    ArrayList<ArrayList<Float>> plli = new ArrayList<>();

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
            plli.add(row);
        }
    }
    public void ListOut(int startN){
        System.out.println("순번 이름 공격력 방어도 숙련도 day시작금액 사용후금액   -    수리여부");
        for (int i=startN; i<=plli.size()-1; i++) {
            for (int j=0; j<=plli.get(i).size()-1; j++) {
                float value=plli.get(i).get(j);
                System.out.print(value+ "    ");
            }
            System.out.println();
        }
    }
    public void ArrayChange(int rowToChange,int columnToChange,float newValue){
        plli.get(rowToChange).set(columnToChange, newValue);
    }
    public void MenuAddColumn(){
        for(int i=0; i<plli.size(); i++){
            plli.get(i).add(0.0f);
        }
    }
    public void ArrayDelColumn(int delcomnum){
        for(int i=0; i<plli.size(); i++){
            plli.get(i).remove(delcomnum);
        }
    }
    public float GetValue(int rown, int coln){
        float value;
        value=plli.get(rown).get(coln);
        return value;
    }
    public int HowmanyColumn(){
        int value;
        value=plli.get(0).size();
        return value;
    }
    public int HowmanyRow(){
        int value;
        value=plli.size();
        return value;
    }
    public void PlayersList1stset(ArrayList<ArrayList<Integer>> plli) { // 메뉴 초기 셋팅
        ArrayChange(0, 2, 4000);
    }
}
