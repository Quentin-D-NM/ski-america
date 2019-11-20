## Introduction 
As someone who skis quite a bit I am always unsure about the weather going to ski resorts in my area.
While there are many weather apps for ski resorts, many are over complicated and unintuitive. 
I strive to create a simple, easy to use weather app for ski resorts all over the United States.
The driving idea behind Ski America is to provide fast easy to access weather data for ski resorts near you.

## Description 
Ski America is an android app designed to provide weather data for ski resorts that you are interested in.
As a user of the app you will be able to follow specific ski area/resorts.
By following these resorts you will be able to view the weather information on your dashboard. 
Following a ski resort also gives you the ability to receive notifications when a good storm is moving in, or when the weather conditions line up for a perfect day.
The app will provide weather information including cloud cover, temperature, wind speed/direction, and upcoming storms. 
You will also have the ability to toggle on and off downloads for the 7 day forecasts for ski resorts you follow. 
The user interface is meant to be simple yet sleek only containing 4 page, the login, the main landing, the settings, and the search page.


## Intended Users 
Skier, Snowboarders, and Resort employees looking for weather information on a particular Ski Resort. 

### [User stories](docs/user-stories.md)

### [Entity Relationship Diagram](docs/erd.md)

### [Wireframe Diagram](docs/wireframe.md)

### [DDL](docs/ddl.md)

### [Entity Classes](docs/entity-classes.md)

### [DAOs](docs/daos.md)

### [Database Class](https://github.com/Quentin-D-NM/ski-america/blob/master/app/src/main/java/com/queuedye/skiamerica/model/service/SkiAmericaDatabase.java)

## Current State of the App

### Current Abilities / 
+ The App currently has the ability to search for ski weather based on an Address and a name provided by the user.
+ The App as the ability to sign-in a user with their google account
+ The User can add as many ski resorts to his main fragment as you want
+ It will add all of the objects in the data base in the RecyclerView a again when adding another Ski Resort
+ Will crash if you do not give it a valid address in the following format "1111 street name, city, ST" (ST is a two letter state code)

### Future Astetic Improvements
+ Could clean up the look of the list view
+ Add Descriptions for each value
+ Order the list and give the user the choice to order by something specific
+ Stop it from adding the database information again

### Stretch Goals 
+ Implement a search function so the user does not have to manually enter a name and address
+ Add more data for the user to view

## Technical Requirements and Dependencies

+ Android API level 21 is required
+ Was tested on the Pixel 2 running API level 28
+ Third Party Libs
    + Androidx
        + Appcompat 
        + Constraint Layout
        + Lifecycle 
        + Legacy
    + Androidx Room
        + Room Runtime 
        + Room Compiler 
    + Google 
        + Android Material 
        + Android Play Services
        + Code Gson
    + Reactivex 
        + Rxjava
        + Rxandroid
    + Square Up 
        + Picasso 
        + Retrofit2
            + Retrofit
            + Converter Gson
            + Adapter Rxjava2 
        + Okhttps3 Logging Interceptor
    + Facebook Stetho 

## Javadocs Documentation 

[Ski America Javadocs](docs/javadocs/index.html)

## Build Instructions
1. Fork the project on github [here](https://github.com/Quentin-D-NM/ski-america) then copy the ssh
2. Open Intellij and create a new Project from version control and select git
3. Paste the ssh copied from earlier and when prompted do not open the project
4. After successfully creating the project select import and select the project you just cloned
5. Import the project and a gradle project
6. Once the importing is complete you will need to create two files containing your api keys
7. Create the files in a "services" directory that is two directories back from you main project
8. The first File is geocode.properties, the second is skiweather.properties
9. You need to go to [Google Developers Console](https://console.developers.google.com) serach for geoCoder api and [WorldWeatherOnline](https://www.worldweatheronline.com/) to create api keys  
10. Once you have created you api keys you should put them is the respected files like so: 
```text
api_key = YOUR_API_KEY_HERE
```
11. Create Google Sign in credentials at the Google Developer console 
12. Launch the App! 

## User Instructions

1. Launch the App
2. The first time launching or if you have logged out you should be presented with a google sign in page
3. Log in with google 
4. Click the blue button in the bottom right hand corner
5. Enter a Ski Resort Name
6. Then its address 
7. Wait for it to appear on the screen 
8. That pretty much it right now 
    

## Third Milestone(Nov 20th 2019)

+ [x] Documentation 
    + [x] Project Introduction / Description
    + [x] Intended Users
    + [x] User Stories
    + [x] Current State Summary
    + [x] Wireframe Diagrams 
    + [x] Entity Relationship Diagrams
    + [x] DDL 
    + [x] Technical Requirements & Dependencies
    + [x] Javadoc Technical Documentation
    + [x] Copyright & License 
    + [x] Build Instructions
    + [x] Basic User Instructions
+ [ ] Implementation Components
    + [x] Multiple Fragments / Multiple Activities
    + [ ] Shared Preferences
    + [x] Use of SQLite Database
    + [x] Database Dynamic UI (RecyclerView)
    + [x] Consumption of External Services
    + [ ] Custom Icons
    + [ ] Code Quality (I'll let you decide) 
        

## Second Milestone(Oct 28th 2019)

+ [x] Description
+ [x] Intended users
+ [x] ERDs
+ [x] User stories
+ [x] Entity classes
+ [x] DAOs
+ [x] Database Class
+ [x] DDL
+ [x] Inspect data model with chrome

## First Milestone(Oct 2nd 2019)

+ [x] Description 
+ [x] Intended users
+ [x] ERDs
+ [x] Wireframes
+ [x] User stories

## Licence info 

Copyright 2019 Quentin Dye

[Licence Info](docs/license-info.md)
[Full Licence](LICENSE)

