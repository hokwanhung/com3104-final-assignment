# com3104-final-assignment

com3104, Digital Games and Mobile Computing, is a course offered by The Hang Seng University of Hong Kong, and taught by Professor Dr. Aileen Hou. 

According to the [university website](https://www.hsu.edu.hk/en/academic-programmes/undergraduate/ahcc/academic-structure/?shortname=COM3104&cid=2100),

`
This module aims to provide students with a holistic understanding of digital game design technique, mobile computing and mobile software development platforms, and to familiarise students with the concepts and ideas of mobile application development. Various design skills, gamification techniques, and game technologies are introduced to students. Students will apply a variety of programming and integrated digital game development tools to design and implement digital games.
`

## Table of Content
- [com3104-final-assignment](#com3104-final-assignment)
  - [Table of Content](#table-of-content)
  - [Installation](#installation)
  - [Usage](#usage)
    - [Program Structure](#program-structure)
    - [Quick Start](#quick-start)
    - [Demo](#demo)
  - [License](#license)
  - [Credits](#credits)
  - [FAQ (Frequently Asked Questions)](#faq-frequently-asked-questions)
    - [1. Why is the `.gitignore` file designed as the project shows?](#1-why-is-the-gitignore-file-designed-as-the-project-shows)


## Installation

The program is transferred from local repositories to `Git` repositories after half a year, demonstrating the original complete mobile `Android Java` app for a Event-booking application.

IDE(Integrated Development Environment): `Android Studio` for the complete mobile development.

![Alt text](/markdown_images/android-studio.png)

Other tools:

`Firebase Realtime Database` for `NoSQL` cloud database hosting.

![Alt text](/markdown_images/realtime-database.png)


## Usage

### Program Structure
```
com3104-final-assignment
 ┣ app
 ┃ ┣ src
 ┃ ┃ ┣ androidTest
 ┃ ┃ ┃ ┗ java
 ┃ ┃ ┃ ┃ ┗ com
 ┃ ┃ ┃ ┃ ┃ ┗ example
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ eventup
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ ExampleInstrumentedTest.java
 ┃ ┃ ┣ main
 ┃ ┃ ┃ ┣ java
 ┃ ┃ ┃ ┃ ┗ com
 ┃ ┃ ┃ ┃ ┃ ┗ example
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ eventup
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ calendar
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ CalendarActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ CalendarEvent.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ CalendarEventAdapter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ event
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ Event.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ EventAdapter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ EventDetailsActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ EventListActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ post
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ PostEvent.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ PostEventActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ status
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ StatusDetailsActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ StatusEvent.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ StatusEventAdapter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ StatusListActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ HomeActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ LoginActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ MemoActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ SignUpActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ UserProfile.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ WallpaperActivity.java
 ┃ ┃ ┃ ┣ res
 ┃ ┃ ┃ ┃ ┣ drawable
 ┃ ┃ ┃ ┃ ┃ ┣ bg1.jpeg
 ┃ ┃ ┃ ┃ ┃ ┣ bg10.jpg
 ┃ ┃ ┃ ┃ ┃ ┣ bg2.jpeg
 ┃ ┃ ┃ ┃ ┃ ┣ bg3.jpeg
 ┃ ┃ ┃ ┃ ┃ ┣ bg4.jpeg
 ┃ ┃ ┃ ┃ ┃ ┣ bg5.jpeg
 ┃ ┃ ┃ ┃ ┃ ┣ bg6.jpeg
 ┃ ┃ ┃ ┃ ┃ ┣ bg7.jpeg
 ┃ ┃ ┃ ┃ ┃ ┣ bg8.jpeg
 ┃ ┃ ┃ ┃ ┃ ┣ bg9.jpeg
 ┃ ┃ ┃ ┃ ┃ ┣ black_bt.png
 ┃ ┃ ┃ ┃ ┃ ┣ blue_bt.png
 ┃ ┃ ┃ ┃ ┃ ┣ btn_red.png
 ┃ ┃ ┃ ┃ ┃ ┣ calendar_bt.png
 ┃ ┃ ┃ ┃ ┃ ┣ eventstatus_bt.png
 ┃ ┃ ┃ ┃ ┃ ┣ ic_launcher_background.xml
 ┃ ┃ ┃ ┃ ┃ ┣ login_wallpaper.jpg
 ┃ ┃ ┃ ┃ ┃ ┣ logout_icon.png
 ┃ ┃ ┃ ┃ ┃ ┣ memo_bt.png
 ┃ ┃ ┃ ┃ ┃ ┣ post_bt2.png
 ┃ ┃ ┃ ┃ ┃ ┣ profile_icon.png
 ┃ ┃ ┃ ┃ ┃ ┣ red_bt.png
 ┃ ┃ ┃ ┃ ┃ ┣ registration_wallpaper.jpg
 ┃ ┃ ┃ ┃ ┃ ┣ search_bt.png
 ┃ ┃ ┃ ┃ ┃ ┣ setting_bt.png
 ┃ ┃ ┃ ┃ ┃ ┣ test_bt.png
 ┃ ┃ ┃ ┃ ┃ ┗ wallpapaer_bt.png
 ┃ ┃ ┃ ┃ ┣ drawable-v24
 ┃ ┃ ┃ ┃ ┃ ┗ ic_launcher_foreground.xml
 ┃ ┃ ┃ ┃ ┣ layout
 ┃ ┃ ┃ ┃ ┃ ┣ activity_calendar.xml
 ┃ ┃ ┃ ┃ ┃ ┣ activity_event_details.xml
 ┃ ┃ ┃ ┃ ┃ ┣ activity_event_list.xml
 ┃ ┃ ┃ ┃ ┃ ┣ activity_home.xml
 ┃ ┃ ┃ ┃ ┃ ┣ activity_login.xml
 ┃ ┃ ┃ ┃ ┃ ┣ activity_memo.xml
 ┃ ┃ ┃ ┃ ┃ ┣ activity_post_event.xml
 ┃ ┃ ┃ ┃ ┃ ┣ activity_signup.xml
 ┃ ┃ ┃ ┃ ┃ ┣ activity_status_details.xml
 ┃ ┃ ┃ ┃ ┃ ┣ activity_status_list.xml
 ┃ ┃ ┃ ┃ ┃ ┣ activity_wallpaper.xml
 ┃ ┃ ┃ ┃ ┃ ┣ event_item.xml
 ┃ ┃ ┃ ┃ ┃ ┣ item_event.xml
 ┃ ┃ ┃ ┃ ┃ ┗ status_item.xml
 ┃ ┃ ┃ ┃ ┣ mipmap-anydpi-v26
 ┃ ┃ ┃ ┃ ┃ ┣ ic_launcher.xml
 ┃ ┃ ┃ ┃ ┃ ┗ ic_launcher_round.xml
 ┃ ┃ ┃ ┃ ┣ mipmap-hdpi
 ┃ ┃ ┃ ┃ ┃ ┣ ic_launcher.webp
 ┃ ┃ ┃ ┃ ┃ ┗ ic_launcher_round.webp
 ┃ ┃ ┃ ┃ ┣ mipmap-mdpi
 ┃ ┃ ┃ ┃ ┃ ┣ ic_launcher.webp
 ┃ ┃ ┃ ┃ ┃ ┗ ic_launcher_round.webp
 ┃ ┃ ┃ ┃ ┣ mipmap-xhdpi
 ┃ ┃ ┃ ┃ ┃ ┣ ic_launcher.webp
 ┃ ┃ ┃ ┃ ┃ ┗ ic_launcher_round.webp
 ┃ ┃ ┃ ┃ ┣ mipmap-xxhdpi
 ┃ ┃ ┃ ┃ ┃ ┣ ic_launcher.webp
 ┃ ┃ ┃ ┃ ┃ ┗ ic_launcher_round.webp
 ┃ ┃ ┃ ┃ ┣ mipmap-xxxhdpi
 ┃ ┃ ┃ ┃ ┃ ┣ ic_launcher.webp
 ┃ ┃ ┃ ┃ ┃ ┗ ic_launcher_round.webp
 ┃ ┃ ┃ ┃ ┣ values
 ┃ ┃ ┃ ┃ ┃ ┣ colors.xml
 ┃ ┃ ┃ ┃ ┃ ┣ strings.xml
 ┃ ┃ ┃ ┃ ┃ ┗ themes.xml
 ┃ ┃ ┃ ┃ ┗ values-night
 ┃ ┃ ┃ ┃ ┃ ┗ themes.xml
 ┃ ┃ ┃ ┗ AndroidManifest.xml
 ┃ ┃ ┗ test
 ┃ ┃ ┃ ┗ java
 ┃ ┃ ┃ ┃ ┗ com
 ┃ ┃ ┃ ┃ ┃ ┗ example
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ eventup
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ ExampleUnitTest.java
 ┃ ┣ .gitignore
 ┃ ┣ build.gradle
 ┃ ┗ proguard-rules.pro
 ┣ gradle
 ┃ ┗ wrapper
 ┃ ┃ ┣ gradle-wrapper.jar
 ┃ ┃ ┗ gradle-wrapper.properties
 ┣ .gitignore
 ┣ build.gradle
 ┣ gradle.properties
 ┣ gradlew
 ┣ gradlew.bat
 ┣ README.md
 ┗ settings.gradle
```

### Quick Start

To run the code, it is important to have the `Firebase` set up. Access the [Firebase Console](https://console.firebase.google.com/) and create a `Firebase` account with any private `Google` account.

Then add a new project with default configurations.

![Alt text](/markdown_images/add-project.png)

Inside the navigation panel, access the `Project settings` options near the `Project Overview`. Then, click on the `Service accounts` and select `Java` from `Firebase Admin SDK`. 

![Alt text](/markdown_images/service-accounts.png)

After generating the new private key, rename it to `google-services.json` and put it under `/app`.

The setup should be ready afterwards.

### Demo

![Alt text](/markdown_images/login-signup.png)

![Alt text](/markdown_images/main.png)

## License

N/A

## Credits

N/A

## FAQ (Frequently Asked Questions)

### 1. Why is the `.gitignore` file designed as the project shows?

Originally, `Android Studio` would generate a `.gitignore` file for `Git` usages. The codes are shown as follow:

```
*.iml
.gradle
/local.properties
/.idea/caches
/.idea/libraries
/.idea/modules.xml
/.idea/workspace.xml
/.idea/navEditor.xml
/.idea/assetWizardSettings.xml
.DS_Store
/build
/captures
.externalNativeBuild
.cxx
local.properties
```

However, after visited multiple websites and references, it appears that the below two `stackoverflow` answers to the question of ["What should be in my .gitignore for an Android Studio project?"](https://stackoverflow.com/q/16736856/14499516) are more comprehensive/suitable for this project, namely [Lior lluz](https://stackoverflow.com/a/17803964/14499516) and [Phil](https://stackoverflow.com/a/21049338/14499516). 

Among the two answers, the first one are chosen because it demonstrates a even clearer structure on `Github` when users examines the repository, as all files or folders that are locally dependent or can be regenerated are all omitted.