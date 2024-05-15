# Overview
This is a Java+Appium+TesNG framework designed to test native and hybrid applications developed for IOS and ANDROID platforms.

## Java JDK and Appium setup
- Download JDK from Oracle: stable Java SE 11 or higher
- Install Appium: “sudo npm install -g appium”
- Install Appium doctor: “sudo npm i -g appium-doctor” 
- Check the environment setup health: run in terminal "appium-doctor"


## ANDROID env setup & configuring Emulators 
- Install Android studio 
- Set Java & Appium HOME and PATH variables in .zshenv file (or .bash_profile etc. ) 
- Create a zsh_profile file: run "vi ~/.zshenv" in terminal
- Open the file open: run  "~/.zshenv" in terminal
- Add env variables to .zshenv as shown below:
 export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home
 export ANDROID_HOME=/Users/<username>/Library/Android/sdk
 export PATH=$PATH:$ANDROID_HOME/platform-tools
 export PATH=$PATH:$ANDROID_HOME/tools
 export PATH=$PATH:$ANDROID_HOME/tools/bin
 export PATH=$PATH:$ANDROID_HOME/emulator
- Save the file
- Source the file: run " source  ~/.zshenv " in terminal
- Open Android Studio, go to Virtual Device Manager, install at least 2 builds, R and Q
- Download apk for the app which you will automate or generate apk of the app (copy the url from Google play, use the link to generate APK on apk generator sites)
- Install ANDROID driver UIAutomator2
   - run in terminal: "appium driver install uiautomator2"

## IOS env setup and configuring Simulators
- Download X-code app from App store
- Install the X-code: run in terminal "xcode-select --install"
- Install Carthage (dependency manager for macOS & IOS)
  - run in terminal "brew install carthage"
  - Note: If you don't have homebrew in your machine, then install homebrew
    - run in terminal: "/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"
- Install 2 IOS virtual devices for Xcode, 1 for Manual and 1 for local automation
  - Go to ->  X-Code >Windows > Devices & Simulator> Simulators
- Install IOS driver XCUITest
  - run in terminal: "appium driver install xcuitest"


## Start Appium server locally
- run in terminal: "appium -p 4724" (desired port for locally run is 4724)


## Appium Inspector setup
- Download and install Appium inspector from official GitHub page:  https://github.com/appium/appium-inspector
- Appium Inspector is intended to use for finding locator, appPackage, appActivity, contexts element/screen dimension etc.

  ## Launch ANDROID app in Appium Inspector given capabilities
   - {
   - "appium:platformName": "Android",
   - "appium:platformVersion": "11.0",
   - "appium:deviceName": "Pixel_11",
   - "appium:app": "appPath",
   - "appium:automationName": "UIAutomator2"
  -  }
- Start session

  ## Launch IOS app in Appium Inspector with given capabilities
  - {
  - "appium:platformName": "IOS",
  - "appium:deviceName": "iPhone 14",
  - "appium:platformVersion": "16.0",
  - "appium:automationName": "XCUItest",
  - "appium:app": iosAppPath,
  - }
- Start session


   ## Note: 
To land to the specific screen/page directly, following capabilities should be included:
   - “appium:appPackage” : “appPackageValue”
   - “appium:appActivity” : “appActivityValue"

## Run tests in BrowserStack with Parallel execution
- Create a BrowserStack account (or use existing BrowserStack of current client/company)
- Upload the app to the BrowserStack and copy app location link (ex: bs://51a13558a3e018454b141de69736b26f4f7d4c79)
- Install BrowserStack plugin to your IDE (Eclipse, IntelliJ etc. )
- Generate browserstack.yml file for the project
  - right click on project -> click BrowserStack -> Integrate with App Automate SDK
  - provide userName and accessKey and click OK
  - In the project directory will be generated new file called "browserstack.ym" and that file will have available device details along with BS_Username and BS_accessKey, later sensitive details can be passed from GitHub secrets in runtime for security purposes. Initially there will be 3 available devices, but later we can add new device to the BS account, so we can run our tests in desired devices
- Set "app" section to read your app location link in browserstack.yml
  - app: bs://51a13558a3e018454b141de69736b26f4f7d4c79 (this field is different for different users)
