spring-boot-1109
================

reproduction for https://github.com/spring-projects/spring-boot/issues/1109


When -Dspring.profiles.active is set, application-test.properties isn't picked up when enabled by @ActiveProfiles("test")

this successes:
mvn clean test

this fails:
mvn clean test -Dspring.profiles.active=someProfile
