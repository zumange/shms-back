# ShmsBack

## Requirements
For building and running application you'll need:
- JDK 21 (at least)
- Maven 3

Database is required because backend will throw error on booting if he wont be able to establish connection to database.

## Development server

Firstly, you need to run:
```bash
mvn build
```

To start a local development server, you can do it in two ways:

1) Run ShmsBackApplication.class from your IDE
2) Run in bash:
```bash
mvn spring-boot:run
```
