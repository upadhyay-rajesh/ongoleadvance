package com.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Trainees {
	private TrainerInterface ti;
	
	//ADAPTER
	public void setTi(TrainerInterface ti) {
		this.ti = ti;
	}

	public void useTrainer() {
		ti.teach();
	}

	public static void main(String[] args) {
		
		
	//	TrainerInterface tt=new Trainer();//SPRING TASK TO CREATE OBJECT USING BeanFactory
	//	Trainees t=new Trainees();
	//	t.setTi(tt);     //DI, task of spring
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("abc.xml");
		
		Trainees t=(Trainees)ctx.getBean("b");
		
		t.useTrainer();
	}

}






