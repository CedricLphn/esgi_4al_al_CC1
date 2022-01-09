# ESGI Architecture logicielle - CC2    

Par LEPROHON Cédric

Pour Monsieur Boissinot

- [Rappel](#rappel)
- [Projet](#projet)
- [Librairies](#librairies)
- [Modules](#modules)
    * [package fr.leprohon.esgi.al4.al.kernel](#package-frleprohonesgial4alkernel)
    * [fr.leprohon.esgi.al4.al.shopping](#frleprohonesgial4alshopping)
    * [fr.leprohon.esgi.al4.al.securepay](#frleprohonesgial4alsecurepay)
- [Call API](#call-api)
    * [Shopping](#shopping)
        + [Retrouver un contrat](#retrouver-un-contrat)
        + [Ajouter un contrat](#ajouter-un-contrat)
    * [SecurePay](#securepay)
        + [Créer une transaction](#cr-er-une-transaction)
- [Axe d'amélioration](#axe-d-am-lioration)
- [Diagramme de classe](#diagramme-de-classe)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with markdown-toc</a></i></small>


## Rappel

- Reprise du sujet fonctionnel et du scénario métier du CC1 (souscription d’un membre à l’application TradeMe)
- Cas de l’abonnement: Demande d’un paiement fixe chaque mois

Pour plus d'information, consulter le fichier <u>CC2.pdf</u>

# Projet

Le CC2 est une refonte en profondeur du CC1, respectant (à peu près) l'architecture DDD et le CQS

Le projet communique avec deux modules :

1. Shopping: Module principal qui permet de souscrire à deux types de contrats (CONTRACTOR, TRADESMAN)
2. Securepay: Module qui valide ou non la transaction

Vous trouverez en fin de page le diagramme de classe.

# Librairies

* JUnit
* SpringBoot

# Modules

Avant de continuer, j'ai fait un package java commun qui regroupe les classes communes utilisées par les modules.

## package fr.leprohon.esgi.al4.al.kernel

J'utilise les annotations pour les entités et les repository afin de mieux retrouver mes entités et mes repository mais
aussi dans un soucis de nommage de classe. En effet, en utilisant les annotations, j'évite de mettre *Entity*
ou *Repository* comme suffixe.

J'utilise aussi une exception lorsque je n'arrive pas à trouver un contrat.

Également, je génère à la volée des *InMemory database* car *fr.leprohon.esgi.al4.al.shopping* et *fr.leprohon.esgi.al4.al.securepay* utilise des bases de données. Cela
permettra plus tard de ne pas s'embêter à recréer des *InMemory database*

## fr.leprohon.esgi.al4.al.shopping

Pour créer un contrat, j'utilise le design pattern *Faceted builder* qui permet de séparer des informations en "
catégories"

Exemple:

```java
contractBuilder
        .User()
            .firstName("Cedric")
            .lastName("Leprohon")
            .age(27)
        .Payment()
            .cardNumber("4485678386265192")
            .CVV(1234)
            .expirationDate(ZonedDateTime.now())
        .Subscription()
            .type(ContractType.TRADESMAN)
            .amount(19)
            .status(Status.NEW)
        .build();
```

Une fois le contrat crée, l'utilisateur est redirigé vers le processus de paiement.

J'utilise ```ContratService``` qui est dépendant de ```ContratRepository``` qui est juste une façade destinée pour le
métier. J'ai préféré utiliser un repository plutôt qu'un DAO car cela correspond bien à l'architecture DDD et cela
sépare la technicité informatique à celle du métier.

J'utilise aussi des *handler* pour le traitement d'un contrat lorsque celle-ci à été traité par *fr.leprohon.esgi.al4.al.securepay*. Pourquoi ce
choix ? Tout simplement pour rendre malléable le code, ainsi, si le métier change de workflow, il pourra le faire sans
aller très loin dans la technicité. (voir SubscriptionHandler.java, UpdateObjectStatusContract.java)

## fr.leprohon.esgi.al4.al.securepay

Module qui autorise la transaction ou non du contrat. Il historise aussi la transaction via au repository
HistoryTransaction Un module de test à été créer pour le développement ```DummyPaymentTranasction``` qui accepte toutes
les transactions. Évidemment, elle est facilement remplaçable car elle hérite de ```PaymentTransaction``` et elle est
appelé sous la forme d'fr.leprohon.esgi.al4.al.event (via à l'injection de dépendance).

# Call API

La nouveauté est l'intégration de quelques calls api

## Shopping
### Retrouver un contrat
Type: ```GET```

URL : ```api/v1/contract/1```

Résultat:
```json
{
  "id": "7c9f7c8f-035c-4c0e-97cf-90a607b39dbb",
  "type": "TRADESMAN",
  "user": {
    "firstname": "Leprohon",
    "lastname": "Cedric",
    "age": 27,
    "creditCard": {
      "number": "4485678386265192",
      "expiration": "2022-01-09T23:05:08.2778522+01:00",
      "CVV": 123
    }
  },
  "amount": 19,
  "expiration": "2022-02-09T22:05:20.417+00:00",
  "paymentStatus": "ACCEPTED"
}
```


**A noter que la vérification du payement via securepay s'effectue avec un appel REST HTTP (pour plus de réalisme)**

### Ajouter un contrat
Type: ```POST```

URL : ```api/v1/contract/create```

Body Request :
```json
{
  "type": "TRADESMAN",
  "user": {
    "firstname": "Gustin",
    "lastname": "Florianne",
    "age": 48
  },
  "creditcard": {
    "number": "4485678386265192",
    "expiration": "2022-01-06T21:16:00.2228243+01:00",
    "cvv": 1234
  },
  "amount": 19,
  "subscription": false // facultatif (permet d'avoir une souscription définitif)
}
```

Réponse:
```201 CREATED``` ou ```400 BAD REQUEST```

## SecurePay

### Créer une transaction
Type : ```POST```

URL : ```api/v1/securepay/payment/payload```

Body:
```json
{
  "amount":19,
  "creditCard": {
    "number": "4485678386265192",
    "expiration": "2022-01-09T23:16:07.254959200+01:00[Europe/Paris]", 			
    "cvv": 123
  }
}
```


# Axe d'amélioration

Conscient que ce projet est loin d'être parfait, nous pouvons parfaitement améliorer certains points:
- Problème lors de l'ajout d'un contrats: le contrat s'édite en deux fois.
- Ajout de tests unitaires
- Mise en place de l'architecture SEDA notamment pour securepay pour l'historisation des events.
- Refactorisation notamment des entités, trop de getters et de setters liés à la dette technique du CC1
- Un autre format de date pour la carte bleue
# Diagramme de classe

![](java.png)
