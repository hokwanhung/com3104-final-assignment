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
  - [License](#license)
  - [Credits](#credits)
  - [FAQ (Frequently Asked Questions)](#faq-frequently-asked-questions)
    - [1. Why is the `.gitignore` file designed as the project shows?](#1-why-is-the-gitignore-file-designed-as-the-project-shows)


## Installation

## Usage

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