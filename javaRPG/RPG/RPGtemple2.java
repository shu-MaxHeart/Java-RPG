package RPG;
import RPG.*;
//Ver1.05

public class plse {
  public static void main(String[] args) {
		Hero[] p = new Hero[4];
		int[] win_count = {0,0,0,0};
		int battle_count = -1;
		//do{
			int all_spd = 0;
			
			/*
			for(int i = 0;i * 3 <args.length;i++){
				if(args[i*3+1].equals("剣士"))
					p[i] = new SWordfighter(args[i*3],Integer.parseInt(args[i*3+2]));
				else if(args[i*3+1].equals("戦士"))
					p[i] =      new WArrior(args[i*3],Integer.parseInt(args[i*3+2]));
				else if(args[i*3+1].equals("魔術師"))
					p[i] =       new WIzard(args[i*3],Integer.parseInt(args[i*3+2]));
				else if(args[i*3+1].equals("勇者"))
					p[i] =         new Hero(args[i*3],Integer.parseInt(args[i*3+2]));
				else
					p[i] =       new banana(args[i*3],Integer.parseInt(args[i*3+2]));
			}*/
			
			//剣士を定義
			p[0] = new SWordfighter("ラン",1);
      if(args.length > 0) p[0] = new SWordfighter("ラン",Integer.parseInt(args[0]));
			//戦士を定義
      p[1] = new WArrior("ミキ",1);
      if(args.length > 1) p[1] = new WArrior("ミキ",Integer.parseInt(args[1]));
			//魔術師を定義
      p[2] = new WIzard("スゥ",10);
      if(args.length > 2) p[2] = new WIzard("スゥ",Integer.parseInt(args[2]));
			//勇者を定義
			p[3] = new Hero("ダイヤ",1);
      if(args.length > 3) p[3] = new Hero("ダイヤ",Integer.parseInt(args[3]));
			//p[4] = new banana("オイラァ！",1);
      for(Hero h : p)
				h.steats();
			//剣士を定義
			//if(args.length > 0) p[0] = new SWordfighter(args[0],1);
      /*p[(int)(Math.random()*4)].heal(p[(int)(Math.random()*4)]);//回復
      p[(int)(Math.random()*4)].steats();
      p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//攻撃
      p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//攻撃
      p[(int)(Math.random()*4)].steats();
      for(int i=0;;i++){//p[(int)(Math.random()*4)].hp>0;i++){
				p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//攻撃
				p[2].heal(p[(int)(Math.random()*4)]);
				p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//攻撃
     		p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//攻撃
     	 	p[(int)(Math.random()*4)].attack_freim(p[(int)(Math.random()*4)]);//魔法攻撃
				p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//攻撃
      	p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//攻撃
				p[(int)(Math.random()*4)].attack_freim(p[(int)(Math.random()*4)]);//魔法攻撃
				p[(int)(Math.random()*4)].steats();
				p[(int)(Math.random()*4)].steats();
				p[(int)(Math.random()*4)].steats();
				
				if(i==50) break;
			}
			p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//回復
			for(int i=0;p[(int)(Math.random()*4)].hp<p[(int)(Math.random()*4)].hpmax;i++){
				//p[(int)(Math.random()*4)].heal(p[(int)(Math.random()*4)]);
				p[2].heal(p[(int)(Math.random()*4)]);
				p[(int)(Math.random()*4)].steats();
				if(i==50) break;
				if(p[(int)(Math.random()*4)].mp<6) break;
			}
      p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//回復
      p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//回復
      p[(int)(Math.random()*4)].attack(p[(int)(Math.random()*4)]);//回復
			*/
			for(int i = 1;;i++){
				int index = 0;//(int)(Math.random()*4);
				int index2 = 0;
				all_spd = 0;
				for(Hero h : p)
					all_spd += h.spd;
				int act = (int)(all_spd * Math.random());
				do{
					index = p.length - 1;
					for(int j = 0;j < p.length;j++){
						//System.out.println("行動値："+(p[j].spd)+" < "+(act));
						if(p[j].spd >= act){
							index = j;//(int)(Math.random()*4);
							break;
						}else
							act -= p[j].spd;
					}
					act = (int)(all_spd * Math.random());
				}while(!(p[index].checklive()));
				do{
					index2 = (int)(Math.random()*4);
				}while((index == index2)||!(p[index2].checklive()));
				int route = (int)(Math.random()*5);
				if((route > 3)&&(p[index].checklive())&&(p[index].job.equals("魔術師"))){
					//index = 2;
					do{
						index2 = (int)(Math.random()*4);
					}while((index == index2)||!(p[index2].checklive()));
					p[index].attack_freim(p[index2]);//魔法攻撃
				}else if((route > 2)&&(p[index].checklive())&&(p[index].job.equals("魔術師"))){
					//index = 2;
					/**do{
						index2 = (int)(Math.random()*4);
					}while((index == index2)||!(p[index2].checklive()));/**/
					//index2 = index;
					p[index].heal(p[index]);//回復
				}else
					p[index].attack(p[index2]);//攻撃
				if(battle_finish(p,0) < 2){
					battle_count += i;
					break;
				}
				if(i == 100) break;
				if((i % 10 == 0)&&(i != 0)){
					for(Hero h : p)
						h.steats();
				}
			}
			if(battle_count == -1)
				battle_count += 100;
      for(Hero h : p)
				h.steats();
			System.out.println("延べ行動回数："+(battle_count));
			System.out.print(  "勝者："+p[battle_finish(p,1)].name+" HP:"+((p[battle_finish(p,1)].hp*100)/p[battle_finish(p,1)].hpmax)+"%");
			if((p[battle_finish(p,1)].mpmax)>0)
				System.out.println(" MP:"+((p[battle_finish(p,1)].mp*100)/p[battle_finish(p,1)].mpmax)+"%");
			else
				System.out.println(" MP:0");
				/** /win_count[battle_finish(p,1)]++;for(int i=0;i<p.length;i++)
			System.out.println(p[i].name+"勝ち回数："+(win_count[i]));
		}while((win_count[2])<50);//battle_finish(p,1)/**/
		
  }
	static void battle(Hero[] p){
		
	}
	static int battle_finish(Hero[] p,int sw){
		int count = 0;
		switch(sw){
			case 0:
				for(Hero h : p)
					if((h.checklive()))
						count++;
				break;
			case 1:
				count = 0;//-1;
				for(int i = 0;i < p.length;i++)
					if((p[i].checklive()))/** /{
						if(count>-1)
							if(((p[count].hp*100)/p[count].hpmax) < ((p[i].hp*100)/p[i].hpmax)){
								count = i;
							}
						}else/**/
							count = i;
				break;
		}
		return count;
	}
}
public class Hero {
  String name;
  String job = "勇者";
	int Lv;
	int B_1;
	int B_2;
	int exp,expmax;
	int B_3;
	int B_4;
	
	int hp;
	int mp;
	int hpmax;
	int mpmax;
	int atk;
	int dfe;
	int mgk;
	int mdf;	
	int spd;
	
	int hit;
	int clt;
	int abs;
	
	int[] up = new int[7];
	
	boolean live = true;
	
	Hero(String n,int lv){
		this.Lv = 1;
		State_stream(job);
		this.name = n;
		while(this.Lv < lv) silent_exp();
	}
	void State_stream(String job){
		String[] str;
		ReaderFile FR = new ReaderFile(7);
		str = FR.Reader_File("job_csv2.csv",this.job);
		/*for(String x: str)
			System.out.println(x);*/
		B_1 = 10;
		B_2 = 0;
		exp=0;
		expmax=B_2+B_1;
		B_3 = 10;
		B_4 = 10;
		this.hpmax = Integer.parseInt(str[1]);
		this.mpmax = Integer.parseInt(str[2]);
		this.atk = Integer.parseInt(str[3]);
		this.dfe = Integer.parseInt(str[4]);
		this.mgk = Integer.parseInt(str[5]);
		this.mdf = Integer.parseInt(str[6]);
		this.spd = Integer.parseInt(str[7]);
		for(int i=0;i<up.length;i++)
			this.up[i] = Integer.parseInt(str[i+8]);
		maxline(1);
		this.hit = Integer.parseInt(str[8+up.length+0]);
		this.clt = Integer.parseInt(str[8+up.length+1]);
		this.abs = Integer.parseInt(str[8+up.length+2]);
	
	}
	void Lv_up(int sd){
			/*for(String x: str)
				System.out.println(x);*/

			int Lvb = this.Lv;
			int Lvco = this.Lv;
			double expmax = 0.0;
			do{
			this.Lv++;
			Lvco = this.Lv;
			
			this.hpmax += up[0];
			this.mpmax += up[1];
			this.hp += up[0];
			this.mp += up[1];
			this.atk += up[2];
			this.dfe += up[3];
			this.mgk += up[4];
			this.mdf += up[5];
			this.spd += up[6];
			
			this.hit++;
			this.clt++;
			this.abs++;
			//this.exp -= this.expmax;
			expmax = B_1*Math.pow(Lvco-1,0.9+B_3/250)*Lvco*(Lvco+1);
			expmax = expmax/(6+Math.pow(Lvco,2)/50/B_4);
			expmax = expmax+(Lvco-1)*B_2;
			this.expmax += (int)(Math.round(expmax));
			}while(this.exp>=this.expmax);
			Lvb = Lvco - Lvb;
			if(sd < 1){
				System.out.println("========LEVEL UP!====================");
				System.out.println(this.name+" はレベル "+(Lvco)+" になった！");
				System.out.println(this.name+" のレベルが "+(Lvb)+" 上がった！");
				if(up[2]>0)
					System.out.println(this.name+" の力が "+(up[2]*Lvb)+" 上がった！");
				if(up[3]>0)
					System.out.println(this.name+" の守りが "+(up[3]*Lvb)+" 上がった！");
				if(up[4]>0)
					System.out.println(this.name+" の魔力が "+(up[4]*Lvb)+" 上がった！");
				if(up[5]>0)
					System.out.println(this.name+" の賢さが "+(up[5]*Lvb)+" 上がった！");
				if(up[6]>0)
					System.out.println(this.name+" の素早さが "+(up[6]*Lvb)+" 上がった！");
				if(up[0]>0)
					System.out.println(this.name+" のHPが "+(up[0]*Lvb)+" 上がった！");
				if(up[1]>0)
					System.out.println(this.name+" のMPが "+(up[1]*Lvb)+" 上がった！");
				//System.out.println(this.name+" の力が "+(up[7]*Lvb)+" 上がった！");
				System.out.println("=====================================");
			}
	}
	void steats(){
		System.out.println("=====================================");
		System.out.println("= "+this.name+"のステータス");
		System.out.println("= "+"職業："+this.job);
		System.out.println("= "+"レベル："+this.Lv);
		System.out.println("= "+"経験値："+this.exp);
		System.out.println("= "+"必要な残り経験値："+(this.expmax-this.exp));
		System.out.println("= "+"HP："+this.hp+"/"+this.hpmax);
		System.out.println("= "+"MP："+this.mp+"/"+this.mpmax);
		System.out.println("= "+"力："+this.atk + " 守り："+ this.dfe );
		System.out.println("= "+"魔力："+this.mgk + " 賢さ："+ this.mdf );
		System.out.println("= "+"素早さ："+this.spd/* + " 賢さ："+ this.mdf */);
		if(!(this.checklive()))
			System.out.println("戦闘不能");
		//System.out.println("");
		//System.out.println("");
		System.out.println("=====================================");
		//System.out.println("");
	}
	void maxline(int m){
		switch(m){
			case 0:
				if(this.hp > this.hpmax)
					this.hp = this.hpmax;
				if(this.mp > this.mpmax)
					this.mp = this.mpmax;
				break;
			case 1:
				this.hp = this.hpmax;
				this.mp = this.mpmax;
				break;
			case 2:
				if(!(this.checklive()))
					System.out.println(this.name + "は戦闘不能だ");
				else if(this.hp <= 0){
					this.live = false;
					System.out.println(this.name + "は戦闘不能になった");
				}
				break;
		}
		
	}
	void heal(Hero h){}
	void right_heal(Hero h){ }
	void attack_freim(Hero h){ }
	
	void attack(Hero e) {
		System.out.println(this.name + " の "+" 攻撃！");
			int damege = 0;
			int critical_damege = 0;
			int rnd = (int)(Math.random()*(this.atk / 5)-(this.atk / 10));
			int hit_rnd = (int)(Math.random()*(10000));
			int hit_brns = (this.hit * 10000 / (e.abs + 100));
			int clt_brns = 10000 - (hit_brns * this.clt / 100);
			damege = (int)(Math.pow(this.atk,2) / e.dfe / 4 + rnd);
			critical_damege = (int)(this.atk / 1.2 + rnd * 1.5);
		if(!(this.checklive())){
			this.maxline(2);
		}else if(!(e.checklive())){
			e.maxline(2);
		}else {
			//System.out.println(this.atk / 2 + " - "+ e.dfe / 4 +" + "+ rnd +" = "+(damege));
			//System.out.println(hit_rnd+" < "+hit_brns);
			//System.out.println(hit_rnd+" > "+clt_brns);
			
			if(hit_rnd > hit_brns){
				System.out.println(e.name+" に 攻撃をかわされた！");
			}else if(hit_rnd > clt_brns){
				System.out.println("クリティカルヒット！");
				if(critical_damege<1){
					System.out.println(e.name+" にダメージを与えられなかった！");
					get_exp((int)(( 1 + 5 * (e.Lv+15) / (this.Lv+10)) * 1.5));
				}else{
					System.out.println(e.name + " に "+(critical_damege)+" のダメージ！");
  	 	  	e.hp -= critical_damege;
					get_exp(Math.round(( 8 + 5 * (e.Lv+0) * 3 / (this.Lv+0))));
					if(0 > e.hp) e.hp = 0;
					e.maxline(2);
				}
			}else{
				if(damege<1){
					System.out.println(e.name+" にダメージを与えられなかった！");
					get_exp((int)( 1 + 5 * (e.Lv+15) / (this.Lv+10)));
				}else{
					System.out.println(e.name + " に "+(damege)+" のダメージ！");
  	 	  	e.hp -= damege;
					get_exp((int)( 8 + 5 * (e.Lv+0) / (this.Lv+0)));
					if(0 > e.hp) e.hp = 0;
					e.maxline(2);
				}
			}
		}
		System.out.println("");
  }
	void get_exp(int point){
		point *= 2;
		this.exp += point;
		System.out.println(this.name + " は "+point+" ポイントの経験値を手に入れた！");
		if(this.exp>=this.expmax) Lv_up(0);
	}
	
	void silent_exp(){
		int point = 1;
		this.exp += point;
		if(this.exp>=this.expmax) Lv_up(1);
	}
	
	boolean checklive(){
		return this.live;
	}
}
public class WIzard extends Hero{
	WIzard(String str,int lv){
		super(str,lv);
		job = "魔術師";
		this.name = str;
		State_stream(job);
		this.Lv = 1;
		while(this.Lv < lv) silent_exp();
	}
  void heal(Hero h) {
			System.out.println(this.name + " の "+" 「ヒール」！");
			if(!(this.checklive())){
				this.maxline(2);
			}else if(!(h.checklive())){
				h.maxline(2);
			}else if(this.mp<6){
				System.out.println(this.name + "のMPが "+(6 - this.mp)+" 足りなかった！");
			}else{
				this.mp-=6;
				int hp = h.hp;
  	    h.hp += 15 + mdf / 4;
				h.maxline(0);
    	  System.out.println(h.name + "のHPを "+(h.hp - hp)+" 回復した");
				get_exp((int)( 6 + ((h.hp - hp) * 10 / h.hpmax)));
			}
		System.out.println("");
  }
	void right_heal(Hero h) {
			int use_mp=4;
			System.out.println(this.name + " の "+" 「ライトヒール」！");
			int hp = h.hp;
			if(!(this.checklive())){
				this.maxline(2);
			}else if(!(h.checklive())){
				h.maxline((int)(Math.round(10 * 0.5 *mgk / 15)));
			}else if(this.mp<1){
				System.out.println(this.name + "のMPが 足りない！");
			}else{
				if(this.mp<4){
					use_mp = this.mp;
					System.out.println(this.name + "のMP "+(this.mp)+" で唱えた！");
					h.hp += (int)(7/4*this.mp);
  	    	this.mp=0;
				}else{
					this.mp-=4;
  	    	h.hp += 7;
				}
				h.maxline(0);
    	  System.out.println(h.name + "のHPを "+(h.hp - hp)+" 回復した");
				get_exp((int)( use_mp + ((h.hp - hp) * 12 / h.hpmax)));
			}
		System.out.println("");
  }
	void attack_freim(Hero e) {
		System.out.println(this.name + " の "+" 「フレイムⅠ」！");
		if(!(this.checklive())){
			this.maxline(2);
		}else if(!(e.checklive())){
			e.maxline(2);
		}else if(this.mp<7){
				System.out.println(this.name + "のMPが 足りない！");
				this.attack(e);
		}else {
			this.mp-=6;
			int damege = 0;
			int rnd = (int)(Math.random()*(this.mgk / 2.5)-(this.mgk / 5));
			damege = (int)(Math.pow(this.mgk,2) / e.mdf / 3 + rnd +25);
			//System.out.println(this.mgk / 2 + " - "+ e.mdf / 2 +" + ("+ rnd +") + 25 = "+(damege));
			if(damege<1){
				System.out.println(e.name+" にダメージを与えられなかった！");
			}else{
				System.out.println(e.name + " に "+(damege)+" のダメージ！");
  	    e.hp -= damege;
				get_exp((int)( 7 + 8 + 3 * (e.Lv+3) / (this.Lv+3)));
				if(0 > e.hp) e.hp = 0;
				e.maxline(2);
			}
		}
		System.out.println("");
  }
}
public class WArrior extends Hero{
	WArrior(String str,int lv){
		super(str,lv);
		job = "戦士";
		this.name = str;
		State_stream(job);
		this.Lv = 1;
		while(this.Lv < lv) silent_exp();
	}
}
public class SWordfighter extends Hero{
	SWordfighter(String str,int lv){
		super(str,lv);
		job = "剣士";
		this.name = str;
		State_stream(job);
		this.Lv = 1;
		while(this.Lv < lv) silent_exp();
	}
	void attack(Hero e) {
		System.out.println(this.name + " の "+" 攻撃！");
			int damege = 0;
			int critical_damege = 0;
			int rnd = (int)(Math.random()*(this.atk / 10)-(this.atk / 20));
			int hit_rnd = (int)(Math.random()*(10000));
			int hit_brns = (this.hit * 10000 / (e.abs + 100));
			int clt_brns = 10000 - (hit_brns * this.clt / 100);
			damege = (int)(Math.pow(this.atk,2) / e.dfe / 8 + rnd);
			critical_damege = (int)(this.atk / 1.2 + rnd * 1.5);
		if(!(this.checklive())){
			this.maxline(2);
		}else if(!(e.checklive())){
			e.maxline(2);
		}else {
			//System.out.println(hit_rnd+" < "+hit_brns);
			//System.out.println(hit_rnd+" > "+clt_brns);
			
			if(hit_rnd > hit_brns){
				System.out.println(e.name+" に 攻撃をかわされた！");
				if(Math.random()*100<80) get_exp(Math.round(second_attack(e,1)));
			}else if(hit_rnd > clt_brns){
				System.out.println("クリティカルヒット！");
				if(critical_damege<1){
					System.out.println(e.name+" にダメージを与えられなかった！");
					get_exp((int)(( 1 + 5 * (e.Lv+15) / (this.Lv+10)) * 1.5));
				}else{
					System.out.println(e.name + " に "+(critical_damege)+" のダメージ！");
  	 	  	e.hp -= critical_damege;
					if(0 > e.hp) e.hp = 0;
					e.maxline(2);
					if(Math.random()*100<80) get_exp(Math.round(( 4 + 3 * (e.Lv+0) * 3 / (this.Lv+0)) + second_attack(e,2)));
					else get_exp(Math.round( 8 + 5 * (e.Lv+0) * 3 / (this.Lv+0)));
				}
			}else{
				if(damege<1){
					System.out.println(e.name+" にダメージを与えられなかった！");
					get_exp((int)( 1 + 5 * (e.Lv+15) / (this.Lv+10)));
				}else{
					System.out.println(e.name + " に "+(damege)+" のダメージ！");
  	 	  	e.hp -= damege;
					if(0 > e.hp) e.hp = 0;
					e.maxline(2);
					if(Math.random()*100<80) get_exp(Math.round(( 4 + 3 * (e.Lv+0) / (this.Lv+0)) + second_attack(e,2)));
					else get_exp(Math.round( 8 + 5 * (e.Lv+0) / (this.Lv+0)));
				}
			}
		}
		System.out.println("");
  }
	int second_attack(Hero e,int cnt) {
		System.out.println(e.name + " に "+" 続けて攻撃！");
			int damege = 0;
			int critical_damege = 0;
			int rnd = (int)(Math.random()*(this.atk / 10)-(this.atk / 20));
			int hit_rnd = (int)(Math.random()*(10000));
			int hit_brns = (this.hit * 10000 / (e.abs + 100));
			int clt_brns = 10000 - (hit_brns * this.clt / 100);
			damege = (int)(this.atk / 4 - e.dfe / 8 + rnd);
			critical_damege = (int)(this.atk / 1.2 + rnd * 1.5);
		int plse_get = 0;
		if(!(this.checklive())){
			this.maxline(2);
			plse_get = 2 * e.Lv;
		}else if(!(e.checklive())){
			e.maxline(2);
		}else {
			//System.out.println(hit_rnd+" < "+hit_brns);
			//System.out.println(hit_rnd+" > "+clt_brns);
			
			if(damege<1){
				System.out.println(e.name+" にダメージを与えられなかった！");
				 plse_get = (1);
			}else if(hit_rnd > hit_brns){
				System.out.println(e.name+" に 攻撃をかわされた！");
				if((Math.random()*100<80)&&(cnt<=2)) plse_get = (Math.round(second_attack(e,cnt)));
			}else if(hit_rnd > clt_brns){
				System.out.println("クリティカルヒット！");
				if(critical_damege<1){
					System.out.println(e.name+" にダメージを与えられなかった！");
					 plse_get = ((int)(( 0.5 + 3 * (e.Lv+15) / (this.Lv+10)) * 1.5));
				}else{
					System.out.println(e.name + " に "+(critical_damege)+" のダメージ！");
  	 	  	e.hp -= critical_damege;
					if(0 > e.hp) e.hp = 0;
					e.maxline(2);
					if(Math.random()*100<(80/cnt)) plse_get = (Math.round(( 4 + 2 * (e.Lv+0) * 3 / (this.Lv+0)) + second_attack(e,2)));
					else plse_get = (Math.round( 4 + 3 * (e.Lv+0) * 3 / (this.Lv+0)));
				}
			}else{
				if(damege<1){
					System.out.println(e.name+" にダメージを与えられなかった！");
					 plse_get = ((int)( 0.5 + 3 * (e.Lv+15) / (this.Lv+10)));
				}else{
					System.out.println(e.name + " に "+(damege)+" のダメージ！");
  	 	  	e.hp -= damege;
					if(0 > e.hp) e.hp = 0;
					e.maxline(2);
					if(Math.random()*100<(80/cnt))  plse_get = ((int)( 4 + 2 * (e.Lv+0) / (this.Lv+0)) + second_attack(e,cnt++));
					else  plse_get = (int)( 4 + 3 * (e.Lv+0) / (this.Lv+0));
				}
			}
		}
		return plse_get;
  }
}
public class banana extends Hero{
	banana(String str,int lv){
		super(str,lv);
		this.name = str;
		job = "旅人";
		State_stream(job);
		this.Lv = 1;
		while(this.Lv < lv) silent_exp();
	}
}
