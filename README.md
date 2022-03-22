#validator-app
- Consists of two modules - an angular client and a spring boot client

## Running the app
- [x] git clone https://github.com/Ewatiri/validator-app.git
- [x] cd validator-app/validator mvn package
- [x] docker build --tag=validator:latest .
- [x] docker run -p8080:8080 validator:latest
- [x] run the client
- [x] cd validator-app/validator-client 
- [x] npm install
- [x] ng serve
- [x] Navigate to http://localhost:4200/