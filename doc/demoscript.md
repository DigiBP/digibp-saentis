## Script for Demo of the application

# Preparation
- Reset Postgres database: https://data.heroku.com/datastores/de020a0e-4eba-4e7d-b4c1-7ce92a1ad729#administration
- Activate all Zapier Hooks: https://zapier.com/app/dashboard (except Drafts)

# 1. Issue Creation
## Ticket Creation Camunda
- Open https://saentisincident.herokuapp.com/app/tasklist/default/#/
- Create Ticket in Camunda by starting Overall Process and choose: 
	- Priority: Critical
	- Affected Application: Website
	- Impact: Critical
## Ticket Creation Website
- Create a Ticket using Website: https://saentisincident-php.herokuapp.com/ 
- Use the E-Mail info@joelschmid.ch (will be used later on to check status)
- Show that the Ticket has been created in camunda https://saentisincident.herokuapp.com/app/tasklist/default/#/

## Create Ticket using E-Mail
- Send an E-Mail to t700agmb@robot.zapier.com concerning a problem with ''lotus notes''!!

## Show Tickets in Camunda as well as confirmation E-Mail
- Show Confirmation E-Mails

# 2. Issue Identifcation
- Use Ticket from E-Mail
- Ticket Supported: TRUE
- Set Affected Application to: Lotus Notes
- SystemID: 0221
- Set Priority to: CRITICAL
- Set Impact to: CRITICAL
- Show Tweet: https://twitter.com/saentisgroupinc

# 3. Ticket Resolution
- Claim Ticket
- Diagnose Issue (explain what can be done using discretionary tasks and mention that they are not supported yet by camunda)
- Say that the customer would now be informed depending on the Origin of the Ticket (Telefone, E-Mail, ...)
- Status Update > Show E-Mail

# Track Issue Status 
- Open https://saentisincident-php.herokuapp.com/views/ticketStatus.php
- Type in info@joelschmid.ch to see all open tickets


# Show Ticket Dashboard
- Open https://saentisincident-php.herokuapp.com/views/ticketDashboard.php
- Used by the responsible team lead of the help desk
