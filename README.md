A simple Rest application(Send Email) deployed on Docker

This example shows how to use fake-smtp with the java REST application.

Steps to run this.

1. Clone this repository
2. Package the project by running mvn Package
3. Run 'docker images' and confirm that the 'mail-rest' docker images is available.
4. Then go into fake-smtp folder and build the image by running 'docker build -t fake-smtp:latest . " and confirm that the 'fake-smtp' docker images is available.
5. Then go to project root folder(java-mail-rest) and run "docker-compose up -d" 
6. Access the REST endpoint with http://localhost:8080/api/sendEmail 
7. Check the output folder and confirm that there is an eml file created which has the email content
