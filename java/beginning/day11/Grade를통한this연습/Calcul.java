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
		P.pln("����: " + total);
		avg = total/g.scores.length;
		P.pln("���: " + avg);
	}
	void showResult(){
		Shower s = new Shower();
		s.showGrade(this); //����
	}
}
