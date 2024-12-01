# GraphQL_Apollo_Spring_App

# TP Android avec GraphQL et Spring Backend

## Introduction
Ce projet consiste à créer une application Android qui utilise **GraphQL** pour effectuer des opérations CRUD sur un compte (avec des attributs tels que **solde**, **date de création**, et **type de compte**, qui peut être soit "épargne" soit "courant"). Le backend sera développé avec **Spring Boot**, tandis que le client Android utilisera **Apollo** pour interagir avec l'API GraphQL.


## demo GraphQL
[Vedio demo ](https://github.com/user-attachments/assets/0e367884-3458-4272-8251-ca65e38e2157
)
## demo APP android
[Vedio demo ](https://github.com/user-attachments/assets/c67c6937-27be-437b-83fc-0cce85b25170
)


## Structure du Projet
Le projet se compose de deux parties principales :

### Backend - Spring Boot avec GraphQL
Cette partie du projet met en place un serveur **GraphQL** à l'aide de **Spring Boot**. Voici les étapes clés :

#### a. Configuration du projet
Utiliser **Spring Initializr** pour créer un projet avec les dépendances nécessaires :
- **Spring Web**
- **Spring Data JPA**
- **GraphQL**

#### b. Modèle de données
Créer une entité `Compte` avec les attributs suivants :
- `solde`: `Double`
- `dateCreation`: `Date`
- `type`: `Enum` (Epargne, Courant)
### Android - Apolo avec GraphQL
### MVVM - Model View ViewModel

