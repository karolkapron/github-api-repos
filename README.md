GitHub Repository List API

This is a simple Spring Boot application that allows you to list a GitHub user's repositories that are not forks. The application communicates with the GitHub API to fetch the repository data and provides it in a user-friendly format.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Running the Application](#running-the-application)
- [Usage](#usage)
- [Response](#response)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) 17 or higher installed on your system.
- [Maven](https://maven.apache.org/download.cgi) (if you choose to use it) for building the project.
- GitHub API personal access token if you plan to make a lot of requests to GitHub's API.

## Getting Started

### Running the Application

1. Clone this repository to your local machine:

    ```shell
   git clone https://github.com/karolkapron/github-api-repos.git
2. Open pulled drirectory from git
    ```shell
    cd github-repo-list-api
3. Open the src/main/resources/application.properties file and configure the GitHub API access token.
    ```shell
   github.api.auth-token=YourGitHubToken
4. Build the project using Maven:
    ```shell
   mvn clean install
5. Run the Spring Boot application:
    ```shell
   mvn spring-boot:run
By default, the application will start on port 8080. You can access it at http://localhost:8080.
## Usage
1. To retrieve a list of GitHub repositories for a user, make an HTTP GET request to the following endpoint:
    ```shell
      GET http://localhost:8080/api/repos/{username}
2. Example Request
   ```shell
       curl -H "Accept: application/json" http://localhost:8080/api/repos/{userame}
3. Example Response
   ```shell
   [
      {
       "name": "repositoryName",
        "username": "ownerLogin",
        "branches": [
        {
          "name": "main",
          "commit": {
             "sha": "abcdef123456"
            }
        },
       {
           "name": "feature-branch",
           "commit": {
             "sha": "123456abcdef"
           }
       }
      ]
     },
   // More repositories...
   ]
## Response
1. As an api consumer, given not existing github user, You will receive 404 response like:
    ```shell
        {
            “status”: ${responseCode}
            “Message”: ${whyHasItHappened}
        }
2. As an api consumer, given header “Accept: application/xml”, I will receive 406 response like:
    ```shell
        {
            “status”: ${responseCode}
            “Message”: ${whyHasItHappened}
        }
## API Endpoints
1. GET /api/repos/{username}: List GitHub repositories for a user.

## Configuration
1. You can configure the application by modifying the src/main/resources/application.properties file.
   github.api.auth-token: GitHub API personal access token.

## License
```shell
   This project is licensed under the MIT License s. See the LICENSE file for details.
