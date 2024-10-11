# Project Name

This project is a full-stack application with a **Java Spring Boot** backend and a **React.js** frontend. Follow the instructions below to set up and run both the backend and frontend locally.

## Prerequisites

Make sure you have the following tools installed on your system:

- **Java Development Kit (JDK)** (version 11 or later)
- **Maven** (for building the Java backend)
- **Node.js** (version 14.x or later) and **npm** (for managing frontend dependencies)
- **Docker** (for running the database with `docker-compose`)

## Getting Started

### Clone the repository

```bash
git clone https://github.com/your-username/your-project.git
cd your-project
```

### Database Setup

You have two options for setting up the database:

#### 1. Use Docker Compose (Recommended)

A `docker-compose.yml` file is provided to set up a PostgreSQL (or any other defined) database.

##### Steps:

1. Make sure Docker is installed and running on your machine.
2. Run the following command in the project root to start the database:

   ```bash
   docker-compose up -d
   ```

   This will start the database service in the background.

#### 2. Create Your Own Database

If you prefer to set up your own database manually (e.g., locally or via a cloud provider), follow these steps:

1. Create a database (PostgreSQL, MySQL, etc.) using your preferred method.
2. Update the `application.properties` file (located in `backend/src/main/resources/`) with the relevant database connection details:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

Make sure the database is running before you start the backend.

### Backend (Spring Boot)

#### 1. Navigate to the backend directory

```bash
cd backend
```

#### 2. Build the backend project

Use Maven to build the project and install dependencies:

```bash
mvn clean install
```

#### 3. Run the backend server

After building the project, you can run the backend server using the following command:

```bash
mvn spring-boot:run
```

By default, the backend should run on `http://localhost:8080`.

### Frontend (React.js)

#### 1. Navigate to the frontend directory

```bash
cd ../frontend
```

#### 2. Install dependencies

Run the following command to install the necessary frontend dependencies using `npm`:

```bash
npm install
```

#### 3. Run the development server

After the dependencies are installed, run the frontend development server using the following command:

```bash
npm run dev
```

The frontend should now be running on `http://localhost:3000`.

### Running Both Backend and Frontend

- **Backend:** `http://localhost:8080`
- **Frontend:** `http://localhost:3000`

The frontend will communicate with the backend through the API.

### Environment Variables and Configuration

If you're using the provided `docker-compose` setup, the database connection should work out-of-the-box. Otherwise, make sure to update the `application.properties` file with your database credentials as described in the [Database Setup](#database-setup) section.

## Additional Commands

### Backend

- **Run Tests:** Run unit tests for the backend using Maven:

  ```bash
  mvn test
  ```

- **Package Backend:** Package the backend into a JAR file:

  ```bash
  mvn package
  ```

### Frontend

- **Build Frontend:** Create a production build of the frontend:

  ```bash
  npm run build
  ```

- **Linting and Formatting:** Check for linting errors in the frontend code:

  ```bash
  npm run lint
  ```

## Contributing

Feel free to submit pull requests or open issues if you find any bugs or improvements.
