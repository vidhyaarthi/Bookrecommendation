# Bookrecommendation
This is a simple application using spring boot which provides recommendation of books to users. The user can give their feedback for each book.

STEPS:
1)The user has to fill in the registration form by giving his username and Password.
2)Once the registration is successful, the user will be redirected to the login page.
3)User can login by giving his username and password.
4)If the login is successful, he will be redirected to a page where he will get a list of book recommendations.
5)The user can give feedback to every book by selecting either Liked,Disliked or Not interested.
6)The user can log out from the application at any time.

Prerequisites
    Eclipse with maven 
    H2 db
    Junit
    Postman

REST API SCHEMES:

        - http
        paths:
        /user:
        post:
        tags:
        - user
        summary: Adds a new user.
        description: ''
        operationId: addUser
        consumes:
        - application/x-www-form-urlencoded
        parameters:
        - in: body
        name: body
        description: User that should be added
        required: true
        schema:
        $ref: '#/definitions/User'
        responses:
        '201':
        headers:
        location:
        description: location (uri) of the created new user
        type: string
        format: uri
        description: Created new user.
        '400':
        description: Invalid input

        '/user/{userId}/book':
        get:
        tags:
        - user
        summary: Get the list of books for this user.
        description: ''
        operationId: listBooks
        produces:
        - application/json
        parameters:
        - name: userId
        in: path
        description: ID of user
        required: true
        type: integer
        format: int64
        responses:
        '200':
        description: Found books for this user. Returned are book title,bookid and feedback form.
        schema:
        type: array
        items:
        type: string

        /userfeedback:
        post:
        tags:
        - userfeedback
        summary: Place a user feedback
        description: ''
        operationId: addStatus
        consumes:
        - application/json
        produces:
        - application/json
        parameters:
        - in: body
        name: body
        description: response of the user
        required: true
        schema:
        $ref: '#/definitions/userfeedback'
        responses:
        '201':
        headers:
        location:
        description: location (uri) of the created feedback
        type: string
        format: uri
        description: Created new feedback successfully.




