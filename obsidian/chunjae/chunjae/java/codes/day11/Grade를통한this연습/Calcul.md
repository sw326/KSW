```java
class Calcul 
{
    int total = 0;
    int avg = 0;
    Grade g;
    void setCalcul(Grade g){
        this.g = g;
    }
    void cal(){
        for(int score: g.scores){
            total += score;
        }
        P.pln("총점: " + total);
        avg = total/g.scores.length;
        P.pln("평균: " + avg);
    }
    void showResult(){
        Shower s = new Shower();
        s.showGrade(this); //전달
    }
}