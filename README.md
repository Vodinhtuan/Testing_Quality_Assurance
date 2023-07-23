# Testing_Quality_Assurance
IntelliJ IDEA provides robust support for testing and Quality Assurance. It integrates popular testing frameworks and offers tools to detect bugs and optimize source code quality.

I.	Introduction to selenium:
Selenium is a free open-source library that supports automated testing for web applications across different browsers and platforms. It can be combined with programming languages to create automation testing scripts for web browsers.
Selenium is a free open-source automated testing suite for web applications across different browsers and platforms. Selenium focuses solely on automating web-based applications. Testing performed using the Selenium tool is commonly referred to as Selenium Automation Testing. Selenium is not just a single tool; it is a software suite, each component of which caters to different testing needs of an organization. It consists of four components:
•	Selenium Integrated Development Environment (Selenium IDE)
•	Selenium Remote Control (Selenium RC)
•	Selenium WebDriver
•	Selenium Grid
 
	Currently, Selenium RC and Selenium WebDriver have been merged into a single framework to form Selenium 2 (Selenium 1 refers to Selenium RC).
II.	Introduction to Selenium Integrated Development Environment (Selenium IDE):
Selenium Integrated Development Environment (IDE) is the simplest framework in the Selenium suite, and it is the easiest part to learn. It is a browser plugin that can be easily installed like other plugins. However, due to its simplicity, the IDE tool is mainly used as a prototyping tool. If you want to create more advanced test cases, you can use Katalon Studio as an alternative tool or combine Selenium WebDriver with programming languages.
	Advantages:
o	Easy installation and usage.
o	Does not require programming skills; users only need to have some knowledge of HTML and DOM.
o	Test cases created in Selenium IDE can be exported for use in Selenium WebDriver or Selenium RC.
o	Provides reporting functionality and necessary support while using.
o	Can be integrated with various extensions.
	Disadvantages:
o	Since it is an extension, it can only be installed in browsers.
o	It is primarily designed for creating simple tests or prototype tests.
o	The IDE lacks the ability to perform complex calculations or conditional statements.
o	Performance may be slower compared to WebDriver and Selenium RC.

III.	Introduction to Selenium Remote Control (Selenium RC):
Selenium RC (Remote Control) has been a leading testing framework in the Selenium project for a long time. It is the first tool that allowed users to perform automated web testing using their preferred programming language. Since version 2.25.0, RC supports the following programming languages:
•	Java
•	C#
•	PHP
•	Python
•	Perl
•	Ruby
	Advantages:
o	Runs on different browsers and operating systems.
o	Supports looped operations and conditions.
o	Supports newer browsers.
o	Executes tests faster than Selenium IDE.
o	Can support data-driven testing.
o	Provides a comprehensive API.
	Disadvantages:
o	More complex installation compared to Selenium IDE.
o	Requires Selenium RC Server to run tests.
o	Browser interactions may be less realistic.
o	Results may not be compatible and rely on JavaScript.
o	Slower execution time compared to WebDriver.
o	Requires programming knowledge.
IV.	Introduction to Selenium WebDriver:
WebDriver has proven to be superior to both Selenium IDE and Selenium RC in many aspects. It adopts a modern and stable approach to browser automation. Unlike Selenium RC, WebDriver does not rely on JavaScript for automation but directly communicates with the browser. The supported programming languages are the same as those in Selenium RC:
•	Java
•	C#
•	PHP
•	Python
•	Perl
•	Ruby
	Advantages:
o	Simpler installation compared to Selenium RC.
o	Enables direct interaction with the browser.
o	Browser interactions mimic real user actions.
o	Faster execution speed compared to Selenium IDE and RC.
o	Capable of testing most components on the web, excluding some components that should not be automated (which will be discussed later in the learning process).
	Disadvantages:
o	More complex installation compared to Selenium IDE.
o	Requires users to have programming skills.
V.	Introduction to Selenium Grid:
Selenium Grid is a tool used in conjunction with Selenium RC to execute tests in parallel across different machines and browsers simultaneously. Parallel execution means running multiple tests at the same time.
•	Features:
o	Allows concurrent execution of tests across multiple browsers and environments.
o	Saves a significant amount of time.
o	Utilizes the concept of a hub-and-nodes. The hub acts as a central source for Selenium commands, with each connected node being a separate machine.
o	Here's how you can set up a Selenium hub to run multiple tests across different machines and browsers simultaneously. Selenium Grid enables you to run test cases in parallel, meaning different test cases can be executed simultaneously on remote machines.
•	This brings several advantages:
o	If you have a large test dataset or slow-running test cases, you can significantly improve their performance by using Selenium Grid. It distributes the test cases to be executed concurrently on different machines. In this way, you can leverage remote resources and execute them simultaneously.
 
o	In some cases, Selenium Grid can improve the execution time for parallel test cases. If you have limited experience with programming or scripting languages, you can still use Selenium Grid to familiarize yourself with Selenium commands.
VI.	Notes on Browser and Environment Support:
	Selenium IDE	WebDriver
Browser support	Mozilla Firefox	-	Internet Explorer versions 6 to 11, both 32 bit and 64 bit.
-	Microsoft Edge version 12.10240 or later (partial functionality is under development)
-	Firefox 3.0 or later
-	Google Chrome 12.0 and later.
-	Opera 11.5 and up.
-	Android -2.3 or later for phones and tablets (devices & emulators).
-	iOS 3+ for phones (devices and emulators) and 3.2+ for tablets (devices and emulators).
-	HtmlUnit 2.9 or later.
Operating system	Windown, Mac OS X, Linux	All operating systems where the above browsers can run.
VII.	Step-by-step Demonstration Selenium WebDriver:
1.	Download Chrome driver for Selenium:
-	You know that selenium is a tool that basically interacts with browsers to test your web applications.
-	But selenium cannot do all these tasks on its own. It needs some help from the browser side as well, to perform all these tasks. So, in that sense, chrome driver is what helps selenium perform these actions on Chrome browser. In more technical terms, ChromeDriver is a standalone server which implements WebDriver’s wire protocol for Chrome.
a.	Open ChromeDriver page – https://chromedriver.chromium.org/home
-	This page provides the latest beta and stable ChromeDriver release information.
 
b.	Click on Downloads link. Based on the version of Chrome browser you have on your machine, click on the corresponding ChromeDriver version: 
 
c.	Assuming you clicked on the link for ChromeDriver 110, you will be navigated to ChromeDriver download page which contains ChromeDriver for Mac, Windows and Linux operating systems.
 
d.	Click on chromedriver_win32.zip to download ChromeDriver for Windows.
e.	Once you download the zip file, unzip it to retrieve chromedriver.exe.
f.	With this, we complete the download process for ChromeDriver.	
2.	Configure Selenium with Intellij
a.	Open Intellij IDE
 
b.	Here is your screen
 
c.	and then setup to install selenium library into your intellij tool following this video tutorial
link
d.	Copy and past Chrome Driver in package Executables
 
e.	right click on package Tests
 
f.	Select Mark Directory as Test Sources Root
 
g.	Navigate to the directory with the path Test\Constant\Constant and assign the URL link of the website to be tested.
 
h.	Locate the component to be tested using xpath in FileDowloaderPage class
i.	Demo demonstration xpath, first we need open the website that we want to test. link
 
j.	Click F12 or open inspect tab and then click on Elements and  click Ctrl + F to open Xpath input and search the item.
 
k.	
 
l.	Go to the class FileDownloadTest.java.
 
3.	Debug and check result
 
4.	Result
 

