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

### Current Abilities
+ The App currently has the ability to search for ski weather based on an Address and a name provided by the user.
+ The User has the ability to update a ski resorts weather by clicking and holding on the ski resort then selecting update
+ The App as the ability to sign-in a user with their google account
+ The User can add as many ski resorts to his main fragment as you want

### Future Astetic Improvements
+ Could clean up the look of the list view
+ Order the list and give the user the choice to order by something specific

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
    


## Third Milestone(Nov 20th 2019)

+ [ ] Documentation 
    + [x] Project Introduction / Description
    + [x] Intended Users
    + [x] User Stories
    + [x] Current State Summary
    + [x] Wireframe Diagrams 
    + [x] Entity Relationship Diagrams
    + [ ] DDL 
    + [x] Technical Requirements & Dependencies
    + [ ] Javadoc Technical Documentation
    + [ ] Copyright & License 
    + [ ] Build Instructions
    + [ ] Basic User Instructions
+ [ ] Implementation Components
        

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

