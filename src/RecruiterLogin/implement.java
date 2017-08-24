package RecruiterLogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class implement extends BaseClass {
	

	public void DashBoard() throws Exception {
		/*
		 * @author Sakthi Praveen Kumar.k work name : DashBoard
		 */
		 String mytitle = "Top Jobs for Smart Talent | TechFetch.com";
		 //System.out.println(d.getTitle());
		 if (d.getTitle().equals(mytitle)) {
		d.navigate().refresh();
		 }
		Thread.sleep(3000);
		Properties prop;
		FileInputStream fileInput = new FileInputStream(workingDir + "\\Resources\\Dashboard.properties");
		prop = new Properties();
		prop.load(fileInput);
		//Thread.sleep(2000);
		Thread.sleep(3000);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe1");
		Thread.sleep(3000);
		//Thread.sleep(2000);
		css(prop.getProperty("Avaliableasof")).click();
		log.info("Clicking Avaliable as of menu");

		// To display all the element from the WebPage Table WebElement table =
		xp(prop.getProperty("TableBorder"));
		log.info("getting table border");
		// Get all rows (tr tags) List<WebElement> rows =
		/*
		 * table.findElements(By.tagName("tr"));
		 * System.out.println("No. of Rows in the WebTable: "); // Print data from each
		 * row (Data from each System.out.println(rows.size() - 1); // td tag)
		 * d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		 */

		// To Display All The Resumes according To Month Using For Loop:

		String[] months = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		for (int i = 0; i < 12; i++) {

			/*
			 * driver.findElement( By.xpath(
			 * ".//[@id='emp-col9']/div/div[2]/div[3]/div/div/div[2]/table/thead/tr[2]/td[1]/div/input"
			 * )) .clear();
			 */

			xp(prop.getProperty("AvaliableasofFieldBox")).sendKeys(months[i]);
			log.info("getting avaliableasoffield");
			Thread.sleep(2000);

			WebElement table1 = xp(prop.getProperty("TableBorder"));
			log.info("getting tableborder");
			List<WebElement> rows4 = table1.findElements(By.tagName("tr"));
			Thread.sleep(2000);

			System.out.println("Resumes" + months[i]);
			log.info("printing resumes");
			System.out.println(rows4.size() - 1);
			log.info("printing rowsize");
			xp(prop.getProperty("AvaliableasofFieldBox")).clear();
			log.info("clearing avaliableasof field");

		}

		// Search by Name d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		xp(prop.getProperty("SearchByNameFieldBox")).sendKeys(prop.getProperty("SearchByNameValue"));
		log.info("getting fieldname");
		Thread.sleep(2000);
		xp(prop.getProperty("SearchByNameFieldBox")).clear();
		log.info("clearing fieldbox");
		Thread.sleep(2000);

		// Search By Work Authorization

		String[] WorkAuthorization = new String[] { "US Citizen", "Green Card", "US Security Clearance" };
		for (int i = 0; i < 3; i++) {

			xp(prop.getProperty("WorkAuthorizationFieldBox")).sendKeys(WorkAuthorization[i]);
			log.info("getting workauthorization");
			Thread.sleep(2000);

			xp(prop.getProperty("WorkAuthorizationFieldBox")).clear();
			log.info("clearing workauthorization");
			Thread.sleep(2000);

		} // Search By Location(City or State)

		xp(prop.getProperty("LocationFieldBox")).sendKeys(prop.getProperty("LocationSearchValue"));
		log.info("getting location field");
		Thread.sleep(2000);
		xp(prop.getProperty("LocationFieldBox")).clear();
		log.info("clearing locationfieldbox");
		// Search By Relocation

		String[] ReLocation = new String[] { "Yes", "No" };
		for (int i = 0; i < 2; i++) {

			xp(prop.getProperty("RelocationFieldBox")).sendKeys(ReLocation[i]);
			log.info("getting relocationfield");
			Thread.sleep(2000);
			xp(prop.getProperty("RelocationFieldBox")).clear();
			log.info("clearing relocationfield");
		}

		// search By Specialized Area

		xp(prop.getProperty("SpecializedAreaFieldBox")).sendKeys(prop.getProperty("SpecializedAreaSearchValue"));
		log.info("getting specializedarea");
		Thread.sleep(2000);

		xp(prop.getProperty("SpecializedAreaFieldBox")).clear();
		log.info("clearing specializedarea");
		// Search By Experience
		xp(prop.getProperty("ExperienceFieldBox")).sendKeys(prop.getProperty("ExperienceSearchValue"));
		log.info("getting experiencefield");
		Thread.sleep(2000);
		xp(prop.getProperty("ExperienceFieldBox")).clear();
		log.info("clearing experiencefieldbox");
		Thread.sleep(2000);

		// Search By Rate
		xp(prop.getProperty("RateFieldBox")).sendKeys(prop.getProperty("RateSearchValue"));
		log.info("getting ratefieldbox");
		// Profile Click

		xp(prop.getProperty("ProfileClick")).click();
		log.info("clicking profile");
		Thread.sleep(1000);
		String window1 = d.getWindowHandle();
		System.out.println(window1);
		log.info("printing window1 output");
		Set<String> windows = d.getWindowHandles();
		Iterator iterator = windows.iterator();
		String x;
		while (iterator.hasNext()) {
			x = iterator.next().toString();

			System.out.println(x);

			// for(String x:windows){
			if (x.equals(window1) == false) {
				d.switchTo().window(x);

				// Thread.sleep(2000);

				Thread.sleep(2000);
				xp(prop.getProperty("Email")).click();
				log.info("clicking email");
				Thread.sleep(2000);
				d.switchTo().defaultContent();
				d.switchTo().frame("empchkResumecontentframe");
				Thread.sleep(500);
				xp(prop.getProperty("Subject")).sendKeys(prop.getProperty("SubjectValue"));
				log.info("getting subject");
				Thread.sleep(500);
				xp(prop.getProperty("EmailSend")).click();
				log.info("clicking emailsend");
				Thread.sleep(500);
				xp(prop.getProperty("EmailNotificationClose")).click();
				log.info("clicking emailnotification");
				Thread.sleep(500);
				// Thread.sleep(2000);

				d.switchTo().defaultContent();

				// d.close();

				d.switchTo().window(x);
				// Thread.sleep(2000);
				xp(prop.getProperty("ForwardProfile")).click();
				log.info("clicking forward profile");
				Thread.sleep(500);
				d.switchTo().defaultContent();

				d.switchTo().frame("empforwardprofilecontentframe");
				Thread.sleep(500);
				xp(prop.getProperty("ToMailID")).sendKeys(prop.getProperty("ToMailIDValue"));
				log.info("Getting mailid");
				Thread.sleep(500);
				xp(prop.getProperty("ForwardButton")).click();
				log.info("clicking forward button");
				Thread.sleep(500);
				xp(prop.getProperty("ForwardCloseButton")).click();
				log.info("Clicking forward close");
				Thread.sleep(100);
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				Thread.sleep(1000);
				xp(prop.getProperty("AddFeedback")).click();
				log.info("Clicking add feedback");
				Thread.sleep(500);
				d.switchTo().defaultContent();
				d.switchTo().frame("employerfeedbackframe");

				Thread.sleep(500);

				xp(prop.getProperty("OpenToRelocate")).click();
				log.info("Clicking opento relocate");
				Thread.sleep(500);
				xp(prop.getProperty("Save&Close")).click();
				log.info("Clicking Save button");
				Thread.sleep(500);
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				d.close();

				/*
				 * xp(prop.getProperty("AddNote")).click(); d.switchTo().defaultContent();
				 * 
				 * Thread.sleep(2000); d.switchTo().frame("addnotesframe");
				 * 
				 * xp(prop.getProperty("TextBoxField")).sendKeys(prop.getProperty("TextBoxValue"
				 * )); xp(prop.getProperty("Save&close")).click();
				 */

			}
		}
		d.switchTo().window(window1);
		Thread.sleep(2000);
	}

	public void postjob() throws Exception {

		/**
		 * @author surya Balapriya work name : postjobs
		 */
		String workingDir;

		workingDir = System.getProperty("user.dir");

		File file = new File(workingDir + "\\Resources\\postjob.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		Thread.sleep(500);
		id(prop.getProperty("postjobs")).click();
		Thread.sleep(2000);
		d.switchTo().defaultContent();

		d.switchTo().frame("Iframe2");
		Thread.sleep(2000);
		id(prop.getProperty("Jobtitle")).clear();
		log.info("clearing title");
		id(prop.getProperty("Jobtitle")).sendKeys(prop.getProperty("jobtitle"));
		log.info("getting title");
		id(prop.getProperty("Requiredskills")).clear();
		log.info("clearing skills");
		id(prop.getProperty("Requiredskills")).sendKeys(prop.getProperty("requiredskills"));
		log.info("getting skills");
		id(prop.getProperty("Preferredskill")).clear();
		log.info("clearing preferredskills ");
		id(prop.getProperty("Preferredskill")).sendKeys(prop.getProperty("preferredskill"));
		log.info("getting preferredskills");
		id(prop.getProperty("explevel")).click();
		log.info("clicking explevel");
		id(prop.getProperty("Jobdescription")).clear();
		log.info("clearing jobdescription");
		id(prop.getProperty("Jobdescription")).sendKeys(prop.getProperty("jobdescription"));
		log.info("getting jobdescription");
		id(prop.getProperty("Clientname")).clear();
		log.info("clearing clientname");
		id(prop.getProperty("Clientname")).sendKeys(prop.getProperty("clientname"));
		log.info("getting clientname");
		id(prop.getProperty("Buttonclick")).click();
		log.info("clicking button");
		Thread.sleep(7000);
		id(prop.getProperty("City")).sendKeys(prop.getProperty("city"));
		log.info("getting city");
		Thread.sleep(7000);
		css(prop.getProperty("citylist")).click();
		log.info("clicking citylist");
		Thread.sleep(7000);

		new Select(id(prop.getProperty("Jobexp"))).selectByVisibleText("1 Week");
		log.info("selecting jobexp");
		id(prop.getProperty("consulting")).click();
		log.info("clicking consulting");
		id(prop.getProperty("workauthori")).click();
		log.info("clicking workauthor");
		id(prop.getProperty("preferemp")).click();
		log.info("clicking preferemp");
		id(prop.getProperty("Duration")).clear();
		log.info("clearing duration");
		id(prop.getProperty("Duration")).sendKeys(prop.getProperty("duration"));
		log.info("getting duration");
		Select select = new Select(xp(prop.getProperty("splarea")));
		log.info("selecting splarea");
		Select select1 = new Select(xp(prop.getProperty("splskills")));
		log.info("selecting splskills");
		for (int i = 0; i <= 27; i++) {
			select.selectByIndex(i);
			Thread.sleep(2000);
		}

		select.selectByIndex(1);
		select1.selectByIndex(1);

		id(prop.getProperty("savebtn")).click();
		log.info("clicking savebtn");
		id(prop.getProperty("others")).click();
		log.info("clicking others");
		id(prop.getProperty("domainexpo")).click();
		log.info("domainexpo");
		id(prop.getProperty("domainexpo1")).click();
		log.info("getting domainexpo1");
		id(prop.getProperty("domainexpo2")).click();
		log.info("getting domainexpo2");
		Thread.sleep(2000);
		id(prop.getProperty("postmyjob")).click();
		log.info("clicking postmyjob");
		Thread.sleep(2000);
		xp(prop.getProperty("closebtn")).click();
		log.info("clicking closebutton");
		d.switchTo().defaultContent();
	}

	public void Jobresponse() throws Exception {

		/**
		 * @author Santhalakshmi work name :Jobresponse
		 */

		File file = new File(workingDir + "\\Resources\\jobresponse.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		// jobresponse tab
		css(prop.getProperty("jobresponse")).click();
		log.info("clicking jobresponse");
		Thread.sleep(2000);

		d.switchTo().defaultContent();
		Thread.sleep(2000);
		d.switchTo().frame("Iframe4");
		Thread.sleep(2000);

		// Select Select = new Select(id(prop.getProperty("resumetitle")));
		// Thread.sleep(2000);
		// resumelink click
		css(prop.getProperty("resumelink")).click();
		log.info("clicking resumelink");
		String window1 = d.getWindowHandle();
		System.out.println(window1);

		Set<String> windows = d.getWindowHandles();
		Iterator iterator = windows.iterator();
		String x;
		while (iterator.hasNext()) {
			x = iterator.next().toString();

			System.out.println(x);

			// for(String x:windows){
			if (x.equals(window1) == false) {
				// switch to window
				d.switchTo().window(x);
				// Thread.sleep(2000);
				// forwarding

				Thread.sleep(2000);
				css(prop.getProperty("forward")).click();
				log.info("clicking forward");
				Thread.sleep(500);
				d.switchTo().defaultContent();
				d.switchTo().frame("empforwardprofilecontentframe");
				Thread.sleep(2000);
				css(prop.getProperty("toaddress")).sendKeys(prop.getProperty("tomailid"));
				log.info("getting toaddress ");
				css(prop.getProperty("send")).click();
				log.info("clicking send");
				Thread.sleep(2000);
				css(prop.getProperty("close")).click();
				log.info("clicking close");
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				Thread.sleep(2000);
				// Thread.sleep(2000);
				// downloading
				// css(prop.getProperty("download")).click();

				Thread.sleep(2000);
				// check email availability
				css(prop.getProperty("checkmail")).click();
				log.info("clicking checkmail");
				d.switchTo().defaultContent();
				d.switchTo().frame("empchkResumecontentframe");
				css(prop.getProperty("subject")).sendKeys(prop.getProperty("Resume"));
				log.info("clicking postmyjob");
				css(prop.getProperty("submit")).click();
				log.info("clicking submit");
				css(prop.getProperty("close")).click();
				log.info("clicking close");
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				d.close();
			}
			d.switchTo().window(window1);
			Thread.sleep(2000);
		}

	}

	public void fetchresume() throws InterruptedException, IOException {

		/**
		 * @author Karthigavalli work name :Fetch Resume
		 */

		File file = new File(workingDir + "\\Resources\\rec.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		d.switchTo().defaultContent();

		xp(prop.getProperty("fetch")).click();
		log.info("clicking postmyjob");
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe5");
		Thread.sleep(2000);
		id(prop.getProperty("key")).sendKeys(prop.getProperty("keyword"));
		log.info("getting key");
		Thread.sleep(2000);
		id(prop.getProperty("all")).click();
		log.info("clicking all");
		id(prop.getProperty("workAuthority")).click();
		log.info("clicking workAuthority");
		id(prop.getProperty("workAuthority1")).click();
		log.info("clicking workAuthority1");
		id(prop.getProperty("workAuthority2")).click();
		log.info("clicking workAuthority2");
		id(prop.getProperty("workAuthority3")).click();
		log.info("clicking workAuthority3");
		id(prop.getProperty("preferedEmployment")).click();
		log.info("clicking preferedEmployment");
		id(prop.getProperty("preferedEmployment1")).click();
		log.info("clicking preferedEmployment1");
		id(prop.getProperty("preferedEmployment2")).click();
		log.info("clicking preferedEmployment2");
		id(prop.getProperty("preferedEmployment3")).click();
		log.info("clicking preferedEmployment3");
		id(prop.getProperty("preferedEmployment4")).click();
		log.info("clicking preferedEmployment4");
		id(prop.getProperty("workAuthority")).click();
		log.info("clicking workAuthority");
		id(prop.getProperty("workAuthority1")).click();
		log.info("clicking workAuthority1");
		id(prop.getProperty("preferedEmployment")).click();
		log.info("clicking preferedEmployment ");
		id(prop.getProperty("preferedEmployment1")).click();
		log.info("clicking prefered employment1");
		Thread.sleep(2000);
		new Select(id(prop.getProperty("area"))).selectByVisibleText("Java, J2EE");
		log.info("getting area");
		new Select(id(prop.getProperty("skill"))).selectByVisibleText("Java Server Side");
		log.info("getting skill");
		id(prop.getProperty("advancedSearch")).click();
		log.info("clicking advanced search");
		Thread.sleep(2000);
		xp(prop.getProperty("domain1")).click();
		log.info("clicking domain1");
		xp(prop.getProperty("domain2")).click();
		log.info("clicking domain2");
		id(prop.getProperty("country")).click();
		log.info("clicking country");
		Thread.sleep(2000);
		new Select(id(prop.getProperty("degree"))).selectByVisibleText("Bachelor");
		log.info("getting degree");
		Select select = new Select(id(prop.getProperty("state")));
		log.info("getting state");
		List<WebElement> l = select.getOptions();
		for (int i = 0; i < 6; i++) {
			select.selectByIndex(i);
			xp(prop.getProperty("arrow")).click();
			log.info("clicking arrow");
		}
		id(prop.getProperty("Experience")).click();
		log.info("clicking experience");
		id(prop.getProperty("usExperience")).click();
		log.info("clicking usExperience");
		id(prop.getProperty("askill1")).sendKeys(prop.getProperty("skill1"));
		log.info("getting askill1");
		new Select(id(prop.getProperty("year1"))).selectByVisibleText("4");
		log.info("getting year1");
		id(prop.getProperty("askill2")).sendKeys(prop.getProperty("skill1"));
		log.info("getting askill2");
		new Select(id(prop.getProperty("year2"))).selectByVisibleText("2");
		log.info("getting year2");
		id(prop.getProperty("askill3")).sendKeys(prop.getProperty("skill1"));
		log.info("getting askill3");
		new Select(id(prop.getProperty("year3"))).selectByVisibleText("4");
		log.info("getting year");
		xp(prop.getProperty("save")).sendKeys(prop.getProperty("fetching"));
		log.info("getting save");
		Thread.sleep(2000);
		new Select(id(prop.getProperty("days"))).selectByVisibleText("90 Days");
		log.info("getting days");
		Thread.sleep(2000);
		id(prop.getProperty("fetched")).click();
		log.info("clicking fetched");
		Thread.sleep(2000);

		d.switchTo().defaultContent();
		Thread.sleep(4000);
		xp(prop.getProperty("loggggggg")).click();
		log.info("clicking logg");
		Thread.sleep(4000);
		xp(prop.getProperty("logggggggoooo")).click();
		log.info("clicking log");
	}

	public void Jobs() throws Exception {
		File file = new File(workingDir + "\\Resources\\myjob.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.switchTo().defaultContent();
		css(prop.getProperty("jobmenu")).click();
		log.info("clicking jobmenu");
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");
		xp(prop.getProperty("updateddate")).sendKeys(prop.getProperty("month"));
		log.info("getting updatedate");
		xp(prop.getProperty("jobtitle")).sendKeys(prop.getProperty("lang"));
		log.info("getting jobtitle");
		xp(prop.getProperty("location")).sendKeys(prop.getProperty("cty4"));
		log.info("clicking location");
		Thread.sleep(2000);

		xp(prop.getProperty("preview")).click();
		log.info("clicking preview");
		String window1 = d.getWindowHandle();
		System.out.println(window1);

		Set<String> windows = d.getWindowHandles();
		Iterator iterator = windows.iterator();
		String x;
		while (iterator.hasNext()) {
			x = iterator.next().toString();

			System.out.println(x);

			// for(String x:windows){
			if (x.equals(window1) == false) {
				d.switchTo().window(x);
				Thread.sleep(2000);

				xp(prop.getProperty("applynow")).click();
				log.info("clicking applynow");
				d.switchTo().defaultContent();
				d.switchTo().frame("applyemailframe");
				Thread.sleep(2000);
				
				new Select(d.findElement(By.id(prop.getProperty("selectfromprofile"))))
						.selectByIndex(2);
				
				log.info("getting selectfromprofile");
				xp(prop.getProperty("optionvalue")).click();
				log.info("clicking optionvalue");
				xp(prop.getProperty("cc")).clear();
				log.info("clearing cc");
				xp(prop.getProperty("cc")).sendKeys(prop.getProperty("tooo"));
				log.info("getting cc");
				id(prop.getProperty("coveringletter")).click();
				log.info("clicking coveringletter");
				Thread.sleep(2000);
				id(prop.getProperty("fileupload")).clear();
				log.info("clearing fileupload");
				// d.findElement(By.xpath(".//*[@id='uploaddiv']/div/div/div")).click();
				id(prop.getProperty("fileupload")).sendKeys(workingDir + "\\Resources\\ram.docx");
				log.info("getting file");
				// d.findElement(By.id("uploadvalue2")).sendKeys("C:\\Users\\mag8\\Desktop\\res.docx");
				id(prop.getProperty("sendemail")).click();
				log.info("clicking sendmail");
				Thread.sleep(2000);
				d.switchTo().defaultContent();
				d.switchTo().frame("applyemailframe");
				xp(prop.getProperty("btnclose")).click();
				log.info("clicking btnclose");
				// forward
				Thread.sleep(5000);
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				xp(prop.getProperty("forwardjob")).click();
				log.info("clicking fwdjob");
				d.switchTo().defaultContent();
				d.switchTo().frame("jsfwdjobcontentframe");
				Thread.sleep(2000);
				xp(prop.getProperty("toaddr")).sendKeys(prop.getProperty("tooo"));
				log.info("getting toaddr");
				Thread.sleep(2000);
				xp(prop.getProperty("sendmail")).click();
				log.info("clicking sendmail");
				Thread.sleep(2000);
				d.close();
			}
		}

		// FORWARD
		Thread.sleep(2000);
		d.switchTo().window(window1);
		css(prop.getProperty("jobmenu")).click();
		log.info("clicking jobmenu");
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");

		xp(prop.getProperty("updateddate")).clear();
		log.info("clearing updatedate");
		xp(prop.getProperty("jobtitle")).clear();
		log.info("clearing jobtitle");
		xp(prop.getProperty("location")).clear();
		log.info("clearing location");
		Thread.sleep(2000);
		xp(prop.getProperty("updateddate")).sendKeys(prop.getProperty("month8"));
		log.info("getting updatedate");
		xp(prop.getProperty("jobtitle")).sendKeys(prop.getProperty("lang8"));
		log.info("getting jobtitle");
		xp(prop.getProperty("location")).sendKeys(prop.getProperty("cty8"));
		log.info("getting location");
		// xp(prop.getProperty("fwd")).click();
		// Thread.sleep(2000);
		// d.switchTo().frame(d.findElement(By.xpath(prop.getProperty("forwardmain"))));
		// Thread.sleep(2000);
		// xp(prop.getProperty("toaddr")).sendKeys(prop.getProperty("tooo"));
		// Thread.sleep(2000);
		// css(prop.getProperty("sendmail1")).click();
		// Thread.sleep(2000);

		// EDIT

		// @author surya Balapriya work name : edit
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");
		xp(prop.getProperty("updateddate")).clear();
		log.info("clearing uodatedate");
		xp(prop.getProperty("jobtitle")).clear();
		log.info("clearing jobtitle");
		xp(prop.getProperty("location")).clear();
		log.info("clearing location");
		Thread.sleep(2000);

		xp(prop.getProperty("edit")).click();
		log.info("clicking edit");
		d.switchTo().defaultContent();
		Thread.sleep(2000);
		d.switchTo().frame("Iframe8");

		id(prop.getProperty("jobtitle5")).clear();
		log.info("clicking jobtitle5");
		id(prop.getProperty("jobtitle5")).sendKeys(prop.getProperty("Title"));
		log.info("getting jobtitle5");
		Thread.sleep(2000);

		id(prop.getProperty("skillreq")).clear();
		log.info("clicking skillreq");
		id(prop.getProperty("skillreq")).sendKeys(prop.getProperty("Title"));
		log.info("getting skillreq");
		id(prop.getProperty("exlevel")).click();
		log.info("clicking exlevel");
		id(prop.getProperty("exlevel1")).click();
		log.info("clicking exlevel1");
		id(prop.getProperty("exlevel2")).click();
		log.info("clicking exlevel2");
		id(prop.getProperty("exlevel3")).click();
		log.info("clicking exlevel3");
		id(prop.getProperty("exlevel4")).click();
		log.info("clicking exlevel4");
		Thread.sleep(2000);

		xp(prop.getProperty("permanenttype")).click();
		log.info("clicking Parametertype");
		id(prop.getProperty("Work1")).click();
		log.info("clicking work1");
		Thread.sleep(2000);

		id(prop.getProperty("PreferredEmployment5")).click();
		log.info("clicking PreferredEmployment5");
		Thread.sleep(2000);

		new Select(id(prop.getProperty("splarea1"))).selectByVisibleText("Java, J2EE");
		log.info("getting splarear1");
		new Select(id(prop.getProperty("splskill1"))).selectByVisibleText("Java, J2EE");
		log.info("getting splskill1");
		id(prop.getProperty("domainlist0")).click();
		log.info("clicking domainlist0 ");
		id(prop.getProperty("domainlist2")).click();
		log.info("clicking domianlist2");
		id(prop.getProperty("preview1")).click();
		log.info("clicking preview1");
		Thread.sleep(5000);

		d.findElement(By.linkText(prop.getProperty("closebutton"))).click();
		log.info("clicking clsbutton");
		Thread.sleep(5000);

		d.switchTo().defaultContent();
		xp(prop.getProperty("matchclose")).click();
		log.info("clicking matchclose");
		xp(prop.getProperty("jobclose")).click();
		log.info("clicking jobclose");
		// id(prop.getProperty("updatebutton")).click();
		// Thread.sleep(5000);
		// xp(".//*[@id='tabs']/ul/li[3]/span").click();
		// d.close();
		
		//d.switchTo().defaultContent();
	}

	public void myaccount() throws Exception {
		File file = new File(workingDir + "\\Resources\\myaccount.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
	
	   	d.switchTo().defaultContent();
		   	xp(prop.getProperty("myaccount")).click();
			log.info("clicking myaccount");
			Thread.sleep(2000);
			d.switchTo().defaultContent();
			d.switchTo().frame("Iframe9");
			xp(prop.getProperty("txt_mail")).clear();
			log.info("clearing txtmail");
			xp(prop.getProperty("txt_mailid")).sendKeys(prop.getProperty("username"));
			log.info("getting txtmail");
			Thread.sleep(2000);
			xp(prop.getProperty("Firstname")).clear();
			log.info("clearing firstname ");
			xp(prop.getProperty("Firstname")).sendKeys("Trainee");
			log.info("getting firstname");
			Thread.sleep(2000);
			xp(prop.getProperty("Lastname")).clear();
			log.info("clearing lastname");
			xp(prop.getProperty("Lastname")).sendKeys("Three");
			log.info("getting lastname");
			Thread.sleep(2000);
			xp(prop.getProperty("companyname")).clear();
			log.info("clearing companyname");
			xp(prop.getProperty("companyname")).sendKeys("Techpark");
			;
			log.info("getting companyname");
			Thread.sleep(2000);
			xp(prop.getProperty("country")).sendKeys("India");
			log.info("getting country");
			Thread.sleep(2000);
			xp(prop.getProperty("city")).clear();
			log.info("clearing city");
			xp(prop.getProperty("city")).sendKeys("Mumbai, Maharashtra");
			Thread.sleep(2000);
			xp(prop.getProperty("personalid")).clear();
			log.info("clearing personalid");
			xp(prop.getProperty("personalid")).sendKeys("qatraining1@tiliconveli.com");
			log.info("getting personalid");
			Thread.sleep(2000);

			xp(prop.getProperty("ph_area")).sendKeys("+91");
			log.info("getting ph area");
			Thread.sleep(2000);
			xp(prop.getProperty("phno")).clear();
			log.info("clearing phno");
			xp(prop.getProperty("phno")).sendKeys("9487525100");
			log.info("getting phno");
			Thread.sleep(2000);
			xp(prop.getProperty("update")).click();
			log.info("clicking update");
			Thread.sleep(5000);

	
			d.switchTo().defaultContent();

			css(prop.getProperty("passclick")).click();
			log.info("clicking Passclick");
			d.switchTo().defaultContent();
			d.switchTo().frame("Iframe10");
		
			xp(prop.getProperty("passreset")).sendKeys(prop.getProperty("password"));
			log.info("getting passreset");
			Thread.sleep(2000);
			css(prop.getProperty("passreset1")).sendKeys(prop.getProperty("password"));
			log.info("getting passreset1");
			Thread.sleep(2000);
			xp(prop.getProperty("resetbutton")).click();
			log.info("clicking resetbutton");
			Thread.sleep(5000);

			d.switchTo().defaultContent();
			css(prop.getProperty("preference")).click();
			log.info("clicking preferences");
			d.switchTo().defaultContent();
			d.switchTo().frame("Iframe11");

			Thread.sleep(2000);

			css(prop.getProperty("radio2")).click();
			log.info("clicking radio2");
			Thread.sleep(2000);
			css(prop.getProperty("radio1")).click();
			log.info("clicking radio1");
			Thread.sleep(2000);
			css(prop.getProperty("radio4")).click();
			log.info("clicking radio4");
			Thread.sleep(2000);
			css(prop.getProperty("radio3")).click();
			log.info("clicking radio3");
			Thread.sleep(2000);
			css(prop.getProperty("radio6")).click();
			log.info("clicking radio6");
			Thread.sleep(2000);
			css(prop.getProperty("radio5")).click();
			log.info("clicking radion5");
			Thread.sleep(2000);
			css(prop.getProperty("radio_button")).click();
			log.info("clicking radiobutton");
			Thread.sleep(2000);
			d.switchTo().defaultContent();
			xp(prop.getProperty("user")).click();
			log.info("clicking user");
			Thread.sleep(2000);

		}
	}

