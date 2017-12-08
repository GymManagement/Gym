package com;

import java.util.Date;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class CrawlListenner implements ServletContextListener {
	private static final long PERIOD_DAY = 24*60*60*1000;
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		new TimerManager();
	/*	Timer timer = new Timer();
		CrawlTask task=new CrawlTask();
		//CrawlDataSumTask dataTask=new CrawlDataSumTask();
		Calendar calendar =Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 10);
		calendar.set(Calendar.SECOND,0);
		Date date=calendar.getTime();
		if(date.before(new Date())) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			date =calendar.getTime();
		}
		//timer.schedule(task, date,PERIOD_DAY);
	//	timer.schedule(task, 0, 1*60*1000);
		timer.schedule(task, 2*60*1000);*/
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

}

