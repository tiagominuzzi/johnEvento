# john-evento-h1
Trabalho da disciplina de Introdução ao Desenvolvimento Ágil - Uniritter - 2018

[![Build Status](https://travis-ci.org/mfgonzalez/johnEvento.svg?branch=master)](https://travis-ci.org/mfgonzalez/johnEvento)
[![codecov](https://codecov.io/gh/mfgonzalez/johnEvento/branch/master/graph/badge.svg)](https://codecov.io/gh/mfgonzalez/johnEvento)

# US#1 - Criar evento

Historia:
Como gestor de eventos
Quero ter a possibilidade de criar eventos
Para que meus clientes tenham conhecimento de eventos e suas datas

Critérios

#1
Dado que quero criar um evento
Quando  carregar o formulário
Então deve apresentar os seguintes campos:
*Nome
*Data do evento


#2
Dado que quero criar um evento
Quando salvar o evento
Então os campos abaixo devem ser obrigatórios:
*Nome
*Data do evento

#3
Dado que quero criar um evento
Quando informar um nome maior que 150 caracteres e salvar
Então não deve permitir salvar e informar a mensagem:
"O nome permite no máximo 150 caracteres"

#4
Dado que quero criar um evento
Quando informar uma data inferior ao do dia atual e salvar
Então não deve permitir salvar e informar a mensagem:
"A data do evento deve ser igual ou maior que a de hoje"



# US#2 Ofertar Ingressos

Como gestor de eventos
Quero ter inúmeros tipos de ingresso
Para que eu possa atingir vários níveis de público

Critérios

Dado que quero disponibilizar um ingresso VIP
Quando informar o valor
Então o mesmo deve ser 1000

Dado que quero disponibilizar um ingresso BACKSTAGE
Quando informar o valor
Então o mesmo deve ser 800

Dado que quero disponibilizar um ingresso PLATEIA VIP
Quando informar o valor
Então o mesmo deve ser 500

Dado que quero disponibilizar um ingresso PLATEIA
Quando informar o valor
Então o mesmo deve ser 300



