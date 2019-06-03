# language: en
Feature: Registrarme y darme de alta en el sitio

	Scenario: Si me quiero registrar con un usuario existente, no puedo
		Given que ya existe el usuario prueba@oprueba.com
		When me registro con el usuario prueba@oprueba.com y la pass 1234
		Then sale mensaje de error El usuario ya existe
			And estoy en registrarme
		
	Scenario: Si me quiero registrar con un usuario inexistente puedo
		Given que no existe el usuario prueba2@oprueba.com
		When me registro con el usuario prueba2@oprueba.com y la pass 1234
		Then estoy en login
		
	Scenario Outline: Si me quiero registrar con un usuario invalido, no puedo
		Given que no existe el usuario pruebaoprueba.com
		When me registro con el usuario <usuario> y la pass 1234
		Then sale mensaje de error El formato del usuario no es una direccion de email válida
			And estoy en registrarme

	Examples:
		| 		usuario					|
		|		"pruebaoprueba.com"		|
		| 		"sasa.sasa"				|