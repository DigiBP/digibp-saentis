# DigiBP Säntis Incident Management [![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
```
________  .__       .______________________    _________  _ _  __  .__        
\______ \ |__| ____ |__\______   \______   \  /   _____/ _____/  |_|__| ______
 |    |  \|  |/ ___\|  ||    |  _/|     ___/  \_____  \ /    \   __\  |/  ___/
 |    `   \  / /_/  >  ||    |   \|    |      /        \   |  \  | |  |\___ \ 
/_______  /__\___  /|__||______  /|____|     /_______  /___|  /__| |__/____  >
        \/  /_____/            \/                    \/     \/             \/ 
```                                                                       
                                                                          
This repository contains an incident management workflow running on [Camunda BPM](https://docs.camunda.org). This repository is part of the group assignment of the Digitalisation of the Business Processes (SS18) Module at the FHNW.

*Authors*
* Jaime Ramirez, [jaime.ramirez@students.fhnw.ch](mailto:jaime.ramirez@students.fhnw.ch)
* Moritz Armingeon, [moritz.armingeon@students.fhnw.ch](mailto:moritz.armingeon@students.fhnw.ch)
* Joël Schmid, [joel.schmid@students.fhnw.ch](mailto:joel.schmid@students.fhnw.ch)

## Dislaimer
We assume that the reader is familiar with BPMN 2.0. The processes and their flows are not described or explained in this project. 

## Methodology and approach

The present project was approached according to the KISS (keep it simple, stupid) principle. With the KISS principle, a simple solution can be sought to solve a required problem. In addition to the KISS principle, the project team has chosen the agile approach to ensure the development and finalization of the project. 

## Incident Process Idea - Process Decription (Incident Management Workflow)
This Chapter describes the basic idea behind the incident process we have selected. 

For this project we have adhered to the ITIL Incident Management Standard. We have focused on the following four sub-processes. 

- 1 Indicent Creation Process
- 2 Incident Identification Process (Incident Categorization and Incident Priorization) 
- 3 Incident Resolution Process

![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/Incident_Management_ITIL_2.jpg)

This screenshot shows the ITIL Incident Management Process. You can see the sub-processes (outlined in red) that we used for our project. 

### Overall Process
The following image shows a simple visualization of our Overall process. This Process is divided in four sub processes.
- Create Issue
- Issue Identification
- Issue Diagnosis
- Issue Resolution

| **Overall Process** |
| ------------------ |
|![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/00_Overall.png) |

### Issue Creation Process
The following image shows a simple visualization of our Issue Creation Process.

| **Issue Creation Process** |
| ------------------ |
|![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/01_IncidentCreation.png) |

### Issue Identification
The following image shows a simple visualization of our Identification Process.

| **Identification Process** |
| ------------------ |
|![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/02_IncidentIdentification.png) |

### Issue Diagnosis Process
The following image shows a simple visualization of our Diagnosis Process.

| **Diagnosis Process** |
| ------------------ |
|![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/03_IncidentDiagnosis.png) |

### Issue Resolution Process
The following image shows a simple visualization of our Resolution Process.

| **Resolution Process** |
| ------------------ |
|![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/04_IncidentResolution.png) |

## Step by Step Guide
The Incident can be started in several ways (see picture Big Picture). In this chapter all possibilities are explained step by step. 
![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/BigPicture_v1.png)
Picture description: Big Picture

| Linke Überschrift | Mittlere Überschrift |Rechte Überschrift |
| ------------------ | ------------------ |
| Etwas Text hier | Ein bisschen hier | Etwas Hier|


![alt text](https://github.com/DigiBP/digibp-saentis/blob/master/pics/BigPicture_v2.png)


## Installation
The repository can be deployed to Heroku using the following button. The repository is based on the [digibp-camunda-template](https://github.com/DigiBP/digibp-camunda-template) (Version 2.0.39

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

The following packages and libraries are used (see pom.xml file fore more information):
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

## ToDo
- [x] Zapier Migration (Moritz)
- [x] Set Ticket Orign and DateCreated in Init Vars (Moritz)
- [x] Ticket opening via e-mail (c9u3218e@robot.zapier.com) auf zapier Account übertragen saentisgroupincident@gmail.com (FHNW2018!) (Moritz)
- [x] Cleanup forms (Moritz)
- [ ] Dokumentieren Prozesse (Jaime)
- [x] Documentation (Architekturbild) (Moritz)
- [x] Add Ticket Status Field (Open, Assigned, Resolved, Closed, Reopened,...)
  - [x] Incorporate into whole process
- [x] Creation Process (Check variables, finalize, ) (Moritz)
- [x] Specify Validation Task (Creation1.bpmn) (Moritz)
- [x] The start event can contain a webform! (Moritz)
- [ ] PHP Formular für Ticket creation (REST POST to Process Start) (Jaime)
  - [x] Hosting auf Heroku (PHP) -> App freigeben für Team
  - [x] GitHub Repo erstellen (Joël) 
- [x] Use of a DMN Decision Model (Assign to specific application depending on content keywords) (Joël) Analog Beispiel AutoCreateTweet (ServiceTasks)
- [x] Identification Task (Tweet, Priorisitation) (Joël)
- [x] Create Zapier Student Account (Joël) -> not needed, 100 request per month are for free
- [x] Diagnosis mit CMMN erstellen (Moritz)
- [ ] What are properties used for? (Joël)
- [ ] Reporting overview: Page with dashboard of all tickets... for Case Manager (Jaime)
- [x] Test Post Twitter Status
- [ ] Speaker Deck Presentation
- [x] How to quickly empty the H2 database (Joël)
- [x] Create Testcases and Issues - Process (Moritz)
- [ ] Create Testcases and Issues - Integration: E-Mail (Moritz)
- [ ] Create Testcases and Issues - Integration: PHP (Moritz)
- [ ] Create Testcases and Issues - Integration: Twitter (Moritz)
- [ ] Create Testcases and Issues - Integration: Reporting(Tableau) (Moritz)
- [ ] Status Changes (Request Ticket Status PHP) (Joël)
- [ ] E-Mail Parser als AI (Zapier hat gewisse funktionen) (Moritz)

## Nice to Have
- [ ] Freemaker for Mails (can use Camunda Variables)
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
- [ ] Ticket assignment (Routing? How to do it? Skill based routing)
- [ ] E-Mail FreeMarker e-Mail template https://freemarker.apache.org/

```
  ___                                 _         ____  ____  __  __
/ ___| __ _ _ __ ___  _   _ _ __   __| | __ _  | __ )|  _ \|  \/  |
| |   / _` | '_ ` _ \| | | | '_ \ / _` |/ _` | |  _ \| |_) | |\/| |
| |__| (_| | | | | | | |_| | | | | (_| | (_| | | |_) |  __/| |  | |
\____/\__,_|_| |_| |_|\__,_|_| |_|\__,_|\__,_| |____/|_|   |_|  |_|
```
