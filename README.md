# Spring GraphQL

## Description

This project is a simple example of how to use GraphQL with Spring Boot. It uses the GraphQL Java library to create a GraphQL server.

## How to run

To run the project, execute the following command:

```bash
./gradlew bootRun
```

## GraphiQL

After running the project, you can access the GraphiQL interface at the following URL:

```
http://localhost:8080/graphiql
```

## Queries

You can use the following queries:

### Get all books

```graphql
query GetBookStores {
    bookStores {
        id
        name
        books {
            bookStoreId
            id
            title
        }
    }
}
```