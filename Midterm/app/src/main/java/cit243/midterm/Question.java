package cit243.midterm;

public class Question {
    private String q;
    private int num;
    private boolean ans;

    public Question(String q, int num, boolean ans){
        this.q = num + q;
        this.ans = ans;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
