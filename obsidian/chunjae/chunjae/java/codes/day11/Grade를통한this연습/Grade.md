```java
class Grade {
    String[] subjects;
    int scores[];
    
    Grade(String[] subjects){
        this.subjects = subjects;
        scores = new int[subjects.length];
    }
    void init(){
        //1. input로직 
        In in = new In(this); //전달
        for(int i=0; i<subjects.length; i++){
            in.input(i);
        }

        //2. 판단로직
        Calcul cc = new Calcul();
        cc.setCalcul(this); //전달
        cc.cal();

        //3. 학점계산과 출력
        cc.showResult();
    }
    public static void main(String[] subjects) {
        if(subjects.length ==0){
            System.out.println("사용법 Grade 과목1 과목2 ..");
            return;
        }

        Grade g = new Grade(subjects);
        g.init();
    }
} 