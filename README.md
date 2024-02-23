# weather_censoring
Servers for remote weather monitoring

### weatherApp 
weatherApp is a webserver written in sprinboot to accept requests and stick them in a database

It has a simple bit of logic to filter requests by IP so only the specified raspberyy pis can post data

### webserver
webserver has a functioning node server that does the same thing currently without authorisation

There are also some simple python socket servers that I was playing with
