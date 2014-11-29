Sticky Stone 
=============

A reference implementation for how to build an application that uses the best-practices that are encouraged by the use of Sping-boot

Features
---

All interactions require a REST client. There is no UI with this distribution. For a good UI that consumes Restful API, see PointyPatient.

This app showcases the following features ([related blog post](Sticky Stone "Sticky Stone")):

Setup
---

- Create three ROLEs: ADMIN, SHOPPER and BROWSER
- ADMIN can change roles of existing users
- SHOPPER can buy stuff and browse stuff
- BROWSER can only browse stuff

- Create a User User1 who is ADMIN
- Create a user User2 who is SHOPPER
- Create a user User3 who is BROWSER

Use Cases
---

- Allow users to self-register and assign them BROWSER by default.
- Allow the user to select a username and warn if a duplicate.
- Write an android app that can be downloaded
- The android app will only allow the users who have registered on website to browse but not shop.
- When the user is bumped up to SHOPPER by an ADMIN user, that user should be able to shop on the phone.

- Showcases use of Spring-Boot
- Self-registration
- Login Using Facebook
- Showcases the use of Spring Security to secure Restful API
- Showcases Spring HATEOAS
- Showcases Rich Domain Design
- Showcases modular design at maven module level
- Showcases Spring MVC tests
- Showcases Spring JPA and Spring Data
- Showcases externalizing properties using YAML
- Showcases the use of Spring profiles and the Environment abstraction

Demo
---

To Run
---

mvn clean install -Dspring.profiles.active=loc | dev

loc -> H2
dev -> MySQL


Using jar file:

java -jar target/sticky-stone-domain-0.1.0.jar --spring.profiles.active=loc | dev


