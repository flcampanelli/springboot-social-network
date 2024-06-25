# Social Network API Documentation

Welcome to the documentation for the Social Network API. This API provides endpoints to interact with users their posts in a social network application.

## Base URL

The base URL for all API endpoints is:

```
http://localhost:8080
```

## Users

### Retrieve All Users

```
GET /users
```

Retrieve a list of all users.

#### Response

- **HTTP Status Code**: 200 OK

```json
[
    {
        "id": "667217f95617941eef6735ed",
        "name": "João",
        "email": "joao@gmail.com"
    },
    {
        "id": "667217f95617941eef6735ee",
        "name": "Maria",
        "email": "maria@gmail.com"
    }
]
```

### Retrieve a User by ID

```
GET /users/{id}
```

Retrieve details of a specific user by its ID.

#### Parameters

- `id` (string): ID of the user to retrieve.

#### Response

- **HTTP Status Code**: 200 OK

```json
{
    "id": "667217f95617941eef6735ed",
    "name": "João",
    "email": "joao@gmail.com"
}
```

### Insert a New User

```
POST /users
```

Create a new user.

#### Request Body

```json
{
    "name": "New User",
    "email": "new_user@example.com"
}
```

This endpoint creates a new user with the provided details in the request body.

#### Response

- **HTTP Status Code**: 201 Created
- **Location Header**: `http://localhost:8080/users/{id}`

### Update a User

```
PUT /users/{id}
```

Update details of an existing user.

#### Parameters

- `id` (string): ID of the user to update.

#### Request Body

```json
{
    "name": "Updated User",
    "email": "updated_user@example.com"
}
```

This endpoint updates details of an existing user identified by the provided ID.

#### Response

- **HTTP Status Code**: 204 No Content

### Delete a User

```
DELETE /users/{id}
```

Delete a user identified by the provided ID.

#### Parameters

- `id` (string): ID of the user to delete.

#### Response

- **HTTP Status Code**: 204 No Content

### Retrieve User Posts by ID

```
GET /users/{id}/posts
```

Retrieve all posts by a specific user.

#### Parameters

- `id` (string): ID of the user.

#### Response

- **HTTP Status Code**: 200 OK

```json
[
    {
        "id": "667836a197850b6ecbe6a6a7",
        "date": "2024-06-02T00:00:00.000+00:00",
        "title": "Sample Post Title",
        "body": "Sample post body text.",
        "author": {
            "id": "667217f95617941eef6735ed",
            "name": "João"
        },
        "comments": [
            {
                "text": "Sample comment.",
                "date": "2024-06-03T00:00:00.000+00:00",
                "author": {
                    "id": "667217f95617941eef6735ee",
                    "name": "Maria"
                }
            }
        ]
    }
]
```

## Posts

### Retrieve a Post by ID

```
GET /posts/{id}
```

Retrieve details of a specific post by its ID.

#### Parameters

- `id` (string): ID of the post to retrieve.

#### Response

- **HTTP Status Code**: 200 OK

```json
{
    "id": "667836a197850b6ecbe6a6a7",
    "date": "2024-06-02T00:00:00.000+00:00",
    "title": "Sample Post Title",
    "body": "Sample post body text.",
    "author": {
        "id": "667217f95617941eef6735ed",
        "name": "João"
    },
    "comments": [
        {
            "text": "Sample comment.",
            "date": "2024-06-03T00:00:00.000+00:00",
            "author": {
                "id": "667217f95617941eef6735ee",
                "name": "Maria"
            }
        }
    ]
}
```

### Search Posts by Title

Search for posts by their title.

#### Parameters

- `text` (string): Text to search in the post titles.

#### Response

- **HTTP Status Code**: 200 OK

```json
[
    {
        "id": "667836a197850b6ecbe6a6a7",
        "date": "2024-06-02T00:00:00.000+00:00",
        "title": "Sample Post Title",
        "body": "Sample post body text.",
        "author": {
            "id": "667217f95617941eef6735ed",
            "name": "João"
        },
        "comments": [
            {
                "text": "Sample comment.",
                "date": "2024-06-03T00:00:00.000+00:00",
                "author": {
                    "id": "667217f95617941eef6735ee",
                    "name": "Maria"
                }
            }
        ]
    }
]
```

### Full Search for Posts

```
GET /posts/{id}
```

Perform a full search for posts based on text, and optional date range.

#### Parameters

- `text` (string): Text to search in the post titles and bodies.
- `minDate` (string, optional): Minimum date for the search (format: yyyy-MM-dd).
- `maxDate` (string, optional): Maximum date for the search (format: yyyy-MM-dd).

#### Response

- **HTTP Status Code**: 200 OK

```json
[
    {
        "id": "667836a197850b6ecbe6a6a7",
        "date": "2024-06-02T00:00:00.000+00:00",
        "title": "Sample Post Title",
        "body": "Sample post body text.",
        "author": {
            "id": "667217f95617941eef6735ed",
            "name": "João"
        },
        "comments": [
            {
                "text": "Sample comment.",
                "date": "2024-06-03T00:00:00.000+00:00",
                "author": {
                    "id": "667217f95617941eef6735ee",
                    "name": "Maria"
                }
            }
        ]
    }
]
```
