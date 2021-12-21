### To-do-app

The app is an MVP* of the requested version. The * is because its not functional yet, I had some issues with angular. 
Files are in branch "master".

# The stack required to run the app is the following:
* Java 11 
* Postgresql 13.5
* Node 12.22.5
* npm 7.5.2
* Angular CLI 13.1.2
* Linux x64

To run the backend, the first thing to do is:
  $ bash psqldatabase.sh
Then inside the target folder, there is a file called: appens-0.0.1-SNAPSHOT.jar
  $ java -jar appens-0.0.1-SNAPSHOT.jar
 
Regarding the front end, Its not finished and to "run" it its necessary to execute 
  $ ng serve
on the folder, and then once compiled, typing localhost:4200 in the browser.


 
