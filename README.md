# DigiBP Säntis Incident Management [![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
```
________  .__       .______________________    _________  _ _  __  .__        
\______ \ |__| ____ |__\______   \______   \  /   _____/ _____/  |_|__| ______
 |    |  \|  |/ ___\|  ||    |  _/|     ___/  \_____  \ /    \   __\  |/  ___/
 |    `   \  / /_/  >  ||    |   \|    |      /        \   |  \  | |  |\___ \ 
/_______  /__\___  /|__||______  /|____|     /_______  /___|  /__| |__/____  >
        \/  /_____/            \/                    \/     \/             \/ 
```                                                                       
                                                                          
| Summary | Quicklinks |
| ------------------ | - |
|This repository contains an incident management workflow running on [Camunda BPM](https://docs.camunda.org). This repository is part of the group assignment of the Digitalization of the Business Processes (SS18) Module at the FHNW. Check out our [Presentation Slides](https://speakerdeck.com/joelschmid91/santis-group-digitalisation-of-business-processes) to get an overview of the process as well as the tools and technologies used. | [Camunda BPN Incident Management]( https://saentisincident.herokuapp.com/ ) - [PHP Web Incident Management](https://saentisincident-php.herokuapp.com/) -  [Create an Issue by E-Mail](mailto:t700agmb@robot.zapier.com)|

*Authors*
* Jaime Ramirez, [jaime.ramirez@students.fhnw.ch](mailto:jaime.ramirez@students.fhnw.ch)
* Moritz Armingeon, [moritz.armingeon@students.fhnw.ch](mailto:moritz.armingeon@students.fhnw.ch)
* Joël Schmid, [joel.schmid@students.fhnw.ch](mailto:joel.schmid@students.fhnw.ch)


# Methodology and Approach
Please be aware that the reader should be familiar with BPMN 2.0. The processes and their flows are not described or explained in this project. 

This project was approached using the KISS (keep it simple, stupid) principle. With the KISS principle, a simple solution can be found to solve a complex problem. In addition to the KISS principle, the project team has chosen an agile approach to enable a high flexibility during the implementation and further to increase the success rate of the project.

## Design Approach
After the first lesson, we were able to execute the first workflow by running the Camunda BPM Engine on Heroku. Although with a limited functionality. It was a valuable experience for the group as new technologies were used. Furthermore, documentation and design plans were crafted and some tests were conducted. We treated every lesson and the following development and adaptions to the product as one sprint.

## Collaboration
Git Version control was used in order to work collaboratively on the project. GitHub was used for the versioning of the development increments, as well as to create the technical documentation.

We work with two Heroku instances and two GitHub Repositories. GitHub and Heroku can be seamlessly integrated with eachother, allowing a continous delivery of the implemented increment. 
- 1 Camunda / Tomcat: This instance holds the Camunda codebase. Camunda was firstly tested locally on the developer's machine and then  committed. Once committed, the repo is automatically deployed on Heroku.
- 2 Web Form / PHP: This instance contains the web-based components of our solution: The web-form to create new incidents, a status page to check the status of the tickets and an overview using the Tableau dashboards. 

## Testing
In order to minimalize defects, various functional tests were conducted. We created test-cases from an external view (black box). Furthermore, different decision paths were tested. Detected issues were tracked with the [Github issue management](https://github.com/DigiBP/digibp-saentis/issues) as well as with the tasks stored in the README.md file.

## Project Management
Tasks were tracked within this documentation and assigned to one of the team members. For such as small team, no designated project leader was chosen. Tasks were taken by the each teammember individually.

# Process Description (Incident Management)
The following chapter describes the basic idea behind the incident process we have selected. 

![Media Flows](https://github.com/DigiBP/digibp-saentis/blob/master/pics/BigPicture_v2.png)
We have implemented an incident management process. The incident management system runs for a fictional company called “Säntis Corporation”. Incidents are filed out by customer of the company as well as internal staff. The company has different incident managers which work on resolving these issues.

We have three main options to open a ticket:
* **e-Mail:** Send an e-Mail to the support address [t700agmb@robot.zapier.com] to automatically create a ticket
* **Web form:** Fill out the [web-form](https://saentisincident-php.herokuapp.com/views/createTicket.php) to create a new incident
* **Camunda:** Create the issue directly in [Camunda BPM](https://saentisincident.herokuapp.com/app/welcome/default/). For example, an issue received by phone can then directly recoreded.

Please be aware that all these channels are all using the REST API of Camunda. Therefore, further channels can be easiliy added in the future.

The **communication** with the incident creator is done by e-Mail. In case the identified incident is critical, the case manager gets informed. If the indicent has a impact for different customers a automatic tweet is generated to quickly inform other customers and to prevent the incident managers from further interruptions. Consequently, this should reduce the amount of similar issues received.

A **status report** of the ticket is provided by a reporting suite. Two general views were created: An [internal view](https://saentisincident-php.herokuapp.com/views/ticketDashboard.php), for incident managers and their supervisors, giving an overview of all tickets as well as a [external, personal view](https://saentisincident-php.herokuapp.com/views/ticketStatus.php) for the customer, where he may consult his ticket status.

### Process Description
| ITIL | - |
| ------------------ | - |
| ** We tried to align this process to the ITIL incident management standard. We have focused on the following four sub-processes.** This screenshot shows the overall process workflow. You can see the sub-processes (outlined in red) that we used for our project. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/Incident_Management_ITIL_2.jpg) |


## Overall Process
The following figure shows a simple visualization of our overall process. This process is divided in four sub processes.
- Issue Creation
- Issue Identification
- Issue Diagnosis
- Issue Resolution


| **Overall Process** | - |
| ------------------ | - |
|**JOEL: Hier wäre jeweils kurz eine Beschreibung gut was passiert beim Jeweiligen sub-process, unter anderem auch was für notations e.g. BPMN, CMMN, sowie DMN die verwendet wurden und was für Schnittstellen involviert sind (nur wenns reicht)** | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/00_Overall.png) |

### Issue Creation Process

| **Issue Creation Process** | - |
| ------------------ | - |
|The following image shows a comprehensive visualization of our issue creation process. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/01_IncidentCreation.png) |

### Issue Identification

| **Identification Process** | - |
| ------------------ | - |
|The following image shows a comprehensive visualization of our identification process. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/02_IncidentIdentification.png) |

### Issue Diagnosis Process

| **Diagnosis Process** | - |
| ------------------ | - |
| The following image shows a comprehensive visualization of our diagnosis process. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/03_IncidentDiagnosis.png) |

### Issue Resolution Process

| **Resolution Process** | - |
| ------------------ | - |
| The following image shows a comprehensive visualization of our resolution process. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/04_IncidentResolution.png) |


## Camunda Processes Step by Step Guide

### Issue Creation Process
The incident can be started in several ways (see Big Picture). In this chapter all possibilities are explained step by step. 
![Big Picture](https://github.com/DigiBP/digibp-saentis/blob/master/pics/BigPicture_v1.png)

#### Create an Issue using Camunda


| **1 Step - Go to Camunda** | - |
| ------------------ | - |
|1. Click the following URL to go to our Heroku website: https://saentisincident.herokuapp.com/app/welcome/default/ 2. login with demo for the Username and demo for the Password 3. Click on task list 4. After that click on start Overall Process | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/StartProcess.png) |
| **2 Step - Incident Creation** | - |
|Fill out all fields (As in the example) and click on Start to start the Process | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentCreationMask.png) |
| **3 Step - Incident Identification** | - |
|After the second step follows the incident identification process. The incident manager confirms whether the incident is supported. In our case yes - so the check mark at "Is this Incident supported" is set and this is confirmed with the "complete" button. ![alt text]|(https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentIdentification.png) |
| **4 Step - Add Incident Details** | - |
|At this point, the incident manager can add the "Affected Application" and the SystemID. This additional information is confirmed with the "Complete" button. After confirmation, the incident is terminated in our case and passed on to the next position. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/AddIncidentDetails.png) |

#### Create an Incident with the Web Form

| **1 Step - Go to the Webpage** | - |
| ------------------ | - |
| 1. Click the following URL to go to our Heroku PHP site: https://saentisincident-php.herokuapp.com/ 2. Create a new incident 3. Retrieve incident status 4. Dashboard (Overview) which shows the current incidents 5. Landing page 6. You can also access the individual actions through the yellow-bordered area. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/WebformularPHP.png) |
| **2 Step - Create an Incident with the web form** | - |
||1. Click on "Open a new Incident (First point on the Picture above) 2. Fill out all fields like this example an click "create ticket" ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentCreationPHP.png) 3.The Incident was successfully transmitted when "Success" appears. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentCreationPHPSuccess.png)|

Note: **If the incident is "Critical", a Twitter message is generated directly. The same procedure as when you want to enter an incident in Camunda that is classified as "Critical".** 
**JOEL: Dies stimmt so nicht, es gibt einen unterschied zwischen IMPACT und PRIORITY**


#### Create an Issue using e-Mail

| **1 Step** | - |
| ------------------ | - |
| Write an eMail to this e-mail: [t700agmb@robot.zapier.com] | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/EmailTo.png) |


### Incident Identification
| **Is the Incident Supported?** | - |
| ------------------ | - |
| As soon as the incident process has started (all necessary information has been entered) the first question comes up as whether the incident is supported or not. The incident manager has to decide if the incident is supported, if yes, further information about the incident has to be entered in Camunda. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentSupportedYesOrNo.png) |
|  If not, the customer gets notified that his incident will not be supported. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentIsNotSupported.png) |
| **Add Ticket Details**| - |
| The system ID and the affected application have been entered by the incident manager. Depending which applications is affected, the incident might be redirected to an external support such as Microsoft or SAP products.
Depending on which application is affected, different tasks are generated. Not all possibilities will be shown in the upcoming documentation. As for example if it is an **SAP** or **Microsoft (Outlook)** incident, it is forwarded to the "external" support. All other incidents will be prioritized and the impact will be redefined if the incident is supported. For the following applications are used within the company: None, Excel, Word, Lotus Notes, Outlook, Website, SAP | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IncidentIsSupported.png) |
| **Indicent Priority**| - |
Again the incident manager has to select whether the incident has a high priority or not. If the incident has a high priority, then the supervising case manger should be informed. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IsTheIncidentCritical.png) |
| **Incident Impact**| - |
| If the Incident has a high impact and is thus critical, an automatic [tweet](https://twitter.com/search?src=typd&q=saentisgroupinc) will be generated in order to inform other customers of the incident. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/IsTheIncidentCritical2.png) |


## Issue Diagnosis & Resolution
**JOEL: Vollständigkeitshalber müssten wir noch Issue Diagnosis und Issue Resultion erwähnenè**


### Tableau Dashboard

This chapter describes what you can see in the Ticket Dashboard. The Dashboard/Cockpit was created with Tableau. The dashboard/cockpit contains three tabs which are structured as follows:

| **Overview** | - |
| ------------------ | - |
|This "overview" view shows the number of data records in relation to the affected applications and the customer. The individual case can be viewed and filtered using the "Case ID" View.It is differentiated whether a ticket is "New" "Open" Rejected" or "Solved". The ticket status and whether the ticket is"Active" or "Completed" is also visible on this view.| ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/SaentisDashboardOverview.png) |
| **Ticket Status** | - |
|This "Ticket Status" view shows the Number of records relating to the Ticket Status.| ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/SaentisDashboardStatus.png) |
| **Tickets/Time** | - |
|...| ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/SaentisDashboardTime.png) |

### Check for Incident Status via eMail (Webformular)

| **1 Step** |- |
| ------------------ | - |
|Go to the following URL https://saentisincident-php.herokuapp.com/ and klick on "Check Incident Status".| ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/CheckIncidentStatusEmail.png)|
| **2 Step** |- |
|Enter the email you used to write an Incident on [t700agmb@robot.zapier.com] an cklick on "Check Ticket Status" to see what the status of the Incident is. | ![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/CheckTicketStatusButton.png)|


**JOEL: Technical Details müsste man auch noch etwas konsolidieren. Tools werden mehrfach beschrieben und erwähnt (trivial! wenns nit längt isch halb so wild! :-) **

# Developer Documentation
## Variables
The following set of variables was introduced in our process. We choose to define all variables in a structured matter and describe, for who they are visible. This allowed us to easier work together. These variables were all initialized automatically, so one could count on the instanciation of the variables.
![Variables](https://github.com/DigiBP/digibp-saentis/blob/master/pics/Variables.png | width=100)

## Integrations & Interfaces
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


## Automation
Different automation techniques and languages were used.
* **Groovy**: Quick changes to variables were realised in groovy. Mostly changes of the status-variable (State Machine)
* **JavaScript**: Slightly more complex requests were programmed in JavaScript. For example the Twitter integration.
* **Java**: More complex cases were programmed in Java. For example, the variable initialisation and the e-Mail interface was realized in Java.

## E-Mails
**E-Mail Outbound**
- Hook: https://hooks.zapier.com/hooks/catch/3017214/katznf/
- Test with:  curl -v -H "Accept: application/json"         -H "Content-Type: application/json"         -X POST         -d '{"email":"moritz.armingeon@gmail.com","msg":"This is a Test","title":"Incident Notification123"}'    https://hooks.zapier.com/hooks/catch/3017214/katznf/

**E-Mail Inbound**
- Hook: t700agmb@robot.zapier.com

## Tableau
- The ticket dashboard was realized with [Tableau Desktop Pro Version 10.5](https://www.tableau.com/support/releases/desktop/10.5).
- The dashboard is published on the [Tableau Public Server](https://public.tableau.com).
- Through the pro-license the [PostgreSQL database of Heroku](https://data.heroku.com/datastores/de020a0e-4eba-4e7d-b4c1-7ce92a1ad729#administration) could be connected directly. 
- The following picture shows which data from Heroku is relevant for the integration on Tableau. 
![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/HerokuDatabase.png)
- The following picture shows how the relevant data of Heroku was integrated into Tableau. It is important to activate SSL during the connection. 
![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/TableauHerokuConnection.png) 
- The following two tables were linked with an inner join to display the relevant data from the Heroku database on a tableau. 
![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/Innerjoin.png)
- Tableau Public does not support live connection of the data nor does it support scattered schedules for the extracts. Therefore, the data is loaded manually from Tableau Desktop to the Tableau Public Server through extracts by the Tableau ETL process. 
- The dashboard of Tableau is displayed on the [Säntis PHP Website](https://saentisincident-php.herokuapp.com/views/ticketDashboard.php) via an embedded view script. The script is stored in the [GitHub Repo](https://github.com/DigiBP/digibp-saentis-2/tree/master/web/views) in the ticketStatus.php file. 


**JOEL: Hier müssten wir wohl noch sämtliche Logins hinterlegen, ZAPIER; TWITTER; GOOGLE ACCOUNT, TABLEAU am besten das PW Andreas per E-Mail zusenden?**
## Instructions for Testing
Following steps provide instructions on how to test the Incident Management process as described in the Process chapter.
- Open the [Säntis Heroku App](https://saentisincident.herokuapp.com/) (this might take a while zZZzzZZZ)
- Login using the following user (Username: `demo`, Password: `demo`)
- Start a new process by clicking on `Home` > `Tasklist` and choose `Start process`
- Choose the `Overall process` to start the entire incident management workflow

## License
- [Apache License, Version 2.0](https://github.com/DigiBP/digibp-archetype-camunda-boot/blob/master/LICENSE)


```
  ___                                 _         ____  ____  __  __
/ ___| __ _ _ __ ___  _   _ _ __   __| | __ _  | __ )|  _ \|  \/  |
| |   / _` | '_ ` _ \| | | | '_ \ / _` |/ _` | |  _ \| |_) | |\/| |
| |__| (_| | | | | | | |_| | | | | (_| | (_| | | |_) |  __/| |  | |
\____/\__,_|_| |_| |_|\__,_|_| |_|\__,_|\__,_| |____/|_|   |_|  |_|
```
