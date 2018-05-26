# DigiBP Säntis Incident Management [![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
```
________  .__       .______________________    _________  _ _  __  .__        
\______ \ |__| ____ |__\______   \______   \  /   _____/ _____/  |_|__| ______
 |    |  \|  |/ ___\|  ||    |  _/|     ___/  \_____  \ /    \   __\  |/  ___/
 |    `   \  / /_/  >  ||    |   \|    |      /        \   |  \  | |  |\___ \ 
/_______  /__\___  /|__||______  /|____|     /_______  /___|  /__| |__/____  >
        \/  /_____/            \/                    \/     \/             \/ 
```                                                                       
                                                                          
This repository contains an incident management workflow running on [Camunda BPM](https://docs.camunda.org). This repository is part of the group assignment of the Digitalization of the Business Processes (SS18) Module at the FHNW.

*Authors*
* Jaime Ramirez, [jaime.ramirez@students.fhnw.ch](mailto:jaime.ramirez@students.fhnw.ch)
* Moritz Armingeon, [moritz.armingeon@students.fhnw.ch](mailto:moritz.armingeon@students.fhnw.ch)
* Joël Schmid, [joel.schmid@students.fhnw.ch](mailto:joel.schmid@students.fhnw.ch)

## Disclaimer
We assume that the reader is familiar with BPMN 2.0. The processes and their flows are not described or explained in this project. 

## Methodology and approach

The present project was approached according to the KISS (keep it simple, stupid) principle. With the KISS principle, a simple solution can be sought to solve a required problem. In addition to the KISS principle, the project team has chosen the agile approach to ensure the development and finalization of the project.

### Design approach
Already after the first lesson, we could execute the first workflow. Although it was not very rich in functionality, it was a valuable experience and thought the group the new technologies. First documentation and design plans were drawn, and first tests were executed. Every lecture followed this principle: Every lesson in class was one complete iteration or development sprint.

### Collaboration
Git version control system was used in order to work collaborative on the project. The GitHub platform enabled storage of the development artefacts, documentation and test management.

We work with two Heroku instances and two GitHub Repositories. Both GitHub and Heroku pair up between each other.
- 1 Camunda / Tomcat: This instance holds the Camunda codebase. Camunda be tested locally on the developer's machine and then, after committing, is automatically deployed to Heroku
- 2 Web Form / PHP: This instance contains the web-based components of our solution: The web-form, status page and tableau dashboards. After committing, it is also automatically deployed to Heroku

### Testing
In order to minimalize defects, many functional tests were carried out. We created test-cases from an external view (black box) as well as testing every decision path.
Detected issues were tracked with the Github issue management system.

### Project Management
Tasks were tracked within this documentation. A flat hierarchy without designated project leader was chosen.

## Incident Process Idea - Process Description (Incident Management Workflow)
This chapter describes the basic idea behind the incident process we have selected. 
### Process Summary
![Media Flows](https://github.com/DigiBP/digibp-saentis/blob/master/pics/BigPicture_v2.png)
We have implemented an incident management process. The incident management system is run by a fictional company “Säntis Corporation” and incidents are filed by customer of Säntis – both, external and internal. Incident managers working for Säntis work on resolving these issues.
We have three main strategies to open a ticket:
* **e-Mail:** Send an e-Mail to the support address and automatically a process is triggered
* **Web form:** Fill out the web-form describing the ticket
* **Camunda:** Create the issue directly in Camunda. For example, issues received by phone can then directly entered
Note that these medias are all bound to the process engine by a REST interface and therefore could be easily extended by further channels.

The **communication** with the user is then always by e-Mail. In case the incident identified is critical, which concerns a larger user base, a tweet is sent out, in order to quickly inform customers, that Säntis is working on resolving the issue. This should reduce the amount of similar issues received.

Status **report** on the ticket is provided by a reporting suite. Two general views are provided: The internal view, for ticket managers and their supervisors, giving an overview for all tickets and a personal view for the customer, where he may consult his ticket status.
### Process Description

For this project we have adhered to the ITIL incident management standard. We have focused on the following four sub-processes. 

- 1 Incident Creation Process
- 2 Incident Identification Process (Incident Categorization and Incident prioritization) 
- 3 Incident Resolution Process

![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/Incident_Management_ITIL_2.jpg)

This screenshot shows the ITIL incident management process. You can see the sub-processes (outlined in red) that we used for our project. 

### Overall Process
The following image shows a simple visualization of our overall process. This process is divided in four sub processes.
- Create Issue
- Issue Identification
- Issue Diagnosis
- Issue Resolution

| **Overall Process** |
| ------------------ |
|![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/00_Overall.png) |

### Issue Creation Process
The following image shows a simple visualization of our issue creation process.

| **Issue Creation Process** |
| ------------------ |
|![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/01_IncidentCreation.png) |

### Issue Identification
The following image shows a simple visualization of our identification process.

| **Identification Process** |
| ------------------ |
|![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/02_IncidentIdentification.png) |

### Issue Diagnosis Process
The following image shows a simple visualization of our diagnosis process.

| **Diagnosis Process** |
| ------------------ |
|![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/03_IncidentDiagnosis.png) |

### Issue Resolution Process
The following image shows a simple visualization of our resolution process.

| **Resolution Process** |
| ------------------ |
|![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/04_IncidentResolution.png) |

# Camunda Processes in Detail
This chapter will explain in detail the Camunda processes.

For the following applications, an incident can be filed:
 - None
- Excel
- Word
- Lotus Notes
- Outlook
- Website
- SAP

Depending on which application is affected, different processes or flows are started. Not all possibilities will be shown in the upcoming documentation. If it is an **SAP** or **Microsoft (Outlook)** incident, it is forwarded to the "external" support.  All other incidents are reprioritized and the impact is redefined. 


## Incident Identification - Is the Incident Supported or not?
As soon as the incident process has started (all necessary information has been entered) the first question comes up as to whether the incident is supported or not.

![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentSupportedYesOrNo.png)

**Is the Incident Supported**
If the incident is supported, the user in Camunda is asked to enter further information about the incident.

![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentIsSupported.png)

**Is the Incident Supported and Critical**
If the system ID and the affected application have been entered, it must be decided whether the incident is critical or not.

![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IsTheIncidentCritical.png)

**Is the Incident Supported, Critical and the Impact is Critical**
It must be selected again whether the impact is critical or not. If critically rated, a Twitter message will be sent.

![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IsTheIncidentCritical2.png)

**The Incident is not Supported**
If the Incident is not supported, the incident is rejected. 

![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentIsNotSupported.png)
----------------------------------------------------------------------------------------------------------------------------------------

## Step by Step Guide
The incident can be started in several ways (see picture Big Picture). In this chapter all possibilities are explained step by step. 
![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/BigPicture_v1.png)
Picture description: Big Picture

### Create an incident with Camunda

| **1 Step** |
| ------------------ |
|1. Click the following URL to go to our Heroku website: https://saentisincident.herokuapp.com/app/welcome/default/ 2. login with demo for the Username and demo for the Password 3. Click on task list 4. After that click on start Overall Process ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/StartProcess.png) |

| **2 Step - Incident Creation** |
| ------------------ |
|1. Fill out all fields (As in the example) and click on Start to start the Process ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentCreationMask.png) |

| **3 Step - Incident Identification** |
| ------------------ |
|1. After the second step follows the incident identification process. The incident manager confirms whether the incident is supported. In our case yes - so the check mark at "Is this Incident supported" is set and this is confirmed with the "complete" button. ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentIdentification.png) |

| **4 Step - Add Incident Details** |
| ------------------ |
|1. At this point, the incident manager can add the "Affected Application" and the SystemID. This additional information is confirmed with the "Complete" button. After confirmation, the incident is terminated in our case and passed on to the next position.  ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/AddIncidentDetails.png) |

----------------------------------------------------------------------------------------------------------------------------------------

### Generate a tweet if the incident is Critical (Impact) with Camunda

| **1 Step - Login in to Camunda** |
| ------------------ |
|1. Click the following URL to go to our Heroku website: https://saentisincident.herokuapp.com/app/welcome/default/ 2. login with demo for the username and demo for the password 3. Click on task list 4. After that click on start overall process ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/StartProcess.png) |

| **2 Step - Incident Creation (with Crititcal Impact)** |
| ------------------ |
|1. Fill out all fields (As in the example) and click on start to start the process 2. The tweet is only triggered if the impact status is on CRITICAL. ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentCreationMaskCritical.png) |

| **3 Step - Incident Identification (with Crititcal Impact)** |
| ------------------ |
|1. After the second step follows the incident identification process. The incident manager confirms whether the Incident is supported. In our case yes - so the check mark at "Is this Incident supported" is set and this is confirmed with the "complete" button. ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentIdentificationCritical.png) |

| **4 Step - Add Incident Details (with Critical Impact)** |
| ------------------ |
|1. At this point, the incident manager can add the "Affected Application" and the SystemID. This additional information is confirmed with the "Complete" button. After confirmation, the Incident is terminated in our case and passed on to the next position.  ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/AddIncidentDetailsCritical.png)|

----------------------------------------------------------------------------------------------------------------------------------------

### Ceate an Incident with the web form

| **1 Step - Go to the Webpage** |
| ------------------ |
|Click the following URL to go to our Heroku PHP site: https://saentisincident-php.herokuapp.com/ 1. Create a new incident 2. Retrieve incident status 3. Dashboard (Overview) which shows the current incidents 4. Landing page 5. You can also access the individual actions through the yellow-bordered area. ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/WebformularPHP.png)|

| **2 Step - Create an Incident with the web form** |
| ------------------ |
|1. Click on "Open a new Incident (First point on the Picture above) 2. Fill out all fields like this example an click "create ticket" ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentCreationPHP.png) 3.The Incident was successfully transmitted when "Success" appears. ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentCreationPHPSuccess.png)|

Note: **If the incident is "Critical", a Twitter message is generated directly. The same procedure as when you want to enter an incident in Camunda that is classified as "Critical".** 

----------------------------------------------------------------------------------------------------------------------------------------
### Create an incident via eMail

| **1 Step** |
| ------------------ |
|1. Write an eMail to this eMailadress. ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/EmailTo.png) |

| **1 Step - Login in to Camunda** |
| ------------------ |
|1. Click the following URL to go to our Heroku website: https://saentisincident.herokuapp.com/app/welcome/default/ 2. login with demo for the username and demo for the password 3. Click on task list 4. After that click on start overall process ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/StartProcess.png) |

----------------------------------------------------------------------------------------------------------------------------------------
### Check for Incident Status via eMail (Webformular)

| **1 Step** |
| ------------------ |
|1. Go to the following URL https://saentisincident-php.herokuapp.com/ and klick on "Check Incident Status". ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/CheckIncidentStatusEmail.png)|

----------------------------------------------------------------------------------------------------------------------------------------
## Twitter Message

If the incident has been reprioritized and the impact and priority are critical, a tweet is sent.
This is only triggered if the following applications are involved. 

- None
- Excel
- Word
- Lotus Notes
- Website

The Twitter status can be viewed at: [https://twitter.com/search?src=typd&q=saentisgroupinc]

The following picture shows an example of a triggered tweet.

![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/Twitter.png)
----------------------------------------------------------------------------------------------------------------------------------------
#Technical Details
## Variables
The following set of variables was introduced in our process. We choose to define all variables in a structured matter and describe, for whom it's visible. In this manner, it was easier to work together and define interfaces, if all variables and their options were set.
These variables were all initialized automatically, so one could count on the evaluation of the variables.

![Variables](https://github.com/DigiBP/digibp-saentis/blob/master/pics/Variables.png)

## Automation
Different automation techniques and languages were used.
* **Groovy**: Quick changes to variables were realised in groovy. Mostly changes of the status-variable (State Machine)
* **JavaScript**: Slightly more complex requests were programmed in JavaScript. For example the Twitter integration.
* **Java**: More complex cases were programmed in Java. For example, the variable initialisation and the e-Mail interface was realized in Java.

## Integration
Our solution is integrated with multiple third party solution:
* e-Mail: REST API to Zapier (Gmail, inbound and outbound)
* Twitter: REST API to Zapier
* Web-Form: REST API to a PHP web server
* Tableau Reporting: Direct database connection



## Installation
The repository can be deployed to Heroku using the following button. The repository is based on the [digibp-camunda-template](https://github.com/DigiBP/digibp-camunda-template) (Version 2.0.39

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

The following packages and libraries are used (see pom.xml file for more information):
- Camunda Version: 7.8.0
- Java Version: 1.8
- Sprint Version: 1.5.8
- H2 Database

## Tools and Software
The following tools and software has been used for implementing the incident management process.

| Tool / Software  | Description |
| ------------- | ------------------ |
| Camunda Modeler  | The Camunda Modeler is used to create BPMN, CMMN and DMN models. The modeler is based on [bpmn.io](http://bpmn.io/).  |
| GitHub| Github is used for collaboration and versioning of the programming code as well as the models. |
|Heroku|Heroku is a PaaS (Platform as a Services) which is used to quickly build, run, and operate the Camunda in the cloud. |
|Zapier|Zapier is a web-based service that allows end users to integrate the web applications. A REST API is used to push Tweets on Twitter.|
|Tableau  | Tableau is a powerful business intelligence and data visualization tool that has a very intuitive user interface. You don’t need any coding knowledge to work with Tableau. It is very useful in drilling-down data, creating insightful reports and garner actionable business insights.|
|Tableau Public "Server" |It is the free version of Tableau Server but hosted on the cloud by Tableau Software. As it is free, it requires that all workbook and data are freely accessible to everybody. In terms of data source, all should be extracts and there is a limit of 1 million rows. |


## Instructions for Testing
Following steps provide instructions on how to test the Incident Management process as described in the Process chapter.
- Open the [Säntis Heroku App](https://saentisincident.herokuapp.com/) (this might take a while zZZzzZZZ)
- Login using the following user (Username: `demo`, Password: `demo`)
- Start a new process by clicking on `Home` > `Tasklist` and choose `Start process`
- Choose the `Overall process` to start the entire incident management workflow

## License

- [Apache License, Version 2.0](https://github.com/DigiBP/digibp-archetype-camunda-boot/blob/master/LICENSE)

## Infos
- Bitte Webforms unter src/main/webapp/forms/ ablegen

## Zapier
### E-Mail Outbound
- Hook: https://hooks.zapier.com/hooks/catch/3017214/katznf/
- Test with:  curl -v -H "Accept: application/json"         -H "Content-Type: application/json"         -X POST         -d '{"email":"moritz.armingeon@gmail.com","msg":"This is a Test","title":"Incident Notification123"}'    https://hooks.zapier.com/hooks/catch/3017214/katznf/

### E-Mail Inbound
- Hook: t700agmb@robot.zapier.com

## Tableau
- The ticket dashboard was realized with Tableau Desktop Pro Version 10.5 [https://www.tableau.com/support/releases/desktop/10.5].
- The dashboard is published on the Tableau Public Server [https://public.tableau.com].
- Through the pro-license the PostgreSQL database of Heroku could be connected directly [https://data.heroku.com/datastores/de020a0e-4eba-4e7d-b4c1-7ce92a1ad729#administration]. 
- The following picture shows which data from Heroku is relevant for the integration on Tableau. 
![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/HerokuDatabase.png)
- The following picture shows how the relevant data of Heroku was integrated into Tableau. It is important to activate SSL during the connection. 

![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/TableauHerokuConnection.png) 
- The following two tables were linked with an inner join to display the relevant data from the Heroku database on a tableau. 

![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/Innerjoin.png)

- Tableau Public does not support live connection of the data nor does it support scattered schedules for the extracts. Therefore, the data is loaded manually from Tableau Desktop to the Tableau Public Server through extracts by the Tableau ETL process. 

- Disclaimer: **The data was last loaded/extracted on 07.06.2018.**

- The dashboard of Tableau is displayed on[https://saentisincident-php.herokuapp.com/views/ticketDashboard.php] via an embedded view script. The script is stored[https://github.com/DigiBP/digibp-saentis-2/tree/master/web/views] in the ticketStatus.php file. 

## ToDo
- [x] Zapier Migration (Moritz)
- [x] Set Ticket Orign and DateCreated in Init Vars (Moritz)
- [x] Ticket opening via e-mail (c9u3218e@robot.zapier.com) auf zapier Account übertragen saentisgroupincident@gmail.com (FHNW2018!) (Moritz)
- [x] Cleanup forms (Moritz)
- [ ] Dokumentieren Prozesse (Jaime)
- [x] Documentation (Architekturbild) (Moritz)
- [x] Add Ticket Status Field (Open, Assigned, Resolved, Closed, Reopened,...)
  - [x] Incorporate into whole process
- [x] Creation Process (Check variables, finalize, ) (Moritz)
- [x] Specify Validation Task (Creation1.bpmn) (Moritz)
- [x] The start event can contain a webform! (Moritz)
- [x] PHP Formular für Ticket creation (REST POST to Process Start) (Jaime)
  - [x] Hosting auf Heroku (PHP) -> App freigeben für Team
  - [x] GitHub Repo erstellen (Joël) 
- [x] Use of a DMN Decision Model (Assign to specific application depending on content keywords) (Joël) Analog Beispiel AutoCreateTweet (ServiceTasks)
- [x] Identification Task (Tweet, Priorisitation) (Joël)
- [x] Create Zapier Student Account (Joël) -> not needed, 100 request per month are for free
- [x] Diagnosis mit CMMN erstellen (Moritz)
- [x] What are properties used for? (Joël)
- [ ] Reporting overview: Page with dashboard of all tickets... for Case Manager (Jaime)
- [x] Test Post Twitter Status
- [ ] Speaker Deck Presentation
- [x] How to quickly empty the H2 database (Joël)
- [x] Create Testcases and Issues - Process (Moritz)
- [ ] Create Testcases and Issues - Integration: E-Mail (Moritz)
- [ ] Create Testcases and Issues - Integration: PHP (Moritz)
- [ ] Create Testcases and Issues - Integration: Twitter (Moritz)
- [ ] Create Testcases and Issues - Integration: Reporting(Tableau) (Moritz)
- [x] Status Changes (Request Ticket Status PHP) (Joël)
- [ ] E-Mail Parser als AI (Zapier hat gewisse funktionen) (Moritz)
- [ ] Add another status once the ticket is processing (after decision ticket is supported)
- [ ] Create a script with the demo steps (and test!!!)

## Nice to Have
- [ ] Reporting specific Ticket: Status page for open tickets status (PHP page, ggf. Properties?, Security?, 
- [ ] Ticket opening via google assistant
- [x] Monitoring of open tickets
- [x] Reporting and Statistics on Tableau
- [x] Switch to postgres sql (?)
- [ ] Open ticked depending on social media actions [more](https://developer.twitter.com/en/docs/tweets/search/overview) 
- [ ] Text recogniztion to assign to specific application (DMN)
- [ ] Complete customer data with CRM?
- [ ] Complete First/Lastname from Mailchimp API
- [ ] Welcome the logged in user: https://docs.camunda.org/manual/7.6/reference/embedded-forms/javascript/examples/
- [x] Ticket assignment (Routing? How to do it? Skill based routing)
- [ ] E-Mail FreeMarker e-Mail template https://freemarker.apache.org/


Tasks offe:
- Witeri Status Change implementiere nach "Ticket Supported" -> in Progress (Chentisch du das mache @Moritz ?)
- Uberarbeitig Doku (Alle)
- No en geile Graph bim Tableau hinzüefiege (@Jaime )
- AI ver E-Mail üswärtig (@Moritz isch das üfwendig?)
- Es Ablauf-Skript ver di Präsentation schribe (siehe https://github.com/DigiBP/digibp-saentis/blob/master/doc/demoscript.md) damit wer kei Fähler hei bi der Demo am schluss, sprich jede Schritt und wenn welle schrit, etc.


```
  ___                                 _         ____  ____  __  __
/ ___| __ _ _ __ ___  _   _ _ __   __| | __ _  | __ )|  _ \|  \/  |
| |   / _` | '_ ` _ \| | | | '_ \ / _` |/ _` | |  _ \| |_) | |\/| |
| |__| (_| | | | | | | |_| | | | | (_| | (_| | | |_) |  __/| |  | |
\____/\__,_|_| |_| |_|\__,_|_| |_|\__,_|\__,_| |____/|_|   |_|  |_|
```
