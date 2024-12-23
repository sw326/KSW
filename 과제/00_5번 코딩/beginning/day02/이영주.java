class Moving
{
	int speed = 10;
	Moving(int speed){
		this.speed=speed;
	}
	void move(){
		System.out.println(this.speed+"의 속도로 이동했습니다.");
	}
}

class Gun
{
	int max_ammo = 100;
	int ammo;
	Gun(int max_ammo){
		this.max_ammo = max_ammo;
	}
	void shoot(){
		System.out.println("발사하였습니다.");
		ammo-=1;
		System.out.println("현재 탄창 " + ammo + " / " + max_ammo);
	}
	void reload(){
		System.out.println("재장전하였습니다.");
		ammo = max_ammo;
		System.out.println("현재 탄창 " + ammo + " / " + max_ammo);
	}
}

class character
{
	String name = "홍길동";
	Moving moving;
	Gun gun;

	character(){
		moving = new Moving(15);
		gun = new Gun(20);
	}
	character(String name, int speed, int max_ammo){
		this.name =name;
		moving = new Moving(speed);
		gun = new Gun(max_ammo);
	}
}


class Player
{
	public static void main(String[] args) 
	{
		character chara = new character("chara", 15, 20);

		System.out.println(chara.name + "이 ");
		chara.moving.move();
		System.out.println(chara.name + "이 ");
		chara.gun.shoot();
		System.out.println(chara.name +"이 ");
		chara.gun.reload();
	}
}
