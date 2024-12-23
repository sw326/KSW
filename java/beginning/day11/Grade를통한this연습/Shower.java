class Shower 
{
	String grade = "F";
	void showGrade(Calcul cc){
		switch(cc.avg/10){
			case 10: 
			case  9: grade = "A"; break;
			case  8: grade = "B"; break;
			case  7: grade = "C"; break; 
			case  6: grade = "D";  
		}
		P.pln("ÇÐÁ¡: " + grade);
	}
}
