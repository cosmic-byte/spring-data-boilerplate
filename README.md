# Spring-Data-BoilerPlate
A boiler plate for combining multiple spring data repositories.

In this project, Spring data JPA is combined with Spring data Elasticsearch

#### SETUP ######

###### JPA database configuration

    POSTGRES DB setup

    Run the following commands on psql.

    1. CREATE DATABASE 'database_name' OWNER postgres;
    2. CREATE ROLE 'role_name';
    3. ALTER ROLE 'role_name' WITH LOGIN;
    4. \password 'role_name'
    5. password is "enter new password"
    6. GRANT ALL PRIVILEGES ON DATABASE 'database_name' to 'role_name';

###### Elastic server installation and configuration.

    for linux(ubuntu) run the following commands on the terminal

    1. wget https://download.elastic.co/elasticsearch/release/org/elasticsearch/distribution/deb/elasticsearch/2.3.1/elasticsearch-2.3.1.deb
    2. sudo dpkg -i elasticsearch-2.3.1.deb
    3. sudo systemctl enable elasticsearch.service

    locate the elasticsearch.yml file and add a cluster.name and node.name

    4. sudo nano /etc/elasticsearch/elasticsearch.yml

    start the server using the following command

    5. sudo systemctl start elasticsearch

###### for more information for installing and configuring elastic server checkout the following link
   [How to install and configure elasticSearch on Ubuntu](https://www.digitalocean.com/community/tutorials/how-to-install-and-configure-elasticsearch-on-ubuntu-16-04)


###### Edit application.properties file
    edit the following lines with your personal details

    spring.datasource.url=jdbc:postgresql://Localhost:5432/Your_database_name
    spring.datasource.username=Your_database_username
    spring.datasource.password=Your_database_password

###### Edit ElasticSearchConfig.java file
    edit the following lines with your personal details

    .....
    .put("cluster.name", "your_cluster_name")
    .....