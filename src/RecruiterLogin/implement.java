package RecruiterLogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class implement extends BaseClass{

	
	public static void dashBoard() throws Exception {
		/*
		 * @author Sakthi Praveen Kumar.k work name : DashBoard
		 */
		String mytitle = "Top Jobs for Smart Talent | TechFetch.com";
		// System.out.println(d.getTitle());
		if (d.getTitle().equals(mytitle)) {
			d.navigate().refresh();
		}
		Properties prop;
		FileInputStream fileInput = new FileInputStream(workingDir + "\\Resources\\dashBoard.properties");
		prop = new Properties();
		prop.load(fileInput);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe1");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		css(prop.getProperty("avaliableAsof")).click();
		log.info("Clicking Avaliable as of menu");

		// To display all the element from the WebPage Table WebElement table =
		xp(prop.getProperty("tableBorder"));
		log.info("getting table border");

		// To Display All The Resumes according To Month Using For Loop:

		String[] months = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		for (int i = 0; i < 12; i++) {

			xp(prop.getProperty("avaliableAsofFieldbox")).sendKeys(months[i]);
			log.info("getting avaliableasoffield");
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			WebElement table1 = xp(prop.getProperty("tableBorder"));
			log.info("getting tableborder");
			List<WebElement> rows4 = table1.findElements(By.tagName("tr"));
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			System.out.println("Resumes" + months[i]);
			log.info("printing resumes");
			System.out.println(rows4.size() - 1);
			log.info("printing rowsize");
			xp(prop.getProperty("avaliableAsofFieldbox")).clear();
			log.info("clearing avaliableasof field");

		}

		// Search by Name

		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		xp(prop.getProperty("searchBynameFieldbox")).sendKeys(prop.getProperty("searchBynameValue"));
		log.info("getting fieldname");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		xp(prop.getProperty("searchBynameFieldbox")).clear();
		log.info("clearing fieldbox");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Search By Work Authorization

		String[] workAuthorization = new String[] { "US Citizen", "Green Card", "US Security Clearance" };
		for (int i = 0; i < 3; i++) {

			xp(prop.getProperty("workAuthorizationfieldBox")).sendKeys(workAuthorization[i]);
			log.info("getting workauthorization");
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			xp(prop.getProperty("workAuthorizationfieldBox")).clear();
			log.info("clearing workauthorization");
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} // Search By Location(City or State)

		xp(prop.getProperty("locationFieldbox")).sendKeys(prop.getProperty("locationSearchvalue"));
		log.info("getting location field");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		xp(prop.getProperty("locationFieldbox")).clear();
		log.info("clearing locationfieldbox");
		// Search By Relocation

		String[] reLocation = new String[] { "Yes", "No" };
		for (int i = 0; i < 2; i++) {

			xp(prop.getProperty("relocationFieldbox")).sendKeys(reLocation[i]);
			log.info("getting relocationfield");
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			xp(prop.getProperty("relocationFieldbox")).clear();
			log.info("clearing relocationfield");
		}

		// search By Specialized Area

		xp(prop.getProperty("specializedAreafieldBox")).sendKeys(prop.getProperty("specializedAreasearchValue"));
		log.info("getting specializedarea");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		xp(prop.getProperty("specializedAreafieldBox")).clear();
		log.info("clearing specializedarea");
		// Search By Experience
		xp(prop.getProperty("experienceFieldbox")).sendKeys(prop.getProperty("experienceSearchvalue"));
		log.info("getting experiencefield");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		xp(prop.getProperty("experienceFieldbox")).clear();
		log.info("clearing experiencefieldbox");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Search By Rate
		xp(prop.getProperty("rateFieldbox")).sendKeys(prop.getProperty("rateSearchvalue"));
		log.info("getting ratefieldbox");
		wait = new WebDriverWait(d, 30);

		
	}

	public static void post() throws Exception {

		/**
		 * @author surya Balapriya work name : postjobs
		 */
		String workingDir;

		workingDir = System.getProperty("user.dir");
		File file = new File(workingDir + "\\Resources\\postJob.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		id(prop.getProperty("postJobs")).click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe2");
		wait = new WebDriverWait(d, 10);
		id(prop.getProperty("jobTitleName")).clear();
		log.info("clearing title");
		id(prop.getProperty("jobTitleName")).sendKeys(prop.getProperty("jobTitle"));
		log.info("getting title");
		// d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		id(prop.getProperty("requiredSkillsName")).clear();
		log.info("clearing skills");
		id(prop.getProperty("requiredSkillsName")).sendKeys(prop.getProperty("requiredSkills"));
		log.info("getting skills");
		// wait = new WebDriverWait(d, 30);
		id(prop.getProperty("preferredSkillName")).clear();
		log.info("clearing preferredskills ");
		// d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		id(prop.getProperty("preferredSkillName")).sendKeys(prop.getProperty("preferredSkill"));
		log.info("getting preferredskills");
		id(prop.getProperty("expLevel")).click();
		log.info("clicking explevel");
		id(prop.getProperty("jobDescriptionName")).clear();
		log.info("clearing jobdescription");
		id(prop.getProperty("jobDescriptionName")).sendKeys(prop.getProperty("jobDescription"));
		log.info("getting jobdescription");
		// d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		id(prop.getProperty("clientName1")).clear();
		log.info("clearing clientname");
		id(prop.getProperty("clientName1")).sendKeys(prop.getProperty("clientName"));
		log.info("getting clientname");
		// wait = new WebDriverWait(d, 30);
		id(prop.getProperty("buttonClick1")).click();
		log.info("clicking button");
		// wait = new WebDriverWait(d, 30);
		id(prop.getProperty("cityName")).sendKeys(prop.getProperty("city"));
		log.info("getting city");
		Thread.sleep(1000);
		css(prop.getProperty("cityList")).click();
		log.info("clicking citylist");
		wait = new WebDriverWait(d, 30);

		new Select(id(prop.getProperty("jobExp1"))).selectByVisibleText("1 Week");
		log.info("selecting jobexp");
		wait = new WebDriverWait(d, 30);
		id(prop.getProperty("consulting")).click();
		log.info("clicking consulting");
		id(prop.getProperty("workAuthori")).click();

		log.info("clicking workauthor");
		wait = new WebDriverWait(d, 30);
		id(prop.getProperty("preferEmp")).click();
		log.info("clicking preferemp");
		id(prop.getProperty("durationName")).clear();
		log.info("clearing duration");
		id(prop.getProperty("durationName")).sendKeys(prop.getProperty("duration"));
		log.info("getting duration");
		// d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Select select = new Select(xp(prop.getProperty("splArea")));
		log.info("selecting splarea");
		Select select1 = new Select(xp(prop.getProperty("splSkills")));
		log.info("selecting splskills");
		for (int i = 0; i <= 27; i++) {
			select.selectByIndex(i);
			d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}

		select.selectByIndex(1);
		select1.selectByIndex(1);

		id(prop.getProperty("saveBtn")).click();
		log.info("clicking savebtn");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		id(prop.getProperty("others")).click();
		log.info("clicking others");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		id(prop.getProperty("domainExpo")).click();
		log.info("domainexpo");
		id(prop.getProperty("domainExpo1")).click();
		log.info("getting domainexpo1");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		id(prop.getProperty("domainExpo2")).click();
		log.info("getting domainexpo2");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		id(prop.getProperty("postMyJob")).click();
		log.info("clicking postmyjob");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("closeBtn")).click();
		log.info("clicking closebutton");
		d.switchTo().defaultContent();
	}

	public static void jobResponse() throws Exception {

		/**
		 * @author Santhalakshmi work name :Jobresponse
		 */

		File file = new File(workingDir + "\\Resources\\jobresponse.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		// jobresponse tab
		css(prop.getProperty("jobResponse")).click();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
	}

	public static void fetchResume() throws InterruptedException, IOException {

		/**
		 * @author Karthigavalli work name :Fetch Resume
		 */

		File file = new File(workingDir + "\\Resources\\fetchResume.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		d.switchTo().defaultContent();

		xp(prop.getProperty("fetch")).click();
		log.info("clicking postmyjob");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe5");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		id(prop.getProperty("key")).sendKeys(prop.getProperty("keyWord"));
		log.info("getting key");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new Select(id(prop.getProperty("area"))).selectByVisibleText("Java, J2EE");
		log.info("getting area");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		new Select(id(prop.getProperty("skill"))).selectByVisibleText("Java Server Side");
		log.info("getting skill");
		Thread.sleep(1000);
		id(prop.getProperty("advancedSearch")).click();
		log.info("clicking advanced search");
		Thread.sleep(1000);
		xp(prop.getProperty("domain1")).click();
		log.info("clicking domain1");
		xp(prop.getProperty("domain2")).click();
		log.info("clicking domain2");
		id(prop.getProperty("country")).click();
		log.info("clicking country");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
		id(prop.getProperty("experience")).click();
		log.info("clicking experience");
		id(prop.getProperty("usExperience")).click();
		log.info("clicking usExperience");
		id(prop.getProperty("aSkill1")).sendKeys(prop.getProperty("skill1"));
		log.info("getting askill1");
		new Select(id(prop.getProperty("year1"))).selectByVisibleText("4");
		log.info("getting year1");
		id(prop.getProperty("aSkill2")).sendKeys(prop.getProperty("skill1"));
		log.info("getting askill2");
		new Select(id(prop.getProperty("year2"))).selectByVisibleText("2");
		log.info("getting year2");
		id(prop.getProperty("aSkill3")).sendKeys(prop.getProperty("skill1"));
		log.info("getting askill3");
		new Select(id(prop.getProperty("year3"))).selectByVisibleText("4");
		log.info("getting year");
		xp(prop.getProperty("save")).sendKeys(prop.getProperty("fetching"));
		log.info("getting save");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new Select(id(prop.getProperty("days"))).selectByVisibleText("90 Days");
		log.info("getting days");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		id(prop.getProperty("fetched")).click();
		log.info("clicking fetched");
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("tabClose")).click();
		log.info("clicking logg");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("tabClose1")).click();
		log.info("clicking log");
	}

	public static void jobs() throws Exception {
		/**
		 * @author DurgaDevi work name :Jobs
		 */

		File file = new File(workingDir + "\\Resources\\myJob.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		css(prop.getProperty("jobMenu")).click();
		log.info("clicking jobmenu");
		wait = new WebDriverWait(d, 30);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");
		xp(prop.getProperty("updatedDate")).sendKeys(prop.getProperty("month"));
		log.info("getting updatedate");
		xp(prop.getProperty("jobTitle")).sendKeys(prop.getProperty("lang"));
		log.info("getting jobtitle");
		xp(prop.getProperty("location")).sendKeys(prop.getProperty("cty4"));
		log.info("clicking location");
		wait = new WebDriverWait(d, 30);

		/**
		 * @author SanthanaLakshmi work name :Applying & Forward
		 */

		xp(prop.getProperty("preview")).click();
		log.info("clicking preview");

		String window1 = d.getWindowHandle();
		System.out.println(window1);
		log.debug("printing window1 output");
		Set<String> windows = d.getWindowHandles();
		Iterator iterator = windows.iterator();
		String x;
		while (iterator.hasNext()) {
			x = iterator.next().toString();

			System.out.println(x);

			// for(String x:windows){
			if (x.equals(window1) == false) {
				d.switchTo().window(x);
				Thread.sleep(5000);
				id(prop.getProperty("applyNow")).click();
				log.info("clicking applynow");
				d.switchTo().defaultContent();
				d.switchTo().frame("applyemailframe");
				wait = new WebDriverWait(d, 30);

				new Select(d.findElement(By.id(prop.getProperty("selectFromProfile"))))
						.selectByVisibleText("Mithilesh Joshi (EXP) [Active]");

				log.info("getting selectfromprofile");
				// xp(prop.getProperty("optionValue")).click();
				// log.info("clicking optionvalue");
				xp(prop.getProperty("cc")).clear();
				log.info("clearing cc");
				xp(prop.getProperty("cc")).sendKeys(prop.getProperty("tooo"));
				log.info("getting cc");
				xp(prop.getProperty("coveringLetter")).click();
				log.info("clicking coveringletter");
				d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				id(prop.getProperty("fileUpload")).clear();
				log.info("clearing fileupload");
				// d.findElement(By.xpath(".//*[@id='uploaddiv']/div/div/div")).click();
				id(prop.getProperty("fileUpload")).sendKeys(workingDir + "\\Resources\\ram.docx");
				log.info("getting file");
				// d.findElement(By.id("uploadvalue2")).sendKeys("C:\\Users\\mag8\\Desktop\\res.docx");
				id(prop.getProperty("sendEmail")).click();
				log.info("clicking sendmail");
				d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				d.switchTo().defaultContent();
				d.switchTo().frame("applyemailframe");
				xp(prop.getProperty("btnClose")).click();
				log.info("clicking btnclose");

				// forward
				Thread.sleep(5000);
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				xp(prop.getProperty("forwardJob")).click();
				log.info("clicking fwdjob");
				d.switchTo().defaultContent();
				d.switchTo().frame("jsfwdjobcontentframe");
				d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				xp(prop.getProperty("toAddr")).sendKeys(prop.getProperty("tooo"));
				log.info("getting toaddr");
				d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				xp(prop.getProperty("sendMail")).click();
				log.info("clicking sendmail");
				d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				d.close();
			}

		}
		// Edit

		/*
		 * @author surya Balapriya work name : edit
		 */
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		d.switchTo().window(window1);
		css(prop.getProperty("jobMenu")).click();
		log.info("clicking jobmenu");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");

		xp(prop.getProperty("edit")).click();
		log.info("clicking edit");
		d.switchTo().defaultContent();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.switchTo().frame("Iframe8");
		id(prop.getProperty("jobTitle5")).clear();
		log.info("clicking jobtitle5");
		id(prop.getProperty("jobTitle5")).sendKeys(prop.getProperty("titleName"));
		log.info("getting jobtitle5");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		id(prop.getProperty("skillReq")).clear();
		log.info("clicking skillreq");
		id(prop.getProperty("skillReq")).sendKeys(prop.getProperty("titleName"));
		log.info("getting skillreq");
		id(prop.getProperty("exLevel")).click();
		log.info("clicking exlevel");
		id(prop.getProperty("exLevel1")).click();
		log.info("clicking exlevel1");
		id(prop.getProperty("exLevel2")).click();
		log.info("clicking exLevel2");
		id(prop.getProperty("exLevel3")).click();
		log.info("clicking exlevel3");
		id(prop.getProperty("exLevel4")).click();
		log.info("clicking exlevel4");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		xp(prop.getProperty("permanentType")).click();
		log.info("clicking Parametertype");
		id(prop.getProperty("work1")).click();
		log.info("clicking work1");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		id(prop.getProperty("preferredEmployment5")).click();
		log.info("clicking PreferredEmployment5");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		new Select(id(prop.getProperty("splArea1"))).selectByVisibleText("Java, J2EE");
		log.info("getting splarear1");
		new Select(id(prop.getProperty("splSkill1"))).selectByVisibleText("Java, J2EE");
		log.info("getting splskill1");
		id(prop.getProperty("domainList0")).click();
		log.info("clicking domainlist0 ");
		id(prop.getProperty("domainList2")).click();
		log.info("clicking domianlist2");
		id(prop.getProperty("preview1")).click();
		log.info("clicking preview1");
		Thread.sleep(1000);

		d.findElement(By.linkText(prop.getProperty("closeButton"))).click();
		log.info("clicking clsbutton");
		Thread.sleep(1000);

		d.switchTo().defaultContent();
		xp(prop.getProperty("matchClose")).click();
		log.info("clicking matchclose");
		xp(prop.getProperty("jobClose")).click();
		log.info("clicking jobclose");

	}

	public static void myAccount() throws Exception {
		/**
		 * @author RamKumar Sastha work name :My Account
		 */
		File file = new File(workingDir + "\\Resources\\myAccount.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		d.switchTo().defaultContent();
		xp(prop.getProperty("myAccount")).click();
		log.info("clicking myaccount");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe9");
		xp(prop.getProperty("txt_Mail")).clear();
		log.info("clearing txtmail");
		xp(prop.getProperty("txt_Mailid")).sendKeys(prop.getProperty("userName"));
		log.info("getting txtmail");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("firstName")).clear();
		log.info("clearing firstname ");
		xp(prop.getProperty("firstName")).sendKeys(prop.getProperty("firstNamevalue"));
		log.info("getting firstname");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("lastName")).clear();
		log.info("clearing lastname");
		xp(prop.getProperty("lastName")).sendKeys(prop.getProperty("lastNamevalue"));
		log.info("getting lastname");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("companyName")).clear();
		log.info("clearing companyname");
		xp(prop.getProperty("companyName")).sendKeys(prop.getProperty("companyNamevalue"));
		log.info("getting companyname");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("country")).sendKeys(prop.getProperty("countryValue"));
		log.info("getting country");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("city")).clear();
		log.info("clearing city");
		xp(prop.getProperty("city")).sendKeys(prop.getProperty("cityValue"));
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("personalId")).clear();
		log.info("clearing personalid");
		xp(prop.getProperty("personalId")).sendKeys(prop.getProperty("personalIdvalue"));
		log.info("getting personalid");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		xp(prop.getProperty("ph_Area")).sendKeys(prop.getProperty("ph_Areavalue"));
		log.info("getting ph area");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("ph_No")).clear();
		log.info("clearing phno");
		xp(prop.getProperty("ph_No")).sendKeys(prop.getProperty("ph_Novalue"));
		log.info("getting phno");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("update")).click();
		log.info("clicking update");
		Thread.sleep(5000);

		d.switchTo().defaultContent();

		css(prop.getProperty("passClick")).click();
		log.info("clicking Passclick");
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe10");

		xp(prop.getProperty("passReset")).sendKeys(prop.getProperty("password"));
		log.info("getting passreset");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		css(prop.getProperty("passReset1")).sendKeys(prop.getProperty("password1"));
		log.info("getting passreset1");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("resetButton")).click();
		log.info("clicking resetbutton");
		Thread.sleep(5000);

		d.switchTo().defaultContent();
		css(prop.getProperty("preference")).click();
		log.info("clicking preferences");
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe11");

		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		css(prop.getProperty("radio2")).click();
		log.info("clicking radio2");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		css(prop.getProperty("radio1")).click();
		log.info("clicking radio1");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		css(prop.getProperty("radio4")).click();
		log.info("clicking radio4");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		css(prop.getProperty("radio3")).click();
		log.info("clicking radio3");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		css(prop.getProperty("radio6")).click();
		log.info("clicking radio6");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		css(prop.getProperty("radio5")).click();
		log.info("clicking radion5");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		css(prop.getProperty("radio_Button")).click();
		log.info("clicking radiobutton");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		xp(prop.getProperty("user")).click();
		log.info("clicking user");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}
}
