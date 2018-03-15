# DigiBP Säntis Incident Management [![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
This repository contains an incident management workflow running on [Camunda BPM](https://docs.camunda.org). This repository is part of the group assignment of the Digitalisation of the Business Processes (SS18) Module at the FHNW.

*Authors*
* Jaime Ramirez, [jaime.ramirez@students.fhnw.ch](mailto:jaime.ramirez@students.fhnw.ch)
* Moritz Armingeon, [moritz.armingeon@students.fhnw.ch](mailto:moritz.armingeon@students.fhnw.ch)
* Joël Schmid, [joel.schmid@students.fhnw.ch](mailto:joel.schmid@students.fhnw.ch)

## Process Description (Incident Management Workflow)
This chapter describes the implemented process in more detail.
### Overall Process

### Issue Creation

### Issue Identification

### Issue Diagnosis

### Issue Resolution
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
- 

## ToDo
- [ ] Creation Process (Check variables, finalize, ) (Moritz)
- [ ] Specify Validation Task (Creation1.bpmn) (Moritz)
- [ ] The start event can contain a webform!
- [ ] Ticket opening via e-mail (c9u3218e@robot.zapier.com) auf zapier Account übertragen saentisgroupincident@gmail.com (FHNW2018!) (Moritz)
- [ ] PHP Formular für Ticket creation (REST POST to Process Start) (Jaime)
  - [x] Hosting auf Heroku (PHP) -> App freigeben für Team
  - [x] GitHub Repo erstellen (Joël) 
- [ ] Use of a DMN Decision Model (Assign to specific application depending on content keywords) (Joël) Analog Beispiel AutoCreateTweet (ServiceTasks)
- [ ] Identification Task (Tweet, Priorisitation) (Joël)
- [x] Create Zapier Student Account (Joël) -> not needed, 100 request per month are for free
- [ ] Diagnosis mit CMMN erstellen (Moritz)
- [ ] What are properties used for?
- [ ] Ticket assignment (Routing? How to do it? Skill based routing)
- [ ] Reporting specific Ticket: Status page for open tickets status (PHP page, ggf. Properties?, Security?, 
- [ ] Reporting overview: Page with dashboard of all tickets... for Case Manager
- [ ] Documentation (Installation, Guidelines, ...)
- [x] Test Post Twitter Status
- [ ] Speaker Deck Presentation
- [ ] How to quickly empty the H2 database


## Nice to Have
- [ ] Ticket opening via google voice
- [ ] Monitoring of open tickets
- [ ] Reporting and Statistics on Tableau
- [ ] Switch to postgres sql (?)
- [ ] Open ticked depending on social media actions [more](https://developer.twitter.com/en/docs/tweets/search/overview) 
- [ ] Text recogniztion to assign to specific application (DMN)
- [ ] Complete customer data with CRM?
- [ ] Complete First/Lastname from Mailchimp API
- [ ] Welcome the logged in user: https://docs.camunda.org/manual/7.6/reference/embedded-forms/javascript/examples/

