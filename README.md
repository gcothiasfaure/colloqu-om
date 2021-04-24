# Bienvenue sur Colloqu'OM <img src="src/main/resources/public/img/favicon.png" width="30">

Ce dépôt est le rendu du **projet Spring + Hibernate** du cours de J2E en TSI.

## Installation

#### Prérequis pour l'installation :

- Etre connecté à internet

- Avoir un IDE Java installé

- Avoir un JDK installé

- Avoir PostgreSQL installé

#### Installation :

1. Télécharger ([lien de téléchargement](https://gitlab.com/gascothiasfaure/j2e-project/-/archive/master/j2e-project-master.zip))  ou clonez (`https://gitlab.com/gascothiasfaure/j2e-project.git`) ce dépôt sur votre ordinateur

2. Dans votre IDE, importez le code source cloné en tant que nouveau projet Maven. Choisissez la racine de ce dépôt comme dossier racine du projet (où se trouve le `pom.xml`)

3. Dans le fichier `/src/main/resources/application.properties`, renseignez les champs suivants :

- **spring.datasource.url** (l.7) : hôte, port et nom de votre base de donnée PostgreSQL (reproduire le format deja présent)
- **spring.datasource.username** (l.10) : nom d'utilisateur de votre base de données PostgreSQL
- **spring.datasource.password** (l.13) : mot de passe de votre base de données PostgreSQL

>**NOTE :**
>
>Vous pouvez également modifier le port utilisé par Spring Boot avec le champ **server.port** (l.16)

4. Lancez la commande suivante :

```
 mvn clean package
```

>**NOTE :**
>
> Démarche à suivre dans la plupart des IDE : 
> - Clic droit sur le nom du projet (*j2e-project*) dans l'arborescence des packages
> - *Run As ...* 
> - *Maven build ...* 
> - Renseignez le champ *Goals* avec "*clean package*" puis *Run*

## Lancement de l'application

>**NOTE :**
>
> Vous devez être connecté à internet

Lancez le fichier `/src/main/java/j2e.gasmel/Application.java` en tant qu'Application.

>**NOTE :**
>
> Démarche à suivre dans la plupart des IDE :
> - Clic droit sur lefichier */src/main/java/j2e.gasmel/Application.java* dans l'arborescence des packages
> - *Run As ...* 
> - *Java Application* 

Rendez-vous sur le port 8080 de votre hôte local (http://localhost:8080/) grâce a votre navigateur.

Vous pouvez alors naviguer sur **Colloqu'OM**.

## Modules implémentés

- Consignes par défaut

- Front-end HTML/CSS avec Bootstrap

## Auteurs

- [Gaspard Cothias Faure](https://gitlab.com/gascothiasfaure)

- [Melvin Pichenot](https://gitlab.com/MeLu)

## Outils utilisées :

- [Maven](https://maven.apache.org/)

- [PostgreSQL](https://www.postgresql.org/)

- [Spring Boot](https://spring.io/projects/spring-boot)

- [Hibernate](https://hibernate.org/)

- [Bootstrap](https://getbootstrap.com/)
