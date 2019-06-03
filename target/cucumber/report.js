$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ar/com/grupoesfera/pruebas/aceptacion/cucumber/login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Si me quiero loggear con un nombre de usuario incorrecto, no puedo",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "que ya existe el usuario prueba@prueba.com",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrarmeCucumber.yaExisteElUsuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me loggeo con el usuario prueba@prueba.com y la pass 123",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrarmeCucumber.meRLoggeoConElUsuarioYPass(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sale mensaje de error Usuario o clave incorrecta",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrarmeCucumber.sale_mensaje_de_error(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "estoy en login",
  "keyword": "And "
});
formatter.match({
  "location": "RegistrarmeCucumber.estoyEn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Si me quiero loggear con una pass incorrecta, no puedo",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "que ya existe el usuario prueba1@prueba.com",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrarmeCucumber.yaExisteElUsuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me loggeo con el usuario prueba@prueba.com y la pass 123",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrarmeCucumber.meRLoggeoConElUsuarioYPass(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sale mensaje de error Usuario o clave incorrecta",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrarmeCucumber.sale_mensaje_de_error(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "estoy en login",
  "keyword": "And "
});
formatter.match({
  "location": "RegistrarmeCucumber.estoyEn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Si me quiero loggear con un usuario existente puedo",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "que ya existe el usuario prueba4@prueba.com",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrarmeCucumber.yaExisteElUsuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me loggeo con el usuario prueba4@prueba.com y la pass 1234",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrarmeCucumber.meRLoggeoConElUsuarioYPass(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "estoy en home",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrarmeCucumber.estoyEn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("ar/com/grupoesfera/pruebas/aceptacion/cucumber/registrarme.feature");
formatter.feature({
  "name": "Registrarme y darme de alta en el sitio",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Si me quiero registrar con un usuario existente, no puedo",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "que ya existe el usuario prueba@oprueba.com",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrarmeCucumber.yaExisteElUsuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me registro con el usuario prueba@oprueba.com y la pass 1234",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrarmeCucumber.meRegistroConElUsuarioYPass(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sale mensaje de error El usuario ya existe",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrarmeCucumber.sale_mensaje_de_error(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "estoy en registrarme",
  "keyword": "And "
});
formatter.match({
  "location": "RegistrarmeCucumber.estoyEn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Si me quiero registrar con un usuario inexistente puedo",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "que no existe el usuario prueba2@oprueba.com",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrarmeCucumber.noExisteElUsuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me registro con el usuario prueba2@oprueba.com y la pass 1234",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrarmeCucumber.meRegistroConElUsuarioYPass(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "estoy en login",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrarmeCucumber.estoyEn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Si me quiero registrar con un usuario invalido, no puedo",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "que no existe el usuario pruebaoprueba.com",
  "keyword": "Given "
});
formatter.step({
  "name": "me registro con el usuario \u003cusuario\u003e y la pass 1234",
  "keyword": "When "
});
formatter.step({
  "name": "sale mensaje de error El formato del usuario no es una direccion de email válida",
  "keyword": "Then "
});
formatter.step({
  "name": "estoy en registrarme",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "usuario"
      ]
    },
    {
      "cells": [
        "\"pruebaoprueba.com\""
      ]
    },
    {
      "cells": [
        "\"sasa.sasa\""
      ]
    }
  ]
});
formatter.scenario({
  "name": "Si me quiero registrar con un usuario invalido, no puedo",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "que no existe el usuario pruebaoprueba.com",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrarmeCucumber.noExisteElUsuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me registro con el usuario \"pruebaoprueba.com\" y la pass 1234",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrarmeCucumber.meRegistroConElUsuarioYPass(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sale mensaje de error El formato del usuario no es una direccion de email válida",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrarmeCucumber.sale_mensaje_de_error(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "estoy en registrarme",
  "keyword": "And "
});
formatter.match({
  "location": "RegistrarmeCucumber.estoyEn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Si me quiero registrar con un usuario invalido, no puedo",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "que no existe el usuario pruebaoprueba.com",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrarmeCucumber.noExisteElUsuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me registro con el usuario \"sasa.sasa\" y la pass 1234",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrarmeCucumber.meRegistroConElUsuarioYPass(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sale mensaje de error El formato del usuario no es una direccion de email válida",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrarmeCucumber.sale_mensaje_de_error(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "estoy en registrarme",
  "keyword": "And "
});
formatter.match({
  "location": "RegistrarmeCucumber.estoyEn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});