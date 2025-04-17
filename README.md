# Deployment Using Docker Networking

### Application Look:
- Registration Form:

![image](https://github.com/user-attachments/assets/58e841f0-497e-424c-a1bb-444febddd8c8)

- Database list:

![image](https://github.com/user-attachments/assets/bdb9dded-5083-4cdd-9af8-4a1c27019fcc)


### STEPS TO IMPLEMENT THE PROJECT
- **<p id="Docker">Deployment using Docker</p>**
  - Clone the repository
  ```bash
  git clone https://github.com/Nehabisen21/studentapp.ui.git
  ```
  #
  - Install docker, docker compose and provide neccessary permission
  ```bash
  sudo apt update -y

  sudo apt install docker.io docker-compose-v2 -y

  sudo usermod -aG docker $USER && newgrp docker
  ``` 
  #
  - Move to the cloned repository
  ```bash
  cd studentapp.ui
  ```
  #
  - Build the Dockerfile
  ```bash
  docker build -t studentappUI .
  ```
  #
  - Create a docker network
  ```bash
  docker network create studentapp
  ```
  #
  - Run MYSQL container
  ```bash
  docker run -itd --name mysql --network=studentapp -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=studentapp -v "$(pwd)/student.sql":/docker-entrypoint-initdb.d/init.sql  mysql
  ```
  #
  - Run Application container
  ```bash
  docker run -itd --name studentapp --network=studentapp -p 8080:8080 studentappUI
  ```
  #
  - Verify deployment
  ```bash
  docker ps
  ```
  # 
  - Open port 8080 of your AWS instance and access your application
  ```bash
  http://<public-ip>:8080/app
  ```
  ### Congratulations, you have deployed the application using Docker 
