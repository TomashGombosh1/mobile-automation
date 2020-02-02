 # Setup and launch project using maven 
 
 ###Install and Setup Java
  
 1. Install Java 8 on your local machine. To download Java 8 jdk click on that and install java according to yours PC OS. 
 1. To test the installation of Java on your machine, open cmd.exe and at the command line write ‘java -version’ and send key ‘Enter’ from your keyboard. If Java installed successfully you should see a message on your command line as java version
 1. To set up JAVA_HOME follow next steps:
     1. Click left button of the mouse on the 'My computer' icon and choose 'Settings' in the drop-down list;      
     1. In the 'System' window click 'Additional parameters of the system';
     1. Click on button 'Environment variables';
     1. In the modal window 'System variables' click button 'Add';
     1. In the field 'Variable name' fill 'JAVA_HOME';
     1. In the field 'Variable value' fill <path to jdk>;
     1. Click 'OK' button;
     1. Open 'PATH' in the 'System variables'; 
     1. In the bottom of the list add %JAVA_HOME%\lib, %JAVA_HOME%\bin and %JAVA_HOME%\jre;
     1. To check the acceptance of changes, open the command line of your machine and run the following 'path' command, at the end of the change you need to set <path to jdk>\lib,<path to jdk>\bin and <path to jdk>\jre
     1. If path not show in the command line. Restart you work PC, if that not be helpful delete java and repeat steps i-x
     
 ###Install and Setup Git
     
 1. Download and install Git
 1. Open cmd.exe in PC
 1. Copy command from main page of project remote repository
 1. Wait that project cloning to local machine
 
 ###Install and Setup Appium for the test running
 1. Download latest Node.js from the official site
 1. Install Node.js
 1. Open cmd.exe 
 1. Launch installation of the appium using command _npm install -g appium_
 
 ###Install and Setup Appium desktop for the element inspection
 1. Install Appium Destop to the you OS
 1. Set Capabilites for the launching iOS or Android device to the inspecting elements
 
 
 ###Install and Setup Maven
 
 1. Download and install Maven to the Program Files(x86)
 1. Set MAVEN_HOME and M2_HOME as in the step to setup JAVA_HOME
 1. Add to the path Maven bin and lib folders
    
 ###Install and setup Android sdk for the launching Android project
 1. Download Android Studio
 1. Install Android Studio
 1. Setup ANDROID_HOME using Android SDK folder as in the steps to setup JAVA_HOME 
 1. Add to the path Android  platform-tools and tools folder
 1. Setup Android Virtual devices:
    1. Run avd manager through android studio(Android Studio - Tools -Android - Avd Manager)
    1. Create desired virtual device
    1. run avd through android studio avd manager or _cmd -> cd %android_home%/tools  -> emulator @<avd_name>_
    1. Add emulator name to the Project config file
 1. Setup real device:
       1. turn on Developer options on device -> usb debugging
       1. cmd  -> adb devices	to see list of attached devices
       1. Add devices name to the Project config file

 ###Launching iOS project
1. iOS project can be launch only on the MacOS
1. 


###Start test project
1. Open ConfigProjectLocal.properties and change Environment, PlatformName and Base username and password for you testing
1. Open cmd.exe in PC
1. Go to the dir of the project using command line
1. Start test using command 'mvn clean test'
1. After finishing running suite use command 'mvn allure:serve' to see report 
      
      
# Rules of the automation process flow in the project
      
### Updating ChangeLog
Adding automated test cases to the changelog should be done using the following rules:
1. Add Section to what attached that test case
1. Add Name of the test case
1. Add Link to the Jira 
1. Add by whom was done that test cases
      
###_Example:_ 
|Section| Name| Link| Tester|
      
      
###Working with test documentation
AQA Engineer should start development with test section or cases that
MQA Engineer prioritized first. MQA Engineer should be guaranteed that all documentation is up to date and defect or blockers not present in the section. AQA Engineer development ATC using step-by-step development method, it means that step in MTC is present in the ATC. All test methods, description, the suites and all page objects, elements, methods have names according to 3 chapters of that document. 
If documentation is not actual or some defects is found AQA Engineer should be informed MQA Engineer about that. Test cases should be marked as a blocked and AQA Engineer can be developed other test cases. Prohibited developed test cases that have status blocked or is not up to date. If documentation is updated AQA Engineer should be informed by the MQA Engineer and that should initialize maintenance in the develop branch. Prohibited initialize maintenance if not need or without knowing of MQA Engineer. 
      
      
###Working with opening pull request
All changes to the main branches(develop or master) should be done using PR. PR should be opened using bitbucket. 
PR should be opened if next conditions are fulfilled:
1. All page objects, elements, methods have names according to 3 chapters of that document;
1. The test is written according to the Manual Test Case step by step
1. The test is passed on all browser regarding MQA Engineer or Customer requirements
    
PR should be reviewed by Tech Lead and MQA Engineer and have approved by both. If in the PR would be conflicts those should be resolved step by step. PR should be updated if Tech Lead or MQA Engineer find some inconsistencies or inaccuracies. All inconsistencies or inaccuracies should be written as a comment to the PR or specific method, class, test or etc. PR should be merged only after approval process in the finish. Pushed pull request into branch without approving there is a violation of the Swan 
      
      
###Working with refactoring or maintenance project
Refactoring of the project should be initialized by AQA Engineer if need to implement new technologies or some test need to optimization. 
If the project in the state 'In Refactoring' MQA Engineer and Customer should be informed about that. Also, need to inform them about the reason of refactoring. 
After close refactoring project should be open PR, according to 4.2 chapters of that document. 
Maintenance of the project should be initialized by MQA Engineer if need to implement new technologies or some test need to optimization. 
If the project in the state 'In Maintenance'  Customer should be informed about that. Also, need to inform them about the reason for maintenance. 
After close maintenance project should be open PR, according to 4.2 chapters of that document.
      
###Working with automation regression testing
During the automated regression testing, AQA Engineer should be open Pull Request (PR) from develop branch to the master branch. 
After approving it by Tech Lead or some of the team member, that should be as a start of automated regression testing. Automated regression testing analyze should be done by AQA Engineer. 
AQA Engineer creates a bug report about what of the test have bugs or some of the java.com.mobile.automation.framework.tests has a problem on the automation side. After that, a bug report should be presented to MQA Engineer or to the customer according to that a test plan of the project. 
That should be a finish of automated regression testing
