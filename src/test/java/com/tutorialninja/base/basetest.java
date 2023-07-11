package com.tutorialninja.base;



import com.tutorialsninja.pages.basepage;

public class basetest extends basepage{

	basepage basepage=new basepage();
	public void openbrowser_and_enter_url(String browsername,String url)
	{
		basepage.Initializebrower_and_open_application_url(browsername,url);
		
	}
	
}



