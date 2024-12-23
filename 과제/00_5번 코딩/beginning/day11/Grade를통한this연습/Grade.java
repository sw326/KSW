class Grade {
	String[] subjects;
	int scores[];
	
	Grade(String[] subjects){
		this.subjects = subjects;
		scores = new int[subjects.length];
	}
	void init(){
		//1. input���� 
		In in = new In(this); //����
		for(int i=0; i<subjects.length; i++){
			in.input(i);
		}

		//2. �Ǵܷ���
		Calcul cc = new Calcul();
		cc.setCalcul(this); //����
		cc.cal();

		//3. �������� ���
		cc.showResult();
	}
	public static void main(String[] subjects) {
		if(subjects.length ==0){
			System.out.println("���� Grade ����1 ����2 ..");
			return;
		}

		Grade g = new Grade(subjects);
		g.init();
	}
}
