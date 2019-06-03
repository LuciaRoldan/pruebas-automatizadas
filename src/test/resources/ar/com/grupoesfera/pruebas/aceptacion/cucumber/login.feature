# language: en
Feature: Login

Scenario: Si me quiero loggear con un nombre de usuario incorrecto, no puedo
		Given que ya existe el usuario prueba@prueba.com
		When me loggeo con el usuario prueba@prueba.com y la pass 123
		Then sale mensaje de error Usuario o clave incorrecta
			And estoy en login
		
	Scenario: Si me quiero loggear con una pass incorrecta, no puedo
		Given que ya existe el usuario prueba1@prueba.com
		When me loggeo con el usuario prueba@prueba.com y la pass 123
		Then sale mensaje de error Usuario o clave incorrecta
			And estoy en login
		
	Scenario: Si me quiero loggear con un usuario existente puedo
		Given que ya existe el usuario prueba4@prueba.com
		When me loggeo con el usuario prueba4@prueba.com y la pass 1234
		Then estoy en home