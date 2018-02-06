package com.mano.combo_anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComboAnnoTestMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ComboConfig.class);

		ComboDemoService comboDemoService = context
				.getBean(ComboDemoService.class);

		comboDemoService.outPutResult();

		context.close();
	}

}
