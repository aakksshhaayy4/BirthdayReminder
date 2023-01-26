package com.codewithakshay.birthdayreminder.postgres.component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.codewithakshay.birthdayreminder.postgres.model.Birthday;
import com.codewithakshay.birthdayreminder.postgres.service.BirthdayService;

@Component
public class ScheduledTasks {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	@Autowired
	private BirthdayService birthdaySerive;

	@Scheduled(cron = "* * * * * *")
	public void birthdayCheckCron() {
		List<Birthday> todaysBithdays = birthdaySerive.getTodaysBithdays();
		System.out.println("here is the cron executed at : " + dateFormat.format(new Date()) + " and today bbirthday : "
				+ todaysBithdays);
	}

}
