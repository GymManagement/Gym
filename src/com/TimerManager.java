package com;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
public class TimerManager {
	private static final long PERIOD_DAY = 24*60*60*1000;

	public TimerManager() {
		Calendar calendar =Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 21);
		calendar.set(Calendar.SECOND,0);
		Date date=calendar.getTime();
		Timer timer = new Timer();
		CrawlTask task=new CrawlTask();
		timer.schedule(task, date,PERIOD_DAY);
	}
}
