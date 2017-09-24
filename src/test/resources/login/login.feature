#Author: lilianny@gmail.com

Feature: Login en linkedin

Background: 
	Given El usuario esta en la pagina principal de linkedin

Scenario Outline: Login fallido
When El usuario ingresa el email <email>
And El usuario ingresa el password <password>
Then El login resulta <status>

Examples:
    |         email             |  password | status |
    |liliannyrodrigues@gmail.com|   123456  |  Fallo |
    |liliannyrodriguez@gmail.com|asasasasas |  Fallo |
    |liliannysarahy@gmail.com   |  lanybe12 |  Fallo |
    
Scenario Outline: Ingreso con campo(s) vacio(s)
When El usuario no ingresa el email <email>
And El usuario no ingresa el password <password>
Then El boton no realiza accion

Examples:
    |         email             |  password |
    |            -              |      -    |
    |liliannyrodriguez@gmail.com|      -    |
    |            -              |  123456   |
    
Scenario Outline: Ingreso con datos mal formateados
When El usuario ingresa email en un formato incorrecto <email>
And El usuario ingresa password en un formato incorrecto <password>
Then Redirecciona a relogin

Examples:
    |           email           |  password |
    |            lala           |   123456  |
    |liliannyrodriguez@gmail.com|      42   |
    |            lala           |      42   |

Scenario: Login exitoso
When Ingresa los datos en los campos correspondientes
| email    |micuentareal@gmail.com |
| password |mipasswordreal         |
Then El usuario puede ingresar a su cuenta
