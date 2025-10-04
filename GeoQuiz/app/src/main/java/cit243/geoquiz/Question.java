package cit243.geoquiz;

public class Question {
    String q;
    int num;
    boolean answer;

    public Question(){
        q = "Question";
        num = 1;
        answer = true;

    }
    public Question(String q, int num, boolean ans){
        this.q = q;
        this.num = num;
        this.answer = ans;
    }
}
