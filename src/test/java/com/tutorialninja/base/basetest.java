package com.tutorialninja.base;

import java.io.File;

import com.tutorialsninja.pages.basepage;

public class basetest extends basepage{
	
	basepage basepage;
	public void openbrowser_and_enter_url(String browsername,String url)
	{
		basepage=new basepage();
		basepage.Initializebrower_and_open_application_url(browsername,url);
		
	}
	
}



